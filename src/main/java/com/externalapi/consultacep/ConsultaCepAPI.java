package com.externalapi.consultacep;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.externalapi.dto.CepResultDto;

@RestController
@RequestMapping(value = "consulta-cep")
public class ConsultaCepAPI {

	@GetMapping("{cep}")
	public CepResultDto consultaCep(@PathVariable("cep") String cep) {
		
		RestTemplate restTemplate = new RestTemplate();
		
		String uri = "https://viacep.com.br/ws/%s/json/";
		
		ResponseEntity<CepResultDto> resp = restTemplate.getForEntity(String.format(uri, cep), CepResultDto.class);
		
		return resp.getBody();
	}
}
