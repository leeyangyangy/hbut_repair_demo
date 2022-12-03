package com.lyt.manager.modular.system.service.impl;

import com.lyt.manager.modular.system.pojo.Classify;
import com.lyt.manager.modular.system.mapper.ClassifyMapper;
import com.lyt.manager.modular.system.pojo.Type;
import com.lyt.manager.modular.system.service.ClassifyService;
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
public class ClassifyServiceImpl extends ServiceImpl<ClassifyMapper, Classify> implements ClassifyService {

    @Resource
    private ClassifyMapper classifyMapper;

//    查询全部
    @Override
    public List<Classify> findAllClassify() {
        return classifyMapper.findAllClassify();
    }

//    添加
    @Override
    public int addClassify(Type type) {
        return classifyMapper.addClassify(type);
    }

//    按名id
    @Override
    public int delClassifyById(Integer id) {
        return classifyMapper.delClassifyById(id);
    }

//    按名查找
    @Override
    public Classify findClassifyByName(String classifyName) {
        return classifyMapper.findClassifyByName(classifyName);
    }


    @Override
    public int updateClassifyByName(Classify classify) {
        return classifyMapper.updateClassifyByName(classify);
    }

//    按id查找
    @Override
    public Classify findClassifyById(Integer id) {
        return classifyMapper.findClassifyById(id);
    }
}
