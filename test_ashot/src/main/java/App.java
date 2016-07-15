import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

public class App {
    public static void main (String [] args) throws Exception {
		File file = new File("t.png");
		WebDriver driver = new ChromeDriver();

        driver.get("http://192.168.122.1:8080/201606/1.html");

        final Screenshot screenshot = new AShot().shootingStrategy(
                ShootingStrategies.viewportPasting(500)).takeScreenshot(driver);
        final BufferedImage image = screenshot.getImage();
        ImageIO.write(image, "PNG", file);

        driver.quit();
    }
}
