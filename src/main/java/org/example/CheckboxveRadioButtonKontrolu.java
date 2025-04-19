package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class CheckboxveRadioButtonKontrolu {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

        // 1. Checkbox testleri
        driver.get("https://the-internet.herokuapp.com/checkboxes");

        WebElement checkbox1 = driver.findElements(By.cssSelector("input[type='checkbox']")).get(0);
        WebElement checkbox2 = driver.findElements(By.cssSelector("input[type='checkbox']")).get(1);

        if (!checkbox1.isSelected()) {
            checkbox1.click();
            System.out.println("✅ 1. Checkbox işaretlendi.");
        }

        if (checkbox2.isSelected()) {
            System.out.println("✅ 2. Checkbox zaten işaretli.");
        }

        // 2. Radio button testleri
        driver.get("https://demo.guru99.com/test/radio.html");

        WebElement radio2 = driver.findElement(By.id("vfb-7-2"));
        radio2.click();

        if (radio2.isSelected()) {
            System.out.println("✅ Radio button 2 seçildi.");
        }

        // Bekleme ve tarayıcıyı kapatma
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        driver.quit();
    }
}
