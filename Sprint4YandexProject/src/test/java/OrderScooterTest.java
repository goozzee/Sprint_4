import PageObject.MainPage;
import PageObject.OrderPage;
import PageObject.RentPage;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.ParentRunner;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@RunWith(Parameterized.class)
public class OrderScooterTest extends BaseTestConfig {

private final By orderButton;

    public OrderScooterTest(By orderButton) {
        this.orderButton = orderButton;
    }
    // Тестовые данные
    @Parameterized.Parameters
    public static  Object[][] getOrderButton() {
        return new Object[][]{
                new By[]{By.className("Button_Button__ra12g")},
                new By[]{By.className("Button_Middle__1CSJM")}

        };
    }


    // Тест заказа

    @Test
    public void samokatOrderingHeaderButton() {

        new MainPage(driver)
                .openSite()
                .clickHeaderOrderButton(orderButton)
                .clickCookieButton();

        new OrderPage(driver)
                .insertFirstNameClient("Саня")
                .insertLastNameClient("Гузе")
                .insertDeliveryAddress("пр. Ленина")
                .selectMetroStation("Сокольники")
                .sendClientNumber("88005553535")
                .clickNextButton();

        new RentPage(driver)
                .sendRentalDate("16.05.2023")
                .sendRentalPeriod()
                .sendScooterColor()
                .commentСourier("Комментарий")
                .clickOrderButton()
                .clickModalOrderWindow()
                .checkModalOrderWindowComplete();
    }


}
