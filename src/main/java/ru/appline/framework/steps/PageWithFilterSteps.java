package ru.appline.framework.steps;

import io.cucumber.java.ru.И;
import ru.appline.framework.managers.PageManager;

public class PageWithFilterSteps {

    private final PageManager pageManager = PageManager.getPageManager();

    @И("^Заполняем параметр цены \"min\" значением \"(.+)\"$")
    public void fillPriceMinInput(String minPrice) {
        pageManager.getPageWithFilter().fillPriceMinInput(minPrice);
    }

    @И("^Заполняем поле Производитель значением \"(.+)\"$")
    public void fillManufacturerField(String manufacturer) {
        pageManager.getPageWithFilter().fillManufacturerField(manufacturer);
    }
}
