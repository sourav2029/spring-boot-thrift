package com.inmobi.esg.heartbeatdbserviceimpl.heartbeat;

import static org.junit.Assert.assertEquals;

import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.protocol.TProtocolFactory;
import org.apache.thrift.transport.THttpClient;
import org.apache.thrift.transport.TTransport;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.inmobi.esg.heartbeatdbservice.HeartbeatServiceClient;
import com.inmobi.esg.heartbeatdbservice.thrift.TCalculatorService;
import com.inmobi.esg.heartbeatdbservice.thrift.TOperation;


@RunWith(SpringRunner.class)
@SpringBootTest
public class HeartbeatServiceTest {
    @Autowired
    protected TProtocolFactory protocolFactory;

    protected HeartbeatServiceClient client;

    @Before
    public void setUp() throws Exception {
        client = new HeartbeatServiceClient("localhost",9000);

    }

    @Test
    public void testListOfCountry() throws Exception {
        System.out.println(client.getListOfCountry());
    }

    @Test
    public void testListOfOs() throws Exception {
        System.out.println(client.getListOfOS());
    }

}
