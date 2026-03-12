package io.github.tahanima.util;

import io.github.tahanima.testdata.BaseTestData;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.lang.annotation.*;

/**
 * @author tahanima
 */
@Documented
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@ArgumentsSource(TestArgumentsProvider.class)
@ParameterizedTest
public @interface TestDataSource {

    String id();

    String file();

    Class<? extends BaseTestData> clazz();
}
