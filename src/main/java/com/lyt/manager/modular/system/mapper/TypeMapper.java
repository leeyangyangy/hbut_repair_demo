package com.lyt.manager.modular.system.mapper;

import com.lyt.manager.modular.system.pojo.Type;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author lyy
 * @since 2022-11-28
 */
public interface TypeMapper extends BaseMapper<Type> {

    //    查询全部种类（小类别）
    List<Type> findAllType();

    //    添加类别（小类别）
    int addType(Type type);

    //    删除类别（小类别）
    int delTypeById(Integer id);

    //    按名查找
    Type findTypeByName(String typeName);

    //    按名修改
    int updateTypeByName(Type type);

//    按id查找
    Type findTypeById(Integer id);
}
