package util;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 JedisUtil工具类
 加载配置文件，配置连接池的参数
 提供获取连接的方法
 */
public class JedisUtil {

    private static JedisPool jedisPool;

    //初始化连接池
    static {
        //读取文件配置
        InputStream in = JedisUtil.class.getClassLoader().getResourceAsStream("jedis.properties");
        //创建properties对象
        Properties properties = new Properties();
        //关联文件
        try{
            properties.load(in);
        }catch (IOException e){
            e.printStackTrace();
        }
        //设置连接池参数，配置到JedisPoolConfig中
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        jedisPoolConfig.setMaxTotal(Integer.parseInt(properties.getProperty("maxTotal")));
        jedisPoolConfig.setMaxIdle(Integer.parseInt(properties.getProperty("maxIdle")));
        //初始化JedisPool
        jedisPool = new JedisPool(jedisPoolConfig,properties.getProperty("host"),Integer.parseInt(properties.getProperty("port")));
    }
    /**
     * 获取连接方法
     * */
    public static Jedis getJedis(){
        System.out.println("连接成功");
        return jedisPool.getResource();
    }
    /**
     * 归还连接，释放资源
     * */
    public void close(Jedis obj){
        obj.close();
    }

}
