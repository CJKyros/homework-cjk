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
import java.util.List;

@WebServlet("/q")

public class PerfumeSearch extends HttpServlet {

        @Override
        protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            resp.setCharacterEncoding("utf-8");
            resp.setContentType("text/html;charset=utf-8");

            String condition = req.getParameter("condition");

            PerfumeDao perfumeDao = new PerfumeInMemoryDao();
            List<Perfume> perfumes = perfumeDao.getPerfumesByName(condition);

            req.setAttribute("perfumes", perfumes);

            req.getSession().setAttribute("msg", "当前查询条件为:[" + condition + "]");

            req.getRequestDispatcher("jsp/perfume_list.jsp").include(req, resp);
        }
}
