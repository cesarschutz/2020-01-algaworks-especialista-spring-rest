package com.algaworks.algafood.infrastructe.repository;

import com.algaworks.algafood.domain.model.Cozinha;
import com.algaworks.algafood.domain.repository.CozinhaRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;

@SpringBootTest
@RunWith(SpringRunner.class)
public class CozinhaRepositoryImplTest {

    @Autowired
    private CozinhaRepository cozinhaRepository;

    @Test
    public void listar() {
        assertEquals(cozinhaRepository.listar().size(), 2);
    }

    @Test
    public void buscar() {
        assertEquals(cozinhaRepository.buscar(1L).getNome(), "Tailandesa");
    }

    @Test
    public void salvar() {
        final Cozinha cozinha = new Cozinha();
        cozinha.setNome("teste");

        final Cozinha salvar = cozinhaRepository.salvar(cozinha);
        assertEquals(salvar.getNome(), "teste");
    }

    @Test
    public void remover() {
        final int qtdRegistros = cozinhaRepository.listar().size();

        final Cozinha cozinha = new Cozinha();
        cozinha.setId(1L);
        cozinhaRepository.remover(cozinha);

        assertEquals(cozinhaRepository.listar().size(), qtdRegistros - 1);
    }
}