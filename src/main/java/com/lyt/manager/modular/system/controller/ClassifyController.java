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
}

