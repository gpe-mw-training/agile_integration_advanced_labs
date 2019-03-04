
package org.fuse.usecase.service;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the org.fuse.usecase.service package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _CorporateAccount_QNAME = new QName("http://service.usecase.fuse.org/", "CorporateAccount");
    private final static QName _UpdateAccount_QNAME = new QName("http://service.usecase.fuse.org/", "updateAccount");
    private final static QName _UpdateAccountResponse_QNAME = new QName("http://service.usecase.fuse.org/", "updateAccountResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: org.fuse.usecase.service
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link CorporateAccount }
     * 
     */
    public CorporateAccount createCorporateAccount() {
        return new CorporateAccount();
    }

    /**
     * Create an instance of {@link UpdateAccount }
     * 
     */
    public UpdateAccount createUpdateAccount() {
        return new UpdateAccount();
    }

    /**
     * Create an instance of {@link UpdateAccountResponse }
     * 
     */
    public UpdateAccountResponse createUpdateAccountResponse() {
        return new UpdateAccountResponse();
    }

    /**
     * Create an instance of {@link Account }
     * 
     */
    public Account createAccount() {
        return new Account();
    }

    /**
     * Create an instance of {@link Company }
     * 
     */
    public Company createCompany() {
        return new Company();
    }

    /**
     * Create an instance of {@link Contact }
     * 
     */
    public Contact createContact() {
        return new Contact();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CorporateAccount }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.usecase.fuse.org/", name = "CorporateAccount")
    public JAXBElement<CorporateAccount> createCorporateAccount(CorporateAccount value) {
        return new JAXBElement<CorporateAccount>(_CorporateAccount_QNAME, CorporateAccount.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdateAccount }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.usecase.fuse.org/", name = "updateAccount")
    public JAXBElement<UpdateAccount> createUpdateAccount(UpdateAccount value) {
        return new JAXBElement<UpdateAccount>(_UpdateAccount_QNAME, UpdateAccount.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdateAccountResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.usecase.fuse.org/", name = "updateAccountResponse")
    public JAXBElement<UpdateAccountResponse> createUpdateAccountResponse(UpdateAccountResponse value) {
        return new JAXBElement<UpdateAccountResponse>(_UpdateAccountResponse_QNAME, UpdateAccountResponse.class, null, value);
    }

}
