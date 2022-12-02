package com.example.map;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.RadioGroup;

import com.tencent.tencentmap.mapsdk.maps.MapView;
import com.tencent.tencentmap.mapsdk.maps.TencentMap;
import com.tencent.tencentmap.mapsdk.maps.TencentMapInitializer;

public class MapTypeActivity extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener {

    private MapView mapView;
    private TencentMap tencentMap;
    private RadioGroup radioGroup;
    private MapLifecycle mapLifecycle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map_type);

        TencentMapInitializer.setAgreePrivacy(true);

        mapView=findViewById(R.id.basemap);
        radioGroup=findViewById(R.id.map_type);
        radioGroup.setOnCheckedChangeListener(this);
        tencentMap=mapView.getMap();
        mapLifecycle=new MapLifecycle(mapView);
        getLifecycle().addObserver(mapLifecycle);
    }

    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int i) {
        switch (i){
//            普通地图
            case R.id.normal:
                tencentMap.setTrafficEnabled(false);
                tencentMap.setMapType(TencentMap.MAP_TYPE_NORMAL);
                break;
//            卫星地图
            case R.id.satellite:
                tencentMap.setTrafficEnabled(false);
                tencentMap.setMapType(TencentMap.MAP_TYPE_SATELLITE);
                break;
//            暗色地图
            case R.id.dark:
                tencentMap.setTrafficEnabled(false);
                tencentMap.setMapType(TencentMap.MAP_TYPE_DARK);
                break;
//            路况地图
            case R.id.traffic:
                tencentMap.setTrafficEnabled(true);
                break;
            default:
                break;

        }
    }
}