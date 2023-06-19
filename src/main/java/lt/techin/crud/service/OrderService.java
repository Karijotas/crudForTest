package lt.techin.crud.service;

import lt.techin.crud.config.exception.CustomValidationException;
import lt.techin.crud.dao.OrderRepository;
import lt.techin.crud.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import static lt.techin.crud.service.FinderClass.findOrder;

@Service
public class OrderService {
    private final OrderRepository orderRepository;

    private final Validator validator;

    @Autowired
    public OrderService(OrderRepository orderRepository, Validator validator) {
        this.orderRepository = orderRepository;
        this.validator = validator;
    }

    void validateInputWithInjectedValidator(Order order) {
        Set<ConstraintViolation<Order>> violations = validator.validate(order);
        if (!violations.isEmpty()) {
            throw new CustomValidationException(violations.toString(), "Order", "Error in order entity", order.toString());
        }
    }

    public List<Order> getAll() {
        return orderRepository.findAll();
    }

    public Optional<Order> getById(Long id) {
        return orderRepository.findById(id);
    }

    public Order create(Order order) {
        var newOrder = new Order();

        newOrder.setId(order.getId());
        newOrder.setMeals(order.getMeals());
        newOrder.setCustomerName(order.getCustomerName());
        newOrder.setCustomerEmail(order.getCustomerEmail());
        newOrder.setCustomerPhoneNumber(order.getCustomerPhoneNumber());
        newOrder.setTotalAmount(order.getTotalAmount());
        newOrder.setAddress(order.getAddress());
        newOrder.setStatus(order.getStatus());
        newOrder.setTrackingNumber(order.getTrackingNumber());

        return orderRepository.save(newOrder);
    }

    public Order update(Long id, Order order) {
        validateInputWithInjectedValidator(order);
        Order existing = findOrder(id);

        existing.setMeals(order.getMeals());
        existing.setCustomerName(order.getCustomerName());
        existing.setCustomerEmail(order.getCustomerEmail());
        existing.setCustomerPhoneNumber(order.getCustomerPhoneNumber());
        existing.setTotalAmount(order.getTotalAmount());
        existing.setAddress(order.getAddress());
        existing.setStatus(order.getStatus());
        existing.setTrackingNumber(order.getTrackingNumber());

        return orderRepository.save(existing);
    }
    public Boolean deleteById(Long id) {
        try {
            orderRepository.deleteById(id);
            return true;
        } catch (EmptyResultDataAccessException e) {
            return false;
        }
    }
}
