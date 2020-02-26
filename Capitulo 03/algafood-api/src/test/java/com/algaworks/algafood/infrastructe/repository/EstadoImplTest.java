package com.algaworks.algafood.infrastructe.repository;

import com.algaworks.algafood.domain.model.Estado;
import com.algaworks.algafood.domain.repository.EstadoRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@SpringBootTest
@RunWith(SpringRunner.class)
public class EstadoImplTest {

    @Autowired
    private EstadoRepository estadoRepository;

    @Test
    public void listar() {
        assertEquals(estadoRepository.listar().size(), 3);
    }

    @Test
    public void buscar() {
        assertEquals(estadoRepository.buscar(1L).getNome(), "Santa Catarina");
    }

    @Test
    public void salvar() {
        final Estado estado = new Estado();
        estado.setNome("Rio Grande do Sul");

        final Estado estadoSave = estadoRepository.salvar(estado);
        assertEquals(estadoSave.getNome(), "Rio Grande do Sul");
    }

    @Test
    public void remover() {
        final int qtdRegistros = estadoRepository.listar().size();

        final Estado estado = new Estado();
        estado.setId(3L);
        estadoRepository.remover(estado);

        assertEquals(estadoRepository.listar().size(), qtdRegistros - 1);
    }
}