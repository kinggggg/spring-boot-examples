package com.neo.config;

import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheException;
import org.apache.shiro.cache.CacheManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @ClassName RedisCacheManager
 * @Description
 * @Author liweibo
 * @Date 2018/12/17 下午3:44
 * @Version v1.0
 **/
@Component
public class RedisCacheManager implements CacheManager {

//    @Autowired
//    private RedisTemplate redisTemplate; // RedisTemplate，如果不明白怎么使用的，请参考http://blog.csdn.net/liuchuanhong1/article/details/54601037

    @Resource
    private RedisTemplate<Object, Object> redisTemplate;

    public RedisTemplate<Object, Object> getRedisTemplate() {
        return redisTemplate;
    }

    public void setRedisTemplate(RedisTemplate<Object, Object> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }


    public <K, V> Cache<K, V> getCache(String name) throws CacheException {
        return new RedisCache<K, V>(name, redisTemplate);
    }

}
