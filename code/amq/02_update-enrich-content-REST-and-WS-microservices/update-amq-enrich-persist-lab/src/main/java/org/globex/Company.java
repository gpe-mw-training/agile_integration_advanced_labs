
package org.globex;

import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
    "name",
    "geo",
    "active"
})
public class Company {

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("name")
    private String name;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("geo")
    private String geo;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("active")
    private boolean active;

    /**
     * 
     * (Required)
     * 
     * @return
     *     The name
     */
    @JsonProperty("name")
    public String getName() {
        return name;
    }

    /**
     * 
     * (Required)
     * 
     * @param name
     *     The name
     */
    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 
     * (Required)
     * 
     * @return
     *     The geo
     */
    @JsonProperty("geo")
    public String getGeo() {
        return geo;
    }

    /**
     * 
     * (Required)
     * 
     * @param geo
     *     The geo
     */
    @JsonProperty("geo")
    public void setGeo(String geo) {
        this.geo = geo;
    }

    /**
     * 
     * (Required)
     * 
     * @return
     *     The active
     */
    @JsonProperty("active")
    public boolean isActive() {
        return active;
    }

    /**
     * 
     * (Required)
     * 
     * @param active
     *     The active
     */
    @JsonProperty("active")
    public void setActive(boolean active) {
        this.active = active;
    }

}
