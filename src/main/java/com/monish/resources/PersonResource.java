package com.monish.resources;

import com.codahale.metrics.annotation.Timed;
import com.monish.data.Person;
import com.monish.db.PersonDB;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/person")
public class PersonResource {
    public PersonResource() {
    }


    //Get all data
    @GET
    @Timed
    @Path("/all")
    @Produces(MediaType.APPLICATION_JSON)
    public String getPersons() {
        return PersonDB.getAll();
    }

    // Get particular data
    @GET
    @Timed
    @Path("/get/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public String getPerson(@PathParam("id") int id) {
        return PersonDB.getById(id);
    }

    //Add data
    @POST
    @Timed
    @Path("/save")
    @Produces(MediaType.TEXT_PLAIN)
    @Consumes({MediaType.APPLICATION_JSON})
    public String addPerson(Person person) {
        return PersonDB.save(person);
    }

    // delete particular data
    @GET
    @Timed
    @Path("/remove/{id}")
    @Produces(MediaType.TEXT_PLAIN)
    public String removePersonByID(@PathParam("id") int id) {
        return PersonDB.removeByID(id);
    }

}
