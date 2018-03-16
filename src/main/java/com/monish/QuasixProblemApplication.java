package com.monish;

import com.monish.health.PersonCheck;
import com.monish.resources.PersonResource;
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class QuasixProblemApplication extends Application<QuasixProblemConfiguration> {

    public static void main(final String[] args) throws Exception {
        new QuasixProblemApplication().run(args);
    }

    @Override
    public String getName() {
        return "QuasixProblem";
    }

    @Override
    public void initialize(final Bootstrap<QuasixProblemConfiguration> bootstrap) {
    }

    @Override
    public void run(final QuasixProblemConfiguration configuration,
                    final Environment environment) {
        environment.jersey().register(new PersonResource());
        environment.healthChecks().register("template", new PersonCheck(configuration.getVersion()));
    }
}
