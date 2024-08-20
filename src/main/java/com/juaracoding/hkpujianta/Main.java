package com.juaracoding.hkpujianta;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        WebElement divParent = driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/form/div"));
        List<WebElement> list = driver.findElements(By.tagName("input"));
        //input ke1
        list.get(0);
        //input ke 2
        list.get(1);


    }
}