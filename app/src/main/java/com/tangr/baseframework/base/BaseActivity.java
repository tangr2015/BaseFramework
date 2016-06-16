package com.tangr.baseframework.base;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.tangr.baseframework.R;

public abstract class BaseActivity extends AppCompatActivity {
    protected Toolbar toolbar;
    protected TextView toolbar_title;
    public static final int MODE_NONE = 0;
    public static final int MODE_BACK = 1;
    public static final int MODE_MENU = 2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setUpContentView();
        setUpView();
        setUpData(savedInstanceState);
    }

    protected abstract void setUpContentView();

    protected abstract void setUpView();

    protected abstract void setUpData(Bundle savedInstanceState);

    @Override
    public void setContentView(int layoutResID) {
        setContentView(layoutResID, "", MODE_NONE);
    }

    public void setContentView(int layoutResID, String titleText){
        setContentView(layoutResID, titleText, MODE_NONE);
    }

    public void setContentView(int layoutResID, String titleText, int mode) {
        super.setContentView(layoutResID);
        setUpToolbar(titleText, mode);
    }

    private void setUpToolbar(String titleText, int mode) {
        toolbar = (Toolbar)findViewById(R.id.toolbar);
        toolbar_title = (TextView)findViewById(R.id.toolbar_title);

        if (mode == MODE_BACK) {
            toolbar.setNavigationIcon(R.mipmap.ic_back);
        }else if(mode == MODE_MENU){
            toolbar.setNavigationIcon(R.mipmap.ic_drawer_home);
        }
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                leftButtonClick();
            }
        });

        setUpTitle(titleText);
    }

    protected void leftButtonClick() {
        finish();
    }

    protected void setUpTitle(String titleText) {
        if (toolbar_title != null) {
            toolbar_title.setText(titleText);
        }
    }
}
