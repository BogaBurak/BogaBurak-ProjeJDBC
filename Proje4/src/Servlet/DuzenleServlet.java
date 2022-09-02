package Servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
import ProjeSql.AddressDuzenle;
@WebServlet("/duzenle")

public class DuzenleServlet extends HttpServlet {
 private static final long serialVersionUID = 1L;
 
protected void doGet(HttpServletRequest request,
 HttpServletResponse response) throws ServletException, IOException {
 doPost(request, response);
 }
 
protected void doPost(HttpServletRequest request,
 HttpServletResponse response) throws ServletException, IOException {
	String id = request.getParameter("id");
	String adressCode = request.getParameter("adressCode");
	  String adressType = request.getParameter("adressType");
	  String adress = request.getParameter("adress");
	  String district = request.getParameter("district");
	  String zipcode = request.getParameter("zipcode");
	  String city = request.getParameter("city");
 
 int durum = new AddressDuzenle().AddressDuzenle(Integer.valueOf(id), adressCode, adressType, adress, district, zipcode,  city);
 
 response.sendRedirect("index.jsp");
 }
	 }