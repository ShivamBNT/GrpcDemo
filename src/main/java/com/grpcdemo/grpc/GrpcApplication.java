package com.grpcdemo.grpc;

import java.io.IOException;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import com.grpcdemo.grpc.carservice.CarService;

import io.grpc.Server;
import io.grpc.ServerBuilder;



@SpringBootApplication
@ComponentScan(basePackages = "com.grpcdemo.grpc")
public class GrpcApplication {

	@Bean
public Server grpcServer(CarService carService) {
    return ServerBuilder.forPort(8090)
          .addService(carService)
          .build();
}

	public static void main(String[] args) throws IOException, InterruptedException {
		ConfigurableApplicationContext context = SpringApplication.run(GrpcApplication.class, args);
		Server server = context.getBean(Server.class);
		server.start();
		server.awaitTermination();
	}

	
	// public static void main(String[] args) {
	// 	SpringApplication.run(GrpcApplication.class, args);
	// }



}
