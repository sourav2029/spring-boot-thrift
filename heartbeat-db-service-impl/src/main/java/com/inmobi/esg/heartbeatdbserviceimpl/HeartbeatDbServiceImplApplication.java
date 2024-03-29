package com.inmobi.esg.heartbeatdbserviceimpl;

import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocolFactory;
import org.apache.thrift.server.TServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;

import com.inmobi.esg.heartbeatdbserviceimpl.handler.HeartbeatServiceHandler;
import com.inmobi.thriftself.thrift.models.THeartbeatService;


@SpringBootApplication
public class HeartbeatDbServiceImplApplication {

	public static void main(String[] args) {
		SpringApplication.run(HeartbeatDbServiceImplApplication.class, args);
	}

	@Bean
	public TProtocolFactory tProtocolFactory() {
		return new TBinaryProtocol.Factory();
	}


	@Bean
	public ServletRegistrationBean<TServlet> calculator(TProtocolFactory protocolFactory, HeartbeatServiceHandler handler) {
		TServlet servlet = new TServlet(new THeartbeatService.Processor<>(handler), protocolFactory);
		return new ServletRegistrationBean<>(servlet, "/heartbeat/");
	}
}
