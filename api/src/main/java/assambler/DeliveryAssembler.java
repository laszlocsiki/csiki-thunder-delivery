package assambler;

import dto.DeliveryDTO;
import exception.CsikiDeliveryApiException;
import model.Delivery;

import javax.ejb.Stateless;

@Stateless
public class DeliveryAssembler extends EntityAssembler<Delivery, DeliveryDTO> {

    @Override
    public DeliveryDTO createDto() {
        return new DeliveryDTO();
    }

    @Override
    public Delivery createModel() {
        return new Delivery();
    }

    @Override
    public DeliveryDTO modelToDto(Delivery model) throws CsikiDeliveryApiException {
        final DeliveryDTO deliveryDTO = createDto();
        deliveryDTO.setId(model.getId());
        deliveryDTO.setOrderId(model.getOrderId());
        deliveryDTO.setStatus(model.getStatus());
        deliveryDTO.setUserid(model.getUserid());
        deliveryDTO.setDeliveryDate(model.getDeliveryDate());
        deliveryDTO.setPaymentId(model.getPaymentId());
        return deliveryDTO;
    }

    @Override
    public Delivery dtoToModel(DeliveryDTO dto) throws CsikiDeliveryApiException {
        final Delivery delivery = createModel();
        delivery.setId(dto.getId());
        delivery.setDeliveryDate(dto.getDeliveryDate());
        delivery.setOrderId(dto.getOrderId());
        delivery.setStatus(dto.getStatus());
        delivery.setUserid(dto.getUserid());
        delivery.setPaymentId(dto.getPaymentId());
        return delivery;
    }

}
