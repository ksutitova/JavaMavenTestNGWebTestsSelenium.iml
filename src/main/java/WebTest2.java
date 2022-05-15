import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static java.lang.Thread.sleep;

public class WebTest2 {

    /**
     * TC_11_01 Подтвердите, что на странице по базовой ссылке в правом верхнем углу
     * пользователь видит заголовок 99 Bottles of Beer
     * Шаги:
     * 1. Открыть вебсайт на базовой странице
     * 2. Считать заголовок в правом верхнем углу
     * 3. Подтвердить, что текст заголовка соответствует ожидаемому
     * 4. Закрыть браузер
     */

    @Test
    public void testMenuStartHeading() {

        String chromeDriver = "webdriver.chrome.driver";
        String driverPath = "/Users/ksenianehotina/Downloads/chromedriver 2";
        String url = "http://www.99-bottles-of-beer.net/";
        String expectedResult = "99 Bottles of Beer";

        System.setProperty(chromeDriver, driverPath);
        WebDriver driver = new ChromeDriver();

        driver.get(url);

        WebElement heading = driver.findElement(By.xpath("//body/div[@id='wrap']/div[@id='header']/h1"));

        String actualResult = heading.getText();

        Assert.assertEquals(actualResult, expectedResult);

        driver.quit();
    }
}