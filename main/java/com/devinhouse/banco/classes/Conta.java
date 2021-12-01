package com.devinhouse.banco.classes;

public class Conta {
    public String nome;
    public double saldo;
    public static int totalContas;

    public Conta(String nome, double saldo) {
        this.nome = nome;
        this.saldo = saldo;
        totalContas++;
    }
}
