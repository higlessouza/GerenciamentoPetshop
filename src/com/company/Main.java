package com.company;

import java.io.IOException;
import java.text.DateFormat;
import java.text.NumberFormat;
import java.util.Date;

public class Main {
    static Date inputData;
    static int cachorrosPequenos, cachorrosGrandes;
    static DateFormat formataData;

    public static void IniciarParamentros() {
        inputData = new Date();
        cachorrosPequenos = 0;
        cachorrosGrandes = 0;
        formataData = DateFormat.getDateInstance();
        formataData.setLenient(false);
    }

    //Menu para interação com o usuário
    //Caso exista algum erro nos paramentros inseridos pelo usuário, este metodo é chamado para o usuário inserir as informações novamente
    public static void Menu() {
        System.out.println(" ");
        System.out.println("Digite a data desejada no formato DD/MM/AAAA:");
        try {
            inputData = formataData.parse(System.console().readLine());
        } catch (Exception e) {
            Log.Novo("Ocorreu um erro ao tentar converter a data, por favor, tente novamente!");
            Menu();
        }
        try {
            System.out.println("Digite a quantidade de cães pequenos");
            cachorrosPequenos = Integer.parseInt(System.console().readLine());

            System.out.println("Digite a quantidade de cães grandes");
            cachorrosGrandes = Integer.parseInt(System.console().readLine());

            if (cachorrosPequenos < 0 || cachorrosGrandes < 0) {
                Log.Novo("Não é possivel ter o numero de cachorros menor que 0. Por favor, tente novamente!");
                Menu();
            }
        } catch (Exception e) {
            Log.Novo("Ocorreu um erro ao tentar converter a quantidade de cães, por favor, tente novamente!");
            Menu();
        }
    }

    public static void main(String[] args) {
        IniciarParamentros();
        System.out.println("-------------------------------------");
        System.out.println("Canil - DTI");
        System.out.println("-------------------------------------");

        if (args.length == 3) {
            try {
                inputData = formataData.parse(args[0]);
                cachorrosPequenos = Integer.parseInt(args[1]);
                cachorrosGrandes = Integer.parseInt(args[2]);
            } catch (NumberFormatException e) {
                Log.Novo("Ocorreu um erro ao tentar converter a quantidade de cães, por favor, tente novamente!");
                Menu();
            } catch (Exception e) {
                Log.Novo("Ocorreu um erro ao verificar paramentros, por favor, tente novamente!");
                Menu();
            } finally {
                if (cachorrosPequenos < 0 || cachorrosGrandes < 0) {
                    Log.Novo("Não é possivel ter o numero de cachorros menor que 0. Por favor, tente novamente!");
                    Menu();
                }
            }
        } else {
            Log.Novo("Não foram encontrados parâmetros de entrada, por favor, insira as informações solicitadas abaixo.");
            Menu();
        }
        if (cachorrosPequenos + cachorrosGrandes == 0) {
            Log.Novo("A quantidade total de cães selecionados foi 0. Por favor, tente novamente..");
            Menu();
        }
        GerenciamentoPetshop gerenciamentoPetshop = new GerenciamentoPetshop(inputData, cachorrosPequenos, cachorrosGrandes);
        Petshop petshop = gerenciamentoPetshop.ProcurarPetshop();
        System.out.println("O canil mais adequado na data " + formataData.format(inputData) + " é o " + petshop.getNome() + " com o preço de " + petshop.getOrcamentoFormatado() + ".");
    }
}

