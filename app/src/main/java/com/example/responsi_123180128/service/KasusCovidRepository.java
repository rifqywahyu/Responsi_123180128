package com.example.responsi_123180128.service;

import com.example.responsi_123180128.model.kasus_covid.KasusCovidResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface KasusCovidRepository {
    @GET("rekapitulasi_v2/jabar/kumulatif")
    Call<KasusCovidResponse> getKasusCovid();
}
