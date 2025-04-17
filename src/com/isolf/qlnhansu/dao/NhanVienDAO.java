/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.isolf.qlnhansu.dao;

import java.util.*;

public class NhanVienDAO {
    private List<Nhanvien> danhSach = new ArrayList<>();

    // CREATE
    public void them(Nhanvien nv) {
        danhSach.add(nv);
    }

    // READ - hiển thị
    public void hienThi() {
        for (Nhanvien nv : danhSach) {
            System.out.println("Mã NV: " + nv.maNV + ", Họ tên: " + nv.hoTen + 
                ", Phòng ban: " + nv.phongBan + ", Thu nhập: " + nv.tinhThuNhap() +
                ", Thuế: " + nv.tinhThue());
        }
    }

    // UPDATE
    public boolean sua(String maNV, Nhanvien nvMoi) {
        for (int i = 0; i < danhSach.size(); i++) {
            if (danhSach.get(i).maNV.equalsIgnoreCase(maNV)) {
                danhSach.set(i, nvMoi);
                return true;
            }
        }
        return false;
    }

    // DELETE
    public boolean xoa(String maNV) {
        return danhSach.removeIf(nv -> nv.maNV.equalsIgnoreCase(maNV));
    }

    // SEARCH by mã hoặc tên
    public Nhanvien timTheoMa(String maNV) {
        for (Nhanvien nv : danhSach) {
            if (nv.maNV.equalsIgnoreCase(maNV)) return nv;
        }
        return null;
    }

    public List<Nhanvien> timTheoTen(String ten) {
        List<Nhanvien> ketQua = new ArrayList<>();
        for (Nhanvien nv : danhSach) {
            if (nv.hoTen.toLowerCase().contains(ten.toLowerCase())) {
                ketQua.add(nv);
            }
        }
        return ketQua;
    }

    // SORT by thu nhập
    public void sapXepTheoThuNhap() {
        danhSach.sort(Comparator.comparingDouble(Nhanvien::tinhThuNhap).reversed());
    }

    // SORT by tên
    public void sapXepTheoTen() {
        danhSach.sort(Comparator.comparing(nv -> nv.hoTen));
    }

    public List<Nhanvien> getDanhSach() {
        return danhSach;
    }
}

