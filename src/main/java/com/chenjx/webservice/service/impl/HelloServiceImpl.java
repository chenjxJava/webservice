package com.chenjx.webservice.service.impl;

import com.chenjx.webservice.model.User;
import com.chenjx.webservice.service.HelloService;

import javax.jws.WebService;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * create by chenjx 2018/8/9
 */
@WebService()
public class HelloServiceImpl implements HelloService {
    @Override
    public String say() {
        return "this is simple case";
    }

    @Override
    public String sayHello(String name) {
        return "i just want to say hello..." + name;
    }

    @Override
    public String putNameAndAge(String name, String age) {
        return "input{name:"+ name + ",age:" + age + "}";
    }

    @Override
    public List<User> getUserList() {
        ArrayList<User> users = new ArrayList<>();
        User user1 = new User(1L,"liukai",20);
        User user2 = new User(2L,"yehan",25);
        User user3 = new User(3L,"chenyanpu",29);

        users.add(user1);
        users.add(user2);
        users.add(user3);

        return users;
    }


}
