/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package nhanvien;

/**
 *
 * @author PC
 */
public class TruongPhong extends Nhanvien {
    private double luongTrachNhiem; 

    public TruongPhong(String maNV, String hoTen, String phongBan, double luongCoBan, double luongTrachNhiem) {
        super(maNV, hoTen, phongBan, luongCoBan);
        this.luongTrachNhiem = luongTrachNhiem;
    }

    @Override
    public double tinhThuNhap() {
        return luongCoBan + luongTrachNhiem;
    }
}