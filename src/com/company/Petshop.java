package com.company;

import java.text.NumberFormat;
import java.util.List;

public class Petshop {
    private double distancia;
    private String nome;
    private List<Preco> precos;
    private double orcamento;

    public Petshop(String nome, double distancia, List<Preco> precos) {
        setNome(nome);
        setDistancia(distancia);
        setPrecos(precos);
    }

    //Calcula o orçamento de acordo com os parametros inseridos pelo usuário
    public double setOrcamento(boolean diaDeSemana, int cachorrosGrandes, int cachorrosPequenos) {
        double precoTotal = 0;
        try {
            for (Preco preco : precos) {
                if (diaDeSemana == preco.getDiaDeSemana()) {
                    if (preco.getTamanhoCachorro().equals("Grande")) {
                        precoTotal += cachorrosGrandes * preco.getPreco();
                    } else if (preco.getTamanhoCachorro().equals("Pequeno")) {
                        precoTotal += cachorrosPequenos * preco.getPreco();
                    }
                }
            }
            this.orcamento = precoTotal;
        } catch (Exception e) {
            Log.Novo("Erro ao calcular orçamento. " + e.toString());
        }
        return precoTotal;
    }

    public void setPrecos(List<Preco> precos) {
        this.precos = precos;
    }

    //Retorna o orçamento formatado para visualização do usuário
    public String getOrcamentoFormatado() {
        NumberFormat formatter = NumberFormat.getCurrencyInstance();
        return formatter.format(orcamento);
    }

    public double getOrcamento() {
        return orcamento;
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
