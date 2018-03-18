package com.plivo.assignment.services;

import com.plivo.assignment.models.UserContactDetails;
import com.plivo.assignment.request.UserRequest;
import com.plivo.assignment.response.SearchContactResponse;

public interface UserContactService{

    long insertContact(UserRequest request);

    void deleteContact(UserRequest request) throws Exception;

    void updateContact(UserRequest request) throws Exception;

    UserContactDetails searchByEmail(String email);

    SearchContactResponse searchByName(String name, Integer page);
}
