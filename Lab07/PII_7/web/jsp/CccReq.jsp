<%@ page import="beans.CBean" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Request</title>
    </head>
    <body>
        <%

            CBean cBean = (CBean) request.getAttribute("atrCBean");
            if(cBean!=null){
                String value1 = cBean.getValue1();
                String value2 = cBean.getValue2();
                String value3 = cBean.getValue3();

                out.write(
                        "<br>Value 1 = " + value1 +
                        "<br>Value 2 = " + value2 +
                        "<br>Value 3 = " + value3
                );
            }
            else {
                out.write("CBean is null");
            }
        %>
    </body>
</html>
