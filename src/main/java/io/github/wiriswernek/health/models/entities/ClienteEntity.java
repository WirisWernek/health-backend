package io.github.wiriswernek.health.models.entities;

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
@Table( name = "CLIENTE" )
public class ClienteEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long id;

	@Column(name = "URL")
	private String url;

	@Column(name = "NOME")
	private String nome;

	@Column(name = "HEALTH_ENDPOINT")
	private String healthEndpoint;

	@Column(name = "PARAMETRIZADO")
	private Boolean parametrizado;

	@Column(name = "SERVICO")
	private String servico;

	@ManyToOne( fetch = FetchType.LAZY )
	@JoinColumn(name = "AMBIENTEID", referencedColumnName = "ID")
	private AmbienteEntity ambiente;

}
