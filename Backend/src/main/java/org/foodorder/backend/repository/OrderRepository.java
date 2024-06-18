package org.foodorder.backend.repository;


import org.foodorder.backend.model.Order;
import org.springframework.data.mongodb.repository.MongoRepository;



public interface OrderRepository extends MongoRepository<Order, String>{

}
