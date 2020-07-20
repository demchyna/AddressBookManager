package com.softserve.itacademy;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/records/update")
public class UpdateRecordServlet extends HttpServlet {

    private AddressBook addressBook;
    private String firstName;
    private String lastName;

    @Override
    public void init() throws ServletException {
        addressBook = AddressBook.getInstance();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        firstName = req.getParameter("first-name");
        lastName = req.getParameter("last-name");
        String address = addressBook.read(firstName, lastName);
        if (address == null) {
            throw new RuntimeException("Person with name '" + req.getParameter("first-name") + " " + req.getParameter("last-name") + "' not found in Address Book!");
        } else {
            req.setAttribute("address", address);
            req.getRequestDispatcher("/WEB-INF/update.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        boolean status = addressBook.update(firstName, lastName, req.getParameter("address"));
        if (!status) {
            req.setAttribute("error", "An error occurred! Please try again!");
            req.getRequestDispatcher("/WEB-INF/update.jsp").forward(req, resp);
        } else {
            resp.sendRedirect("/records/list");
        }
    }
}
