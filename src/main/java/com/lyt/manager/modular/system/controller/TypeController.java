package com.lyt.manager.modular.system.controller;


import com.lyt.manager.modular.system.pojo.Classify;
import com.lyt.manager.modular.system.pojo.Type;
import com.lyt.manager.modular.system.service.ClassifyService;
import com.lyt.manager.modular.system.service.TypeService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

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

}

