package com.bodega.demo.type;

import java.util.Arrays;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.fasterxml.jackson.databind.ObjectMapper;

@WebMvcTest(TypeController.class)
class TypeControllerTest {

	@MockBean
	private TypeService typeService;
	
	@Autowired
	private MockMvc mockMvc;
	
	@Test
	void showAllTest() throws Exception {
		Type test1 = new Type(1, "testName");
		Type test2 = new Type(2, "testName2");

		Mockito.when(typeService.getAll()).thenReturn(Arrays.asList(test1, test2));


		mockMvc.perform(MockMvcRequestBuilders.get("/api/types")).andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.jsonPath("@.[0].id").value(1))
				.andExpect(MockMvcResultMatchers.jsonPath("@.[1].name").value("testName2"));
	}
	
	@Test
	void showOneTest() throws Exception {
		Type test = new Type(1, "testName");

		Mockito.when(typeService.getOne(1)).thenReturn(test);

		mockMvc.perform(MockMvcRequestBuilders.get("/api/types/1")).andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.jsonPath("@.id").value(1))
				.andExpect(MockMvcResultMatchers.jsonPath("@.name").value("testName"));
	}
	
	@Test
	@WithMockUser(username = "admin", password = "1234", roles = { "USER" })
	void saveTest() throws Exception {
		Type test = new Type(1, "testName");

		ObjectMapper objectMapper = new ObjectMapper();
	    String json = objectMapper.writeValueAsString(test);
	        
		mockMvc.perform(MockMvcRequestBuilders.post("/api/types")
				.contentType(MediaType.APPLICATION_JSON)
				.content(json)
				.characterEncoding("utf-8"))
				.andExpect(MockMvcResultMatchers.status().isOk());
	}
	
	@Test
	@WithMockUser(username = "admin", password = "123", roles = { "USER" })
	void editTest() throws Exception {
		Type test = new Type(1, "testName");

		ObjectMapper objectMapper = new ObjectMapper();
	    String json = objectMapper.writeValueAsString(test);
	        
		mockMvc.perform(MockMvcRequestBuilders.put("/api/types")
				.contentType(MediaType.APPLICATION_JSON)
				.content(json))
				.andExpect(MockMvcResultMatchers.status().isOk());
	}
	
	@Test
	@WithMockUser(username = "admin", password = "123", roles = { "ADMIN" })
	void deleteTest_withValidUser()  throws Exception {
	        
		mockMvc.perform(MockMvcRequestBuilders.delete("/api/types/1"))
				.andExpect(MockMvcResultMatchers.status().isOk());
	}
	
	@Test
	@WithMockUser(username = "admin", password = "123", roles = { "USER" })
	void deleteTest_withNonValidUser() throws Exception {
	        
		mockMvc.perform(MockMvcRequestBuilders.delete("/api/types/1"))
				.andExpect(MockMvcResultMatchers.status().isForbidden());
	}
}
