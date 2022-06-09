package com.example.recuperaciom8.Fragments;

import static com.example.recuperaciom8.Api.DefaultConstants.*;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.recuperaciom8.Api.Interfice.ApiCall;
import com.example.recuperaciom8.Api.Model.ModelApi;
import com.example.recuperaciom8.R;
import com.example.recuperaciom8.SQLite.Model.Ubicacio;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MapsFragment extends Fragment {

    private static final int LOCATION_PERMISSION_REQUEST_CODE = 1;
    private boolean permissionDenied = false;
    private GoogleMap map;
    Editable citySearch;
    EditText searchText;
    RecyclerView recyclerView;
    TextView textView;
    public String api = "835babac7f4d7e37f8f51a1abac4fe63";

    private OnMapReadyCallback callback = new OnMapReadyCallback() {

        /**
         * Manipulates the map once available.
         * This callback is triggered when the map is ready to be used.
         * This is where we can add markers or lines, add listeners or move the camera.
         * In this case, we just add a marker near Sydney, Australia.
         * If Google Play services is not installed on the device, the user will be prompted to
         * install it inside the SupportMapFragment. This method will only be triggered once the
         * user has installed Google Play services and returned to the app.
         */
        @Override
        public void onMapReady(GoogleMap googleMap) {
            LatLng sydney = new LatLng(-34, 151);
            googleMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
            googleMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
        }
    };

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {


        View view = inflater.inflate(R.layout.fragment_maps, container, false);

        searchText  = view.findViewById(R.id.searchText);
        textView = view.findViewById(R.id.textResults);

        ImageButton searchButton = view.findViewById(R.id.searchButton);
        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String query = searchText.getText().toString();
                Log.i("asd", query);
                if (!query.equals("")) {

                    ApiCall apiCall = retrofit.create(ApiCall.class);
                    Call<ModelApi> call = apiCall.getData(query, API_KEY);

                    call.enqueue(new Callback<ModelApi>() {
                        @Override
                        public void onResponse(Call<ModelApi> call, Response<ModelApi> response) {
                            if (response.code() != 200) {
                                Log.i("testApi", "checkConnection");
                                return;
                            } else {
                                Log.i("testApi", response.body().getName());
                                Log.i("testApi", response.body().getWeather().get(0).getMain());
                                Log.i("testApi", response.body().getWeather().get(0).getDescription());
                                textView.setText("Ciutat: " + response.body().getName()
                                            + "--- Temps: " + response.body().getWeather().get(0).getMain()
                                            + "--- Descripció: " + response.body().getWeather().get(0).getDescription());
                            }
                        }

                        @Override
                        public void onFailure(Call<ModelApi> call, Throwable t) {

                        }
                    });
                }
            }
        });
        return view;
    }

}