package ru.appline.framework.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Класс описывающий страницу с фильтром
 */
public class PageWithFilter extends BasePage {
    private static final String SEARCH_FIELD_XPATH = "//*[text()='%s']/ancestor::section//input[@placeholder='Поиск']";
    private static final String SELECT_FOUND_XPATH = "//*[contains(@class,'Checkbox_label')]//*[text()='%s']/../../input[@type='checkbox']";

    @FindBy(xpath = "//*[contains(@class, 'RangeSelector_inputs')]//input[@name='min']")
    private WebElement priceMinInputField;

    /**
     * Заполнить параметр цены "min"
     *
     * @return PageWithFilter
     */
    @Step("Заполнить параметр цены \"min\" значением {0}")
    public PageWithFilter fillPriceMinInput(String minPrice) {
        fillInputField(priceMinInputField, minPrice);
        return this;
    }

    /**
     * Заполнить поле "Производитель", дождаться выполнения поиска
     *
     * @return PageWithFilter
     */
    @Step("Заполнить поле \"Производитель\" значением {0}, дождаться выполнения поиска")
    public ProductPage fillManufacturerField(String manufacturer) {
        WebElement searchInputField = driver.findElement(By.xpath(String.format(SEARCH_FIELD_XPATH, "Производитель")));
        fillInputField(searchInputField, manufacturer);
        WebElement selectFoundCheckbox = driver.findElement(By.xpath(String.format(SELECT_FOUND_XPATH, manufacturer)));
        setCheckboxInState(selectFoundCheckbox, true);
        return pageManager.getProductPage();
    }
}
