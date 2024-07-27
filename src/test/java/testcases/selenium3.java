package testcases;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class selenium3 {
    public static void main(String[] args) throws InterruptedException {
        //Empty Password
        WebDriverManager.chromedriver().setup();
        ChromeDriver d1 = new ChromeDriver();
        d1.manage().window().maximize();
        d1.get("http://localhost:8000/");

        // By loginLevel1LinkRef = By.linkText("Level 1");
        By loginLevel1LinkRef = By.linkText("Level 1");
        WebElement link = d1.findElement(loginLevel1LinkRef);
        link.click();
        By loginButton = By.id("loginbtn");
        WebElement loginButton1 = d1.findElement(loginButton);
        loginButton1.click();

        By error = By.id("error1");
        WebElement errorInfo = d1.findElement(error);
        String errorText = errorInfo.getText();
        System.out.println(errorText);

        d1.close();
    }

    }
