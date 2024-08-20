package com.juaracoding.hkpujianta.ujianta.impl.admin;

import com.juaracoding.hkpujianta.ujianta.impl.HadirHooks;
import com.juaracoding.hkpujianta.ujianta.page.admin.LoginPage;
import com.juaracoding.hkpujianta.ujianta.util.Constants;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;

/*
IntelliJ IDEA 2024.1.4 (Ultimate Edition)
Build #IU-241.18034.62, built on June 21, 2024
@Author ITS-NEW a.k.a. Herlina Kurnia Prasetiani
Java Developer
Created on 12/08/2024 15:57
@Last Modified 12/08/2024 15:57
Version 1.0
*/

public class LoginNegatif {
    public WebDriver driver;
    private static ExtentTest extentTest;
    private LoginPage loginPage;
    private boolean isValid;

    public LoginNegatif() {
        isValid = true;
        this.driver = HadirHooks.driver;
        loginPage = new LoginPage(driver);
        extentTest = HadirHooks.extentTest;
    }

    @BeforeTest
    public void initials(){
        isValid = true;
    }

    //TLNA002 - Login dengan menggunakan email dan password yang kosong
    @When("TLNA002 Clear field email dan password")
    public void tlna002_Clear_field_email_dan_password() {
        this.driver.get(Constants.URL_LOGIN); //buka url

        loginPage.getTxtFieldEmail().clear();
        loginPage.getTxtFieldPassword().clear();
        extentTest.log(LogStatus.PASS, "TLNA002 Clear field email dan password");
    }

    @And("TLNA002 Input text field email empty string")
    public void tlna002_Input_textfield_email_empty_string() {
        loginPage.getTxtFieldEmail().sendKeys("");
        extentTest.log(LogStatus.PASS, "TLNA002 Input text field email empty string");
    }

    @And("TLNA002 Input text field password empty string")
    public void tlna002_Input_textfield_password_empty_string() {
        loginPage.getTxtFieldPassword().sendKeys("");
        extentTest.log(LogStatus.PASS, "TLNA002 Input text field password empty string");
    }

    @And("TLNA002 Tekan tombol Masuk")
    public void tlna002_Tekan_tombol_Masuk() {
        loginPage.getButtonMasuk().click();
        extentTest.log(LogStatus.PASS, "TLNA002 Tekan tombol Masuk");
    }

    @Then("TLNA002 Validasi notifikasi yang muncul saat tombol masuk ditekan")
    public void tlna002_Validasi_notifikasi_tombol_masuk_ditekan() {
        boolean isError = loginPage.getErrorLog().getText().equals("Akun tidak ditemukan");

        Assert.assertTrue(isError);
        extentTest.log(LogStatus.PASS, "TLNA002 Validasi notifikasi yang muncul saat tombol masuk ditekan");
    }

    //TLNA003 - Login dengan menggunakan email yang valid
    @When("TLNA003 Clear field email dan password")
    public void tlna003_Clear_field_email_dan_password() {
        loginPage.getTxtFieldEmail().clear();
        loginPage.getTxtFieldPassword().clear();
        extentTest.log(LogStatus.PASS, "TLNA003 Clear field email dan password");
    }

    @And("TLNA003 Input text field email yang valid")
    public void tlna003_Input_textfield_email_yang_valid() {
        loginPage.getTxtFieldEmail().sendKeys("admin@hadir.com");
        extentTest.log(LogStatus.PASS, "TLNA003 Input text field email yang valid");
    }

    @And("TLNA003 Input text field password yang tidak valid")
    public void tlna003_Input_textfield_password_yang_tidak_valid() {
        loginPage.getTxtFieldPassword().sendKeys("admin");
        extentTest.log(LogStatus.PASS, "TLNA003 Input text field password yang tidak valid");
    }

    @And("TLNA003 Tekan tombol Masuk")
    public void tlna003_Tekan_tombol_Masuk() {
        loginPage.getButtonMasuk().click();
        extentTest.log(LogStatus.PASS, "TLNA003 Tekan tombol Masuk");
    }

