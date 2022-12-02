package com.example.map;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.tencent.tencentmap.mapsdk.maps.MapView;
import com.tencent.tencentmap.mapsdk.maps.TencentMap;
import com.tencent.tencentmap.mapsdk.maps.TencentMapInitializer;
import com.tencent.tencentmap.mapsdk.maps.TextureMapView;


public class BaseMapActivity extends AppCompatActivity {
    //基础地图
    private TextureMapView mapView;
    //腾讯地图
    private TencentMap tencentMap;

    private MapLifecycle mapLifecycle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base_map);

        TencentMapInitializer.setAgreePrivacy(true);

        //地图
        mapView = findViewById(R.id.mapView);
        //创建tencentMap地图对象
        tencentMap = mapView.getMap();

        mapLifecycle=new MapLifecycle(mapView);

        getLifecycle().addObserver(mapLifecycle);

    }


    /**
     * mapview的生命周期管理
     */
    @Override
    protected void onStart() {
        super.onStart();
        mapView.onStart();
    }

    @Override
    protected void onResume() {
        super.onResume();
        mapView.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        mapView.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
        mapView.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mapView.onDestroy();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        mapView.onRestart();
    }

}