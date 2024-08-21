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
import org.testng.Assert;
import org.testng.annotations.BeforeTest;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
IntelliJ IDEA 2024.1.4 (Ultimate Edition)
Build #IU-241.18034.62, built on June 21, 2024
@Author ITS-NEW a.k.a. Herlina Kurnia Prasetiani
Java Developer
Created on 19/08/2024 14:37
@Last Modified 19/08/2024 14:37
Version 1.0
*/
public class IzinOffPositif {

    public WebDriver driver;
    private static ExtentTest extentTest;
    private UserLoginPage userLoginPage;
    private IzinPage izinPage;
    private IzinOffPage izinOffPage;
    private LoginPage loginPage;
    private HomePage homePage;
    private boolean isValid;
    private String keterangan;

    public IzinOffPositif() {
        isValid = true;
        this.driver = HadirHooks.driver;
        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);
        userLoginPage = new UserLoginPage(driver);
        izinPage = new IzinPage(driver);
        izinOffPage = new IzinOffPage(driver);
        extentTest = HadirHooks.extentTest;
    }
    @BeforeTest
    public void initials(){isValid = true;}

    @When("TIZOPU001 Membuka Halaman Login")
    public void tizopu001_membuka_halaman_login(){
        this.driver.get(Constants.URL_LOGIN2);
        extentTest.log(LogStatus.PASS, "TIZOPU001 Membuka Halaman Login");
    }
    @And("TIZOPU001 Clear field input email dan password")
    public void tizopu001_clear_field_input_email_dan_password(){
        userLoginPage.getTxtEmail().clear();
        userLoginPage.getTxtPassword().clear();
        extentTest.log(LogStatus.PASS, "TIZOPU001 Clear field input email dan password");
    }
    @And("TIZOPU001 Masukan email dan password yang valid")
    public void tizopu001_masukan_email_dan_password_yang_valid(){
        userLoginPage.getTxtEmail().sendKeys("dummyher@gmail.com");
        userLoginPage.getTxtPassword().sendKeys("dummyher");
        extentTest.log(LogStatus.PASS, "TIZOPU001 Masukan email dan password yang valid");
    }
    @When("TIZOPU001 Tekan tombol Masuk")
    public void tizopu001_tekan_tombol_masuk(){
        userLoginPage.getBtnMasuk().click();
        extentTest.log(LogStatus.PASS, "TIZOPU001 Tekan tombol Masuk");
    }
    @And("TIZOPU001 Validasi Halaman Home")
    public void tizopu001_validasi_halaman_home(){
        GlobalFunction.delay(2);
        if(userLoginPage.getDivValidasiHome().isDisplayed()){
            extentTest.log(LogStatus.PASS, "TIZPU001 Validasi Halaman Home");
        }else{
            extentTest.log(LogStatus.FAIL, "TIZPU001 Validasi Halaman Home");
        }
        //extentTest.log(LogStatus.PASS, "TIZOPU001 Validasi Halaman Home");
    }
    @When("TIZOPU001 Tekan tombol Izin")
    public void tizopu001_tekan_tombol_izin(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, document.body.scrollHeight * 0.25);");

        userLoginPage.getBtnIzin().click();
        extentTest.log(LogStatus.PASS, "TIZOPU001 Tekan tombol Izin");
    }
    @Then("TIZOPU001 Validasi Halaman Izin")
    public void tizopu001_validasi_halaman_izin(){
        GlobalFunction.delay(2);
        if(izinPage.getVarHalamanIzin().equals("")){
            extentTest.log(LogStatus.FAIL, "TIZPU001 Validasi Halaman Izin");
        }else{
            extentTest.log(LogStatus.PASS, "TIZPU001 Validasi Halaman Izin");
        }
        //extentTest.log(LogStatus.PASS, "TIZOPU001 Validasi Halaman Izin");
    }
    @When("TIZOPU001 Tekan tombol Izin Off")
    public void tizopu001_tekan_tombol_izin_off(){
        izinPage.getBtnIzinOff().click();
        extentTest.log(LogStatus.PASS, "TIZOPU001 Tekan tombol Izin Off");
    }
    @Then("TIZOPU001 Validasi setelah menekan tombol izin off")
    public void tizopu001_validasi_setelah_menekan_tombol_izin_off(){
        if(izinPage.getValidasiListIzinOff().equals("")){
            extentTest.log(LogStatus.FAIL, "TIZOPU001 Validasi setelah menekan tombol izin off");
        }else{
            extentTest.log(LogStatus.PASS, "TIZOPU001 Validasi setelah menekan tombol izin off");
        }

    }
    @When("TIZOPU001 Tekan tombol ajukan izin off")
    public void tizopu001_tekan_tombol_ajukan_izin_off(){
        izinPage.getBtnAjukanIzinOff().click();
        extentTest.log(LogStatus.PASS, "TIZOPU001 Tekan tombol ajukan izin off");
    }
    @Then("TIZOPU001 Validasi Form ajukan izin off")
    public void tizopu001_validasi_form_ajukan_izin_off(){
        if(izinPage.getValidasiFormIzinOff().equals("")){
            extentTest.log(LogStatus.FAIL, "TIZOPU001 Validasi Form ajukan izin off");
        }else{
            extentTest.log(LogStatus.PASS, "TIZOPU001 Validasi Form ajukan izin off");
        }
    }
    @And("TIZOPU001 Input tanggal izin off")
    public void tizopu001_input_tanggal_izin_off(){
        LocalDateTime now = LocalDateTime.now().plusDays(3);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM dd yyyy");
        String date = now.format(formatter);

        //cari inputannya
        WebElement divParent = driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/form/div/div[1]/div/div"));
        List<WebElement> list = driver.findElements(By.tagName("input"));
        boolean flag = false;
        int attemps =0;
        while(attemps < 3 && !flag){
            try{
                list.get(0).sendKeys(date);
                flag = true;
                extentTest.log(LogStatus.PASS, "TIZOPU001 Input tanggal izin off");
            }catch (Exception ex){
                attemps++;
                extentTest.log(LogStatus.FAIL, "TIZOPU001 Input tanggal izin off");
            }
        }
    }
    @And("TIZOPU001 input alasan izin off")
    public void tizopu001_input_alasan_izin_off(){
        keterangan = "Lorem Ipsum is simply dummy text of the printing and typesetting industry. " +
                "Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, " +
                "when an unknown printer took a galley of type and scrambled it to make a type specimen book.";
        izinPage.getTxtAlasanOff().sendKeys(keterangan);
        extentTest.log(LogStatus.PASS, "TIZOPU001 input alasan izin off");
    }
    @When("TIZOPU001 Tekan tombol Ajukan")
    public void tizopu001_tekan_tombol_ajukan(){
        izinPage.getBtnFormAjukanIzinOff().click();
        extentTest.log(LogStatus.PASS, "TIZOPU001 Tekan tombol Ajukan");
    }
    @Then("TIZOPU001 Validasi setelah menekan tombol Ajukan")
    public void tizopu001_validasi_setelah_menekan_tombol_ajukan(){
        List<Map<String,Object>> list = new ArrayList<>();
        int intCount = Integer.parseInt(izinPage.getLabelCountData().getText().replace("Total : ",""));
        WebElement allElement = null;
        List<WebElement> listP = null;
        int intLebih = intCount+1;
        isValid = true;
        Map<String,Object> mapz = null;

        for (int i = 0; i < intCount; i++) {
            /** HANYA UNTUK PENGECEKAN APAKAH JUMLAH DATA YANG DI LABEL SESUAI DENGAN JUMLAH DATA YANG ADA */
            if((i+2)==(intCount+1)){// KALAU TOTAL RECORD = 3 BERARTI i+2=4 dan intCount+1 = 4
                //DISENGAJA ERROR , JIKA ERROR BERARTI MEMANG SESUAI DATA YANG DI LABEL DENGAN DATA YANG ADA DI GRID
                try{
                    driver.findElement(By.xpath("/html/body/div/div/div[3]/div/div[2]/div[3]/div[2]/div/div["+(i+2)+"]/div/div/div[2]"));
                    isValid = false;
                }catch (Exception e){
                    System.out.println("TRUE");
                }
            }
            //System.out.println("====================== LOOPING KE : "+(i+1)+" ==================================");
            allElement = driver.findElement(By.xpath("/html/body/div/div/div[3]/div/div[2]/div[3]/div[2]/div/div["+(i+1)+"]/div/div/div[2]"));
            listP = allElement.findElements(By.tagName("p"));

            if(listP.get(0).getText().equals("") && listP.get(1).getText().equals("")){
                isValid = false;
                extentTest.log(LogStatus.FAIL, "TIZOPU001 Validasi setelah menekan tombol Ajukan");
            }else{
                extentTest.log(LogStatus.PASS, "TIZOPU001 Validasi setelah menekan tombol Ajukan");
            }
        }
    }
    @When("TIZOPU001 Tekan tombol kembali")
    public void tizopu001_tekan_tombol_kembali(){
        izinPage.getBtnKembali().click();
        extentTest.log(LogStatus.PASS, "TIZOPU001 Tekan tombol kembali");
    }
    @Then("TIZOPU001 Validasi halaman home setelah izin off")
    public void tizopu001_validasi_halaman_home_setelah_izin_off(){
        GlobalFunction.delay(2);
        if(userLoginPage.getDivValidasiHome().isDisplayed()){
            extentTest.log(LogStatus.PASS, "TIZOPU001 Validasi halaman telah izin off");
            //extentTest.log(LogStatus.PASS, "TIZPU001 Validasi Halaman Home");
        }else{
            extentTest.log(LogStatus.FAIL, "TIZOPU001 Validasi halaman telah izin off");
            //extentTest.log(LogStatus.FAIL, "TIZPU001 Validasi Halaman Home");
        }
    }
    @When("TIZOPU001 Tekan button stip")
    public void tizopu001_tekan_button_stip(){
        GlobalFunction.delay(2);
        userLoginPage.getBtnUtkLogout().click();
        extentTest.log(LogStatus.PASS, "TIZOPU001 Tekan button stip");
    }
    @When("TIZOPU001 tekan tombol Logout")
    public void tizopu001_tekan_tombol_logout(){
        GlobalFunction.delay(2);
        userLoginPage.getButtonLogout().click();
        extentTest.log(LogStatus.PASS, "TIZOPU001 tekan tombol Logout");
    }
    @When("TIZOPU001 Validasi halaman login")
    public void tizopu001_validasi_halaman_login(){
        if(userLoginPage.getDivValidasiLogin().isDisplayed()){
            extentTest.log(LogStatus.PASS, "TIZOPU001 Validasi halaman login");
        }else {
            extentTest.log(LogStatus.FAIL, "TIZOPU001 Validasi halaman login");
        }
    }

    //TIZOPA002 Admin melakukan validasi pada menu laporan izin off
    @When("TIZOPA002 Membuka Halaman Login")
    public void tizopa002_membuka_halaman_login(){
        this.driver.get(Constants.URL_LOGIN);
        extentTest.log(LogStatus.PASS, "TIZOPA002 Membuka Halaman Login");
    }
    @And("TIZOPA002 Clear field input email dan password")
    public void tizopa002_clear_field_input_email_dan_password(){
        loginPage.getTxtFieldEmail().clear();
        loginPage.getTxtFieldPassword().clear();
        extentTest.log(LogStatus.PASS, "TIZOPA002 Clear field input email dan password");
    }
    @And("TIZOPA002 Masukan email dan password yang valid")
    public void tizopa002_masukan_email_dan_password_yang_valid(){
        loginPage.getTxtFieldEmail().sendKeys("admin@hadir.com");
        loginPage.getTxtFieldPassword().sendKeys("admin@hadir");
        extentTest.log(LogStatus.PASS, "TIZOPA002 Masukan email dan password yang valid");
    }
    @When("TIZOPA002 Tekan tombol Masuk")
    public void tizopa002_tekan_tombol_masuk(){
        loginPage.getButtonMasuk().click();
        extentTest.log(LogStatus.PASS, "TIZOPA002 Tekan tombol Masuk");
    }
    @Then("TIZOPA002 Validasi Halaman Home")
    public void tizopa002_validasi_halaman_home(){
        GlobalFunction.delay(2);
        if(homePage.getValidasiLabelValidasi().getText().equals("") && homePage.getLabelAplikasiHadir().getText().equals("")){
            extentTest.log(LogStatus.PASS, "TIZOPA002 Validasi Halaman Home");
        }else{
            extentTest.log(LogStatus.PASS, "TIZOPA002 Validasi Halaman Home");
        }
    }
    @When("TIZOPA002 Tekan menu laporan")
    public void tizopa002_tekan_menu_laporan(){
        homePage.getVarMenuLaporan().click();
        extentTest.log(LogStatus.PASS, "TIZOPA002 Tekan menu laporan");
    }
    @When("TIZOPA002 Pilih menu Izin Off")
    public void tizopa002_pilih_menu_izin_off(){
        WebElement sidebar = driver.findElement(By.xpath("//div[@class='sidebar MuiBox-root css-ftf74w']"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollTop = arguments[0].scrollHeight;", sidebar);

        homePage.getVarIzinOff().click();
        extentTest.log(LogStatus.PASS, "TIZOPA002 Pilih menu Izin Off");
    }
    @Then("TIZOPA002 Validasi menu izin Off")
    public void tizopa002_validasi_menu_izin_off(){
        if(izinOffPage.getValidasiHalamanIzinOff().getText().equals("")){
            extentTest.log(LogStatus.FAIL, "TIZOPA002 Validasi menu izin Off");
        }else{
            extentTest.log(LogStatus.PASS, "TIZOPA002 Validasi menu izin Off");
        }
    }
    @And("TIZOPA002 Input text search berdasarkan nama")
    public void tizopa002_input_text_search_berdasarkan_nama(){
        izinOffPage.getTxtSearch().sendKeys("test");
        extentTest.log(LogStatus.PASS, "TIZOPA002 Input text search berdasarkan nama");
    }
    @When("TIZOPA002 Tekan tombol search")
    public void tizopa002_tekan_tombol_search(){
        izinOffPage.getButtonSearch().click();
        extentTest.log(LogStatus.PASS, "TIZOPA002 Tekan tombol search");
    }
    @And("TIZOPA002 Validasi tabel yang telah di search")
    public void tizopa002_validasi_tabel_yang_telah_di_search(){
        GlobalFunction.delay(2);
        if(izinOffPage.getDivTabelIzinOff().getText().equals("")){
            extentTest.log(LogStatus.FAIL, "TIZOPA002 Validasi tabel yang telah di search");
        }else{
            extentTest.log(LogStatus.PASS, "TIZOPA002 Validasi tabel yang telah di search");
        }
    }
    @When("TIZOPA002 Tekan Profile")
    public void tizopa002_tekan_profile(){
        homePage.getLabelProfil().click();
        extentTest.log(LogStatus.PASS, "TIZOPA002 Tekan Profile");
    }
    @When("TIZOPA002 Tekan Tombol Logout")
    public void tizopa002_tekan_tombol_logout(){
        homePage.getButtonLogout().click();
        extentTest.log(LogStatus.PASS, "TIZOPA002 Tekan Tombol Logout");
    }
    @Then("TIZOPA002 Validasi label halaman login")
    public void tizopa002_validasi_label_halaman_login(){
        String textLabelLogin = (loginPage.getLabelLogin()==null)?"" : loginPage.getLabelLogin().getText();
        if(textLabelLogin.equals("")){
            isValid = false;
            extentTest.log(LogStatus.FAIL, "TIZOPA002 Validasi label halaman login");
        }
        Assert.assertTrue(textLabelLogin.equals("Login"));
        extentTest.log(LogStatus.PASS, "TIZOPA002 Validasi label halaman login");
    }

}
