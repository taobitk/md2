package CaseStudy.service.impl;

import CaseStudy.entity.Product;
import CaseStudy.repository.ProductRepository;
import CaseStudy.service.IProduct;

import java.util.ArrayList;
import java.util.List;

public class Producservice implements IProduct {
    List<Product> products = new ArrayList<Product>();
    ProductRepository productRepository = new ProductRepository();
    @Override
    public List<Product> getAll() {
     return products = productRepository.getAll();
    }

    @Override
    public List<Product> findByName(String name) {
        return List.of();
    }

    @Override
    public void save(Product s) {
        productRepository.save(s);
    }

    @Override
    public void update(int id) {
        productRepository.chainByID(id);
    }

    @Override
    public void remove(int id) {
        productRepository.deleteByID(id);
    }

    @Override
    public Product findById(int id) {
        return productRepository.findByID(id);
    }


}
