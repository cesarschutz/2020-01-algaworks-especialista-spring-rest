package com.algaworks.algafood.infrastructe.repository;

import com.algaworks.algafood.domain.model.Permissao;
import com.algaworks.algafood.domain.repository.PermissaoRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@SpringBootTest
@RunWith(SpringRunner.class)
public class PermissaoRepositoryImplTest {

    @Autowired
    private PermissaoRepository permissaoRepository;

    @Test
    public void listar() {
        assertEquals(permissaoRepository.listar().size(), 2);
    }

    @Test
    public void buscar() {
        assertEquals(permissaoRepository.buscar(1L).getNome(), "read");
    }

    @Test
    public void salvar() {
        final Permissao permissao = new Permissao();
        permissao.setNome("full");
        permissao.setDescricao("permissao de escria e leiura");


        final Permissao permissaoSave = permissaoRepository.salvar(permissao);
        assertEquals(permissaoSave.getNome(), "full");
    }

    @Test
    public void remover() {
        final int qtdRegistros = permissaoRepository.listar().size();

        final Permissao permissao = new Permissao();
        permissao.setId(3L);
        permissaoRepository.remover(permissao);

        assertEquals(permissaoRepository.listar().size(), qtdRegistros - 1);
    }
}