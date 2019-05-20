package com.example.hunglamthurecyclerview;

public  class Khachhang {
    String Hoten,Diachi;
    double Cstruoc,Cssau;

    public Khachhang() {
    }

    public String getHoten() {
        return Hoten;
    }

    public void setHoten(String hoten) {
        Hoten = hoten;
    }

    public String getDiachi() {
        return Diachi;
    }

    public void setDiachi(String diachi) {
        Diachi = diachi;
    }

    public double getCstruoc() {
        return Cstruoc;
    }

    public void setCstruoc(double cstruoc) {
        Cstruoc = cstruoc;
    }

    public double getCssau() {
        return Cssau;
    }

    public void setCssau(double cssau) {
        Cssau = cssau;
    }

    public Khachhang(String hoten, String diachi, double cstruoc, double cssau) {
        Hoten = hoten;
        Diachi = diachi;
        Cstruoc = cstruoc;
        Cssau = cssau;
    }
}
