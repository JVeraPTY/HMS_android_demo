/*
 * Copyright (C) 2012 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 *  2020.1.3-Changed modify the import classes type and add some mapView demos.
 *                  Huawei Technologies Co., Ltd.
 *
 */

package com.huawei.hms.androiddemo;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import com.huawei.hms.maps.CameraUpdateFactory;
import com.huawei.hms.maps.HuaweiMap;
import com.huawei.hms.maps.HuaweiMapOptions;
import com.huawei.hms.maps.MapView;
import com.huawei.hms.maps.OnMapReadyCallback;
import com.huawei.hms.maps.model.LatLng;
import com.huawei.hms.maps.model.MarkerOptions;

public class MapViewCodeDemoActivity extends AppCompatActivity implements OnMapReadyCallback {
    private static final String TAG = "MapViewCodeDemoActivity";

    private HuaweiMap hMap;

    private MapView mMapView;

    private static final String MAPVIEW_BUNDLE_KEY = "MapViewBundleKey";
    private static final Double Longitude_initial = 14.6024984;
    private static final Double Latitude_initial = -90.5138277;

    private static final LatLng OAKLANDMALL = new LatLng(14.598773, -90.507367);
    private static final LatLng CENTROMEDICO = new LatLng(14.6057496, -90.5132161);
    private static final LatLng FONTABELLA = new LatLng(14.5997542, -90.5143134);
    private static final LatLng MARGARITAS = new LatLng(14.6027182, -90.5117666);
    private static final LatLng AVIA = new LatLng(14.6008685, -90.5161703);
    private static final LatLng MCDONALDS = new LatLng(14.6002673, -90.516991);
    private static final LatLng TEXACO = new LatLng(14.6002937, -90.5232988);
    private static final LatLng UNIGALILEO = new LatLng(14.6094792, -90.5078585);
    private static final LatLng ELPILLAR = new LatLng(14.6099824, -90.5015485);
    private static final LatLng METROBOWL = new LatLng(14.6010119, -90.5007241);
    private static final LatLng CAYALA = new LatLng(14.6082789, -90.4887839);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d(TAG, "onCreate: ");

        super.onCreate(savedInstanceState);
        HuaweiMapOptions huaweiMapOptions = new HuaweiMapOptions();
        huaweiMapOptions.compassEnabled(true);
        huaweiMapOptions.zoomControlsEnabled(true);
        huaweiMapOptions.scrollGesturesEnabled(true);
        huaweiMapOptions.zoomGesturesEnabled(true);
        mMapView = new MapView(this, huaweiMapOptions);
        Bundle mapViewBundle = null;
        if (savedInstanceState != null) {
            mapViewBundle = savedInstanceState.getBundle(MAPVIEW_BUNDLE_KEY);
        }

        mMapView.onCreate(mapViewBundle);
        mMapView.getMapAsync(this);
        setContentView(mMapView);

    }

    @Override
    protected void onStart() {
        super.onStart();
        mMapView.onStart();
    }

    @Override
    protected void onStop() {
        super.onStop();
        mMapView.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mMapView.onDestroy();
    }

    @Override
    public void onMapReady(HuaweiMap map) {
        Log.d(TAG, "onMapReady: ");
        Log.d(TAG, "Longitude_initial: "+Longitude_initial);
        Log.d(TAG, "Latitude_initial: "+Latitude_initial);
        hMap = map;
        hMap.setMyLocationEnabled(true);
        hMap.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(Longitude_initial, Latitude_initial), 14));
        hMap.getUiSettings().setCompassEnabled(true);
        hMap.getUiSettings().setMyLocationButtonEnabled(true);
        hMap.addMarker(new MarkerOptions().position(OAKLANDMALL).title("Oakland Mall").snippet("Shopping mall").clusterable(true));
        hMap.addMarker(new MarkerOptions().position(FONTABELLA).title("Fontabella").snippet("Shopping mall").clusterable(true));
        hMap.addMarker(new MarkerOptions().position(MARGARITAS).title("Centro Gerencial Las Margaritas").snippet("Corporate office").clusterable(true));
        hMap.addMarker(new MarkerOptions().position(AVIA).title("Avia").snippet("Shopping mall").clusterable(true));
        hMap.addMarker(new MarkerOptions().position(TEXACO).title("Texaco").snippet("Gas Station").clusterable(true));
        hMap.addMarker(new MarkerOptions().position(UNIGALILEO).title("Universidad Galileo").snippet("University").clusterable(true));
        hMap.addMarker(new MarkerOptions().position(ELPILLAR).title("Nuestra Señora Del Pilar Hospital").snippet("Hospital").clusterable(true));
        hMap.addMarker(new MarkerOptions().position(METROBOWL).title("Metro Bowl").snippet("Bowling alley").clusterable(true));
        hMap.addMarker(new MarkerOptions().position(CAYALA).title("Ciudad Cayalá").snippet("Shopping mall").clusterable(true));
        hMap.addMarker(new MarkerOptions().position(MCDONALDS).title("McDonald's").snippet("Fast food restaurant").clusterable(true));
        hMap.addMarker(new MarkerOptions().position(CENTROMEDICO).title("Centro Médico").snippet("Private hospital").clusterable(true));
    }

    @Override
    protected void onPause() {
        mMapView.onPause();
        super.onPause();
    }

    @Override
    protected void onResume() {
        super.onResume();
        mMapView.onResume();
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        mMapView.onLowMemory();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        mMapView.onSaveInstanceState(outState);
    }

}
