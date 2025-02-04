package ru.appline.framework.steps;

import io.cucumber.java.ru.И;
import ru.appline.framework.managers.PageManager;

public class HomePageSteps {
    private final PageManager pageManager = PageManager.getPageManager();

    @И("^Открыть меню \"Каталог\"$")
    public void openCatalogMenu() {
        pageManager.getHomePage().openCatalogMenu();
    }

    @И("^Выбираем \"(.+)\" в главном меню$")
    public void selectBaseMenu(String nameMenu) {
        pageManager.getHomePage().selectBaseMenu(nameMenu);
    }

    @И("^Выбираем \"(.+)\" в подменю$")
    public void closeCookiesDialog(String nameSubMenu) {
        pageManager.getHomePage().selectSubMenu(nameSubMenu);
    }
}
