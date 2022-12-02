package com.example.map;

import android.util.Log;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;

import com.tencent.tencentmap.mapsdk.maps.MapView;

public class MapLifecycle implements LifecycleObserver {
    public static final String TAG= "MapLifecycle";
    private MapView mapView;

    public MapLifecycle(MapView mapView){
        this.mapView=mapView;
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    private void create(){
        Log.d(TAG,"onCreate");
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    private void resume(){
        Log.d(TAG,"onResume");
        mapView.onResume();
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    private void pause(){
        Log.d(TAG,"onPause");
        mapView.onPause();
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    private void stop(){
        Log.d(TAG,"onStop");
        mapView.onStop();
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    private void destroy(){
        Log.d(TAG,"onDestroy");
        mapView.onDestroy();
    }

}
