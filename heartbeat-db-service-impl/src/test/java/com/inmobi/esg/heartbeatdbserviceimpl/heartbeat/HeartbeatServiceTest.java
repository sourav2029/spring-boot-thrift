package com.inmobi.esg.heartbeatdbserviceimpl.heartbeat;

import static org.junit.Assert.assertEquals;

import org.apache.thrift.protocol.TProtocolFactory;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.inmobi.esg.heartbeatdbservice.HeartbeatServiceClient;


@RunWith(SpringRunner.class)
@SpringBootTest
public class HeartbeatServiceTest {
    @Autowired
    protected TProtocolFactory protocolFactory;

    private HeartbeatServiceClient client;

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

    @Test
    public void testListOfProposition() throws Exception {
        System.out.println(client.getListOfProposition());
    }

    @Test
    public void testListOfEventType() throws Exception {
        System.out.println(client.getListOfEventType());
    }

    @Test
    public void testListOfChannel() throws Exception {
        System.out.println(client.getListOfChannel());
    }

    @Test
    public void testAdvertiserByAdvertiserId() throws Exception {
        System.out.println(client.getAdvertiserByAdvertiserId(1));
    }
}
