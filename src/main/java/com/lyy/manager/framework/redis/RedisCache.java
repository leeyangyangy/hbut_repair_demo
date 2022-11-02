package com.lyy.manager.framework.redis;


import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Collection;
import java.util.concurrent.TimeUnit;

/**
 * redis缓存 工具类
 **/
@Component
@SuppressWarnings(value = {"unchecked", "rawtypes"})
public class RedisCache {

    @Resource
    private RedisTemplate redisTemplate;


    /**
     * 缓存对象
     *
     * @param key   缓存的键值
     * @param value 缓存的值
     */
    public <T> void setCache(String key, T value,long timeout, TimeUnit unit) {
        redisTemplate.opsForValue().set(key, value,timeout,unit);
    }

    /**
     * 缓存对象
     *
     * @param key   缓存的键值
     * @param value 缓存的值
     */
    public <T> void setCache(String key, T value) {
        redisTemplate.opsForValue().set(key, value);
    }

    /**
     * 缓存对象，指定过期时间
     *
     * @param key      缓存的键值
     * @param value    缓存的值
     * @param timeout  时间
     * @param timeUnit 时间颗粒度
     */
    public <T> void setCache(String key, T value, Integer timeout, TimeUnit timeUnit) {
        redisTemplate.opsForValue().set(key, value, timeout, timeUnit);
    }

    /**
     * 获取缓存的对象
     *
     * @param key 缓存键值
     * @param <T> 放回对象类型
     * @return 缓存键值对应的数据
     */
    public <T> T getCache(String key) {
        ValueOperations<String, T> operation = redisTemplate.opsForValue();
        return operation.get(key);
    }

    /**
     * 设置有效时间
     *
     * @param key     Redis键
     * @param timeout 超时时间
     * @param unit    时间单位
     */
    public void expire(String key, long timeout, TimeUnit unit) {
        redisTemplate.expire(key, timeout, unit);
    }

    /**
     * 删除单个对象
     *
     * @param key 缓存key
     */
    public void delete(String key) {
        redisTemplate.delete(key);
    }

    /**
     * 判断缓存是否存在
     *
     * @param key 缓存key
     * @return true：存在； false：不存在
     */
    public Boolean exists(String key) {
        return redisTemplate.hasKey(key);
    }

    /**
     * 获得缓存的基本对象列表
     *
     * @param pattern 字符串前缀
     * @return 对象列表
     */
    public Collection<String> keys(final String pattern) {
        return redisTemplate.keys(pattern);
    }

    /**
     * 获得缓存的基本对象。
     *
     * @param key 缓存键值
     * @return 缓存键值对应的数据
     */
    public <T> T getCacheObject(final String key) {
        ValueOperations<String, T> operation = redisTemplate.opsForValue();
        return operation.get(key);
    }

}
