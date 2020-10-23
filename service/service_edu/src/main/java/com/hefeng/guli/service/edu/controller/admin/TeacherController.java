package com.hefeng.guli.service.edu.controller.admin;


import com.hefeng.guli.service.edu.entity.Teacher;
import com.hefeng.guli.service.edu.service.TeacherService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
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

@Api(description = "讲师管理")
@RestController
@RequestMapping("/admin/edu/teacher")
public class TeacherController {
    @Autowired
    private TeacherService teacherService;

    @ApiOperation("所有讲师列表")
    @GetMapping("list")
    public List<Teacher> listAll(){
        List<Teacher> list = teacherService.list();
        return list;
    }

    @ApiOperation(value = "根据id删除讲师" , notes = "根据id删除讲师，逻辑删除")
    @DeleteMapping("remove/{id}")
    public boolean removeById(@ApiParam("讲师ID") @PathVariable String id){
       return teacherService.removeById(id);
    }
}

