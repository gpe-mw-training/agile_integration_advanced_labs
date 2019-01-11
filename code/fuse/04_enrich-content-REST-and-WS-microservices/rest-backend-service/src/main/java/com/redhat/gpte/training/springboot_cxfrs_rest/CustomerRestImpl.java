package com.redhat.gpte.training.springboot_cxfrs_rest;

import org.globex.Account;
import org.globex.Company;

import io.swagger.annotations.Api;

import java.util.Random;

@Api("/customerservice")
public class CustomerRestImpl implements CustomerRest {

    private static final String NA_REGION = "NORTH_AMERICA";
    private static final String SA_REGION = "SOUTH_AMERICA";
    private static final String WE_REGION = "WEST_AMERICA";
    private static final String EAST_REGION = "EAST_AMERICA";

    @Override public Account enrich(Account account) {
        Company company = account.getCompany();
        String region = company.getGeo();
        switch (region) {
        case "NA":
            company.setGeo(NA_REGION); break;
        case "SA":
            company.setGeo(SA_REGION); break;
        case "WA":
            company.setGeo(WE_REGION); break;
        case "EA":
            company.setGeo(EAST_REGION); break;
        }
        account.setCompany(company);
        return account;
    }
}
