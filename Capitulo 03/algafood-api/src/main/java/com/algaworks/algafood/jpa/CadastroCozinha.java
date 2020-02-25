package com.algaworks.algafood.jpa;

import com.algaworks.algafood.domain.model.Cozinha;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Component
public class CadastroCozinha {

    @PersistenceContext
    private EntityManager entityManager;

    public List<Cozinha> listar() {
        return entityManager.createQuery("from Cozinha", Cozinha.class).getResultList();
    }

    @Transactional
    public Cozinha adicionar(final Cozinha cozinha) {
        return entityManager.merge(cozinha);
    }

    public Cozinha getById(final Long id){
        return entityManager.find(Cozinha.class, id);
    }
}
