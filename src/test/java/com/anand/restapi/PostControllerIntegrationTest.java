package com.anand.restapi;
import com.anand.restapi.dto.CreatePostRequest;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
@SpringBootTest @AutoConfigureMockMvc
class PostControllerIntegrationTest {
 @Autowired private MockMvc mockMvc; @Autowired private ObjectMapper objectMapper;
 @Test void createsThenListsAPost() throws Exception {
  CreatePostRequest request=new CreatePostRequest("First post","Created through the POST API");
  mockMvc.perform(post("/api/posts").contentType(MediaType.APPLICATION_JSON).content(objectMapper.writeValueAsString(request))).andExpect(status().isCreated()).andExpect(jsonPath("$.success").value(true)).andExpect(jsonPath("$.data.title").value("First post"));
  mockMvc.perform(get("/api/posts")).andExpect(status().isOk()).andExpect(jsonPath("$.success").value(true)).andExpect(jsonPath("$.data[0].content").value("Created through the POST API"));
 }
 @Test void rejectsAnInvalidPost() throws Exception { mockMvc.perform(post("/api/posts").contentType(MediaType.APPLICATION_JSON).content("{\"title\":\"\",\"content\":\"\"}")).andExpect(status().isBadRequest()).andExpect(jsonPath("$.success").value(false)).andExpect(jsonPath("$.data.title").value("Title is required")); }
}
