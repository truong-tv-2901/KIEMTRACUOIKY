package vai.truongtv23.kiemtracuoiky;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import vai.truongtv23.common.BaseTest;
import vai.truongtv23.common.RecordVideo;

import java.lang.reflect.Method;

public class addNewProduct extends BaseTest  {

    @Test
    public void addNewProduct(Method method) throws Exception {
        RecordVideo.startRecord(method.getName());

          // enter username password
        driver.get("https://cms.anhtester.com/login");
        Assert.assertEquals(driver.findElement(By.xpath("//h1[normalize-space()='Welcome to Active eCommerce CMS']")).getText() , "Welcome to Active eCommerce CMS", "Pass");

        driver.findElement(By.xpath(" //input[@id='email']")).sendKeys("admin@example.com");
        driver.findElement(By.xpath(" //input[@id='password']")).sendKeys("123456");

        driver.findElement(By.xpath(" //button[normalize-space()='Login']")).click();


        Assert.assertTrue(driver.findElement(By.xpath(" //span[normalize-space()='Dashboard']")).isDisplayed() ,"Fail");

        // mở trang add new product
        driver.findElement(By.xpath(" //span[normalize-space()='Products']")).click();

        driver.findElement(By.xpath(" //span[normalize-space()='Add New Product']")).click();

        Assert.assertEquals(driver.findElement(By.xpath("//h5[normalize-space()='Add New Product']")).getText() , "Add New Product", "Pass");

        driver.findElement(By.xpath("//input[@placeholder='Product Name']")).sendKeys("truongtv23");

        driver.findElement(By.xpath("//div[@id='category']//label[@class='col-md-3 col-from-label']/following-sibling::div//button")).click();
        driver.findElement(By.xpath("//div[@id='category']//label[@class='col-md-3 col-from-label']/following-sibling::div//div//input")).sendKeys("aka");
        driver.findElement(By.xpath("//div[@id='category']//label[@class='col-md-3 col-from-label']/following-sibling::div//div//input")).sendKeys(Keys.ENTER);
        sleep(2);



        driver.findElement(By.xpath("//label[normalize-space()='Brand']/following-sibling::div//button")).click();
        driver.findElement(By.xpath("//label[normalize-space()='Brand']/following-sibling::div//input")).sendKeys("demo");
        driver.findElement(By.xpath("//label[normalize-space()='Brand']/following-sibling::div//input")).sendKeys(Keys.ENTER);
        sleep(2);


        driver.findElement(By.xpath("//input[@placeholder='Unit (e.g. KG, Pc etc)']")).sendKeys("KG");

        driver.findElement(By.xpath("//input[@placeholder='0.00']")).clear();
        driver.findElement(By.xpath("//input[@placeholder='0.00']")).sendKeys("10");

        driver.findElement(By.xpath("//input[@name='min_qty']")).clear();
        driver.findElement(By.xpath("//input[@name='min_qty']")).sendKeys("1");

        driver.findElement(By.xpath("//tags[@role='tagslist']")).sendKeys("VAI");



        driver.findElement(By.xpath("//label[normalize-space()='Gallery Images (600x600)']/following-sibling::div")).click();
        driver.findElement(By.xpath("//input[@placeholder='Search your files']")).sendKeys("car");
        sleep(2);
        driver.findElement(By.xpath("//div[@title='car.jpg']//img[@class='img-fit']")).click();
        driver.findElement(By.xpath("//button[normalize-space()='Add Files']")).click();
        sleep(2);

        // add file thumbnail
        driver.findElement(By.xpath("//label[normalize-space()='Thumbnail Image (300x300)']/following-sibling::div")).click();
        driver.findElement(By.xpath("//input[@placeholder='Search your files']")).sendKeys("ak47");
        sleep(2);
        driver.findElement(By.xpath("//body[1]/div[3]/div[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/img[1]")).click();
        driver.findElement(By.xpath("//button[normalize-space()='Add Files']")).click();
        sleep(2);

        //thêm video provider
        driver.findElement(By.xpath("//label[normalize-space()='Video Provider']/following-sibling::div//button")).click();
        sleep(1);

        driver.findElement(By.xpath("//a[@id='bs-select-3-1']")).click();
        // thêm video link

        driver.findElement(By.xpath("//input[@placeholder='Video Link']")).sendKeys("cms.anhtester.com/login");
        driver.findElement(By.xpath("")).sendKeys("");
        // thêm attribute
        driver.findElement(By.xpath("//button[@class='btn dropdown-toggle btn-light bs-placeholder']")).click();
        driver.findElement(By.xpath("//div[@class='dropdown-menu show']//input[@aria-label='Search']")).sendKeys("size");
        driver.findElement(By.xpath("//div[@class='dropdown-menu show']//input[@aria-label='Search']")).sendKeys(Keys.ENTER);

        driver.findElement(By.xpath("//button[@class='btn dropdown-toggle bs-placeholder btn-light']")).click();
        driver.findElement(By.xpath("//div[@class='dropdown-menu show']//input[@aria-label='Search']")).sendKeys("22");
        driver.findElement(By.xpath("//div[@class='dropdown-menu show']//input[@aria-label='Search']")).sendKeys(Keys.ENTER);

         // thêm unit price
        driver.findElement(By.xpath("//input[@placeholder='Unit price']")).clear();
        driver.findElement(By.xpath("//input[@placeholder='Unit price']")).sendKeys("1");

           // thêm extenal link
        driver.findElement(By.xpath("//input[@placeholder='External link']")).sendKeys("cms.com");

        // External link button text
        driver.findElement(By.xpath("//input[@placeholder='External link button text']")).sendKeys("123");

        //nhập description
        driver.findElement(By.xpath("//div[@role='textbox']")).click();
        driver.findElement(By.xpath("//div[@role='textbox']")).sendKeys("viettei ai");


        driver.findElement(By.xpath("//input[@placeholder='Meta Title']")).sendKeys("vietteiai");


        driver.findElement(By.xpath("//textarea[@name='meta_description']")).click();
        driver.findElement(By.xpath("//textarea[@name='meta_description']")).sendKeys("123456789");
        // thêm meta image
        driver.findElement(By.xpath("//label[normalize-space()='Meta Image']/following-sibling::div")).click();
        driver.findElement(By.xpath("(//div[@aria-modal='true']//div[@role='document']//div//div//div//div//div//div//div//div//input[@placeholder='Search your files']")).sendKeys("car");
        sleep(2);
        driver.findElement(By.xpath("//div[@aria-modal='true']//div[@role='document']//div//div//div//div//div//div[@aria-hidden='false']//div//div[@title='car.jpg']//div//img")).click();
        driver.findElement(By.xpath("//div[@aria-modal='true']//div[@role='document']//div//div//button[@type='button'][normalize-space()='Add Files']")).click();
        sleep(2);

        // KIỂM TRA KHI ADD THÀNH CÔNG
        Assert.assertTrue(driver.findElement(By.xpath("//span[normalize-space()]='Product has been inserted successfully']")).isDisplayed(), "fail");
        // search lại tên
        driver.findElement(By.xpath("//input[@id='search']")).sendKeys("truongtv23");
        driver.findElement(By.xpath("//input[@id='search']")).sendKeys(Keys.ENTER);
        sleep(2);
        //Kiểm tra sản phẩm có xuất hiện không
        Assert.assertTrue(driver.findElement(By.xpath("//td[normalize-space()]='truongtv23']")).isDisplayed(), "fail");





    }
}
