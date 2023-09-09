package io.github.tahanima.config;

import org.aeonbits.owner.Config;
import org.aeonbits.owner.Config.LoadPolicy;
import org.aeonbits.owner.Config.LoadType;
import org.aeonbits.owner.Config.Sources;

/**
 * @author tahanima
 */
@LoadPolicy(LoadType.MERGE)
@Sources({"system:properties", "classpath:allure.properties", "classpath:config.properties"})
public interface Configuration extends Config {

    @Key("allure.results.directory")
    String allureResultsDir();

    @Key("api.base.path")
    String apiBasePath();

    @Key("api.base.uri")
    String apiBaseUri();
    
    @Key("test.data.base.path")
    String testDataBasePath();
}
