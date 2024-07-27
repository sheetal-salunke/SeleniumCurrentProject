package testcases;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AmazonAssignment {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeDriver d1 = new ChromeDriver();
        d1.manage().window().maximize();
        d1.get("https://www.amazon.com");
        //Added sleep to handle captcha--entering captcha manually
        Thread.sleep(10000);

        //Again opening same website
        d1.get("https://www.amazon.com");
        //clicking on Gaming see more option
        By gameSeeMore = By.xpath("//h2[text()='Gaming accessories']/../..//span[text()='See more' and contains(@class,'a-truncate-cut')]");
        WebElement seeMoreLink = d1.findElement(gameSeeMore);
        seeMoreLink.click();

        //Find and click on Keyboard option
        By keyboards =By.xpath("//a[@aria-label='Keyboards']");
        WebElement keyboardOption =d1.findElement(keyboards);
        keyboardOption.click();

        //find first searched keyboard and click
        //By keyboardSearch1=By.xpath("//span[contains(text(),'MageGee Portable 60% Mechanical Gaming Keyboard')]");
        By keyboardOptionFirst=By.xpath("//div[@id='search']/..//a[@class='a-link-normal s-underline-text s-underline-link-text s-link-style a-text-normal']/span[1]");
        WebElement keyBoardOption1Search=d1.findElement(keyboardOptionFirst);
        String keyboardName=keyBoardOption1Search.getText();
        keyBoardOption1Search.click();

        //print price for keyboard
        By keyboardOption1Price=By.xpath("//span[@class='a-price a-text-price a-size-medium apexPriceToPay']//span[2][text()='$29.99']");
        WebElement priceOfKeyboardOptionFirst=d1.findElement(keyboardOption1Price);
        String price=priceOfKeyboardOptionFirst.getText();
        System.out.println(keyboardName +" price is " +price);
        //Closing browser
        d1.close();

    }
}
