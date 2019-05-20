package com.example.hunglamthurecyclerview;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class SqliteKhachHang extends SQLiteOpenHelper {

    SQLiteDatabase database;
    SqliteKhachHang helper;

    private static final String TEN_DATABASE = "QuanLyKhachHang";
    private static final String TEN_BANG = "KhachHang";
    private static final String COT_ID = "_id";
    private static final String COT_HOTEN = "_hoten";
    private static final String COT_DIACHI = "_diachi";
    private static final String COT_CSTRUOC = "_cstruoc";
    private static final String COT_CSSAU = "_cssau";
    private static final String TAO_BANG_KHACH_HANG = ""
            + " create table " + TEN_BANG + " ("
            + COT_ID + " INTEGER PRIMARY KEY autoincrement ,"
            + COT_HOTEN + " TEXT NOT NULL,"
            + COT_DIACHI + " TEXT NOT NULL,"
            + COT_CSTRUOC + " TEXT NOT NULL,"
            + COT_CSSAU + " TEXT NOT NULL)";

    public SqliteKhachHang(Context context) {
        super(context, TEN_DATABASE, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(TAO_BANG_KHACH_HANG);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public List<Khachhang> layTatCaKhachHang() {
        List<Khachhang> list = new ArrayList<>();
        String selectQuery = "SELECT  * FROM " + TEN_BANG;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                Khachhang khachhang = new Khachhang();
                khachhang.setHoten(cursor.getString(1));
                khachhang.setDiachi(cursor.getString(2));
                khachhang.setCstruoc(Double.parseDouble(cursor.getString(3)));
                khachhang.setCssau(Double.parseDouble(cursor.getString(4)));
                list.add(khachhang);

            } while (cursor.moveToNext());
        }
        return list;
    }

    public void xoa(Khachhang khachhang) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TEN_BANG, COT_HOTEN + " = ?", new String[]{khachhang.getHoten()});
        db.close();
    }

    public void add(Khachhang khachhang) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COT_HOTEN, khachhang.getHoten());
        values.put(COT_DIACHI, khachhang.getDiachi());
        values.put(COT_CSTRUOC, khachhang.getCstruoc());
        values.put(COT_CSSAU, khachhang.getCssau());
        // Trèn một dòng dữ liệu vào bảng.
        db.insert(TEN_BANG, null, values);
        // Đóng kết nối database.
        db.close();
    }
}
