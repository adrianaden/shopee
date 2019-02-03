package org.shopee.adrianaden.challenge.api.service;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.shopee.adrianaden.challenge.api.entity.Product;
import org.shopee.adrianaden.challenge.api.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductServiceTestCase {

    @Autowired
    private ProductService productService;

    @MockBean
    private ProductRepository productRepository;

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
    public void createSuccess(){
        Product product = new Product();
        product.setId(1L);
        product.setName("Big Mac");
        product.setProductTypeCode(1);
        product.setPrice(1000L);

        Mockito.when(productRepository.save(Mockito.any(Product.class))).thenReturn(productMock);
        Product actual = productService.create(product);

        Assert.assertEquals(productMock.getId(), actual.getId());
        Assert.assertEquals(productMock.getName(), actual.getName());
        Assert.assertEquals(productMock.getProductTypeCode(), actual.getProductTypeCode());
        Assert.assertEquals(productMock.getPrice(), actual.getPrice());
    }

}
