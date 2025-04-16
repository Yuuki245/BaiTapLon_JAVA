/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package nhanvien;

/**
 *
 * @author PC
 */
public abstract class Nhanvien {

    protected String maNV;
    protected String hoTen;
    protected String phongBan;
    protected double luongCoBan;

    public Nhanvien(String maNV, String hoTen, String phongBan, double luongCoBan) {
        this.maNV = maNV;
        this.hoTen = hoTen;
        this.phongBan = phongBan;
        this.luongCoBan = luongCoBan;
    }

    // Getter, Setter
    public abstract double tinhThuNhap();

    public double tinhThue() {
        double thuNhap = tinhThuNhap();
        if (thuNhap < 9_000_000) return 0;
        else if (thuNhap <= 15_000_000) return thuNhap * 0.1;
        else return thuNhap * 0.12;
    }

    
    
}
