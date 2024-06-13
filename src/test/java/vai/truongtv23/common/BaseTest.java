package vai.truongtv23.common;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.time.Duration;

public class BaseTest {
    public  WebDriver driver;

    @BeforeMethod
    public void createDriver() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));


    }

    @AfterMethod
    public void takeScreenshot(ITestResult result) throws InterruptedException {
        AddLog.info(result.getName());
        Thread.sleep(1000);
        //Khởi tạo đối tượng result thuộc ITestResult để lấy trạng thái và tên của từng Test Case
        //Ở đây sẽ so sánh điều kiện nếu testcase passed hoặc failed
        //passed = SUCCESS và failed = FAILURE
        if (ITestResult.FAILURE == result.getStatus()) {
            try {
                // Tạo tham chiếu của TakesScreenshot
                TakesScreenshot ts = (TakesScreenshot) driver;
                // Gọi hàm capture screenshot - getScreenshotAs
                File source = ts.getScreenshotAs(OutputType.FILE);
                //Kiểm tra folder tồn tại. Nêu không thì tạo mới folder
                File theDir = new File("./Screenshots/");
                if (!theDir.exists()) {
                    theDir.mkdirs();
                }
                // result.getName() lấy tên của test case xong gán cho tên File chụp màn hình
                FileHandler.copy(source, new File("./Screenshots/" + result.getName() + ".png"));
                System.out.println("Đã chụp màn hình: " + result.getName());
            } catch (Exception e) {
                System.out.println("Exception while taking screenshot " + e.getMessage());
            }
        }
    }
    public void closeDriver() throws Exception {
        driver.quit();
        RecordVideo.stopRecord();

    }

    public  void sleep(double second ){
        try {
            Thread.sleep((long) (second * 1000));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
