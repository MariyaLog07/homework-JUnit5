package ru.desnol.Page;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class AsosPage  {

    public static final String URL = "https://www.asos.com/ru/";

    private SelenideElement
            logo = $("._24SZgSx"),
            searchInput = $(".Cyuazsm"),
            searchResult = $("#search-term-banner");

    public AsosPage openPage() {
        open(URL);
        logo.shouldBe(visible);
        return this;
    }

    public AsosPage searchValue(String value) {
        searchInput.setValue(value).click();
        searchInput.setValue(value).pressEnter();
        return this;
    }

    public AsosPage checkResult(String s) {
        searchResult.shouldBe(visible);
        searchResult.find(byText(s));
        return this;
    }
}

