package com.lyt.manager.modular.system.controller;


import com.lyt.manager.modular.system.pojo.*;
import com.lyt.manager.modular.system.service.*;
import com.lyt.manager.modular.util.FileUploadUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author lyy
 * @since 2022-11-28
 */
@Controller
@RequestMapping("/product")
public class ProductController {
    /**
     * 参数选型
     * 1.HttpServletRequest    只有通过转发方式到达目标页面就结束
     * 2.HttpSession           所有(多个)页面都需要用到的数据
     * 3.ServletContext        所有用户共享数据   数据一直在内存中，服务器重启才消失
     * 4.ModelAndView          方法返回值是ModelAndView
     * 5.Model                 只有通过转发方式到达目标页面就结束
     */

    @Resource
    private ProductService productService;

    @Resource
    private SupplierService supplierService;

    @Resource
    private TypeService typeService;

    @Resource
    private ClassifyService classifyService;

    @Resource
    private DeliveryService deliveryService;

    @Resource
    private StorageService storageService;

    //    获取所有物料信息
    @GetMapping("/getAllProduct")
    public String getAllProduct(HttpServletRequest request) {
        List<Product> allProduct = productService.findAllProduct();
        request.setAttribute("allProduct", allProduct);
        return "productList";
    }

    @GetMapping("deleteProductById")
    public String deleteProductById(Integer id, HttpServletRequest request) {
        System.out.println(id);
        int total = productService.delProductById(id);
        System.out.println("total=" + total);
        List<Product> allProduct = productService.findAllProduct();
        request.setAttribute("allProduct", allProduct);
        return "redirect:/productList.jsp";
    }

    @GetMapping("findProductById")
    private String findProductById(Integer id, HttpServletRequest request) {
        Product result = productService.findProductById(id);
        request.setAttribute("result", result);
        List<Supplier> allSupplier = supplierService.findAllSupplier();
        request.setAttribute("allSupplier", allSupplier);
        List<Type> allType = typeService.findAllType();
        List<Classify> allClassify = classifyService.findAllClassify();
        request.setAttribute("allType", allType);
        request.setAttribute("allClassify", allClassify);
        return "updateProduct";
    }

    @PostMapping("updateProductById")
    public String updateProductById(Product p, MultipartFile multipartFile, String url, HttpServletRequest request) {
        System.out.println(multipartFile);
        System.out.println("p=" + p);
        /**
         *
         * 处理文件上传
         *
         * 数据库直接存文件名，后台自行拼接？
         *
         */
        FileUploadUtils fileUploadUtils = new FileUploadUtils();
        String upload = fileUploadUtils.upload(multipartFile);
        System.out.println("上传文件=="+upload);
//        if () {
//
//        } else
        System.out.println("url=" + url);
        if(upload==null)p.setProductPicture(url);
        else {
            String filePath;
            //    linux
//            String linuxPath = "/home/admin/upload/images/";
//            String winPath = "D://images";
            String path = "images";
            System.out.println("final upload=" + upload);
//            删除文件
//            ......
//            win直接回显（配置webMvc）
//            p.setProductPicture(winPath + '/' + upload);
            p.setProductPicture(path + '/' + upload);
        };
        System.out.println("图片地址=="+p.getProductPicture());
        productService.updateProductById(p);
        List<Product> allProduct = productService.findAllProduct();
        request.setAttribute("allProduct", allProduct);
        return "redirect:/productList.jsp";
    }

    //    出库记录
    @GetMapping("subProductValueById")
    public String subProductValueById(Integer id, HttpSession session) {
        Product product = productService.findProductById(id);
        if (product.getProductValue() <= product.getProductWarn()) {
            return "redirect:/productList.jsp";
        } else {
            /**
             * 假设库存数量是10，一次出10台，刚好可以
             * 如果库存数量是9，强制出10台，预警值恰好是5，这时候如何设计？
             */
//            出货数
            int export=10;
            if(export>=product.getProductValue()){
//                不允许出库
                return "redirect:/productList.jsp";
            }
//            默认减去10
            productService.subProductValueById(id, export);
//            填写出库记录
            Delivery delivery = new Delivery();
//            数量  类型强转
            delivery.setDeliveryNumber(Long.valueOf(export));
            delivery.setProductName(product.getProductName());
//            获取当前session对象
            User user = (User) session.getAttribute("login");
            System.out.println(user);
            delivery.setDeliveryUser(user.getUsername());
            int total = deliveryService.addDelivery(delivery);
            System.out.println(total);
        }
        System.out.println(product.getProductValue());
        return "redirect:/productList.jsp";
    }

    //    入库记录
    @GetMapping("addProductValueById")
    public String addProductValueById(Integer id, HttpSession session) {
        Product product = productService.findProductById(id);
//        默认+10
        productService.addProductValueById(id, 10);
        //            获取当前session对象
        User user = (User) session.getAttribute("login");
        Storage storage = new Storage();
        storage.setProductName(product.getProductName());
        storage.setStorageUser(user.getUsername());
//        数量
        storage.setStorageNumber(10L);
        storageService.addStorage(storage);
//        填写入库记录
        return "redirect:/productList.jsp";
    }

    //    添加物料
    @PostMapping("addProduct")
    public String addProduct(Product p, MultipartFile multipartFile, String url, HttpServletRequest request) {
        System.out.println(multipartFile);
        System.out.println("p=" + p);
        /**
         *
         * 处理文件上传
         *
         * 数据库直接存文件名，后台自行拼接？
         *
         */
        FileUploadUtils fileUploadUtils = new FileUploadUtils();
        String upload = fileUploadUtils.upload(multipartFile);
        System.out.println("上传文件=="+upload);
//        if () {
//
//        } else
        System.out.println("url=" + url);
        if(upload==null)p.setProductPicture(url);
        else {
            String filePath;
            //    linux
//            String linuxPath = "/home/admin/upload/images/";
//            String winPath = "D://images";
            String path = "images";
            System.out.println("final upload=" + upload);
//            删除文件
//            ......
//            win直接回显（配置webMvc）
//            p.setProductPicture(winPath + '/' + upload);
            p.setProductPicture(path + '/' + upload);
        };
        p.setProductValue(0L);
        if(p.getProductUnits()==null)p.setProductUnits("台");
        System.out.println("图片地址=="+p.getProductPicture());
//        添加操作
        productService.addProduct(p);
        List<Product> allProduct = productService.findAllProduct();
        request.setAttribute("allProduct", allProduct);
        return "redirect:/productList.jsp";
    }
}

