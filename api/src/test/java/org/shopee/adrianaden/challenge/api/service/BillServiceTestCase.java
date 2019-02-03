package org.shopee.adrianaden.challenge.api.service;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.shopee.adrianaden.challenge.api.common.type.product.EntertainmentProductCategory;
import org.shopee.adrianaden.challenge.api.common.type.product.FoodBeverageProductCategory;
import org.shopee.adrianaden.challenge.api.common.type.product.ProductCategory;
import org.shopee.adrianaden.challenge.api.common.type.product.TobaccoProductCategory;
import org.shopee.adrianaden.challenge.api.dto.BillSummary;
import org.shopee.adrianaden.challenge.api.dto.ProductSummary;
import org.shopee.adrianaden.challenge.api.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BillServiceTestCase {

    @Autowired
    private BillService billService;

    @MockBean
    private ProductService productService;

    private List<Product> productMocks;

    @Before
    public void preDefine() {
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
    public void findAllSuccess() {
        Mockito.when(productService.findAll()).thenReturn(productMocks);

        BillSummary actual = billService.findAll();

        Assert.assertEquals(actual.getProductSummaries().get(0).getName(), productMocks.get(0).getName());

        Assert.assertEquals(actual.getProductSummaries().get(0).getCategoryCode(), productMocks.get(0).getProductCategoryCode());
        Assert.assertEquals(actual.getProductSummaries().get(0).getPrice(), productMocks.get(0).getPrice());
        Assert.assertEquals(actual.getProductSummaries().get(0).getCategory(), new FoodBeverageProductCategory().getName());
        Assert.assertEquals(actual.getProductSummaries().get(0).getTaxAmount(), new FoodBeverageProductCategory().calculateTax(productMocks.get(0).getPrice()), 0);
        Assert.assertEquals(actual.getProductSummaries().get(0).getIsRefundable(), new FoodBeverageProductCategory().isRefundable());
        Assert.assertEquals(actual.getProductSummaries().get(0).getAmount(), productMocks.get(0).getPrice() + new FoodBeverageProductCategory().calculateTax(productMocks.get(0).getPrice()), 0);

        Assert.assertEquals(actual.getProductSummaries().get(1).getCategoryCode(), productMocks.get(1).getProductCategoryCode());
        Assert.assertEquals(actual.getProductSummaries().get(1).getPrice(), productMocks.get(1).getPrice());
        Assert.assertEquals(actual.getProductSummaries().get(1).getCategory(), new TobaccoProductCategory().getName());
        Assert.assertEquals(actual.getProductSummaries().get(1).getTaxAmount(), new TobaccoProductCategory().calculateTax(productMocks.get(1).getPrice()), 0);
        Assert.assertEquals(actual.getProductSummaries().get(1).getIsRefundable(), new TobaccoProductCategory().isRefundable());
        Assert.assertEquals(actual.getProductSummaries().get(1).getAmount(), productMocks.get(1).getPrice() + new TobaccoProductCategory().calculateTax(productMocks.get(1).getPrice()), 0);

        Assert.assertEquals(actual.getProductSummaries().get(2).getCategoryCode(), productMocks.get(2).getProductCategoryCode());
        Assert.assertEquals(actual.getProductSummaries().get(2).getPrice(), productMocks.get(2).getPrice());
        Assert.assertEquals(actual.getProductSummaries().get(2).getCategory(), new EntertainmentProductCategory().getName());
        Assert.assertEquals(actual.getProductSummaries().get(2).getTaxAmount(), new EntertainmentProductCategory().calculateTax(productMocks.get(2).getPrice()), 0);
        Assert.assertEquals(actual.getProductSummaries().get(2).getIsRefundable(), new EntertainmentProductCategory().isRefundable());
        Assert.assertEquals(actual.getProductSummaries().get(2).getAmount(), productMocks.get(2).getPrice() + new EntertainmentProductCategory().calculateTax(productMocks.get(2).getPrice()), 0);

        Assert.assertEquals(actual.getPriceSubTotal(), 2150.0, 0);
        Assert.assertEquals(actual.getTaxSubTotal(), 130.5, 0);
        Assert.assertEquals(actual.getGrandSubTotal(), 2019.5, 0);

    }

    @Test
    public void findAllSuccess_Entertainment() {
        productMocks.clear();
        Product product = new Product();
        product.setName("Movie");
        product.setProductCategoryCode(3);
        product.setPrice(99L);
        productMocks.add(product);

        Mockito.when(productService.findAll()).thenReturn(productMocks);

        BillSummary actual = billService.findAll();

        Assert.assertEquals(actual.getProductSummaries().get(0).getName(), productMocks.get(0).getName());

        Assert.assertEquals(actual.getProductSummaries().get(0).getCategoryCode(), productMocks.get(0).getProductCategoryCode());
        Assert.assertEquals(actual.getProductSummaries().get(0).getPrice(), productMocks.get(0).getPrice());
        Assert.assertEquals(actual.getProductSummaries().get(0).getCategory(), new EntertainmentProductCategory().getName());
        Assert.assertEquals(actual.getProductSummaries().get(0).getTaxAmount(), new EntertainmentProductCategory().calculateTax(productMocks.get(0).getPrice()), 0);
        Assert.assertEquals(actual.getProductSummaries().get(0).getIsRefundable(), new EntertainmentProductCategory().isRefundable());
        Assert.assertEquals(actual.getProductSummaries().get(0).getAmount(), productMocks.get(0).getPrice() + new EntertainmentProductCategory().calculateTax(productMocks.get(0).getPrice()), 0);

        Assert.assertEquals(actual.getPriceSubTotal(), 99, 0);
        Assert.assertEquals(actual.getTaxSubTotal(), 0, 0);
        Assert.assertEquals(actual.getGrandSubTotal(), 99.0, 0);

    }


    @Test
    public void findAllSuccess_Uncategorized() {
        productMocks.clear();
        Product product = new Product();
        product.setName("Headphone");
        product.setProductCategoryCode(4);
        product.setPrice(5000000L);
        productMocks.add(product);

        Mockito.when(productService.findAll()).thenReturn(productMocks);

        BillSummary actual = billService.findAll();

        Assert.assertEquals(actual.getProductSummaries().get(0).getName(), productMocks.get(0).getName());

        Assert.assertEquals(actual.getProductSummaries().get(0).getCategoryCode(), productMocks.get(0).getProductCategoryCode());
        Assert.assertEquals(actual.getProductSummaries().get(0).getPrice(), productMocks.get(0).getPrice());
        Assert.assertEquals(actual.getProductSummaries().get(0).getCategory(), new ProductCategory().getName());
        Assert.assertEquals(actual.getProductSummaries().get(0).getTaxAmount(), new ProductCategory().calculateTax(productMocks.get(0).getPrice()), 0);
        Assert.assertEquals(actual.getProductSummaries().get(0).getIsRefundable(), new ProductCategory().isRefundable());
        Assert.assertEquals(actual.getProductSummaries().get(0).getAmount(), productMocks.get(0).getPrice() + new ProductCategory().calculateTax(productMocks.get(0).getPrice()), 0);

        Assert.assertEquals(actual.getPriceSubTotal(), 5000000, 0);
        Assert.assertEquals(actual.getTaxSubTotal(), 0, 0);
        Assert.assertEquals(actual.getGrandSubTotal(), 5000000.0, 0);

    }
}
