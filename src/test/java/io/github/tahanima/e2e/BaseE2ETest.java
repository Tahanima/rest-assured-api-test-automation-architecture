package io.github.tahanima.e2e;

import io.github.tahanima.report.AllureManager;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

/**
 * @author tahanima
 */
@TestInstance(Lifecycle.PER_CLASS)
public abstract class BaseE2ETest {

    @BeforeAll
    protected void setupAll() {
        AllureManager.setAllureEnvironmentInfo();
    }
}
