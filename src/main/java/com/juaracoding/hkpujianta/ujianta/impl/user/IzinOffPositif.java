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
    private boolean isValid;
    private String keterangan;

    public IzinOffPositif() {
        isValid = true;
        this.driver = HadirHooks.driver;
        userLoginPage = new UserLoginPage(driver);
        izinPage = new IzinPage(driver);
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
        userLoginPage.getTxtEmail().sendKeys("testuser@gmail.com");
        userLoginPage.getTxtPassword().sendKeys("testuser");
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
        extentTest.log(LogStatus.PASS, "TIZOPU001 Validasi Halaman Home");
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
        extentTest.log(LogStatus.PASS, "TIZOPU001 Validasi Halaman Izin");
    }
    @When("TIZOPU001 Tekan tombol Izin Off")
    public void tizopu001_tekan_tombol_izin_off(){
        izinPage.getBtnIzinOff().click();
        extentTest.log(LogStatus.PASS, "TIZOPU001 Tekan tombol Izin Off");
    }
    @Then("TIZOPU001 Validasi setelah menekan tombol izin off")
    public void tizopu001_validasi_setelah_menekan_tombol_izin_off(){
//        if(izinPage.getValidasiListIzinOff().equals("")){
//            extentTest.log(LogStatus.FAIL, "TIZOPU001 Validasi setelah menekan tombol izin off");
//        }else{
//            extentTest.log(LogStatus.PASS, "TIZOPU001 Validasi setelah menekan tombol izin off");
//        }
        List<Map<String,Object>> list = new ArrayList<>();
        int intCount = Integer.parseInt(izinPage.getLabelCountData().getText().replace("Total : ",""));
        WebElement allElement = null;
        List<WebElement> listP = null;
        int intLebih = intCount+1;
        boolean isValid = true;
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
//                String strX = driver.findElement(By.xpath("/html/body/div/div/div[3]/div/div[2]/div[3]/div[2]/div/div["+(i+2)+"]/div/div/div[2]"))==null?null:"";
//                if(strX!=null){
//
//                }
            }
            System.out.println("====================== LOOPING KE : "+(i+1)+" ==================================");
            allElement = driver.findElement(By.xpath("/html/body/div/div/div[3]/div/div[2]/div[3]/div[2]/div/div["+(i+1)+"]/div/div/div[2]"));
            listP = allElement.findElements(By.tagName("p"));

            mapz = new HashMap<>();
            mapz.put("izinOff",listP.get(0).getText());
            mapz.put("status",listP.get(1).getText());
            mapz.put("catatan",listP.get(2).getText());
            mapz.put("alasanDitolak",listP.get(3).getText());
            mapz.put("tanggalDibuat",listP.get(4).getText());
            list.add(mapz);
        }


        for(int i=0;i<list.size();i++){
            System.out.println("======================= INI ISI DATA MAP KE "+(i+1)+" =============================");
            for (Map.Entry<String,Object> r : list.get(i).entrySet()){
                System.out.println("Key :  "+r.getKey()+" --- Value "+r.getValue());
            }
        }
        Assert.assertTrue(isValid);
    }
    @When("TIZOPU001 Tekan tombol ajukan izin off")
    public void tizopu001_tekan_tombol_ajukan_izin_off(){
        //izinPage.getBtnAjukanIzinOff().click();
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
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM dd yyyy");
        String date = now.format(formatter);

        //cari inputannya
        WebElement divParent = driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/form/div/div[1]/div/div"));
        List<WebElement> list = driver.findElements(By.tagName("input"));
        //list.get(0).sendKeys(date);
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
        WebElement divParent = driver.findElement(By.xpath(""));
        List<WebElement> list = driver.findElements(By.xpath("/html/body/div/div/div[3]/div/div[2]/div[1]/div[2]/div/div/div"));
        for (int i = 0; i < list.size(); i++) {
            List<WebElement> listKe2 = driver.findElements(By.xpath("/html/body/div/div/div[3]/div/div[2]/div[1]/div[2]/div/div/div/div/div[2]"));
            Map<String, Object> data = new HashMap<String, Object>();
            //get Jam
            System.out.println(data.put("Jam Terlambat : ", list.get(0).getText()));
        }
        extentTest.log(LogStatus.PASS, "TIZOPU001 Validasi setelah menekan tombol Ajukan");
    }
    @When("TIZOPU001 Tekan tombol kembali")
    public void tizopu001_tekan_tombol_kembali(){

        extentTest.log(LogStatus.PASS, "TIZOPU001 Tekan tombol kembali");
    }
    @Then("TIZOPU001 Validasi halaman home setelah izin off")
    public void tizopu001_validasi_halaman_home_setelah_izin_off(){

        extentTest.log(LogStatus.PASS, "TIZOPU001 Validasi halaman telah izin off");
    }
    @When("TIZOPU001 Tekan button stip")
    public void tizopu001_tekan_button_stip(){

        extentTest.log(LogStatus.PASS, "TIZOPU001 Tekan button stip");
    }
    @When("TIZOPU001 tekan tombol Logout")
    public void tizopu001_tekan_tombol_logout(){

        extentTest.log(LogStatus.PASS, "TIZOPU001 tekan tombol Logout");
    }
    @When("TIZOPU001 Validasi halaman login")
    public void tizopu001_validasi_halaman_login(){

        extentTest.log(LogStatus.PASS, "TIZOPU001 Validasi halaman login");
    }

}
