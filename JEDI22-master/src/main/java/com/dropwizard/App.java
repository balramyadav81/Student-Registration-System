package com.dropwizard;

import io.dropwizard.Application;
import io.dropwizard.Configuration;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
 
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.flipkart.restController.CourseRestAPI;
import com.flipkart.restController.EndRegistrationRestAPI;
import com.flipkart.restController.ProfessorRestAPI;
import com.flipkart.restController.StudentRestAPI;
import com.flipkart.restController.UserRestAPI;


public class App extends Application<Configuration> {
    private static final Logger LOGGER = LoggerFactory.getLogger(App.class);
 
    @Override
    public void initialize(Bootstrap<Configuration> b) {
    }
 
    @Override
    public void run(Configuration c, Environment e) throws Exception {
        LOGGER.info("Registering REST resources");
       
        //registering all the RESTful service classes.
        e.jersey().register(new CourseRestAPI());        
        e.jersey().register(new EndRegistrationRestAPI() );        
        e.jersey().register(new ProfessorRestAPI());
        e.jersey().register(new StudentRestAPI());
        e.jersey().register(new UserRestAPI());
    }
 
    public static void main(String[] args) throws Exception {
        new App().run(args);
    }
}