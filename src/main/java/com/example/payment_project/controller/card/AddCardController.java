package com.example.payment_project.controller.card;

import com.example.payment_project.model.Card;
import com.example.payment_project.service.CardServise;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.UUID;

@WebServlet(name = "addCard", urlPatterns = "/add-card")
public class AddCardController extends HttpServlet {

    CardServise cardServise = CardServise.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("userId", req.getParameter("userId"));
        req.getRequestDispatcher("AddCard.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String password = req.getParameter("password");
        String card_number = req.getParameter("card-Number");
        UUID userId = UUID.fromString(req.getParameter("userId"));

        Card card = new Card(password, card_number, userId);

        PrintWriter printWriter = resp.getWriter();
        try {
            UUID id = cardServise.saveCard(card);
            if (id != null) {
                req.setAttribute("userId", userId);
                req.getRequestDispatcher("Sucsesfuly.jsp").forward(req, resp);

            }
        } catch (RuntimeException e) {
            printWriter.println("<h1 style=\"color: red\">" + e.getMessage() + "</h1>\n" +
                    "<a href=\"/add-card\">Qaytadan urinish</a>");
        }

    }
}













