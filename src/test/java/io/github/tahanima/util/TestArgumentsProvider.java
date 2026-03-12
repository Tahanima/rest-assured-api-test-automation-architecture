package io.github.tahanima.util;

import static io.github.tahanima.config.ConfigurationManager.config;

import io.github.tahanima.testdata.BaseTestData;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.support.AnnotationConsumer;

import java.util.stream.Stream;

/**
 * @author tahanima
 */
public class TestArgumentsProvider implements ArgumentsProvider, AnnotationConsumer<TestDataSource> {

    private String id;
    private String file;
    private Class<? extends BaseTestData> clazz;

    @Override
    public void accept(TestDataSource source) {
        id = source.id();
        file = config().testDataBasePath() + source.file();
        clazz = source.clazz();
    }

    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
        return Stream.of(TestDataCsvLoader.map(clazz, file, id)).map(Arguments::of);
    }
}
