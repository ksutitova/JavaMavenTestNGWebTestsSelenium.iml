
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import runner.BaseTest;


public class KsuTitova99BottlesOfBeerHW12Tests extends BaseTest {

    /**
     * TC_12_01 Подтвердите, что в меню BROWSE LANGUAGES, подменю  J,
     * пользователь может найти описание страницы, на которой перечеслены все программные языки,
     * начинающиеся с буквы J,  отсортированные по названию
     * Шаги:
     * Открыть базовую страницу
     * Нажать на пункт меню BROWSE LANGUAGES
     * Нажать на подменю J
     * Подтвердить, что пользователь видит текст
     * “All languages starting with the letter J are shown, sorted by Language.”
     */


    @Test
    public void testKseniyaTitovaBROWSELANGUAGESsubmenuJ() {
        String expectedResult = "All languages starting with the letter J are shown, sorted by Language.";

        getDriver().get("http://www.99-bottles-of-beer.net/");

        WebElement menuBrowseLanguages = getDriver().findElement(By.xpath("//ul/li/a[@href='/abc.html']"));
        menuBrowseLanguages.click();

        WebElement subtitleJ = getDriver().findElement(By.xpath("//ul/li/a[@href='j.html']"));
        subtitleJ.click();

        WebElement result = getDriver().findElement(By.xpath("//div[@id='main']/p"));

        Assert.assertEquals(result.getText(), expectedResult);
    }

    /**
     * TC_12_02 Подтвердите, что в меню BROWSE LANGUAGES, подменю  M, последний программный язык в таблице -  MySQL
     * Шаги:
     * Открыть базовую страницу
     * Нажать на пункт меню BROWSE LANGUAGES
     * Нажать на подменю M
     * Подтвердить, что последний язык программирования на странице - MySQL
     */

    @Test
    public void testKseniyaTitovaBROWSELANGUAGESsubmenuM() {

        String expectedResult = "MySQL";

        getDriver().get("http://www.99-bottles-of-beer.net/");

        getDriver().findElement(By.xpath("//ul/li/a[@href='/abc.html']")).click();

        getDriver().findElement(By.xpath("//ul/li/a[@href='m.html']")).click();

        WebElement result = getDriver().findElement(By.xpath("//table//a[@href='language-mysql-1252.html']"));

        Assert.assertEquals(result.getText(), expectedResult);
    }

    /**
     * TC_12_03 Подтвердите, что в меню BROWSE LANGUAGES существует таблица
     * с заголовками Language, Author, Date, Comments, Rate
     */

    @Test
    public void testKseniyaTitovaBROWSELANGUAGESTable() {

        String expectedResult = "Language, Author, Date, Comments, Rate, ";

        getDriver().get("http://www.99-bottles-of-beer.net/");

        getDriver().findElement(By.xpath("//ul/li/a[@href='/abc.html']")).click();

        String[] pText = new String[5];
        for (int i = 0; i < pText.length; i++) {
            int index = i + 1;
            pText[i] = getDriver().findElement(By.xpath(
                    "//table[@id='category']/tbody/tr/th[" + index + "]")).getText();
        }

        String actualResult = "";
        for (int i = 0; i < pText.length; i++) {
            actualResult += pText[i] + ", ";
        }

        Assert.assertEquals(actualResult, expectedResult);
    }

    /**
     * TC_12_05 Подтвердите, что на сайте существует 10 языков, названия которых начинаются с цифр.
     */

    @Test
    public void testLanguagesNamesStartWithNumbers() {
        int expectedResult = 10;

        getDriver().get("http://www.99-bottles-of-beer.net/");

        getDriver().findElement(By.xpath("//a[@href='/abc.html']")).click();
        getDriver().findElement(By.xpath("//a[@href='0.html']")).click();

        String[] actualResult = new String[10];
        for (int i = 0; i < actualResult.length; i++) {
            actualResult[i] = getDriver().findElement(
                    By.xpath("//tbody/tr[@onmouseover][" + (i + 1) + "]")
            ).getText();
        }

        Assert.assertEquals(actualResult.length, expectedResult);
    }


    /**
     * TC_12_06 Подтвердите, что если на странице Sign Guestbook
     * http://www.99-bottles-of-beer.net/signv2.html вы заполните все поля формы,
     * но введете случайно сгенерированное трехзначное число в поле  Security Code: ,
     * то вы получите сообщение об ошибке  Error: Error: Invalid security code.
     */

