package com.example.thi_thu;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;

import java.util.List;

public class AdapterSo extends RecyclerView.Adapter<AdapterSo.ViewHolder> {
    List<String> list;
    Context context;

    public AdapterSo(List<String> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_recyclerview, viewGroup, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        String so = list.get(i);
        if (lasoInterger(so)){
            viewHolder.item_btn.setText(so);
            if (Integer.parseInt(so) % 2 == 0) {
                //nếu là chẵn
                viewHolder.btn_left.setVisibility(View.GONE);
                viewHolder.btn_right.setVisibility(View.INVISIBLE);
                viewHolder.item_btn.setBackgroundColor(context.getResources().getColor(R.color.green));
            } else {
                //nếu là lẻ
                viewHolder.btn_left.setVisibility(View.INVISIBLE);
                viewHolder.btn_right.setVisibility(View.GONE);
                viewHolder.item_btn.setBackgroundColor(context.getResources().getColor(R.color.red));
            }
        }

    }

    private boolean lasoInterger(String so) {
        try {
            Integer.parseInt(so);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private Button item_btn,btn_left,btn_right;
        private RelativeLayout rlt;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            btn_left= (Button) itemView.findViewById(R.id.btn_left);
            btn_right= (Button) itemView.findViewById(R.id.btn_right);
            item_btn = (Button) itemView.findViewById(R.id.item_btn);
            rlt = (RelativeLayout) itemView.findViewById(R.id.rlt);
        }
    }
}
