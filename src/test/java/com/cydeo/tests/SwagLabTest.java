package com.cydeo.tests;

import com.cydeo.utils.ConfigurationReader;
import com.cydeo.utils.Driver;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

public class SwagLabTest {

    @Test
    public void LoginTest() throws InterruptedException {
        AppiumDriver<MobileElement> driver = Driver.getDriver();

        System.out.println("driver.getPlatformName() = " + driver.getPlatformName());

        System.out.println("driver.getDeviceTime() = " + driver.getDeviceTime());

        Thread.sleep(4000);

        driver.findElement(MobileBy.AccessibilityId("test-Username")).sendKeys(ConfigurationReader.getProperty("swagUser"));
        driver.findElement(MobileBy.AccessibilityId("test-Password")).sendKeys(ConfigurationReader.getProperty("swagPass"));
        driver.findElement(MobileBy.AccessibilityId("test-LOGIN")).click();
        MobileElement products = driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc=\"test-Cart drop zone\"]/android.view.ViewGroup"));

        Thread.sleep(4000);


        Assertions.assertTrue(products.isDisplayed());

        ((AndroidDriver)driver).findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Policy\"));");


        Driver.closeDriver();
    }
}

//    AppiumDriver<MobileElement> driver = Driver.getDriver();
//
//        System.out.println("driver.getPlatformName() = " + driver.getPlatformName());
//
//                System.out.println("driver.getDeviceTime() = " + driver.getDeviceTime());
//
//                WebDriverWait wait = new WebDriverWait(driver, 4);
//
//                wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.AccessibilityId("test-Username")))
//                .sendKeys(ConfigurationReader.getProperty("swagUser"));
//                wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.AccessibilityId("test-Password")))
//                .sendKeys(ConfigurationReader.getProperty("swagPass"));
//                wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.AccessibilityId("test-LOGIN"))).click();
//                MobileElement products = (MobileElement) wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.view.ViewGroup[@content-desc=\"test-Cart drop zone\"]/android.view.ViewGroup")));
//
//                Assertions.assertTrue(products.isDisplayed());
//                Driver.closeDriver();