    @Test
    public void testSecurityCodeField() {
        String expectedResult = "Error: Error: Invalid security code.";

        getDriver().get("http://www.99-bottles-of-beer.net/signv2.html");

        getDriver().findElement(By.xpath
                ("//form/p/input[@name='name']")).sendKeys("Ksenia");
        getDriver().findElement(By.xpath
                ("//form/p/input[@name='location']")).sendKeys("Sankt-Peterburg");
        getDriver().findElement(By.xpath
                ("//form/p/input[@name='email']")).sendKeys("ksunchik123@yandex.ru");
        getDriver().findElement(By.xpath
                ("//form/p/input[@name='homepage']")).sendKeys("https://www.google.com/");
        getDriver().findElement(By.xpath("//form/p/input[@name='captcha']")).sendKeys
                (Integer.toString((int) (Math.random() * 1000 + 100)));
        getDriver().findElement(By.xpath("//textarea[@name='comment']")).sendKeys
                ("Test");

        getDriver().findElement(By.xpath("//input[@name='submit']")).click();

        String actualResult = getDriver().findElement(By.xpath("//div[@id='main']/p")).getText();

        Assert.assertEquals(actualResult, expectedResult);
    }


    /**
     * TC_12_07
     * Выберите любой язык программирования (из меню BROWSE LANGUAGES) и любую версию решения
     * (из раздела Alternative Versions, если такой раздел существует  для выбранного языка)
     * Подтвердите, что пользователь может сделать закладку на это решение на сайте Reddit
     * (нажав на иконку сайта Reddit, пользователь перейдет на Логин страницу сайта Reddit)
     */

    @Test
    public void testBookmarkTheVersionInSiteReddit() {
        String expectedResult = "Log in";

        getDriver().get("http://www.99-bottles-of-beer.net/");

        getDriver().findElement(By.xpath("//ul/li/a[@href='/abc.html']")).click();
        getDriver().findElement(By.xpath("//ul/li/a[@ href='j.html']")).click();
        getDriver().findElement(By.xpath("//table/tbody/tr/td/a[@href='language-java-3.html']")).click();
        getDriver().findElement(By.xpath("//table/tbody/tr/td/a[@href='language-java-4.html']")).click();
        getDriver().findElement(By.xpath("//div[@id='voting']/p/a[@title='reddit']")).click();

        String actualResult =
                getDriver().findElement(By.xpath("//div[@class='Step__content']/h1")).getText();

        Assert.assertEquals(actualResult, expectedResult);
    }


    /**
     * TC_12_08 Подтвердите, что решение на языке Shakespeare входит в топ 20 всех решений,
     * в топ 10 решений на Esoteric Languages и в топ 6 решений-хитов. Но решение на языке Shakespeare
     * не входит в список топовых решений на реальных языках программирования.
     * (Можно написать одним тестом, но так, чтобы все Asserts были в конце теста. Или можно написать
     * отдельные тесты на каждый requirenment.)
     */

    @Test
    public void testTop20Shakespeare() {
        Boolean expectedResult = false;

        getDriver().get("http://www.99-bottles-of-beer.net/");

        getDriver().findElement(By.xpath("//ul/li/a[@href='/toplist.html']")).click();

        String[] result = new String[22];
        for (int i = 1; i < result.length; i++) {
            if (getDriver().findElement(By.xpath("//tr[" + i + "]")).getText().contains("Shakespeare")) {
                expectedResult = true;
            }
        }

        Assert.assertTrue(expectedResult);
    }

    @Test
    public void testTop10Shakespeare() {
        Boolean expectedResult = false;

        getDriver().get("http://www.99-bottles-of-beer.net/");

        getDriver().findElement(By.xpath("//ul/li/a[@href='/toplist.html']")).click();
        getDriver().findElement(By.xpath("//ul/li/a[@href='./toplist_esoteric.html']")).click();

        String[] result = new String[12];
        for (int i = 1; i < result.length; i++) {
            if (getDriver().findElement(By.xpath("//tr[" + i + "]")).getText().contains("Shakespeare")) {
                expectedResult = true;
            }
        }

        Assert.assertTrue(expectedResult);
    }

    @Test
    public void testTop6Shakespeare() {
        Boolean expectedResult = false;

        getDriver().get("http://www.99-bottles-of-beer.net/");

        getDriver().findElement(By.xpath("//ul/li/a[@href='/toplist.html']")).click();
        getDriver().findElement(By.xpath("//ul/li/a[@href='./tophits.html']")).click();

        String[] result = new String[8];
        for (int i = 1; i < result.length; i++) {
            if (getDriver().findElement(By.xpath("//tr[" + i + "]")).getText().contains("Shakespeare")) {
                expectedResult = true;
            }
        }

        Assert.assertTrue(expectedResult);
    }


    /**
     * TC_12_09 Подтвердите, что существует 6 версий решений на языке программирования Java.
     */

    @Test
    public void VersionsOfJava() {
        int expectedResult = 6;

        getDriver().get("http://www.99-bottles-of-beer.net/");

        getDriver().findElement(By.xpath("//ul[@id='menu']/li/a[@href='/abc.html']")).click();
        getDriver().findElement(By.xpath("//li/a[@href ='j.html']")).click();
        getDriver().findElement(By.xpath("//a[@href='language-java-3.html']")).click();

        int actualResult =
                getDriver().findElements(By.xpath("//table[@id='category']/tbody/tr/td/a")).size() + 1;

        Assert.assertEquals(actualResult, expectedResult);
    }

}
