package com.haulmont.sample.petclinic.config;

import com.haulmont.cuba.core.config.Config;
import com.haulmont.cuba.core.config.Property;
import com.haulmont.cuba.core.config.Source;
import com.haulmont.cuba.core.config.SourceType;

@Source(type = SourceType.APP)
public interface PetclinicEnvironmentConfig extends Config {

    @Property("petclinic.environment.name")
    String getEnvironmentName();
}