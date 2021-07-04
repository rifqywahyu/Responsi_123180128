package com.example.responsi_123180128.adapter;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.responsi_123180128.model.rs_rujukan.RsRujukanDataItem;
import com.example.responsi_123180128.R;

import java.util.ArrayList;

public class RsRujukanAdapter extends RecyclerView.Adapter<RsRujukanAdapter.ViewHolder> {
    private ArrayList<RsRujukanDataItem> rsRujukanDataItems = new ArrayList<>();
    private Context context;

    public void setData(ArrayList<RsRujukanDataItem> items){
        rsRujukanDataItems.clear();
        rsRujukanDataItems.addAll(items);
        notifyDataSetChanged();
    }

    public RsRujukanAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public RsRujukanAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_rsrujukan,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RsRujukanAdapter.ViewHolder holder, int position) {
        holder.tv_namaRS.setText(rsRujukanDataItems.get(position).getNama());
        holder.tv_alamatRS.setText(rsRujukanDataItems.get(position).getAlamat());
        holder.btn_map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://maps.google.com/maps?q="+ rsRujukanDataItems.get(position).getAlamat()));
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return rsRujukanDataItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tv_namaRS,tv_alamatRS;
        Button btn_map;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tv_namaRS = itemView.findViewById(R.id.itemrs_tv_namars);
            tv_alamatRS = itemView.findViewById(R.id.itemrs_tv_alamat);
            btn_map = itemView.findViewById(R.id.itemrs_btn);
        }
    }
}
