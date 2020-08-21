package com.thrift;

public class ThriftServer {

    public static void main(String[] args) throws Exception{
       /* TNonblockingServerSocket tn = new TNonblockingServerSocket(8899);
        THsHaServer.Args th = new THsHaServer.Args(tn).minWorkerThreads(2).maxWorkerThreads(4);
        PersonService.Processor<example> processor = new PersonService.Processor<>(new example());
        th.protocolFactory(new TCompactProtocol.Factory());
        th.transportFactory(new TFramedTransport.Factory());
        th.processorFactory(new TProcessorFactory(processor));
        TServer ts = new THsHaServer(th);
        ts.serve();//异步非阻塞*/

    }
}
