package com.plivo.assignment.response;

import com.plivo.assignment.enums.ErrorCode;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class UserEntityResponse extends ResponseEntity<ResponseWrapper> {
    public UserEntityResponse(ResponseWrapper body , HttpStatus status) {
        super(body,status);
    }

    public static UserEntityResponse buildSuccessResponse(Object payload) {
        ResponseWrapper responseWrapper = new ResponseWrapper();
        responseWrapper.setHttpCode(200);
        responseWrapper.setPayload(payload);
        responseWrapper.setStatus("Success");
        return new UserEntityResponse(responseWrapper, HttpStatus.OK);
    }

    public static UserEntityResponse buildErrorResponse(ErrorCode errorCode, String message) {
        ResponseWrapper responseWrapper = new ResponseWrapper();
        responseWrapper.setHttpCode(errorCode.getStatusCode());
        responseWrapper.setMessage(message);
        responseWrapper.setStatus(errorCode.getMessage());
        return new UserEntityResponse(responseWrapper, HttpStatus.BAD_REQUEST);
    }

}