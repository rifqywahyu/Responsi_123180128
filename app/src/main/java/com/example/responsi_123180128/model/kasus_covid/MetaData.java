package com.example.responsi_123180128.model.kasus_covid;

import com.google.gson.annotations.SerializedName;

public class MetaData {

    @SerializedName("last_update")
    private String lastUpdate;

    public String getLastUpdate(){
        return lastUpdate;
    }

    @Override
    public String toString(){
        return
                "Metadata{" +
                        "last_update = '" + lastUpdate + '\'' +
                        "}";
    }

}
