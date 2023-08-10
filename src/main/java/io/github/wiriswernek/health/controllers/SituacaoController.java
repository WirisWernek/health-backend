package io.github.wiriswernek.health.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.github.wiriswernek.health.business.facades.SituacaoFacade;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping( "/situacao" )
@Slf4j
@RequiredArgsConstructor
public class SituacaoController {

	private final SituacaoFacade facade;

	@GetMapping( path = "/get-all" )
	public ResponseEntity getAll() {
		try {
			return ResponseEntity.ok( facade.getAll() );
		} catch ( Exception e ) {
			log.info( e.getMessage() );
			log.info( e.toString() );
			return ResponseEntity.internalServerError().body( e.getMessage() );

		}
	}

	@GetMapping( path = "/{id}" )
	public ResponseEntity getAllStatusSistemaByIdSituacao( @PathVariable Long id) {
		try {
			return ResponseEntity.ok( facade.getAllStatusSistemaByIdSituacao(id) );
		} catch ( Exception e ) {
			log.info( e.getMessage() );
			log.info( e.toString() );
			return ResponseEntity.internalServerError().body( e.getMessage() );

		}
	}


}
