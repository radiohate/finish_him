package ru.appline.framework.managers;

import ru.appline.framework.pages.HomePage;
import ru.appline.framework.pages.PageWithFilter;
import ru.appline.framework.pages.ProductPage;

/**
 * Класс для управления страничками
 */
public class PageManager {

    /**
     * Менеджер страничек
     */
    private static PageManager pageManager;

    /**
     * Стартовая страничка
     */
    private HomePage homePage;

    /**
     * Страничка страхование путешественников
     */
    private PageWithFilter pageWithFilter;

    /**
     * Страничка выбора полиса или тарифа
     */
    private ProductPage productPage;

    /**
     * Конструктор специально был объявлен как private (singleton паттерн)
     *
     * @see PageManager#getPageManager()
     */
    private PageManager() {
    }

    /**
     * Ленивая инициализация PageManager
     *
     * @return PageManager
     */
    public static PageManager getPageManager() {
        if (pageManager == null) {
            pageManager = new PageManager();
        }
        return pageManager;
    }

    /**
     * Ленивая инициализация {@link HomePage}
     *
     * @return HomePage
     */
    public HomePage getHomePage() {
        if (homePage == null) {
            homePage = new HomePage();
        }
        return homePage;
    }

    /**
     * Ленивая инициализация {@link PageWithFilter}
     *
     * @return PageWithFilter
     */
    public PageWithFilter getPageWithFilter() {
        if (pageWithFilter == null) {
            pageWithFilter = new PageWithFilter();
        }
        return pageWithFilter;
    }

    /**
     * Ленивая инициализация {@link ProductPage}
     *
     * @return ProductPage
     */
    public ProductPage getProductPage() {
        if (productPage == null) {
            productPage = new ProductPage();
        }
        return productPage;
    }
}
