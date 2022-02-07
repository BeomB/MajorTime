package com.example.majortime;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;


public class MapsLibraryActivity extends AppCompatActivity implements OnMapReadyCallback {

    private GoogleMap mMap,mMap2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps_library);
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map_library);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(final GoogleMap googleMap) {

        mMap = googleMap;

        LatLng MAP_point = new LatLng(Double.parseDouble(String.valueOf(37.380054)), Double.parseDouble(String.valueOf(126.927711)));
        LatLng MAP_Library = new LatLng(Double.parseDouble(String.valueOf(37.379895)), Double.parseDouble(String.valueOf(126.928737)));
        //(성결관)


        MarkerOptions markerOptions_Ki = new MarkerOptions();
        MarkerOptions markerOptions_Home = new MarkerOptions();
        MarkerOptions markerOptions_Library = new MarkerOptions();
        MarkerOptions markerOptions_dae = new MarkerOptions();
        MarkerOptions markerOptions_HS = new MarkerOptions();
        MarkerOptions markerOptions_jae = new MarkerOptions();
        MarkerOptions markerOptions_print = new MarkerOptions();
        MarkerOptions markerOptions_jong= new MarkerOptions();
        MarkerOptions markerOptions_student = new MarkerOptions();
        MarkerOptions markerOptions_eng = new MarkerOptions();
        MarkerOptions markerOptions_act = new MarkerOptions();
        markerOptions_Library.position(MAP_Library);
        markerOptions_dae.position(new LatLng(37.380988, 126.926318));
        markerOptions_HS.position(new LatLng(37.380463, 126.926877));
        markerOptions_jae.position(new LatLng(37.380264, 126.927594));
        markerOptions_print.position(new LatLng(37.379799, 126.928503));
        markerOptions_jong.position(new LatLng(37.378798, 126.929335));
        markerOptions_student.position(new LatLng(37.379468, 126.929552));
        markerOptions_eng.position(new LatLng(37.379243, 126.929393));
        markerOptions_act.position(new LatLng(37.379628, 126.929597));
        markerOptions_Home.position(new LatLng(37.379922, 126.92689));
        markerOptions_Ki.position(new LatLng( 37.379253, 126.927432));

        markerOptions_Ki.snippet("신학, 예술 대학");
        markerOptions_student.snippet("학과 과실,다양한 학교활동");
        markerOptions_print.snippet("프린트 및 복사");
        markerOptions_HS.snippet("도서관");
        markerOptions_eng.snippet("인문 대학");
        markerOptions_dae.snippet("대학원");
        markerOptions_act.snippet("체육시설");
        markerOptions_jong.snippet("사회,과학대학(학식)");
        markerOptions_Home.snippet("공과 대학");
        markerOptions_Library.snippet("채플");
        markerOptions_student.title("학생 회관");
        markerOptions_print.title("복사실");
        markerOptions_HS.title("학술정보관");
        markerOptions_eng.title("영암관");
        markerOptions_dae.title("대학원");
        markerOptions_act.title("체육관");
        markerOptions_jong.title("중생관");
        markerOptions_Home.title("성결대학교");
        markerOptions_Ki.title("기념관");
        markerOptions_Library.title("성결관");
        mMap.addMarker(markerOptions_Home);
        mMap.addMarker(markerOptions_act);
        mMap.addMarker(markerOptions_dae);
        mMap.addMarker(markerOptions_eng);
        mMap.addMarker(markerOptions_HS);
        mMap.addMarker(markerOptions_print);
        mMap.addMarker(markerOptions_student);
        mMap.addMarker(markerOptions_Library);
        mMap.addMarker(markerOptions_jong);
        mMap.addMarker(markerOptions_Ki);


        mMap.moveCamera(CameraUpdateFactory.newLatLng(MAP_point));
        mMap.animateCamera(CameraUpdateFactory.zoomTo(16));
    }

}