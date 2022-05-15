import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebTestAndrew {

    @Test
    public void testMenuStart() {

        String chromeDriver = "webdriver.chrome.driver";
        String driverPath = "/Users/ksenianehotina/Downloads/chromedriver 2";
        String url = "file:///Users/ksenianehotina/Library/Group%20Containers/group.com.apple.notes/Media/3A3138E6-C3F1-4539-970B-1B5AA8C5E156/monkdiamonddiscovery.html";
        String expectedResult = "Факты об алмазе\n" +
                "Карат: 300\n" +
                "Цвет: зелёный\n" +
                "Цена: более f10 миллионов";

        System.setProperty(chromeDriver, driverPath);
        WebDriver driver = new ChromeDriver();

        driver.get(url);

        WebElement green = driver.findElement(By.xpath("//body/div[5]"));

        String actualResult = green.getText();

        Assert.assertEquals(actualResult, expectedResult);

        driver.quit();
    }
}
