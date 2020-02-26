package com.algaworks.algafood.infrastructe.repository;

import com.algaworks.algafood.domain.model.FormaDePagamento;
import com.algaworks.algafood.domain.repository.FormaDePagamentoRepository;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Component
public class FormaDePagamentoRepositoryImpl implements FormaDePagamentoRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<FormaDePagamento> listar() {
        return entityManager.createQuery("from FormaDePagamento", FormaDePagamento.class).getResultList();
    }

    @Override
    public FormaDePagamento buscar(final Long id) {
        return entityManager.find(FormaDePagamento.class, id);
    }

    @Override
    @Transactional
    public FormaDePagamento salvar(final FormaDePagamento formaDePagamento) {
        return entityManager.merge(formaDePagamento);
    }

    @Override
    @Transactional
    public void remover(final FormaDePagamento formaDePagamento) {
        entityManager.remove(buscar(formaDePagamento.getId()));
    }
}
