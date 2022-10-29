package com.lyy.manager.framework.mybatisplus;

import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.BlockAttackInnerInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.OptimisticLockerInnerInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @Package: com.lyy.manager.framwork.mybatisplus
 * @Author: LEEYANGYANG
 * @Create: 2022/10/26 19:27
 * @Description:
 */
@MapperScan(basePackages = "com.lyy.manager.**.mapper")
@EnableTransactionManagement//事务
@Configuration//配置类
public class MyBatisPlusConfig {

    /**
     * 插件3.4.2
     */
    @Bean
    public MybatisPlusInterceptor mybatisPlusInterceptor() {
        MybatisPlusInterceptor interceptor = new MybatisPlusInterceptor();
        //乐观锁插件
        interceptor.addInnerInterceptor(new OptimisticLockerInnerInterceptor());
        //分页
        interceptor.addInnerInterceptor(new PaginationInnerInterceptor());
        // 阻断（防止全表更新）
        interceptor.addInnerInterceptor(new BlockAttackInnerInterceptor());
        //逻辑删除 MybatisPlus最新的版本只需要配置yml和在实体类上面添加注解就可以了
        return interceptor;
    }

}
