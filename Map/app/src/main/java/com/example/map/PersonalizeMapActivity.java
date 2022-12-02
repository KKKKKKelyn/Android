package com.example.map;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;

import android.graphics.PorterDuff;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.RadioGroup;
import android.widget.Switch;

import com.tencent.tencentmap.mapsdk.maps.MapView;
import com.tencent.tencentmap.mapsdk.maps.TencentMap;
import com.tencent.tencentmap.mapsdk.maps.TencentMapInitializer;

public class PersonalizeMapActivity extends FragmentActivity implements RadioGroup.OnCheckedChangeListener {
    private MapView mapView;
    private TencentMap tencentMap;
    private RadioGroup radioGroup;
    private Switch aSwitch;
    private MapLifecycle mapLifecycle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personalize_map);

        TencentMapInitializer.setAgreePrivacy(true);

        mapView=findViewById(R.id.personalize_map);
        radioGroup=findViewById(R.id.personalizemap_type);
        aSwitch=findViewById(R.id.switch_open);
        radioGroup.setOnCheckedChangeListener(this);
        tencentMap=mapView.getMap();
        mapLifecycle=new MapLifecycle(mapView);
        getLifecycle().addObserver(mapLifecycle);

        aSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                PorterDuff.Mode buttonTintMode=compoundButton.getButtonTintMode();
                if(b){
                    //显示3D建筑物
                    tencentMap.setBuilding3dEffectEnable(true);
                }else {
                    //隐藏3D建筑物
                    tencentMap.setBuilding3dEffectEnable(false);
                }
            }
        });
    }

    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int i) {
        switch (i){
            //雨露
            case R.id.yulu:
                tencentMap.setMapStyle(1);
                break;
//                烟翠
            case R.id.yancui:
                tencentMap.setMapStyle(2);
                break;
//                澹月
            case R.id.danyue:
                tencentMap.setMapStyle(3);
            default:
                break;
        }
    }

}