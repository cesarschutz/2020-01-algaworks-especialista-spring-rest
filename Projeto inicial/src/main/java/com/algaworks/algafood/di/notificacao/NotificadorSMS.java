package com.algaworks.algafood.di.notificacao;

import com.algaworks.algafood.di.modelo.Cliente;
import org.springframework.stereotype.Component;

public class NotificadorSMS implements Notificador {

	public NotificadorSMS() {
		System.out.println("contruiu Notificador sms");
	}

	@Override
	public void notificar(Cliente cliente, String mensagem) {
		System.out.printf("Notificando %s através do sms %s: %s\n",
				cliente.getNome(), cliente.getTelefone(), mensagem);
	}
	
}
