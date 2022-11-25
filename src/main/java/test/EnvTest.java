package test;

import com.lyt.dao.UserMapper;
import com.lyt.pojo.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

@RunWith(SpringJUnit4ClassRunner.class)
//加载spring配置文件
@ContextConfiguration("classpath:spring-config.xml")
public class EnvTest {

    @Resource
    private UserMapper userMapper;

    @Test
    public void testEnv(){

        User user=new User();
        user.setName("李洋洋");
        user.setPassword("1111");

        User user1= userMapper.login(user);
        System.out.println(user1);
    }

}
