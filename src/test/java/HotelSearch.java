import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class HotelSearch {

    @Test
    public void searchHotel() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("http://www.kurs-selenium.pl/demo/");
        driver.findElement(By.xpath("//span[text()='Search by Hotel or City Name']")).click();
        driver.findElement(By.xpath("//div[@id='select2-drop']//input")).sendKeys("Dubai");
        Thread.sleep(3000);
        driver.findElement(By.xpath("//span[@class='select2-match' and text() = 'Dubai']")).click();

        driver.findElement(By.name("checkin")).click();
        driver.findElement(By.className("next")).click();
        driver.findElements(By.xpath("//td[@class='day ' and text()='15']"))
                .stream().filter(WebElement::isDisplayed)
                .findFirst()
                .ifPresent(WebElement::click);

        driver.findElements(By.className("next"))
                .stream().filter(WebElement::isDisplayed)
                .findFirst()
                .ifPresent(WebElement::click);

        driver.findElements(By.xpath("//td[@class='day ' and text()='5']"))
                .stream().filter(WebElement::isDisplayed)
                .findFirst()
                .ifPresent(WebElement::click);

        driver.findElement(By.id("travellersInput")).click();
        driver.findElement(By.id("adultMinusBtn")).click();
        driver.findElement(By.id("childPlusBtn")).click();

        driver.findElement(By.xpath("//button[text()=' Search']")).click();

    }
}
