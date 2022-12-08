package com.lyt.manager.modular.system.controller;


import com.lyt.manager.modular.system.pojo.Classify;
import com.lyt.manager.modular.system.pojo.Type;
import com.lyt.manager.modular.system.service.ClassifyService;
import com.lyt.manager.modular.system.service.TypeService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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
@RequestMapping("/classify")
public class ClassifyController {

    @Resource
    private TypeService typeService;

    @Resource
    private ClassifyService classifyService;

    //   ---- Classify ----
//    查询全部
    @RequestMapping("getAllClassify")
    public String classifyList(HttpServletRequest request) {
        List<Classify> allClassify = classifyService.findAllClassify();
        request.setAttribute("allClassify", allClassify);
        List<Type> allType = typeService.findAllType();
        request.setAttribute("allType", allType);
        return "typeList";
    }

    //    id查找
    @GetMapping("toFindClassify")
    public String toFindClassify(Integer id, HttpServletRequest request) {
        System.out.println(id);
        Classify result = classifyService.findClassifyById(id);
        System.out.println(result);
        request.setAttribute("result", result);
        return "updateClassify";
    }

    @PostMapping("updateClassifyById")
    public String updateClassifyById(Classify classify, HttpServletRequest request) {
        classifyService.updateClassifyByName(classify);
        List<Classify> allClassify = classifyService.findAllClassify();
        request.setAttribute("allClassify", allClassify);
        List<Type> allType = typeService.findAllType();
        request.setAttribute("allType", allType);
        return "typeList";
    }

//    添加
    @PostMapping("add")
    public String add(Classify classify,HttpServletRequest request) {
        System.out.println(classify);
        classifyService.addClassify(classify);
        List<Classify> allClassify = classifyService.findAllClassify();
        request.setAttribute("allClassify", allClassify);
        List<Type> allType = typeService.findAllType();
        request.setAttribute("allType", allType);
        return "typeList";
    }

//    按名查找
    @PostMapping("checkClassifyName")
    @ResponseBody
    public boolean checkClassifyName(String classifyName) {
        System.out.println("检查名称是否存在");
        System.out.println(classifyName);
        if (null == classifyService.findClassifyByName(classifyName)) {
//            不存在
            return false;
        } else {
//            存在
            return true;
        }
    }

    @GetMapping("deleteClassifyById")
    public String deleteClassifyById(HttpServletRequest request,Integer id){
//        删除
        classifyService.delClassifyById(id);
//        展示数据
        List<Classify> allClassify = classifyService.findAllClassify();
        request.setAttribute("allClassify", allClassify);
        List<Type> allType = typeService.findAllType();
        request.setAttribute("allType", allType);
        return "typeList";
    }

}

