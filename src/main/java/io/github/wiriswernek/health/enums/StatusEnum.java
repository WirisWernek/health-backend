package io.github.wiriswernek.health.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum StatusEnum {

	UP( 1L, "De Pé/Respondendo" ), DOWN( 2L, "Caído/Sem Resposta" ), UNSTABLE( 3L, "No limite/Pode cair" );

	private Long id;
	private String status;

	public static StatusEnum parse( String value ) {
		StatusEnum enumerated = null;
		for( var status : StatusEnum.values() ) {
			if( value.equals( status.name() ) ) {
				enumerated = status;
			}
		}

		return enumerated;
	}
}
