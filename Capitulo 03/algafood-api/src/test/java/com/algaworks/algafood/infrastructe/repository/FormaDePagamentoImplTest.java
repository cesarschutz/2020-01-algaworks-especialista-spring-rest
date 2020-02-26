package com.algaworks.algafood.infrastructe.repository;

import com.algaworks.algafood.domain.model.FormaDePagamento;
import com.algaworks.algafood.domain.repository.FormaDePagamentoRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@SpringBootTest
@RunWith(SpringRunner.class)
public class FormaDePagamentoImplTest {

    @Autowired
    private FormaDePagamentoRepository formaDePagamentoRepository;

    @Test
    public void listar() {
        assertEquals(formaDePagamentoRepository.listar().size(), 3);
    }

    @Test
    public void buscar() {
        assertEquals(formaDePagamentoRepository.buscar(1L).getDescricao(), "Cartão débito");
    }

    @Test
    public void salvar() {
        final FormaDePagamento formaDePagamento = new FormaDePagamento();
        formaDePagamento.setDescricao("teste");

        final FormaDePagamento formaDePagamentoSave = formaDePagamentoRepository.salvar(formaDePagamento);
        assertEquals(formaDePagamentoSave.getDescricao(), "teste");
    }

    @Test
    public void remover() {
        final int qtdRegistros = formaDePagamentoRepository.listar().size();

        final FormaDePagamento formaDePagamento = new FormaDePagamento();
        formaDePagamento.setId(3L);
        formaDePagamentoRepository.remover(formaDePagamento);

        assertEquals(formaDePagamentoRepository.listar().size(), qtdRegistros - 1);
    }
}