package com.example.thi_thu;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    EditText input_so;
    Button btn_so;
    RecyclerView rv_so;
    AdapterSo adapterSo;
    List<String> list;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        input_so = (EditText) findViewById(R.id.input_so);
        btn_so = (Button) findViewById(R.id.btn_so);
        rv_so = (RecyclerView) findViewById(R.id.rv_so);
        list = new ArrayList<String>();
        context = this;


        adapterSo = new AdapterSo(list, context);
        rv_so.setAdapter(adapterSo);

        btn_so.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String number = input_so.getText().toString();
                if (!number.isEmpty()) {
                    //list = new ArrayList<String>();
                    for(String item : number.split(",")){
                        list.add(item);
                        adapterSo.notifyDataSetChanged();
                    }

                }

            }
        });



    }
}
