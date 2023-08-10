package io.github.wiriswernek.health.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class AmbienteDTO {
	private Long id;
	private String nome;
	private String descricao;
}
