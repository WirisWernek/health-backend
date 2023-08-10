package io.github.wiriswernek.health.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ClienteDTO {
	private Long id;
	private String url;
	private String healthEndpoint;
	private Boolean parametrizado;
	private String servico;
	private AmbienteDTO ambiente;
}
