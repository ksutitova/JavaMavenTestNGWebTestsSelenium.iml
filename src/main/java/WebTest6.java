import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebTest6 {

    /** TC_11_06 Подтвердите, что имена создателей сайта:
     Oliver Schade
     Gregor Scheithauer
     Stefan Scheler

     Шаги:
     Напишите самостоятельно (найдите информацию о создателях на сайте,
     и опишите шаги для навигации и исполнения тест кейса)

     Шаги:
     1. Открыть вебсайт на странице Start
     2. Перейти на вкладку Team
     3. Считать исмена создателей
     4. Подтвердить, что имена соответствует ожидаемым
     5. Закрыть браузер
     */

    @Test
    public void testNamesOfTheCreatorsOfTheSite(){
        String chromeDriver = "webdriver.chrome.driver";
        String driverPath = "/Users/ksenianehotina/Downloads/chromedriver 2";
        String url = "http://www.99-bottles-of-beer.net/";
        String expectedResult1 = "Oliver Schade";
        String expectedResult2 = "Gregor Scheithauer";
        String expectedResult3 = "Stefan Scheler";

        System.setProperty(chromeDriver, driverPath);
        WebDriver driver = new ChromeDriver();

        driver.get(url);

        WebElement subtitleTeam = driver.findElement(By.xpath
                ("//body/div[@id='wrap']/div[@id='navigation']/ul[@id='submenu']/li/a[@href='team.html']")
        );

        subtitleTeam.click();


        WebElement names1 = driver.findElement(By.xpath("//body/div[@id='wrap']/div[@id='main']/h3[1]"));
        String actualResult1 = names1.getText();
        Assert.assertEquals(actualResult1,expectedResult1);

        WebElement names2 = driver.findElement(By.xpath("//body/div[@id='wrap']/div[@id='main']/h3[2]"));
        String actualResult2 = names2.getText();
        Assert.assertEquals(actualResult2,expectedResult2);

        WebElement names3 = driver.findElement(By.xpath("//body/div[@id='wrap']/div[@id='main']/h3[3]"));
        String actualResult3 = names3.getText();
        Assert.assertEquals(actualResult3,expectedResult3);

        driver.quit();
    }
}
