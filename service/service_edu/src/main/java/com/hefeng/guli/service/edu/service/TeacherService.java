package com.hefeng.guli.service.edu.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hefeng.guli.service.edu.entity.Teacher;
import com.baomidou.mybatisplus.extension.service.IService;
import com.hefeng.guli.service.edu.entity.vo.TeacherQueryVo;


public interface TeacherService extends IService<Teacher> {

    IPage<Teacher> selectPage(Long page, Long limit, TeacherQueryVo teacherQueryVo);
}
