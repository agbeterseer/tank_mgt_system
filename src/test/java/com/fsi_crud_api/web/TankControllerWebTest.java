/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fsi_crud_api.web;

import com.fsi_crud_api.FsiCrudApiApplication;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

/**
 *
 * @author Terseer
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = FsiCrudApiApplication.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TankControllerWebTest {

    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext wac;

    @Before
    public void setup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();

    }

    @Test
    public void verifyAllTankList() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/tanks").accept(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$", hasSize(4))).andDo(print());
    }

    @Test
    public void verifyTankById() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/tanks/3").accept(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id").exists())
                .andExpect(jsonPath("$.name").exists()) 
                .andExpect(jsonPath("$.id").value(3))
                .andExpect(jsonPath("$.name").value("TANK001"))
                .andDo(print());
    }

    @Test
    public void verifyInvalidTankArgument() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/tanks/f").accept(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.errorCode").value(400))
                .andExpect(jsonPath("$.message").value("The request could not be understood by the server due to malformed syntax."))
                .andDo(print());
    }

    @Test
    public void verifyInvalidTankId() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/tanks/0").accept(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.errorCode").value(404))
                .andExpect(jsonPath("$.message").value("Tank doesn´t exist"))
                .andDo(print());
    }

    @Test
    public void verifyNullTank() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/tanks/6").accept(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.errorCode").value(404))
                .andExpect(jsonPath("$.message").value("ToDo doesn´t exist"))
                .andDo(print());
    }

    @Test
    public void verifyDeleteTank() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.delete("/tanks/4").accept(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.status").value(200))
                .andExpect(jsonPath("$.message").value("Tank has been deleted"))
                .andDo(print());
    }

    @Test
    public void verifyInvalidTankDelete() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.delete("/tanks/9").accept(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.errorCode").value(404))
                .andExpect(jsonPath("$.message").value("Tank to delete doesn´t exist"))
                .andDo(print());
    }

    @Test
    public void verifyAddTank() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/tanks/")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"name\" : \"TANKO\", \"tanktype\" : \"TANK0V1\" , \"liter\" : \"42342\", \"dispenserid\" : \"2\" }")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id").exists())
                .andExpect(jsonPath("$.name").exists())
                .andExpect(jsonPath("$.tanktype").value("TANK0V1"))
                .andExpect(jsonPath("$.liter").exists())
                .andExpect(jsonPath("$.dispenserid").exists())
                .andDo(print());
    }

    @Test
    public void verifyMalformedAddTank() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/tanks/")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{ \"id\": \"8\", \"name\" : \"TANKO\", \"tnaktype\" : \"TANK0V1\", \"liter\" : \"42342\", \"dispenserid\" : \"2\" }")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.errorCode").value(404))
                .andExpect(jsonPath("$.message").value("Payload malformed, id must not be defined"))
                .andDo(print());
    }

    @Test
    public void verifyUpdateTank() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.patch("/tanks/")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"id\": \"8\", \"name\" : \"TANKO\", \"tnaktype\" : \"TANK0V1\", \"liter\" : \"42342\", \"dispenserid\" : \"2\" }")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id").exists())
                .andExpect(jsonPath("$.name").exists())
                .andExpect(jsonPath("$.tanktype").exists())
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.name").value("TANKO"))
                .andExpect(jsonPath("$.liter").exists())
                .andDo(print());
    }

    @Test
    public void verifyInvalidTankUpdate() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.patch("/tanks/")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{ \"idd\": \"8\", \"name\" : \"TANKO\", \"tnaktype\" : \"TANK0V1\", \"liter\" : \"42342\", \"dispenserid\" : \"2\" }")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.errorCode").value(404))
                .andExpect(jsonPath("$.message").value("Tank to update doesn´t exist"))
                .andDo(print());
    }

}
