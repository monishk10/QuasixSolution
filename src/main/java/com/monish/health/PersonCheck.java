package com.monish.health;

import com.codahale.metrics.health.HealthCheck;
import com.monish.db.PersonDB;

public class PersonCheck extends HealthCheck {
    private final String version;

    public PersonCheck(String version) {
        this.version = version;
    }

    @Override
    protected Result check() throws Exception {
        // If no data in DB, health="false"
        if (PersonDB.getCount() == 0) {
            return Result.unhealthy("No persons in DB! Version: " + this.version);
        }
        // else health="true"
        return Result.healthy("OK with version: " + this.version + ". Persons count: " + PersonDB.getCount());
    }
}
