package com.example.ctrlpc;

public class ArticulosDB {

    private String NOMBRE;
    private String DESCRIPCION;
    private String FOTO;



    private int ID_PROD;

    public ArticulosDB(int ID_PROD, String NOMBRE, String DESCRIPCION, String FOTO) {

        this.NOMBRE = NOMBRE;
        this.DESCRIPCION = DESCRIPCION;
        this.FOTO = FOTO;
        this.ID_PROD = ID_PROD;
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
