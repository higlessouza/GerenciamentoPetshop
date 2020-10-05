package com.company;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class GerenciamentoPetshop {
    public GerenciamentoPetshop(Date data, int cachorrosPequenos, int cachorrosGrandes) {
        setDiaDeSemana(data);
        setCachorrosGrandes(cachorrosGrandes);
        setCachorrosPequenos(cachorrosPequenos);
        petshops = new ArrayList<Petshop>();
        //Populando a lista
        PreencherDados();
    }

    private List<Petshop> petshops;
    private boolean diaDeSemana;
    private int cachorrosPequenos, cachorrosGrandes;

    // Raliza um looping nos petshops e define o melhor de acordo com preço e distância
    public Petshop ProcurarPetshop() {
        //Define o primeiro petshop da lista como o melhor petshop e calcula o orçamento.
        Petshop MelhorPetshop = petshops.get(0);
        MelhorPetshop.setOrcamento(diaDeSemana, cachorrosGrandes, cachorrosPequenos);
        try {
            for (Petshop petshop : petshops) {
                //Calcula o orçamento do petshop atual no looping
                petshop.setOrcamento(diaDeSemana, cachorrosGrandes, cachorrosPequenos);
                //se o petshop atual do looping for mais barato, ou tiver o mesmo preço e for mais perto, define ele como o "melhorPetshop"
                if (MelhorPetshop.getOrcamento() > petshop.getOrcamento()) {
                    MelhorPetshop = petshop;
                } else if (MelhorPetshop.getOrcamento() == petshop.getOrcamento() && petshop.getDistancia() < MelhorPetshop.getDistancia()) {
                    MelhorPetshop = petshop;
                }
            }
        } catch (Exception e) {
            Log.Novo("Erro ao procurar melhor Pet Shop " + e.toString());
        }
        return MelhorPetshop;
    }

    public boolean isDiaDeSemana() {
        return diaDeSemana;
    }

    //Recebe uma data por parametro e define se é dia de semana ou não
    public void setDiaDeSemana(Date data) {
        try {

            Calendar cal = Calendar.getInstance();
            cal.setTime(data);
            if ((cal.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY) || (cal.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY)) {
                this.diaDeSemana = false;
            } else {
                this.diaDeSemana = true;
            }
        } catch (Exception e) {
            Log.Novo("Erro ao verificar se o dia é util: " + e.toString());
        }
    }

    public int getCachorrosPequenos() {
        return cachorrosPequenos;
    }

    public void setCachorrosPequenos(int cachorrosPequenos) {
        this.cachorrosPequenos = cachorrosPequenos;
    }

    public int getCachorrosGrandes() {
        return cachorrosGrandes;
    }

    public void setCachorrosGrandes(int cachorrosGrandes) {
        this.cachorrosGrandes = cachorrosGrandes;
    }

    // Como não existe um banco de dados tradicional, este método preenche as informações dos pet shops em tempo de execução.
    public void PreencherDados() {
        //Meu Canino Feliz
        List<Preco> precos = new ArrayList<Preco>();
        precos.add(new Preco(true, 40.0, "Grande"));
        precos.add(new Preco(false, 48.0, "Grande"));
        precos.add(new Preco(true, 20.0, "Pequeno"));
        precos.add(new Preco(false, 24.0, "Pequeno"));
        petshops.add(new Petshop("Meu Canino Feliz", 2, precos));

        //Vai Rex
        precos = new ArrayList<Preco>();
        precos.add(new Preco(true, 50.0, "Grande"));
        precos.add(new Preco(false, 55.0, "Grande"));
        precos.add(new Preco(true, 15.0, "Pequeno"));
        precos.add(new Preco(false, 20.0, "Pequeno"));
        petshops.add(new Petshop("Vai Rex", 1.7, precos));

        //ChowChawgas
        precos = new ArrayList<Preco>();
        precos.add(new Preco(true, 45.0, "Grande"));
        precos.add(new Preco(false, 45.0, "Grande"));
        precos.add(new Preco(true, 30.0, "Pequeno"));
        precos.add(new Preco(false, 30.0, "Pequeno"));
        petshops.add(new Petshop("ChowChawgas", 0.8, precos));
    }
}