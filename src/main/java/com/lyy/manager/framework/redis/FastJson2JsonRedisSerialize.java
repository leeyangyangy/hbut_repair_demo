package com.lyy.manager.framework.redis;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.parser.ParserConfig;
import com.alibaba.fastjson.serializer.SerializerFeature;
import org.springframework.data.redis.serializer.RedisSerializer;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

/**
 * @Package: com.lyy.security.framwork.redis
 * @Author: LEEYANGYANG
 * @Create: 2022/11/2 20:14
 * @Description:
 */
@SuppressWarnings(value = {"unchecked", "rawtypes"})
public class FastJson2JsonRedisSerialize
        <T> implements RedisSerializer<T> {

    public static final Charset DEFAULT_CHARSET = StandardCharsets.UTF_8;

    private final Class<T> clazz;

    static {
        ParserConfig.getGlobalInstance().setAutoTypeSupport(true);
    }

    public FastJson2JsonRedisSerialize(Class clazz) {
        super();
        this.clazz = clazz;
    }


    /**
     * 序列化
     */
    @Override
    public byte[] serialize(T t) {
        if (null == t) {
            return new byte[0];
        }
        return JSON.toJSONString(t, SerializerFeature.WriteClassName).getBytes(DEFAULT_CHARSET);
    }

    /**
     * 反序列化
     */
    @Override
    public T deserialize(byte[] bytes) {
        if (null == bytes || bytes.length <= 0) {
            return null;
        }
        String str = new String(bytes, DEFAULT_CHARSET);
        return JSON.parseObject(str, clazz);
    }

}

