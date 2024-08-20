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
Created on 13/08/2024 10:01
@Last Modified 13/08/2024 10:01
Version 1.0
*/
public class RegistrasiUser {

    private WebDriver driver;

    @FindBy(xpath = "//p[@class='MuiTypography-root MuiTypography-body1 css-1ub5lza'][normalize-space()='Management']")
    private WebElement varManagement;

    @FindBy(xpath = "//p[normalize-space()='Pendaftaran User']")
    private WebElement varPendaftaranUser;

    @FindBy(xpath = "//h1[@class='MuiTypography-root MuiTypography-h1 css-czbdxj']")
    private WebElement labelValidasiRegisterUser;

    @FindBy(xpath = "//div[contains(text(),'Account Information')]")
    private WebElement labelValidasiAccountInformation;

    @FindBy(xpath = "//label[@role='button']")
    private WebElement buttonUploadFoto;

    @FindBy(xpath = "//input[@id='logo']")
    private WebElement uploadFoto;

    @FindBy(xpath = "//input[@id='nik']")
    private WebElement txtFieldNIK;

    @FindBy(xpath = "//input[@id='email']")
    private WebElement txtFieldEmail;

    @FindBy(xpath = "//input[@id='fullname']")
    private WebElement txtFieldNamaKaryawan;

    @FindBy(xpath = "//input[@id='password']")
    private WebElement txtFieldPassword;

    @FindBy(xpath = "//input[@id='divisi']")
    private WebElement txtFieldDivisi;

    @FindBy(xpath = "//input[@id='unit']")
    private WebElement txtFieldUnit;

    @FindBy(xpath = "//input[@id='posisi-kerja']")
    private WebElement txtFieldPosisiKerja;

    @FindBy(xpath = "//input[@id='jabatan']")
    private WebElement txtFieldJabatan;

    @FindBy(xpath = "//input[@id='atasan']")
    private WebElement txtFieldAtasan;

    @FindBy(xpath = "//input[@id='atasan-v2']")
    private WebElement txtFieldAtasanV2;

    @FindBy(xpath = "//input[@id='atasan-v3']")
    private WebElement txtFieldAtasanV3;

    @FindBy(xpath = "//input[@id='tipe-kontrak']")
    private WebElement txtFieldTipeKontrak;

    @FindBy(xpath = "//li[@id='tipe-kontrak-option']")
    private WebElement txtFieldTipeKontrakPKWT;

    @FindBy(xpath = "//input[@id='lokasi-kerja']")
    private WebElement txtFieldLokasiKerja;

    @FindBy(xpath = "//div[@id='shift_type']")
//    @FindBy(xpath = "//div[@id='tipe-shift menu-shift_type']")
    //@FindBy(xpath = "//div[@id='shift_type']")
    //@FindBy(xpath = "//*[@id=\"__next\"]/div/div[2]/div/div[1]/div/div/div[2]" +"/form/div[6]/div/div[2]/div/input")
    private WebElement txtFieldShiftType;

    @FindBy(xpath = "//input[@id='menu-shift_type']")
    private WebElement txtFieldMenuShiftType;

    @FindBy(xpath = "//input[@id='jadwal-kerja']")
    private WebElement txtFieldJadwalKerja;

    @FindBy(xpath = "//div[@id='required_selfie']")
    private WebElement txtFieldRequiredSelfie;

    @FindBy(xpath = "//*[@id=\"menu-required_selfie\"]/div[3]")
    private WebElement txtFieldRequiredSelfieList;

    @FindBy(xpath = "//input[@id='jumlah-cuti']")
    private WebElement txtFieldJumlahCuti;

    @FindBy(xpath = "//button[@id='submit']")
    private WebElement buttonSumbit;

    //untuk validasi

    @FindBy(xpath = "//div[normalize-space()='Nama']")
    private WebElement comboSearch;

    //@FindBy(xpath = "//*[@id="menu-"]/div[3]")
    //@FindBy(xpath = "//li[normalize-space()='Nik']")
   // private WebElement searchByNIK;

