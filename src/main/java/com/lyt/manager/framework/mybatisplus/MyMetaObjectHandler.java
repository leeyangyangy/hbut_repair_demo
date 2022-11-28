package com.lyt.manager.framework.mybatisplus;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @Package: com.lyy.manager.framwork.mybatisplus
 * @Author: LEEYANGYANG
 * @Create: 2022/10/26 19:28
 * @Description:
 */
@Component //定义Spring管理Bean（将标注@Component注解的类交由spring管理）
public class MyMetaObjectHandler implements MetaObjectHandler {
    @Override
    public void insertFill(MetaObject metaObject) {
        this.setFieldValByName("createTime", new Date(), metaObject); //创建时间
        this.setFieldValByName("updateTime", new Date(), metaObject); //首次创建时间
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        this.setFieldValByName("updateTime", new Date(), metaObject); //修改时间
    }
}
