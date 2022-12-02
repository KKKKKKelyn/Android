package com.example.map;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.tencent.lbssearch.TencentSearch;
import com.tencent.lbssearch.httpresponse.BaseObject;
import com.tencent.lbssearch.object.param.DistrictChildrenParam;
import com.tencent.lbssearch.object.result.DistrictResultObject;
import com.tencent.map.tools.net.http.HttpResponseListener;
import com.tencent.tencentmap.mapsdk.maps.CameraUpdateFactory;
import com.tencent.tencentmap.mapsdk.maps.MapView;
import com.tencent.tencentmap.mapsdk.maps.TencentMap;
import com.tencent.tencentmap.mapsdk.maps.TencentMapInitializer;
import com.tencent.tencentmap.mapsdk.maps.model.CameraPosition;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;

import java.util.ArrayList;
import java.util.List;

public class DistrictActivity extends AppCompatActivity {
    private Spinner province;
    private Spinner city;
    private Spinner district;
    private List<LatLng> latLngs=new ArrayList<>();
    private TencentMap tencentMap;
    private MapView mapView;
    private MapLifecycle mapLifecycle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_district);
        TencentMapInitializer.setAgreePrivacy(true);
        initView();
        initSpinner();

    }

    protected void initView(){
        province=(Spinner) findViewById(R.id.sp_province);
        city=(Spinner) findViewById(R.id.sp_city);
        district=(Spinner) findViewById(R.id.sp_district);
        mapView=findViewById(R.id.district_map);
        tencentMap=mapView.getMap();
        mapLifecycle=new MapLifecycle(mapView);
        getLifecycle().addObserver(mapLifecycle);
    }

    protected void initSpinner(){
        getDistrict(0, R.id.sp_province);
        AdapterView.OnItemSelectedListener onItemSelectedListener = new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int position, long id) {
                // TODO Auto-generated method stub
                switch (parent.getId()) {
                    case R.id.sp_province:
                        getDistrict(((List<Integer>) parent.getTag()).
                                get(position).intValue(), R.id.sp_city);
                        break;
                    case R.id.sp_city:
                        getDistrict(((List<Integer>) parent.getTag()).
                                get(position).intValue(), R.id.sp_district);
                        break;
                    case R.id.sp_district:
                        getDistrict(((List<Integer>) parent.getTag()).
                                get(position).intValue(), R.id.sp_district);
                        tencentMap.moveCamera(CameraUpdateFactory.newCameraPosition(new CameraPosition(latLngs.get(position), 15f, 0, 0)));
                    default:
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // TODO Auto-generated method stub

            }
        };
        province.setOnItemSelectedListener(onItemSelectedListener);
        city.setOnItemSelectedListener(onItemSelectedListener);
        district.setOnItemSelectedListener(onItemSelectedListener);

    }

    /**
     * 获取行政区划
     */
    protected void getDistrict(int pDistrict, final int spId){
        TencentSearch tencentSearch=new TencentSearch(this);
        DistrictChildrenParam districtChildrenParam=new DistrictChildrenParam();
        Log.d("eqrwqeqewr","getdistrict" + spId);

         //如果不设置id，则获取全部数据
        if (spId != R.id.sp_province && spId == R.id.sp_city) {
            districtChildrenParam.id(pDistrict);
        }
        if (spId != R.id.sp_province && spId != R.id.sp_city) {
            districtChildrenParam.id(pDistrict);
        }

        tencentSearch.getDistrictChildren(districtChildrenParam, new HttpResponseListener<BaseObject>() {
            @Override
            public void onSuccess(int i, BaseObject baseObject) {
                if (baseObject==null){
                    return;
                }
                DistrictResultObject obj=(DistrictResultObject) baseObject;
                switch (spId){
                    case R.id.sp_province:
                        setDistrictAdapter(province, obj);
                        break;
                    case R.id.sp_city:
                        setDistrictAdapter(city, obj);
                        break;
                    case R.id.sp_district:
                        setDistrictAdapter(district, obj);
                        break;

                    default:
                        break;
                }
            }

            @Override
            public void onFailure(int i, String s, Throwable throwable) {

            }
        });

    }
    /**
     * 设置行政区划的adapter
     *
     * @param spinner 要设置adapter的spinner
     * @param obj     用于填充adapter的数据源
     */
    protected void setDistrictAdapter(Spinner spinner, final DistrictResultObject obj){
        List<String> names = new ArrayList<String>();
        List<Integer> ids = new ArrayList<Integer>();
        latLngs.clear();
        final List<DistrictResultObject.DistrictResult> districtResults = obj.result.get(0);
        for (final DistrictResultObject.DistrictResult result : districtResults) {
            names.add(result.fullname);
            ids.add(result.id);
            latLngs.add(result.latLng);
            Log.d("位置", "setDistrictAdapter: " + result.fullname);

        }
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, names);
        spinner.setAdapter(adapter);
        //将行政区划编码附到spinner方便后续查询
        spinner.setTag(ids);
    }
    protected void printResult(final String r) {
        runOnUiThread(new Runnable() {

            @Override
            public void run() {
                // TODO Auto-generated method stub
            }
        });
    }

}