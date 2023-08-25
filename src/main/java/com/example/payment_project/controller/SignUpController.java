package com.example.payment_project.controller;
import com.example.payment_project.model.User;
import com.example.payment_project.service.UserService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.UUID;

@WebServlet(name = "signUp", value = "/sign-up")

public class SignUpController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect("signUp.jsp");
    }

    UserService userService = UserService.getInstance();
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        User user = User.builder()
                .username(username)
                .password(password)
                .build();
        PrintWriter writer = resp.getWriter();
        try {
            UUID id  = userService.save(user);
            if(id != null){
                req.setAttribute("userId",id);
                req.getRequestDispatcher("MainMenu.jsp").forward(req,resp);
            }
        }catch (RuntimeException e){
            writer.println("<h1 style=\"color: red\">"+e.getMessage()+"</h1>\n" +
                    "<a href=\"/sign-up\">Qaytadan urinish</a>");
        }

    }
}
