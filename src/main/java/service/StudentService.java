package service;

import bean.StudentBean;

import java.util.Set;

public interface StudentService {
    /**
     * 新增学生
     * */
    boolean saveStudent(StudentBean studentBean);
    /**
     * 修改学生信息
     * */
    boolean updateStudent(StudentBean studentBean);
    /**
     * 删除学生
     * */
    boolean deleteStudent(StudentBean studentBean);
    /**
     * 查询所有学生
     * */
    Set<String> selectStudent(Long start, Long end);
    /**
     * 获取数据总条数
     * */
    Long count();
}
