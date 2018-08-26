package servlet;

import Dao.PerfumeDao;
import Dao.PerfumeInMemoryDao;
import entity.Perfume;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/add")

public class PerfumeAdd extends HttpServlet{

        @Override
        protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            req.getRequestDispatcher("jsp/perfume_add_form.jsp").forward(req, resp);
        }

        @Override
        protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            req.setCharacterEncoding("utf-8");

            int id = Integer.parseInt(req.getParameter("id"));
            String name = req.getParameter("name");
            float price = Float.parseFloat(req.getParameter("price"));
            String capacity = req.getParameter("capacity");
            String other = req.getParameter("other");

            Perfume perfume = new Perfume(id, name, price, capacity, other);

            PerfumeDao perfumeDao = new PerfumeInMemoryDao();
            perfumeDao.add(perfume);

            resp.sendRedirect("/index");
        }

    }
