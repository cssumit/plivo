package com.plivo.assignment.controllers;

import com.plivo.assignment.enums.ErrorCode;
import com.plivo.assignment.models.UserContactDetails;
import com.plivo.assignment.request.UserRequest;
import com.plivo.assignment.response.SearchContactResponse;
import com.plivo.assignment.response.UserEntityResponse;
import com.plivo.assignment.services.UserContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.RequestEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "plivo/v1")
public class UserController {

    @Autowired
    UserContactService userContactService;

    @RequestMapping(value="/insert",method = RequestMethod.PUT)
    public UserEntityResponse insertContact(RequestEntity<UserRequest> requestEntity){
        try{
            long userId = userContactService.insertContact(requestEntity.getBody());
            return UserEntityResponse.buildSuccessResponse(userId);
        }catch(Exception e){
            return UserEntityResponse.buildErrorResponse(ErrorCode.INTERNAL_SERVER_ERROR,e.getMessage());
        }
    }

    @RequestMapping(value="/delete",method = RequestMethod.DELETE)
    public UserEntityResponse deleteContact(RequestEntity<UserRequest> requestRequestEntity){
        try{
            userContactService.deleteContact(requestRequestEntity.getBody());
            return UserEntityResponse.buildSuccessResponse("Successfully Deleted");
        }catch(Exception e){
            return UserEntityResponse.buildErrorResponse(ErrorCode.INTERNAL_SERVER_ERROR,e.getMessage());
        }
    }

    @RequestMapping(value="/update",method = RequestMethod.POST)
    public UserEntityResponse updateContact(RequestEntity<UserRequest> requestEntity){
        try{
            userContactService.updateContact(requestEntity.getBody());
            return UserEntityResponse.buildSuccessResponse("Successfully Updated");
        }catch(Exception e){
            return UserEntityResponse.buildErrorResponse(ErrorCode.INTERNAL_SERVER_ERROR,e.getMessage());
        }
    }


    @RequestMapping(value="/searchByName",method = RequestMethod.GET)
    public UserEntityResponse searchContact(String name,Integer page){
        try{
            SearchContactResponse searchContactResponse = userContactService.searchByName(name,page);
            return UserEntityResponse.buildSuccessResponse(searchContactResponse);
        }catch(Exception e){
            return UserEntityResponse.buildErrorResponse(ErrorCode.INTERNAL_SERVER_ERROR,e.getMessage());
        }
    }

    @RequestMapping(value="/searchByEmail",method = RequestMethod.GET)
    public UserEntityResponse searchContact(String email){
        try{
            UserContactDetails userContactDetails = userContactService.searchByEmail(email);
            return UserEntityResponse.buildSuccessResponse(userContactDetails);
        }catch(Exception e){
            return UserEntityResponse.buildErrorResponse(ErrorCode.INTERNAL_SERVER_ERROR,e.getMessage());
        }
    }
}
