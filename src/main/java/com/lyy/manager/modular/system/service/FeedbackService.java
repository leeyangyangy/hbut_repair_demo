package com.lyy.manager.modular.system.service;

import com.lyy.manager.modular.system.entity.Feedback;
import com.baomidou.mybatisplus.extension.service.IService;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author lyy
 * @since 2022-10-26
 */
public interface FeedbackService extends IService<Feedback> {

    //    根据学号查询学生反馈内容
    List<Feedback> findAllByFsno(@Param("sno") String sno);

    /**
     * 学生反馈和留言
     * @param feedback
     * @return
     */
    int addFeedback(Feedback feedback);
}