    @Then("TLNA003 Validasi notifikasi yang muncul saat tombol masuk ditekan")
    public void tlna003_Validasi_notifikasi_tombol_masuk_ditekan() {
        boolean isError = loginPage.getErrorLog().getText().equals("Email atau password salah");
        Assert.assertTrue(isError);
        extentTest.log(LogStatus.PASS, "TLNA003 Validasi notifikasi yang muncul saat tombol masuk ditekan");
    }

    //TLNA004 - Login dengan menggunakan password yang valid
    @When("TLNA004 Clear field email dan password")
    public void tlna004_Clear_field_email_dan_password() {
        //this.driver.get(Constants.URL_LOGIN); //buka url

        loginPage.getTxtFieldEmail().clear();
        loginPage.getTxtFieldPassword().clear();
        extentTest.log(LogStatus.PASS, "TLNA004 Clear field email dan password");
    }

    @And("TLNA004 Input text field email yang tidak valid")
    public void tlna004_Input_textfield_email_yang_tidak_valid() {
        loginPage.getTxtFieldEmail().sendKeys("admin@hadircom");
        extentTest.log(LogStatus.PASS, "TLNA004 Input text field email yang tidak valid");
    }

    @And("TLNA004 Input text field password yang valid")
    public void tlna004_Input_textfield_password_yang_valid() {
        loginPage.getTxtFieldPassword().sendKeys("admin@hadir");
        extentTest.log(LogStatus.PASS, "TLNA004 Input text field password yang valid");
    }

    @And("TLNA004 Tekan tombol Masuk")
    public void tlna004_Tekan_tombol_Masuk() {
        loginPage.getButtonMasuk().click();
        extentTest.log(LogStatus.PASS, "TLNA004 Tekan tombol Masuk");
    }

    @Then("TLNA004 Validasi notifikasi yang muncul saat tombol masuk ditekan")
    public void tlna004_Validasi_notifikasi_tombol_masuk_ditekan() {
        boolean isError = loginPage.getErrorLog().getText().equals("Akun tidak ditemukan");
        Assert.assertTrue(isError);
        extentTest.log(LogStatus.PASS, "TLNA004 Validasi notifikasi yang muncul saat tombol masuk ditekan");
    }

    //TLN005 - Login dengan menggunakan email dan password yang tidak valid
    @When("TLNA005 Clear field email dan password")
    public void tlna005_Clear_field_email_dan_password() {
        loginPage.getTxtFieldEmail().clear();
        loginPage.getTxtFieldPassword().clear();
        extentTest.log(LogStatus.PASS, "TLNA005 Clear field email dan password");
    }

    @And("TLNA005 input text field email yang tidak valid")
    public void tlna005_input_textfield_email_yang_tidak_valid() {
        loginPage.getTxtFieldEmail().sendKeys("admin@hadircom");
        extentTest.log(LogStatus.PASS, "TLNA005 input text field email yang tidak valid");
    }

    @And("TLNA005 input text field password yang tidak valid")
    public void tlna005_Input_textfield_password_yang_tidak_valid() {
        loginPage.getTxtFieldPassword().sendKeys("admin@hadircom");
        extentTest.log(LogStatus.PASS, "TLNA005 input text field password yang tidak valid");
    }

    @And("TLNA005 Tekan tombol Masuk")
    public void tlna005_Tekan_tombol_Masuk() {
        loginPage.getButtonMasuk().click();
        extentTest.log(LogStatus.PASS, "TLNA005 Tekan tombol Masuk");
    }

    @Then("TLNA005 Validasi notifikasi yang muncul saat tombol masuk ditekan")
    public void tlna005_Validasi_notifikasi_tombol_masuk_ditekan() {
        boolean isError = loginPage.getErrorLog().getText().equals("Akun tidak ditemukan");
        Assert.assertTrue(isError);
        extentTest.log(LogStatus.PASS, "TLNA005 Validasi notifikasi yang muncul saat tombol masuk ditekan");
    }
}
