// package com.grpcdemo.grpc.server;

// import io.grpc.Server;
// import io.grpc.ServerBuilder;

// import java.io.IOException;
// import java.util.List;
// import java.util.ServiceLoader;
// import java.util.stream.Collectors;

// import org.springframework.beans.factory.annotation.Value;
// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;

// @Configuration
// public class GrpcConfiguration {

 
//     @Value("${grpc.server.port}")
//     private int grpcServerPort;

//     @Bean
//     public Server grpcServer() throws IOException {
//         ServerBuilder<?> serverBuilder = ServerBuilder.forPort(grpcServerPort);
//         List<GrpcServiceDefinition> serviceDefinitions = loadGrpcServices();
//         for (GrpcServiceDefinition serviceDefinition : serviceDefinitions) {
//             serverBuilder.addService(serviceDefinition);
//         }
//         return serverBuilder.build();
//     }

//     private List<GrpcServiceDefinition> loadGrpcServices() {
//         ServiceLoader<GrpcServiceDefinition> serviceLoader = ServiceLoader.load(GrpcServiceDefinition.class);
//         return serviceLoader.stream().map(ServiceLoader.Provider::get).collect(Collectors.toList());
//     }
// }
