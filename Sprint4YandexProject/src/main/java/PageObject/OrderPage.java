package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class OrderPage {

    private WebDriver driver;

    // Локаторы страницы заказа

    // Поле "Имя"
    private By clientFirstName = By.xpath(".//input[@placeholder='* Имя']");

    // Поле "Фамилия"
    private By clientLastName = By.xpath(".//input[@placeholder='* Фамилия']");

    // Поле "Адрес"
    private By clientAdress = By.xpath(".//input[@placeholder='* Адрес: куда привезти заказ']");

    // Поле "Станция метро"

    private By metroStation = By.xpath(".//input[@placeholder='* Станция метро']");

    // Поле "Телефон"
    private  By сlientPhoneNumber = By.xpath(".//input[@placeholder='* Телефон: на него позвонит курьер']");

    // Кнопка "Далее"
    private  By nextButton = By.xpath(".//button[(@class ='Button_Button__ra12g Button_Middle__1CSJM' and text()='Далее')]");

    public OrderPage(WebDriver driver) {
        this.driver = driver;
    }

    // Методы для работы с элементами страницы заказа

    // Ввод имени клиента
    public OrderPage insertFirstNameClient(String clientFirst) {

        driver.findElement(clientFirstName).sendKeys(clientFirst);

        return this;
    }

    // Ввод фамилии клиента
    public OrderPage insertLastNameClient(String clientLast) {

        driver.findElement(clientLastName).sendKeys(clientLast);

        return this;
    }

    // Ввод адреса доставки
    public OrderPage insertDeliveryAddress(String address) {

        driver.findElement(clientAdress).sendKeys(address);

        return this;
    }

    // Выбор станции метро
    public OrderPage selectMetroStation(String metroStationFromOrder) {

        driver.findElement(metroStation).click();
        driver.findElement(metroStation).sendKeys(metroStationFromOrder);
        driver.findElement(metroStation).sendKeys(Keys.DOWN,Keys.ENTER);

        return this;
    }
    public OrderPage sendClientNumber(String value) {
        driver.findElement(сlientPhoneNumber).sendKeys(value);
        return this;
    }

    // Клик по кнопке "Далее"
    public OrderPage clickNextButton() {

        driver.findElement(nextButton).click();

        return this;
    }
}
