package com.example.responsi_123180128.model.kasus_covid;

import com.google.gson.annotations.SerializedName;

public class KasusCovidResponse {

    @SerializedName("status_code")
    private int statusCode;

    @SerializedName("data")
    private Data data;

    public int getStatusCode(){
        return statusCode;
    }

    public Data getData(){
        return data;
    }

    @Override
    public String toString(){
        return
                "Response{" +
                        "status_code = '" + statusCode + '\'' +
                        ",data = '" + data + '\'' +
                        "}";
    }

}
