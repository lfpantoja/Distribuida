package com.distribuida.rest.cliente;

import com.distribuida.rest.cliente.dto.Persona;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * UNIVERSIDAD CENTRAL DEL ECUADOR
 * @author Luis Pantoja
 */
public class PersonasRestClientMain {
	
	public static final String URL = "http://localhost:8080/lfpyRestServer3/api";
	private static RestTemplate restTemplate = new RestTemplate();
	
	private static void cliente() throws Exception {

		System.out.println( "------------------------------------------------" );
		System.out.println("----------LISTAR INICIO");
		listar();

		System.out.println("------------BUSCAR(1)");
		Persona persona = restTemplate.getForObject(URL+"/personas/1", Persona.class);
		System.out.println("Id: " +persona.getId());
		System.out.println("Nombre: " +persona.getNombre());

		System.out.println("------------INGRESAR 5");
		Persona persona1 = new Persona();
		persona1.setId(5);
		persona1.setNombre("OK.");
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<Persona> request = new HttpEntity<>(persona1, headers);
		restTemplate.exchange(URL+"/personas", HttpMethod.POST, request, new ParameterizedTypeReference<Persona>() { });

		System.out.println("-------LISTAR-tras-INGRESAR");
		listar();

		System.out.println("-------DELETE(2)");
		Persona personadelete = null;
		HttpEntity<Persona> request1 = new HttpEntity<>(personadelete, headers);
		restTemplate.exchange(URL+"/personas/2", HttpMethod.DELETE, request1, new ParameterizedTypeReference<Persona>() { });

		System.out.println("-------LISTAR-tras-DELETE");
		listar();

		System.out.println("-------UPDATE(3)");
		Persona personaupdate = new Persona();
		personaupdate.setId(3);
		personaupdate.setNombre("Update");
		HttpEntity<Persona> request2 = new HttpEntity<>(personaupdate, headers);
		restTemplate.exchange(URL+"/personas", HttpMethod.PUT, request2, new ParameterizedTypeReference<Persona>() { });

		System.out.println("-------LISTAR-tras-UPDATE");
		listar();

	}

	private static void listar() throws Exception {
		List<Persona> entity = restTemplate.getForObject(URL+"/personas", List.class);
		System.out.println(entity);
	}


	public static void main(String[] args) throws Exception {
		
		//testJson( );
		
		//testXml( );

		cliente( );
		
		//testXml2Persona( );
		
	}

}
