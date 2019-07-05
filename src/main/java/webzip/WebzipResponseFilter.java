/*
 * https://www.javacodegeeks.com/2014/10/java-ee-7-jax-rs-2-0-simple-rest-api-authentication-authorization-with-custom-http-header.html
 */
package webzip;

import java.io.IOException;
import java.util.logging.Logger;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.container.PreMatching;
import javax.ws.rs.ext.Provider;
  
@Provider
@PreMatching
public class WebzipResponseFilter implements ContainerResponseFilter {
  
    private final static Logger log = Logger.getLogger( WebzipResponseFilter.class.getName() );
  
    @Override
    public void filter( ContainerRequestContext requestCtx, ContainerResponseContext responseCtx ) throws IOException {
  
        log.info( "Filtering REST Response" );
  
        responseCtx.getHeaders().add( "Access-Control-Allow-Origin", "*" );    // You may further limit certain client IPs with Access-Control-Allow-Origin instead of '*'
        responseCtx.getHeaders().add( "Access-Control-Allow-Credentials", "true" );
        responseCtx.getHeaders().add( "Access-Control-Allow-Methods", "GET, POST, DELETE, PUT" );
        responseCtx.getHeaders().add( "Access-Control-Allow-Headers", HTTPHeaderNames.SERVICE_KEY + ", " + HTTPHeaderNames.AUTH_TOKEN );
    }
}