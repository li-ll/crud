package org.example.controller;

import io.swagger.annotations.ApiOperation;
import org.example.domain.Upath;


import org.reflections.Reflections;
import org.reflections.scanners.MethodAnnotationsScanner;
import org.reflections.util.ClasspathHelper;
import org.reflections.util.ConfigurationBuilder;
import org.springframework.web.bind.annotation.*;
import java.lang.reflect.Method;
import java.util.Date;
import java.util.Set;

/**
 * @author ruo
 * @version 1.0
 * @date 2023/4/22
 */
public class scanController {


    public static void main(String[] args) {
        getRequestMappingMethod("org.example.controller");
    }

    /**
     * @param scanPackage 需要扫描的包路径
     */
    private static void getRequestMappingMethod(String scanPackage) {
        //设置扫描路径
        Reflections reflections = new Reflections(new ConfigurationBuilder().setUrls(ClasspathHelper.forPackage(scanPackage)).setScanners(new MethodAnnotationsScanner()));

        //扫描包内带有@ApiOperation注解的所有方法集合
        Set<Method> methods = reflections.getMethodsAnnotatedWith(ApiOperation.class);
        Date now = new Date();
        //循环获取方法
        methods.forEach(method -> {

            //用于保存方法的请求类型
            String methodType = "";

            //获取类上的@RequestMapping注解的值，作为请求的基础路径
            String url = method.getDeclaringClass().getAnnotation(RequestMapping.class).value()[0];

            //获取方法上的@PutMapping,@GetMapping,@PostMapping,@DeleteMapping注解的值，作为请求路径,并区分请求方式
            if (method.getAnnotation(PutMapping.class) != null) {
                methodType = "put";
                if (method.getAnnotation(PutMapping.class).value().length > 0) {
                    url = method.getAnnotation(PutMapping.class).value()[0];
                }
            } else if (method.getAnnotation(GetMapping.class) != null) {
                methodType = "get";
                if (method.getAnnotation(GetMapping.class).value().length > 0) {
                    url = method.getAnnotation(GetMapping.class).value()[0];
                }
            } else if (method.getAnnotation(PostMapping.class) != null) {
                methodType = "post";
                if (method.getAnnotation(PostMapping.class).value().length > 0) {
                    url = method.getAnnotation(PostMapping.class).value()[0];
                }
            } else if (method.getAnnotation(DeleteMapping.class) != null) {
                if (method.getAnnotation(DeleteMapping.class).value().length > 0) {
                    url = method.getAnnotation(DeleteMapping.class).value()[0];
                }
            }
            Upath upath = new Upath();
            upath.setMethodType(methodType);
            upath.setUrl(url);
            upath.setCreateTime(now);
            System.out.println(upath);
        });
    }
}