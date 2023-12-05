package com.example.andresdelgado1evexamen;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    List<Objeto> objetos;
    public RecyclerViewAdapter(List<Objeto> userModelList){this.objetos =userModelList;}
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recyclerview, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bind(objetos.get(position));
    }

    @Override
    public int getItemCount() {
        return objetos.size();
    }
    static  class ViewHolder extends RecyclerView.ViewHolder{
        private final TextView nombre, localidad;
        public ViewHolder(View v){
            super(v);
            nombre = (TextView) v.findViewById(R.id.itemNumero);
            localidad = (TextView) v.findViewById(R.id.itemTiempo);
        }
        void bind(Objeto objeto){
            nombre.setText(objeto.getNumero());
            localidad.setText(objeto.getTiempo());
        }
    }
}
