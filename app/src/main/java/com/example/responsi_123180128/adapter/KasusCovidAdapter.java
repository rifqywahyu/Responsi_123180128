package com.example.responsi_123180128.adapter;

import com.example.responsi_123180128.model.kasus_covid.KasusCovidDataItem;
import com.example.responsi_123180128.R;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class KasusCovidAdapter extends RecyclerView.Adapter<KasusCovidAdapter.ViewHolder> {
    private ArrayList<KasusCovidDataItem> kasusCovidItem = new ArrayList<>();
    private Context context;

    public void setData(ArrayList<KasusCovidDataItem> items){
        kasusCovidItem.clear();
        kasusCovidItem.addAll(items);
        notifyDataSetChanged();
    }

    public KasusCovidAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_kasuscovid,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.tv_tanggal.setText(kasusCovidItem.get(position).getTanggal()+"");
        holder.tv_terkonfirmasi.setText("Terkonfimasi : "+kasusCovidItem.get(position).getConfirmationDiisolasi()+"");
        holder.tv_sembuh.setText("Sembuh : "+kasusCovidItem.get(position).getConfirmationSelesai()+"");
        holder.tv_meninggal.setText("Meninggal : "+kasusCovidItem.get(position).getConfirmationMeninggal()+"");
    }

    @Override
    public int getItemCount() {
        return kasusCovidItem.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tv_tanggal,tv_terkonfirmasi,tv_sembuh,tv_meninggal;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tv_tanggal = itemView.findViewById(R.id.itemkasus_tv_tanggal);
            tv_terkonfirmasi = itemView.findViewById(R.id.itemkasus_tv_konfirmasi);
            tv_sembuh = itemView.findViewById(R.id.itemkasus_tv_sembuh);
            tv_meninggal = itemView.findViewById(R.id.itemkasus_tv_meninggal);
        }
    }
}
