package com.plivo.assignment.services;

import com.plivo.assignment.request.UserRequest;

public interface UserContactService{

    long insertContact(UserRequest request);

    void deleteContact(UserRequest request) throws Exception;

    void updateContact(UserRequest request) throws Exception;
}
