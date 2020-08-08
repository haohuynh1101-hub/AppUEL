package com.example.appuel.modal;

import java.util.Date;

public class LichThi {
    public int id;
    public Date ngaythi;
    public String giothi;
    public String mamonhoc;
    public String tenmonhoc;
    public String phongthi;

    public LichThi(int id, Date ngaythi, String giothi, String mamonhoc, String tenmonhoc, String phongthi) {
        this.id = id;
        this.ngaythi = ngaythi;
        this.giothi = giothi;
        this.mamonhoc = mamonhoc;
        this.tenmonhoc = tenmonhoc;
        this.phongthi = phongthi;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getNgaythi() {
        return ngaythi;
    }

    public void setNgaythi(Date ngaythi) {
        this.ngaythi = ngaythi;
    }

    public String getGiothi() {
        return giothi;
    }

    public void setGiothi(String giothi) {
        this.giothi = giothi;
    }

    public String getMamonhoc() {
        return mamonhoc;
    }

    public void setMamonhoc(String mamonhoc) {
        this.mamonhoc = mamonhoc;
    }

    public String getTenmonhoc() {
        return tenmonhoc;
    }

    public void setTenmonhoc(String tenmonhoc) {
        this.tenmonhoc = tenmonhoc;
    }

    public String getPhongthi() {
        return phongthi;
    }

    public void setPhongthi(String phongthi) {
        this.phongthi = phongthi;
    }
}
