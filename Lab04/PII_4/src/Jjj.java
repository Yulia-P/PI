import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;

// import java.net.http.HttpClient;
// import java.net.http.HttpRequest;
// import java.net.http.HttpResponse;
// import org.apache.commons.httpclient.methods.PostMethod;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Calendar;
import java.time.LocalDateTime;
import java.io.PrintWriter;

// @WebServlet(urlPatterns = "/Jjj")
@WebServlet(value = "/Jjj")

public class Jjj extends HttpServlet
{

    private Calendar calendar = Calendar.getInstance();
    private int hour = calendar.get(Calendar.HOUR_OF_DAY);
    
    private TimeHelper timeHelper = new TimeHelper();
    private String timeName = this.timeHelper.GetTimeName(LocalDateTime.now().getHour());
    
    @Override
    public void init() throws ServletException
    {
        super.init();
        System.out.println("Jjj:init");
    }

    @Override
    public void destroy()
    {
        super.destroy();
        System.out.println("Jjj:destroy");
    }

    private void forwardToJsp(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        req.getRequestDispatcher(timeName + ".jsp").forward(req,resp);
    }

    private void getToJspGet(HttpServletResponse resp) throws IOException{
        HttpClient hc = new HttpClient();
        GetMethod gm = new GetMethod("http://localhost:8080/AS_PYS4/"+timeName+".jsp");
        System.out.println("Jjj:HttpClient");
        hc.executeMethod(gm);
        resp.setContentType("text/html");
        PrintWriter pw = resp.getWriter();
        pw.println(gm.getResponseBodyAsString());
        pw.flush();
    }

    private void getToJspPost(HttpServletResponse resp) throws IOException{
        HttpClient hc = new HttpClient();
        PostMethod gm = new PostMethod("http://localhost:8080/AS_PYS4/"+timeName+".jsp");
        System.out.println("Jjj:HttpClient");
       
        hc.executeMethod(gm);
        resp.setContentType("text/html");
        PrintWriter pw = resp.getWriter();
        pw.println(gm.getResponseBodyAsString());
        pw.flush();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        System.out.println("Jjj:doGet");
        // forwardToJsp(req, resp);
        getToJspGet(resp);

        /* if (hour > 0 && hour <= 5)
        //     req.getRequestDispatcher("night.jsp").forward(req, resp);
        // else if (hour > 5 && hour < 12)
        //     req.getRequestDispatcher("morning.jsp").forward(req, resp);
        // else if (hour >= 12 && hour <= 17)
        //     resp.sendRedirect("afternoon.jsp");
        // else
        //     req.getRequestDispatcher("evening.jsp").forward(req, resp);*/       
    }

   @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        System.out.println("Jjj:doPost");
        // forwardToJsp(req, resp);
        getToJspPost(resp);

        /*if (hour > 0 && hour <= 5)
            req.getRequestDispatcher("night.jsp").forward(req, resp);
        else if (hour > 5 && hour < 12)
            req.getRequestDispatcher("morning.jsp").forward(req, resp);
        else if (hour >= 12 && hour <= 17)
            req.getRequestDispatcher("afternoon.jsp").forward(req, resp);
        else
            req.getRequestDispatcher("evening.jsp").forward(req, resp);*/
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getMethod().equals("POST")) {
            this.doPost(req, resp);
        } else if (req.getMethod().equals("GET")) {
            this.doGet(req, resp);
        }
    }
}
