package lt.techin.crud.api;

import lombok.extern.slf4j.Slf4j;
import lt.techin.crud.api.dto.orders.OrderDto;
import lt.techin.crud.api.dto.orders.OrderEntityDto;
import lt.techin.crud.model.Order;
import lt.techin.crud.service.OrderService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

import static lt.techin.crud.api.dto.mapper.OrderMapper.toOrder;
import static lt.techin.crud.api.dto.mapper.OrderMapper.toOrderEntityDto;
import static org.springframework.http.ResponseEntity.ok;

@Controller
@RequestMapping("/api/v1/orders")
@Validated
@Slf4j
public class OrderController {

    private final OrderService service;

    public OrderController(OrderService orderService) {
        this.service = orderService;
    }

    @GetMapping
    @ResponseBody
    public List<Order> getAll() {
        return service.getAll();
    }

    @GetMapping(value = "/{orderId}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<OrderEntityDto> getIndividual(@PathVariable Long orderId) {
        var optional = service.getById(orderId);

        return optional
                .map(order -> ok(toOrderEntityDto(order)))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Order> create(@Valid @RequestBody OrderEntityDto orderEntityDto) {
        return ok(service.create(toOrder(orderEntityDto)));
    }

    @PatchMapping("/{orderId}")
    public ResponseEntity<Order> update(@PathVariable Long orderId, @Valid @RequestBody OrderDto orderDto) {
        log.info("Trying to update order by id: {}", orderId);
        return ok(service.update(orderId, toOrder(orderDto)));
    }

    @DeleteMapping("/delete/{orderId}")
    public ResponseEntity<Void> delete(@PathVariable Long orderId) {
        log.info("Trying to delete order by id: {}", orderId);

        if (service.deleteById(orderId)) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.noContent().build();
        }
    }
}
