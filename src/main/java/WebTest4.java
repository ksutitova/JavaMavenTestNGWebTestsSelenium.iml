import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebTest4 {

    /** TC_11_03 Подтвердите, что на странице по базовой ссылке последний пункт меню
     *  имеет подзаголовок Submit new Language

     Шаги:
     1. Открыть вебсайт на базовой странице
     2. Считать название подзаголовка последнего пункта меню
     3. Подтвердить, что название подзаголовка последнего пункта меню соответствует ожидаемому
     4. Закрыть браузер
     */

    @Test
    public void testMenuSubtitleSubmitNewLanguage(){
        String chromeDriver = "webdriver.chrome.driver";
        String driverPath = "/Users/ksenianehotina/Downloads/chromedriver 2";
        String url = "http://www.99-bottles-of-beer.net/";
        String expectedResult = "Submit New Language";

        System.setProperty(chromeDriver, driverPath);
        WebDriver driver = new ChromeDriver();

        driver.get(url);

        WebElement menuSubmitNewLanguage = driver.findElement(By.xpath
                ("//body/div[@id='wrap']/div[@id='navigation']/ul[@id='menu']/li/a[@href='/submitnewlanguage.html']")
        );

        menuSubmitNewLanguage.click();

        WebElement subtitle = driver.findElement(By.xpath
              ("//body/div[@id='wrap']/div[@id='navigation']/ul[@id='submenu']/li/a[@href='./submitnewlanguage.html']")
        );

        String actualResult = subtitle.getText();

        Assert.assertEquals(actualResult,expectedResult);

        driver.quit();
    }
}
