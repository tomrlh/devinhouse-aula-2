package com.devinhouse.banco;

import com.devinhouse.banco.classes.Conta;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
@RestController
public class BancoApplication {
	public static List<Conta> contas = new ArrayList<>();

	public static void main(String[] args) {
		SpringApplication.run(BancoApplication.class, args);

		BancoApplication banco = new BancoApplication();

		Conta conta1 = new Conta("Thiago", 1000);
		Conta conta2 = new Conta("Guilherme", 10000);

		BancoApplication.contas.add(conta1);
		BancoApplication.contas.add(conta2);
	}

	@GetMapping("/")
	public String helloWorld() {
		return "Hello World!";
	}

	// um método para consultar o saldo de uma conta
	@GetMapping("/consultarSaldo/{nomeConta}")
	public double consultarSaldo(@PathVariable("nomeConta") String nome) {
		for(Conta conta : BancoApplication.contas) {
			System.out.println("NOME " + nome);
			System.out.println(conta.nome);
			System.out.println(conta.saldo);
			if(conta.nome.equals(nome)) {
				return conta.saldo;
			}
		}
		return 0;
	}
}
