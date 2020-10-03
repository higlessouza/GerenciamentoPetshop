package com.company;

public class Preco {
    private Boolean DiaDeSemana;
    private Double preco;
    private String tamanhoCachorro;

    public String getTamanhoCachorro() {
        return tamanhoCachorro;
    }

    public void setTamanhoCachorro(String tamanhoCachorro) {
        this.tamanhoCachorro = tamanhoCachorro;
    }

    public Boolean getDiaDeSemana() {
        return DiaDeSemana;
    }

    public void setDiaDeSemana(Boolean diaDeSemana) {
        DiaDeSemana = diaDeSemana;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }
}
