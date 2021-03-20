package com.example.ctrlpc;

public class CuentaBD {


    public CuentaBD(String EMAIL, String NOMBRES, String APELLIDOS) {
        this.EMAIL = EMAIL;
        this.NOMBRES = NOMBRES;
        this.APELLIDOS = APELLIDOS;
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

    private String  EMAIL,NOMBRES,APELLIDOS;
}
