package test;

import com.lyt.manager.modular.system.mapper.UserMapper;
import com.lyt.manager.modular.system.pojo.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
//加载spring配置文件
@ContextConfiguration("classpath:spring/spring-config.xml")
public class EnvTest {

    @Resource
    private UserMapper userMapper;

//    @Test
//    public void testEnv(){
////        测试用户登录
//        User user=new User();
//        user.setUserId("");
//        user.setPassword("");
//        user.setPermission(1);
//        User user1= userMapper.login(user);
//        System.out.println(user1);
//    }

//    测试查询全部用户
    @Test
    public void testFindAllUser(){
        List<User> allUser = userMapper.findAllUser();
        allUser.forEach(user -> {
            System.out.println(user);
            System.out.println(user.getPermission().getPermissionName());
            System.out.println(user.getPermission().getId());
        });
    }

//    测试按id查找用户
    @Test
    public void testFindUserById(){
        User user = userMapper.findUserByUserId("20223035104");
        System.out.println(user);
    }

//    更新用户
    @Test
    public void testUpdateUserByUserId(){

//        int total = userMapper.updateUserById("20223035104");

//        System.out.println(total);

    }
}
