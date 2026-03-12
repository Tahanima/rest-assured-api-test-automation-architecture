package io.github.tahanima.util;

import com.univocity.parsers.csv.CsvParserSettings;
import com.univocity.parsers.csv.CsvRoutines;

import io.github.tahanima.testdata.BaseTestData;

import lombok.extern.slf4j.Slf4j;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

/**
 * @author tahanima
 */
@Slf4j
public final class TestDataCsvLoader {

    private TestDataCsvLoader() {}

    public static Object[] map(Class<? extends BaseTestData> clazz, String file, String id) {
        CsvParserSettings settings = new CsvParserSettings();

        settings.getFormat().setLineSeparator("\n");
        settings.trimValues(false);

        CsvRoutines routines = new CsvRoutines(settings);

        try (Reader reader =
                     new InputStreamReader(new FileInputStream(file), StandardCharsets.UTF_8)) {
            ArrayList<BaseTestData> testData = new ArrayList<>();

            routines.iterate(clazz, reader)
                    .forEach(
                            e -> {
                                if (e.getTestCaseId().equals(id)) {
                                    testData.add(e);
                                }
                            });

            return testData.toArray();
        } catch (IOException e) {
            log.error("Couldn't provide test data.", e);
        }

        throw new NullPointerException();
    }
}
