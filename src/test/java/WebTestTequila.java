
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import static java.lang.Thread.sleep;


public class WebTestTequila {

    /**
     * TC_1

     * Шаги:
     * 1. Открыть вебсайт на базовой странице
     * 2. Перейти на вкладку меню
     * 3. Кликаем на кнопку поиска
     * 4. ВВодим в поиск "tequila"
     * 5. Переходим  - кликаем
     * 6. Подтвердить, что он выводится "The 13 Best Tequila Brands For Margaritas"
     * 7. Закрыть браузер
     */

    @Test
    public void testSubtitleSongLyrics() throws InterruptedException {
        String chromeDriver = "webdriver.chrome.driver";
        String driverPath = "/Users/ksenianehotina/Downloads/chromedriver 2";
        String url = "https://www.delish.com/cooking/recipe-ideas/";
        String expectedResult = "tequila";    //"The 13 Best Tequila Brands For Margaritas";

        System.setProperty(chromeDriver, driverPath);
        WebDriver driver = new ChromeDriver();

        driver.get(url);

        WebElement menu = driver.findElement(By.className("icon icon-menu"));
                //(By.xpath("/html/body/nav[3]/div/div/a[2]/span"));
//                ("//body/div[@id='__next']/div[@data-focus-lock='main']/" +
//                        "nav[@class='nav-bar-container css-1pioqs8 efnztv76']/" +
//                        "div[@class='nav-bar-container css-1pioqs8 efnztv76']/" +
//                        "a[@aria-label='Sidepanel Button']/span[@class=' css-4bs81v e1s64tyo0']" +
//                        "/svg[@viewBox='0 0 500 500']")
                // //*[@id="__next"]/div/nav/div/a[1]/span/svg
               //  //body/div[@id='__next']/div[@data-focus-lock='main']/nav/div/a[@aria-label='Sidepanel Button']/span/svg[@viewBox='0 0 500 500']
//        );

        menu.click();

        WebElement search = driver.findElement(By.xpath("//*[@id=\"sidepanel\"]/div/a[1]/span[2]"));
        search.click();

        WebElement searchBox = driver.findElement(By.xpath("//*[@id=\"editing-view-port\"]/div"));
        searchBox.sendKeys("tequila");

        sleep(1000);

        searchBox.getCssValue(String.valueOf(searchBox));

        String actualResult = searchBox.getText();

        Assert.assertEquals(actualResult, expectedResult);

        driver.quit();
    }
}
