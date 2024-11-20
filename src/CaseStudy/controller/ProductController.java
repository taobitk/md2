package CaseStudy.controller;

import CaseStudy.entity.Product;
import CaseStudy.service.impl.Producservice;

import java.util.ArrayList;
import java.util.List;

public class ProductController {
   static Producservice producservice = new Producservice();

   public static List<Product> getAll() {
      return producservice.getAll();
   }

   public static void save(Product product) {
      producservice.save(product);
   }

   public static void deletePRD(int id) {
      producservice.remove(id);
   }

   public static Product findPRD(int id) {
      return producservice.findById(id);
   }

   public static void chain(int id) {
      producservice.update(id);
   }
}
