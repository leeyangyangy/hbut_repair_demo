package com.lyy.manager.modular.system.controller;

import com.lyy.manager.framework.respone.ResponseData;
import com.lyy.manager.modular.system.entity.Feedback;
import com.lyy.manager.modular.system.service.FeedbackService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author lyy
 * @since 2022-10-26
 */
@RestController
@RequestMapping("/feedback")
public class FeedbackController {

    @Resource
    private FeedbackService feedbackService;

    //    学生查看反馈信息
//    @RequestMapping(value = "/feedback/{sno}", method = RequestMethod.GET)
    @GetMapping("/{sno}")
    public ResponseData feedback(@PathVariable("sno") String sno) {
        List<Feedback> list = feedbackService.findAllByFsno(sno);
        if (list != null) {
            System.out.println("数据获取成功");
            list.forEach(System.out::println);
            return ResponseData.success(20041, "获取数据成功", list);
        } else {
//            找不到资源
            System.out.println("没有反馈内容，如有问题，请联系管理员");
            return ResponseData.success(20040, "找不到该学生的反馈", null);
        }
    }

    //    学生创建反馈信息   返回非空即添加成功
//    @RequestMapping(value = "/feedback/add/{sno}", method = RequestMethod.POST)
    @PostMapping("/{sno}")
    public ResponseData createFeedback(@RequestBody Feedback feedback, @PathVariable("sno") String sno) {
//        获取sno学号
        feedback.setFsno(sno);
        int total = feedbackService.addFeedback(feedback);
        if (total > 0) {
            return ResponseData.success(20011, "添加成功", true);
        }
        return ResponseData.error(20010, "添加失败", false);
    }
}

