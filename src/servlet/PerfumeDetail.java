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

@WebServlet(value = "/detail")

public class PerfumeDetail extends HttpServlet {

        @Override
        protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            int id = Integer.parseInt(req.getParameter("id"));
            PerfumeDao perfumeDao = new PerfumeInMemoryDao();

            req.getSession().setAttribute("aaa", "222");

            req.getSession().getAttribute("aaa");

            Perfume perfume = perfumeDao.getPerfumeById(id);
            req.setAttribute("perfume", perfume);
            req.getRequestDispatcher("jsp/perfume_detail.jsp").forward(req, resp);
        }
}