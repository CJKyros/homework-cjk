package servlet;

import Dao.PerfumeDao;
import Dao.PerfumeInMemoryDao;
import entity.Perfume;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/update")

public class PerfumeUpdate extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        PerfumeDao perfumeDao = new PerfumeInMemoryDao();
        Perfume perfume = perfumeDao.getPerfumeById(id);
        req.setAttribute("perfume", perfume);
        req.getRequestDispatcher("jsp/perfume_update.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");

        int id = Integer.parseInt(req.getParameter("id"));
        String name = req.getParameter("name");
        float price = Float.parseFloat(req.getParameter("price"));
        String capacity = req.getParameter("capaci");
        String other = req.getParameter("other");

        Perfume perfume = new Perfume(id, name, price, capacity, other);

        PerfumeDao perfumeDao = new PerfumeInMemoryDao();
        perfumeDao.update(perfume);

        HttpSession session = req.getSession();
        session.setAttribute("msg", "更新成功！");

        resp.sendRedirect("/detail?id=" + id);
    }
}
