package CaseStudy.service.impl;

import CaseStudy.entity.WaterSalesman;
import CaseStudy.repository.WaterSalesmanRepository;
import CaseStudy.service.IWaterSlalesman;


import java.util.List;

public class WaterSalesmanSevervice implements IWaterSlalesman {
    WaterSalesmanRepository waterSalesmanRepository = new WaterSalesmanRepository();

    @Override
    public List<WaterSalesman> getAll() {
      List<WaterSalesman> waterSalesman = waterSalesmanRepository.getAll();
        return waterSalesman;
    }

    @Override
    public List<WaterSalesman> findByName(String name) {
        return List.of();
    }

    @Override
    public void save(WaterSalesman s) {
        waterSalesmanRepository.save(s);

    }

    @Override
    public void update(int id) {
        waterSalesmanRepository.chain(id);
    }

    @Override
    public void remove(int id) {
        waterSalesmanRepository.deleteByID(id);

    }

    @Override
    public WaterSalesman findById(int id) {
        WaterSalesman waterSalesman = waterSalesmanRepository.findById(id);
        return waterSalesman;
    }


}
