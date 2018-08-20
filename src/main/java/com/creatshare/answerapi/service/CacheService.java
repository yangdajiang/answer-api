package com.creatshare.answerapi.service;

import com.alibaba.fastjson.JSONObject;
import com.creatshare.answerapi.service.impt.CacheServiceImpt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.concurrent.TimeUnit;

@Service
public class CacheService implements CacheServiceImpt {

    @Autowired
    RedisTemplate redisTemplate;

    @Override
    public void subCache(String userNum, String subNum, String subContent) {
        if (!redisTemplate.hasKey(userNum)) {
            redisTemplate.opsForHash().put(userNum, subNum, subContent);
            redisTemplate.expire(userNum, 120 * 60, TimeUnit.SECONDS);
            return;
        }

        redisTemplate.opsForHash().put(userNum, subNum, subContent);
        return;

    }

    @Override
    public String returnCache(String userNum) {
        if (!redisTemplate.hasKey(userNum)) return null;

        Map map = redisTemplate.opsForHash().entries(userNum);
        JSONObject jsonObject = new JSONObject();
        map.forEach((key, value) -> {
            jsonObject.put(String.valueOf(key), value);
        });
        return jsonObject.toJSONString();
    }
}