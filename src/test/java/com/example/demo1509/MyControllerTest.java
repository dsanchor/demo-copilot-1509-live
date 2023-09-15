// BEGIN: 1c2d3e4f5g6h
package com.example.demo1509;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@WebMvcTest(MyController.class)
public class MyControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testSayHello() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/hello"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("Hello, world!"));
    }

    @Test
    public void testReverseText() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/reverse").param("text", "hello"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("olleh"));
    }

    @Test
    public void testReverseTextWithSpaces() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/reverse").param("text", "hello world"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("dlrow olleh"));
    }

    @Test
    public void testReverseTextWithSpecialCharacters() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/reverse").param("text", "hello, world!"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("!dlrow ,olleh"));
    }

    @Test
    public void testDisemvowelText() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/disemvowel").param("text", "hello"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("hll"));
    }

    @Test
    public void testDisemvowelTextWithSpaces() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/disemvowel").param("text", "hello world"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("hll wrld"));
    }
}
// END: 1c2d3e4f5g6h