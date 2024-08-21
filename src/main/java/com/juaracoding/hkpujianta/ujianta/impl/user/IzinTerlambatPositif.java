package com.juaracoding.hkpujianta.ujianta.impl.user;

import com.juaracoding.hkpujianta.ujianta.impl.HadirHooks;
import com.juaracoding.hkpujianta.ujianta.impl.admin.RegistrasiUserPositif;
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
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeTest;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Random;

/*
IntelliJ IDEA 2024.1.4 (Ultimate Edition)
Build #IU-241.18034.62, built on June 21, 2024
@Author ITS-NEW a.k.a. Herlina Kurnia Prasetiani
Java Developer
Created on 17/08/2024 19:06
@Last Modified 17/08/2024 19:06
Version 1.0
*/
public class IzinTerlambatPositif {

    public WebDriver driver;
    private static ExtentTest extentTest;
    private UserLoginPage userLoginPage;
    private RegistrasiUserPositif registrasiUser;
    private IzinPage izinPage;
    private String keterangan;
    private boolean isValid;
    private static Random random = new Random();

    public IzinTerlambatPositif() {
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

    @When("TIZPU001 Membuka Halaman Login")
    public void tizpu001_membuka_halaman_login(){
        this.driver.get(Constants.URL_LOGIN2); //buka url login user

        extentTest.log(LogStatus.PASS, "TIZPU001 Membuka Halaman Login");
    }
    @And("TIZPU001 Clear field input email dan password")
    public void tizpu001_clear_field_input_email_dan_password(){
        userLoginPage.getTxtEmail().clear();
        userLoginPage.getTxtPassword().clear();
        extentTest.log(LogStatus.PASS, "TIZPU001 Clear field input email dan password");
    }
    @And("TIZPU001 Masukan email dan password yang valid")
    public void tizpu001_masukan_email_dan_password_yang_valid(){
        userLoginPage.getTxtEmail().sendKeys("dummyher@gmail.com");
        userLoginPage.getTxtPassword().sendKeys("dummyher");
        extentTest.log(LogStatus.PASS, "TIZPU001 Masukan email dan password yang valid");
    }
    @When("TIZPU001 Tekan tombol Masuk")
    public void tizpu001_tekan_tombol_masuk(){
        userLoginPage.getBtnMasuk().click();
        extentTest.log(LogStatus.PASS, "TIZPU001 Tekan tombol Masuk");
    }
    @Then("TIZPU001 Validasi Halaman Home")
    public void tizpu001_validasi_halaman_home(){
        GlobalFunction.delay(2);
        if(userLoginPage.getDivValidasiHome().isDisplayed()){
            extentTest.log(LogStatus.PASS, "TIZPU001 Validasi Halaman Home");
        }else{
            extentTest.log(LogStatus.FAIL, "TIZPU001 Validasi Halaman Home");
        }
    }
    @When("TIZPU001 Tekan tombol Izin")
    public void tizpu001_tekan_tombol_izin(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, document.body.scrollHeight * 0.25);");

        userLoginPage.getBtnIzin().click();
        extentTest.log(LogStatus.PASS, "TIZPU001 Tekan tombol Izin");
    }
    @Then("TIZPU001 Validasi Halaman Izin")
    public void tizpu001_validasi_halaman_izin(){
        GlobalFunction.delay(2);
        if(izinPage.getVarHalamanIzin().equals("")){
            extentTest.log(LogStatus.FAIL, "TIZPU001 Validasi Halaman Izin");
        }else{
            extentTest.log(LogStatus.PASS, "TIZPU001 Validasi Halaman Izin");
        }
    }
    @When("TIZPU001 Tekan tombol Ajukan Izin Terlambat")
    public void tizpu001_tekan_tombol_ajukan_izin_terlambat(){
        izinPage.getBtnAjukanTerlambat().click();
        extentTest.log(LogStatus.PASS, "TIZPU001 Tekan tombol Ajukan Izin Terlambat");
    }
    @Then("TIZPU001 Validasi form Ajukan Izin Terlambat")
    public void tizpu001_validasi_form_ajukan_izin_terlambat(){
        if(izinPage.getVarFormAjukanIzinTerlambat().equals("")){
            extentTest.log(LogStatus.FAIL, "TIZPU001 Validasi form Ajukan Izin Terlambat");
        }else{
            extentTest.log(LogStatus.PASS, "TIZPU001 Validasi form Ajukan Izin Terlambat");
        }
    }
    @And("TIZPU001 Clear field form Ajukan Izin Terlambat")
    public void tizpu001_clear_field_form_ajukan_izin_terlambat(){
        //izinPage.getTxtFieldTanggal().clear();
        //izinPage.getTxtFieldJam().clear();
        //izinPage.getTxtFieldKeterangan().clear();
        extentTest.log(LogStatus.PASS, "TIZPU001 Clear field form Ajukan Izin Terlambat");
    }
    @And("TIZPU001 Input field Tanggal")
    public void tizpu001_input_field_tanggal(){
        LocalDateTime now = LocalDateTime.now().plusDays(9);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM dd yyyy");
        String date = now.format(formatter);

        WebElement divParentTanggal = driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/form/div/div[1]/div/div"));
        List<WebElement> tanggalTerlambat = divParentTanggal.findElements(By.tagName("input"));
        tanggalTerlambat.get(0).sendKeys(date);
        extentTest.log(LogStatus.PASS, "TIZPU001 Input field Tanggal");
    }
    @And("TIZPU001 Input field Jam")
    public void tizpu001_input_field_jam(){

        GlobalFunction.delay(2);
        izinPage.getBtnClock().click();
        WebElement elementClock = driver.findElement(By.xpath("/html/body/div[3]/div[2]/div/div/div/div[2]/div"));
        List<WebElement> listDiv = elementClock.findElements(By.tagName("div"));
        System.out.println("Banyak nya Div -> "+listDiv.size());
        List<WebElement> listClock = listDiv.get(2).findElements(By.tagName("span"));
        System.out.println("Banyak nya Span -> "+listClock.size());
        WebElement elementSpan = listClock.get(random.nextInt(0,24));
        System.out.println("Aria Label SPan adalah : "+elementSpan.getAttribute("aria-label"));
        new Actions(driver)
                .click(elementSpan)
                .perform();
        /** button next */
        WebElement nextClockButton = driver.findElement(By.xpath("/html/body/div[3]/div[2]/div/div/div/div[1]/button[2]"));
        new Actions(driver)
                .click(nextClockButton)
                .perform();
        listClock = listDiv.get(2).findElements(By.tagName("span"));
        System.out.println("Banyak nya Span Menit-> "+listClock.size());
        elementSpan = listClock.get(random.nextInt(0,12));
        System.out.println("Aria Label Span Menit adalah : "+elementSpan.getAttribute("aria-label"));
        new Actions(driver)
                .click(elementSpan)
                .perform();

        extentTest.log(LogStatus.PASS, "TIZPU001 Input field Jam");

    }
    @And("TIZPU001 Input field Keterangan")
    public void tizpu001_input_field_keterangan(){
        keterangan = "Lorem Ipsum is simply dummy text of the printing and typesetting industry. " +
                "Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, " +
                "when an unknown printer took a galley of type and scrambled it to make a type specimen book.";

        izinPage.getTxtFieldKeteranganTerlambat().sendKeys(keterangan);
        extentTest.log(LogStatus.PASS, "TIZPU001 Input field Keterangan");
    }
    @When("TIZPU001 Tekan tombol Ajukan")
    public void tizpu001_tekan_tombol_ajukan(){
        izinPage.getFormBtnAjukanTerlambat().click();
        extentTest.log(LogStatus.PASS, "TIZPU001 Tekan tombol Ajukan");
    }
    @Then("TIZPU001 Validasi setelah melakukan input")
    public void tizpu001_validasi_setelah_melakukan_input(){
        GlobalFunction.delay(2);
        WebElement divParent = driver.findElement(By.xpath("/html/body/div/div/div[3]/div/div[2]/div[1]/div[2]/div/div/div/div"));
        List<WebElement> list = divParent.findElements(By.tagName("p"));
        //System.out.println("get p : "+ list.get(0).getText());
        if(list.get(0).getText().equals("") && list.get(1).getText().equals("") && list.get(2).getText().equals("")){
            extentTest.log(LogStatus.FAIL, "TIZPU001 Validasi setelah melakukan input");
        }else{
            extentTest.log(LogStatus.PASS, "TIZPU001 Validasi setelah melakukan input");
        }
    }
    @When("TIZPU001 Tekan tombol kembali")
    public void tizpu001_tekan_tombol_kembali(){
        GlobalFunction.delay(2);

        driver.navigate().refresh();

        izinPage.getBtnKembali().click();
        extentTest.log(LogStatus.PASS, "TIZPU001 Tekan tombol kembali");
    }
    @Then("TIZPU001 Validasi halaman home setelah izin")
    public void tizpu001_validasi_halaman_home_setelah_izin(){
        GlobalFunction.delay(2);
        if(!userLoginPage.getDivValidasiHome().isDisplayed()){
            extentTest.log(LogStatus.FAIL, "TIZPU001 Validasi halaman home setelah izin");
        }else{
            extentTest.log(LogStatus.PASS, "TIZPU001 Validasi halaman home setelah izin");
        }
    }
    @When("TIZPU001 Tekan button stip")
    public void tizpu001_tekan_button_stip(){
        userLoginPage.getBtnUtkLogout().click();
        extentTest.log(LogStatus.PASS, "TIZPU001 Tekan button stip");
    }
    @When("TIZPU001 tekan tombol Logout")
    public void tizpu001_tekan_tombol_logout(){
        userLoginPage.getButtonLogout().click();
        extentTest.log(LogStatus.PASS, "TIZPU001 tekan tombol Logout");
    }
    @Then("TIZPU001 Validasi halaman login")
    public void tizpu001_validasi_halaman_login(){
        if(userLoginPage.getDivValidasiLogin().isDisplayed()){
            extentTest.log(LogStatus.PASS, "TIZPU001 Validasi halaman login");
        }else {
            extentTest.log(LogStatus.FAIL, "TIZPU001 Validasi halaman login");
        }
    }
}
