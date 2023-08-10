package io.github.wiriswernek.health.scheduled;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import io.github.wiriswernek.health.business.facades.SituacaoFacade;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
@EnableScheduling
public class HealthChek {

	private final long SEGUNDO = 1000;
	private final long MINUTO = SEGUNDO * 60;
	private final long HORA = MINUTO * 60;

	@Autowired
	private SituacaoFacade facade;

	@Scheduled( fixedDelay = ( SEGUNDO * 20 ) )
	public void checkStatus() {
		try {
			log.info( "Verificando sistemas" );
			// facade.process();
		} catch ( Exception e ) {
			log.error( "Erro de processamento do serviço " + e.getMessage() );
			e.printStackTrace();
		}
	}

	@Scheduled( fixedDelay = ( MINUTO * 2 ) )
	public void refreshView() {
		try {
			log.info( "Inciando Refresh Automático da View" );
			facade.refreshView();
			log.debug( "Fim do Refresh Automático da View" );
		} catch ( Exception e ) {
			log.error( "Erro de processamento do serviço " + e.getMessage() );
			e.printStackTrace();
		}
	}

}
