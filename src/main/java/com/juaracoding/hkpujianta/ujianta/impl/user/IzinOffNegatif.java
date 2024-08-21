package com.juaracoding.hkpujianta.ujianta.impl.user;

import com.juaracoding.hkpujianta.ujianta.impl.HadirHooks;
import com.juaracoding.hkpujianta.ujianta.page.admin.HomePage;
import com.juaracoding.hkpujianta.ujianta.page.admin.IzinOffPage;
import com.juaracoding.hkpujianta.ujianta.page.admin.LoginPage;
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

import static com.juaracoding.hkpujianta.ujianta.impl.HadirHooks.extentTest;

/*
IntelliJ IDEA 2024.1.4 (Ultimate Edition)
Build #IU-241.18034.62, built on June 21, 2024
@Author ITS-NEW a.k.a. Herlina Kurnia Prasetiani
Java Developer
Created on 20/08/2024 19:21
@Last Modified 20/08/2024 19:21
Version 1.0
*/
public class IzinOffNegatif {

    public WebDriver driver;
    private static ExtentTest extentTest;
    private UserLoginPage userLoginPage;
    private IzinPage izinPage;
    private IzinOffPage izinOffPage;
    private boolean isValid;

    public IzinOffNegatif(){
        isValid = true;
        this.driver = HadirHooks.driver;
        userLoginPage = new UserLoginPage(driver);
        izinPage = new IzinPage(driver);
        izinOffPage = new IzinOffPage(driver);
        extentTest = HadirHooks.extentTest;
    }

    @BeforeTest
    public void initials(){isValid = true;}

    @When("TIZONU003 Membuka Halaman Login")
    public void tizonu003_membuka_halaman_login(){
        this.driver.get(Constants.URL_LOGIN2);

        extentTest.log(LogStatus.PASS, "TIZONU003 Membuka Halaman Login");
    }
    @And("TIZONU003 Clear field input email dan password")
    public void tizonu003_clear_field_input_email_dan_password(){
//        userLoginPage.getTxtEmail().clear();
//        userLoginPage.getTxtPassword().clear();
        extentTest.log(LogStatus.PASS, "TIZONU003 Clear field input email dan password");
    }
    @And("TIZONU003 Masukan email dan password yang valid")
    public void tizonu003_masukan_email_dan_password_yang_valid(){
        GlobalFunction.delay(2);
        userLoginPage.getTxtEmail().sendKeys("testuser@gmail.com");
        userLoginPage.getTxtPassword().sendKeys("testuser");
        extentTest.log(LogStatus.PASS, "TIZONU003 Masukan email dan password yang valid");
    }
    @When("TIZONU003 Tekan tombol Masuk")
    public void tizonu003_tekan_tombol_masuk(){
        userLoginPage.getBtnMasuk().click();
        extentTest.log(LogStatus.PASS, "TIZONU003 Tekan tombol Masuk");
    }
    @Then("TIZONU003 Validasi Halaman Home")
    public void tizonu003_validasi_halaman_home(){
        GlobalFunction.delay(2);
        if(userLoginPage.getDivValidasiHome().isDisplayed()){
            extentTest.log(LogStatus.PASS, "TIZONU003 Validasi Halaman Home");
        }else{
            extentTest.log(LogStatus.FAIL, "TIZONU003 Validasi Halaman Home");
        }
    }
    @When("TIZONU003 Tekan tombol Izin")
    public void tizonu003_tekan_tombol_izin(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, document.body.scrollHeight * 0.25);");

