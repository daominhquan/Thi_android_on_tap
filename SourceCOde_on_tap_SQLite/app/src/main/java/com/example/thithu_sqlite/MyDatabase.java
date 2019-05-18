package com.example.thithu_sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

public class MyDatabase {
    SQLiteDatabase database;
    DBHelper helper;

    public MyDatabase(Context context) {
        helper = new DBHelper(context);
        database = helper.getWritableDatabase();
    }

    public List<KhachHang> layTatCaDuLieu() {
        List<KhachHang> khachHangList = new ArrayList<KhachHang>();
        String[] cot = {
                DBHelper.COT_ID,
                DBHelper.COT_TEN,
                DBHelper.COT_DIACHI,
                DBHelper.COT_SODIENTHOAI
        };
        Cursor cursor = null;
        cursor = database.query(DBHelper.
                        TEN_BANG_KHACHHANG, cot, null, null, null, null,
                DBHelper.COT_ID + " DESC");

        // Duyệt trên con trỏ, và thêm vào danh sách.
        if (cursor.moveToFirst()) {
            do {
                KhachHang khachHang = new KhachHang();
                khachHang.setName(cursor.getString(1));
                khachHang.setAddress(cursor.getString(2));
                khachHang.setPhoneNumber(cursor.getString(3));

                // Thêm vào danh sách.
                khachHangList.add(khachHang);
            } while (cursor.moveToNext());
        }


        return khachHangList;

    }

    public long them(KhachHang khachHang) {
        ContentValues values = new ContentValues();
        values.put(DBHelper.COT_TEN, khachHang.getName());
        values.put(DBHelper.COT_DIACHI, khachHang.getAddress());
        values.put(DBHelper.COT_SODIENTHOAI, khachHang.getPhoneNumber());
        return database.insert(DBHelper.
                TEN_BANG_KHACHHANG, null, values);
    }

    public long xoa(KhachHang khachHang) {
        /*
         * Tương tự cho xóa một dòng dữ liệu cần
         * 3 đối số là tên bảng, câu điều kiện và
         * cuối cùng là đối số cho câu điều kiện
         * nhưng có thể gộp 2 đối số làm 1 như ở
         * dưới.
         */
        return database.delete(DBHelper
                .TEN_BANG_KHACHHANG, DBHelper
                .COT_TEN + " = " + "'" +
                khachHang.getName() + "'", null);
    }

    public long sua(KhachHang khachHang) {
        ContentValues values = new ContentValues();
        values.put(DBHelper.COT_TEN, khachHang.getName());
        values.put(DBHelper.COT_DIACHI, khachHang.getAddress());
        values.put(DBHelper.COT_SODIENTHOAI, khachHang.getPhoneNumber());
        return database.update(DBHelper
                        .TEN_BANG_KHACHHANG, values,
                DBHelper.COT_TEN + " = "
                        + khachHang.getName(), null);
    }

}
