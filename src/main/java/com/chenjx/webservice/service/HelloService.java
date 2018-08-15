package com.chenjx.webservice.service;

import com.chenjx.webservice.model.User;

import javax.jws.WebMethod;
import javax.jws.WebService;
import java.util.List;

@WebService
public interface HelloService {

    @WebMethod
    String say();

    @WebMethod
    String sayHello(String name);

    @WebMethod
    String putNameAndAge(String name, String age);

    @WebMethod
    List<User> getUserList();
}
