
package org.globex;

import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
    "company",
    "contact"
})
public class Account {

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("company")
    private Company company;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("contact")
    private Contact contact;

    /**
     * 
     * (Required)
     * 
     * @return
     *     The company
     */
    @JsonProperty("company")
    public Company getCompany() {
        return company;
    }

    /**
     * 
     * (Required)
     * 
     * @param company
     *     The company
     */
    @JsonProperty("company")
    public void setCompany(Company company) {
        this.company = company;
    }

    /**
     * 
     * (Required)
     * 
     * @return
     *     The contact
     */
    @JsonProperty("contact")
    public Contact getContact() {
        return contact;
    }

    /**
     * 
     * (Required)
     * 
     * @param contact
     *     The contact
     */
    @JsonProperty("contact")
    public void setContact(Contact contact) {
        this.contact = contact;
    }

}
