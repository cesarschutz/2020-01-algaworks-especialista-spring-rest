package com.algaworks.algafood.infrastructe.repository;

import com.algaworks.algafood.domain.model.Cidade;
import com.algaworks.algafood.domain.model.Estado;
import com.algaworks.algafood.domain.repository.CidadeRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@SpringBootTest
@RunWith(SpringRunner.class)
public class CidadeRepositoryImplTest {

    @Autowired
    private CidadeRepository cidadeRepository;

    @Test
    public void listar() {
        assertEquals(cidadeRepository.listar().size(), 3);
    }

    @Test
    public void buscar() {
        assertEquals(cidadeRepository.buscar(1L).getNome(), "Florianópolis");
    }

    @Test
    public void salvar() {
        final Estado estado = new Estado();
        estado.setId(1L);

        final Cidade cidade = new Cidade();
        cidade.setNome("Guarda do Embaú");
        cidade.setEstado(estado);

        final Cidade cidadeSave = cidadeRepository.salvar(cidade);
        assertEquals(cidadeSave.getNome(), "Guarda do Embaú");
    }

    @Test
    public void remover() {
        final int qtdRegistros = cidadeRepository.listar().size();

        final Cidade cidade = new Cidade();
        cidade.setId(3L);
        cidadeRepository.remover(cidade);

        assertEquals(cidadeRepository.listar().size(), qtdRegistros - 1);
    }
}