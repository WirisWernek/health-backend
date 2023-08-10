package io.github.wiriswernek.health.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum AmbientesEnum {

	LOCAL( "Local" ), DEV( "Desenvolvimento" ), HML( "Homologação" ), PRD( "Produção" ), PRD2( "Produção 2" );

	private String ambiente;

	public static AmbientesEnum parse( String value ) {
		AmbientesEnum enumerated = null;
		for( var ambiente : AmbientesEnum.values() ) {
			if( value.equals( ambiente.name() ) ) {
				enumerated = ambiente;
			}
		}

		return enumerated;
	}
}
