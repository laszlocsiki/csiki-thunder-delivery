package assambler;

import dto.PaymentDTO;
import exception.CsikiDeliveryApiException;
import model.Payment;

import javax.ejb.Stateless;

@Stateless
public class PaymentAssembler extends EntityAssembler<Payment, PaymentDTO> {

    @Override
    public PaymentDTO createDto() {
        return new PaymentDTO();
    }

    @Override
    public Payment createModel() {
        return new Payment();
    }

    @Override
    public PaymentDTO modelToDto(Payment model) throws CsikiDeliveryApiException {
        final PaymentDTO paymentDTO = createDto();
        paymentDTO.setId(model.getId());
        paymentDTO.setOrderId(model.getOrderId());
        paymentDTO.setPayed(model.isPayed());
        paymentDTO.setPrice(model.getPrice());
        return paymentDTO;
    }

    @Override
    public Payment dtoToModel(PaymentDTO dto) throws CsikiDeliveryApiException {
        final Payment payment = createModel();
        payment.setId(dto.getId());
        payment.setPrice(dto.getPrice());
        payment.setPayed(dto.isPayed());
        payment.setOrderId(dto.getOrderId());
        return payment;
    }

}
