package com.servlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;

@WebServlet(name = "CalcServlet", value = "/CS")
public class CalcServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int num1 = 0;
        int num2 = 0;
        String name = "";

        request.setCharacterEncoding("utf-8");
        num1 = Integer.parseInt(request.getParameter("num1"));
        num2 = Integer.parseInt(request.getParameter("num2"));
        name = request.getParameter("userName");

        int result = num1 + num2;
        request.setAttribute("result", result);
        request.setAttribute("userName", name);

        //1. Dispatcher 방식
//        RequestDispatcher re = request.getRequestDispatcher("/basic/result_dispatcher.jsp");
//        re.forward(request, response);

        //2. Redirect 방식
        String encodeName = URLEncoder.encode(name, "UTF-8");
        response.sendRedirect("/restfulTest_war_exploded/basic/result_redirect.jsp?result=" + result + "&userName=" + encodeName);
    }
}
