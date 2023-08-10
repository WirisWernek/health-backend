package io.github.wiriswernek.health.business.facades;

import java.math.BigInteger;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.persistence.Tuple;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import io.github.wiriswernek.health.dtos.HealthDTO;
import io.github.wiriswernek.health.dtos.HealthResumedDTO;
import io.github.wiriswernek.health.dtos.Status;
import io.github.wiriswernek.health.enums.StatusEnum;
import io.github.wiriswernek.health.models.entities.ClienteEntity;
import io.github.wiriswernek.health.models.entities.HealthEntity;
import io.github.wiriswernek.health.models.entities.StatusEntity;
import io.github.wiriswernek.health.models.repositories.ClienteRepository;
import io.github.wiriswernek.health.models.repositories.HealthRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SituacaoFacade {

	private final ModelMapper mapper = new ModelMapper();

	private final HealthRepository healthRepository;
	private final ClienteRepository clienteRepository;

	private final DateTimeFormatter formatterData = DateTimeFormatter.ofPattern("dd/MM/uuuu");
	private final DateTimeFormatter formatterHora = DateTimeFormatter.ofPattern("HH:mm:ss");

	public void process() throws Exception {

		List<HealthEntity> list = new ArrayList<HealthEntity>();

		var clientes = clienteRepository.findAll();

		for (var sistema : clientes) {
			try {
				var status = this.getStatus(sistema.getUrl(), sistema.getHealthEndpoint() );

				HealthEntity registro = getModel(sistema, StatusEnum.parse(status.getStatus()));

				list.add(registro);

			} catch (Exception e) {
				HealthEntity registro = getModel(sistema, StatusEnum.DOWN);
				list.add(registro);
			}
		}

		if (!list.isEmpty()) {
			healthRepository.saveAll(list);
		} else {
			throw new Exception("Erro ao consultar serviços as " + LocalDateTime.now() + " com o código "
					+ UUID.randomUUID().toString());
		}
	}

	private HealthEntity getModel(ClienteEntity cliente, StatusEnum status) {

		HealthEntity health = new HealthEntity();
		StatusEntity statusEntity = new StatusEntity();

		statusEntity.setId(status.getId());
		health.setQuando(LocalDateTime.now());
		health.setStatus(statusEntity);
		health.setAmbiente(cliente.getAmbiente());
		health.setCliente(cliente);

		return health;
	}

	public List<HealthResumedDTO> getAll() {
		refreshView();
		List<HealthResumedDTO> listSituacao = new ArrayList<HealthResumedDTO>();

		var list = healthRepository.getListSituacaoAtual();
		list.stream().forEach(item -> {
			listSituacao.add(mapper(item));
		});

		return listSituacao;

	}

	public void refreshView() {
		healthRepository.refreshViews();
	}

	public List<HealthResumedDTO> getAllStatusSistemaByIdSituacao(Long id) {
		List<HealthResumedDTO> listSituacao = new ArrayList<HealthResumedDTO>();
		var list = healthRepository.getAllStatusSistemaByIdSituacao(id);

		list.forEach(item -> {
			listSituacao.add(mapperResumedDTO(item));
		});

		return listSituacao;
	}

	private HealthResumedDTO mapperResumedDTO(HealthEntity entity){
		HealthResumedDTO situacao = new HealthResumedDTO();
		situacao.setId(entity.getId());
		situacao.setAmbiente(entity.getAmbiente().getNome());
		situacao.setCliente(entity.getCliente().getNome());
		situacao.setStatus(entity.getStatus().getNome());
		situacao.setDia(formatterData.format(entity.getQuando()));
		situacao.setHora(formatterHora.format(entity.getQuando()));

		return situacao;
	}

	private HealthResumedDTO mapper(Tuple tuple) {
		HealthResumedDTO situacao = new HealthResumedDTO();
		situacao.setId(getLong(tuple, "id"));
		situacao.setAmbiente((String) tuple.get("ambiente"));
		situacao.setCliente((String) tuple.get("cliente"));
		situacao.setStatus((String) tuple.get("status"));
		situacao.setDia(formatterData.format(getLocalDateTimeFromTimestamp(tuple, "quando")));
		situacao.setHora(formatterHora.format(getLocalDateTimeFromTimestamp(tuple, "quando")));

		return situacao;
	}

	private Status getStatus(String url, String healthEndpoint ) throws Exception {
		RestTemplate restTemplate = new RestTemplate();
		return restTemplate.getForObject(url + healthEndpoint, Status.class);
	}

	private Long getLong(Tuple tuple, String column) {
		var value = (BigInteger) tuple.get(column);
		return value != null ? value.longValue() : null;
	}

	private static LocalDateTime getLocalDateTimeFromTimestamp(Tuple tuple, String column) {
		var dateStr = (Timestamp) tuple.get(column);
		if (dateStr == null) {
			return null;
		}
		return dateStr.toLocalDateTime();
	}
}
