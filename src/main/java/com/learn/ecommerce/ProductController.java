package com.learn.ecommerce;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.learn.ecommerce.entity.ProductEntity;
import com.learn.ecommerce.response.BaseResponse;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("api/v1/products")
@AllArgsConstructor
public class ProductController {
    private final ProductService productService;

    /**
     * Handles HTTP GET requests for retrieving a paginated list of products.
     *
     * @param page the page number to retrieve, default is 1
     * @param size the number of products per page, default is 100
     * @param q    the query string to filter products by name, default is an empty
     *             string
     * @return a BaseResponse containing the status, message, and list of products
     */

    @GetMapping
    BaseResponse getProducts(
            @RequestParam(defaultValue = "1") Integer page,
            @RequestParam(defaultValue = "100") Integer size,
            @RequestParam(required =  false, name="categoryId") Integer categoryId,
            @RequestParam(required = false) String q) {
        BaseResponse response = new BaseResponse();
        try {
            List<ProductEntity> products = productService.getProducts(page, size, q,categoryId);

            response.setStatus(true);
            response.setMessage("Success");
            response.setData(products);
            return response;
        } catch (Exception e) {

            response.setStatus(false);
            response.setMessage(e.getMessage());
            return response;
        }
    }
}
