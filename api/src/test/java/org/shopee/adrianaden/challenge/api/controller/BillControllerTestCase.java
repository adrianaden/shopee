package org.shopee.adrianaden.challenge.api.controller;


import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.shopee.adrianaden.challenge.api.dto.BillSummary;
import org.shopee.adrianaden.challenge.api.entity.Product;
import org.shopee.adrianaden.challenge.api.service.BillService;
import org.shopee.adrianaden.challenge.api.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;


@RunWith(SpringRunner.class)
@WebMvcTest(BillController.class)
public class BillControllerTestCase {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private BillService billService;


    @Before
    public void preDefine(){

    }

    @Test
    public void findAllSuccess() throws Exception {
        Mockito.when(billService
                .findAll())
                .thenReturn(new BillSummary());

        MockHttpServletRequestBuilder requestBuilders = MockMvcRequestBuilders
                .get("/api" + "/bill")
                .servletPath("/bill")
                .contextPath("/api")
                .contentType(MediaType.APPLICATION_JSON);

        mockMvc.perform(requestBuilders)
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk());
    }
}
