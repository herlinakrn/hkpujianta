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
Created on 12/08/2024 15:57
@Last Modified 12/08/2024 15:57
Version 1.0
*/
public class HomePage {

    private WebDriver driver;

    @FindBy(xpath = "//h2[normalize-space()='Validator 1']")
    private WebElement labelValidasi;

    @FindBy(xpath = "//p[normalize-space()='© 2022 Aplikasi Hadir']")
    private WebElement labelAplikasiHadir;

    @FindBy(xpath = "//div[@class='MuiBox-root css-6eu2y8']//*[name()='svg']")
    private WebElement labelProfil;

    @FindBy(xpath = "//button[normalize-space()='Logout']")
    private WebElement buttonLogout;

    public HomePage (WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public WebElement getValidasiLabelValidasi() {
        GlobalFunction.delay(Constants.TIMEOUT_DELAY);
        return new WebDriverWait(driver, Duration.ofSeconds(Constants.TIMEOUT_DELAY))
                .until(ExpectedConditions.visibilityOf(labelValidasi));
    }

    public WebElement getLabelProfil() {
        GlobalFunction.delay(Constants.TIMEOUT_DELAY);
        return new WebDriverWait(driver, Duration.ofSeconds(Constants.TIMEOUT_DELAY))
                .until(ExpectedConditions.visibilityOf(labelProfil));
    }

    public WebElement getButtonLogout() {
        GlobalFunction.delay(Constants.TIMEOUT_DELAY);
        return new WebDriverWait(driver, Duration.ofSeconds(Constants.TIMEOUT_DELAY))
                .until(ExpectedConditions.visibilityOf(buttonLogout));
    }

    public WebElement getLabelAplikasiHadir() {
        GlobalFunction.delay(Constants.TIMEOUT_DELAY);
        return new WebDriverWait(driver, Duration.ofSeconds(Constants.TIMEOUT_DELAY))
                .until(ExpectedConditions.visibilityOf(labelAplikasiHadir));
    }

}
