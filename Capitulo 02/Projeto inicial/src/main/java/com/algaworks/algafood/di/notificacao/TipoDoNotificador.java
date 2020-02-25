package com.algaworks.algafood.di.notificacao;

import org.springframework.beans.factory.annotation.Qualifier;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

//aqui informa quanto tempo deve ficar essa anotação na classe que utilizou
//se nao colocarmos isso em tempo de compilação ela não existe!
@Retention(RetentionPolicy.RUNTIME)
//qualifier para o spring entender
@Qualifier
public @interface TipoDoNotificador {
    NivelUrgencia value();
}