    @FindBy(xpath = "//*[@id=\"menu-\"]/div[3]")
    private WebElement searchByNIK;

    @FindBy(xpath = "/html/body/div[1]/div/div[2]/div/div[1]/div/div[2]/div/div[2]/div/table/tbody/tr[2]/td[2]")
    private WebElement getTabel;

    @FindBy(xpath = "/html/body/div[1]/div/div[2]/div/div[1]/div/div[2]/div/div[2]/div/table/tbody/tr[2]/td[2]/div/h6[1]")
    private WebElement tableNIK;

    @FindBy(xpath = "//input[@id='search']")
    private WebElement textFieldSearch;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement buttonSearch;

    @FindBy(xpath = "//tbody/tr[2]/td[7]/div[1]/div[1]/button[1]//*[name()='svg']")
    private WebElement buttonTitikTiga;

    @FindBy(xpath = "/html[1]/body[1]/div[3]/div[3]/ul[1]/li[1]")
    private WebElement varLihatSisaCuti;

    @FindBy(xpath = "//h2[@id='alert-dialog-slide-title']")
    private WebElement varModalJudulLihatSisaCuti;

    @FindBy(xpath = "//body//div[@role='presentation']//div[@role='presentation']//li[1]")
    private WebElement varTotalCuti;

    @FindBy(xpath = "//button[normalize-space()='Tutup']")
    private WebElement buttonModalTutup;

    @FindBy(xpath = "//*[@id=\"__next\"]/div/div[2]/div/div[1]/div/div[1]/div/div[2]/div/form/div/div/div[1]/div[1]")
    private WebElement btnChangeBy;

    public RegistrasiUser(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public WebElement getVarManagement(){
        GlobalFunction.delay(TIMEOUT_DELAY);
        return new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT_DELAY))
                .until(ExpectedConditions.visibilityOf(varManagement));
    }
    public WebElement getVarPendaftaranUser(){
        GlobalFunction.delay(TIMEOUT_DELAY);
        return new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT_DELAY))
                .until(ExpectedConditions.visibilityOf(varPendaftaranUser));
    }
    public WebElement getLabelValidasiRegisterUser(){
        GlobalFunction.delay(TIMEOUT_DELAY);
        return new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT_DELAY))
                .until(ExpectedConditions.visibilityOf(labelValidasiRegisterUser));
    }
    public WebElement getLabelValidasiAccountInformation(){
        GlobalFunction.delay(TIMEOUT_DELAY);
        return new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT_DELAY))
                .until(ExpectedConditions.visibilityOf(labelValidasiAccountInformation));
    }
    public WebElement getButtonUploadFoto(){
        GlobalFunction.delay(TIMEOUT_DELAY);
        return new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT_DELAY))
                .until(ExpectedConditions.visibilityOf(buttonUploadFoto));
    }

    public WebElement getUploadFoto(){
        GlobalFunction.delay(TIMEOUT_DELAY);
        return new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT_DELAY))
                .until(ExpectedConditions.visibilityOf(uploadFoto));
    }

    public WebElement getTxtFieldNIK(){
        GlobalFunction.delay(TIMEOUT_DELAY);
        return new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT_DELAY))
                .until(ExpectedConditions.visibilityOf(txtFieldNIK));
    }
    public WebElement getTxtFieldEmail(){
        GlobalFunction.delay(TIMEOUT_DELAY);
        return new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT_DELAY))
                .until(ExpectedConditions.visibilityOf(txtFieldEmail));
    }
    public WebElement getTxtFieldNamaKaryawan(){
        GlobalFunction.delay(TIMEOUT_DELAY);
        return new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT_DELAY))
                .until(ExpectedConditions.visibilityOf(txtFieldNamaKaryawan));
    }
    public WebElement getTxtFieldPassword(){
        GlobalFunction.delay(TIMEOUT_DELAY);
        return new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT_DELAY))
                .until(ExpectedConditions.visibilityOf(txtFieldPassword));
    }

    public WebElement getTxtFieldDivisi(){
        GlobalFunction.delay(TIMEOUT_DELAY);
        return new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT_DELAY))
                .until(ExpectedConditions.visibilityOf(txtFieldDivisi));
    }
    public WebElement getTxtFieldUnit(){
        GlobalFunction.delay(TIMEOUT_DELAY);
        return new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT_DELAY))
                .until(ExpectedConditions.visibilityOf(txtFieldUnit));
    }
    public WebElement getTxtFieldPosisiKerja(){
        GlobalFunction.delay(TIMEOUT_DELAY);
        return new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT_DELAY))
                .until(ExpectedConditions.visibilityOf(txtFieldPosisiKerja));
    }
    public WebElement getTxtFieldJabatan(){
        GlobalFunction.delay(TIMEOUT_DELAY);
        return new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT_DELAY))
                .until(ExpectedConditions.visibilityOf(txtFieldJabatan));
    }
    public WebElement getTxtFieldAtasan(){
        GlobalFunction.delay(TIMEOUT_DELAY);
        return new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT_DELAY))
                .until(ExpectedConditions.visibilityOf(txtFieldAtasan));
    }
    public WebElement getTxtFieldAtasanV2(){
        GlobalFunction.delay(TIMEOUT_DELAY);
        return new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT_DELAY))
                .until(ExpectedConditions.visibilityOf(txtFieldAtasanV2));
    }
    public WebElement getTxtFieldAtasanV3(){
        GlobalFunction.delay(TIMEOUT_DELAY);
        return new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT_DELAY))
                .until(ExpectedConditions.visibilityOf(txtFieldAtasanV3));
    }
    public WebElement getTxtFieldTipeKontrak(){
        GlobalFunction.delay(TIMEOUT_DELAY);
        return new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT_DELAY))
                .until(ExpectedConditions.visibilityOf(txtFieldTipeKontrak));
    }
