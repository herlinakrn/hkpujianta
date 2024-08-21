package com.juaracoding.hkpujianta.ujianta.page.admin;

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
Created on 17/08/2024 00:00
@Last Modified 17/08/2024 00:00
Version 1.0
*/
public class UserMonitoring {
    private WebDriver driver;

    @FindBy(xpath = "//p[@class='MuiTypography-root MuiTypography-body1 css-1ub5lza'][normalize-space()='Management']")
    private WebElement varManagement;

    @FindBy(xpath = "//p[@class='MuiTypography-root MuiTypography-body1 css-aqx7sf'][normalize-space()='User Monitoring']")
    private WebElement varUserMonitoring;

    @FindBy(xpath = "//p[@class='MuiTypography-root MuiTypography-body1 css-1kei35f']")
    private WebElement varValidasiUserMonitoring;

    @FindBy(xpath = "//button[normalize-space()='Tambahkan']")
    private WebElement btnTambahkan;

    @FindBy(xpath = "//h1[@class='MuiTypography-root MuiTypography-h1 css-czbdxj']")
    private WebElement varAddUserMonitoring;

    @FindBy(xpath = "//input[@id='free-solo-with-text-demo']")
    private WebElement txtFieldUnit;

    @FindBy(xpath = "//input[@id='search']")
    private WebElement txtSearch;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement btnSearch;

    @FindBy(xpath = "//tbody/tr[1]/td[6]/div[1]/div[1]/button[1]")
    private WebElement btnTitikTiga;

    @FindBy(xpath = "//body/div[3]/div[3]/ul[1]/li[1]")
    private WebElement btnEdit;

    @FindBy(xpath = "//input[@id='fullname']")
    private WebElement txtFullName;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement btnSubmitEdit;

    @FindBy(xpath = "//h1[@class='MuiTypography-root MuiTypography-h1 css-czbdxj']")
    private WebElement varEditUserMonitoring;


    public UserMonitoring(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public WebElement getVarManagement() {
        GlobalFunction.delay(TIMEOUT_DELAY);
        return new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT_DELAY))
                .until(ExpectedConditions.visibilityOf(varManagement));
    }

    public WebElement getVarUserMonitoring(){
        GlobalFunction.delay(TIMEOUT_DELAY);
        return new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT_DELAY))
                .until(ExpectedConditions.visibilityOf(varUserMonitoring));
    }
    public WebElement getVarValidasiUserMonitoring(){
        GlobalFunction.delay(TIMEOUT_DELAY);
        return new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT_DELAY))
                .until(ExpectedConditions.visibilityOf(varValidasiUserMonitoring));
    }

    public WebElement getBtnTambahkan() {
        GlobalFunction.delay(TIMEOUT_DELAY);
        return new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT_DELAY))
                .until(ExpectedConditions.visibilityOf(btnTambahkan));
    }
    public WebElement getVarAddUserMonitoring(){
        GlobalFunction.delay(TIMEOUT_DELAY);
        return new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT_DELAY))
                .until(ExpectedConditions.visibilityOf(varAddUserMonitoring));
    }
    public WebElement getTxtFieldUnit() {
        GlobalFunction.delay(TIMEOUT_DELAY);
        return new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT_DELAY))
                .until(ExpectedConditions.visibilityOf(txtFieldUnit));
    }
    public WebElement getTxtSearch(){
        GlobalFunction.delay(TIMEOUT_DELAY);
        return new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT_DELAY))
                .until(ExpectedConditions.visibilityOf(txtSearch));
    }
    public WebElement getBtnSearch() {
        GlobalFunction.delay(TIMEOUT_DELAY);
        return new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT_DELAY))
                .until(ExpectedConditions.visibilityOf(btnSearch));
    }
    public WebElement getBtnTitikTiga(){
        GlobalFunction.delay(TIMEOUT_DELAY);
        return new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT_DELAY))
                .until(ExpectedConditions.visibilityOf(btnTitikTiga));
    }
    public WebElement getBtnEdit(){
        GlobalFunction.delay(TIMEOUT_DELAY);
        return new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT_DELAY))
                .until(ExpectedConditions.visibilityOf(btnEdit));
    }
    public WebElement getTxtFullName(){
        GlobalFunction.delay(TIMEOUT_DELAY);
        return new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT_DELAY))
                .until(ExpectedConditions.visibilityOf(txtFullName));
    }
    public WebElement getBtnSubmitEdit(){
        GlobalFunction.delay(TIMEOUT_DELAY);
        return new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT_DELAY))
                .until(ExpectedConditions.visibilityOf(btnSubmitEdit));
    }
    public WebElement getVarEditUserMonitoring(){
        GlobalFunction.delay(TIMEOUT_DELAY);
        return new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT_DELAY))
                .until(ExpectedConditions.visibilityOf(varEditUserMonitoring));
    }
}
