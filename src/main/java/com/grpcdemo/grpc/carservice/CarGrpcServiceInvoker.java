// package com.grpcdemo.grpc.carservice;

// import com.grpcdemo.grpc.protofile.Car;
// import com.grpcdemo.grpc.server.GrpcServiceDefinition;

// import io.grpc.ServerServiceDefinition;
// import io.grpc.stub.StreamObserver;

// public class CarGrpcServiceInvoker implements GrpcServiceDefinition{
    
//     private final CarService carService;

//     public CarGrpcServiceInvoker(CarService carService) {
//         this.carService = carService;
//     }

//     @Override
//     public ServerServiceDefinition bindService() {
//         return null;
//         // No need to implement anything here, as it's just a marker interface
//     }

//     // Implement the gRPC service method by delegating to CarService method
//     public void getCar(Car request, StreamObserver<Car> responseObserver) {
//         carService.getCar(request, responseObserver);
//     }
// }
