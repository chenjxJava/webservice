package com.chenjx.webservice.service;

import com.chenjx.webservice.service.impl.HelloServiceImpl;

import javax.xml.ws.Endpoint;

/**
 * create by chenjx 2018/8/9
 */
public class HelloServicePublish {
    public static void main(String[] args) {
        String address = "http://localhost:8989/WS_Server/WebService";
        Endpoint.publish(address, new HelloServiceImpl());
    }
}
