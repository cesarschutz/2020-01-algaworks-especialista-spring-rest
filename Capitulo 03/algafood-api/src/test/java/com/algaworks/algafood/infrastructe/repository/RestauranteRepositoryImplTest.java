package com.algaworks.algafood.infrastructe.repository;

import com.algaworks.algafood.domain.model.Restaurante;
import com.algaworks.algafood.domain.repository.RestauranteRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.assertEquals;

@SpringBootTest
@RunWith(SpringRunner.class)
public class RestauranteRepositoryImplTest {

    @Autowired
    private RestauranteRepository restauranteRepository;

    @Test
    @Transactional
    public void listar() {
        final List<Restaurante> listar = restauranteRepository.listar();
        assertEquals(listar.size(), 3);

        listar.forEach(System.out::println);
    }

    @Test
    @Transactional
    public void buscar() {
        final Restaurante restaurante = restauranteRepository.buscar(1L);
        assertEquals(restaurante.getTaxaFrete(), new BigDecimal(10).setScale(2));
        assertEquals(restaurante.getCozinha().getNome(), "Tailandesa");

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