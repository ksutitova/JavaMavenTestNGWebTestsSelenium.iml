import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebTests {
    /**
     * TC_11_11 Подтвердите, что если на странице по ссылке
     * http://www.99-bottles-of-beer.net/submitnewlanguage.html ,
     * пользователь нажмет кнопку Submit Language,  не заполнив информацию в обязательных полях,
     * будет показана ошибка
     * <p>
     * Error: Precondition failed - Incomplete Input.
     * <p>
     * Шаги:
     * 1. Открыть вебсайт на странице
     * 2. Нажать на кнопку Submit Language
     * 3. Подтвердить, что на странице показана ошибка
     * 4. Подтвердить, что текст ошибки соответствует ожидаемому
     * 5. Закрыть браузер
     */

    @Test
    public void testErrorMenuSubmitLanguage() {
        String chromeDriver = "webdriver.chrome.driver";
        String driverPath = "/Users/ksenianehotina/Downloads/chromedriver 2";
        String url = "http://www.99-bottles-of-beer.net/submitnewlanguage.html";
        String expectedResult = "Error: Precondition failed - Incomplete Input.";

        System.setProperty(chromeDriver, driverPath);
        WebDriver driver = new ChromeDriver();

        driver.get(url);

        WebElement submitLanguage = driver.findElement(By.xpath
                ("//body/div[@id='wrap']/div[@id='main']/form[@id='addlanguage']/p/input[@type='submit']")
        );
        submitLanguage.click();

        WebElement error = driver.findElement(By.xpath
                ("//body/div[@id='wrap']/div[@id='main']/p")
        );

        String actualResult = error.getText();

        Assert.assertEquals(actualResult, expectedResult);

        driver.quit();
    }

    /**
     * TC_11_12 Precondition: Если на странице по ссылке
     * http://www.99-bottles-of-beer.net/submitnewlanguage.html ,
     * пользователь нажмет кнопку Submit Language,  не заполнив информацию в обязательных полях,
     * будет показана ошибка с текстом
     * <p>
     * Error: Precondition failed - Incomplete Input.
     * <p>
     * Подтвертите, что в тексте ошибки слова Error, Precondition, Incomplete и Input написаны
     * с большой буквы, а слово failed  написано  с маленькой буквы.
     * Так же подтвердите, что в тексте ошибки содержатся знаки :, -  и .
     * <p>
     * Шаги:
     * 1. Открыть вебсайт на странице
     * 2. Нажать на кнопку Submit Language
     * 3. Считать текст ошибки
     * 4. Подтвердить requirenments
     * 5. Закрыть браузер
     */
    @Test
    public void testErrorSubmitLanguage() {
        String chromeDriver = "webdriver.chrome.driver";
        String driverPath = "/Users/ksenianehotina/Downloads/chromedriver 2";
        String url = "http://www.99-bottles-of-beer.net/submitnewlanguage.html";
        String expectedResult1 = "Error:";
        String expectedResult2 = "Precondition";
        String expectedResult3 = "Incomplete";
        String expectedResult4 = "Input";
        String expectedResult5 = "failed";
        String expectedResult6 = ":";
        String expectedResult7 = "-";
        String expectedResult8 = ".";

        System.setProperty(chromeDriver, driverPath);
        WebDriver driver = new ChromeDriver();

        driver.get(url);

        WebElement submitLanguage = driver.findElement(By.xpath
                ("//body/div[@id='wrap']/div[@id='main']/form[@id='addlanguage']/p/input[@type='submit']")
        );
        submitLanguage.click();

        WebElement error = driver.findElement(By.xpath
                ("//body/div[@id='wrap']/div[@id='main']/p")
        );
        error.getText();

        WebElement actualResult1 = driver.findElement(
                By.xpath("//body/div[@id='wrap']/div[@id='main']/p[contains(@text(),'Error')]")
        );

//        contains(@id, 'u_0_8')
//        String a = actualResult1.getText();
//        if (a.contains(":") == true) {
//            a = ":";
//        }

        Assert.assertEquals(actualResult1.getText(), expectedResult6);
        driver.quit();
    }

    /**
     * TC_11_13 Подтвердите, что на странице по ссылке
     * http://www.99-bottles-of-beer.net/submitnewlanguage.html
     * в первом пункте списка пользователь видит текст
     *
     * IMPORTANT: Take your time! The more carefully you fill out this form (especially the language name and description), the easier it will be for us and the faster your language will show up on this page. We don't have the time to mess around with fixing your descriptions etc. Thanks for your understanding.
     *
     * Шаги:
     * 1. Открыть вебсайт на странице
     * 2. Считать текст
     * 3. Подтвердить, что текст соответствует ожидаемому
     * 4. Закрыть браузер
     */

    @Test
    public void testIMPORTANTMenuSubmitLanguage() {
        String chromeDriver = "webdriver.chrome.driver";
        String driverPath = "/Users/ksenianehotina/Downloads/chromedriver 2";
        String url = "http://www.99-bottles-of-beer.net/submitnewlanguage.html";
        String expectedResult = "IMPORTANT: Take your time! The more carefully you fill out this form " +
                "(especially the language name and description), the easier it will be for " +
                "us and the faster your language will show up on this page. We don't have" +
                " the time to mess around with fixing your descriptions etc. Thanks for your understanding.";

        System.setProperty(chromeDriver, driverPath);
        WebDriver driver = new ChromeDriver();

        driver.get(url);

        WebElement text = driver.findElement(By.xpath
                ("//body/div[@id='wrap']/div[@id='main']/ul/li/span ")
        );


//        WebElement error = driver.findElement(By.xpath
//                ("//body/div[@id='wrap']/div[@id='main']/p")
//        );

        String actualResult = text.getText();

        Assert.assertEquals(actualResult, expectedResult);

        driver.quit();
    }
}
