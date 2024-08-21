package com.juaracoding.hkpujianta.ujianta.impl.user;

import com.juaracoding.hkpujianta.ujianta.impl.HadirHooks;
import com.juaracoding.hkpujianta.ujianta.page.user.IzinPage;
import com.juaracoding.hkpujianta.ujianta.page.user.UserLoginPage;
import com.juaracoding.hkpujianta.ujianta.util.Constants;
import com.juaracoding.hkpujianta.ujianta.util.GlobalFunction;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;

import java.util.List;

/*
IntelliJ IDEA 2024.1.4 (Ultimate Edition)
Build #IU-241.18034.62, built on June 21, 2024
@Author ITS-NEW a.k.a. Herlina Kurnia Prasetiani
Java Developer
Created on 18/08/2024 00:24
@Last Modified 18/08/2024 00:24
Version 1.0
*/
public class IzinTerlambatNegatif {

    public WebDriver driver;
    private static ExtentTest extentTest;
    private UserLoginPage userLoginPage;
    private IzinPage izinPage;
    private boolean isValid;

    public IzinTerlambatNegatif() {
        isValid = true;
        this.driver = HadirHooks.driver;
        userLoginPage = new UserLoginPage(driver);
        izinPage = new IzinPage(driver);
        extentTest = HadirHooks.extentTest;
    }

    @BeforeTest
    public void initials(){
        isValid = true;
    }

    @When("TIZNU003 Membuka Halaman Login")
    public void tiznu003_membuka_halaman_login(){
        this.driver.get(Constants.URL_LOGIN2);
        extentTest.log(LogStatus.PASS, "TIZNU003 Membuka Halaman Login");
    }
    @And("TIZNU003 Clear field input email dan password")
    public void tiznu003_clear_field_input_email_dan_password(){
        userLoginPage.getTxtEmail().clear();
        userLoginPage.getTxtPassword().clear();
        extentTest.log(LogStatus.PASS, "TIZNU003 Clear field input email dan password");
    }
    @And("TIZNU003 Masukan email dan password yang valid")
    public void tiznu003_masukan_email_dan_password_yang_valid(){
        userLoginPage.getTxtEmail().sendKeys("testuser@gmail.com");
        userLoginPage.getTxtPassword().sendKeys("testuser");
        extentTest.log(LogStatus.PASS, "TIZNU003 Masukan email dan password yang valid");
    }
    @When("TIZNU003 Tekan tombol Masuk")
    public void tiznu003_tekan_tombol_masuk(){
        userLoginPage.getBtnMasuk().click();
        extentTest.log(LogStatus.PASS, "TIZNU003 Tekan tombol Masuk");
    }
    @Then("TIZNU003 Validasi Halaman Home")
    public void tiznu003_validasi_halaman_home(){
        GlobalFunction.delay(2);
        if(userLoginPage.getDivValidasiHome().isDisplayed()){
            extentTest.log(LogStatus.PASS, "TIZNU003 Validasi Halaman Home");
            //extentTest.log(LogStatus.PASS, "TIZPU001 Validasi Halaman Home");
        }else{
            extentTest.log(LogStatus.FAIL, "TIZNU003 Validasi Halaman Home");
            //extentTest.log(LogStatus.FAIL, "TIZPU001 Validasi Halaman Home");
        }
    }
    @When("TIZNU003 Tekan tombol Izin")
    public void tiznu003_tekan_tombol_izin(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, document.body.scrollHeight * 0.25);");

        userLoginPage.getBtnIzin().click();
        extentTest.log(LogStatus.PASS, "TIZNU003 Tekan tombol Izin");
    }
    @Then("TIZNU003 Validasi Halaman Izin")
    public void tiznu003_validasi_halaman_izin(){
        GlobalFunction.delay(2);
        if(izinPage.getVarHalamanIzin().equals("")){
            extentTest.log(LogStatus.FAIL, "TIZNU003 Validasi Halaman Izin");
            //extentTest.log(LogStatus.FAIL, "TIZPU001 Validasi Halaman Izin");
        }else{
            extentTest.log(LogStatus.PASS, "TIZNU003 Validasi Halaman Izin");
            //extentTest.log(LogStatus.PASS, "TIZPU001 Validasi Halaman Izin");
        }
    }
    @When("TIZNU003 Tekan tombol Ajukan Izin Terlambat")
    public void tiznu003_tekan_tombol_ajukan_izin_terlambat(){
        izinPage.getBtnAjukanTerlambat().click();
        extentTest.log(LogStatus.PASS, "TIZNU003 Tekan tombol Ajukan Izin Terlambat");
    }
    @When("TIZNU003 Validasi form Ajukan Izin Terlambat")
    public void tiznu003_validasi_form_ajukan_izin_terlambat(){
        if(izinPage.getVarFormAjukanIzinTerlambat().equals("")){
            extentTest.log(LogStatus.FAIL, "TIZNU003 Validasi form Ajukan Izin Terlambat");
           // extentTest.log(LogStatus.FAIL, "TIZPU001 Validasi form Ajukan Izin Terlambat");
        }else{
            extentTest.log(LogStatus.PASS, "TIZNU003 Validasi form Ajukan Izin Terlambat");
            //extentTest.log(LogStatus.PASS, "TIZPU001 Validasi form Ajukan Izin Terlambat");
        }
    }
    @When("TIZNU003 Tekan tombol Ajukan")
    public void tiznu003_tekan_tombol_ajukan(){
        izinPage.getFormBtnAjukanTerlambat().click();
        extentTest.log(LogStatus.PASS, "TIZNU003 Tekan tombol Ajukan");
    }
    @When("TIZNU003 Validasi notifikasi setelah tekan tombol Ajukan")
    public void tiznu003_validasi_notifikasi_setelah_tekan_tombol_ajukan(){
        GlobalFunction.delay(2);

        WebElement elementDiv = driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/form/div"));
        List<WebElement> listP = elementDiv.findElements(By.tagName("p"));
        if(listP.get(0).getText().equals("") && listP.get(1).getText().equals("") && listP.get(2).getText().equals("")){
            extentTest.log(LogStatus.FAIL, "TIZNU003 Validasi notifikasi setelah tekan tombol Ajukan");
        }else{
            extentTest.log(LogStatus.PASS, "TIZNU003 Validasi notifikasi setelah tekan tombol Ajukan");
        }
    }
}
