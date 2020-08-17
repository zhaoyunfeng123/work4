package servlet;

import bean.StudentBean;
import com.alibaba.fastjson.JSON;
import service.Impl.StudentServiceImpl;
import service.StudentService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class PageSelectStudentServlet extends HttpServlet {
    private static final long serialVersionUID = 21273461561L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");

        Long page = Long.parseLong(req.getParameter("page"));
        System.out.println("page----------------"+page);

        List<StudentBean> list = new ArrayList<>();
        StudentService studentService = new StudentServiceImpl();
        Long start = page * 3 - 1;
        Long end = page * 3 - 1 + 3;
        Set<String> stringSet = studentService.selectStudent(start, end);
        for (String s : stringSet) {
            StudentBean studentBean = JSON.parseObject(s, StudentBean.class);
            list.add(studentBean);
        }
        //返回页数的取值设置
        Long number = studentService.count();
        Long count;
        if (number < 3){
            count = 1L;
        }
        if (number >= 3 && number % 2 ==0){
            count = number / 3;
        }else {
            count = number / 3 + 1;
        }
        System.out.println("pageSelect:"+list.toString());
        HttpSession session = req.getSession();
        session.setAttribute("studentList",list);

        session.setAttribute("currentPage",1);
        session.setAttribute("countStudent",count);

        resp.sendRedirect("index.jsp");

    }
}
