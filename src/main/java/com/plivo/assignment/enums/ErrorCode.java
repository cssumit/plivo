package com.plivo.assignment.enums;

public enum ErrorCode {

    //COMMON ERRORS
    INTERNAL_SERVER_ERROR(500, "Internal Server Error"),
    DATABASE_ERROR (500, "Database Error"),
    BAD_REQUEST(400, "Bad Request"),
    DATA_NOT_FOUND(404, "Data Not Found"),
    UNKNOWN_ERROR(1099, "Unknown error"),
    INVALID_REQUEST(1001, "Invalid request"),
    INVALID_ELASTIC_CONFIG(1002, "Invalid elastic node config"),

    //HTTP REQUEST ERRORS
    JOB_EXECUTION_FAILED(2002, "Failed to execute job"),
    JOB_EXECUTION_CONNECTION_FAILED(2003, "Failed to connect while executing job"),
    URL_SERVICE_NOT_AVAILABLE(2004, "Invalid request url"),

    //External HTTP Requests
    EXTERNAL_URL_SERVICE_FAILED(3001, "Failed to call external url"),

    //Payment error
    PAYMENT_SERVICE_ERROR(4001, "Payment service error");


    private int statusCode;
    private String message;


    private ErrorCode(int statusCode, String message) {
        this.statusCode = statusCode;
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public String toString(){
        return message;
    }
}
