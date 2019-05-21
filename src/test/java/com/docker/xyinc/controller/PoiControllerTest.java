package com.docker.xyinc.controller;

import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.docker.xyinc.builder.PoiBuilder;
import com.docker.xyinc.model.Poi;
import com.docker.xyinc.service.PoiService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class PoiControllerTest {

	private final String URL = "http://localhost:8080/poi";
	private List<Poi> pois;
	private List<Poi> poisInRange;
	private ObjectMapper mapper = new ObjectMapper();
	private MockMvc mockMvc;	
	
	@Mock
	private PoiService poiServiceMock;
	
	@InjectMocks
	private PoiService poiService;
	
	@InjectMocks
	private PoiController poiController;
	
	
	@Before
	public void setUp() throws Exception {
		pois = new PoiBuilder().createListPois();
		poisInRange = new PoiBuilder().createListPoisInRange();
		mockMvc = MockMvcBuilders.standaloneSetup(poiController).build();
	}
	
	@Test	
	public void findAllTest() {
		
		Mockito.when(poiServiceMock.findAll()).thenReturn(pois);
			
		try {
			mockMvc.perform(get(URL + "/getAll"))
				.andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
				.andExpect(jsonPath("$", hasSize(7)));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void getInRangeTest() {
		
		Mockito.when(poiServiceMock.getInRange(20, 10, 10)).thenReturn(poisInRange);
		
		try {
			mockMvc.perform(get(URL + "/inRange?x=20&y=10&dMax=10"))
				.andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
				.andExpect(jsonPath("$", hasSize(4)));
		} catch (Exception e) {
			e.printStackTrace();			
		}		
		
	}
	
	@Test
	public void saveTest() {
		Poi poiBuider = new PoiBuilder().buildPoi();
		
		for (Poi poi : pois) {
			try {
				mockMvc.perform(post(URL)
						.contentType(MediaType.APPLICATION_JSON_UTF8)
						.content(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(poiBuider)))
				.andExpect(status().is2xxSuccessful());
			} catch (JsonProcessingException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	/* Teste de cenário de erro, com uma das coordenadas negativas */
	@Test
	public void saveNegativeTest() {
		Poi poi = new Poi("Ponto de Interesse", 5, -2);
		
		try {
			mockMvc.perform(post(URL).contentType(MediaType.APPLICATION_JSON_UTF8)
					.content(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(poi)))
			.andExpect(status().is4xxClientError());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
