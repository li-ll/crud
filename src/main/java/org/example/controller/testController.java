package org.example.controller;

import org.springframework.web.bind.annotation.*;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
/**
 * @author ruo
 * @version 1.0
 * @date 2023/4/22
 */


@RestController
@RequestMapping("/users")
public class testController {
    @GetMapping
    @ApiOperation("获取列表")
    public void list() {
        System.out.println();
    }


    @GetMapping(path = "/{userId}")
    @ApiOperation("获取详情")
    public void getUserById(@PathVariable("userId") String userId) {
        System.out.println();
    }

    @PostMapping
    @ApiOperation("新增一个用户")
    public void save() {
        System.out.println();
    }

    @PutMapping("/{userId}")
    @ApiOperation("修改保存")
    public void editSave(@PathVariable String userId) {
        System.out.println();
    }


}
