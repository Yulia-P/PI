import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;
import javax.servlet.RequestDispatcher;
import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class Sss extends HttpServlet {
    public Sss() {
        super();
        System.out.println("Sss:constructor");
    }
    protected void service(HttpServletRequest rq, HttpServletResponse rs) throws ServletException, IOException {
        System.out.println("Sss:service");
        String type = rq.getParameter("type");
        String action = rq.getParameter("action");
        HttpClient hc = new HttpClient();
        System.out.println("type = "+type);
        System.out.println("action = "+action);

        if(rq.getMethod().equals("GET")) {
            if(type.equals("forward") || type.equals("forwardX2")) {
                PrintWriter pw = rs.getWriter();
                System.out.println("Sss:forward");
                RequestDispatcher rd = null;
                rs.getWriter().write("output Task5 from Sss");
                rd = rq.getRequestDispatcher("/Ggg");
                //5
              
                //5
                rd.forward(rq, rs);
            } else if(type.equals("redirect")) {
                System.out.println("Sss:redirect");
                rs.sendRedirect("/Lab3/Ggg");
            } else if(type.equals("redirectX2")) {
                System.out.println("Sss:redirectX2");
                rs.sendRedirect("/Lab3/Ggg?type=redirectX2");
            }
            else if(type.equals("request")) {
                GetMethod gm = new GetMethod("http://localhost:8081/Lab3/Ggg?type=request&firstname=get&lastname=request");
                hc.executeMethod(gm);
                rs.setContentType("text/html");
                PrintWriter pw = rs.getWriter();
                pw.println(gm.getResponseBodyAsString());
                pw.flush();
            }
        } else if(rq.getMethod().equals("POST")) {
            if(action.equals("forward")) {
                System.out.println("Sss:forward");
                RequestDispatcher rd = null;
                rd = rq.getRequestDispatcher("/Ggg");

                rd.forward(rq, rs);
            } else if(action.equals("redirect")) {
                System.out.println("Sss:redirect");
                rs.sendRedirect("/Lab3/Ggg");

            } else if(action.equals("request")) {
                PostMethod gm = new PostMethod("http://localhost:8081/Lab3/Ggg");
                gm.addParameter("action",action);
                gm.addParameter("firstname","post");
                gm.addParameter("lastname","request");
                hc.executeMethod(gm);
                rs.setContentType("text/html");
                PrintWriter pw = rs.getWriter();
                pw.println(gm.getResponseBodyAsString());
                pw.flush();
            }
        }
    }
}