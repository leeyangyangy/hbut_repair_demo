package com.lyt.manager.modular.system.service;

import com.lyt.manager.modular.system.pojo.Classify;
import com.baomidou.mybatisplus.extension.service.IService;
import com.lyt.manager.modular.system.pojo.Type;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author lyy
 * @since 2022-11-28
 */
public interface ClassifyService extends IService<Classify> {
    //    查询全部（小类）
    List<Classify> findAllClassify();

    //    添加类别（小类别）
    int addClassify(Type type);

    //    删除类别（小类别）
    int delClassifyById(Integer id);

    //    按名查找
    Classify findClassifyByName(String classifyName);

    //    按名修改
    int updateClassifyByName(Classify classify);

    //    按id查找
    Classify findClassifyById(Integer id);
}
