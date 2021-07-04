package com.example.responsi_123180128.view.viewmodel;

import com.example.responsi_123180128.model.rs_rujukan.RsRujukanResponse;
import com.example.responsi_123180128.model.rs_rujukan.RsRujukanDataItem;
import com.example.responsi_123180128.service.ApiMain;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.util.ArrayList;

public class RsRujukanViewModel extends ViewModel {
    private ApiMain apiMain;
    private MutableLiveData<ArrayList<RsRujukanDataItem>> listRs = new MutableLiveData<>();

    public void setRsDiscover() {
        if(this.apiMain==null){
            apiMain = new ApiMain();
        }

        apiMain.getApiRsRujukan().getRsRujukan().enqueue(new Callback<RsRujukanResponse>() {
            @Override
            public void onResponse(Call<RsRujukanResponse> call, Response<RsRujukanResponse> response) {
                RsRujukanResponse rsDiscover = response.body();
                if(rsDiscover != null && rsDiscover.getData() != null){
                    ArrayList<RsRujukanDataItem> rsRujukanDataItems = rsDiscover.getData();
                    listRs.postValue(rsRujukanDataItems);
                }
            }

            @Override
            public void onFailure(Call<RsRujukanResponse> call, Throwable t) {

            }
        });
    }

    public LiveData<ArrayList<RsRujukanDataItem>> getRsDiscover(){
        return listRs;
    }
}
