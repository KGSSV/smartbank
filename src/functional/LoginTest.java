import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SmartBankLoginAutomation {

    public static void main(String[] args) throws InterruptedException {
        // Set the path to the chromedriver executable
        System.setProperty("webdriver.chrome.driver", "/usr/bin/chromedriver");
        // Create a new instance of the ChromeDriver
        WebDriver driver = new ChromeDriver();
        // Navigate to the Smart Bank login page
        driver.get("http://54.161.80.51:8081/");

        // Wait for the page to load
        Thread.sleep(5000);
        // Find the username and password input fields
        WebElement usernameField = driver.findElement(By.id("username"));
        WebElement passwordField = driver.findElement(By.id("password"));
        // Enter the incorrect login credentials
        usernameField.sendKeys("incorrect_username");
        passwordField.sendKeys("incorrect_password");
        // Find the login button and click it
        WebElement loginButton = driver.findElement(By.xpath("//button[@type='submit']"));
        loginButton.click();

        // Wait for the login process to complete
        Thread.sleep(5000);

        // Find the error message element
        WebElement errorMessage = driver.findElement(By.className("error-message"));
        // Print the error message
        System.out.println("Error message: " + errorMessage.getText());

        // Close the browser
        driver.quit();
    }
}
