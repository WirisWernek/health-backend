package io.github.wiriswernek.health.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum ClientesEnum {

	SITE_LOCAL( "Site Core", "http://localhost:8082", "LOCAL" ), //
	
	SITE_PRD( "Site Core", "https://site-backend-backend.benevix.com.br", "PRD" ), //
	SITE_HML( "Site Core", "https://site-backend-backend.hml.benevix.com.br", "HML" ),//
	SITE_DEV( "Site Core", "https://site-backend-backend.dev.benevix.com.br", "DEV" ), //
	
	BITIX_PRD( "Bitix", "https://interface-bitix.benevix.com.br/interface-bitix/api", "PRD" ),//
	BITIX_HML( "Bitix", "https://interface-bitix.hml.benevix.com.br/interface-bitix/api", "HML" ),//
	BITIX_DEV( "Bitix", "https://interface-bitix.dev.benevix.com.br/interface-bitix/api", "DEV" ),//
	
	PORTAL_EMPRESARIAL_PRD( "Portal Empresarial", "https://interface-portal-empresarial.benevix.com.br/interface-portal-empresarial/api", "PRD" ),//
	PORTAL_EMPRESARIAL_HML( "Portal Empresarial", "https://interface-portal-empresarial.hml.benevix.com.br/interface-portal-empresarial/api", "HML" ),//
	PORTAL_EMPRESARIAL_DEV( "Portal Empresarial", "https://interface-portal-empresarial.dev.benevix.com.br/interface-portal-empresarial/api", "DEV" ),//

	PORTAL_IMPANTACAO_PRD( "Portal Implantação", "https://interface-portal-implantacao-backend.benevix.com.br/interface-portal-implantacao/api", "PRD" ),//
	PORTAL_IMPANTACAO_HML( "Portal Implantação", "https://interface-portal-implantacao-backend.hml.benevix.com.br/interface-portal-implantacao/api", "HML" ),//
	PORTAL_IMPANTACAO_DEV( "Portal Implantação", "https://interface-portal-implantacao-backend.dev.benevix.com.br/interface-portal-implantacao/api", "DEV" ),//
	
	INTERFACE_RPA_PRD( "Interface RPA", "https://interface-rpa-proposta.benevix.com.br/interface-rpa-proposta/api", "PRD"),//
	INTERFACE_RPA_HML( "Interface RPA", "https://interface-rpa-proposta.hml.benevix.com.br/interface-rpa-proposta/api", "HML"),//
	INTERFACE_RPA_DEV( "Interface RPA", "https://interface-rpa-proposta.dev.benevix.com.br/interface-rpa-proposta/api", "DEV"),//
	
	BUS_PRD( "BUS", "https://bus.benevix.com.br", "PRD"),//
	BUS_HML( "BUS", "https://bus.hml.benevix.com.br", "HML"),//
	BUS_DEV( "BUS", "https://bus.dev.benevix.com.br", "DEV");

	private String servico;
	private String url;
	private String ambiente;

	public static ClientesEnum parse( String value ) {
		ClientesEnum enumerated = null;
		for( var cliente : ClientesEnum.values() ) {
			if( value.equals( cliente.name() ) ) {
				enumerated = cliente;
			}
		}

		return enumerated;
	}
}
