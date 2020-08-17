import bean.StudentBean;
import com.alibaba.fastjson.JSON;
import com.sun.org.apache.xml.internal.resolver.readers.ExtendedXMLCatalogReader;
import dao.StudentDao;
import javafx.application.Application;
import javafx.stage.Stage;
import redis.clients.jedis.Jedis;
import util.JedisUtil;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

public class Test{

    public static void main(String[] args) {

//        jedis.set("s","sssss");
//       Jedis r = JedisUtil.getJedis();
////
////        r.del("s");
//////
//        Date date = new Date();
//        String  s = "2001年5月13日";
//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy年MM月dd日");
//        try{
//            date=simpleDateFormat.parse(s);
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//////
//        StudentBean studentBean = new StudentBean();
//        studentBean.setStudentId("2020007");
//        studentBean.setDescription("贵州");
//        studentBean.setBirthday(date);
//        studentBean.setStudentName("王麻子");
//        studentBean.setAvgScore(99);
//
//       String ss1 = JSON.toJSONString(studentBean);
//       System.out.println("序列化："+ss1);
//
        Jedis jedis = JedisUtil.getJedis();
//        jedis.zadd("student_info",studentBean.getAvgScore(),ss1);
        StudentDao dao = new StudentDao();
////        dao.save(studentBean);
//        StudentBean sb = JSON.parseObject(ss1,StudentBean.class);
//        System.out.println(sb.toString());
//        System.out.println(sb.getBirthday());


////        dao.update(studentBean);
////        dao.delete(studentBean);

//        List<StudentBean> list = new ArrayList<>();
//        Set<String> stringSet = dao.select();
//        for (String s : stringSet) {
//            StudentBean studentBean = JSON.parseObject(s,StudentBean.class);
//            list.add(studentBean);
//            System.out.println(studentBean);
//        }
//        System.out.println(list.toString());

    }


}
