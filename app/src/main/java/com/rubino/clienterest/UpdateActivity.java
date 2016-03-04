package com.rubino.clienterest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.ScrollView;
import android.widget.TextView;

import com.rubino.clienterest.interfaces.Cliente;
import com.rubino.clienterest.pojo.Actividad;

import retrofit.Call;
import retrofit.Callback;
import retrofit.GsonConverterFactory;
import retrofit.Response;
import retrofit.Retrofit;

public class UpdateActivity extends AppCompatActivity {

    private android.widget.TextView textView4;
    private EditText prof;
    private android.widget.TextView textView8;
    private EditText hi;
    private android.widget.TextView textView10;
    private EditText hf;
    private android.widget.TextView textView11;
    private EditText li;
    private android.widget.TextView textView12;
    private EditText lf;
    private android.widget.TextView textView13;
    private EditText f;
    private android.widget.TextView textView14;
    private android.widget.TextView textView15;
    private EditText editText7;
    private RadioButton radioButton;
    private RadioButton radioButton2;
    private android.widget.RadioGroup radioGroup;
    private android.widget.ScrollView scrollView;
    private android.widget.Button button;
    private android.widget.Button button2;
    private android.widget.LinearLayout linearLayout;
    private String tipo;
    private Retrofit r;
    private Actividad a;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        this.linearLayout = (LinearLayout) findViewById(R.id.linearLayout);
        this.button2 = (Button) findViewById(R.id.button2);
        this.button = (Button) findViewById(R.id.button);
        this.scrollView = (ScrollView) findViewById(R.id.scrollView);
        this.radioGroup = (RadioGroup) findViewById(R.id.radioGroup);
        this.radioButton2 = (RadioButton) findViewById(R.id.radioButton2);
        this.radioButton = (RadioButton) findViewById(R.id.radioButton);
        this.editText7 = (EditText) findViewById(R.id.editText7);
        this.textView15 = (TextView) findViewById(R.id.textView15);
        this.textView14 = (TextView) findViewById(R.id.textView14);
        this.textView13 = (TextView) findViewById(R.id.textView13);
        this.lf = (EditText) findViewById(R.id.lf);
        this.textView12 = (TextView) findViewById(R.id.textView12);
        this.li = (EditText) findViewById(R.id.li);
        this.textView11 = (TextView) findViewById(R.id.textView11);
        this.hf = (EditText) findViewById(R.id.hf);
        this.textView10 = (TextView) findViewById(R.id.textView10);
        this.hi = (EditText) findViewById(R.id.hi);
        this.textView8 = (TextView) findViewById(R.id.textView8);
        this.prof = (EditText) findViewById(R.id.prof);
        this.textView4 = (TextView) findViewById(R.id.textView4);

        r = new Retrofit.Builder().baseUrl("http://ieszv.x10.bz/").addConverterFactory(GsonConverterFactory.create()).build();
        a= (Actividad) getIntent().getSerializableExtra("cosa");
    }

    public void accept(View v){
        if(radioButton.isChecked()){
            tipo="complementaria";
        }else if(radioButton2.isChecked()){
            tipo="extraescolar";
        }

        a.setIdprofesor(prof.getText().toString());
        a.setTipo(tipo);
        a.setFechai(hi.getText().toString());
        a.setFechaf(hf.getText().toString());
        a.setLugari(li.getText().toString());
        a.setLugarf(lf.getText().toString());
        a.setDescripcion(editText7.getText().toString());


        Cliente api = r.create(Cliente.class);
        Call<Actividad> call = api.updateActividad2(a);

        call.enqueue(new Callback<Actividad>() {
            @Override
            public void onResponse(Response<Actividad> response, Retrofit retrofit) {
                setResult(RESULT_OK);
                finish();

            }

            @Override
            public void onFailure(Throwable t) {
                t.getLocalizedMessage();
                finish();
            }
        });


    }
}
