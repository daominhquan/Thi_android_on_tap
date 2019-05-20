package com.example.thithu_sqlite;

import android.content.Context;
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
    EditText edt_name, edt_phonenumber;
    Spinner edt_address;
    Button btn_save;
    RecyclerView rv_khachhang;
    AdapterKhachHang adapterKhachHang;
    List<KhachHang> list;
    MyDatabase myDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edt_name = (EditText) findViewById(R.id.edt_name);
        edt_phonenumber = (EditText) findViewById(R.id.edt_phonenumber);
        edt_address = (Spinner) findViewById(R.id.edt_address);
        btn_save = (Button) findViewById(R.id.btn_save);
        rv_khachhang = (RecyclerView) findViewById(R.id.rv_khachhang);
        myDatabase = new MyDatabase(this);
        list = myDatabase.layTatCaDuLieu();
        adapterKhachHang = new AdapterKhachHang(list, this);
        rv_khachhang.setAdapter(adapterKhachHang);
        final Context context;
        context = this;

        List<String> listItem_Spinner = new ArrayList<String>();
        listItem_Spinner.add("Quận Bình Tân");
        listItem_Spinner.add("Quận 10");
        listItem_Spinner.add("Quận 1");
        listItem_Spinner.add("Quận 5");
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this,R.layout.support_simple_spinner_dropdown_item, listItem_Spinner);
        edt_address.setAdapter(arrayAdapter);


        btn_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (edt_name.getText().toString().equals("")) {
                    edt_name.setError("thiếu thiếu tên");
                    return;
                }
                if (edt_phonenumber.getText().toString().equals("")) {
                    edt_phonenumber.setError("thiếu số điện thoại");
                    return;
                }
                if (edt_address.getSelectedItem().toString().equals("")) {
                    Toast.makeText(context, "chưa chọn địa chỉ", Toast.LENGTH_SHORT).show();
                    return;
                }
                KhachHang khachHang = new KhachHang();
                khachHang.setAddress(edt_address.getSelectedItem().toString());
                khachHang.setName(edt_name.getText().toString());
                khachHang.setPhoneNumber(edt_phonenumber.getText().toString());
                myDatabase.them(khachHang);
                list = myDatabase.layTatCaDuLieu();
                adapterKhachHang = new AdapterKhachHang(list, context);
                rv_khachhang.setAdapter(adapterKhachHang);

                edt_address.setSelected(false);
                edt_name.setText("");
                edt_phonenumber.setText("");
            }
        });


    }

}
