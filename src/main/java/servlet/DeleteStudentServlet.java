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

/**
 * 删除学生信息
 * */
public class DeleteStudentServlet extends HttpServlet {
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
        String id = req.getParameter("studentId");
        String name = req.getParameter("studentName");
        //生日（String转化为Date）
        String birthday = req.getParameter("birthday");
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy年MM月dd日");
        int avgScore = Integer.parseInt(req.getParameter("avgScore"));
        String avg = String.valueOf(avgScore);
        String description = req.getParameter("description");
        try{
            //string类型转date类型
            date = simpleDateFormat.parse(birthday);
        }catch (ParseException e){
            e.printStackTrace();
        }
        StudentBean student = new StudentBean();
        student.setStudentId(id);
        student.setStudentName(name);
        student.setBirthday(date);
        student.setAvgScore(avgScore);
        student.setDescription(description);
        StudentService studentService = new StudentServiceImpl();
        boolean result = studentService.deleteStudent(student);
        if (result){
            out.write("success");
        }else {
            out.write("fail");
        }
        out.flush();
        out.close();


    }
}
