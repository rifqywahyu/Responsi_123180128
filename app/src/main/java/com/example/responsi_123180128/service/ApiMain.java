package com.example.responsi_123180128.service;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiMain {

    private Retrofit retrofit;

    public RsRujukanRepository getApiRsRujukan(){
        String BASE_URL = "https://covid19-public.digitalservice.id/api/v1/";
        if(retrofit==null){
            retrofit = new Retrofit
                    .Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit.create(RsRujukanRepository.class);
    }

    public KasusCovidRepository getApiKasusCovid(){
        String BASE_URL = "https://covid19-public.digitalservice.id/api/v1/";
        if(retrofit==null){
            retrofit = new Retrofit
                    .Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit.create(KasusCovidRepository.class);
    }

}
