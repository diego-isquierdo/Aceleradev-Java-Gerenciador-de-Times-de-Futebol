package br.com.codenation;

import br.com.codenation.desafio.exceptions.CapitaoNaoInformadoException;
import br.com.codenation.desafio.exceptions.IdentificadorUtilizadoException;
import br.com.codenation.desafio.exceptions.JogadorNaoEncontradoException;
import br.com.codenation.desafio.exceptions.TimeNaoEncontradoException;

public class Validador {

    static void validaId(boolean parametro){
        if (parametro) throw new IdentificadorUtilizadoException("Id Informado não corresponde");
    }

    static void validaNumber(boolean parametro){
        if (parametro) throw new IllegalArgumentException("Valor informado errado!");
    }

    static void validaTime(boolean parametro){
        if(parametro) throw  new TimeNaoEncontradoException("Time Não Encontrado");
    }

    static void validaJogador (boolean parametro){
        if(parametro) throw new JogadorNaoEncontradoException("Jogador não encontrado");
    }

    static  void validaCapitao(boolean parametro){
        if (parametro) throw new CapitaoNaoInformadoException("Capitão não encontrado!");
    }
}
