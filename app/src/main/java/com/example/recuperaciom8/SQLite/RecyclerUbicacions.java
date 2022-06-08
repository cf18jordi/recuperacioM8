package com.example.recuperaciom8.SQLite;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recuperaciom8.R;
import com.example.recuperaciom8.SQLite.Model.Ubicacio;

import java.util.ArrayList;

public class RecyclerUbicacions extends RecyclerView.Adapter<RecyclerUbicacions.ViewHolder> {
    private ArrayList<Ubicacio> array_ubi;

    public RecyclerUbicacions(ArrayList arrU){
        array_ubi = arrU;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }



    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.ciutat.setText(array_ubi.get(position).getCiutat());
        holder.temps.setText(array_ubi.get(position).getTemps());
        holder.temperatura.setText(array_ubi.get(position).getTemperatura());
    }

    @Override
    public int getItemCount() {
        return array_ubi.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView ciutat;
        TextView temps;
        TextView temperatura;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ciutat = itemView.findViewById(R.id.ciutatField);
            temps = itemView.findViewById(R.id.tempsField);
            temperatura = itemView.findViewById(R.id.temperaturaField);
        }
    }
}
