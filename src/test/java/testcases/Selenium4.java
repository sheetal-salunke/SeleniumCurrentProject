package testcases;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Selenium4 {
    public static void main(String[] args) throws InterruptedException {
        //Successful Login
        WebDriverManager.chromedriver().setup();
        ChromeDriver d1 = new ChromeDriver();
        d1.manage().window().maximize();
        d1.get("http://localhost:8000/");

        // By loginLevel1LinkRef = By.linkText("Level 1");
        By loginLevel1LinkRef = By.linkText("Level 1");
        WebElement link = d1.findElement(loginLevel1LinkRef);
        link.click();


        By userName = By.name("username");
        WebElement uname = d1.findElement(userName);
        uname.sendKeys("Sheetal");

        String actualTitle = d1.getTitle();
        System.out.println(actualTitle);

          By passwordBox = By.id("password");
        WebElement passwordInputBox = d1.findElement(passwordBox);
        passwordInputBox.sendKeys("password");

        //Thread.sleep(2000);
        By loginButton = By.id("loginbtn");
        WebElement loginButton1 = d1.findElement(loginButton);
        loginButton1.click();

        Alert alert = d1.switchTo().alert();
        String alertText = alert.getText();
        Thread.sleep(20000);
        alert.accept();
        System.out.println(alertText);
     //   d1.close();
    }

}