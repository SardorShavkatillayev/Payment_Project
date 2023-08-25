package com.example.payment_project.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.UUID;

@WebServlet(name = "Menu",urlPatterns = "/MainMenu")
public class MainMainController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UUID userId = UUID.fromString(req.getParameter("userId"));
        req.setAttribute("userId",userId);
        req.getRequestDispatcher("MainMenu.jsp").forward(req,resp);
    }
}
