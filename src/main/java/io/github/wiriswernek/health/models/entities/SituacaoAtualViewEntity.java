package io.github.wiriswernek.health.models.entities;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table( name = "SITUACAO_ATUAL_VIEW" )
public class SituacaoAtualViewEntity {
	
	@Id
	@Column(name = "ID")
	private Integer id;
	
	@Column(name = "QUANDO")
	private LocalDateTime quando;

	@Column(name = "AMBIENTE")
	private String ambiente;
	
	@Column(name = "STATUS")
	private String status;

	@Column(name = "CLIENTE")
	private String cliente;
}
