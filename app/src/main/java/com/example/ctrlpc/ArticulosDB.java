package com.example.ctrlpc;

public class ArticulosDB {

    private String NOMBRE;
    private String DESCRIPCION;
    private String FOTO;



    private int PRECIO;


    private int ID_PROD;

    public ArticulosDB(int ID_PROD, int PRECIO, String NOMBRE, String DESCRIPCION, String FOTO) {

        this.NOMBRE = NOMBRE;
        this.DESCRIPCION = DESCRIPCION;
        this.FOTO = FOTO;
        this.ID_PROD = ID_PROD;
        this.PRECIO = PRECIO;
    }

    public int getPRECIO() {
        return PRECIO;
    }

    public int getID_PROD() {
        return ID_PROD;
    }

    public String getNOMBRE() {
        return NOMBRE;
    }

    public String getDESCRIPCION() {
        return DESCRIPCION;
    }

    public String getFOTO() {
        return FOTO;
    }
}
