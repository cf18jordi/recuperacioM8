package com.example.recuperaciom8.Fragments;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;

import android.app.Activity;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.os.Bundle;
import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.recuperaciom8.Api.ApiThread;
import com.example.recuperaciom8.Api.Interfice.ApiCall;
import com.example.recuperaciom8.Api.Model.ModelApi;
import com.example.recuperaciom8.R;
import com.example.recuperaciom8.SQLite.Model.Ubicacio;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.List;
import java.util.Locale;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class FragmentMaps extends Fragment implements GoogleMap.OnMyLocationButtonClickListener,
        GoogleMap.OnMyLocationClickListener,
        OnMapReadyCallback, ActivityCompat.OnRequestPermissionsResultCallback {

    String msg1 = "Waiting to get adress";
    private static final int LOCATION_PERMISSION_REQUEST_CODE = 1;
    private boolean permissionDenied = false;
    private GoogleMap map;
    Editable citySearch;
    EditText searchText;

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
        public void onMapReady(final GoogleMap map) {
            //enableMyLocation();
            String home = "Barcelona";
           // map.addMarker(new MarkerOptions().getTitle(name));
            //map.moveCamera(CameraUpdateFactory.newLatLng(home));

            //map.setOnMyLocationButtonClickListener();
            //map.setOnMyLocationClickListener(this);


        }

    };

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_maps, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        SupportMapFragment mapFragment =
                (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.map);
        if (mapFragment != null) {
            mapFragment.getMapAsync(callback);
        }
    }



    @Override
    public void onMapReady(@NonNull GoogleMap googleMap) {

    }

    private Activity itemView;


    public Editable onSearchButtonClick() {
                citySearch = searchText.getText();
                return citySearch;
    }



}
