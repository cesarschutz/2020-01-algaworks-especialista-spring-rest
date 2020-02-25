package com.algaworks.algafood.jpa;

import com.algaworks.algafood.AlgafoodApiApplication;
import com.algaworks.algafood.domain.model.Cozinha;
import com.algaworks.algafood.domain.repository.CozinhaRepository;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

public class AleracaoCozinhaMain {

    public static void main(String[] args) {
        ApplicationContext applicationContext =
                new SpringApplicationBuilder(AlgafoodApiApplication.class)
                        .web(WebApplicationType.NONE)
                        .run(args);

        final CozinhaRepository cozinhaRepository = applicationContext.getBean(CozinhaRepository.class);
        final Cozinha byId = cozinhaRepository.buscar(1L);
        byId.setNome("teste");

        cozinhaRepository.salvar(byId);
    }
}
