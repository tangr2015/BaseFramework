package com.tangr.baseframework;

import android.os.Bundle;
import android.util.Log;

import com.tangr.baseframework.base.BaseActivity;
import com.tangr.baseframework.widgets.TabLayout;

import java.util.ArrayList;

public class TabActivity extends BaseActivity implements TabLayout.OnTabClickListener {
    @Override
    protected void setUpContentView() {
        setContentView(R.layout.activity_tab,"tab",MODE_MENU);
    }

    @Override
    protected void setUpView() {
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tablayout);
        ArrayList<TabLayout.Tab> tabs = new ArrayList<TabLayout.Tab>();
        tabs.add(new TabLayout.Tab(R.drawable.selector_tab_msg,"消息"));
        tabs.add(new TabLayout.Tab(R.drawable.selector_tab_contact,"联系人"));
        tabs.add(new TabLayout.Tab(R.drawable.selector_tab_moments,"发现"));
        tabs.add(new TabLayout.Tab(R.drawable.selector_tab_profile, "我的"));
        tabLayout.setUpData(tabs, this);
        tabLayout.setCurrentTab(0);
    }

    @Override
    protected void setUpData(Bundle savedInstanceState) {

    }

    @Override
    public void onTabClick(int position, TabLayout.Tab tab) {
        Log.i("tangr",position+"");
    }
}
