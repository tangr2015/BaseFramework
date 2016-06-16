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
public abstract class RowView extends LinearLayout{
    public RowView(Context context) {
        super(context);
    }

    public RowView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public RowView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public abstract void setData(RowData rowData, OnRowClickListener listener);

    public abstract void notifyChanged();
}
