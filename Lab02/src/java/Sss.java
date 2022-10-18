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
    System.out.println("constructor");
  }

  @Override
  public void init() {
    System.out.println("init");
  }

  @Override
  protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      super.service(req, resp);
      System.out.println("service");
      resp.getWriter().write(
                    "\n" + this.getClass().getName() + ":service" +
                    "\nmethod:" + req.getMethod() +  
                    "\nserver-name:" + req.getServerName() +
                    "\nIP:" + req.getLocalAddr() +
                    "\nURL:" + req.getRequestURL() + "?" + req.getQueryString());
  }

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    System.out.println("doGet");
    String firstName=req.getParameter("firstName");
    String lastName=req.getParameter("lastName");
    resp.getWriter().write(
                    "\nfirst name:" + firstName +
                    "\nlast name:" + lastName );
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    System.out.println("doPost");
    String firstName = req.getParameter("firstName");
    String lastName = req.getParameter("lastName");
    resp.getWriter().write(
                    "\nfirst name:" + firstName +
                    "\nlast name:" + lastName );
  }

  @Override
  public void destroy() {
    System.out.println("destroy");
  }  
}