package bean;

import com.alibaba.fastjson.JSON;

import java.io.Serializable;
import java.util.Date;

public class StudentBean implements Serializable {
    //学生id
    private String studentId;
    //姓名
    private String studentName;
    //生日
    private Date birthday;
    //备注
    private String description;
    //平均分
    private Integer avgScore;

    //序列化
    public String toJSON(StudentBean studentBean){
        return JSON.toJSONString(studentBean);
    }
    //反序列化

    @Override
    public String toString() {
        return "StudentBean{" +
                "studentId='" + studentId + '\'' +
                ", studentName='" + studentName + '\'' +
                ", birthday=" + birthday +
                ", description='" + description + '\'' +
                ", avgScore=" + avgScore +
                '}';
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getAvgScore() {
        return avgScore;
    }

    public void setAvgScore(Integer avgScore) {
        this.avgScore = avgScore;
    }
}
