package org.foodorder.backend.controller;


import lombok.extern.slf4j.Slf4j;
import org.foodorder.backend.model.Order;
import org.foodorder.backend.repository.OrderRepository;
import org.foodorder.backend.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
public class OrderController {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private EmailService emailService;

    @PostMapping("/order")
    public void placeOrder(@RequestBody Order order) {
        order.setId(orderRepository.findAll().size() + 1);
        orderRepository.save(order);

        String text= "Your order has been placed successfully. Your order id is " + order.getId() + ". Thank you for ordering with us.\n";
;

        StringBuilder orderDetails = new StringBuilder();
        order.getCartItems().forEach(cartItem -> {
            orderDetails.append("Item: ").append(cartItem.getName()).append("\n Price: ").append(cartItem.getPrice()).append("\n Quantity: ").append(cartItem.getQuantity()).append("\n");
        });

        emailService.sendEmail(order.getEmail(), "Order Confirmation", (text+orderDetails) +  "\n. Thank you for ordering with us.");

        orderRepository.delete(order);
    }


}
