/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Model;

/**
 *
 * @author PC
 */
public abstract class Nhanvien {

    private String maNV;
    protected String hoTen;
    protected String phongBan;
    protected double luongCoBan;

    public Nhanvien(String maNV, String hoTen, String phongBan, double luongCoBan) {
        this.maNV = maNV;
        this.hoTen = hoTen;
        this.phongBan = phongBan;
        this.luongCoBan = luongCoBan;
    }

    public String getMaNV() {
        return maNV;
    }

    public String getHoTen() {
        return hoTen;
    }

    public String getPhongBan() {
        return phongBan;
    }

    public double getLuongCoBan() {
        return luongCoBan;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public void setPhongBan(String phongBan) {
        this.phongBan = phongBan;
    }

    public void setLuongCoBan(double luongCoBan) {
        this.luongCoBan = luongCoBan;
    }

    
    public abstract double tinhThuNhap();

    public double tinhThue() {
        double thuNhap = tinhThuNhap();
        if (thuNhap < 9_000_000) return 0;
        else if (thuNhap <= 15_000_000) return thuNhap * 0.1;
        else return thuNhap * 0.12;
    }

    
    
}
