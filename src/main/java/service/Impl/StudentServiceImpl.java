package service.Impl;

import bean.StudentBean;
import dao.StudentDao;
import service.StudentService;

import java.util.Set;

public class StudentServiceImpl implements StudentService {
    /**
     * 新增学生
     * */
    @Override
    public boolean saveStudent(StudentBean studentBean) {
        StudentDao studentDao = new StudentDao();
        return studentDao.save(studentBean);
    }
    /**
     * 修改学生信息
     * */
    @Override
    public boolean updateStudent(StudentBean studentBean) {
        StudentDao studentDao = new StudentDao();
        return studentDao.update(studentBean);
    }
    /**
     * 删除学生
     * */
    @Override
    public boolean deleteStudent(StudentBean studentBean) {
        StudentDao studentDao = new StudentDao();
        return studentDao.delete(studentBean);
    }
    /**
     * 查询所有学生
     * */
    @Override
    public Set<String> selectStudent(Long start, Long end) {
        StudentDao studentDao = new StudentDao();
        return studentDao.select(start, end);
    }
    /**
     * 获取数据总条数
     * */
    @Override
    public Long count() {
        StudentDao studentDao = new StudentDao();
        return studentDao.countStudent();
    }
}
