package ma.ensa.bankapp;


import androidx.fragment.app.FragmentActivity;

import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import ma.ensa.bankapp.databinding.ActivityMapsBinding;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private ActivityMapsBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMapsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }


    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        // Add a marker
        LatLng bank1 = new LatLng(34.25989316862603, -6.583752394759134);
        mMap.addMarker(new MarkerOptions().position(bank1).title("CIH"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(bank1));
        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(bank1, 10));

        LatLng bank2 = new LatLng(34.25567683785565, -6.595178613617687);
        mMap.addMarker(new MarkerOptions().position(bank2).title("CIH"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(bank2));

        LatLng bank3 = new LatLng(34.26097274966923, -6.6200610763167225);
        mMap.addMarker(new MarkerOptions().position(bank3).title("CIH"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(bank3));

        LatLng bank4 = new LatLng(34.266857133915416, -6.565721747260195);
        mMap.addMarker(new MarkerOptions().position(bank4).title("CIH"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(bank4));
    }
}