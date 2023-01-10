<%@page %>
<%@ page import="java.util.Calendar" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.time.LocalDateTime" %>
<%@ page import="java.time.format.DateTimeFormatter" %>
<%@ page import="java.util.logging.Logger" %>
<%!
    String name = "";
%>
<html>
  <head>
    <title>Index</title>
  </head>
  <body>
   <%
    Logger logger = Logger.getLogger("InfoLogging");
    int hours = new Date().getHours();
    if ( hours >= 0 && hours < 6){
      out.println("Good night");
      logger.info("Good night");
      name = "night.jsp";
    }
    else if (hours >= 6 && hours < 12) {
      out.println("Good morning");
      logger.info("Good morning");
      name = "morning.jsp";
    }
    else if (hours >= 12 && hours < 18) {
      out.println("Good afternoon");
      logger.info("Good afternoon");
      name = "afternoon.jsp";
    }
    else if (hours >= 18 && hours < 24) {
      out.println("Good  evening");
      logger.info("Good evening");
      name = "evening.jsp";
    }

    out.println("<br><br>");

    out.println("<table>");
    LocalDateTime localDateTime = LocalDateTime.now();
    for (int i = 0; i < 7; i++){
      LocalDateTime date = localDateTime.plusDays(i);
      out.println("<tr>");
      out.println("<td>"+date.format(DateTimeFormatter.ofPattern("dd.MM.yyyy"))+"</td>");
      out.println("<td>"+date.getDayOfWeek().getValue()+"</td>");
      out.println("</tr>");
    }
    out.println("</table>");
  %>
    <%
        switch(name){
          case "night.jsp":%>
           <%@ include file="night.jsp"%>
           <jsp:forward page="night.jsp" />
          <%break;
          case "morning.jsp":%>
            <%@ include file="morning.jsp"%>
            <jsp:include page="morning.jsp"/>
          <%break;
            case "afternoon.jsp":%>
            <%@ include file="afternoon.jsp"%>
            <jsp:include page="afternoon.jsp"/>
          <%break;
          case "evening.jsp":%>
            <%@ include file="evening.jsp"%>
            <jsp:include page="evening.jsp"/>
          <%break;
      }%>
   <br>
  <a href="Afternoon">Afternoon servlet</a> <br>
  <!-- <a href="Jjj">Jjj servlet</a> -->

  <form action="Jjj" method="get">
    <input type="submit" value="Go Jjj Get"/>
  </form>

  <form action="Jjj" method="post">
    <input type="submit" value="Go Jjj Post"/>
  </form>
   </body>
</html>
