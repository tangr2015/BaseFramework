package com.tangr.baseframework;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by tangr on 2016/6/15.
 */
public class TabLayout extends LinearLayout implements View.OnClickListener {
    private OnTabClickListener listener;
    private ArrayList<Tab> tabs;
    private View selectView;
    private int tabCount;

    public TabLayout(Context context) {
        super(context);
        initView();
    }

    public TabLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView();
    }

    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public TabLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView();
    }

    private void initView(){
        setOrientation(HORIZONTAL);
    }

    public void setUpData(ArrayList<Tab> tabs, OnTabClickListener listener) {
        this.tabs = tabs;
        this.listener = listener;

        if (tabs != null && tabs.size() > 0) {
            tabCount = tabs.size();
            TabView mTabView;
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(0, LinearLayout.LayoutParams.WRAP_CONTENT);
            params.gravity = Gravity.CENTER;
            params.weight = 1;
            for (int i = 0; i < tabs.size(); i++) {
                mTabView = new TabView(getContext());
                Tab tab = tabs.get(i);
                tab.position = i;
                mTabView.setTag(tab);
                mTabView.setUpData(tabs.get(i));
                mTabView.setOnClickListener(this);
                addView(mTabView, params);
            }
        } else {
            throw new IllegalArgumentException("tabs can't be empty");
        }
    }

    public void setCurrentTab(int i) {
        if (i < tabCount && i >= 0) {
            View view = getChildAt(i);
            onClick(view);
        }
    }

    @Override
    public void onClick(View v) {
        if (selectView != v) {
            if(selectView!=null){
                selectView.setSelected(false);
            }
            Tab tab = (Tab) v.getTag();
            listener.onTabClick(tab.position,tab);
            v.setSelected(true);
            selectView = v;
        }
    }

    public interface OnTabClickListener {
        void onTabClick(int position,Tab tab);
    }

    public class TabView extends LinearLayout {
        private ImageView mTabImg;
        private TextView mTabLabel;

        public TabView(Context context) {
            super(context);
            initView();
        }


        public TabView(Context context, AttributeSet attrs) {
            super(context, attrs);
            initView();
        }

        @TargetApi(Build.VERSION_CODES.HONEYCOMB)
        public TabView(Context context, AttributeSet attrs, int defStyleAttr) {
            super(context, attrs, defStyleAttr);
            initView();
        }

        private void initView() {
            LayoutInflater.from(getContext()).inflate(R.layout.widget_tab_view, this, true);
            setOrientation(VERTICAL);
            setGravity(Gravity.CENTER);
            mTabImg = (ImageView) findViewById(R.id.mTabImg);
            mTabLabel = (TextView) findViewById(R.id.mTabLabel);
        }

        public void setUpData(Tab tab) {
            mTabImg.setBackgroundResource(tab.imgResId);
            if (tab.labelText==null)
                mTabLabel.setText(tab.labelResId);
            else
                mTabLabel.setText(tab.labelText);
        }
    }

    public static class Tab {
        public int imgResId;
        public int labelResId;
        public String labelText;
        public int position;

        public Tab(int imgResId, int labelResId) {
            this.imgResId = imgResId;
            this.labelResId = labelResId;
        }

        public Tab(int imgResId, String labelText) {
            this.imgResId = imgResId;
            this.labelText = labelText;
        }
    }
}
