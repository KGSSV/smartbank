import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginTest {
    public static void main(String[] args) throws InterruptedException {
        // Set the path to the chromedriver executable
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        // Create a new instance of the ChromeDriver
        WebDriver driver = new ChromeDriver();
        // Open the Chrome browser and navigate to the Smart Bank login page
        driver.get("http://34.238.153.133:8081/");

        // Wait for 5 seconds
        Thread.sleep(5000);

        // Find the username input field and enter the username
        WebElement usernameInput = driver.findElement(By.id("username"));
        usernameInput.sendKeys("your_username");

        // Find the password input field and enter the password
        WebElement passwordInput = driver.findElement(By.id("password"));
        passwordInput.sendKeys("your_password");

        // Find the login button and click it
        WebElement loginButton = driver.findElement(By.xpath("//button[@type='submit']"));
        loginButton.click();

        // Wait for 5 seconds
        Thread.sleep(5000);

        // Close the browser
        driver.quit();
    }
}
