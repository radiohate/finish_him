package ru.appline.framework.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Класс описывающий подстраницу с результатами поиска
 */
public class ProductPage extends BasePage {
    private static final String FILTER_TAG_XPATH = "//*[contains(@class,'FilterTags_wrap')]//*[text()='%s']";

    @FindBy(xpath = "//*[@class='rendererWrapper']//*[contains(@class,'Card_listing')]")
    private List<WebElement> searchResultList;

    @FindBy(xpath = "//input[@aria-label='Поиск']")
    private WebElement searchLineInput;

    @FindBy(xpath = "//*[contains(@class,'countSetter__btn')]//*[contains(@class,'countSetter__count')]")
    private WebElement countProductsOnPage;

    @FindBy(xpath = "//*[contains(@class, 'Icons_search')]")
    private WebElement searchIcon;

    public ProductPage() {
    }

    /**
     * Дождаться выполнения поиска
     *
     * @param requestString строка, по которой выполняем поиск
     * @return ProductPage
     */
    @Step("Дождаться выполнения поиска по запросу <{0}>")
    public ProductPage waitSearchResult(String requestString) {
        WebElement filterTag = driver.findElement(By.xpath(String.format(FILTER_TAG_XPATH, requestString)));
        waitUtilElementToBeVisible(filterTag);
        return this;
    }
    
    /**
     * Проверить, что в поисковой выдаче не более 24 товаров 
     * (значение из выпадающего списка "Товаров на странице" внизу страницы)
     *
     * @return SearchResultPage
     */
    @Step("Проверить, что в поисковой выдаче не более указанного внизу страницы товаров")
    public ProductPage checkSearchResultCountLess() {
        int expectedCount = Integer.parseInt(countProductsOnPage.getText().replaceAll("[^0-9]", ""));
        checkSearchResultCountLess(expectedCount);
        return this;
    }

    /**
     * Проверить, что в поисковой выдаче не более ожадмемого количества товаров
     *
     * @param expectedCount ожидаемое количество
     * @return SearchResultPage
     */
    @Step("Проверить, что в поисковой выдаче не более {0} товаров")
    public ProductPage checkSearchResultCountLess(int expectedCount) {
        int actualCount = searchResultList.size();
        assertTrue(String.format("Должно отображаться меньше %s товаров. По факту отображается %s товаров", expectedCount, actualCount),
                actualCount <= expectedCount);
        return this;
    }

    /**
     * Сохранить наименование первого товара в списке
     *
     * @return SearchResultPage
     */
    @Step("Сохранить наименование первого товара в списке")
    public String readFirstResultProductName() {
        WebElement firstResult = searchResultList.get(0);
        return firstResult.getAttribute("title");
    }

    /**
     * В поисковую строку ввести нужное значение, выполнить поиск
     *
     * @param value нужное значение
     * @return SearchResultPage
     */
    @Step("В поисковую строку ввести нужное значение, выполнить поиск")
    public ProductPage performSearch(String value) {
        fillInputField(searchLineInput, value);
        waitUtilElementToBeClickable(searchIcon).click();
        return this;
    }

    /**
     * Проверить, что в поисковой выдаче ровно ожадмемое количество товаров
     *
     * @param expectedCount ожидаемое количество
     * @return SearchResultPage
     */
//    @Step("Проверить, что в поисковой выдаче ровно {0} товаров")
//    public ProductPage checkSearchResultCountEquals(int expectedCount) {
//        int actualCount = searchResultList.size();
//        assertEquals(String.format("Должно отображаться ровно %s товаров", expectedCount), expectedCount, actualCount);
//        return this;
//    }

    /**
     * Проверить, что наименование товара соответствует сохраненному значению
     *
     * @param expectedValue ожидаемое значение
     * @return SearchResultPage
     */
    @Step("Проверить, что наименование товара соответствует значению {0}")
    public ProductPage checkSearchResultValue(String expectedValue) {
        WebElement singleResult = searchResultList.get(0);
        assertEquals("Наименование товара НЕ соответствует сохраненному значению!",
                expectedValue,
                singleResult.getText());
        return this;
    }
}
