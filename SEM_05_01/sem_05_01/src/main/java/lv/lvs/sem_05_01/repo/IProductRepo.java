package lv.lvs.sem_05_01.repo;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;

import lv.lvs.sem_05_01.model.Product;

public interface IProductRepo extends CrudRepository<Product, Integer>{

    ArrayList<Product> findByQuantityLessThan(int threshold);

    ArrayList<Product> findByPriceLessThan(float threshold);

    ArrayList<Product> findByTitleContainingOrDescriptionContaining(String text, String text2);

    Product findByTitleAndDescriptionAndPrice(String title, String description, float price);

}