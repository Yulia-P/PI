import javax.servlet.RequestDispatcher;
import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class Ggg extends HttpServlet {
    public Ggg() {
        super();
        System.out.println("Ggg:constructor");
    }
    protected void service(HttpServletRequest rq, HttpServletResponse rs) throws ServletException, IOException {
        System.out.println("Ggg:service");
        String type = rq.getParameter("type");
        PrintWriter pw = rs.getWriter();
        if(type!=null && type.equals("forwardX2")) {
            RequestDispatcher rd = null;
            System.out.println("Ggg:forwardX2");
            rd = rq.getRequestDispatcher("hello.html");
            // объекты запроса и ответа остаются теми же
            rd.forward(rq, rs);
        } else if(type!=null && type.equals("redirectX2")) {
            System.out.println("Ggg:redirectX2");
            rs.sendRedirect("/Lab3/hello.html");
        } else {
            pw.println("<html><body>"
                    + "<h3>Ggg servlet</h3>"
                    + "<h3>"+rq.getMethod()+"</h3>"
                    + "<br>type = " + type
                    + "<br>action = " + rq.getParameter("action")
                    + "<br>firstname = " + rq.getParameter("firstname")
                    + "<br>lastname = " + rq.getParameter("lastname")
                    + "</body></html>");
            pw.close();
        }

    }
}