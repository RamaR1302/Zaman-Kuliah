package com.example.kucng;

public class Model2 {

    private String id;
    private String nama;
    private String penjelasan;
    private String penanganan;


    public Model2(){}
    public Model2(String id, String nama, String penjelasan, String penanganan) {
        this.id = id;
        this.nama = nama;
        this.penjelasan = penjelasan;
        this.penanganan = penanganan;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getPenjelasan() {
        return penjelasan;
    }

    public void setPenjelasan(String penjelasan) {
        this.penjelasan = penjelasan;
    }

    public String getPenanganan() {
        return penanganan;
    }

    public void setPenanganan(String penanganan) {
        this.penanganan = penanganan;
    }
}

