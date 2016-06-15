package com.tangr.baseframework;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class LazyFragment extends Fragment {
    private boolean isVisibleToUser;
    private boolean viewCreated;
    private boolean hasLoadData;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
//        Log.e("tangr",toString()+":onCreateView");
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
//        Log.e("tangr", toString() + ":setUserVisibleHint:" + isVisibleToUser);
        this.isVisibleToUser = isVisibleToUser;
        checkIfLoadData();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
//        Log.e("tangr", toString() + ":onAttach");
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        Log.e("tangr", toString() + ":onCreate");
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
//        Log.e("tangr", toString() + ":onViewCreated");
        this.viewCreated = true;
        if(savedInstanceState!=null)
            onRestoreInstanceState(savedInstanceState);
        if (hasLoadData)
            setData();
        else
            checkIfLoadData();
    }

    protected void setData() {
    }

    private void checkIfLoadData(){
        if(isVisibleToUser&&viewCreated&&!hasLoadData){
            loadData();
            hasLoadData = true;
            setData();
        }
    }

    protected void loadData() {
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
//        Log.e("tangr", toString() + ":onActivityCreated");
    }

    @Override
    public void onViewStateRestored(Bundle savedInstanceState) {
        super.onViewStateRestored(savedInstanceState);
//        Log.e("tangr", toString() + ":onViewStateRestored");
    }

    @Override
    public void onStart() {
        super.onStart();
//        Log.e("tangr", toString() + ":onStart");
    }

    @Override
    public void onResume() {
        super.onResume();
//        Log.e("tangr", toString() + ":onResume");
    }

    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        hasLoadData = true;
    }

    @Override
    public void onPause() {
        super.onPause();
//        Log.e("tangr", toString() + ":onPause");
    }

    @Override
    public void onStop() {
        super.onStop();
//        Log.e("tangr", toString() + ":onStop");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
//        Log.e("tangr", toString() + ":onDestroyView");
        this.viewCreated = false;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
//        Log.e("tangr", toString() + ":onDestroy");
    }

    @Override
    public void onDetach() {
        super.onDetach();
//        Log.e("tangr", toString() + ":onDetach");
    }
}
