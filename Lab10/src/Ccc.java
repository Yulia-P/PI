package servlets;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.Calendar;
import java.util.Enumeration;

public class Ccc extends HttpServlet implements Servlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String param1 = req.getParameter("param1");
        String Url = "jdbc:sqlserver://DESKTOP-P6IEL6K:1433;databaseName=PI10;Trusted_Connection=No;user=jjulliaaa;password=zalesse2015";
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            System.out.println("Trying to connect");
            Connection connection = DriverManager.getConnection(Url);
            System.out.println("Connection Established Successfull");


            CallableStatement cstmt = connection.prepareCall("{call CountStudentsByPartName(?,?)}");
            cstmt.setString(1, param1);
            cstmt.registerOutParameter(2, Types.INTEGER);
            PrintWriter out = resp.getWriter();
            cstmt.execute();
            out.println("Count of searched students: " + cstmt.getInt(2));

        } catch (Exception e) {
            System.out.println("Unable to make connection with DB");
            e.printStackTrace();
        }
    }
}