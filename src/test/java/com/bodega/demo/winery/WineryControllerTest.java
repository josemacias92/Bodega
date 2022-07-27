
package com.bodega.demo.winery;

import static org.junit.jupiter.api.Assertions.*;

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

import com.bodega.demo.wine.Wine;
import com.bodega.demo.wine.WineService;
import com.fasterxml.jackson.databind.ObjectMapper;
@WebMvcTest(WineryController.class)
class WineryControllerTest {


	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private WineryService wineryService;
	
	
	
	@Test
	void getAllWineries() throws Exception {
		
		Winery wineryTest1 = new Winery(100, "testName");
		Winery wineryTest2 = new Winery(200, "testName2");
		
		Mockito
		.when(wineryService.getAll())
		.thenReturn(Arrays.asList(wineryTest1, wineryTest2));
		try {
		mockMvc
		.perform(MockMvcRequestBuilders.get("/api/wineries"))
		.andExpect(MockMvcResultMatchers.status().isOk())
		.andExpect(MockMvcResultMatchers.jsonPath("@.[1].id").value(200))
		.andExpect(MockMvcResultMatchers.jsonPath("@.[1].name").value("testName2"));
		}catch(Exception e) {
			e.printStackTrace();
		}
		
					
	}
	
	@Test
	void getOneById() throws Exception {
		
		Winery wineryTest1 = new Winery(100, "testName");
		Winery wineryTest2 = new Winery(200, "testName2");
		
		Mockito
		.when(wineryService.getOne(200))
		.thenReturn( wineryTest2);
		try {
		mockMvc
		.perform(MockMvcRequestBuilders.get("/api/wineries/200"))
		.andExpect(MockMvcResultMatchers.status().isOk())
		.andExpect(MockMvcResultMatchers.jsonPath("@.id").value(200))
		.andExpect(MockMvcResultMatchers.jsonPath("@.name").value("testName2"));
		}catch(Exception e) {
			e.printStackTrace();
		}
		
					
	}
	
	@Test
	void save() throws Exception {
		Winery wineryTest1 = new Winery(100, "vino");

		Mockito.when(wineryService.save(wineryTest1)).thenReturn(wineryTest1);
		  ObjectMapper objectMapper = new ObjectMapper();
	        String json = objectMapper.writeValueAsString(wineryTest1);
	        
		mockMvc.perform(MockMvcRequestBuilders.post("/api/wineries")
				.contentType(MediaType.APPLICATION_JSON)
				.content(json)
				.characterEncoding("utf-8"))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.jsonPath("@.id").value(100))
				.andExpect(MockMvcResultMatchers.jsonPath("@.name").value("vino"));
	}
		
		
		
	}




