package com.example.hunglamthurecyclerview;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

public class Adapterr extends RecyclerView.Adapter<Adapterr.ViewHolder> {
    List<Khachhang> list;
    Context context;
    Adapterr adapterr;
    SqliteKhachHang sqliteKhachHang;

    public void setAdapterr(Adapterr adapterr) {
        this.adapterr = adapterr;
    }

    public Adapterr(List<Khachhang> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.etim, viewGroup, false);
        ViewHolder viewHolder = new ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {

        final Khachhang khachhang = list.get(i);
        double sodientieuthu = khachhang.getCssau() - khachhang.getCstruoc();
        double dongia = tinhdongia(sodientieuthu);
        viewHolder.tv_ten.setText(khachhang.getHoten());
        viewHolder.tv_diachi.setText(khachhang.getDiachi());

        viewHolder.tv_sodientt.setText(String.valueOf(sodientieuthu));

        viewHolder.tv_thanhtien.setText(String.valueOf((sodientieuthu) * dongia + "VND"));
        viewHolder.btn_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sqliteKhachHang = new SqliteKhachHang(context);
                sqliteKhachHang.xoa(khachhang);
                list.remove(khachhang);
                adapterr.notifyDataSetChanged();
            }
        });
    }

    private double tinhdongia(double cs) {
        if (cs > 0 && cs <= 50) {
            return 1.549;
        } else if (cs > 50 && cs <= 100) {
            return 1.600;
        } else if (cs > 100 && cs <= 200) {
            return 1.858;
        } else if (cs > 200 && cs <= 300) {
            return 2.340;
        } else if (cs > 300 && cs <= 400) {
            return 2.615;
        } else if (cs > 400) {
            return 2.701;
        }

        return 0;
    }

    @Override
    public int getItemCount() {

        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tv_diachi, tv_ten, tv_sodientt, tv_thanhtien;
        Button btn_delete;

        public ViewHolder(@NonNull View itemView) {

            super(itemView);
            tv_diachi = (TextView) itemView.findViewById(R.id.tv_diachi);
            tv_ten = (TextView) itemView.findViewById(R.id.tv_ten);
            tv_sodientt = (TextView) itemView.findViewById(R.id.tv_sodientt);
            tv_thanhtien = (TextView) itemView.findViewById(R.id.tv_thanhtien);
            btn_delete = (Button) itemView.findViewById(R.id.btn_delete);
        }
    }
}
