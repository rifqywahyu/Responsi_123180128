package com.example.responsi_123180128.service;

import com.example.responsi_123180128.model.rs_rujukan.RsRujukanResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RsRujukanRepository {
    @GET("sebaran_v2/jabar/faskes")
    Call<RsRujukanResponse> getRsRujukan();
}
