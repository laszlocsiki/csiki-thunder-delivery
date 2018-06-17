package resources;

import assambler.OrderAssembler;
import dto.OrderDTO;
import exception.CsikiDeliveryApiException;
import model.Order;
import model.Payment;
import model.Product;
import service.*;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Stateless
@Path(value = "/orders")
@Produces(MediaType.APPLICATION_JSON)
public class OrderResource {

    @EJB
    private OrderService orderService;

    @EJB
    private OrderAssembler orderAssembler;

    @EJB
    private AuthenticationService authService;

    @EJB
    private PaymentService paymentService;

    @EJB
    private ProductService productService;

    @GET
    public Response getOrders(@Context HttpServletRequest request) throws CsikiDeliveryApiException {
        try {
            List<Order> orders = orderService.findAllOrder();
            List<OrderDTO> orderDTOS = orders.stream().map(p -> orderAssembler.modelToDto(p)).collect(Collectors.toList());
            return Response.ok(orderDTOS).build();
        } catch (ServiceException ex) {
            throw new CsikiDeliveryApiException(ex.getMessage(), ex);
        }
    }

    @GET
    @Path("/{orderId}")
    public Response getOrder(@PathParam("orderId") long id, @Context HttpServletRequest request) throws CsikiDeliveryApiException {
        try {
            Order order = orderService.findById(id);
            OrderDTO orderDTO = orderAssembler.modelToDto(order);
            return Response.ok(orderDTO).build();
        } catch (ServiceException ex) {
            throw new CsikiDeliveryApiException(ex.getMessage(), ex);
        }
    }

    @POST
    public Response createOrder(OrderDTO orderDTO, @Context HttpServletRequest request) throws CsikiDeliveryApiException {
        try {
            Order order = orderAssembler.dtoToModel(orderDTO);
            order.setOrderDate(new Date());
            orderService.createOrder(order);

            //create payment object/record
            Product product = productService.findById(order.getProductId());
            paymentService.createPayment(new Payment(order.getId(), product.getPrice() * order.getAmount(), false));

            return Response.ok("Order posted successfully!").build();
        } catch (ServiceException ex) {
            throw new CsikiDeliveryApiException(ex.getMessage(), ex);
        }
    }
}

