<%
    if(session.getAttribute("logado") == null){
        session.invalidate();
        response.sendRedirect("./index.jsp");
    }
%>