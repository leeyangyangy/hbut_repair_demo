package com.lyy.manager.framework.jwt;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.ObjectUtil;
import com.lyy.manager.framework.constants.JwtConstant;
import io.jsonwebtoken.CompressionCodecs;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

/**
 * @Package: com.lyy.security.framwork.jwt
 * @Author: LEEYANGYANG
 * @Create: 2022/11/2 19:16
 * @Description:
 */
public class JwtUtils {


    /**
     * 生成jwt
     * 规则 用户id  long =  userId
     */
    public static  String createToken(Long userId){
        return Jwts.builder()
                //主题 用户名
                .setSubject(userId.toString())
                //设置签名加密方式
                .signWith(SignatureAlgorithm.HS256, JwtConstant.TokenSingKey)
                //压缩算法
                .compressWith(CompressionCodecs.GZIP)
                //失效时间
                .setExpiration(DateUtil.nextMonth())
                .compact();
    }



    /**
     * 解密jwt数据  得到 userId
     */
    public static  Long getUserIdFromToken(String token){

        if (ObjectUtil.isEmpty(token)){
            return null;
        }
        try {

            return Long.valueOf(Jwts.parser().setSigningKey(JwtConstant.TokenSingKey)
                    .parseClaimsJws(token).getBody().getSubject());

        }catch (JwtException e){
            return null;
        }
    }
}
