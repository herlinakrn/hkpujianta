package com.juaracoding.hkpujianta.ujianta.page.admin;

import com.juaracoding.hkpujianta.ujianta.util.Constants;
import com.juaracoding.hkpujianta.ujianta.util.GlobalFunction;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

/*
IntelliJ IDEA 2024.1.4 (Ultimate Edition)
Build #IU-241.18034.62, built on June 21, 2024
@Author ITS-NEW a.k.a. Herlina Kurnia Prasetiani
Java Developer
Created on 20/08/2024 18:28
@Last Modified 20/08/2024 18:28
Version 1.0
*/
public class IzinOffPage {
    private WebDriver driver;

    @FindBy(xpath = "//p[@class='MuiTypography-root MuiTypography-body1 css-1kei35f']")
    private WebElement validasiHalamanIzinOff;

    @FindBy(xpath = "//input[@id='search']")
    private WebElement txtSearch;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement buttonSearch;

    @FindBy(xpath = "/html/body/div[1]/div/div/div/div[1]/div/div[2]/div[1]/div/table/tbody")
    private WebElement divTabelIzinOff;

    public IzinOffPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public WebElement getValidasiHalamanIzinOff() {
        GlobalFunction.delay(Constants.TIMEOUT_DELAY);
        return new WebDriverWait(driver, Duration.ofSeconds(Constants.TIMEOUT_DELAY))
                .until(ExpectedConditions.visibilityOf(validasiHalamanIzinOff));
    }
    public WebElement getTxtSearch() {
        GlobalFunction.delay(Constants.TIMEOUT_DELAY);
        return new WebDriverWait(driver, Duration.ofSeconds(Constants.TIMEOUT_DELAY))
                .until(ExpectedConditions.visibilityOf(txtSearch));
    }
    public WebElement getButtonSearch() {
        GlobalFunction.delay(Constants.TIMEOUT_DELAY);
        return new WebDriverWait(driver, Duration.ofSeconds(Constants.TIMEOUT_DELAY))
                .until(ExpectedConditions.visibilityOf(buttonSearch));
    }
    public WebElement getDivTabelIzinOff() {
        GlobalFunction.delay(Constants.TIMEOUT_DELAY);
        return new WebDriverWait(driver, Duration.ofSeconds(Constants.TIMEOUT_DELAY))
                .until(ExpectedConditions.visibilityOf(divTabelIzinOff));
    }
}
