package com.lyt.manager.framework.respone;

import cn.hutool.core.util.CharsetUtil;
import cn.hutool.http.ContentType;
import com.alibaba.fastjson.JSON;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Package: com.lyy.security.framwork.respone
 * @Author: LEEYANGYANG
 * @Create: 2022/11/2 20:26
 * @Description:
 */
public class ResponseUtils {
    /**
     * 响应异常，直接向前端写response，用于异常处理器捕获不到时手动抛出
     *
     * @author xuyuxiang
     * @date 2020/3/20 11:18
     */
    public static void responseExceptionError(HttpServletResponse response,
                                              Integer code,
                                              String message,
                                              String exceptionClazz) throws IOException {
        response.setCharacterEncoding(CharsetUtil.UTF_8);
        response.setContentType(ContentType.JSON.toString());
        //数据封装
        ResponseData error = ResponseData.error(code, message, exceptionClazz);
        String errorResponseJsonData = JSON.toJSONString(error);
        response.getWriter().write(errorResponseJsonData);
    }

}
