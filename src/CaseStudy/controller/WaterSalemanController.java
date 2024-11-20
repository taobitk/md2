package CaseStudy.controller;

import CaseStudy.entity.WaterSalesman;
import CaseStudy.service.impl.WaterSalesmanSevervice;

import java.util.ArrayList;
import java.util.List;

public class WaterSalemanController {
   static WaterSalesmanSevervice waterSalesmanSevervice = new WaterSalesmanSevervice();

    public static List<WaterSalesman> getAll() {
        return waterSalesmanSevervice.getAll();
    }

    public static void save(WaterSalesman ws) {
        waterSalesmanSevervice.save(ws);
    }

    public static void deleteWS(int id) {
        waterSalesmanSevervice.remove(id);

    }

    public static WaterSalesman findWS(int id) {
        return waterSalesmanSevervice.findById(id);
    }

    public static void chain(int cId) {
         waterSalesmanSevervice.update(cId);
    }
}
