package resources;

import assambler.DeliveryAssembler;
import dto.DeliveryDTO;
import exception.CsikiDeliveryApiException;
import model.Delivery;
import service.AuthenticationService;
import service.DeliveryService;
import service.PaymentService;
import service.ServiceException;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Stateless
@Path(value = "/delivery")
@Produces(MediaType.APPLICATION_JSON)
public class DeliveryResource {

    @EJB
    private DeliveryService deliveryService;

    @EJB
    private DeliveryAssembler deliveryAssembler;

    @EJB
    private AuthenticationService authService;

    @EJB
    private PaymentService paymentService;

    @GET
    public Response getDeliveryList(@Context HttpServletRequest request) throws CsikiDeliveryApiException {
        try {
            List<Delivery> deliveries = deliveryService.findAllDelivery();
            List<DeliveryDTO> orderDTOS = deliveries.stream().map(p -> deliveryAssembler.modelToDto(p)).collect(Collectors.toList());
            return Response.ok(orderDTOS).build();
        } catch (ServiceException ex) {
            throw new CsikiDeliveryApiException(ex.getMessage(), ex);
        }
    }

    @GET
    @Path("/{deliveryId}")
    public Response getOrder(@PathParam("deliveryId") long id, @Context HttpServletRequest request) throws CsikiDeliveryApiException {
        try {
            Delivery delivery = deliveryService.findById(id);
            DeliveryDTO deliveryDTO = deliveryAssembler.modelToDto(delivery);
            return Response.ok(deliveryDTO).build();
        } catch (ServiceException ex) {
            throw new CsikiDeliveryApiException(ex.getMessage(), ex);
        }
    }

    @POST
    public Response createDelivery(DeliveryDTO deliveryDTO, @Context HttpServletRequest request) throws CsikiDeliveryApiException {
        try {
            HttpSession session = request.getSession();
            String username = (String) session.getAttribute("username");
            if ((username != null) && (authService.findByUsername(username) != null)) {
                Delivery delivery = deliveryAssembler.dtoToModel(deliveryDTO);
                delivery.setUserid(authService.findByUsername(username).getId());
                delivery.setDeliveryDate(new Date());
                deliveryService.createDelivery(delivery);
                return Response.ok("Delivery posted successfully!").build();
            } else {
                throw new CsikiDeliveryApiException("Please login first!");
            }
        } catch (ServiceException ex) {
            throw new CsikiDeliveryApiException(ex.getMessage(), ex);
        }
    }

    @PUT
    @Path("/{deliveryId}/finish")
    public Response finishDelivery(@PathParam("deliveryId") long id, @Context HttpServletRequest request) throws CsikiDeliveryApiException {
        try {
            HttpSession session = request.getSession();
            String username = (String) session.getAttribute("username");
            if ((username != null) && (authService.findByUsername(username) != null)) {
                Delivery delivery = deliveryService.findById(id);
                delivery.setStatus("delivered");
                delivery.setDeliveryDate(new Date());

                paymentService.findById(delivery.getPaymentId()).setPayed(true);
                return Response.ok("Delivery finished successfully!").build();
            } else {
                throw new CsikiDeliveryApiException("Please login first!");
            }
        } catch (ServiceException ex) {
            throw new CsikiDeliveryApiException(ex.getMessage(), ex);
        }
    }
}

