package com.example.rest.webservices.restful_web_services.versioning;

public class PersonV2 {
    private Name fullName;
    public PersonV2(Name fullName) {
        this.fullName = fullName;
    }
    public Name getFullName() {
        return fullName;
    }
    public void setFullName(Name fullName) {
        this.fullName = fullName;
    }

    @Override
    public String toString() {
        return "Person V2 [fullName=" + fullName + "]";
    }
}
