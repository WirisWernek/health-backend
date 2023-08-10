package io.github.wiriswernek.health.models.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import io.github.wiriswernek.health.models.entities.ClienteEntity;

public interface ClienteRepository extends JpaRepository<ClienteEntity, Long> {
	
}
