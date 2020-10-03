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

    public Petshop ProcurarPetshop() {
        Petshop MelhorPetshop = petshops.get(0);
        MelhorPetshop.setOrcamento(diaDeSemana, cachorrosGrandes, cachorrosPequenos);
        for (Petshop petshop : petshops) {
            petshop.setOrcamento(diaDeSemana, cachorrosGrandes, cachorrosPequenos);
            if (MelhorPetshop.getOrcamento() > petshop.getOrcamento()) {
                MelhorPetshop = petshop;
            } else if (MelhorPetshop.getOrcamento()  == petshop.getOrcamento() && petshop.getDistancia() < MelhorPetshop.getDistancia()) {
                MelhorPetshop = petshop;
            }
        }
        return MelhorPetshop;
    }

    public boolean isDiaDeSemana() {
        return diaDeSemana;
    }

    public void setDiaDeSemana(Date data) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(data);
        if ((cal.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY) || (cal.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY)) {
            this.diaDeSemana = false;
        } else {
            this.diaDeSemana = true;
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

    public void PreencherDados() {
        //Meu Canino Feliz
        List<Preco> precos = new ArrayList<Preco>();
        precos.add(new Preco(true, 40.0, "Grande"));
        precos.add(new Preco(false, 48.0, "Grande"));
        precos.add(new Preco(true, 20.0, "Pequeno"));
        precos.add(new Preco(false, 24.0, "Pequeno"));
        petshops.add(new Petshop("Meu Canino Feliz",2,precos));

        //Vai Rex
        precos = new ArrayList<Preco>();
        precos.add(new Preco(true, 50.0, "Grande"));
        precos.add(new Preco(false, 55.0, "Grande"));
        precos.add(new Preco(true, 15.0, "Pequeno"));
        precos.add(new Preco(false, 20.0, "Pequeno"));
        petshops.add(new Petshop("Vai Rex",1.7,precos));

        //ChowChawgas
        precos = new ArrayList<Preco>();
        precos.add(new Preco(true, 45.0, "Grande"));
        precos.add(new Preco(false, 45.0, "Grande"));
        precos.add(new Preco(true, 30.0, "Pequeno"));
        precos.add(new Preco(false, 30.0, "Pequeno"));
        petshops.add(new Petshop("Vai Rex",0.8,precos));
    }
}
