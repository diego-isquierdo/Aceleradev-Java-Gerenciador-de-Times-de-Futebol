package br.com.codenation;

import java.math.BigDecimal;
import java.time.LocalDate;

public class TestaDesafio {

    public static void main(String[] args) {
        DesafioMeuTimeApplication desafio = new DesafioMeuTimeApplication();

        //Times
        desafio.incluirTime(3L, "Cruzeiro", LocalDate.now(), "Azul", "branco");
        desafio.incluirTime(1L, "Grêmio", LocalDate.now(), "Azul", "preto");
        desafio.incluirTime(2L, "Guarany", LocalDate.now(), "verde", "branco");
        desafio.incluirTime(4L, "Corinthians", LocalDate.now(), "Preto", "branco");
        desafio.incluirTime(5L, "Vasco", LocalDate.now(), "Preto", "branco");
        //desafio.incluirTime(6L, "Atlético", LocalDate.now(), "Preto", "vermelho");
        //desafio.incluirTime(6L, "Atlético", LocalDate.now(), "Preto", "vermelho");

        //Jogadores
        //Gremio
        desafio.incluirJogador(7L, 1L, "Alejo", LocalDate.of(1964,02,16), 100  , BigDecimal.valueOf(60000.00));
        desafio.incluirJogador(14L, 1L, "Jael", LocalDate.of(1990,06,01), 100, BigDecimal.valueOf(30000.00));
        desafio.incluirJogador(11L, 1L, "Danrlei", LocalDate.of(1983,05,5), 93  , BigDecimal.valueOf(50000.00));
        desafio.incluirJogador(12L, 1L, "Dinho", LocalDate.of(1983,05,5), 93  , BigDecimal.valueOf(50000.00));
        desafio.incluirJogador(13L, 1L, "Paulo Nunes", LocalDate.of(1983,05,5), 93  , BigDecimal.valueOf(50000.00));

        //Guarany
        desafio.incluirJogador(20L, 2L, "João", LocalDate.of(1980,05,5), 69  , BigDecimal.valueOf(60000.00));
        desafio.incluirJogador(24L, 2L, "José", LocalDate.of(1990,06,01), 93, BigDecimal.valueOf(40000.00));
        desafio.incluirJogador(21L, 2L, "Tadeu", LocalDate.of(1983,05,5), 93  , BigDecimal.valueOf(50000.00));
        desafio.incluirJogador(22L, 2L, "Joca", LocalDate.of(1983,05,5), 93  , BigDecimal.valueOf(50000.00));
        desafio.incluirJogador(23L, 2L, "Joel", LocalDate.of(1983,05,5), 93  , BigDecimal.valueOf(50000.00));

        //Cruzeiro
        desafio.incluirJogador(30L, 3L, "Djalminha", LocalDate.of(1980,05,5), 69  , BigDecimal.valueOf(60000.00));
        desafio.incluirJogador(34L, 3L, "Palhinha", LocalDate.of(1990,06,01), 93, BigDecimal.valueOf(40000.00));
        desafio.incluirJogador(31L, 3L, "Fabio", LocalDate.of(1983,05,5), 93  , BigDecimal.valueOf(50000.00));
        desafio.incluirJogador(32L, 3L, "Edilson", LocalDate.of(1983,05,5), 93  , BigDecimal.valueOf(50000.00));
        desafio.incluirJogador(33L, 3L, "Dida", LocalDate.of(1983,05,5), 93  , BigDecimal.valueOf(50000.00));

        //Corinthians
        desafio.incluirJogador(40L, 4L, "Casa Grande", LocalDate.of(1980,05,5), 69  , BigDecimal.valueOf(60000.00));
        desafio.incluirJogador(44L, 4L, "Neto", LocalDate.of(1990,06,01), 93, BigDecimal.valueOf(40000.00));
        desafio.incluirJogador(41L, 4L, "Ronaldo", LocalDate.of(1983,05,5), 93  , BigDecimal.valueOf(50000.00));
        desafio.incluirJogador(42L, 4L, "Marcelinho C.", LocalDate.of(1983,05,5), 93  , BigDecimal.valueOf(50000.00));
        desafio.incluirJogador(43L, 4L, "Joel", LocalDate.of(1983,05,5), 93  , BigDecimal.valueOf(50000.00));

        //Vasco
        desafio.incluirJogador(50L, 5L, "R Dinamite", LocalDate.of(1980,05,5), 69  , BigDecimal.valueOf(60000.00));
        desafio.incluirJogador(54L, 5L, "Romário", LocalDate.of(1990,06,01), 93, BigDecimal.valueOf(40000.00));
        desafio.incluirJogador(51L, 5L, "Edmundo", LocalDate.of(1983,05,5), 93  , BigDecimal.valueOf(50000.00));
        desafio.incluirJogador(52L, 5L, "Junino P.", LocalDate.of(1983,05,5), 93  , BigDecimal.valueOf(50000.00));
        desafio.incluirJogador(53L, 5L, "Vanderlei", LocalDate.of(1983,05,5), 93  , BigDecimal.valueOf(50000.00));

        //Atlécio > não tem jogadores para testes

        //testa cadastro dos times/jogadores
        desafio.getTimes().forEach(System.out::println);
        desafio.getJogadores().forEach(System.out::println);

        //Define os capitães
        desafio.definirCapitao(11L);
        desafio.definirCapitao(20L);
        desafio.definirCapitao(30L);
        desafio.definirCapitao(40L);
        desafio.definirCapitao(50L);
        //desafio.definirCapitao(60L);


        //testa cadstro após definir capitães
        desafio.getTimes().forEach(System.out::println);

        //capitães
        System.out.println("buscarCapitaoDoTime > " + desafio.buscarCapitaoDoTime(1L));
        System.out.println("buscarCapitaoDoTime > " + desafio.buscarCapitaoDoTime(2L));
        System.out.println("buscarCapitaoDoTime > " + desafio.buscarCapitaoDoTime(3L));
        System.out.println("buscarCapitaoDoTime > " + desafio.buscarCapitaoDoTime(4L));
        System.out.println("buscarCapitaoDoTime > " + desafio.buscarCapitaoDoTime(5L));

        //Buscar Jogadores
        //Gremio
        System.out.println("\n" + desafio.buscarNomeTime(1L));
        System.out.println("buscarNomeJogador > " + desafio.buscarNomeJogador(7L));
        System.out.println("buscarNomeJogador > " + desafio.buscarNomeJogador(11L));
        System.out.println("buscarNomeJogador > " + desafio.buscarNomeJogador(12L));
        System.out.println("buscarNomeJogador > " + desafio.buscarNomeJogador(13L));
        System.out.println("buscarNomeJogador > " + desafio.buscarNomeJogador(14L));
        //Guarany
        System.out.println("\n" + desafio.buscarNomeTime(2L));
        System.out.println("buscarNomeJogador > " + desafio.buscarNomeJogador(20L));
        System.out.println("buscarNomeJogador > " + desafio.buscarNomeJogador(21L));
        System.out.println("buscarNomeJogador > " + desafio.buscarNomeJogador(22L));
        System.out.println("buscarNomeJogador > " + desafio.buscarNomeJogador(23L));
        System.out.println("buscarNomeJogador > " + desafio.buscarNomeJogador(24L));
        //Cruzeiro
        System.out.println("\n" + desafio.buscarNomeTime(3L));
        System.out.println("buscarNomeJogador > " + desafio.buscarNomeJogador(30L));
        System.out.println("buscarNomeJogador > " + desafio.buscarNomeJogador(31L));
        System.out.println("buscarNomeJogador > " + desafio.buscarNomeJogador(32L));
        System.out.println("buscarNomeJogador > " + desafio.buscarNomeJogador(33L));
        System.out.println("buscarNomeJogador > " + desafio.buscarNomeJogador(34L));
        //Corinthians
        System.out.println("\n" + desafio.buscarNomeTime(4L));
        System.out.println("buscarNomeJogador > " + desafio.buscarNomeJogador(40L));
        System.out.println("buscarNomeJogador > " + desafio.buscarNomeJogador(41L));
        System.out.println("buscarNomeJogador > " + desafio.buscarNomeJogador(42L));
        System.out.println("buscarNomeJogador > " + desafio.buscarNomeJogador(43L));
        System.out.println("buscarNomeJogador > " + desafio.buscarNomeJogador(44L));
        //Vasco
        System.out.println("\n" + desafio.buscarNomeTime(5L));
        System.out.println("buscarNomeJogador > " + desafio.buscarNomeJogador(50L));
        System.out.println("buscarNomeJogador > " + desafio.buscarNomeJogador(51L));
        System.out.println("buscarNomeJogador > " + desafio.buscarNomeJogador(52L));
        System.out.println("buscarNomeJogador > " + desafio.buscarNomeJogador(53L));
        System.out.println("buscarNomeJogador > " + desafio.buscarNomeJogador(54L));


        //Times por nome
        System.out.println("\nTimes:");
        System.out.println("buscarNomeTime > " + desafio.buscarNomeTime(5L));
        System.out.println("buscarNomeTime > " + desafio.buscarNomeTime(4L));
        System.out.println("buscarNomeTime > " + desafio.buscarNomeTime(3L));
        System.out.println("buscarNomeTime > " + desafio.buscarNomeTime(2L));
        System.out.println("buscarNomeTime > " + desafio.buscarNomeTime(1L));
        //System.out.println("buscarNomeTime > " + desafio.buscarNomeTime(6L));

        System.out.println("\nbuscarJogadoresDoTime > " + desafio.buscarJogadoresDoTime(1L));
        System.out.println("buscarJogadoresDoTime > " + desafio.buscarJogadoresDoTime(2L));
        System.out.println("nbuscarJogadoresDoTime > " + desafio.buscarJogadoresDoTime(3L));
        System.out.println("buscarJogadoresDoTime > " + desafio.buscarJogadoresDoTime(4L));
        System.out.println("buscarJogadoresDoTime > " + desafio.buscarJogadoresDoTime(5L));
        //System.out.println("buscarJogadoresDoTime > " + desafio.buscarJogadoresDoTime(6L));

        System.out.println("\nbuscarMelhorJogadorDoTime > " + desafio.buscarMelhorJogadorDoTime(1L));
        System.out.println("buscarMelhorJogadorDoTime > " + desafio.buscarMelhorJogadorDoTime(2L));
        System.out.println("buscarMelhorJogadorDoTime > " + desafio.buscarMelhorJogadorDoTime(3L));
        System.out.println("buscarMelhorJogadorDoTime > " + desafio.buscarMelhorJogadorDoTime(4L));
        System.out.println("buscarMelhorJogadorDoTime > " + desafio.buscarMelhorJogadorDoTime(5L));
        //System.out.println("buscarMelhorJogadorDoTime > " + desafio.buscarMelhorJogadorDoTime(6L));

        System.out.println("\nbuscarJogadorMaisVelho > " + desafio.buscarJogadorMaisVelho(1L));
        System.out.println("buscarJogadorMaisVelho > " + desafio.buscarJogadorMaisVelho(2L));
        System.out.println("buscarJogadorMaisVelho > " + desafio.buscarJogadorMaisVelho(3L));
        System.out.println("buscarJogadorMaisVelho > " + desafio.buscarJogadorMaisVelho(4L));
        System.out.println("buscarJogadorMaisVelho > " + desafio.buscarJogadorMaisVelho(5L));

        System.out.println("buscarTimes > " + desafio.buscarTimes());

        System.out.println("\nbuscarJogadorMaiorSalario > " + desafio.buscarJogadorMaiorSalario(1L));
        System.out.println("buscarJogadorMaiorSalario > " + desafio.buscarJogadorMaiorSalario(2L));
        System.out.println("buscarJogadorMaiorSalario > " + desafio.buscarJogadorMaiorSalario(3L));
        System.out.println("buscarJogadorMaiorSalario > " + desafio.buscarJogadorMaiorSalario(4L));
        System.out.println("buscarJogadorMaiorSalario > " + desafio.buscarJogadorMaiorSalario(5L));

        System.out.println("buscarSalarioDoJogador > " + desafio.buscarSalarioDoJogador(7L));

        System.out.println("buscarTopJogadores" + desafio.buscarTopJogadores(5));

        System.out.println(desafio.buscarCorCamisaTimeDeFora(1L,3L));
        System.out.println(desafio.buscarCorCamisaTimeDeFora(1L,4L));
        System.out.println(desafio.buscarCorCamisaTimeDeFora(4L,5L));

    }
}
