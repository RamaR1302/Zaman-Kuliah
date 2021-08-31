package com.example.kucng;

public class Model {
    private String id;
    private String nama;
    private String asal;
    private String penjelasan;
    private String foto;

    public Model(){}

    public Model(String id, String nama, String asal, String penjelasan, String foto) {
        this.id = id;
        this.nama = nama;
        this.asal = asal;
        this.foto = foto;
        this.penjelasan = penjelasan;
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

    public String getAsal() {
        return asal;
    }

    public void setAsal(String asal) {
        this.asal = asal;
    }

    public String getPenjelasan() {
        return penjelasan;
    }

    public void setPenjelasan(String penjelasan) {
        this.penjelasan = penjelasan;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }
}
