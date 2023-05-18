import PageObject.MainPage;
import PageObject.OrderPage;
import PageObject.RentPage;
import org.junit.Test;

public class OrderScooterTest extends BaseTestConfig {

    // Тест заказа через кнопку в хедере

    @Test
    public void samokatOrderingHeaderButton() {

        new MainPage(driver)
                .openSite()
                .clickHeaderOrderButton()
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

    // Тест заказа через кнопку в центре страницы

    @Test
    public void samokatOrderingPageButton() {
        new MainPage(driver)
                .openSite()
                .clickCookieButton()
                .clickMiddleOrderButton();

        new OrderPage(driver)
                .insertFirstNameClient("Евлампий")
                .insertLastNameClient("Ершов")
                .insertDeliveryAddress("подвал")
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
