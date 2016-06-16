package com.tangr.baseframework.widgets.rowview;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import java.util.ArrayList;

/**
 * Created by tangr on 2016/6/16.
 */
public class ContentView extends LinearLayout{
    private ArrayList<GroupData> groups;
    private OnRowClickListener listener;

    public ContentView(Context context) {
        super(context);
        initView();
    }

    public ContentView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView();
    }

    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public ContentView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView();
    }

    private void initView() {
        setOrientation(VERTICAL);
    }

    public void setData(ArrayList<GroupData> groups,OnRowClickListener listener){
        this.groups = groups;
        this.listener = listener;
    }

    public void notifyChange(){
        if(groups!=null&&groups.size()>0){
            float density = getContext().getResources().getDisplayMetrics().density;
            GroupView groupView = null;
            LayoutParams params = new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            params.topMargin = (int) (20*density);
            for (int i=0;i<groups.size();i++){
                groupView = new GroupView(getContext());
                groupView.setData(groups.get(i).rows,listener);
                groupView.notifyChanged();
                addView(groupView,params);
            }
        }else {
            setVisibility(GONE);
        }
    }
}