        userLoginPage.getBtnIzin().click();
        extentTest.log(LogStatus.PASS, "TIZONU003 Tekan tombol Izin");
    }
    @Then("TIZONU003 Validasi Halaman Izin")
    public void tizonu003_validasi_halaman_izin(){
        GlobalFunction.delay(2);
        if(izinPage.getVarHalamanIzin().equals("")){
            extentTest.log(LogStatus.FAIL, "TIZONU003 Validasi Halaman Izin");
        }else{
            extentTest.log(LogStatus.PASS, "TIZONU003 Validasi Halaman Izin");
        }
    }
    @When("TIZONU003 Tekan tombol Izin Off")
    public void tizonu003_tekan_tombol_izin_off(){
        izinPage.getBtnIzinOff().click();
        extentTest.log(LogStatus.PASS, "TIZONU003 Tekan tombol Izin Off");
    }
    @Then("TIZONU003 Validasi setelah menekan tombol izin off")
    public void tizonu003_validasi_setelah_menekan_tombol_izin_off(){
        if(izinPage.getValidasiListIzinOff().equals("")){
            extentTest.log(LogStatus.FAIL, "TIZONU003 Validasi setelah menekan tombol izin off");

            //extentTest.log(LogStatus.FAIL, "TIZOPU001 Validasi setelah menekan tombol izin off");
        }else{
            extentTest.log(LogStatus.PASS, "TIZONU003 Validasi setelah menekan tombol izin off");
           // extentTest.log(LogStatus.PASS, "TIZOPU001 Validasi setelah menekan tombol izin off");
        }
    }
    @When("TIZONU003 Tekan tombol ajukan izin off")
    public void tizonu003_tekan_tombol_ajukan_izin_off(){
        izinPage.getBtnAjukanIzinOff().click();
        extentTest.log(LogStatus.PASS, "TIZONU003 Tekan tombol ajukan izin off");
    }
    @Then("TIZONU003 Validasi Form ajukan izin off")
    public void tizonu003_validasi_form_ajukan_izin_off(){
        if(izinPage.getValidasiFormIzinOff().equals("")){
            extentTest.log(LogStatus.FAIL, "TIZONU003 Validasi Form ajukan izin off");
            //extentTest.log(LogStatus.FAIL, "TIZOPU001 Validasi Form ajukan izin off");
        }else{
            extentTest.log(LogStatus.PASS, "TIZONU003 Validasi Form ajukan izin off");
            //extentTest.log(LogStatus.PASS, "TIZOPU001 Validasi Form ajukan izin off");
        }
    }
    @When("TIZONU003 Tekan tombol Ajukan")
    public void tizonu003_tekan_tombol_ajukan(){
        izinPage.getBtnFormAjukanIzinOff().click();
        extentTest.log(LogStatus.PASS, "TIZONU003 Tekan tombol Ajukan");
    }
    @Then("TIZONU003 Validasi setelah menekan tombol Ajukan")
    public void tizonu003_validasi_setelah_menekan_tombol_ajukan(){
        WebElement elemetDiv = driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/form/div"));
        List<WebElement> listP = elemetDiv.findElements(By.tagName("p"));
        if(listP.get(0).getText().equals("") && listP.get(1).getText().equals("")){
            extentTest.log(LogStatus.FAIL, "TIZONU003 Validasi setelah menekan tombol Ajukan");
        }else{
            extentTest.log(LogStatus.PASS, "TIZONU003 Validasi setelah menekan tombol Ajukan");
        }
//        System.out.println("Get 0 : " + listP.get(0).getText());
//        System.out.println("Get 1 : " + listP.get(1).getText());

    }
    @When("TIZONU003 Tekan tombol kembali")
    public void tizonu003_tekan_tombol_kembali(){
        GlobalFunction.delay(2);
        driver.navigate().refresh();
        izinPage.getBtnKembali().click();
        extentTest.log(LogStatus.PASS, "TIZONU003 Tekan tombol kembali");
    }
    @Then("TIZONU003 Validasi halaman home setelah izin off")
    public void tizonu003_validasi_halaman_home_setelah_izin_off(){
        GlobalFunction.delay(2);
        if(userLoginPage.getDivValidasiHome().isDisplayed()){
            extentTest.log(LogStatus.PASS, "TIZONU003 Validasi halaman home setelah izin off");
        }else{
            extentTest.log(LogStatus.FAIL, "TIZONU003 Validasi halaman home setelah izin off");
        }
    }
    @When("TIZONU003 Tekan button stip")
    public void tizonu003_tekan_button_stip(){
        GlobalFunction.delay(2);
        userLoginPage.getBtnUtkLogout().click();
        extentTest.log(LogStatus.PASS, "TIZONU003 Tekan button stip");
    }
    @When("TIZONU003 tekan tombol Logout")
    public void tizonu003_tekan_tombol_logout(){
        GlobalFunction.delay(2);
        userLoginPage.getButtonLogout().click();
        extentTest.log(LogStatus.PASS, "TIZONU003 tekan tombol Logout");
    }
    @Then("TIZONU003 Validasi halaman login")
    public void tizonu003_validasi_halaman_login(){
        if(userLoginPage.getDivValidasiLogin().isDisplayed()){
            extentTest.log(LogStatus.PASS, "TIZONU003 Validasi halaman login");
        }else {
            extentTest.log(LogStatus.FAIL, "TIZONU003 Validasi halaman login");
        }
    }
}
