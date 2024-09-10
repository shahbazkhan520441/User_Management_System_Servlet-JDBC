package com.bridgelabz.user.management.system;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SignIn extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String userEmail = req.getParameter("userEmail");
		String userPassword = req.getParameter("userPassword");
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			// Load MySQL JDBC Driver
			Class.forName("com.mysql.cj.jdbc.Driver");

			// Establish database connection
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/userdatabase", "root", "root");

			// Prepare SQL statement to fetch user details by email
			pstmt = conn.prepareStatement("SELECT userPassword FROM users WHERE userEmail = ?");
			pstmt.setString(1, userEmail); // Set the userEmail in the query

			// Execute query
			rs = pstmt.executeQuery();

			// Check if a result is found
			if (rs.next()) {
				// Get the stored password from the database
				String storedPassword = rs.getString("userPassword");

				// Compare the stored password with the password provided by the user
				if (storedPassword.equals(userPassword)) {
					// Password is correct
					resp.getWriter().println("Login successful!");
				} else {
					// Password is incorrect
					resp.getWriter().println("Incorrect password.");
				}
			} else {
				// No user found with the given email
				resp.getWriter().println("User not found.");
			}

		} catch (ClassNotFoundException | SQLException e) {
			// Handle exceptions (database or JDBC errors)
			e.printStackTrace();
			resp.getWriter().println("An error occurred: " + e.getMessage());
		} finally {
			// Close resources
			try {
				if (rs != null) rs.close();
				if (pstmt != null) pstmt.close();
				if (conn != null) conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		// We should not call super.doGet(), it is not necessary here
	}
}
