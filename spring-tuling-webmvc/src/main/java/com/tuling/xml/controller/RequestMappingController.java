package com.tuling.xml.controller;

import com.tuling.javaconfig.initbinder.User;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.util.Arrays;
import java.util.List;

/***
 * @Author 徐庶   QQ:1092002729
 * @Slogan 致敬大师，致敬未来的你
 */
@Controller
@RequestMapping("/request")
public class RequestMappingController {

    @RequestMapping("/mapping")
    public ModelAndView mapping(){
        System.out.println("RequestMappingController Working.");
        ModelAndView modelAndView = new ModelAndView("a");
        modelAndView.addObject("source","RequestMappingController");
        return modelAndView;
    }

    @PostMapping("/uploadData")
    public ResponseEntity uploadData(@RequestBody MultipartFile file) throws Exception {
        System.out.println(file.getName());
        System.out.println(file.getContentType());
        return ResponseEntity.ok(file.getName());
    }

    @RequestMapping(value="/mappin*")
    public String mapping02(){
        System.out.println("通配符——*");
        return "a";
    }
    @RequestMapping(value="/mappin?")
    public String mapping03(){
        System.out.println("通配符——？");
        return "a";
    }
    @RequestMapping(value="/**")
    public String mapping04(){
        System.out.println("**");
        return "a";
    }
    @RequestMapping("/updateUser")
    @ResponseBody
    public User updateUser(User user) {
        //返回修改后的 那么可能会把数据库中的年龄更新为空
        return user;
    }

    @ResponseBody
    @RequestMapping("/updateUser2/{id}")
    public User updateUser2(@PathVariable Integer id,@RequestParam String lastName) {
        User user=new User(id,lastName,null,null);
        return user;
    }

}
