import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/url")
public class Url extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        String param = req.getParameter("urln");

        PrintWriter printWriter = resp.getWriter();

        if (param.equals("URL1")) {
            resp.sendRedirect(getServletContext().getInitParameter("URL1"));
        } else if (param.equals("URL2")) {
            resp.sendRedirect(getServletContext().getInitParameter("URL2"));
        } else {
            printWriter.println("parameter URL" + param + " not found");
        }

    }
}
