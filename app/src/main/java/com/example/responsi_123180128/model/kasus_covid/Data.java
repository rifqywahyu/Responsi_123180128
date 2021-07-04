package com.example.responsi_123180128.model.kasus_covid;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class Data {

    @SerializedName("metadata")
    private MetaData metadata;

    @SerializedName("content")
    private ArrayList<KasusCovidDataItem> content;

    public MetaData getMetaData(){
        return metadata;
    }

    public ArrayList<KasusCovidDataItem> getContent(){
        return content;
    }

    @Override
    public String toString(){
        return
                "Data{" +
                        "metadata = '" + metadata + '\'' +
                        ",content = '" + content + '\'' +
                        "}";
    }

}
