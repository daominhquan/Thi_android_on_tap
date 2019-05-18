package com.example.thithu_sqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {


    // Tên cơ sở dữ liệu
    private static final String TEN_DATABASE= "QuanLyKhachHang";
    // Tên bảng
    public static final String TEN_BANG_KHACHHANG = "KhachHang";
    // Bảng gồm 3 cột _id, _ten và _lop.
    public static final String COT_ID = "_id";
    public static final String COT_TEN = "_Ten";
    public static final String COT_DIACHI = "_DiaChi";
    public static final String COT_SODIENTHOAI = "_SoDienThoai";


    private static final String TAO_BANG_KHACHHANG = ""
            + "create table " + TEN_BANG_KHACHHANG + " ( "
            + COT_ID                + " integer primary key autoincrement ,"
            + COT_TEN               + " text not null, "
            + COT_DIACHI            + " text not null, "
            + COT_SODIENTHOAI       + " text not null );";


    public DBHelper(Context context) {
        super(context, TEN_DATABASE, null, 1);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(TAO_BANG_KHACHHANG);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    /*
     * Lớp “SQLiteDatabase” dùng để hỗ trợ tương
     * tác với cơ sở dữ liệu.
     */
    SQLiteDatabase database;
    /*
     * Còn lớp “DBHelper” là lớp chúng
     * ta vừa tạo, dùng để tạo Cơ sở dữ liệu và bảng.
     */
    DBHelper helper;


}