//    public WebElement getTxtFieldTipeKontrakPKWT(){
//        GlobalFunction.delay(Constants.TIMEOUT_DELAY);
//        return new WebDriverWait(driver, Duration.ofSeconds(Constants.TIMEOUT_DELAY))
//                .until(ExpectedConditions.visibilityOf(txtFieldTipeKontrakPKWT));
//    }
    public WebElement getTxtFieldLokasiKerja(){
        GlobalFunction.delay(TIMEOUT_DELAY);
        return new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT_DELAY))
                .until(ExpectedConditions.visibilityOf(txtFieldLokasiKerja));
    }
    public WebElement getTxtFieldShiftType(){
        GlobalFunction.delay(TIMEOUT_DELAY);
        return new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT_DELAY))
                .until(ExpectedConditions.visibilityOf(txtFieldShiftType));
    }
    public WebElement getTxtFieldMenuShiftType(){
        GlobalFunction.delay(TIMEOUT_DELAY);
        return new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT_DELAY))
                .until(ExpectedConditions.visibilityOf(txtFieldMenuShiftType));
    }
    public String getTxtFieldShiftList() {
        return  new WebDriverWait(driver, Duration.ofSeconds(Constants.TIMEOUT))
                .until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(
                        "/html/body/div[3]/div[3]")))).getText();
    }
    public WebElement getTxtFieldJadwalKerja(){
        GlobalFunction.delay(TIMEOUT_DELAY);
        return new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT_DELAY))
                .until(ExpectedConditions.visibilityOf(txtFieldJadwalKerja));
    }
    public WebElement getTxtFieldRequiredSelfie(){
        GlobalFunction.delay(Constants.TIMEOUT_DELAY);
        return new WebDriverWait(driver, Duration.ofSeconds(Constants.TIMEOUT_DELAY))
                .until(ExpectedConditions.visibilityOf(txtFieldRequiredSelfie));
    }
    public List<WebElement> getTxtFieldSelfieList() {
        List<WebElement> selfieList = new ArrayList<>();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT_DELAY));
        try {
            // Tunggu hingga elemen <select> dengan XPath terlihat
            WebElement selectElement = wait.until(ExpectedConditions.visibilityOf(txtFieldRequiredSelfie));

            // Temukan semua elemen <option> di dalam elemen <select>
            List<WebElement> optionElements = new WebDriverWait(driver, Duration.ofSeconds(Constants.TIMEOUT_DELAY))
                    .until(ExpectedConditions.visibilityOf(txtFieldRequiredSelfieList)).findElement(By.tagName("ul")).findElements(By.tagName("li"));

            // Iterasi dan ambil teks dari setiap elemen <option>
            for (WebElement option : optionElements) {
                selfieList.add(option);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return selfieList;
    }

    public WebElement getTxtFieldJumlahCuti(){
        GlobalFunction.delay(TIMEOUT_DELAY);
        return new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT_DELAY))
                .until(ExpectedConditions.visibilityOf(txtFieldJumlahCuti));
    }
    public WebElement getButtonSumbit(){
        GlobalFunction.delay(TIMEOUT_DELAY);
        return new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT_DELAY))
                .until(ExpectedConditions.visibilityOf(buttonSumbit));
    }
    public WebElement getComboNama(){
        GlobalFunction.delay(TIMEOUT_DELAY);
        return new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT_DELAY))
                .until(ExpectedConditions.visibilityOf(comboSearch));
    }
    public List<WebElement> getSearchByNIK() {
        List<WebElement> selfieList = new ArrayList<>();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT_DELAY));
        try {
            // Tunggu hingga elemen <select> dengan XPath terlihat
            //WebElement selectElement = wait.until(ExpectedConditions.visibilityOf(btnChangeBy));

            // Temukan semua elemen <option> di dalam elemen <select>
//            List<WebElement> optionElements =new WebDriverWait(driver, Duration.ofSeconds(Constants.TIMEOUT))
//                    .until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("/html/body/div[13]/div[3]"))))
//                    .findElement(By.tagName("ul")).findElements(By.tagName("li"));
            List<WebElement> optionElements = searchByNIK.findElements(By.tagName("li"));

            // Iterasi dan ambil teks dari setiap elemen <option>
            for (WebElement option : optionElements) {
                selfieList.add(option);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return selfieList;
    }

    public WebElement getTextFieldSearch(){
        GlobalFunction.delay(TIMEOUT_DELAY);
        return new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT_DELAY))
                .until(ExpectedConditions.visibilityOf(textFieldSearch));
    }
    public WebElement getButtonSearch(){
        GlobalFunction.delay(TIMEOUT_DELAY);
        return new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT_DELAY))
                .until(ExpectedConditions.visibilityOf(buttonSearch));
    }

