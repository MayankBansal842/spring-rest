package com.example.rest.webservices.restful_web_services.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonV1Controller {
    @GetMapping("/v1/person")
    public PersonV1 getPersonV1() {
        return new PersonV1("Bob Marley");
    }

    @GetMapping("/v2/person")
    public PersonV2 getPersonV2() {
        return new PersonV2(new Name("Bob", "Marley"));
    }

    @GetMapping(value = "/person", params = "version=1")
    public PersonV1 getPersonV1Params() {
        return new PersonV1("Bob Marley");
    }

    @GetMapping(value = "/person", params = "version=2")
    public PersonV2 getPersonV2Params() {
        return new PersonV2(new Name("Bob", "Marley"));
    }

    @GetMapping(value = "/person/header", headers = "X-API-VERSION=1")
    public PersonV1 getPersonV1Header() {
        return new PersonV1("Bob Marley");
    }

    @GetMapping(value = "/person/header", headers = "X-API-VERSION=2")
    public PersonV2 getPersonV2Header() {
        return new PersonV2(new Name("Bob", "Marley"));
    }

//    @GetMapping(value = "/person/accept", produces = "application/vnd/company.app-v1+json")
//    public PersonV1 getPersonV1AcceptHeader() {
//        return new PersonV1("Bob Marley");
//    }
//
//    @GetMapping(value = "/person/accept", produces = "application/vnd/company.app-v2+json")
//    public PersonV2 getPersonV2AcceptHeader() {
//        return new PersonV2(new Name("Bob", "Marley"));
//    }
}
