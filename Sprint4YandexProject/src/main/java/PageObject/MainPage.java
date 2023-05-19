package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage {
    public MainPage(WebDriver driver) {
        this.driver = driver;
    }
    private WebDriver driver;

    // Локатор кнопки "Да все привыкли
    private By cookieButton = By.id("rcc-confirm-button");

    // Локатор кнопки "Заказать" в хедере
    private By headerOrderButton = By.className("Button_Button__ra12g");

    // Локатор кнопки "Заказать" в центре страницы
    private By middleOrderButton = By.className("Button_Middle__1CSJM");

    //Локатор последнего элемента страницы

    private By lastDropdownQuestions = By.id("accordion__heading-7");



    // Методы главной страницы

    // Клик по кнопке "Да все привыкли"

    public MainPage clickCookieButton() {

        driver.findElement(cookieButton).click();
        return this;

    }

    // Клик по кнопке заказать в хедере

    public MainPage clickHeaderOrderButton(By orderButton) {

        driver.findElement(headerOrderButton).click();

        return this;
    }

    //Клик по кнопке заказать в центре страницы

    public MainPage clickMiddleOrderButton() {

        driver.findElement(middleOrderButton).click();

        return this;
    }

    public final MainPage openSite() {
        driver.get("https://qa-scooter.praktikum-services.ru/");
        return this;
    }
    // Клик по кнопке вопроса
    public MainPage clickQuestionButton(String questionButtonLocator) {
        new WebDriverWait(driver, 5)
                .until(ExpectedConditions.elementToBeClickable(By.id(questionButtonLocator)));
        driver.findElement(By.id(questionButtonLocator)).click();
        return this;
    }
}
