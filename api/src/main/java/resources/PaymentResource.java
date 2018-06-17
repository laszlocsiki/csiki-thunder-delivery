package resources;

import assambler.PaymentAssembler;
import dto.PaymentDTO;
import exception.CsikiDeliveryApiException;
import model.Payment;
import service.AuthenticationService;
import service.PaymentService;
import service.ServiceException;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.stream.Collectors;

@Stateless
@Path(value = "/payment")
@Produces(MediaType.APPLICATION_JSON)
public class PaymentResource {

    @EJB
    private PaymentService paymentService;

    @EJB
    private PaymentAssembler paymentAssembler;

    @EJB
    private AuthenticationService authService;

    @GET
    public Response getPaymentList(@Context HttpServletRequest request) throws CsikiDeliveryApiException {
        try {
            List<Payment> payments = paymentService.findAllPayment();
            List<PaymentDTO> paymentDTOS = payments.stream().map(p -> paymentAssembler.modelToDto(p)).collect(Collectors.toList());
            return Response.ok(paymentDTOS).build();
        } catch (ServiceException ex) {
            throw new CsikiDeliveryApiException(ex.getMessage(), ex);
        }
    }

    @GET
    @Path("/{paymentId}")
    public Response getOrder(@PathParam("paymentId") long id, @Context HttpServletRequest request) throws CsikiDeliveryApiException {
        try {
            Payment payment = paymentService.findById(id);
            PaymentDTO paymentDTO = paymentAssembler.modelToDto(payment);
            return Response.ok(paymentDTO).build();
        } catch (ServiceException ex) {
            throw new CsikiDeliveryApiException(ex.getMessage(), ex);
        }
    }
}

