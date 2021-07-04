package com.example.responsi_123180128.view.fragment;

import android.os.Bundle;

import com.example.responsi_123180128.R;
import com.example.responsi_123180128.adapter.KasusCovidAdapter;
import com.example.responsi_123180128.model.kasus_covid.KasusCovidDataItem;
import com.example.responsi_123180128.view.viewmodel.KasusCovidViewModel;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class KasusCovidFragment extends Fragment{
    private KasusCovidAdapter kasusCovidAdapter;
    private RecyclerView rvKasusCovid;
    private KasusCovidViewModel kasusCovidViewModel;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        kasusCovidAdapter = new KasusCovidAdapter(getContext());
        kasusCovidAdapter.notifyDataSetChanged();

        rvKasusCovid = view.findViewById(R.id.fragmentkasus_rv_main);
        rvKasusCovid.setLayoutManager(new LinearLayoutManager(getContext()));

        kasusCovidViewModel = new ViewModelProvider(this).get(KasusCovidViewModel.class);
        kasusCovidViewModel.setKasusCovidDiscover();
        kasusCovidViewModel.getKasusCovidDiscover().observe(this ,getKasusCovidDiscover);

        rvKasusCovid.setAdapter(kasusCovidAdapter);
    }

    private Observer<ArrayList<KasusCovidDataItem>> getKasusCovidDiscover = new Observer<ArrayList<KasusCovidDataItem>>() {
        @Override
        public void onChanged(ArrayList<KasusCovidDataItem> kasusCovidDataItems) {
            if(kasusCovidDataItems != null){
                kasusCovidAdapter.setData(kasusCovidDataItems);
            }
        }
    };

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_kasuscovid, container, false);
    }
}
