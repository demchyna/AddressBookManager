package com.softserve.itacademy;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/records/create")
public class CreateRecordServlet extends HttpServlet {

    private AddressBook addressBook;

    @Override
    public void init() throws ServletException {
        addressBook = AddressBook.getInstance();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/create.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        boolean status = addressBook.create(
                req.getParameter("first-name"),
                req.getParameter("last-name"),
                req.getParameter("address"));
        if (!status) {
            req.setAttribute("error", "An error occurred! Please try again!");
            req.getRequestDispatcher("/WEB-INF/create.jsp").forward(req, resp);
        } else {
            resp.sendRedirect("/records/list");
        }
    }
}
