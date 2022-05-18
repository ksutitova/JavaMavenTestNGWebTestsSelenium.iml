import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;


public class WebTestDelish {


    /**
     * TC_1

     * Шаги:
     * 1. Открыть вебсайт на базовой странице
     * 2. Перейти на вкладку Sign In
     * 3. Подтвердить, что выводится "Sign In"
     * 4. Закрыть браузер
     */

    @Test
    public void testSubtitleSongLyrics() throws InterruptedException {
        String chromeDriver = "webdriver.chrome.driver";
        String driverPath = "/Users/ksenianehotina/Downloads/chromedriver 2";
        String url = "https://www.delish.com/cooking/recipe-ideas/";
        String expectedResult = "Sign In";

        System.setProperty(chromeDriver, driverPath);
        WebDriver driver = new ChromeDriver();

        driver.get(url);

        WebElement signIn = driver.findElement(By.xpath("//*[@id=\"__next\"]/div/nav/div/div[2]/a/span"));

        signIn.click();

        WebElement result = driver.findElement(By.xpath("//*[@id=\"root\"]/div[1]/div[2]/div/div[2]/h1"));

        String actualResult = result.getText();

        Assert.assertEquals(actualResult, expectedResult);

        driver.quit();

    }

}
