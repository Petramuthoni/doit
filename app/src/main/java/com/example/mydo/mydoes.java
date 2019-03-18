package com.example.mydo;

public class mydoes {
    String titleDoes;
    String dateDoes;
    String descDoes;

    public String getKeyDoes() {
        return keyDoes;
    }

    public void setKeyDoes(String keyDoes) {
        this.keyDoes = keyDoes;
    }

    String keyDoes;
    public mydoes() {
    }

    public mydoes(String titleDoes, String dateDoes, String descDoes, String keyDoes) {
        this.titleDoes = titleDoes;
        this.dateDoes = dateDoes;
        this.descDoes = descDoes;
        this.keyDoes = keyDoes;

    }

    public mydoes(String titledoes, String datedoes, String descdoes) {

    }

    public String getTitledoes() {
        return titledoes;
    }

    public void setTitledoes(String titledoes) {
        this.titledoes = titledoes;
    }

    public String getDatedoes() {
        return datedoes;
    }

    public void setDatedoes(String datedoes) {
        this.datedoes = datedoes;
    }

    public String getDescdoes() {
        return descdoes;
    }

    public void setDescdoes(String descdoes) {
        this.descdoes = descdoes;
    }

    String titledoes,datedoes,descdoes;

}
