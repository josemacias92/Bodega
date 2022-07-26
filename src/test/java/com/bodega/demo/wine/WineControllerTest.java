package com.bodega.demo.wine;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.bodega.demo.winery.Winery;
import com.bodega.demo.winery.WineryController;
@WebMvcTest(WineController.class)
class WineControllerTest {

	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private WineService wineService;
	
	
	@Test
	void getAllWines() throws Exception {
		
		Wine wineTest1 = new Wine(100, "vino", "26/07/2022", 12f, 13, 10f, "cuerpo", "acidez", 1, 1, 1 );
		Wine wineTest2 = new Wine(200, "testName2", "07/26/2022", 12f, 1, 13f, "cuerpo", "acido", 2, 2, 2);
		
		Mockito
		.when(wineService.getAll())
		.thenReturn(Arrays.asList(wineTest1, wineTest2));
		try {
		mockMvc
		.perform(MockMvcRequestBuilders.get("/api/wines"))
		.andExpect(MockMvcResultMatchers.status().isOk())
		.andExpect(MockMvcResultMatchers.jsonPath("@.[1].id").value(200))
		.andExpect(MockMvcResultMatchers.jsonPath("@.[1].name").value("testName2"));
		}catch(Exception e) {
			e.printStackTrace();
		}
					
	}
	
	@Test
	void getOneById() throws Exception {
		
		Wine wineTest1 = new Wine(100, "vino", "26/07/2022", 12f, 13, 10f, "cuerpo", "acidez", 1, 1, 1 );
		Wine wineTest2 = new Wine(200, "testName2", "07/26/2022", 12f, 1, 13f, "cuerpo", "acido", 2, 2, 2);
		
		Mockito
		.when(wineService.getOne(200))
		.thenReturn( wineTest2);
		try {
		mockMvc
		.perform(MockMvcRequestBuilders.get("/api/wines/200"))
		.andExpect(MockMvcResultMatchers.status().isOk())
		.andExpect(MockMvcResultMatchers.jsonPath("@.id").value(200))
		.andExpect(MockMvcResultMatchers.jsonPath("@.name").value("testName2"));
		}catch(Exception e) {
			e.printStackTrace();
		}
		
					
	}
		
		
		
	}