package dao;

import bean.StudentBean;
import com.alibaba.fastjson.JSON;
import redis.clients.jedis.Jedis;
import util.JedisUtil;

import java.util.*;

public class StudentDao {
    /**
     * 新增学生
     * */
    public boolean save(StudentBean studentBean){
        Jedis jedis = JedisUtil.getJedis();
        //序列化
        String student = JSON.toJSONString(studentBean);
        try{
            jedis.zadd("student_info",studentBean.getAvgScore(),student);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }
    /**
     * 修改学生信息
     * */
    public boolean update(StudentBean studentBean){
        Jedis jedis = JedisUtil.getJedis();
        //序列化
        String student = JSON.toJSONString(studentBean);
        try{
            jedis.zadd("student_info",studentBean.getAvgScore(),student);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }
    /**
     * 删除学生
     * */
    public boolean delete(StudentBean studentBean){
        Jedis jedis = JedisUtil.getJedis();
        //序列化
        String student = JSON.toJSONString(studentBean);
        try{
            jedis.zrem("student_info",student);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }
    /**
     * 查询所有学生
     * */
    public Set<String> select(Long start, Long end){
        Jedis jedis = JedisUtil.getJedis();
        try{
            Set<String> studentSet = jedis.zrange("student_info",start,end);
            return studentSet;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
    /**
     * 获取数据总条数
     * */
    public Long countStudent(){
        Jedis jedis = JedisUtil.getJedis();
        return jedis.zcard("student_info");
    }
}
