package io.github.wiriswernek.health.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class HealthDTO {
	private Long id;
	private String dia;
	private String hora;
	private ClienteDTO cliente;
	private StatusDTO status;
	private AmbienteDTO ambiente;

	@Override
	public String toString() {
		StringBuilder servico = new StringBuilder();
		servico.append( "Cliente " )//
				.append( this.cliente )//
				.append( " no ambiente " )//
				.append( this.ambiente )//
				.append( " is " )//
				.append( this.status )//
				.append( " às " )//
				.append( this.dia )
				.append( " " )
				.append( this.hora );

		return servico.toString();
	}
}
