package servlet;

import Dao.PerfumeDao;
import Dao.PerfumeInMemoryDao;
import entity.Perfume;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class PerfumeList extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PerfumeDao perfumeDao = new PerfumeInMemoryDao();
        List<Perfume> perfumes = perfumeDao.listAll();
        req.setAttribute("perfumes", perfumes);
        req.getRequestDispatcher("jsp/perfume_list.jsp").forward(req, resp);
    }
}
