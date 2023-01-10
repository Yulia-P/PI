<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>PII_7</title>
  </head>
  <body>
    <h4>Request attribute</h4>
    <a href="CccReq.jsp">Ccc request jsp</a>
    <form action="/AS_PYS7/CccReq" method="GET">
      <input type="text" name="value1" placeholder="Value1"/><br/>
      <input type="text" name="value2" placeholder="Value2"/><br/>
      <input type="text" name="value3" placeholder="Value3"/><br/>
      New <input type="radio" name="CBean" value="new" label="New" title="" checked/><br/>
      Old <input type="radio" name="CBean" value="old" label="Old" title=""/><br/>
      <button type="submit">Click</button>
    </form>
    <hr/>
    <h4>Session attribute</h4>
    <a href="CccSes.jsp">Ccc session jsp</a>
    <form action="/AS_PYS7/CccSes" method="Get">
      <input type="text" name="value1" placeholder="Value1"/><br/>
      <input type="text" name="value2" placeholder="Value2"/><br/>
      <input type="text" name="value3" placeholder="Value3"/><br/>
      New <input type="radio" name="CBean" value="new" label="New" title="" checked/><br/>
      Old <input type="radio" name="CBean" value="old" label="Old" title=""/><br/>
      <button type="submit">Click</button>
    </form>
  </body>
</html>
