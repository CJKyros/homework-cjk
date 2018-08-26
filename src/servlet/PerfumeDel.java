package servlet;

import Dao.PerfumeDao;
import Dao.PerfumeInMemoryDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/del")

public class PerfumeDel extends HttpServlet {

        @Override
        protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            int id = Integer.parseInt(req.getParameter("id"));
            PerfumeDao dao = new PerfumeInMemoryDao();
            String msg = null;

            if(dao.delete(id)) {
                msg = "delete success.";
            } else {
                msg = "delete failure.";
            }
            //req.getRequestDispatcher("/index").forward(req, resp);
            req.getSession().setAttribute("msg", msg);

            resp.sendRedirect("/index");
        }

        @Override
        protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            String[] ids = req.getParameterValues("id");
            PerfumeInMemoryDao dao = new PerfumeInMemoryDao();
            // 组织成一次数据库操作，一切为了效率
            for (String id : ids) {
                dao.delete(Integer.parseInt(id));
            }

            req.getSession().setAttribute("msg", "删除成功。");

            // req.getRequestDispatcher("/index").forward(req,resp);
            resp.sendRedirect("/index");
        }

}
