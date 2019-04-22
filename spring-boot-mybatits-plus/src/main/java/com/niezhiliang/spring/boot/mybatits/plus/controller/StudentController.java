package com.niezhiliang.spring.boot.mybatits.plus.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.niezhiliang.spring.boot.mybatits.plus.domain.Student;
import org.springframework.web.bind.annotation.*;

/**
 * @Author NieZhiLiang
 * @Email nzlsgg@163.com
 * @Date 2019/3/16 上午9:52
 */
@RestController
@RequestMapping(value = "student")
public class StudentController {

    /**
     * 添加
     * @return
     */
    @PostMapping(value = "add")
    public Student add(@RequestBody Student student) {

        student.insert();
        return student;
    }

    /**
     * 127.0.0.1:8080/student/get/1
     * 获取某id的学生
     * @param id
     * @return
     */
    @GetMapping(value = "get/{id}")
    public Student getOne(@PathVariable("id") Long id) {
        return new Student().selectById(id);
    }


    /**
     * 127.0.0.1:8080/student/getOneByName?name=李四
     * 通过名字获取用户信息
     * @param name
     * @return
     */
    @GetMapping(value = "getOneByName")
    public Student getOneByName(String name) {
        return new Student().selectOne(new QueryWrapper<Student>()
                .lambda()
                .eq(Student::getUserName,name)
        );
    }

    /**
     * 127.0.0.1:8080/student/delete/1
     * 通过主键id删除学生
     * @param id
     * @return
     */
    @GetMapping(value = "delete/{id}")
    public Boolean delete(@PathVariable("id") Long id) {
        return new Student().deleteById(id);
    }

    /**
     * 通过主键修改并返回修改后的信息
     * @param student
     * @return
     */
    @PostMapping(value = "update")
    public Student update(@RequestBody Student student) {

        if(student.updateById()) {
            return student.selectById();
        }

        return null;
    }


    /**
     * 127.0.0.1:8080/student/query/1/5
     * 分页查询不带条件
     * @return
     */
    @GetMapping(value = "query/{page}/{pageSize}")
    public IPage<Student> queryPage(@PathVariable("page") Integer page, @PathVariable("pageSize") Integer pageSize) {

        return new Student().selectPage(new Page<Student>((page - 1 ) * pageSize,pageSize),null);
    }

    /**
     * 127.0.0.1:8080/student/queryCondition/1/5
     * 名字带三的模糊查询分页
     * @param page
     * @param pageSize
     * @return
     */
    @GetMapping(value = "queryCondition/{page}/{pageSize}")
    public IPage<Student> queryPageWithCondition(@PathVariable("page") Integer page, @PathVariable("pageSize") Integer pageSize) {
        return new Student().selectPage(new Page<Student>((page - 1 ) * pageSize,pageSize),
                new QueryWrapper<Student>().lambda()
                .like(Student::getUserName,"三")
        );
    }

    /**
     * 127.0.0.1:8080/student/queryCondition1/1/5
     * 家住杭州性别为男的 按年龄排序的模糊查询分页
     * @param page
     * @param pageSize
     * @return
     */
    @GetMapping(value = "queryCondition1/{page}/{pageSize}")
    public IPage<Student> queryPageWithCondition1(@PathVariable("page") Integer page, @PathVariable("pageSize") Integer pageSize) {
        return new Student().selectPage(new Page<Student>((page - 1 ) * pageSize,pageSize),
                new QueryWrapper<Student>().lambda()
                        .eq(Student::getSex,(byte)1)
                        .like(Student::getAddress,"杭州")
                        .orderByDesc(Student::getAge)
        );
    }

}
