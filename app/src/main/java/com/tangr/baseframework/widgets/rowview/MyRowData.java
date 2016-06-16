package com.tangr.baseframework.widgets.rowview;

/**
 * Created by tangr on 2016/6/16.
 */
public class MyRowData extends RowData{
    public int imageRes;
    public String name;
    public String id;

    public MyRowData(int imageRes, String name,String id, RowActionEnum action){
        this.imageRes = imageRes;
        this.name = name;
        this.id = id;
        this.action = action;
    }
}
