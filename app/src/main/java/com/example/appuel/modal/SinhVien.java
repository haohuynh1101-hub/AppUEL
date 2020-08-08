package com.example.appuel.modal;

import java.io.Serializable;
import java.util.Date;

public class SinhVien implements Serializable {
    public int id;
    public String ten;
    public String mssv;
    public String img;
    public Date date;
    public String lop;
    public String address;
    public String email;

    public SinhVien(int id, String ten, String mssv, String img, Date date, String lop, String address, String email) {
        this.id = id;
        this.ten = ten;
        this.mssv = mssv;
        this.img = img;
        this.date = date;
        this.lop = lop;
        this.address = address;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getMssv() {
        return mssv;
    }

    public void setMssv(String mssv) {
        this.mssv = mssv;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getLop() {
        return lop;
    }

    public void setLop(String lop) {
        this.lop = lop;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
