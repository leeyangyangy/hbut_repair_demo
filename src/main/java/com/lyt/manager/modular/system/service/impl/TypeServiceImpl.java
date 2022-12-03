package com.lyt.manager.modular.system.service.impl;

import com.lyt.manager.modular.system.pojo.Type;
import com.lyt.manager.modular.system.mapper.TypeMapper;
import com.lyt.manager.modular.system.service.TypeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author lyy
 * @since 2022-11-28
 */
@Service
public class TypeServiceImpl extends ServiceImpl<TypeMapper, Type> implements TypeService {

    @Resource
    private TypeMapper typeMapper;

//    查询全部类别（小类）
    @Override
    public List<Type> findAllType() {
        return typeMapper.findAllType();
    }

//    按名修改
    @Override
    public int updateTypeByName(Type type) {
        return typeMapper.updateTypeByName(type);
    }

//    按id查找
    @Override
    public Type findTypeById(Integer id) {
        return typeMapper.findTypeById(id);
    }

    //    按名查找
    @Override
    public Type findTypeByName(String typeName) {
        return typeMapper.findTypeByName(typeName);
    }

    //    添加类别（小类）
    @Override
    public int addType(Type type) {
        return typeMapper.addType(type);
    }

//    按名删除
    @Override
    public int delTypeById(Integer id) {
        return typeMapper.delTypeById(id);
    }
}
