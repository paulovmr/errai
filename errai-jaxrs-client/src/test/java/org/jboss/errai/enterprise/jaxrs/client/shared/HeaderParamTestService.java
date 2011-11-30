package org.jboss.errai.enterprise.jaxrs.client.shared;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.HEAD;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;

/**
 * This service is used to test support for header parameters (@HeaderParam).
 * 
 * @author Christian Sadilek <csadilek@redhat.com>
 */
@Path("/test/headerparam")
public interface HeaderParamTestService {

  @GET
  @Path("/1")
  public String getWithHeaderParam(@HeaderParam("header") String header);

  @GET 
  @Path("/2")
  public String getWithMultipleHeaderParams(@HeaderParam("header1") String header1, 
      @HeaderParam("header2") String header2);

  @POST
  public String postWithHeaderParam(@HeaderParam("header") String header);

  @PUT
  public String putWithHeaderParam(@HeaderParam("header") String header);

  @DELETE
  public String deleteWithHeaderParam(@HeaderParam("header") String header);
  
  @HEAD
  public void headWithHeaderParam(@HeaderParam("header") String header);
}
