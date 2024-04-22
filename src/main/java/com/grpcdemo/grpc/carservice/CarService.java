package com.grpcdemo.grpc.carservice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.io.IOException;
import com.grpcdemo.grpc.dao.Cardata;
import com.grpcdemo.grpc.dao.demoRepo;
import com.grpcdemo.grpc.protofile.Car;
import com.grpcdemo.grpc.protofile.CarRequest;
import com.grpcdemo.grpc.protofile.CarServiceGrpc;

import io.grpc.stub.StreamObserver;

@Service
public class CarService extends CarServiceGrpc.CarServiceImplBase{

    private final demoRepo repo;

    @Autowired
    public CarService(demoRepo repo) {
        this.repo = repo;
    }
   
    @Override
    public void getCar(Car request, StreamObserver<Car> responseObserver) {
        // Implement your service logic here
        Car car = Car.newBuilder()
                .setCarNo(request.getCarNo())
                .setCarName(request.getCarName())
                .setCarModel(request.getCarModel())
                .build();
        Cardata data=new Cardata();
            data.setCarModel(request.getCarModel());
            data.setCarName(request.getCarName());
            data.setCarNo(request.getCarNo());
        repo.save(data);
        responseObserver.onNext(car);
        responseObserver.onCompleted();
    }

    @Override
    public void getAllCars(CarRequest request, StreamObserver<Car> responseObserver){
        List<Cardata> data=repo.findAll();
        for(Cardata car:data){
            Car carResponse=Car.newBuilder()
                                .setCarModel(car.getCarModel())
                                .setCarName(car.getCarName())
                                .setCarNo(car.getCarNo())
                                .build();
            responseObserver.onNext(carResponse);
        }
        responseObserver.onCompleted();

    }

    public void check() throws IOException{

    }
}
