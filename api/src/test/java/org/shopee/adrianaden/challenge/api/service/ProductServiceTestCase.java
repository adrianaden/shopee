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

import java.util.ArrayList;
import java.util.List;


@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductServiceTestCase {

    @Autowired
    private ProductService productService;

    @MockBean
    private ProductRepository productRepository;

    private Product productMock;
    private List<Product> productMocks;

    @Before
    public void preDefine(){
        productMock = new Product();
        productMock.setId(1L);
        productMock.setName("Big Mac");
        productMock.setProductCategoryCode(1);
        productMock.setPrice(1000L);

        Product product1 = new Product();
        product1.setName("Big Mac");
        product1.setProductCategoryCode(1);
        product1.setPrice(1000L);

        Product product2 = new Product();
        product2.setName("Lucky Stretch");
        product2.setProductCategoryCode(2);
        product2.setPrice(1000L);

        Product product3 = new Product();
        product3.setName("Movie");
        product3.setProductCategoryCode(3);
        product3.setPrice(150L);

        productMocks = new ArrayList<>();
        productMocks.add(product1);
        productMocks.add(product2);
        productMocks.add(product3);
    }

    @Test
    public void createSuccess(){
        Product product = new Product();
        product.setId(1L);
        product.setName("Big Mac");
        product.setProductCategoryCode(1);
        product.setPrice(1000L);

        Mockito.when(productRepository.save(Mockito.any(Product.class))).thenReturn(productMock);
        Product actual = productService.create(product);

        Assert.assertEquals(productMock.getId(), actual.getId());
        Assert.assertEquals(productMock.getName(), actual.getName());
        Assert.assertEquals(productMock.getProductCategoryCode(), actual.getProductCategoryCode());
        Assert.assertEquals(productMock.getPrice(), actual.getPrice());
    }

    @Test
    public void findAllSuccess(){

        Mockito.when(productRepository.findAll()).thenReturn(productMocks);
        List<Product> actual = productService.findAll();

        Assert.assertEquals(productMocks.size(), actual.size());
    }

}
