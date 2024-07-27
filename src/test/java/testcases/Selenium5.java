package testcases;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Selenium5 {
    public static void main(String[] args) throws InterruptedException {

        //Successful Login -10 user login
            for(int i=1;i<=10;i++)
             {
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
            uname.sendKeys("Sheetal"+i);

            String actualTitle = d1.getTitle();
            System.out.println(actualTitle);

            By generatePassword = By.id("generate_password");
            WebElement generatePass = d1.findElement(generatePassword);
            generatePass.click();

            Alert alert = d1.switchTo().alert();
            String alertText = alert.getText();
            alert.accept();

            String newAlertText = alertText.replace("Generated Password : ", "");
            String password = newAlertText.replace(". Use this password for login", "");
            System.out.println("Password: " + password);

            By passwordBox = By.id("password");
            WebElement passwordInputBox = d1.findElement(passwordBox);
            passwordInputBox.sendKeys(password);

            //Thread.sleep(2000);
            By loginButton = By.id("loginbtn");
            WebElement loginButton1 = d1.findElement(loginButton);
            loginButton1.click();

            Alert alert2 = d1.switchTo().alert();
            System.out.print(alert2.getText());

            Thread.sleep(5000);
            alert2.accept();

            //  loginButton1.click();
            System.out.println(" ");
            System.out.println("User Logged in "+i+ " times");
            d1.close();
        }
    }
}

