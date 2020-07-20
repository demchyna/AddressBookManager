package com.softserve.itacademy;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/records/read")
public class ReadRecordServlet extends HttpServlet {

    private AddressBook addressBook;

    @Override
    public void init() throws ServletException {
        addressBook = AddressBook.getInstance();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String address = addressBook.read(
                req.getParameter("first-name"),
                req.getParameter("last-name"));
        if (address == null) {
            throw new RuntimeException("Person with name '" + req.getParameter("first-name") + " " + req.getParameter("last-name") + "' not found in Address Book!");
        } else {
            req.setAttribute("address", address);
            req.getRequestDispatcher("/WEB-INF/read.jsp").forward(req, resp);
        }
    }
}
