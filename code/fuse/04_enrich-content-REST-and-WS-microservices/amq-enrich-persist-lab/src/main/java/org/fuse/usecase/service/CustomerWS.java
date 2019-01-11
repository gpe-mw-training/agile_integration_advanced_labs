package org.fuse.usecase.service;

import org.globex.Account;
import org.globex.CorporateAccount;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.ws.ResponseWrapper;

@WebService
public interface CustomerWS {

    CorporateAccount updateAccount(Account account);

}
