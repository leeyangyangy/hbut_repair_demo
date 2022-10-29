package com.lyy.manager.modular.system.service.impl;

import com.lyy.manager.modular.system.entity.Feedback;
import com.lyy.manager.modular.system.mapper.FeedbackMapper;
import com.lyy.manager.modular.system.service.FeedbackService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author lyy
 * @since 2022-10-26
 */
@Service
public class FeedbackServiceImpl extends ServiceImpl<FeedbackMapper, Feedback> implements FeedbackService {
    @Override
    public int addFeedback(Feedback feedback) {
        return this.baseMapper.addFeedback(feedback);
    }

    @Override
    public List<Feedback> findAllByFsno(String sno) {
        return this.baseMapper.findAllByFsno(sno);
    }
}
