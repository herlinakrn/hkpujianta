package com.juaracoding.hkpujianta.ujianta.page.admin;

import com.juaracoding.hkpujianta.ujianta.util.Constants;
import com.juaracoding.hkpujianta.ujianta.util.GlobalFunction;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import static com.juaracoding.hkpujianta.ujianta.util.Constants.TIMEOUT_DELAY;

/*
IntelliJ IDEA 2024.1.4 (Ultimate Edition)
Build #IU-241.18034.62, built on June 21, 2024
@Author ITS-NEW a.k.a. Herlina Kurnia Prasetiani
Java Developer
Created on 15/08/2024 09:35
@Last Modified 15/08/2024 09:35
Version 1.0
*/
public class UnitPage {
    private WebDriver driver;

    @FindBy(xpath = "//p[@class='MuiTypography-root MuiTypography-body1 css-1ub5lza'][normalize-space()='Management']")
    private WebElement varManagement;

    @FindBy(xpath = "//p[@class='MuiTypography-root MuiTypography-body1 css-aqx7sf'][normalize-space()='Unit']")
    private WebElement varUnit;

    @FindBy(xpath = "//p[@class='MuiTypography-root MuiTypography-body1 css-1kei35f']")
    private WebElement validasiUnit;

    @FindBy(xpath = "//h5[normalize-space()='LOKASI ABSEN TETAP']")
    private WebElement validasiLokasiAbsen;

    @FindBy(xpath = "//button[normalize-space()='Tambahkan']")
    private WebElement buttonTambahkan;

    @FindBy(xpath = "//h2[@id='alert-dialog-title']")
    private WebElement validasiModalTambahUnit;

    @FindBy(xpath = "//input[@id='name']")
    private WebElement txtFieldNamaUnit;

    @FindBy(xpath = "//input[@name='locationType']")
    private WebElement txtFieldLocationType;

    @FindBy(xpath = "//input[@id='calendar']")
    private WebElement txtFieldKalender;

    @FindBy(xpath = "//input[@id='unitLeave']")
    private WebElement txtFieldAturanUnit;

    @FindBy(xpath = "//div[@class='MuiSnackbarContent-message css-1w0ym84']")
    private WebElement varNotifikasi;

    @FindBy(xpath = "//p[@id='name-helper-text']")
    private WebElement varError;

    @FindBy(xpath = "//button[normalize-space()='Tambah']")
    private WebElement buttonModalTambah;

    @FindBy(xpath = "//div[@class='MuiSnackbarContent-message css-1w0ym84']")
    private WebElement varNotififasiBerhasil;

    @FindBy(xpath = "//input[@id='search']")
    private WebElement txtSearchField;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement buttonSearch;

    @FindBy(xpath = "//tbody/tr[1]/td[1]")
    private WebElement getColomNama;

//    @FindBy(xpath = "/html/body/div[13]/div[3]/div/form/div[1]/div/div[3]/div/div/div")
//    private WebElement getDropDownKalender;

    @FindBy(xpath = "/html/body/div[1]/div/div/div/div[1]/div/div/div/div[2]/div/table/tbody/tr[1]")
    private WebElement getTabelUnit;

    @FindBy(xpath = "//tbody/tr[1]/td[5]/div[1]/div[1]/button[1]//*[name()='svg']")
    private WebElement getTitikTiga;

    @FindBy(xpath = "//body/div[3]/div[3]/ul[1]/li[2]")
    private WebElement getEdit;

    @FindBy(xpath = "//h2[@id='alert-dialog-title']")
    private WebElement getModalEdit;

    @FindBy(xpath = "//button[normalize-space()='Simpan']")
    private WebElement btnSimpanEdit;

    @FindBy(xpath = "/html[1]/body[1]/div[3]/div[3]/ul[1]/li[3]")
    private WebElement getDelete;

    @FindBy(xpath = "//button[normalize-space()='Ya']")
    private WebElement btnYa;

    @FindBy(xpath = "//h2[@id='alert-dialog-slide-title']")
    private WebElement varHapusDepartements;


