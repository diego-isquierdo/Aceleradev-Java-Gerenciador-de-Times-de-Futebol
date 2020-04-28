package br.com.codenation;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import br.com.codenation.desafio.annotation.Desafio;
import br.com.codenation.desafio.app.MeuTimeInterface;
import br.com.codenation.desafio.exceptions.JogadorNaoEncontradoException;
import br.com.codenation.desafio.exceptions.TimeNaoEncontradoException;

public class DesafioMeuTimeApplication implements MeuTimeInterface {
    private List<Time> times = new ArrayList<>();
    private List<Jogador> jogadores = new ArrayList<>();


	public List<Time> getTimes() {
		return times;
	}
	public List<Jogador> getJogadores() {
		return jogadores;
	}



    @Desafio("incluirTime")
	public void incluirTime(Long id, String nome, LocalDate dataCriacao, String corUniformePrincipal, String corUniformeSecundario) {
		Validador.validaId(anyMatchTime(id));
		times.add(new Time(id, nome, dataCriacao, corUniformePrincipal, corUniformeSecundario));
	}

	@Desafio("incluirJogador")
	public void incluirJogador(Long id, Long idTime, String nome, LocalDate dataNascimento, Integer nivelHabilidade, BigDecimal salario) {
		Validador.validaTime(!anyMatchTime(idTime));
		Validador.validaId(anyMatchJogador(id));
		Validador.validaNumber(nivelHabilidade<0 || nivelHabilidade>100);

	    jogadores.add(new Jogador(id, idTime, nome, dataNascimento, nivelHabilidade, salario));
	}


	@Desafio("definirCapitao")
	public void definirCapitao(Long idJogador) {
		Validador.validaJogador(!anyMatchJogador(idJogador));

		entregaBracadeira(idJogador);
	}

	@Desafio("buscarCapitaoDoTime")
	public Long buscarCapitaoDoTime(Long idTime) {
		Validador.validaTime(!anyMatchTime(idTime));

        Long capitao = getTimeById(idTime).getCapitao();
		Validador.validaCapitao(capitao==null);

        return capitao;
	}

	@Desafio("buscarNomeJogador")
	public String buscarNomeJogador(Long idJogador) {
		return getJogadorById(idJogador).getNome();
	}

	@Desafio("buscarNomeTime")
	public String buscarNomeTime(Long idTime) {
		return getTimeById(idTime).getNome();
	}

	@Desafio("buscarJogadoresDoTime")
	public List<Long> buscarJogadoresDoTime(Long idTime) {
		Validador.validaTime(!anyMatchTime(idTime));

		return jogadores.stream()
					  .filter(j->j.getIdTime().equals(idTime))
					  .map(Jogador::getId)
					  .sorted()
					  .collect(Collectors.toList());
	}

	@Desafio("buscarMelhorJogadorDoTime")
	public Long buscarMelhorJogadorDoTime(Long idTime) {
		Validador.validaTime(!anyMatchTime(idTime));

		return jogadores.stream()
					  .filter(j->j.getIdTime().equals(idTime))
				 	  .sorted(Comparator.comparingInt(Jogador::getNivelHabilidade)
							  			.reversed()
					  					.thenComparing(Jogador::getId))
				 	  .map(Jogador::getId)
					  .findFirst()
					  .orElseThrow(JogadorNaoEncontradoException::new);
	}

	@Desafio("buscarJogadorMaisVelho")
	public Long buscarJogadorMaisVelho(Long idTime) {
		Validador.validaTime(!anyMatchTime(idTime));

		return jogadores.stream()
					  .filter(j->j.getIdTime().equals(idTime))
					  .sorted(Comparator.comparing(Jogador::getDataNascimento)
					  					.thenComparing(Jogador::getId))
					  .map(Jogador::getId)
					  .findFirst()
					  .orElseThrow(JogadorNaoEncontradoException::new);
	}

	@Desafio("buscarTimes")
	public List<Long> buscarTimes() {
		return times.stream()
					.sorted(Comparator.comparingLong(Time::getId))
					.map(Time::getId)
					.collect(Collectors.toList());
	}

	@Desafio("buscarJogadorMaiorSalario")
	public Long buscarJogadorMaiorSalario(Long idTime) {
		Validador.validaTime(!anyMatchTime(idTime));

		return jogadores.stream()
					  .filter(j->j.getIdTime().equals(idTime))
					  .sorted(Comparator.comparing(Jogador::getSalario)
					  					.reversed()
					  					.thenComparingLong(Jogador::getId))
					  .map(Jogador::getId)
					  .findFirst()
					  .orElseThrow(JogadorNaoEncontradoException::new);
	}

	@Desafio("buscarSalarioDoJogador")
	public BigDecimal buscarSalarioDoJogador(Long idJogador) {
		Validador.validaJogador(!anyMatchJogador(idJogador));
		return jogadores.stream()
						.filter(j->Objects.equals(j.getId(), idJogador))
						.map(Jogador::getSalario)
						.findFirst()
						.orElseThrow(NullPointerException::new);
	}

	@Desafio("buscarTopJogadores")
	public List<Long> buscarTopJogadores(Integer top) {
		return jogadores.stream()
                     .sorted(Comparator.comparingInt(Jogador::getNivelHabilidade)
                             .reversed()
                             .thenComparingLong(Jogador::getId))
                     .limit(top)
                     .mapToLong(Jogador::getId)
					 .boxed()
                     .collect(Collectors.toList());
	}

	@Desafio("buscarCorCamisaTimeDeFora")
	public String buscarCorCamisaTimeDeFora(Long timeDaCasa, Long timeDeFora) {
		Time mandante =  getTimeById(timeDaCasa);
		Time visitante = getTimeById(timeDeFora);

		if (mandante.getCorUniformePrincipal().compareTo(visitante.getCorUniformePrincipal())==0){
			return visitante.getCorUniformeSecundario();
		}
		return visitante.getCorUniformePrincipal();
	}




	public void entregaBracadeira(Long idJogador){
		getTimeById(getJogadorById(idJogador).getIdTime()).setCapitao(idJogador);
	}

	public Time getTimeById(Long id){
        return times.stream()
                    .filter(t->t.getId().equals(id))
                    .findFirst()
                    .orElseThrow(TimeNaoEncontradoException::new);
    }

    public Jogador getJogadorById(Long id){
        return jogadores.stream()
                    .filter(p->p.getId().equals(id))
                    .findFirst()
                    .orElseThrow(JogadorNaoEncontradoException::new);
    }

    public boolean anyMatchTime(Long id){
		return times.stream().anyMatch(p-> Objects.equals(p.getId(), id));
	}

	public boolean anyMatchJogador(Long id){
		return jogadores.stream().anyMatch(j->Objects.equals(j.getId(), id));
	}

}
