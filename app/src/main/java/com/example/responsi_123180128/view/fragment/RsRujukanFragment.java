package com.example.responsi_123180128.view.fragment;

import android.os.Bundle;

import com.example.responsi_123180128.R;
import com.example.responsi_123180128.adapter.RsRujukanAdapter;
import com.example.responsi_123180128.adapter.RsRujukanAdapter;
import com.example.responsi_123180128.model.rs_rujukan.RsRujukanDataItem;
import com.example.responsi_123180128.model.kasus_covid.KasusCovidDataItem;
import com.example.responsi_123180128.view.viewmodel.RsRujukanViewModel;
import com.example.responsi_123180128.view.viewmodel.KasusCovidViewModel;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class RsRujukanFragment extends Fragment{

    private RsRujukanAdapter rsRujukanAdapter;
    private RecyclerView rvRsRujukan;
    private RsRujukanViewModel rsRujukanViewModel;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        rsRujukanAdapter = new RsRujukanAdapter(getContext());
        rsRujukanAdapter.notifyDataSetChanged();

        rvRsRujukan = view.findViewById(R.id.fragmentrs_rv_main);
        rvRsRujukan.setLayoutManager(new LinearLayoutManager(getContext()));

        rsRujukanViewModel = new ViewModelProvider(this).get(RsRujukanViewModel.class);
        rsRujukanViewModel.setRsDiscover();
        rsRujukanViewModel.getRsDiscover().observe(this ,getRsRujukanDiscover);

        rvRsRujukan.setAdapter(rsRujukanAdapter);
    }

    private Observer<ArrayList<RsRujukanDataItem>> getRsRujukanDiscover = new Observer<ArrayList<RsRujukanDataItem>>() {
        @Override
        public void onChanged(ArrayList<RsRujukanDataItem> fasilitasiKesehatanDataItems) {
            if(fasilitasiKesehatanDataItems != null){
                rsRujukanAdapter.setData(fasilitasiKesehatanDataItems);
            }
        }
    };

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_rsrujukan, container, false);
    }

}
