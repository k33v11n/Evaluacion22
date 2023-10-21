package com.example.evaluacion;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.evaluacion.R;
import com.example.evaluacion.mapa;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MainActivity extends AppCompatActivity implements OnMapReadyCallback, GoogleMap.OnMapClickListener, GoogleMap.OnMapLongClickListener {
    EditText txtLatitud, txtLongitud;
    GoogleMap mMap;
    Button btnGoToMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtLatitud = findViewById(R.id.direc1);
        txtLongitud = findViewById(R.id.direc2);
        txtLatitud = findViewById(R.id.direc3);
        txtLongitud = findViewById(R.id.direc3);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        btnGoToMap = findViewById(R.id.btnGoToMap);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        this.mMap.setOnMapClickListener(this);
        this.mMap.setOnMapLongClickListener(this);
        LatLng santiago = new LatLng(-33.4726789, -70.7946414);
        LatLng concepcion = new LatLng(-36.8260137, -73.1154467);
        LatLng chillan = new LatLng(-36.6124828, -72.1449114);

        mMap.addMarker(new MarkerOptions().position(santiago).title("Santiago"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(santiago));
        mMap.addMarker(new MarkerOptions().position(concepcion).title("Concepcion"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(concepcion));
        mMap.addMarker(new MarkerOptions().position(chillan).title("Chillan"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(chillan));
    }

    @Override
    public void onMapClick(LatLng latLng) {
        txtLatitud.setText("" + latLng.latitude);
        txtLongitud.setText("" + latLng.longitude);
    }

    @Override
    public void onMapLongClick(LatLng latLng) {
        txtLatitud.setText("" + latLng.latitude);
        txtLongitud.setText("" + latLng.longitude);
    }

    public void goToMapActivity(View view) {
        Intent intent = new Intent(this, mapa.class);
        startActivity(intent);
    }
}
