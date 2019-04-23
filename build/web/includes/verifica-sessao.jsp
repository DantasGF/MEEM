<%
    if(request.getSession().getAttribute("logado") == null 
            || !request.getSession().getAttribute("logado").equals("ok")){
        response.sendRedirect("http://localhost:8080/index.jsp");
    }
%>