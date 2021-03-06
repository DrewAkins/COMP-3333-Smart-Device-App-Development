package com.example.maxdr_000.assignment3;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.text.InputType;
import android.widget.Toast;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import android.widget.TextView;
import android.view.View;
import android.widget.Button;

public class MapsActivity extends FragmentActivity {

    private GoogleMap mMap; // Might be null if Google Play services APK is not available.
    TextView myEditViewLat, myEditViewLongi; //Enter lat and longi.
    TextView myTextViewLat, myTextViewLongi; //display lat and longi

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        setUpMapIfNeeded();
        myEditViewLat = (TextView)findViewById(R.id.editTextLat);
        myEditViewLat.setInputType(InputType.TYPE_CLASS_TEXT);
        myEditViewLat.setText("");
        myEditViewLongi = (TextView)findViewById(R.id.editTextLongi);
        myEditViewLongi.setInputType(InputType.TYPE_CLASS_TEXT);
        myEditViewLongi.setText("");
        myTextViewLat = (TextView)findViewById(R.id.textViewLat);
        myTextViewLongi = (TextView)findViewById(R.id.textViewLongi);
    }

    @Override
    protected void onResume() {
        super.onResume();
        setUpMapIfNeeded();
    }
    public void submitData(View view) {
//Fetch the coordinates
        String newLatStr = myEditViewLat.getText().toString();
        String newLongiStr = myEditViewLongi.getText().toString();
        if (newLatStr.isEmpty() || newLongiStr.isEmpty()) {
            Toast.makeText(MapsActivity.this, "Invalid input",
                    Toast.LENGTH_SHORT).show();
            return;
        }
//Convert string to double for moving the pin and camera
        double latV, longiV;
        latV = Double.parseDouble(newLatStr);
        longiV = Double.parseDouble(newLongiStr);
        AddMarker(latV, longiV);
    }

    /**
     * Sets up the map if it is possible to do so (i.e., the Google Play services APK is correctly
     * installed) and the map has not already been instantiated.. This will ensure that we only ever
     * call {@link #setUpMap()} once when {@link #mMap} is not null.
     * <p/>
     * If it isn't installed {@link SupportMapFragment} (and
     * {@link com.google.android.gms.maps.MapView MapView}) will show a prompt for the user to
     * install/update the Google Play services APK on their device.
     * <p/>
     * A user can return to this FragmentActivity after following the prompt and correctly
     * installing/updating/enabling the Google Play services. Since the FragmentActivity may not
     * have been completely destroyed during this process (it is likely that it would only be
     * stopped or paused), {@link #onCreate(Bundle)} may not be called again so we should call this
     * method in {@link #onResume()} to guarantee that it will be called.
     */
    private void setUpMapIfNeeded() {
        // Do a null check to confirm that we have not already instantiated the map.
        if (mMap == null) {
            // Try to obtain the map from the SupportMapFragment.
            mMap = ((SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map))
                    .getMap();
            // Check if we were successful in obtaining the map.
            if (mMap != null) {
                setUpMap();
            }
        }
    }

    /**
     * This is where we can add markers or lines, add listeners or move the camera. In this case, we
     * just add a marker near Africa.
     * <p/>
     * This should only be called once and when we are sure that {@link #mMap} is not null.
     */
    private void setUpMap() {

        mMap.addMarker(new MarkerOptions().position(new LatLng(0, 0)).title("Marker"));
    }

    public void AddMarker(double Lat,double Long) {

        mMap.addMarker((new MarkerOptions().position(new LatLng(Lat,Long)).title(("NewMarker"))));
    }


}




