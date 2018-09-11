package menu;

import java.util.ArrayList;

import org.junit.Test;

import car.dao.CarDaoIMP;
import car.pojo.Car;

public class Cartest {
	
	@Test
	public void test() throws Exception {
		CarDaoIMP carDaoIMP = new CarDaoIMP();
		carDaoIMP.addProduct("ruibaba", "1", 5);
		
		ArrayList<Car> allProductFromCar = carDaoIMP.getAllProductFromCar();
		for(Car tmp:allProductFromCar) {
			System.out.println(tmp);
		}

		
	}
}
