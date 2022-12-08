package com.lyt.manager.modular.system.mapper;

import com.lyt.manager.modular.system.pojo.Classify;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author lyy
 * @since 2022-11-28
 */
public interface ClassifyMapper extends BaseMapper<Classify> {

//    查询全部（小类）
    List<Classify> findAllClassify();

    //    添加类别（小类别）
    int addClassify(Classify classify);

    //    删除类别（小类别）
    int delClassifyById(Integer id);

    //    按名查找
    Classify findClassifyByName(String classifyName);

    //    按名修改
    int updateClassifyByName(Classify classify);

    //    按id查找
    Classify findClassifyById(Integer id);
}
