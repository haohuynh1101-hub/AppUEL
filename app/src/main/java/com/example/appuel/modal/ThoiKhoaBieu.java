package com.example.appuel.modal;

public class ThoiKhoaBieu {
    public int Id;
    public String tenmonhoc;
    public String thoigian;
    public String phong;
    public int ngayhoc;

    public ThoiKhoaBieu(int id, String tenmonhoc, String thoigian, String phong, int ngayhoc) {
        Id = id;
        this.tenmonhoc = tenmonhoc;
        this.thoigian = thoigian;
        this.phong = phong;
        this.ngayhoc = ngayhoc;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getTenmonhoc() {
        return tenmonhoc;
    }

    public void setTenmonhoc(String tenmonhoc) {
        this.tenmonhoc = tenmonhoc;
    }

    public String getThoigian() {
        return thoigian;
    }

    public void setThoigian(String thoigian) {
        this.thoigian = thoigian;
    }

    public String getPhong() {
        return phong;
    }

    public void setPhong(String phong) {
        this.phong = phong;
    }

    public int getNgayhoc() {
        return ngayhoc;
    }

    public void setNgayhoc(int ngayhoc) {
        this.ngayhoc = ngayhoc;
    }
}
