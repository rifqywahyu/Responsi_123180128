package com.example.responsi_123180128.view.viewmodel;

import com.example.responsi_123180128.model.kasus_covid.KasusCovidResponse;
import com.example.responsi_123180128.model.kasus_covid.KasusCovidDataItem;
import com.example.responsi_123180128.service.ApiMain;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class KasusCovidViewModel extends ViewModel{
    private ApiMain apiMain;
    private MutableLiveData<ArrayList<KasusCovidDataItem>> listKasusCovid = new MutableLiveData<>();

    public void setKasusCovidDiscover() {
        if(this.apiMain==null){
            apiMain = new ApiMain();
        }

        apiMain.getApiKasusCovid().getKasusCovid().enqueue(new Callback<KasusCovidResponse>() {
            @Override
            public void onResponse(Call<KasusCovidResponse> call, Response<KasusCovidResponse> response) {
                KasusCovidResponse kasusCovidRespone = response.body();
                if(kasusCovidRespone != null && kasusCovidRespone.getData() != null){
                    ArrayList<KasusCovidDataItem> kasusCovidItem = kasusCovidRespone.getData().getContent();
                    listKasusCovid.postValue(kasusCovidItem);
                }
            }

            @Override
            public void onFailure(Call<KasusCovidResponse> call, Throwable t) {

            }
        });
    }

    public LiveData<ArrayList<KasusCovidDataItem>> getKasusCovidDiscover(){
        return listKasusCovid;
    }
}
