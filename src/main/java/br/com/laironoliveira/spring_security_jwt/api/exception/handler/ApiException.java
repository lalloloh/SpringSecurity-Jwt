package br.com.laironoliveira.spring_security_jwt.api.exception.handler;

import java.time.OffsetDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonInclude(Include.NON_NULL)
@AllArgsConstructor
public class ApiException {

    private Integer status;
	private OffsetDateTime dataHora;
	private String titulo;
	private List<Field> campos;

	public static class Field {
		private final String nome;
		private final String mensagem;

		public Field(String nome, String mensagem) {
			this.nome = nome;
			this.mensagem = mensagem;
		}

		public String getNome() {
			return nome;
		}

		public String getMensagem() {
			return mensagem;
		}

	}
}
