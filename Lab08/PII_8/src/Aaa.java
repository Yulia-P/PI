import org.apache.commons.httpclient.Header;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.PostMethod;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class Aaa extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpClient hc = new HttpClient();
        PostMethod req = new PostMethod("http://localhost:8080/AS_PYS8/Bbb");
        NameValuePair[] parms = {
                new NameValuePair("firstName", "Yulia"),
                new NameValuePair("middleName", "Sergeevna"),
                new NameValuePair("lastName", "Pochikovskaya")
        };
        req.addParameters(parms);
        req.addRequestHeader ("x-a-first-header", "a first value");
        req.addRequestHeader ("x-a-second-header", "a second value");
        req.addRequestHeader ("x-a-third-header", "a third value");
        hc.executeMethod(req);

        PrintWriter pw = response.getWriter();
        pw.println("Response body:");
        pw.println(req.getResponseBodyAsString());
        pw.println("Headers:");
        for (Header responseHeader : req.getResponseHeaders()) {
            pw.println(responseHeader.getName() + " = " + responseHeader.getValue());
        }
        pw.flush();
    }
}
