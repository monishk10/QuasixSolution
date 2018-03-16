package com.monish.db;

import com.monish.data.Person;

import java.util.HashMap;
import java.util.Map;

public class PersonDB {
    // Mapping data
    private static Map<Integer, Person> persons = new HashMap<Integer, Person>();

    static {
        persons.put(1, new Person(1, "Rob", "Palmer", "robpalmer@email.com"));
        persons.put(2, new Person(2, "Gary", "D'souza", "gary@email.com"));
        persons.put(3, new Person(3, "James", "Lambton", "lambton.james@email.com"));
        persons.put(4, new Person(4, "Kris", "Jenner", "kris.j@email.com"));
    }

    // Get details of individual data
    public static String getById(int id) {
        // If the PERSON with the given ID exists then
        if(persons.get(id) != null) {
            Person person = persons.get(id);
            // Display the details
            String result = person.getId() + ". First Name: " + person.getFirstName() + " | Last Name: " + person.getLastName() + " | Email: " + person.getEmail();
            return result;
        } else {
            // if PERSON not found then display error
            return "ERROR: Person not found";
        }
    }

    // Get details of all data
    public static String getAll() {
        String result="";
        // If no PERSON in DB
        if(getCount()<1){
            result = "No Person in DB";
        } else {
            // else loop through the values
            for (Integer key : persons.keySet()) {
                Person person = persons.get(key);
                result += person.getId() + ". First Name: " + person.getFirstName() + " | Last Name: " + person.getLastName() + " | Email: " + person.getEmail() + "\n";
            }
        }
        //return the result string
        return result;
    }

    //Determine the Array size
    public static int getCount() {
        return persons.size();
    }

    // Remove a particular PERSON data
    public static String removeByID(int id) {
        if(persons.get(id) != null) {
            persons.remove(id);
            return "Person removed. Person(s) left: " + getCount();
        }
        return "ERROR: Person not found";
    }

    // Add person to DB
    public static String save(Person person) {
        // Initialize empty String
        String result = "";
        // If PERSON with the given ID found
        if (persons.get(person.getId()) != null) {
            // UPDATE the data
            result = "Updated Person with id=" + person.getId() + "\n";
            result += "Updated Person: " + person.getFirstName() + " " + person.getLastName() + " " + person.getEmail();
        } else {
            // else ADD the data
            result = "Added Person with id=" + person.getId() + "\n";
            result += "Added Person: " + person.getFirstName() + " " + person.getLastName() + " " + person.getEmail();
        }
        // PUSH to the DB
        persons.put(person.getId(), person);
        return result;
    }
}
