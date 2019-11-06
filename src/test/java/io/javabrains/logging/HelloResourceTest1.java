package io.javabrains.logging;

//import static org.junit.Assert.*;

import io.javabrains.logging.service.HelloService;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@RunWith(SpringJUnit4ClassRunner.class)
public class HelloResourceTest1 {

    private MockMvc mockMvc;

    @Mock
    private HelloService helloService;

    @InjectMocks
    private HelloResource helloResource;

    @Before
    public void setUp() throws Exception {
        mockMvc = MockMvcBuilders.standaloneSetup(helloResource).build();
    }

    @Test
    public void testHelloWorld() throws Exception {
        Mockito.when(helloService.hello()).thenReturn("hello");
        mockMvc.perform(MockMvcRequestBuilders.get("/"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("hello"));
        Mockito.verify(helloService).hello();
        /*mockMvc.perform(MockMvcRequestBuilders.get("/"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("Hello from Spring boot!"));
*/    }

    @Test
    public void testHelloWorldJson() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/json")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.title", Matchers.is("Greetings")))
                .andExpect(MockMvcResultMatchers.jsonPath("$.value", Matchers.is("Hello World")))
                .andExpect(MockMvcResultMatchers.jsonPath("$.*", Matchers.hasSize(2)));
    }

    @Test
    public void testPost() throws Exception {
        String json = "{\n" +
                "  \"title\": \"Greetings\",\n" +
                "  \"value\": \"Hello World\"\n" +
                "}";
        mockMvc.perform(post("/post")
        .contentType(MediaType.APPLICATION_JSON)
        .content(json))
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.jsonPath("$.title", Matchers.is("Greetings")))
        .andExpect(MockMvcResultMatchers.jsonPath("$.value", Matchers.is("Hello World")))
        .andExpect(MockMvcResultMatchers.jsonPath("$.*", Matchers.hasSize(2)));
    }
}