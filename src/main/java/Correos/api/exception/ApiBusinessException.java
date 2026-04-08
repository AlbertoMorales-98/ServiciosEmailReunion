package Correos.api.exception;

import Correos.api.ApiResponse;

public abstract class ApiBusinessException extends RuntimeException {

    private final int status;
    private final String message;

    protected ApiBusinessException(int status, String message) {
        super(String.valueOf(status));
        this.status = status;
        this.message = message;
    }

    protected ApiBusinessException(int status, String message, Throwable cause) {
        super(String.valueOf(status), cause);
        this.status = status;
        this.message = message;
    }

    public int getStatus() {
        return status;
    }

    public ApiResponse toResponse() {
        return new ApiResponse(status, message);
    }
}
