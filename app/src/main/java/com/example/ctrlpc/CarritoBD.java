package com.example.ctrlpc;

public class CarritoBD {

    public CarritoBD(String NOMBRE, String DESCRIPCION, String FOTO, String PRECIO, int ID_PROD) {
        this.NOMBRE = NOMBRE;
        this.DESCRIPCION = DESCRIPCION;
        this.FOTO = FOTO;
        this.PRECIO = PRECIO;
        this.ID_PROD = ID_PROD;
    }

    private String NOMBRE;
    private String DESCRIPCION;

    public String getNOMBRE() {
        return NOMBRE;
    }

    public String getDESCRIPCION() {
        return DESCRIPCION;
    }

    public String getFOTO() {
        return FOTO;
    }

    public String getPRECIO() {
        return PRECIO;
    }

    public int getID_PROD() {
        return ID_PROD;
    }

    private String FOTO;



    private String PRECIO;


    private int ID_PROD;


}