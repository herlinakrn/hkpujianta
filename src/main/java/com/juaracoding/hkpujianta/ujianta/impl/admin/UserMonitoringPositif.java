package com.juaracoding.hkpujianta.ujianta.impl.admin;

import com.juaracoding.hkpujianta.ujianta.impl.HadirHooks;
import com.juaracoding.hkpujianta.ujianta.page.admin.HomePage;
import com.juaracoding.hkpujianta.ujianta.page.admin.LoginPage;
import com.juaracoding.hkpujianta.ujianta.page.admin.UserMonitoring;
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
Created on 20/08/2024 23:33
@Last Modified 20/08/2024 23:33
Version 1.0
*/
public class UserMonitoringPositif {
    public WebDriver driver;
    private static ExtentTest extentTest;
    private boolean isValid;
    private LoginPage loginPage;
    private UserMonitoring userMonitoring;
    private HomePage homePage;
    private String search;
    private String namaUser;

    public UserMonitoringPositif() {
        isValid = true;
        this.driver = HadirHooks.driver;
        extentTest = HadirHooks.extentTest;
        loginPage = new LoginPage(driver);
        userMonitoring = new UserMonitoring(driver);
        homePage = new HomePage(driver);
    }
    @BeforeTest
    public void initials(){isValid = true;}

