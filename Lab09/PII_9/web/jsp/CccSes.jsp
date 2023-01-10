<%@ page import="beans.CBean" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Session</title>
    </head>
    <body>
        <%
            out.write("session id = " + session.getId() + "<br/>");
            System.out.println("in view: " + request.getSession().getId());
            CBean cBean = (CBean) session.getAttribute(request.getSession().getId());
            if(cBean!=null){
                String value1 = cBean.getValue1();
                String value2 = cBean.getValue2();
                String value3 = cBean.getValue3();

                out.write(
                        "<br>Value1: " + value1 +
                                "<br>Value2: " + value2 +
                                "<br>Value3: " + value3
                );
            }
            else {
                out.write("CBean is null");
            }
        %>
    </body>
</html>