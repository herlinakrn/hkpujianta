package com.juaracoding.hkpujianta.ujianta.impl.admin;

import com.juaracoding.hkpujianta.ujianta.impl.HadirHooks;
import com.juaracoding.hkpujianta.ujianta.page.admin.HomePage;
import com.juaracoding.hkpujianta.ujianta.page.admin.LoginPage;
import com.juaracoding.hkpujianta.ujianta.util.Constants;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.JavascriptExecutor;
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

public class LoginPositif {
    //private static final Logger log = LoggerFactory.getLogger(LoginPositif.class);
    public WebDriver driver;
    private static ExtentTest extentTest;
    private LoginPage loginPage;
    private HomePage homePage;
    private boolean isValid;

    public LoginPositif(){
        isValid = true;
        this.driver = HadirHooks.driver;
        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);
        extentTest = HadirHooks.extentTest;
    }

    @BeforeTest
    public void initials(){
        isValid = true;
    }

    @When("TLPA001 Membuka Halaman Login")
    public void tlpa001_membuka_halaman_login(){
        this.driver.get(Constants.URL_LOGIN);
        extentTest.log(LogStatus.PASS, "TLPA001 Membuka Halaman Login");
    }

    @And("TLPA001 Clear Field email dan password")
    public void tlpa001_clear_field_email_dan_password(){
        loginPage.getTxtFieldEmail().clear();
        loginPage.getTxtFieldPassword().clear();
        extentTest.log(LogStatus.PASS, "TLPA001 Clear Field email dan password");
    }

    @And("TLPA001 Input textfield {string} email yang valid")
    public void tlpa001_input_textfield_email_yang_valid(String email){
        //loginPage.getTxtFieldEmail().sendKeys("admin@hadir.com");
        loginPage.getTxtFieldEmail().sendKeys(email);
        extentTest.log(LogStatus.PASS, "TLPA001 Input textfield email yang valid");
    }

    @And("TLPA001 Input textfield {string} password yang valid")
    public void tlpa001_input_textfield_password_yang_valid(String pass){
        //loginPage.getTxtFieldEmail().sendKeys("admin@hadir.com");
        loginPage.getTxtFieldPassword().sendKeys(pass);
        extentTest.log(LogStatus.PASS, "TLPA001 Input textfield password yang valid");
    }

    @And("TLPA001 Tekan tombol Masuk")
    public void tlpa001_tekan_tombol_masuk(){
        loginPage.getButtonMasuk().click();
        extentTest.log(LogStatus.PASS, "TLPA001 Tekan tombol Masuk");
    }

    @And("TLPA001 Scroll ke akhir page")
    public void tlpa001_scroll_ke_akhir_page(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
        extentTest.log(LogStatus.PASS, "TLPA001 Scroll ke akhir page");
    }

    @Then("TLPA001 Validasi halaman home")
    public void tlpa001_validasi_halaman_home(){
        String textValidasi = (homePage.getValidasiLabelValidasi()==null)?"" : homePage.getValidasiLabelValidasi().getText();
        String textValidasi2 = (homePage.getLabelAplikasiHadir()==null)?"" : homePage.getLabelAplikasiHadir().getText();
        if(textValidasi.equals("") && textValidasi2.equals("")){
            isValid = false;
        }
        Assert.assertTrue(textValidasi.equals("Validator 1") && textValidasi2.equals("© 2022 Aplikasi Hadir"));
        extentTest.log(LogStatus.PASS, "TLPA001 Validasi halaman home");
    }

    @When("TLPA001 Tekan Profil")
    public void tlpa001_tekan_profil(){
        homePage.getLabelProfil().click();
        extentTest.log(LogStatus.PASS, "TLPA001 Tekan Profil");
    }

    @When("TLPA001 Tekan tombol Logout")
    public void tlpa001_tekan_logout(){
        homePage.getButtonLogout().click();
        extentTest.log(LogStatus.PASS, "TLPA001 Tekan tombol Logout");
    }

    @Then("TLPA001 Validasi halaman login")
    public void tlpa001_validasi_halaman_login(){
        String textLabelLogin = (loginPage.getLabelLogin()==null)?"" : loginPage.getLabelLogin().getText();
        if(textLabelLogin.equals("")){
            isValid = false;
            extentTest.log(LogStatus.FAIL, "TLPA001 Validasi halaman login");
        }
        Assert.assertTrue(textLabelLogin.equals("Login"));
        extentTest.log(LogStatus.PASS, "TLPA001 Validasi halaman login");
    }
}
