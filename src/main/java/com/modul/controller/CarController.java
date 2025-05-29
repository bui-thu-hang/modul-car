package com.modul.controller;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.modul.constant.SystemConstant;
import com.modul.model.CarModel;
import com.modul.service.ICarService;
import com.modul.sort.Sorter;
import com.modul.utils.FormUtil;
import com.modul.utils.MessageUtil;
import com.modul.paging.Pageble;
import com.modul.paging.PageRequest;

@WebServlet(urlPatterns = {"/admin-car"})
public class CarController extends HttpServlet{

	private static final long serialVersionUID = 2686801510274002166L;
	
	@Inject 
	private ICarService carService ;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CarModel model=FormUtil.toModel(CarModel.class,request);
		String view ="";
		if (model.getType().equals(SystemConstant.LIST)) {

	        Pageble pageble=new PageRequest (model.getPage(),model.getMaxPageItem(),new Sorter(model.getSortName(),model.getSortBy()));
	        model.setListResult(carService.findAll(pageble));
	        model.setTotalItem(carService.getTotalItem());//kich thước danh sách lấy lên 
	        model.setTotalPage ((int)Math.ceil((double)model.getTotalItem()/model.getMaxPageItem()));
			view ="/views/admin/car/list.jsp";
			
		}
		else if (model.getType().equals(SystemConstant.EDIT)) {
			if (model.getId()!= null ) {
				model=carService.findOne(model.getId());
			}
			
			
			view ="/views/admin/car/edit.jsp";
			}

		   MessageUtil.showMessage(request);
		    request.setAttribute(SystemConstant.MODEL,model);
			RequestDispatcher rd = request.getRequestDispatcher(view);
			rd.forward(request, response);
		
	}
	
}
