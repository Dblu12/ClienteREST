package com.rubino.clienterest;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.rubino.clienterest.pojo.Actividad;

import java.util.List;

/**
 * Created by David on 29/02/2016.
 */
public class Adaptador extends ArrayAdapter<Actividad> {


    private int res;
    private LayoutInflater lInflator;
    private List<Actividad> lista;
    private Context con;

    static class ViewHolder {

        public TextView li, lf, hi, hf, t, ip, d;


    }


    public Adaptador(Context context, int resource, List<Actividad> objects) {

        super(context, resource, objects);

        this.res = resource; // LAYOUT
        this.lista = objects; // LISTA DE VALORES
        this.con = context; // ACTIVIDAD

        lInflator = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder gv = new ViewHolder();
        if (convertView == null) {
            convertView = lInflator.inflate(res, null);


            TextView lf = (TextView) convertView.findViewById(R.id.lf);
            gv.lf = lf;
            TextView li = (TextView) convertView.findViewById(R.id.li);
            gv.li = li;
            TextView hi = (TextView) convertView.findViewById(R.id.hi);
            gv.hi=hi;
            TextView hf  = (TextView) convertView.findViewById(R.id.hf);
            gv.hf= hf;
            TextView t= (TextView) convertView.findViewById(R.id.t);
            gv.t= t;
            TextView ip= (TextView) convertView.findViewById(R.id.ip);
            gv.ip= ip;
            TextView d= (TextView) convertView.findViewById(R.id.d);
            gv.d= d;
            convertView.setTag(gv);
        } else {
            gv = (ViewHolder) convertView.getTag();
        }
        Actividad a= lista.get(position);
        gv.lf.setText(a.getLugarf());
        gv.li.setText(a.getLugari());
        gv.hi.setText(a.getFechai());
        gv.hf.setText(a.getFechaf());
        gv.d.setText(a.getDescripcion());
        gv.t.setText(a.getTipo());
        gv.ip.setText(a.getIdprofesor()+"");
        return convertView;
    }
}
