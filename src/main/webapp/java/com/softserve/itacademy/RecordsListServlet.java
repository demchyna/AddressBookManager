package com.softserve.itacademy;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(value = "/records/list")
public class RecordsListServlet extends HttpServlet {

    private AddressBook addressBook;

    @Override
    public void init() throws ServletException {
        addressBook = AddressBook.getInstance();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String sortBy = req.getParameter("sort");
        if (sortBy != null) {
            switch (sortBy) {
                case "asc" :
                    addressBook.sortedBy(SortOrder.ASC);
                    break;
                case "desc" :
                    addressBook.sortedBy(SortOrder.DESC);
                    break;
                default: break;
            }
        }

        List<String[]> records = new ArrayList<>();

        for (Object record : addressBook) {
            String[] recordParts = record.toString().split(", ");
            String firstName = recordParts[0].substring(recordParts[0].indexOf(":") + 2);
            String lastName = recordParts[1].substring(recordParts[1].indexOf(":") + 2);
            String address = recordParts[2].substring(recordParts[2].indexOf(":") + 2);
            records.add(new String[] {firstName, lastName, address});
        }

        req.setAttribute("records", records);
        req.getRequestDispatcher("/WEB-INF/list.jsp").forward(req, resp);
    }
}
