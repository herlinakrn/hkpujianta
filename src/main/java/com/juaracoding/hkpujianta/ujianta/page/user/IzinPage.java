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
Created on 17/08/2024 19:05
@Last Modified 17/08/2024 19:05
Version 1.0
*/
public class IzinPage {
    private WebDriver driver;

    @FindBy(xpath = "//p[@class='MuiTypography-root MuiTypography-body1 css-15et00z']")
    private WebElement varHalamanIzin;

    @FindBy(xpath = "//button[normalize-space()='Ajukan Izin Terlambat']")
    private WebElement btnAjukanTerlambat;

    @FindBy(xpath = "//p[@class='MuiTypography-root MuiTypography-body1 css-1bthjtb']")
    private WebElement varFormAjukanIzinTerlambat;

    @FindBy(xpath = "/html/body/div[2]/div[3]/div/form/div/div[1]/div/div")
    private WebElement divTanggal;

    @FindBy(xpath = "//input[@id='mui-1']")
    //@FindBy(xpath = "//*[@id=\"mui-31\"]")
    private WebElement txtFieldTanggalTeelambat;

    @FindBy(xpath = "//input[@id='mui-2']")
    private WebElement txtFieldJamTerlambat;

    @FindBy(xpath = "//textarea[@id='notes']")
    private WebElement txtFieldKeteranganTerlambat;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement btnFormAjukanTerlambat;

    @FindBy(xpath = "//div[@class='MuiCardContent-root css-1qw96cp']")
    private WebElement validasiHasilIzinTerlambat;

    @FindBy(xpath = "//button[@class='MuiButtonBase-root MuiButton-root MuiButton-text MuiButton-textPrimary MuiButton-sizeMedium MuiButton-textSizeMedium MuiButton-root MuiButton-text MuiButton-textPrimary MuiButton-sizeMedium MuiButton-textSizeMedium css-f5765a']")
    private WebElement btnKembali;

    @FindBy(xpath = "//p[@id='mui-1-helper-text']")
    private WebElement errorLogTanggalTerlambat;

    @FindBy(xpath = "//p[@id='mui-2-helper-text']")
    private WebElement errorLogJamTerlambat;

    @FindBy(xpath = "//p[@id='notes-helper-text']")
    private WebElement errorLogKeteranganTerlambat;

    @FindBy(xpath = "//button[normalize-space()='Izin Off']")
    private WebElement btnIzinOff;

    @FindBy(xpath = "//p[@class='MuiTypography-root MuiTypography-body1 css-ro47yx']")
    private WebElement validasiListIzinOff;

    @FindBy(xpath = "//button[normalize-space()='Ajukan Izin Off']")
    private WebElement btnAjukanIzinOff;

    @FindBy(xpath = "//body/div[@id='__next']/div[@class='MuiContainer-root MuiContainer-maxWidthSm css-1cd81x']/div[@class='MuiBox-root css-1ejni00']/div[@class='MuiBox-root css-0']/div[@class='MuiBox-root css-ec24e']/div[@id='mui-p-3650-P-off-permit']/div[@class='infinite-scroll-component__outerdiv']/div[contains(@class,'infinite-scroll-component')]/div[1]/div[1]")
    private WebElement validasiDivHasilIzinOff;

    @FindBy(xpath = "//p[@class='MuiTypography-root MuiTypography-body1 css-1bthjtb']")
    private WebElement validasiFormIzinOff;

    @FindBy(xpath = "//textarea[@id='reason']")
    private WebElement txtAlasanOff;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement btnFormAjukanIzinOff;

    @FindBy(xpath = "/html/body/div/div/div[3]/div/div[2]/div[3]/div[1]/p[2]")
    WebElement labelCountData ;


    public IzinPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public WebElement getVarHalamanIzin() {
        GlobalFunction.delay(TIMEOUT_DELAY);
        return new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT_DELAY))
                .until(ExpectedConditions.visibilityOf(varHalamanIzin));
    }
    public WebElement getBtnAjukanTerlambat() {
        GlobalFunction.delay(TIMEOUT_DELAY);
        return new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT_DELAY))
                .until(ExpectedConditions.visibilityOf(btnAjukanTerlambat));
    }
    public WebElement getVarFormAjukanIzinTerlambat(){
        GlobalFunction.delay(TIMEOUT_DELAY);
        return new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT_DELAY))
                .until(ExpectedConditions.visibilityOf(varFormAjukanIzinTerlambat));
    }
