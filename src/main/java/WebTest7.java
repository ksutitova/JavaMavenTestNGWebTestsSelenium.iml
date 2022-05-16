import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebTest7 {

    /** TC_11_07 Придумайте и автоматизируйте свой собственный тест кейс на сайте
        http://www.99-bottles-of-beer.net/
     Считать две первые строчки песни

     Шаги:
     1. Открыть вебсайт на странице Start
     2. Перейти на вкладку Song Lyrics
     3. Считать подзаголовок
     4. Подтвердить, что он соответствует ожидаемому
     5. Закрыть браузер
     */

    @Test
    public void testSubtitleSongLyrics(){
        String chromeDriver = "webdriver.chrome.driver";
        String driverPath = "/Users/ksenianehotina/Downloads/chromedriver 2";
        String url = "http://www.99-bottles-of-beer.net/";
        String expectedResult = "Song Lyrics";

        System.setProperty(chromeDriver, driverPath);
        WebDriver driver = new ChromeDriver();

        driver.get(url);

        WebElement subtitleSongLyrics = driver.findElement(By.xpath
                ("//body/div[@id='wrap']/div[@id='navigation']/ul[@id='submenu']/li/a[@href='lyrics.html']")
        );

        subtitleSongLyrics.getText();

        String actualResult = subtitleSongLyrics.getText();

        Assert.assertEquals(actualResult,expectedResult);

        driver.quit();
    }








}
