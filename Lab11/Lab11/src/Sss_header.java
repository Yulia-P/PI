package lab11;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Sss_header extends HttpServlet implements Servlet {
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            Integer x = Integer.parseInt(request.getHeader("Value-x"));
            Integer y = Integer.parseInt(request.getHeader("Value-y"));
            Integer z = x + y;

            Thread.sleep(10000);

            response.setHeader("Value-z", z.toString());
        } catch(Exception e) {
            response.getWriter().println(e.getMessage());
        }
    }
}