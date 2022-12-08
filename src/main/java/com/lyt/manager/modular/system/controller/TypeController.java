package com.lyt.manager.modular.system.controller;


import com.lyt.manager.modular.system.pojo.Classify;
import com.lyt.manager.modular.system.pojo.Type;
import com.lyt.manager.modular.system.service.ClassifyService;
import com.lyt.manager.modular.system.service.TypeService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
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
@RequestMapping("/type")
public class TypeController {

    @Resource
    private TypeService typeService;

    @Resource
    private ClassifyService classifyService;

    //    查询全部
    @RequestMapping("getAllType")
    public String typeList(HttpServletRequest request) {
        List<Type> allType = typeService.findAllType();
        request.setAttribute("allType", allType);
        List<Classify> allClassify = classifyService.findAllClassify();
        request.setAttribute("allClassify", allClassify);
        return "typeList";
    }

    //    id查找
    @GetMapping("toFindType")
    public String toFindType(Integer id, HttpServletRequest request) {
        System.out.println(id);
        Type result = typeService.findTypeById(id);
        System.out.println(result);
        request.setAttribute("result", result);
        return "updateType";
    }

    @PostMapping("updateTypeById")
    public String updateTypeById(Type type, HttpServletRequest request) {
        System.out.println(type);
//        typeService.findTypeById(type.getId());
        typeService.updateTypeByName(type);
        List<Type> allType = typeService.findAllType();
        request.setAttribute("allType", allType);
        List<Classify> allClassify = classifyService.findAllClassify();
        request.setAttribute("allClassify", allClassify);
        return "typeList";
    }


    //    添加
    @PostMapping("add")
    public String add(Type type, HttpServletRequest request) {
        System.out.println(type);
//        添加操作
        typeService.addType(type);
//        展示数据
        List<Classify> allClassify = classifyService.findAllClassify();
        request.setAttribute("allClassify", allClassify);
        List<Type> allType = typeService.findAllType();
        request.setAttribute("allType", allType);
        return "typeList";
    }

    //    按名查找
    @PostMapping("checkTypeName")
    @ResponseBody
    public boolean checkTypeName(String typeName) {
        System.out.println("检查名称是否存在");
        System.out.println(typeName);
        if (null == typeService.findTypeByName(typeName)) {
//            不存在
            return false;
        } else {
//            存在
            return true;
        }
    }

    @GetMapping("deleteTypeById")
    public String deleteTypeById(HttpServletRequest request, Integer id) {
//        删除
        typeService.delTypeById(id);
//        展示数据
        List<Classify> allClassify = classifyService.findAllClassify();
        request.setAttribute("allClassify", allClassify);
        List<Type> allType = typeService.findAllType();
        request.setAttribute("allType", allType);
        return "typeList";
    }
}

