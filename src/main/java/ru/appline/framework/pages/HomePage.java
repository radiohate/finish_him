package ru.appline.framework.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.util.List;

/**
 * Стартовая страница приложения
 */
public class HomePage extends BasePage {
    final static String BASE_MENU_ITEM_XPATH = "//li[contains(@class, 'Catalog_mainCategory')]//*[text()='%s']";
    final static String SUB_MENU_ITEM_XPATH = "//*[contains(@class, 'Category_container__ZBIIA')]//*[text()='%s']";
    final static String HEADER = "//h1[text()='%s']";

    @FindBy(xpath = "//button/*[text()='Каталог']")
    private WebElement catalogButton;

    @FindBy(xpath = "//li[contains(@class, 'Catalog_mainCategory')]//*[text()='Комплектующие для ПК']")
    private List<WebElement> listBaseMenu;

    @FindBy(xpath = "//a[@data-cga_click_top_menu]")
    private List<WebElement> listSubMenu;

    /**
     * Открыть меню "Каталог"
     *
     * @return HomePage
     */
    public HomePage openCatalogMenu() {
        waitUtilElementToBeClickable(catalogButton).click();
        return this;
    }

    /**
     * Функция наведения мыши на любой пункт меню
     *
     * @param nameBaseMenu наименование меню
     * @return HomePage
     */
    public HomePage selectBaseMenu(String nameBaseMenu) {
        // Комплектующие для ПК, Периферия
        WebElement menuItem = driver.findElement(By.xpath(String.format(BASE_MENU_ITEM_XPATH, nameBaseMenu)));
        waitUtilElementToBeClickable(menuItem).click();
        return this;
    }

    /**
     * Функция открытия подменю второго порядка
     *
     * @param nameSubMenu наименование подменю
     * @return PageWithFilter
     */
    public PageWithFilter selectSubMenu(String nameSubMenu) {
        // Видеокарты Клавиатуры
        WebElement menuItem = driver.findElement(By.xpath(String.format(SUB_MENU_ITEM_XPATH, nameSubMenu)));
        waitUtilElementToBeClickable(menuItem).click();
        waitUtilElementToBeVisible(driver.findElement(By.xpath(String.format(HEADER, nameSubMenu))));
        return pageManager.getPageWithFilter();
    }
}
