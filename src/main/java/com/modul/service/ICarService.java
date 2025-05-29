package com.modul.service;

import java.util.List;

import com.modul.model.CarModel;
import com.modul.paging.Pageble;

public interface ICarService {

	CarModel save(CarModel carModel);
	CarModel update(CarModel updateCar);
	void delete (long[] ids);
    List<CarModel>findAll(Pageble pageble);
    int getTotalItem();
    CarModel findOne(long id);
}
