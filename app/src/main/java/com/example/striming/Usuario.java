package com.example.striming;

public class Usuario {

    private String etRegistroU;
    private String spnTipoPerfil;

    public Usuario(String etRegistroU, String spnTipoPerfil) {
        this.etRegistroU = etRegistroU;
        this.spnTipoPerfil = spnTipoPerfil;
    }

    public String getEtRegistroU() {
        return etRegistroU;
    }

    public void setEtRegistroU(String etRegistroU) {
        this.etRegistroU = etRegistroU;
    }

    public String getSpnTipoPerfil() {
        return spnTipoPerfil;
    }

    public void setSpnTipoPerfil(String spnTipoPerfil) {
        this.spnTipoPerfil = spnTipoPerfil;
    }
}
