import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

public class Bbb extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.addHeader ("x-b-first-header", "b first value");
        response.addHeader ("x-b-second-header", "b second value");

        PrintWriter pw = response.getWriter();
        String name;
        response.setContentType("text/html");
        pw.println("Query parameters:");
        Enumeration params = request.getParameterNames();
        while (params.hasMoreElements()) {
            name = (String)params.nextElement();
            pw.println(name + " = " + request.getParameter(name));
        }
        pw.print("Headers:");
        Enumeration headers = request.getHeaderNames();
        while (headers.hasMoreElements()) {
            name = (String) headers.nextElement();
            pw.println(name + " = " + request.getHeader(name));
        }
        pw.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
