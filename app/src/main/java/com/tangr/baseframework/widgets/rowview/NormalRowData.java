package com.tangr.baseframework.widgets.rowview;

/**
 * Created by tangr on 2016/6/16.
 */
public class NormalRowData extends RowData{
    public int imageRes;
    public String text;

    public NormalRowData(int imageRes, String text){
        this.imageRes = imageRes;
        this.text = text;
    }

    public NormalRowData(int imageRes, String text, RowActionEnum action){
        this.imageRes = imageRes;
        this.text = text;
        this.action = action;
    }
}
