package com.company;

import java.text.NumberFormat;
import java.util.Date;

public class Main {

    public static void main(String[] args) {
        // write your code here
        GerenciamentoPetshop gerenciamentoPetshop = new GerenciamentoPetshop(new Date("03/08/2018"), 3, 5);
        Petshop petshop = gerenciamentoPetshop.ProcurarPetshop();
        System.out.println("O canil mais adequado é o " + petshop.getNome() + " com o preço de " + petshop.getOrcamentoFormatado());
    }
}
