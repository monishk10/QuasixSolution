package com.monish;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.dropwizard.Configuration;
import org.hibernate.validator.constraints.NotEmpty;

public class QuasixProblemConfiguration extends Configuration {
    @NotEmpty
    private String version;

    @JsonProperty
    public String getVersion() {
        return version;
    }
}
