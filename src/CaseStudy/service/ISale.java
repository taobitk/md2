package CaseStudy.service;

import java.util.List;

public interface ISale<T> {
    List<T> getAll();
    List<T> findByName(String name);
    void save(T s);
    void update(int id);
    void remove(int id);
    T findById(int id);
}
