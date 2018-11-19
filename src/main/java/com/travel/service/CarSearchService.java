package com.travel.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import com.travel.dto.Car;
import com.travel.dto.CarResult;
import com.travel.dto.CarSearchResponse;

@Service
public class CarSearchService {

	public void sortCarByPrice(CarSearchResponse carSearchResponse) {
		if (null != carSearchResponse) {
			List<CarResult> carResultList = carSearchResponse.getResults();
			carResultList.forEach(carRes -> Collections.sort(carRes.getCars(), new Comparator<Car>() {
				@Override
				public int compare(Car o1, Car o2) {
					double amt1 = Double.valueOf(o1.getEstimatedTotal().getAmount());
					double amt2 = Double.valueOf(o2.getEstimatedTotal().getAmount());
					if (amt1 < amt2) {
						return -1;
					} else if (amt1 > amt2) {
						return 1;
					}
					return 0;
				}
			}));
		}
	}

	
	public void filterCarByCategory(CarSearchResponse carSearchResponse, String category) {
		if (StringUtils.isNotBlank(category)) {
			List<CarResult> carResultList = carSearchResponse.getResults();
			List<CarResult> carResultList1 = new ArrayList<>();
			for (CarResult carRes : carResultList) {
				CarResult carRes1 = new CarResult();
				carRes1 = carRes;
				List<Car> carList = carRes.getCars();
				carList = carList.stream().filter(c->c.getVehicleInfo().getCategory().equalsIgnoreCase(category)).collect(Collectors.toList());
				if(null!=carList && !carList.isEmpty()){
					carRes1.setCars(carList);
					carResultList1.add(carRes1);
				}
			}
			carSearchResponse.setResults(carResultList1);
		}
	}
	
	public void filterCarByType(CarSearchResponse carSearchResponse, String type) {
		if (StringUtils.isNotBlank(type)) {
			List<CarResult> carResultList = carSearchResponse.getResults();
			List<CarResult> carResultList1 = new ArrayList<>();
			for (CarResult carRes : carResultList) {
				CarResult carRes1 = new CarResult();
				carRes1 = carRes;
				List<Car> carList = carRes.getCars();
				carList = carList.stream().filter(c->c.getVehicleInfo().getType().equalsIgnoreCase(type)).collect(Collectors.toList());
				if(null!=carList && !carList.isEmpty()){
					carRes1.setCars(carList);
					carResultList1.add(carRes1);
				}
			}
			carSearchResponse.setResults(carResultList1);
		}
	}

}
