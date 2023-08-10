package io.github.wiriswernek.health.models.repositories;

import java.util.List;

import javax.persistence.Tuple;
import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import io.github.wiriswernek.health.models.entities.HealthEntity;

public interface HealthRepository extends JpaRepository<HealthEntity, Long>{
	@Transactional
	@Modifying
	@Query( value = " call refreshViews(); ", nativeQuery = true )
	public void refreshViews();

	@Query( value = " SELECT * FROM situacao_atual_view order by status ", nativeQuery = true )
	public List<Tuple> getListSituacaoAtual();

	@Query( value = " select * from health s where clienteid in ( select clienteid from health h2 where h2.id = :id ) order by 2 desc ", nativeQuery = true )
	public List<HealthEntity> getAllStatusSistemaByIdSituacao(@Param("id") Long id);
}
