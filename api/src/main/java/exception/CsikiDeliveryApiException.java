package exception;

public class CsikiDeliveryApiException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public CsikiDeliveryApiException(final String string) {
        super(string);
    }

    public CsikiDeliveryApiException(final String string, final Throwable throwable) {
        super(string, throwable);
    }

}
