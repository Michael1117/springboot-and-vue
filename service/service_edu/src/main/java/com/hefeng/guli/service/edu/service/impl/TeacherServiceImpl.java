package com.hefeng.guli.service.edu.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hefeng.guli.service.edu.entity.Teacher;
import com.hefeng.guli.service.edu.entity.vo.TeacherQueryVo;
import com.hefeng.guli.service.edu.mapper.TeacherMapper;
import com.hefeng.guli.service.edu.service.TeacherService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

/**
 * <p>
 * 讲师 服务实现类
 * </p>
 *
 * @author Michael
 * @since 2020-10-23
 */
@Service
public class TeacherServiceImpl extends ServiceImpl<TeacherMapper, Teacher> implements TeacherService {


    @Override
    public IPage<Teacher> selectPage(Long page, Long limit, TeacherQueryVo teacherQueryVo) {
        // 显示分页查询列表
        Page<Teacher> pageParam = new Page<>(page, limit);
        // 1、 排序： 按照sort字段排序
        QueryWrapper<Teacher> queryWrapper = new QueryWrapper<>();
        queryWrapper.orderByAsc("sort");

        // 2、 查询
        if(teacherQueryVo == null) {
            return  baseMapper.selectPage(pageParam, queryWrapper);
        }

        // 3、条件查询
        String name = teacherQueryVo.getName();
        Integer level = teacherQueryVo.getLevel();
        String joinDateBegin = teacherQueryVo.getJoinDateBegin();
        String joinDateEnd = teacherQueryVo.getJoinDateEnd();

        if(!StringUtils.isEmpty(name)){
            queryWrapper.likeRight("name", name);

        }

        if(level != null){
            queryWrapper.eq("level", level);
        }
        if(!StringUtils.isEmpty(joinDateBegin)) {
            queryWrapper.ge("join_date", joinDateBegin);
        }

        if(!StringUtils.isEmpty(joinDateEnd)) {
            queryWrapper.le("join_date", joinDateEnd);
        }

        return baseMapper.selectPage(pageParam, queryWrapper);
    }


}
