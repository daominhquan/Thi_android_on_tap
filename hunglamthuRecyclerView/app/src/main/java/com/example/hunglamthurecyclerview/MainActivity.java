package com.example.hunglamthurecyclerview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    EditText edt_hoten, edt_cstruoc, edt_cssau;
    Spinner edt_diachi;
    Button btn_tinh, btn_xoa;
    RecyclerView rcv;
    Adapterr adapterr;
    List<Khachhang> list;
    SqliteKhachHang sqliteKhachHang;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rcv = (RecyclerView) findViewById(R.id.rcv);
        edt_hoten = (EditText) findViewById(R.id.edt_hoten);
        edt_diachi = (Spinner) findViewById(R.id.edt_diachi);
        edt_cssau = (EditText) findViewById(R.id.edt_cssau);
        edt_cstruoc = (EditText) findViewById(R.id.edt_cstruoc);
        btn_tinh = (Button) findViewById(R.id.btn_tinh);
        btn_xoa = (Button) findViewById(R.id.btn_xoa);
        sqliteKhachHang = new SqliteKhachHang(this);


        list = sqliteKhachHang.layTatCaKhachHang();


        adapterr = new Adapterr(list, this);
        rcv.setAdapter(adapterr);
        adapterr.setAdapterr(adapterr);
        btn_tinh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (kiemtra()) {
                    Khachhang khachhang = new Khachhang();
                    khachhang.setHoten(edt_hoten.getText().toString());
                    khachhang.setDiachi(edt_diachi.getSelectedItem().toString());
                    khachhang.setCssau(Double.parseDouble(edt_cssau.getText().toString()));
                    khachhang.setCstruoc(Double.parseDouble(edt_cstruoc.getText().toString()));
                    list.add(khachhang);
                    sqliteKhachHang.add(khachhang);
                    adapterr.notifyDataSetChanged();
                    Toast.makeText(MainActivity.this, "thêm thành công !", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, "thêm thất bại !", Toast.LENGTH_SHORT).show();

                }
            }
        });
        btn_xoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                list.clear();
                adapterr.notifyDataSetChanged();
                Toast.makeText(MainActivity.this, "đã clear thành công", Toast.LENGTH_SHORT).show();
            }
        });

        List<String> list_item_spinner = new ArrayList<String>();
        list_item_spinner.add("Quận 10");
        list_item_spinner.add("Quận 1");
        list_item_spinner.add("Quận 2");
        list_item_spinner.add("Quận Bình Tân");
        list_item_spinner.add("Quận Tân Phú");
        ArrayAdapter<String> spinnerAdapter = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item, list_item_spinner);
        edt_diachi.setAdapter(spinnerAdapter);
    }

    private boolean kiemtra() {
        if (edt_hoten.getText().toString().isEmpty()) {
            edt_hoten.setError("thieu ho ten");
            return false;
        } else if (edt_diachi.getSelectedItem().toString().isEmpty()) {
            Toast.makeText(this, "Thiếu Địa Chỉ", Toast.LENGTH_SHORT).show();
            return false;
        } else if (edt_cstruoc.getText().toString().isEmpty()) {
            edt_cstruoc.setError("thieu cs truoc");
            return false;
        } else if (edt_cssau.getText().toString().isEmpty()) {
            edt_cssau.setError("thieu cs sau");
            return false;
        } else if (Double.parseDouble(edt_cssau.getText().toString()) < Double.parseDouble(edt_cstruoc.getText().toString())) {

            edt_cssau.setError("cs sau khong dc be hon cs truoc");
            return false;
        }

        return true;
    }

}
