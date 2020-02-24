package com.algaworks.algafood.di.service;

import com.algaworks.algafood.di.modelo.Cliente;
import com.algaworks.algafood.di.notificacao.NivelUrgencia;
import com.algaworks.algafood.di.notificacao.Notificador;
import com.algaworks.algafood.di.notificacao.TipoDoNotificador;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AtivacaoClienteService {

    @TipoDoNotificador(NivelUrgencia.SEM_URGENCIA)
    @Autowired
    private List<Notificador> notificadores;

    public void ativar(Cliente cliente) {
        cliente.ativar();
        notificadores.forEach(notificador -> {
            notificador.notificar(
                    cliente,
                    "Seu cadastro no sistema está ativo!");
        });
    }
}
