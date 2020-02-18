package com.example.demo;

import org.junit.Test;
import org.junit.runner.RunWith;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class DemoApplicationTests {

    private static String YES = "yes";
    private static String NO = "no";

    @Autowired
    private MockMvc mockMvc;

    private final String BASE_URL  = "hhtp://localhost:8080/connected?origin=%s&destination=%s";


    @Test
    public void positiveRouteTest() throws Exception {

        try (Stream<String> stream = Files.lines(Paths.get(ClassLoader.getSystemResource("input.txt").toURI()))) {
            stream.forEach(line -> shouldHaveValidRoute(line));
        } catch (Exception e) {}
    }

    private void shouldHaveValidRoute(String path) {

        String[] paths = path.split("\\,");
        final String from = paths[0];
        final String to = paths[1];

        final String url =String.format(BASE_URL, from.trim(), to.trim());

        try {
            // make sure to get 200 status
            MvcResult result = mockMvc.perform(MockMvcRequestBuilders
                    .get(url))
                    .andExpect(MockMvcResultMatchers.status().isOk())
                    .andReturn();

            //get valid response
            final String route = result.getResponse().getContentAsString();
            assertEquals(YES, route);
        }
        catch (Exception e) {}
    }

    @Test
    public void negativeRouteTest() throws Exception {
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders
                .get("/connected?origin=Boston&destination=new york"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();

        //get valid response
        final String route = result.getResponse().getContentAsString();
        assertEquals(route,NO);

    }

}
