package assambler;

import dto.AbstractDTO;
import exception.CsikiDeliveryApiException;

import javax.ejb.Local;

@Local
public interface Assembler<M, D extends AbstractDTO> {

    D createDto();

    M createModel();

    D modelToDto(M model) throws CsikiDeliveryApiException;

    M dtoToModel(D dto) throws CsikiDeliveryApiException;
}
