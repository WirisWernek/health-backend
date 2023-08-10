package io.github.wiriswernek.health.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class HealthResumedDTO {
	private Long id;
	private String dia;
	private String hora;
	private String cliente;
	private String status;
	private String ambiente;
}
