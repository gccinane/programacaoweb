package br.com.services;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/PersonService")
public class PersonService extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			URL url = new URL("https://private-d0fc94-person28.apiary-mock.com/person");
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			
			BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			String output, json = "";
			
			while((output = br.readLine()) != null) {
				json += output;
			}
			
			request.setAttribute("teste", json);
			request.getRequestDispatcher("NewFile.jsp").forward(request, response);;
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.getRequestDispatcher("resultado.jsp").forward(request, response);
		
	}
}





