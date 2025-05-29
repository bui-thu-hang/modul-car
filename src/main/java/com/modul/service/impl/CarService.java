package com.modul.service.impl;

import java.util.List;

import javax.inject.Inject;

import com.modul.dao.ICarDao;
import com.modul.dao.impl.CarDao;
import com.modul.model.CarModel;
import com.modul.paging.Pageble;
import com.modul.service.ICarService;


public class CarService implements ICarService {

    @Inject
    private ICarDao carDao;



    @Override
    public CarModel save(CarModel carModel) {
        Long id = carDao.save(carModel);
        if (id == null) {
            throw new RuntimeException("Failed to save car, no ID generated.");
        }
        return carDao.findOne(id);
    }


    @Override
    public CarModel update(CarModel updateCar) {
        carDao.update(updateCar);
        return carDao.findOne(updateCar.getId());
    }

    @Override
    public void delete(long[] ids) {
        for (long id : ids) {
            carDao.delete((int) id);
        }
    }

    @Override
    public List<CarModel> findAll(Pageble pageble) {
        return carDao.findAll(pageble);
    }

    @Override
    public int getTotalItem() {
        return carDao.getTotalItem();
    }

    @Override
    public CarModel findOne(long id) {
        return carDao.findOne(id);
    }
}
