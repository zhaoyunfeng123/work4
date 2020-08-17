package servlet;

import bean.StudentBean;
import service.Impl.StudentServiceImpl;
import service.StudentService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class UpdateStudentServlet extends HttpServlet {

    private static final long serialVersionUID = 32127461561L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        PrintWriter out = resp.getWriter();
        Date oldDate = new Date();
        Date newDate = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy年MM月dd日");

        String id = req.getParameter("studentId");
        //旧数据
        String oldName = req.getParameter("oldName");
        String oldBirthday = req.getParameter("oldBirthday");
        int oldAvgScore = Integer.parseInt(req.getParameter("oldAvgScore"));
        String oldDescription = req.getParameter("oldDescription");
        //新数据
        String newStudentName = req.getParameter("newStudentName");
        String newBirthday = req.getParameter("newBirthday");
        int newAvgScore = Integer.parseInt(req.getParameter("newAvgScore"));
        String newDescription = req.getParameter("newDescription");
        try {
            //string类型转date类型
            oldDate = simpleDateFormat.parse(oldBirthday);
            newDate = simpleDateFormat.parse(newBirthday);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        StudentBean oldInfo = new StudentBean();
        StudentBean newInfo = new StudentBean();

        oldInfo.setStudentId(id);
        oldInfo.setStudentName(oldName);
        oldInfo.setBirthday(oldDate);
        oldInfo.setAvgScore(oldAvgScore);
        oldInfo.setDescription(oldDescription);

        newInfo.setStudentId(id);
        newInfo.setStudentName(newStudentName);
        newInfo.setBirthday(newDate);
        newInfo.setAvgScore(newAvgScore);
        newInfo.setDescription(newDescription);

        StudentService studentService = new StudentServiceImpl();
        boolean resultDelte = studentService.deleteStudent(oldInfo);
        boolean resultUpdate = studentService.updateStudent(newInfo);
        if (resultDelte) {
            if (resultUpdate) {
                out.write("success");
            } else {
                out.write("fail");
            }
        }else {
            out.write("fail");
        }
        out.flush();
        out.close();
    }
}
