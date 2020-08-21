package com.example.student;

import com.google.protobuf.InvalidProtocolBufferException;

public class ProtoTest {

    public static void main(String[] args) {
        DataInfo.Student.Builder builder = DataInfo.Student.newBuilder().setName("aaa").setAge(19).setAddress("beijin");
        byte[] bytes = builder.build().toByteArray();
        DataInfo.Student student = null;
        try {
            student = DataInfo.Student.parseFrom(bytes);
        } catch (InvalidProtocolBufferException e) {
            e.printStackTrace();
        }
        System.out.println(student);
    }
}