    public UnitPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public WebElement getVarManagement() {
        GlobalFunction.delay(TIMEOUT_DELAY);
        return new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT_DELAY))
                .until(ExpectedConditions.visibilityOf(varManagement));
    }

    public WebElement getVarUnit(){
        GlobalFunction.delay(TIMEOUT_DELAY);
        return new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT_DELAY))
                .until(ExpectedConditions.visibilityOf(varUnit));
    }

    public WebElement getValidasiUnit(){
        GlobalFunction.delay(TIMEOUT_DELAY);
        return new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT_DELAY))
                .until(ExpectedConditions.visibilityOf(validasiUnit));
    }

    public WebElement getValidasiLokasiAbsen(){
        GlobalFunction.delay(TIMEOUT_DELAY);
        return new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT_DELAY))
                .until(ExpectedConditions.visibilityOf(validasiLokasiAbsen));
    }

    public WebElement getButtonTambahkan(){
        GlobalFunction.delay(TIMEOUT_DELAY);
        return new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT_DELAY))
                .until(ExpectedConditions.visibilityOf(buttonTambahkan));
    }
    public WebElement getValidasiModalTambahUnit(){
        GlobalFunction.delay(TIMEOUT_DELAY);
        return new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT_DELAY))
                .until(ExpectedConditions.visibilityOf(validasiModalTambahUnit));
    }
    public WebElement getTxtFieldNamaUnit(){
        GlobalFunction.delay(TIMEOUT_DELAY);
        return new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT_DELAY))
                .until(ExpectedConditions.visibilityOf(txtFieldNamaUnit));
    }
    public WebElement getTxtFieldLocationType(){
        GlobalFunction.delay(TIMEOUT_DELAY);
        return new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT_DELAY))
                .until(ExpectedConditions.visibilityOf(txtFieldLocationType));
    }
    public WebElement getTxtFieldKalender(){
        GlobalFunction.delay(TIMEOUT_DELAY);
        return new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT_DELAY))
                .until(ExpectedConditions.visibilityOf(txtFieldKalender));
    }
    public List<WebElement> getKalender() {
        List<WebElement> kalender = new ArrayList<>();
        //WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT_DELAY));
        try {
            List<WebElement> optionElements = txtFieldKalender.findElements(By.id("calender"));

            // Iterasi dan ambil teks dari setiap elemen <option>
            for (WebElement option : optionElements) {
                kalender.add(option);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return kalender;
    }
    public WebElement getTxtFieldAturanUnit(){
        GlobalFunction.delay(TIMEOUT_DELAY);
        return new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT_DELAY))
                .until(ExpectedConditions.visibilityOf(txtFieldAturanUnit));
    }
    public WebElement getVarNotifikasi(){
        GlobalFunction.delay(TIMEOUT_DELAY);
        return new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT_DELAY))
                .until(ExpectedConditions.visibilityOf(varNotifikasi));
    }
    public WebElement getVarError(){
        GlobalFunction.delay(TIMEOUT_DELAY);
        return new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT_DELAY))
                .until(ExpectedConditions.visibilityOf(varError));
    }
    public WebElement getButtonModalTambah(){
        GlobalFunction.delay(TIMEOUT_DELAY);
        return new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT_DELAY))
                .until(ExpectedConditions.visibilityOf(buttonModalTambah));
    }
    public  WebElement getVarNotififasiBerhasil(){
        GlobalFunction.delay(TIMEOUT_DELAY);
        return new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT_DELAY))
                .until(ExpectedConditions.visibilityOf(varNotififasiBerhasil));
    }
    public WebElement getTxtSearchField(){
        GlobalFunction.delay(TIMEOUT_DELAY);
        return new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT_DELAY))
                .until(ExpectedConditions.visibilityOf(txtSearchField));
    }
    public WebElement getButtonSearch(){
        GlobalFunction.delay(TIMEOUT_DELAY);
        return new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT_DELAY))
                .until(ExpectedConditions.visibilityOf(buttonSearch));
    }
    public WebElement getGetColomNama(){
        GlobalFunction.delay(TIMEOUT_DELAY);
        return new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT_DELAY))
                .until(ExpectedConditions.visibilityOf(getColomNama));
    }

    public String getTabelUnit(){
        return  new WebDriverWait(driver, Duration.ofSeconds(Constants.TIMEOUT))
                .until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(
                        "//tbody/tr[1]/td[1]")))).getText();
    }

    public WebElement getBtnTitikTiga(){
        GlobalFunction.delay(TIMEOUT_DELAY);
        return new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT_DELAY))
                .until(ExpectedConditions.visibilityOf(getTitikTiga));
    }

    public WebElement getBtnEdit(){
        GlobalFunction.delay(TIMEOUT_DELAY);
        return new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT_DELAY))
                .until(ExpectedConditions.visibilityOf(getEdit));
    }

    public WebElement getFormModalEdit(){
        GlobalFunction.delay(TIMEOUT_DELAY);
        return new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT_DELAY))
                .until(ExpectedConditions.visibilityOf(getModalEdit));
    }
    public WebElement getBtnSimpanEdit(){
        GlobalFunction.delay(TIMEOUT_DELAY);
        return new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT_DELAY))
                .until(ExpectedConditions.visibilityOf(btnSimpanEdit));
    }
    public WebElement getBtnDelete(){
        GlobalFunction.delay(TIMEOUT_DELAY);
        return new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT_DELAY))
                .until(ExpectedConditions.visibilityOf(getDelete));
    }
    public WebElement getBtnYa(){
        GlobalFunction.delay(TIMEOUT_DELAY);
        return new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT_DELAY))
                .until(ExpectedConditions.visibilityOf(btnYa));
    }
    public WebElement getVarHapusDepartements(){
        GlobalFunction.delay(TIMEOUT_DELAY);
        return new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT_DELAY))
                .until(ExpectedConditions.visibilityOf(varHapusDepartements));
    }
}
