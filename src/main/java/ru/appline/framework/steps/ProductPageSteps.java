package ru.appline.framework.steps;

import io.cucumber.java.ru.И;
import ru.appline.framework.managers.PageManager;

public class ProductPageSteps {
    // Объявляем поле для хранения значения
    private String savedValue;

    private final PageManager pageManager = PageManager.getPageManager();

    @И("^Дождемся выполнения поиска \"(.+)\"$")
    public void waitSearchResult(String requestString) {
        pageManager.getProductPage().waitSearchResult(requestString);
    }

    @И("^Проверим, что в поисковой выдаче не более указанного внизу страницы товаров$")
    public void checkSearchResultCountLess() {
        pageManager.getProductPage().checkSearchResultCountLess();
    }

    @И("^Проверим, что в поисковой выдаче не более \"(.+)\" товаров$")
    public void checkSearchResultCountLess(int count) {
        pageManager.getProductPage().checkSearchResultCountLess(count);
    }

    @И("^Сохраним наименование первого товара в списке$")
    public void readFirstResultProductName() {
        savedValue = pageManager.getProductPage().readFirstResultProductName();
    }

    @И("^В поисковую строку вводим значение и выполняем поиск товаров$")
    public void performSearch() {
        pageManager.getProductPage().performSearch(savedValue);
    }

    @И("^Проверим, что наименование товара соответствует сохраненному значению$")
    public void checkSearchResultValue() {
        pageManager.getProductPage().checkSearchResultValue(savedValue);
    }
}
