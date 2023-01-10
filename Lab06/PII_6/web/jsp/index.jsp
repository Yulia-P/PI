<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>PII_6</title>
  </head>
  <body>
  <%
    out.println("Parameter URL1 = " + application.getInitParameter("URL1"));
    out.println("<br/>");
    out.println("Parameter URL2 = " + application.getInitParameter("URL2"));
  %>
    <h4>Get Urln</h4>
    <form action="/AS_PYS6/url" method="GET">
      <input type="text" name="urln" placeholder="URLn">
      <button type="submit">click</button>
    </form>
    <hr/>
    <h4>Set CBean</h4>
    <form action="/AS_PYS6/Ccc" method="get">
      <input type="text" name="value1" placeholder="Value1"/><br/>
      <input type="text" name="value2" placeholder="Value2"/><br/>
      <input type="text" name="value3" placeholder="Value3"/><br/>
      New <input type="radio" name="CBean" value="new" label="New" title=""/><br/>
      Old <input type="radio" name="CBean" value="old" label="Old" title="" checked/><br/>
      <button type="submit">Click</button>
    </form>
    <a href="Ccc.jsp">Ccc jsp</a>
  </body>
</html>
