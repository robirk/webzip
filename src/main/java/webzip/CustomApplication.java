package webzip;

import org.glassfish.jersey.server.ResourceConfig;

/**
 *
 * @author Robert.Birkenheuer
 */
public class CustomApplication extends ResourceConfig
{
    public CustomApplication()
    {
        packages("webzip.resources");
 
        //Register Auth Filter here
        register(AuthenticationFilter.class);
        //register(WebzipResponseFilter.class);
    }
}