//    public WebElement getDivTanggal(){
//        GlobalFunction.delay(TIMEOUT_DELAY);
//        return new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT_DELAY))
//                .until(ExpectedConditions.visibilityOf(divTanggal));
//    }
    public WebElement getTxtFieldTanggalTerlambat() {
        GlobalFunction.delay(TIMEOUT_DELAY);
        return new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT_DELAY))
                .until(ExpectedConditions.visibilityOf(txtFieldTanggalTeelambat));
    }
    public  WebElement getTxtFieldJamTerlambat() {
        GlobalFunction.delay(TIMEOUT_DELAY);
        return new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT_DELAY))
                .until(ExpectedConditions.visibilityOf(txtFieldJamTerlambat));
    }
    public  WebElement getTxtFieldKeteranganTerlambat() {
        GlobalFunction.delay(TIMEOUT_DELAY);
        return new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT_DELAY))
                .until(ExpectedConditions.visibilityOf(txtFieldKeteranganTerlambat));
    }
    public WebElement getFormBtnAjukanTerlambat() {
        GlobalFunction.delay(TIMEOUT_DELAY);
        return new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT_DELAY))
                .until(ExpectedConditions.visibilityOf(btnFormAjukanTerlambat));
    }
    public WebElement getBtnKembali() {
        GlobalFunction.delay(TIMEOUT_DELAY);
        return new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT_DELAY))
                .until(ExpectedConditions.visibilityOf(btnKembali));
    }
    public WebElement getDivValidasiIzinTerlambat() {
        GlobalFunction.delay(TIMEOUT_DELAY);
        return new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT_DELAY))
                .until(ExpectedConditions.visibilityOf(validasiHasilIzinTerlambat));
    }
    public WebElement getErrorLogTanggalTerlambat(){
        GlobalFunction.delay(TIMEOUT_DELAY);
        return new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT_DELAY))
                .until(ExpectedConditions.visibilityOf(errorLogJamTerlambat));
    }
    public WebElement getErrorLogJamTerlambat(){
        GlobalFunction.delay(TIMEOUT_DELAY);
        return new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT_DELAY))
                .until(ExpectedConditions.visibilityOf(errorLogJamTerlambat));
    }
    public WebElement getErrorLogKeteranganTerlambat(){
        GlobalFunction.delay(TIMEOUT_DELAY);
        return new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT_DELAY))
                .until(ExpectedConditions.visibilityOf(errorLogKeteranganTerlambat));
    }
    public WebElement getBtnIzinOff(){
        GlobalFunction.delay(TIMEOUT_DELAY);
        return new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT_DELAY))
                .until(ExpectedConditions.visibilityOf(btnIzinOff));
    }
    public WebElement getValidasiListIzinOff(){
        GlobalFunction.delay(TIMEOUT_DELAY);
        return new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT_DELAY))
                .until(ExpectedConditions.visibilityOf(validasiListIzinOff));
    }
    public WebElement getValidasiDivHasilIzinOff(){
        GlobalFunction.delay(TIMEOUT_DELAY);
        return new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT_DELAY))
                .until(ExpectedConditions.visibilityOf(validasiDivHasilIzinOff));
    }
    public WebElement getBtnAjukanIzinOff(){
        GlobalFunction.delay(TIMEOUT_DELAY);
        return new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT_DELAY))
                .until(ExpectedConditions.visibilityOf(btnAjukanIzinOff));
    }
    public WebElement getValidasiFormIzinOff(){
        GlobalFunction.delay(TIMEOUT_DELAY);
        return new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT_DELAY))
                .until(ExpectedConditions.visibilityOf(validasiFormIzinOff));
    }
    public WebElement getTxtAlasanOff(){
        GlobalFunction.delay(TIMEOUT_DELAY);
        return new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT_DELAY))
                .until(ExpectedConditions.visibilityOf(txtAlasanOff));
    }
    public WebElement getBtnFormAjukanIzinOff(){
        GlobalFunction.delay(TIMEOUT_DELAY);
        return new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT_DELAY))
                .until(ExpectedConditions.visibilityOf(btnFormAjukanIzinOff));
    }

    public WebElement getLabelCountData(){
        GlobalFunction.delay(TIMEOUT_DELAY);
        return new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT_DELAY))
                .until(ExpectedConditions.visibilityOf(labelCountData));
    }
}
