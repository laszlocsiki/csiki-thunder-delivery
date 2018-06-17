package exception;

import javax.validation.ConstraintViolationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class CsikiDeliveryApiExceptionMapper implements ExceptionMapper<Exception> {

    @Override
    public Response toResponse(final Exception ex) {

        if (ex instanceof ConstraintViolationException) {
            return Response.status(Response.Status.BAD_REQUEST).entity(ex.getMessage()).build();
        }
        return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(ex.getMessage())
                .build();
    }
}

