package com.tangr.baseframework.widgets.rowview;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.tangr.baseframework.R;

import java.util.ArrayList;

/**
 * Created by tangr on 2016/6/16.
 */
public class GroupView extends LinearLayout{
    private ArrayList<RowData> rows;
    private float density;
    private int padding;
    private OnRowClickListener listener;

    public GroupView(Context context) {
        super(context);
        initView(context);
    }

    public GroupView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView(context);
    }

    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public GroupView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context);
    }

    private void initView(Context context) {
        setOrientation(VERTICAL);
        setBackgroundResource(android.R.color.transparent);
        density = context.getResources().getDisplayMetrics().density;
        padding = (int) (10 * density);
    }

    public void setData(ArrayList<RowData> rows,OnRowClickListener listener){
        this.rows = rows;
        this.listener = listener;
    }

    public void notifyChanged(){
        if(rows!=null&&rows.size()>0){
            RowView rowView = null;
            View line = null;
            LayoutParams params = new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,1);
            params.leftMargin = (int) (10 * density);
            for (int i=0;i<rows.size();i++){
                RowData row = rows.get(i);
                if(row instanceof NormalRowData){
                    rowView = new NormalRowView(getContext());
                }else if(row instanceof MyRowData){
                    rowView = new MyRowView(getContext());
                }
                rowView.setData(row,listener);
                rowView.notifyChanged();
                rowView.setPadding(padding, padding, padding, padding);
                addView(rowView);
                if(i!=rows.size()-1){
                    line = new View(getContext());
                    line.setBackgroundResource(R.color.line_color);
                    addView(line,params);
                }
            }
        }else {
            setVisibility(GONE);
        }
    }
}
