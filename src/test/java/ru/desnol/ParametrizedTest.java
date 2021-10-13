package ru.desnol;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import ru.desnol.Page.AsosPage;
import ru.desnol.domain.domain;

import java.util.stream.Stream;

@DisplayName("JUnit5 Example")

public class ParametrizedTest extends TestBase {

    AsosPage asosPage = new AsosPage();

    @ValueSource(strings = {
            "свитшот",
            "свитер",
            "худи"
    })
    @ParameterizedTest(name = "Search with ValueSource: {0}")
    void searchByValueSource(String value) {
        asosPage.openPage();
        asosPage.searchValue(value);
        asosPage.checkResult(value);
    }

    @CsvSource(value = {
            "свитшот; мужской",
            "свитер; женский",
            "худи; женский"
    }, delimiter = ';')
    @ParameterizedTest(name = "Search with CsvSource: {0}, {1}")
    void searchByCsvSource(String item, String property) {
        asosPage.openPage();
        asosPage.searchValue(item + " " + property);
        asosPage.checkResult(item);
    }

    @EnumSource(domain.ItemsForSearch.class)
    @ParameterizedTest(name = "search with EnumSource: {0}")
    void searchByEnumSource(domain.ItemsForSearch items) {
        asosPage.openPage();
        asosPage.searchValue(items.getDescription());
        asosPage.checkResult(items.getDescription());
    }
    static Stream<String> stringProvider() {
        return Stream.of("свитшот женский", "свитер мужской", "худи детский");
    }

    @MethodSource("stringProvider")
    @ParameterizedTest(name = "search with MethodSource: {0}")
    void searchByMethodSource(String s) {
        asosPage.openPage();
        asosPage.searchValue(s);
        asosPage.checkResult(s);
    }
}