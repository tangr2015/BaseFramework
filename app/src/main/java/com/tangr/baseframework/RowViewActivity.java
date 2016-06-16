package com.tangr.baseframework;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.tangr.baseframework.widgets.rowview.ContentView;
import com.tangr.baseframework.widgets.rowview.GroupData;
import com.tangr.baseframework.widgets.rowview.GroupView;
import com.tangr.baseframework.widgets.rowview.MyRowData;
import com.tangr.baseframework.widgets.rowview.NormalRowData;
import com.tangr.baseframework.widgets.rowview.OnRowClickListener;
import com.tangr.baseframework.widgets.rowview.RowActionEnum;
import com.tangr.baseframework.widgets.rowview.RowData;

import java.util.ArrayList;

public class RowViewActivity extends AppCompatActivity implements OnRowClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_row_view);

//        GroupView gv = (GroupView) findViewById(R.id.groupview);
//        ArrayList<RowData> list = new ArrayList<RowData>();
//        list.add(new RowData(R.mipmap.ic_launcher,"相册"));
//        list.add(new RowData(R.mipmap.ic_launcher,"收藏"));
//        list.add(new RowData(R.mipmap.ic_launcher,"钱包",true));
//        gv.setData(list);
//        gv.notifyChanged();

        ContentView cv = (ContentView) findViewById(R.id.contentview);

        ArrayList<GroupData> groups = new ArrayList<GroupData>();

        ArrayList<RowData> list0 = new ArrayList<RowData>();
        list0.add(new MyRowData(R.mipmap.ic_launcher,"tangr","weixinid",RowActionEnum.MY));
        groups.add(new GroupData(list0));

        ArrayList<RowData> list1 = new ArrayList<RowData>();
        list1.add(new NormalRowData(R.mipmap.more_my_album,"相册",RowActionEnum.ALBUM));
        list1.add(new NormalRowData(R.mipmap.more_my_favorite,"收藏",RowActionEnum.COLLECT));
        list1.add(new NormalRowData(R.mipmap.more_my_bank_card,"钱包"));
        groups.add(new GroupData(list1));

        ArrayList<RowData> list2 = new ArrayList<RowData>();
        list2.add(new NormalRowData(R.mipmap.more_emoji_store,"表情",RowActionEnum.FACE));
        groups.add(new GroupData(list2));

        ArrayList<RowData> list3 = new ArrayList<RowData>();
        list3.add(new NormalRowData(R.mipmap.more_setting,"设置",RowActionEnum.SETTING));
        groups.add(new GroupData(list3));

        cv.setData(groups, this);
        cv.notifyChange();
    }

    @Override
    public void onRowClick(RowActionEnum action) {
        Toast.makeText(this,action.name(),Toast.LENGTH_SHORT).show();
    }
}
