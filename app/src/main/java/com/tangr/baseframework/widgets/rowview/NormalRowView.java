package com.tangr.baseframework.widgets.rowview;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.tangr.baseframework.R;

/**
 * Created by tangr on 2016/6/16.
 */
public class NormalRowView extends RowView implements View.OnClickListener {
    private ImageView iv;
    private TextView tv;
    private ImageView iv2;
    private NormalRowData rowData;
    private OnRowClickListener listener;

    public NormalRowView(Context context) {
        super(context);
        initView();
    }

    public NormalRowView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView();
    }

    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public NormalRowView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView();
    }

    private void initView() {
        LayoutInflater.from(getContext()).inflate(R.layout.item_rowview, this, true);
        iv = (ImageView) findViewById(R.id.row_iv);
        tv = (TextView) findViewById(R.id.row_tv);
        iv2 = (ImageView) findViewById(R.id.row_ib);
    }

    public void setData(RowData rowData,OnRowClickListener listener) {
        this.rowData = (NormalRowData)rowData;
        this.listener = listener;
    }

    public void notifyChanged() {
        if (rowData!=null){
            iv.setImageResource(rowData.imageRes);
            tv.setText(rowData.text);
            if(rowData.action==null){
                setBackgroundResource(R.color.rowview_bg);
                iv2.setImageResource(R.mipmap.ic_right);
                iv2.setVisibility(INVISIBLE);
            }else {
                setClickable(true);
                setBackgroundResource(R.drawable.selector_rowview);
                iv2.setImageResource(R.mipmap.ic_right);
                iv2.setVisibility(VISIBLE);
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
