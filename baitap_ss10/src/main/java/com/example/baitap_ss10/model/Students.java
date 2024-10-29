package com.example.baitap_ss10.model;

public class Students {
    private String mahocvien;
    private String tenhoctien;
    private String gioitinh;
    private int diemso;

    public Students(String mahocvien, String tenhoctien, String gioitinh, int diemso) {
        this.mahocvien = mahocvien;
        this.tenhoctien = tenhoctien;
        this.gioitinh = gioitinh;
        this.diemso = diemso;
    }

    public String getMahocvien() {
        return mahocvien;
    }

    public void setMahocvien(String mahocvien) {
        this.mahocvien = mahocvien;
    }

    public String getTenhoctien() {
        return tenhoctien;
    }

    public void setTenhoctien(String tenhoctien) {
        this.tenhoctien = tenhoctien;
    }

    public String getGioitinh() {
        return gioitinh;
    }

    public void setGioitinh(String gioitinh) {
        this.gioitinh = gioitinh;
    }

    public int getDiemso() {
        return diemso;
    }

    public void setDiemso(int diemso) {
        this.diemso = diemso;
    }
}

