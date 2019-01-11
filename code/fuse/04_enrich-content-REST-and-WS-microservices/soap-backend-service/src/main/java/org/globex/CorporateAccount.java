package org.globex;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "CorporateAccount")
public class CorporateAccount {

    private Company company;
    private Contact contact;
    private int id;
    private String salesContact;

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSalesContact() {
        return salesContact;
    }

    public void setSalesContact(String salesContact) {
        this.salesContact = salesContact;
    }

}
