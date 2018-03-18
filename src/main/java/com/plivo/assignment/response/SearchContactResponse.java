package com.plivo.assignment.response;

import com.plivo.assignment.models.UserContactDetails;
import lombok.Data;

import java.util.List;

@Data
public class SearchContactResponse {

    private long perPage;

    private long currentPage;

    private long total;

    private List<UserContactDetails> userContactDetailsList;

}
