package com.company;

public class Preco {
    private Boolean diaDeSemana;
    private Double preco;
    private String tamanhoCachorro;

    public Preco(Boolean diaDeSemana,Double preco,String tamanhoCachorro){
        setDiaDeSemana(diaDeSemana);
        setPreco(preco);
        setTamanhoCachorro(tamanhoCachorro);
    }
    public String getTamanhoCachorro() {
        return tamanhoCachorro;
    }

    public void setTamanhoCachorro(String tamanhoCachorro) {
        this.tamanhoCachorro = tamanhoCachorro;
    }

    public Boolean getDiaDeSemana() {
        return diaDeSemana;
    }

    public void setDiaDeSemana(Boolean diaDeSemana) {
        this.diaDeSemana = diaDeSemana;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }
}
