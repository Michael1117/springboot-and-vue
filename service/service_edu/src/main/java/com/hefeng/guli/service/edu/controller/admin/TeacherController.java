package com.hefeng.guli.service.edu.controller.admin;


import com.hefeng.guli.service.edu.entity.Teacher;
import com.hefeng.guli.service.edu.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 讲师 前端控制器
 * </p>
 *
 * @author Michael
 * @since 2020-10-23
 */
@RestController
@RequestMapping("/admin/edu/teacher")
public class TeacherController {
    @Autowired
    private TeacherService teacherService;

    @GetMapping("list")
    public List<Teacher> listAll(){
        List<Teacher> list = teacherService.list();
        return list;
    }

    @DeleteMapping("remove/{id}")
    public boolean removeById(@PathVariable String id){
       return teacherService.removeById(id);
    }
}

