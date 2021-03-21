package com.example.ctrlpc;

public class CuentaBD {


    public CuentaBD(int ID_CLIENT, String EMAIL, String NOMBRES, String APELLIDOS) {
        this.EMAIL = EMAIL;
        this.NOMBRES = NOMBRES;
        this.APELLIDOS = APELLIDOS;
        this.ID_CLIENT = ID_CLIENT;
    }

    public String getEMAIL() {
        return EMAIL;
    }

    public String getNOMBRES() {
        return NOMBRES;
    }

    public String getAPELLIDOS() {
        return APELLIDOS;
    }

    private String  EMAIL;
    private String NOMBRES;
    private String APELLIDOS;

    public int getID_CLIENT() {
        return ID_CLIENT;
    }

    private int ID_CLIENT;

}
