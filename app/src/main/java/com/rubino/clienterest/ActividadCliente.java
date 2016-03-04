package com.rubino.clienterest;

import android.content.Context;
import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.rubino.clienterest.clientes.ClienteRest;
import com.rubino.clienterest.interfaces.Cliente;
import com.rubino.clienterest.pojo.Actividad;
import com.rubino.clienterest.pojo.Grupo;


import java.util.ArrayList;
import java.util.List;

import retrofit.Call;
import retrofit.Callback;
import retrofit.GsonConverterFactory;
import retrofit.Response;
import retrofit.Retrofit;
import retrofit.http.GET;

public class ActividadCliente extends AppCompatActivity {

    private ListView lv;
    private FloatingActionButton fab;
    private ArrayList<Actividad> datos;
    private Adaptador a;
    private Retrofit retrofit;
    private int pos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cliente);


        datos = new ArrayList<>();

        init();

        retrofit = new Retrofit.Builder().baseUrl("http://ieszv.x10.bz/").addConverterFactory(GsonConverterFactory.create()).build();
        loadActividades();


    }

    private void loadActividades() {
        datos= new ArrayList<>();
        Cliente api = retrofit.create(Cliente.class);
        Call<List<Actividad>> call = api.getActividades();

        call.enqueue(new Callback<List<Actividad>>() {
            @Override
            public void onResponse(Response<List<Actividad>>

                                           response, Retrofit retrofit) {
                for (Actividad a : response.body()) {
                    Log.v("HOLA", a.toString());
                    datos.add(a);
                }

                a = new Adaptador(ActividadCliente.this, R.layout.item, datos);
                lv.setAdapter(a);

            }

            @Override
            public void onFailure(Throwable t) {
                t.getLocalizedMessage();
            }
        });
    }

    private void deleteActividad(){
        Cliente api= retrofit.create(Cliente.class);

        Call<Actividad> call= api.deleteActividad(datos.get(pos).getId() + "");
        call.enqueue(new Callback<Actividad>() {
            @Override
            public void onResponse(Response<Actividad> response, Retrofit retrofit) {
                loadActividades();
            }

            @Override
            public void onFailure(Throwable t) {

            }
        });
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {
        if (v.getId()==lv.getId()) {
            AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo)menuInfo;
            menu.setHeaderTitle("Accion");
            menu.add(Menu.NONE, 0, 0, "Borrar");
            menu.add(Menu.NONE,1,1,"Editar");
            }
        }

    public void init(){
        fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(ActividadCliente.this, AddActivity.class);
                startActivityForResult(i, 0);
            }
        });


        lv = (ListView) findViewById(R.id.listView);

        a = new Adaptador(this, R.layout.item, datos);


        lv.setAdapter(a);

        registerForContextMenu(lv);

        lv.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {

            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                pos= position;
                return false;
            }
        });


    }


    @Override
    public boolean onContextItemSelected(MenuItem item) {


        switch (item.getItemId()) {
            case 0:
                deleteActividad();
                break;
            case 1:
                editarActividad();
                break;
        }

        return super.onContextItemSelected(item);
    }
    


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==0 && resultCode==RESULT_OK){
            loadActividades();
        }
    }

    private void editarActividad(){
        Actividad ac = datos.get(pos);

        Intent i= new Intent(this, UpdateActivity.class);
        i.putExtra("cosa", ac);
        startActivityForResult(i,0);


    }
}
