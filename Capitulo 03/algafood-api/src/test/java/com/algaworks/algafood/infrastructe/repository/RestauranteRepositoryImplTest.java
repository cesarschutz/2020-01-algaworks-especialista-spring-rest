package com.algaworks.algafood.infrastructe.repository;

import com.algaworks.algafood.domain.model.Restaurante;
import com.algaworks.algafood.domain.repository.RestauranteRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.assertEquals;

@SpringBootTest
@RunWith(SpringRunner.class)
public class RestauranteRepositoryImplTest {

    @Autowired
    private RestauranteRepository restauranteRepository;

    @Test
    public void listar() {
        assertEquals(restauranteRepository.listar().size(), 3);
    }

    @Test
    public void buscar() {
        assertEquals(restauranteRepository.buscar(1L).getTaxaFrete(),new BigDecimal(10).setScale(2));
    }

    @Test
    public void salvar() {
        final Restaurante restaurante = new Restaurante();
        restaurante.setNome("teste");
        restaurante.setTaxaFrete(new BigDecimal(5));

        final Restaurante salvar = restauranteRepository.salvar(restaurante);
        assertEquals(salvar.getNome(), "teste");
        assertEquals(salvar.getTaxaFrete(), new BigDecimal(5));
    }

    @Test
    public void remover() {
        final int qtdRegistros = restauranteRepository.listar().size();

        final Restaurante restaurante = new Restaurante();
        restaurante.setId(1L);
                restauranteRepository.remover(restaurante);

        assertEquals(restauranteRepository.listar().size(), qtdRegistros - 1);
    }
}