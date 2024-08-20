package com.juaracoding.hkpujianta.ujianta.page.user;

import com.juaracoding.hkpujianta.ujianta.util.GlobalFunction;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static com.juaracoding.hkpujianta.ujianta.util.Constants.TIMEOUT_DELAY;

/*
IntelliJ IDEA 2024.1.4 (Ultimate Edition)
Build #IU-241.18034.62, built on June 21, 2024
@Author ITS-NEW a.k.a. Herlina Kurnia Prasetiani
Java Developer
Created on 17/08/2024 03:16
@Last Modified 17/08/2024 03:16
Version 1.0
*/
public class UserLoginPage {
    private WebDriver driver;

    @FindBy(xpath = "/html/body/div/div/div/div[1]/div[2]/div[2]")
    private WebElement divValidasiHome;

    @FindBy(xpath = "//button[@class='MuiButtonBase-root MuiButton-root MuiButton-text MuiButton-textPrimary MuiButton-sizeMedium MuiButton-textSizeMedium MuiButton-root MuiButton-text MuiButton-textPrimary MuiButton-sizeMedium MuiButton-textSizeMedium css-f5765a']")
    private WebElement btnUtkLogout;

    @FindBy(xpath = "//button[normalize-space()='Logout']")
    private WebElement buttonLogout;

    @FindBy(xpath = "//input[@id='email']")
    private WebElement txtEmail;

    @FindBy(xpath = "//input[@id='password']")
    private WebElement txtPassword;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement buttonMasuk;

    @FindBy(xpath = "//div[@class='MuiBox-root css-8atqhb']")
    private WebElement divValidasiLogin;

    //@FindBy(xpath = "//p[normalize-space()='Izin']")
    @FindBy(xpath = "/html/body/div/div/div/div[1]/div[3]/div/div/div[3]/div/div/a/div")
    private WebElement btnIzin;


    public UserLoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public WebElement getDivValidasiHome() {
        GlobalFunction.delay(TIMEOUT_DELAY);
        return new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT_DELAY))
                .until(ExpectedConditions.visibilityOf(divValidasiHome));
    }
    public WebElement getBtnUtkLogout() {
        GlobalFunction.delay(TIMEOUT_DELAY);
        return new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT_DELAY))
                .until(ExpectedConditions.visibilityOf(btnUtkLogout));
    }
    public WebElement getButtonLogout() {
        GlobalFunction.delay(TIMEOUT_DELAY);
        return new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT_DELAY))
                .until(ExpectedConditions.visibilityOf(buttonLogout));
    }
    public WebElement getTxtEmail() {
        GlobalFunction.delay(TIMEOUT_DELAY);
        return new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT_DELAY))
                .until(ExpectedConditions.visibilityOf(txtEmail));
    }
    public WebElement getTxtPassword() {
        GlobalFunction.delay(TIMEOUT_DELAY);
        return new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT_DELAY))
                .until(ExpectedConditions.visibilityOf(txtPassword));
    }
    public WebElement getBtnMasuk() {
        GlobalFunction.delay(TIMEOUT_DELAY);
        return new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT_DELAY))
                .until(ExpectedConditions.visibilityOf(buttonMasuk));
    }
    public WebElement getDivValidasiLogin() {
        GlobalFunction.delay(TIMEOUT_DELAY);
        return new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT_DELAY))
                .until(ExpectedConditions.visibilityOf(divValidasiLogin));
    }

    public WebElement getBtnIzin(){
        GlobalFunction.delay(TIMEOUT_DELAY);
        return new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT_DELAY))
                .until(ExpectedConditions.visibilityOf(btnIzin));
    }

}
