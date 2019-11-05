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
public class DispenserControllerWebTest {

    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext wac;

    @Before
    public void setup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();

    }

    @Test
    public void verifyAllTankList() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/dispensers").accept(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$", hasSize(4))).andDo(print());
    }

    @Test
    public void verifyTankById() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/dispensers/3").accept(MediaType.APPLICATION_JSON))
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
        mockMvc.perform(MockMvcRequestBuilders.get("/dispensers/0").accept(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.errorCode").value(404))
                .andExpect(jsonPath("$.message").value("Tank doesn´t exist"))
                .andDo(print());
    }

    @Test
    public void verifyNullDenspenser() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/dispensers/6").accept(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.errorCode").value(404))
                .andExpect(jsonPath("$.message").value("ToDo doesn´t exist"))
                .andDo(print());
    }

    @Test
    public void verifyDeleteDespenser() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.delete("/dispensers/4").accept(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.status").value(200))
                .andExpect(jsonPath("$.message").value("Denspenser has been deleted"))
                .andDo(print());
    }

    @Test
    public void verifyInvalidDespenserDelete() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.delete("/dispensers/9").accept(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.errorCode").value(404))
                .andExpect(jsonPath("$.message").value("Denspenser to delete doesn´t exist"))
                .andDo(print());
    }

    @Test
    public void verifyAddDispenser() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/dispensers/")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"name\" : \"TANKO\", \"tanktype\" : \"TANK0V1\" , \"liter\" : \"42342\", \"dispenserid\" : \"2\" }")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id").exists())
                .andExpect(jsonPath("$.name").exists())
                .andExpect(jsonPath("$.hscode").exists())
                .andExpect(jsonPath("$.magnitudeofdischarge").exists())
                .andExpect(jsonPath("$.operationmode").exists())
                .andExpect(jsonPath("$.oiltransportationmode").exists()) 
                .andDo(print());
    }

    @Test
    public void verifyMalformedAddDispenser() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/dispensers/")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"id\": \"8\", \"name\" : \"DPANKO\", \"hscode\" : \"00093D\", \"modelno\" : \"MODEL002\", \"magnitudeofdischarge\" : \"Standard\", \"operationmode\" : \"Manual\", \"oiltransportationmode\" : \"Automatic\" }")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.errorCode").value(404))
                .andExpect(jsonPath("$.message").value("Payload malformed, id must not be defined"))
                .andDo(print());
    }

    @Test
    public void verifyUpdateDispenser() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.patch("/dispensers/")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"id\": \"8\", \"name\" : \"DPANKO\", \"hscode\" : \"00093D\", \"modelno\" : \"MODEL002\", \"magnitudeofdischarge\" : \"Standard\", \"operationmode\" : \"Manual\", \"oiltransportationmode\" : \"Automatic\" }")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id").exists())
                .andExpect(jsonPath("$.name").exists())
                .andExpect(jsonPath("$.hscode").exists())
                .andExpect(jsonPath("$.magnitudeofdischarge").exists())
                .andExpect(jsonPath("$.operationmode").exists())
                .andExpect(jsonPath("$.oiltransportationmode").exists())
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.name").value("DPANKO"))
                .andExpect(jsonPath("$.modelno").exists())
                .andDo(print());
    }

    @Test
    public void verifyInvalidDispenserUpdate() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.patch("/dispensers/")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{ \"idd\": \"8\", \"name\" : \"DPANKO\", \"hscode\" : \"00093D\", \"modelno\" : \"MODEL002\", \"magnitudeofdischarge\" : \"Standard\", \"operationmode\" : \"Manual\", \"oiltransportationmode\" : \"Automatic\" }")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.errorCode").value(404))
                .andExpect(jsonPath("$.message").value("Denspenser to update doesn´t exist"))
                .andDo(print());
    }

}
