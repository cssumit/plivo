package com.plivo.assignment.models;

import com.plivo.assignment.request.UserRequest;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name="user_contact_details")
public class UserContactDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    private String email;

    private long mobile;

    private int status;

    public UserContactDetails(UserRequest userRequest){
        this.email = userRequest.getEmail();
        this.mobile = userRequest.getMobile();
        this.name = userRequest.getName();
    }

    public UserContactDetails(){

    }

    public void update(UserRequest request) {
        if(request.getMobile()>0){
            this.mobile = request.getMobile();
        }
        if(request.getName()!=null){
            this.name = request.getName();
        }
    }
}
