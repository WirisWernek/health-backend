package io.github.wiriswernek.health.models.entities;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table( name = "HEALTH" )
public class HealthEntity {
	
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY )
	@Column(name = "ID")
	private Long id;
	
	@Column(name = "QUANDO")
	private LocalDateTime quando;
	
	@ManyToOne( fetch = FetchType.LAZY )
	@JoinColumn(name = "CLIENTEID", referencedColumnName = "ID")
	private ClienteEntity cliente;
	
	@ManyToOne( fetch = FetchType.LAZY )
	@JoinColumn(name = "STATUSID", referencedColumnName = "ID")
	private StatusEntity status;
	
	@ManyToOne( fetch = FetchType.LAZY )
	@JoinColumn(name = "AMBIENTEID", referencedColumnName = "ID")
	private AmbienteEntity ambiente;

	
}