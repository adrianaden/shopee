package org.shopee.adrianaden.challenge.api.controller;


import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.shopee.adrianaden.challenge.api.entity.Product;
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
@WebMvcTest(ProductController.class)
public class ProductControllerTestCase {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ProductService productService;

    private Product productMock;

    @Before
    public void preDefine(){
        productMock = new Product();
        productMock.setId(1L);
        productMock.setName("Big Mac");
        productMock.setProductTypeCode(1);
        productMock.setPrice(1000L);
    }

    @Test
    public void createSuccess() throws Exception {
        Mockito.when(productService
                .create(Mockito.any(Product.class)))
                .thenReturn(productMock);

        MockHttpServletRequestBuilder requestBuilders = MockMvcRequestBuilders
                .post("/api" + "/product")
                .servletPath("/product")
                .contextPath("/api")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{ \"name\": \"Big Mac\", \"productTypeCode\": 1, \"price\": 1000 }");

        mockMvc.perform(requestBuilders)
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk());
    }
}
