package com.example.appuel.modal;

public class Diem {
    public int id;
    public String mahocphan;
    public String tenhocphan;
    public int tinchi;
    public int quatrinh;
    public int giuaky;
    public int cuoiky;
    public int tb;

    public Diem(int id, String mahocphan, String tenhocphan, int tinchi, int quatrinh, int giuaky, int cuoiky, int tb) {
        this.id = id;
        this.mahocphan = mahocphan;
        this.tenhocphan = tenhocphan;
        this.tinchi = tinchi;
        this.quatrinh = quatrinh;
        this.giuaky = giuaky;
        this.cuoiky = cuoiky;
        this.tb = tb;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMahocphan() {
        return mahocphan;
    }

    public void setMahocphan(String mahocphan) {
        this.mahocphan = mahocphan;
    }

    public String getTenhocphan() {
        return tenhocphan;
    }

    public void setTenhocphan(String tenhocphan) {
        this.tenhocphan = tenhocphan;
    }

    public int getTinchi() {
        return tinchi;
    }

    public void setTinchi(int tinchi) {
        this.tinchi = tinchi;
    }

    public int getQuatrinh() {
        return quatrinh;
    }

    public void setQuatrinh(int quatrinh) {
        this.quatrinh = quatrinh;
    }

    public int getGiuaky() {
        return giuaky;
    }

    public void setGiuaky(int giuaky) {
        this.giuaky = giuaky;
    }

    public int getCuoiky() {
        return cuoiky;
    }

    public void setCuoiky(int cuoiky) {
        this.cuoiky = cuoiky;
    }

    public int getTb() {
        return tb;
    }

    public void setTb(int tb) {
        this.tb = tb;
    }
}
