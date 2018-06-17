package assambler;

import dto.OrderDTO;
import exception.CsikiDeliveryApiException;
import model.Order;

import javax.ejb.Stateless;

@Stateless
public class OrderAssembler extends EntityAssembler<Order, OrderDTO> {

    @Override
    public OrderDTO createDto() {
        return new OrderDTO();
    }

    @Override
    public Order createModel() {
        return new Order();
    }

    @Override
    public OrderDTO modelToDto(Order model) throws CsikiDeliveryApiException {
        final OrderDTO orderDTO = createDto();
        orderDTO.setId(model.getId());
        orderDTO.setAddress(model.getAddress());
        orderDTO.setAmount(model.getAmount());
        orderDTO.setOrderDate(model.getOrderDate());
        orderDTO.setProductId(model.getProductId());
        return orderDTO;
    }

    @Override
    public Order dtoToModel(OrderDTO dto) throws CsikiDeliveryApiException {
        final Order order = createModel();
        order.setId(dto.getId());
        order.setAddress(dto.getAddress());
        order.setAmount(dto.getAmount());
        order.setOrderDate(dto.getOrderDate());
        order.setProductId(dto.getProductId());
        return order;
    }

}
