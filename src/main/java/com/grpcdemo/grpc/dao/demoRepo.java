package com.grpcdemo.grpc.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface demoRepo extends JpaRepository<Cardata, Integer>{

}
