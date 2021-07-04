package com.example.responsi_123180128.model.rs_rujukan;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class RsRujukanResponse {

    @SerializedName("status_code")
    private int statusCode;

    @SerializedName("data")
    private ArrayList<RsRujukanDataItem> data;

    public void setStatusCode(int statusCode){
        this.statusCode = statusCode;
    }

    public int getStatusCode(){
        return statusCode;
    }

    public void setData(ArrayList<RsRujukanDataItem> data){
        this.data = data;
    }

    public ArrayList<RsRujukanDataItem> getData(){
        return data;
    }

}
