package test;

import com.lyt.manager.modular.system.mapper.UserMapper;
import com.lyt.manager.modular.system.pojo.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

@RunWith(SpringJUnit4ClassRunner.class)
//加载spring配置文件
@ContextConfiguration("classpath:spring/spring-config.xml")
public class EnvTest {

    @Resource
    private UserMapper userMapper;

    @Test
    public void testEnv(){
//        测试用户登录
        User user=new User();
        user.setUserId("");
        user.setPassword("");
        user.setPermission(1);
        User user1= userMapper.login(user);
        System.out.println(user1);
    }

}
