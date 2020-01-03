package edu.dlnu.oa.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.util.HashMap;
import java.util.Map;

/**
 * @author wuhan
 * @date 2020/1/3 10:54
 */
@Component
public class RedisUtils {
    @Autowired
    private JedisPool redisPoolFactory;

    private final int EXPIRE = 60*60*24*30;

    public void clearLeaveApplyCount(String empId){
        try (Jedis jedis = redisPoolFactory.getResource()) {
            jedis.hset(String.valueOf(empId), "count", "0");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public int getLeaveApplyCount(int empId){
        Jedis jedis = null;
        int LeaveApplyCount  = 0;
        try{
            jedis = redisPoolFactory.getResource();
            String count = jedis.hget(String.valueOf(empId), "count");
            if (count!=null){
                LeaveApplyCount = Integer.parseInt(count);
            }


        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if (jedis!=null){
                jedis.close();
            }
        }
        return LeaveApplyCount;
    }


    public void add(int deptManagerID){
        Jedis jedis = null;
        try {
            jedis = redisPoolFactory.getResource();
            Map<String,String> map = new HashMap<>();
            String count = jedis.hget(String.valueOf(deptManagerID), "count");
            if (count==null || count.equals("")){
                map.put("count","1");
            }else {
                int i = Integer.parseInt(count);
                i++;
                map.put("count", String.valueOf(i));

            }
            jedis.hmset(String.valueOf(deptManagerID),map);


        }finally {
            if (jedis!=null){
                jedis.close();
            }
        }
    }

}
