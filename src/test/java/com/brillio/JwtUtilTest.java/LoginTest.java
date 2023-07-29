import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginTest {
    public static void main(String[] args) throws InterruptedException {
        // Set the system property for the ChromeDriver
        System.setProperty("webdriver.chrome.driver", "/usr/bin/chromedriver");

        // Create a new instance of the ChromeDriver
        WebDriver driver = new ChromeDriver();

        // Open the Chrome browser and navigate to the Smart Bank login page
        driver.get("http://54.161.80.51:8081/");

        // Print the page title
        System.out.println("Page Title: " + driver.getTitle());

        // Find the username and password input fields and enter the credentials
        WebElement usernameField = driver.findElement(By.id("username"));
        WebElement passwordField = driver.findElement(By.id("password"));

        usernameField.sendKeys("your_username");
        passwordField.sendKeys("your_password");

        // Find the login button and click it
        WebElement loginButton = driver.findElement(By.xpath("//button[@type='submit']"));
        loginButton.click();

        // Wait for 5 seconds
        Thread.sleep(5000);

        // Close the browser
        driver.quit();
    }
}