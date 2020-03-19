package ru.aplana.autotest.steps;

import io.qameta.allure.Step;
import ru.aplana.autotest.pages.MainPage;


public class MainPageSteps extends BaseSteps {

    @Step("Выбрано меню Ипотека")
    public MainPageSteps selectMenu(){
        new MainPage().selectIpotekaItem();
        return this;
    }

    @Step("Выбран пункт меню Ипотека на готовое жильё")
    public MainPageSteps selectItemMenu(){
        new MainPage().selectSubMenu();
        return this;
    }

}
