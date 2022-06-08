package com.example.recuperaciom8.Fragments;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.recuperaciom8.SQLite.DB.ContactsDBHelper;
import com.example.recuperaciom8.R;
import com.example.recuperaciom8.SQLite.Model.Ubicacio;


public class FragmentFormSQLite extends Fragment {


    //Creation of the dbHelper
    private ContactsDBHelper dbHelper;
    private SQLiteDatabase db;

    public FragmentFormSQLite() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_form_s_q_lite, container, false);
        TextView inputForm = root.findViewById(R.id.inputCiutat);
        TextView inputForm2 = root.findViewById(R.id.inputTemps);
        TextView inputForm3 = root.findViewById(R.id.inputTemperatura);

        dbHelper = new ContactsDBHelper(getContext());
        db = dbHelper.getWritableDatabase();

        Button buttonAdd = root.findViewById(R.id.button_send);
        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Ubicacio ubicacio = new Ubicacio(
                        inputForm.getText().toString(),
                        inputForm2.getText().toString(),
                        inputForm3.getText().toString()
                );
                dbHelper.insertContact(db, ubicacio);
                Toast.makeText(getActivity(), "City Weather added", Toast.LENGTH_LONG).show();
            }
        });

        // Inflate the layout for this fragment
        return root;
    }
    //Close the db when the activity onDestroy
    @Override
    public void onDestroy() {
        dbHelper.close();
        db.close();
        super.onDestroy();
    }
}