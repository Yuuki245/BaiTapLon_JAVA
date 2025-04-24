/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author PC
 */
public class NhanVienTiepThi extends Nhanvien {
    private double doanhSo;
    private double hoaHong;

    public NhanVienTiepThi(String maNV, String hoTen, String phongBan, double luongCoBan, double doanhSo, double hoaHong) {
        super(maNV, hoTen, phongBan, luongCoBan);
        this.doanhSo = doanhSo;
        this.hoaHong = hoaHong;
    }

    public double getDoanhSo() {
        return doanhSo;
    }

    public double getHoaHong() {
        return hoaHong;
    }

    public void setDoanhSo(double doanhSo) {
        this.doanhSo = doanhSo;
    }

    public void setHoaHong(double hoaHong) {
        this.hoaHong = hoaHong;
    }
    
    
    @Override
    public double tinhThuNhap() {
        return luongCoBan + doanhSo * hoaHong;
    }
}
