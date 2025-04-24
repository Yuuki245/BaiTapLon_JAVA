/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.regex.Pattern;

/**
 *
 * @author LTuan
 */
public class SinhVien {

    private String maSV;
    private String hoTen;
    private String email;
    private String sdt;
    private String cmnd;
    private String phongThucTap;
    private double diemDanhGia;

    public SinhVien(String maSV, String hoTen, String email, String sdt, String cmnd, String phongThucTap, double diemDanhGia) {
        this.maSV = maSV;
        this.hoTen = hoTen;
        setEmail(email);
        setSdt(sdt);
        setCmnd(cmnd);
        this.phongThucTap = phongThucTap;
        this.diemDanhGia = diemDanhGia;

    }

    public String getMaSV() {
        return maSV;
    }

    public String getHoTen() {
        return hoTen;
    }

    public String getEmail() {
        return email;
    }

    public String getSdt() {
        return sdt;
    }

    public String getCmnd() {
        return cmnd;
    }

    public String getPhongThucTap() {
        return phongThucTap;
    }

    public double getDiemDanhGia() {
        return diemDanhGia;
    }

    public void setMaSV(String maSV) {
        this.maSV = maSV;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public void setEmail(String email) {
        if (!EmailHopLe(email)) {
            throw new IllegalArgumentException("Email phải có định dạng @uneti.com");
        }
        this.email = email;
    }

    public void setSdt(String sdt) {
        if (!SdtHopLe(sdt)) {
            throw new IllegalArgumentException("SĐT phải có 10 chữ số, bắt đầu bằng 0");
        }
        this.sdt = sdt;
    }

    public void setCmnd(String cmnd) {
        if (!CmndHopLe(cmnd)) {
            throw new IllegalArgumentException("CCMND phải có 9 hoặc 12 chữ số");
        }
        this.cmnd = cmnd;
    }

    public void setPhongThucTap(String phongThucTap) {
        this.phongThucTap = phongThucTap;
    }

    public void setDiemDanhGia(double diemDanhGia) {
        this.diemDanhGia = diemDanhGia;
    }

    private boolean EmailHopLe(String email) {
        String regex = "^[a-zA-Z0-9._%+-]+@uneti\\.com$"; // 
        return Pattern.matches(regex, email);
    }

    private boolean SdtHopLe(String sdt) {
        String regex = "^0\\d{9}$";
        return Pattern.matches(regex, sdt);
    }

    private boolean CmndHopLe(String cmnd) {
        String regex = "^\\d{9}$|^\\d{12}$";
        return Pattern.matches(regex, cmnd);
    }

}
