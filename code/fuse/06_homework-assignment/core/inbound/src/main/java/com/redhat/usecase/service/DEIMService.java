package com.redhat.usecase.service;

import javax.ws.rs.core.Response;
import com.customer.app.Person;

public interface DEIMService {
  public Response addPerson(Person person);
}
