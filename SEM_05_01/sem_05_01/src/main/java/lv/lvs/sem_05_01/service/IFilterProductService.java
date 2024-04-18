package lv.lvs.sem_05_01.service;

import java.util.ArrayList;

import lv.lvs.sem_05_01.model.Product;

public interface IFilterProductService {
	
	public abstract ArrayList<Product> filterByPriceLessThanThreshold(float threshold) 
			throws Exception;
	
	public abstract ArrayList<Product> filterByQuantityLessThanThreshold(int threshold)
			throws Exception;
	
	public abstract ArrayList<Product> filterByTitleOrDescription(String text)
			throws Exception;
	
	public abstract float calculateProductsTotalValue() throws Exception;

}
