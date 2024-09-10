package com.bridgelabz.user.management.system;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AddUser extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Connection conn = null;
		PreparedStatement pstm = null;

		int userId = Integer.parseInt(req.getParameter("userId"));
		String userName = req.getParameter("userName");
		String userEmail = req.getParameter("userEmail");
		String userPassword = req.getParameter("userPassword");
		String reuserPassword = req.getParameter("reuserPassword");
		String userAddress = req.getParameter("userAddress");


		if(userPassword.equals(reuserPassword)) {
		try {
			// Load the JDBC driver
			Class.forName("com.mysql.cj.jdbc.Driver");

			// Establish connection
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/userdatabase?createDatabaseIfNotExist=true", "root", "root");

			// Prepare SQL statement
			pstm = conn.prepareStatement("INSERT INTO users(userId, userName, userEmail, userPassword, userAddress) VALUES(?, ?, ?, ?,?)");
			pstm.setInt(1, userId);
			pstm.setString(2, userName);
			pstm.setString(3, userEmail);
			pstm.setString(4, userPassword);
			pstm.setString(5, userAddress);

			// Execute update
			int rowsInserted = pstm.executeUpdate();
			if (rowsInserted > 0) {
				resp.getWriter().write("User added successfully!");
				resp.sendRedirect("registersucessfully.jsp");
			} else {
				resp.getWriter().write("Failed to add user.");
			}

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			resp.getWriter().write("Error: " + e.getMessage());
		} finally {
			// Close resources
			try {
				if (pstm != null) pstm.close();
				if (conn != null) conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		}
		else {
			resp.getWriter().write("reentered password doesnot match to add user.");
		}
	}
}
