package com.example.recuperaciom8.Fragments;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.recuperaciom8.R;
import com.example.recuperaciom8.SQLite.DB.ContactsDBHelper;
import com.example.recuperaciom8.SQLite.Model.Ubicacio;
import com.example.recuperaciom8.SQLite.RecyclerUbicacions;

import java.util.ArrayList;


public class FragmentListSQLite extends Fragment {

    private ContactsDBHelper dbHelper;
    private SQLiteDatabase db;

    public FragmentListSQLite() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View listView = inflater.inflate(R.layout.fragment_list_s_q_lite, container, false);

        dbHelper = new ContactsDBHelper(getContext());
        db = dbHelper.getWritableDatabase();

        ArrayList<Ubicacio> array_noms = dbHelper.getAllData(db);
        array_noms.add(new Ubicacio("Barcelona", "Sol i Nuvols", "28ºC"));
        array_noms.add(new Ubicacio("Londres", "Pluja", "17ºC"));
        array_noms.add(new Ubicacio("Sydney","Sol","38ºC"));
        array_noms.add(new Ubicacio("Paris", "Nuvol", "19ºC"));

        RecyclerView recyclerView = listView.findViewById(R.id.recyclerViewList);
        RecyclerUbicacions adapter = new RecyclerUbicacions(array_noms);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        return listView;
    }
}