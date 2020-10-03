package com.company;

import java.util.List;

public class Petshop {
    private double distancia;
    private String nome;
    private List<Preco> precos;

    public double GetPreco(boolean diaDeSemana, int cachorrosGrandes, int cachorrosPequenos) {
        double precoTotal = 0;
        for (Preco preco : precos) {
            if (preco.getTamanhoCachorro().equals("Grande")) {
                precoTotal += cachorrosGrandes * preco.getPreco();
            } else if (preco.getTamanhoCachorro().equals("Pequeno")) {
                precoTotal += cachorrosPequenos * preco.getPreco();
            }
        }
        return precoTotal;
    }

    public double getDistancia() {
        return distancia;
    }

    public void setDistancia(double distancia) {
        this.distancia = distancia;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
