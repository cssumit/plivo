package com.plivo.assignment.services.impl;

import com.plivo.assignment.models.UserContactDetails;
import com.plivo.assignment.repositories.UserContactDetailsRepository;
import com.plivo.assignment.request.UserRequest;
import com.plivo.assignment.services.UserContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserContactServiceImpl implements UserContactService {

    @Autowired
    private UserContactDetailsRepository userContactDetailsRepository;

    @Override
    public long insertContact(UserRequest userRequest) {
        UserContactDetails userContactDetails = new UserContactDetails(userRequest);
        userContactDetailsRepository.save(userContactDetails);
        return userContactDetails.getId();
    }

    @Override
    public void deleteContact(UserRequest request) throws Exception{
        UserContactDetails userContactDetails = userContactDetailsRepository.findByEmail(request.getEmail());
        if(userContactDetails!=null){
            userContactDetailsRepository.delete(userContactDetails);
            return;
        }
        throw new IllegalArgumentException("Email "+request.getEmail()+" is not found!");
    }

    @Override
    public void updateContact(UserRequest request) throws Exception {
        UserContactDetails userContactDetails = userContactDetailsRepository.findByEmail(request.getEmail());
        if(userContactDetails!=null){
            userContactDetails.update(request);
            userContactDetailsRepository.save(userContactDetails);
            return;
        }
        throw new IllegalArgumentException("Email "+request.getEmail()+" is not found!");
    }
}
