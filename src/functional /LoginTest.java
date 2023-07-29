import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginTest {
    public static void main(String[] args) throws InterruptedException {
        // Step 1: Set up Chrome WebDriver with the appropriate driver executable path
        System.setProperty("webdriver.chrome.driver", "/usr/bin/chromedriver");

        // Step 2: Open the Chrome browser
        WebDriver driver = new ChromeDriver();

        // Step 3: Navigate to the Smart Bank login page
        String baseUrl = "http://35.175.173.214:8081/"; // Replace with the actual login page URL
        System.out.println("Opening The Browser");
        driver.get(baseUrl);
        System.out.println("Opening The URL: " + baseUrl);
	    Thread.sleep(5000);

        // Step 4: Enter incorrect credentials
        String invalidUsername = "incorrect_username";
        String invalidPassword = "incorrect_password";
        System.out.println("Entering incorrect user with username: " + invalidUsername + " and password: " + invalidPassword);
        WebElement inputUsername = driver.findElement(By.id("username"));
        WebElement inputPassword = driver.findElement(By.id("password"));
        inputUsername.sendKeys(invalidUsername);
	    Thread.sleep(5000);
        inputPassword.sendKeys(invalidPassword);
	    Thread.sleep(5000);

        // Step 5: Click the "Login" button and verify error message display
        WebElement loginButton = driver.findElement(By.xpath("//button[text()='Login']"));
        loginButton.click();
        Thread.sleep(5000); // Adjust the wait time as needed

        WebElement errorMessageElement = driver.findElement(By.className("error-message"));
        if (errorMessageElement.isDisplayed()) {
            String errorMessage = errorMessageElement.getText();
            System.out.println("Error message displayed: " + errorMessage);
        } else {
            System.out.println("Error Message Element is not displayed.");
        }

        // Step 6: Close the browser and quit the WebDriver
        System.out.println("Closing the Browser");
        driver.quit();
    }
}
