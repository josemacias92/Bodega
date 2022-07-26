package com.bodega.demo.region;


import java.util.Arrays;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.fasterxml.jackson.databind.ObjectMapper;

@WebMvcTest(RegionController.class)
class RegionControllerTest {
	
	@MockBean
	private RegionService regionService;
	
	@Autowired
	private MockMvc mockMvc;
	
	@Test
	void showAllTest() throws Exception {
		Region test1 = new Region(1, "testName", "España");
		Region test2 = new Region(2, "testName2", "España");

		Mockito.when(regionService.getAll()).thenReturn(Arrays.asList(test1, test2));


		mockMvc.perform(MockMvcRequestBuilders.get("/api/regions")).andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.jsonPath("@.[0].id").value(1))
				.andExpect(MockMvcResultMatchers.jsonPath("@.[1].name").value("testName2"));
	}
	
	@Test
	void showOneTest() throws Exception {
		Region test = new Region(1, "testName", "España");

		Mockito.when(regionService.getOne(1)).thenReturn(test);

		mockMvc.perform(MockMvcRequestBuilders.get("/api/regions/1")).andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.jsonPath("@.id").value(1))
				.andExpect(MockMvcResultMatchers.jsonPath("@.name").value("testName"));
	}
	
	@Test
	void save() throws Exception {
		Region test = new Region(1, "testName", "España");

		Mockito.when(regionService.save(test)).thenReturn(test);
		  ObjectMapper objectMapper = new ObjectMapper();
	        String json = objectMapper.writeValueAsString(test);
	        
		mockMvc.perform(MockMvcRequestBuilders.post("/api/regions")
				.contentType(MediaType.APPLICATION_JSON)
				.content(json)
				.characterEncoding("utf-8"))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.jsonPath("@.id").value(1))
				.andExpect(MockMvcResultMatchers.jsonPath("@.name").value("testName"));
	}

}