    //TUMPA001 Admin melakukan pencarian data dengan keyword 'test'
    @When("TUMPA001 Membuka Halaman Login")
    public void tumpa001_membuka_halaman_login(){
        this.driver.get(Constants.URL_LOGIN);
        extentTest.log(LogStatus.PASS, "TUMPA001 Membuka Halaman Login");
    }
    @And("TUMPA001 Clear field input email dan password")
    public void tumpa001_clear_field_input_email_dan_password(){
        loginPage.getTxtFieldEmail().clear();
        loginPage.getTxtFieldPassword().clear();
        extentTest.log(LogStatus.PASS, "TUMPA001 Clear field input email dan password");
    }
    @And("TUMPA001 Masukan email dan password yang valid")
    public void tumpa001_masukan_email_dan_password_yang_valid(){
        loginPage.getTxtFieldEmail().sendKeys("admin@hadir.com");
        loginPage.getTxtFieldPassword().sendKeys("admin@hadir");
        extentTest.log(LogStatus.PASS, "TUMPA001 Masukan email dan password yang valid");
    }
    @When("TUMPA001 Tekan tombol Masuk")
    public void tumpa001_tekan_tombol_masuk(){
        loginPage.getButtonMasuk().click();
        extentTest.log(LogStatus.PASS, "TUMPA001 Tekan tombol Masuk");
    }
    @Then("TUMPA001 Validasi Halaman Home")
    public void tumpa001_validasi_halaman_home(){
        if(homePage.getValidasiLabelValidasi().getText().equals("") && homePage.getLabelAplikasiHadir().getText().equals("")){
            extentTest.log(LogStatus.FAIL, "TUMPA001 Validasi Halaman Home");
        }else{
            extentTest.log(LogStatus.PASS, "TUMPA001 Validasi Halaman Home");
        }
    }
    @When("TUMPA001 Tekan menu Management")
    public void tumpa001_tekan_menu_management(){
        userMonitoring.getVarManagement().click();
        extentTest.log(LogStatus.PASS, "TUMPA001 Tekan menu Management");
    }
    @When("TUMPA001 Tekan menu User Monitoring")
    public void tumpa001_tekan_menu_user_monitoring(){
        WebElement sidebar = driver.findElement(By.xpath("//div[@class='sidebar MuiBox-root css-ftf74w']"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollTop = arguments[0].scrollHeight;", sidebar);

        userMonitoring.getVarUserMonitoring().click();

        extentTest.log(LogStatus.PASS, "TUMPA001 Tekan menu User Monitoring");
    }
    @Then("TUMPA001 Validasi halaman User monitoring")
    public void tumpa001_validasi_halaman_user_monitoring(){
        if(userMonitoring.getVarValidasiUserMonitoring().getText().equals("")){
            extentTest.log(LogStatus.FAIL, "TUMPA001 Validasi halaman User monitoring");
        }else{
            extentTest.log(LogStatus.PASS, "TUMPA001 Validasi halaman User monitoring");
        }
    }
    @And("TUMPA001 Input keyword pada text field search")
    public void tumpa001_input_keyword_pada_text_field_search(){
        search = "test";
        userMonitoring.getTxtSearch().sendKeys(search);
        extentTest.log(LogStatus.PASS, "TUMPA001 Input keyword pada text field search");
    }
    @When("TUMPA001 Tekan tombol search")
    public void tumpa001_tekan_tombol_search(){
        userMonitoring.getBtnSearch().click();
        extentTest.log(LogStatus.PASS, "TUMPA001 Tekan tombol search");
    }
    @Then("TUMPA001 Validasi setelah menekan tombol search")
    public void tumpa001_validasi_setelah_menekan_tombol_search(){
        GlobalFunction.delay(2);
        WebElement divTabel = driver.findElement(By.xpath("/html/body/div[1]/div/div/div/div[1]/div/div/div/div[2]/div/table/tbody"));
        List<WebElement> listH = divTabel.findElements(By.tagName("h6"));
        if(listH.get(0).getText() == search ){
            extentTest.log(LogStatus.FAIL, "TUMPA001 Validasi setelah menekan tombol search");
        }else{
            extentTest.log(LogStatus.PASS, "TUMPA001 Validasi setelah menekan tombol search");
        }
    }
    @When("TUMPA001 Tekan Profile")
    public void tumpa001_tekan_profile(){
        homePage.getLabelProfil().click();
        extentTest.log(LogStatus.PASS, "TUMPA001 Tekan Profile");
    }
    @When("TUMPA001 Tekan Tombol Logout")
    public void tumpa001_tekan_tombol_logout(){
        homePage.getButtonLogout().click();
        extentTest.log(LogStatus.PASS, "TUMPA001 Tekan Tombol Logout");
    }
    @Then("TUMPA001 Validasi label halaman login")
    public void tumpa001_validasi_label_halaman_login(){
        if(loginPage.getLabelLogin().getText().equals("")){
            extentTest.log(LogStatus.FAIL, "TUMPA001 Validasi label halaman login");
        }else{
            extentTest.log(LogStatus.PASS, "TUMPA001 Validasi label halaman login");
        }
    }

    //TUMPA002 Admin melakukan edit pada nama user
    @When("TUMPA002 Membuka Halaman Login")
    public void tumpa002_membuka_halaman_login(){
        this.driver.get(Constants.URL_LOGIN);
        extentTest.log(LogStatus.PASS, "TUMPA002 Membuka Halaman Login");
    }
    @And("TUMPA002 Clear field input email dan password")
    public void tumpa002_clear_field_input_email_dan_password(){
        loginPage.getTxtFieldEmail().clear();
        loginPage.getTxtFieldPassword().clear();
        extentTest.log(LogStatus.PASS, "TUMPA002 Clear field input email dan password");
    }
    @And("TUMPA002 Masukan email dan password yang valid")
    public void tumpa002_masukan_email_dan_password_yang_valid(){
        loginPage.getTxtFieldEmail().sendKeys("admin@hadir.com");
        loginPage.getTxtFieldPassword().sendKeys("admin@hadir");
        extentTest.log(LogStatus.PASS, "TUMPA002 Masukan email dan password yang valid");
    }
    @When("TUMPA002 Tekan tombol Masuk")
    public void tumpa002_tekan_tombol_masuk(){
        loginPage.getButtonMasuk().click();
        extentTest.log(LogStatus.PASS, "TUMPA002 Tekan tombol Masuk");
    }
    @Then("TUMPA002 Validasi Halaman Home")
    public void tumpa002_validasi_halaman_home(){
        if(homePage.getValidasiLabelValidasi().getText().equals("") && homePage.getLabelAplikasiHadir().getText().equals("")){
            extentTest.log(LogStatus.FAIL, "TUMPA002 Validasi Halaman Home");
        }else{
            extentTest.log(LogStatus.PASS, "TUMPA002 Validasi Halaman Home");
        }
    }
    @When("TUMPA002 Tekan menu Management")
    public void tumpa002_tekan_menu_management(){
        userMonitoring.getVarManagement().click();
        extentTest.log(LogStatus.PASS, "TUMPA002 Tekan menu Management");
    }
    @When("TUMPA002 Tekan menu User Monitoring")
    public void tumpa002_tekan_menu_user_monitoring(){
        WebElement sidebar = driver.findElement(By.xpath("//div[@class='sidebar MuiBox-root css-ftf74w']"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollTop = arguments[0].scrollHeight;", sidebar);

        userMonitoring.getVarUserMonitoring().click();
        extentTest.log(LogStatus.PASS, "TUMPA002 Tekan menu User Monitoring");
    }
    @Then("TUMPA002 Validasi halaman User monitoring")
    public void tumpa002_validasi_halaman_user_monitoring(){
        if(userMonitoring.getVarValidasiUserMonitoring().getText().equals("")){
            extentTest.log(LogStatus.FAIL, "TUMPA002 Validasi halaman User monitoring");
        }else{
            extentTest.log(LogStatus.PASS, "TUMPA002 Validasi halaman User monitoring");
        }
    }
    @And("TUMPA002 Input keyword pada text field search")
    public void tumpa002_input_keyword_pada_text_field_search(){
        userMonitoring.getTxtSearch().sendKeys("<script>alert(1)</scrip>");
        extentTest.log(LogStatus.PASS, "TUMPA002 Input keyword pada text field search");
    }
    @When("TUMPA002 Tekan tombol search")
    public void tumpa002_tekan_tombol_search(){
        userMonitoring.getBtnSearch().click();
        extentTest.log(LogStatus.PASS, "TUMPA002 Tekan tombol search");
    }
    @When("TUMPA002 Tekan Tombol Titik tiga")
    public void tumpa002_tekan_tombol_titik_tiga(){
        userMonitoring.getBtnTitikTiga().click();
        extentTest.log(LogStatus.PASS, "TUMPA002 Tekan Tombol Titik tiga");
    }
    @When("TUMPA002 Tekan tombol edit")
    public void tumpa002_tekan_tombol_edit(){
        userMonitoring.getBtnEdit().click();
        extentTest.log(LogStatus.PASS, "TUMPA002 Tekan tombol edit");
    }
    @Then("TUMPA002 Validasi Halaman edit user monitoring")
    public void tumpa002_validasi_halaman_edit_user_monitoring(){
        if(userMonitoring.getVarEditUserMonitoring().getText().equals("")){
            extentTest.log(LogStatus.FAIL, "TUMPA002 Validasi Halaman edit user monitoring");
        }else{
            extentTest.log(LogStatus.PASS, "TUMPA002 Validasi Halaman edit user monitoring");
        }
    }
    @And("TUMPA002 Ubah text field nama")
    public void tumpa002_ubah_text_field_nama(){
        WebElement page = driver.findElement(By.xpath("/html/body/div[1]/div/div/div/div[1]/div/div/div[2]/form/div[2]/div/div[1]/div/div"));
        WebElement editNama = page.findElement(By.tagName("input"));
        namaUser = "Uji Coba Ubah Nama";

        GlobalFunction.delay(3);
        editNama.click();
        editNama.clear();
        GlobalFunction.delay(3);

        editNama.sendKeys(namaUser);
        extentTest.log(LogStatus.PASS, "TUMPA002 Ubah text field nama");
    }
    @When("TUMPA002 Tekan tombol ubah")
    public void tumpa002_tekan_tombol_ubah(){
        userMonitoring.getBtnSubmitEdit().click();
        extentTest.log(LogStatus.PASS, "TUMPA002 Tekan tombol ubah");
    }
    @Then("TUMPA002 Validasi setelah menekan tombol ubah")
    public void tumpa002_validasi_setelah_menekan_tombol_ubah(){
        userMonitoring.getTxtSearch().sendKeys(namaUser);
        userMonitoring.getBtnSearch().click();

        GlobalFunction.delay(2);
        WebElement divTabel = driver.findElement(By.xpath("/html/body/div[1]/div/div/div/div[1]/div/div/div/div[2]/div/table/tbody"));
        List<WebElement> listH = divTabel.findElements(By.tagName("h6"));

        if(listH.get(0).getText() == namaUser){
            extentTest.log(LogStatus.PASS, "TUMPA002 Validasi setelah menekan tombol ubah");
        }else{
            extentTest.log(LogStatus.FAIL, "TUMPA002 Validasi setelah menekan tombol ubah");
        }
    }
    @When("TUMPA002 Tekan Profile")
    public void tumpa002_tekan_profile(){
        homePage.getLabelProfil().click();
        extentTest.log(LogStatus.PASS, "TUMPA002 Tekan Profile");
    }
    @When("TUMPA002 Tekan Tombol Logout")
    public void tumpa002_tekan_tombol_logout(){
        homePage.getButtonLogout().click();
        extentTest.log(LogStatus.PASS, "TUMPA002 Tekan Tombol Logout");
    }
    @Then("TUMPA002 Validasi label halaman login")
    public void tumpa002_validasi_label_halaman_login(){
        if(loginPage.getLabelLogin().getText().equals("")){
            extentTest.log(LogStatus.FAIL, "TUMPA002 Validasi label halaman login");
        }else{
            extentTest.log(LogStatus.PASS, "TUMPA002 Validasi label halaman login");
        }
    }
}
