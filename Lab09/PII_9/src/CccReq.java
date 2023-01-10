import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import beans.*;

@WebServlet(urlPatterns = "/CccReq")
public class CccReq extends HttpServlet {
    public CBean cBean;

    @Override
    public void init() throws ServletException {
        cBean = new CBean();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("goGet");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("doPost");
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String param1 = req.getParameter("value1");
        String param2 = req.getParameter("value2");
        String param3 = req.getParameter("value3");

        if (req.getParameter("CBean").equals("new")) {

            req.setAttribute("atrCBean", cBean);

            if (param1 != null && param2 != null && param3 != null) {
                cBean.setValue1(param1);
                cBean.setValue2(param2);
                cBean.setValue3(param3);

                req.getRequestDispatcher("/CccReq.jsp").forward(req, resp);
            }
        } else if (req.getParameter("CBean").equals("old")) {

            cBean = (CBean)req.getAttribute("atrCBean");

            if(cBean != null){
                if (param1 != null && param2 != null && param3 != null) {
                    cBean.setValue1(param1);
                    cBean.setValue2(param2);
                    cBean.setValue3(param3);
                }
            }
            req.getRequestDispatcher("/CccReq.jsp").forward(req, resp);
        }
    }

    @Override
    public void destroy() {
        super.destroy();
    }
}
