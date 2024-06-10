package com.fintrack.project.config;


import com.fintrack.project.expense.Expense;
import com.fintrack.project.user.User;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.http.HttpMethod;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

@Configuration
public class MyDataRestConfig implements RepositoryRestConfigurer {

    private String theAllowOrgins =  "http://localhost:3000";

    @Override
    public void configureRepositoryRestConfiguration (RepositoryRestConfiguration config,
                                                      CorsRegistry cors) {

        /* Http methods we want to disable stored in an array <HttpMethod> enum  */
        HttpMethod [] theUnsupportedMethods = {HttpMethod.POST,
                HttpMethod.PATCH,
                HttpMethod.DELETE,
                HttpMethod.PUT };

        config.exposeIdsFor(Expense.class, User.class);

        /* Disabling http methods by class */

        disableHttpMethods(Expense.class, config, theUnsupportedMethods);
        disableHttpMethods(User.class, config, theUnsupportedMethods);

        /* Configure CORS Mapping  */
        // The reason you need to add the "/**" to your cors.addMapping() is that this adds  the method to any path that has the endpoint stored in the allowOrgins variable

        cors.addMapping(config.getBasePath() + "/**")
                .allowedOrigins(theAllowOrgins);

    }

    private void disableHttpMethods(Class theClass,
                                    RepositoryRestConfiguration config,
                                    HttpMethod [] unSupportedActions) {
        config.getExposureConfiguration()
                .forDomainType(theClass)
                .withItemExposure((metdata, httpMethods) ->
                        httpMethods.disable(unSupportedActions))
                .withCollectionExposure((metdata, httpMethods) ->
                        httpMethods.disable(unSupportedActions));

    }


}
