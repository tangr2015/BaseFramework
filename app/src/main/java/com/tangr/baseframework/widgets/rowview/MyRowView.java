package com.tangr.baseframework.widgets.rowview;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.tangr.baseframework.R;

/**
 * Created by tangr on 2016/6/16.
 */
public class MyRowView extends RowView implements View.OnClickListener {
    private ImageView avatar;
    private TextView name;
    private TextView id;
    private ImageView arrow;
    private MyRowData rowData;
    private OnRowClickListener listener;

    public MyRowView(Context context) {
        super(context);
        initView();
    }

    public MyRowView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView();
    }

    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public MyRowView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView();
    }

    private void initView() {
        LayoutInflater.from(getContext()).inflate(R.layout.item_rowview_my, this, true);
        avatar = (ImageView) findViewById(R.id.avator);
        name = (TextView) findViewById(R.id.name);
        id = (TextView) findViewById(R.id.id);
        arrow = (ImageView) findViewById(R.id.arrow);
    }

    public void setData(RowData rowData,OnRowClickListener listener) {
        this.rowData = (MyRowData)rowData;
        this.listener = listener;
    }

    public void notifyChanged() {
        if (rowData!=null){
            avatar.setImageResource(rowData.imageRes);
            name.setText(rowData.name);
            id.setText(rowData.id);
            if(rowData.action==null){
                setBackgroundResource(R.color.rowview_bg);
                arrow.setImageResource(R.mipmap.ic_right);
                arrow.setVisibility(INVISIBLE);
            }else {
                setClickable(true);
                setBackgroundResource(R.drawable.selector_rowview);
                arrow.setImageResource(R.mipmap.ic_right);
                arrow.setVisibility(VISIBLE);
                setOnClickListener(this);
            }
        }else {
            setVisibility(GONE);
        }
    }

    @Override
    public void onClick(View v) {
        listener.onRowClick(rowData.action);
    }
}