//    public String getTabelNIK(){
////        List<String> tableData = new ArrayList<>();
////
////        List<WebElement> cells = new WebDriverWait(driver, Duration.ofSeconds(Constants.TIMEOUT))
////                .until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/div[1]/div/div[2]/div/div[2]/div/table/tbody/tr[2]/td[2]"))))
////                .findElements(By.xpath("/html/body/div[1]/div/div[2]/div/div[1]/div/div[2]/div/div[2]/div/table/tbody/tr[2]/td[2]/div/h6[1]"));
////        for (int i = 0; i < cells.size(); i++) {
////            tableData.add(cells.get(i).getText());
////        }
//        return new WebDriverWait(driver, Duration.ofSeconds(Constants.TIMEOUT))
//                .until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("\"//*[@id=\"__next\"]/div/div[2]/div/div[1]/div/div[2]/div/div[2]/div/table/tbody/tr[2]/td[2]/div/h6[1]\"))).getText();
//    }
    public String getTabelNIK(){
        return  new WebDriverWait(driver, Duration.ofSeconds(Constants.TIMEOUT))
                .until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(
                        "//*[@id=\"__next\"]/div/div[2]/div/div[1]/div/div[2]/div/div[2]/div/table/tbody/tr[2]/td[2]/div/h6[1]")))).getText();
    }

    public String getTabelNama(){
        return  new WebDriverWait(driver, Duration.ofSeconds(Constants.TIMEOUT))
                .until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(
                        "/html/body/div[1]/div/div/div/div[1]/div/div[2]/div/div[2]/div/table/tbody/tr[5]/td[2]/div/h5")))).getText();
    }
}
