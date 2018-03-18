package com.plivo.assignment.services.impl;

import com.plivo.assignment.models.UserContactDetails;
import com.plivo.assignment.repositories.UserContactDetailsRepository;
import com.plivo.assignment.request.UserRequest;
import com.plivo.assignment.response.SearchContactResponse;
import com.plivo.assignment.services.UserContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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

    @Override
    public UserContactDetails searchByEmail(String email) {
        UserContactDetails userContactDetails = userContactDetailsRepository.findByEmail(email);
        if(userContactDetails!=null){
            return userContactDetails;
        }
        throw new IllegalArgumentException("Email "+email+" is not found!");
    }

    @Override
    public SearchContactResponse searchByName(String name, Integer page) {
        SearchContactResponse searchContactResponse = new SearchContactResponse();
        Pageable pageable = createPageRequest(0,10);
        if(page!=null){

            pageable = createPageRequest(page-1,10);
        }
        Page<UserContactDetails> userContactDetailsList = userContactDetailsRepository.findByName(name,pageable);
        searchContactResponse.setUserContactDetailsList(userContactDetailsList.getContent());
        searchContactResponse.setCurrentPage(userContactDetailsList.getPageable().getPageNumber()+1);
        searchContactResponse.setTotal(userContactDetailsList.getTotalElements());
        searchContactResponse.setPerPage(10);

        return searchContactResponse;
    }

    private Pageable createPageRequest(int start,int end) {
        return PageRequest.of(start,end);
    }
}
