package com.thrift;

import com.thrift.frist.Person;
import com.thrift.frist.PersonService;
import org.apache.thrift.protocol.TCompactProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TFramedTransport;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;

public class ThriftClient {

    public static void main(String[] args) {
        TTransport  ttransport = new TFramedTransport(new TSocket("localhost",8899),600);
        TProtocol tprotocol = new TCompactProtocol(ttransport);
        PersonService.Client  Client = new PersonService.Client(tprotocol);
        try {
            ttransport.open();
            Person lisi = Client.getPersonByUsername("lisi");
            System.out.println(lisi);
        } catch (Exception e) {

        } finally{
            ttransport.close();
        }
    }
}
