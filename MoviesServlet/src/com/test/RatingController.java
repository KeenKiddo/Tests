package com.test;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.sql.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RatingController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static String LIST_USER = "/listRating.jsp";
    private MovieDao dao;

    public RatingController() {
        super();
        dao = new MovieDao();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String forward="";
        String action = request.getParameter("action");

        if (action.equalsIgnoreCase("listRating")){
            forward = LIST_USER;
            request.setAttribute("ratings", dao.getAllRatings());
        } else {
            forward = LIST_USER;
            request.setAttribute("ratings", dao.getAllRatings());
        }

        RequestDispatcher view = request.getRequestDispatcher(forward);
        view.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
    	Date date;
    	if (request.getParameter("date") != null && !request.getParameter("date").equals("")) 
    		date = Date.valueOf(request.getParameter("date"));
    	else {
    		date = new java.sql.Date(System.currentTimeMillis());
    	}
        RequestDispatcher view = request.getRequestDispatcher(LIST_USER);
        request.setAttribute("ratings", dao.getAllRatingsByDate(date));
        view.forward(request, response);
    }
}
