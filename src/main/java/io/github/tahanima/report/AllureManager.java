package io.github.tahanima.report;

import static com.github.automatedowl.tools.AllureEnvironmentWriter.allureEnvironmentWriter;

import static io.github.tahanima.config.ConfigurationManager.config;

import com.google.common.collect.ImmutableMap;

/**
 * @author tahanima
 */
public final class AllureManager {

    private AllureManager() {}

    public static void setAllureEnvironmentInfo() {
        allureEnvironmentWriter(
                ImmutableMap.<String, String>builder()
                        .put("Platform", System.getProperty("os.name"))
                        .put("OS Version", System.getProperty("os.version"))
                        .put("API Base URI", config().apiBaseUri())
                        .put("API Base Path", config().apiBasePath())
                        .build(),
                config().allureResultsDir() + "/");
    }
}
