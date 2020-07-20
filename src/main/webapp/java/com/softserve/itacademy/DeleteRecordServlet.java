package com.softserve.itacademy;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/records/delete")
public class DeleteRecordServlet extends HttpServlet {
    private AddressBook addressBook;

    @Override
    public void init() throws ServletException {
        addressBook = AddressBook.getInstance();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        boolean status = addressBook.delete(
                req.getParameter("first-name"),
                req.getParameter("last-name"));
        if (!status) {
            throw new RuntimeException("Person with name '" + req.getParameter("first-name") + " " + req.getParameter("last-name") + "' not found in Address Book!");
        } else {
            resp.sendRedirect("/records/list");
        }
    }
}
