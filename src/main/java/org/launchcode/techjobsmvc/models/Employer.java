package org.launchcode.techjobsmvc.models;

import java.util.ArrayList;
import java.util.List;

public class Employer extends JobField {

    private List<Job> jobs = new ArrayList<>();

    public Employer(String value) {
        super(value);
    }


}

