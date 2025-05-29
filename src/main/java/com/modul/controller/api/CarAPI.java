package com.modul.controller.api;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.modul.model.CarModel;
import com.modul.service.ICarService;
import com.modul.utils.HttpUtil;


@WebServlet(urlPatterns = {"/api-admin-car"})
public class CarAPI extends  HttpServlet {
	@Inject 
	  private ICarService carService; 

	private static final long serialVersionUID = -915988021506484384L;
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
  	ObjectMapper mapper = new ObjectMapper();

  	request.setCharacterEncoding("UTF-8");
	   response.setContentType("application/json");
	    CarModel carModel=  HttpUtil.of(request.getReader()).toModel(CarModel.class);
	   
	   
	    carModel=carService.save(carModel);
	   mapper.writeValue(response.getOutputStream(),carModel);
  
	}
  
  
  protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
  	ObjectMapper mapper = new ObjectMapper();

  	request.setCharacterEncoding("UTF-8");
	   response.setContentType("application/json");
	    CarModel updateCar =  HttpUtil.of(request.getReader()).toModel(CarModel.class);
	   
	    updateCar =carService.update(updateCar);
	    mapper.writeValue(response.getOutputStream(),updateCar);
  }
  protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
  	ObjectMapper mapper = new ObjectMapper();

  	request.setCharacterEncoding("UTF-8");
	   response.setContentType("application/json");
	   CarModel newModel=  HttpUtil.of(request.getReader()).toModel(CarModel.class);
	   carService.delete(newModel.getIds());
	   mapper.writeValue(response.getOutputStream(),"{}");
 	}

}

