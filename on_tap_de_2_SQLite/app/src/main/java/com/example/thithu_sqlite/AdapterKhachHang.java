package com.example.thithu_sqlite;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

public class AdapterKhachHang extends RecyclerView.Adapter<AdapterKhachHang.ViewHolder> {

    //bước dầu khai báo list và context
    List<KhachHang> khachHangList;
    Context context;

    public AdapterKhachHang(List<KhachHang> khachHangList, Context context) {
        this.khachHangList = khachHangList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        //bước 2
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_recyclerview, viewGroup, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder viewHolder, int i) {
        final KhachHang khachHang = khachHangList.get(i);
        if (khachHang != null) {
            viewHolder.tv_address.setText(khachHang.getAddress());
            viewHolder.tv_name.setText(khachHang.getName());
            viewHolder.tv_phoneNumber.setText(khachHang.getPhoneNumber());
        }
        viewHolder.btn_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyDatabase myDatabase = new MyDatabase(context);
                myDatabase.xoa(khachHang);

                viewHolder.layout_item.setVisibility(View.GONE);
            }
        });

    }

    @Override
    public int getItemCount() {
        //bước quan trọng
        return khachHangList == null ? 0 : khachHangList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tv_name, tv_address, tv_phoneNumber;
        Button btn_delete;
        LinearLayout layout_item;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_name = (TextView) itemView.findViewById(R.id.tv_name);
            tv_address = (TextView) itemView.findViewById(R.id.tv_address);
            tv_phoneNumber = (TextView) itemView.findViewById(R.id.tv_phoneNumber);
            btn_delete = (Button) itemView.findViewById(R.id.btn_delete);
            layout_item = (LinearLayout) itemView.findViewById(R.id.layout_item);

        }
    }
}
