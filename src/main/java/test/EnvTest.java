package test;

import com.lyt.manager.modular.system.mapper.DeliveryMapper;
import com.lyt.manager.modular.system.mapper.UserMapper;
import com.lyt.manager.modular.system.paramter.ProductParamter;
import com.lyt.manager.modular.system.pojo.Delivery;
import com.lyt.manager.modular.system.pojo.Product;
import com.lyt.manager.modular.system.pojo.Type;
import com.lyt.manager.modular.system.pojo.User;
import com.lyt.manager.modular.system.service.DeliveryService;
import com.lyt.manager.modular.system.service.ProductService;
import com.lyt.manager.modular.system.service.SupplierService;
import com.lyt.manager.modular.system.service.TypeService;
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

    @Resource
    private TypeService typeService;

    @Resource
    private DeliveryService deliveryService;

    @Resource
    private ProductService productService;

    @Resource
    private SupplierService supplierService;

    @Resource
    private DeliveryMapper deliveryMapper;


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

//    测试查询全部小类别，按名删除，添加
    @Test
    public void testType(){
        List<Type> allType = typeService.findAllType();
        allType.forEach(type -> System.out.println(type));
//        Type type=new Type();
//        type.setTypeOperator("测试");
//        type.setTypeName("测试");
//        int total=typeService.addType(type);
//        System.out.println("total="+total);
//        total=typeService.delTypeByName(1);
//        System.out.println("total="+total);
//        type.setId(7);
//        int total =typeService.updateTypeByName(type);
//        System.out.println(total);
        Type type=typeService.findTypeById(1);
        System.out.println(type);
    }

//    查询全部物料
    @Test
    public void testFindProduct(){
        List<Product> allProduct = productService.findAllProduct();
        allProduct.forEach(product -> System.out.println(product));
    }

    @Test
    public void testPM(){
//        ProductParamter paramter=new ProductParamter();
////        paramter.setProductName(null);
////        paramter.get
//        if (paramter == null){
//            System.out.println("null");
//            System.out.println(paramter);
//        }else {
//            System.out.println("not null");
//            System.out.println(paramter);
//            paramter.setProductWarn(1);
//            System.out.println(paramter.getProductWarn());
//        }

//        int total = productService.delProductById(2);
//        System.out.println("total="+total);
        int total=productService.addProductValueById(3,10);
        System.out.println(total);
    }


    @Test
    public void testDelivery(){
        List<Delivery> list = deliveryMapper.findDeliveryByLikeUserName("c");
        list.forEach(delivery -> System.out.println(delivery));

    }

}
