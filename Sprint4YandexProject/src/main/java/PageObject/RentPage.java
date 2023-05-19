package PageObject;

import org.hamcrest.MatcherAssert;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import static javax.management.Query.value;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;

public class RentPage {

    private WebDriver driver;

    // Локаторы


    //Локатор поля даты начала аренды
    private By rentalDateField = By.xpath(".//input[@placeholder='* Когда привезти самокат']");

    // Локатор поля срока аренды */

    private  By rentalTimeField = By.className("Dropdown-placeholder");

    // Локатор списка срока аренды

    private  By rentalTime = By.xpath(".//*[(@role ='option' and text()='трое суток')]");

    // Локатор цвета самоката "Черный жемчуг"

    private  By checkBoxColourBlackPearl = By.xpath(".//input[@id='black']");

    // Локатор цвета самоката "Серая безысходность"

    private  By checkBoxColourGreyDespair = By.xpath(".//input[@id='grey']");

    // Локатор поля комментария для курьера

    private  By commentField = By.xpath(".//input[@placeholder='Комментарий для курьера']");

    // Локатор кнопки "Заказать"

    private  By orderButton = By.xpath(".//button[(@class='Button_Button__ra12g Button_Middle__1CSJM' and text()='Заказать')]");

    // Локатор кнопки "Да" оформления заказа

    private  By orderButtonYes = By.xpath(".//*[@id='root']/div/div[2]/div[5]/div[2]/button[2]");

    // Локатор модального окна

    private  By modalOrderWindow = By.className("Order_Modal__YZ-d3");


    //Локатор всплывающего окна "Заказ оформлен"
    private By modalOrderWindowComplete = By.className("Order_ModalHeader__3FDaJ");

    public RentPage(WebDriver driver) {
        this.driver = driver;
    }

    //Методы

    // Ввод даты
    public RentPage sendRentalDate(String date) {
        driver.findElement(rentalDateField).sendKeys(date);
        driver.findElement(rentalDateField).sendKeys(Keys.ENTER);
        return this;
    }
    // Выбор срока аренды
    public RentPage sendRentalPeriod() {
        driver.findElement(rentalTimeField ).click();
        driver.findElement(rentalTime).click();
        return this;
    }
    // Выбор цвета самоката
    public RentPage sendScooterColor() {
        driver.findElement(checkBoxColourGreyDespair).click();
        return this;
    }
    // Комментарий для курьера
    public RentPage commentCourier(String value) {
        driver.findElement(commentField).sendKeys(value);
        return this;
    }
    // Кнопка "Заказать"
    public RentPage clickOrderButton() {
        driver.findElement(orderButton).click();
        return this;
    }
    // Кнопка "Да"
    public RentPage clickModalOrderWindow() {
        driver.findElement(orderButtonYes).click();
        return this;
    }
    // Окно успешного оформления заказа
    public RentPage checkModalOrderWindowComplete() {

        String checkCompleteText = driver.findElement(modalOrderWindowComplete).getText();
        Assert.assertThat(checkCompleteText, containsString("Заказ оформлен"));

        return this;
    }
}
