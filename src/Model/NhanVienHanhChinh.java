/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author PC
 */
public class NhanVienHanhChinh extends Nhanvien{
    public NhanVienHanhChinh(String maNV, String hoTen, String phongBan, double luongCoBan) {
        super(maNV, hoTen, phongBan, luongCoBan);
    }
    
    @Override
    public double tinhThuNhap() {
        return luongCoBan;
    }
}
