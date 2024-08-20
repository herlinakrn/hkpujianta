package com.juaracoding.hkpujianta.ujianta.impl.admin;

import com.juaracoding.hkpujianta.ujianta.impl.HadirHooks;
import com.juaracoding.hkpujianta.ujianta.page.user.UserLoginPage;
import com.juaracoding.hkpujianta.ujianta.page.admin.HomePage;
import com.juaracoding.hkpujianta.ujianta.page.admin.LoginPage;
import com.juaracoding.hkpujianta.ujianta.page.admin.RegistrasiUser;
import com.juaracoding.hkpujianta.ujianta.util.Constants;
import com.juaracoding.hkpujianta.ujianta.util.DataGenerator;
import com.juaracoding.hkpujianta.ujianta.util.GlobalFunction;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.JavascriptExecutor;

import java.util.ArrayList;
import java.util.List;

/*
IntelliJ IDEA 2024.1.4 (Ultimate Edition)
Build #IU-241.18034.62, built on June 21, 2024
@Author ITS-NEW a.k.a. Herlina Kurnia Prasetiani
Java Developer
Created on 13/08/2024 20:25
@Last Modified 13/08/2024 20:25
Version 1.0
*/

public class RegistrasiUserPositif {
    public WebDriver driver;
    private static ExtentTest extentTest;
    private LoginPage loginPage;
    private HomePage homePage;
    private RegistrasiUser registrasiUser;
    private UserLoginPage userLoginPage;
    private boolean isValid;
    private String namaKaryawan;
    private String NIK;
    private String email;
    private String password;
    private DataGenerator dataGenerator;
    private static List<String> data = new ArrayList<>();

    public RegistrasiUserPositif(){
        isValid = true;
        this.driver = HadirHooks.driver;
        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);
        registrasiUser = new RegistrasiUser(driver);
        userLoginPage = new UserLoginPage(driver);
        extentTest = HadirHooks.extentTest;
        dataGenerator = new DataGenerator();
    }

    @BeforeTest
    public void initials(){
        isValid = true;
    }

    @When("TRUPA001 Membuka halaman login")
    public void trupa001_membuka_halaman_login(){
        this.driver.get(Constants.URL_LOGIN); //buka url

        extentTest.log(LogStatus.PASS, "TRUPA001 Membuka halaman login");
    }
    @And("TRUPA001 clear field email dan password")
    public void trupa001_clear_field_email_dan_password(){
        loginPage.getTxtFieldEmail().clear();
        loginPage.getTxtFieldPassword().clear();
        extentTest.log(LogStatus.PASS, "TRUPA001 clear field email dan password");
    }
    @And("TRUPA001 input text field email dan password yang valid")
    public void trupa001_input_text_field_email_dan_password_yang_valid(){
        loginPage.getTxtFieldEmail().sendKeys("admin@hadir.com");
        loginPage.getTxtFieldPassword().sendKeys("admin@hadir");
        extentTest.log(LogStatus.PASS, "TRUPA001 input text field email dan password yang valid");
    }
    @And("TRUPA001 Tekan tombol masuk")
    public void trupa001_tekan_tombol_masuk(){
        loginPage.getButtonMasuk().click();
        extentTest.log(LogStatus.PASS, "TRUPA001 Tekan tombol masuk");
    }
    @Then("TRUPA001 Validasi halaman home")
    public void trupa001_validasi_halaman_home(){
        String textValidasi = (homePage.getValidasiLabelValidasi()==null)?"" : homePage.getValidasiLabelValidasi().getText();
        String textValidasi2 = (homePage.getLabelAplikasiHadir()==null)?"" : homePage.getLabelAplikasiHadir().getText();

        if(textValidasi.equals("") && textValidasi2.equals("")){
            isValid = false;
        }
        Assert.assertTrue(textValidasi.equals("Validator 1") && textValidasi2.equals("© 2022 Aplikasi Hadir"));
        extentTest.log(LogStatus.PASS, "TRUPA001 Validasi halaman home");
    }
    @When("TRUPA001 Tekan menu Management")
    public void trupa001_tekan_menu_management(){
        registrasiUser.getVarManagement().click();
        extentTest.log(LogStatus.PASS, "TRUPA001 Tekan menu Management");
    }
    @When("TRUPA001 Tekan menu Pendaftaran User")
    public void trupa001_tekan_menu_pendaftaran_user(){
        registrasiUser.getVarPendaftaranUser().click();
        extentTest.log(LogStatus.PASS, "TRUPA001 Tekan menu Pendaftaran User");
    }
    @Then("TRUPA001 Validasi halaman Pendaftaran User")
    public void trupa001_validasi_halaman_pendaftaran_user(){
        String txtValidasi = (registrasiUser.getLabelValidasiRegisterUser()==null)?"" : registrasiUser.getLabelValidasiRegisterUser().getText();
        String txtValidasi2 = (registrasiUser.getLabelValidasiAccountInformation()==null)?"" : registrasiUser.getLabelValidasiAccountInformation().getText();
        if(txtValidasi.equals("") && txtValidasi2.equals("")){
            isValid = false;
        }

        Assert.assertTrue(txtValidasi.equals("Registrasi User") && txtValidasi2.equals("Account Information"));
        extentTest.log(LogStatus.PASS, "TRUPA001 Validasi halaman Pendaftaran User");
    }
    @And("TRUPA001 input text field Foto")
    public void trupa001_input_text_field_foto(){
        //registrasiUser.getUploadFoto().sendKeys(GlobalFunction.getFilePathInResources("\\data\\negatid\\file-php-tersembunyi.jpg"));
        WebElement inputFile = driver.findElement(By.name("logo"));
        inputFile.sendKeys(GlobalFunction.getFilePathInResources("\\data\\positif\\bunny-7563910_1280.webp"));
        extentTest.log(LogStatus.PASS, "TRUPA001 input text field Foto");
    }
    @And("TRUPA001 Input text field NIK")
    public void trupa001_input_text_field_nik(){
        NIK = dataGenerator.noKtp();
        data.add(NIK);

        registrasiUser.getTxtFieldNIK().sendKeys(data.get(0));
        extentTest.log(LogStatus.PASS, "TRUPA001 Input text field NIK");
    }
    @And("TRUPA001 Input text field Nama Karyawan")
    public void trupa001_input_text_field_nama_karyawan(){
        namaKaryawan = dataGenerator.dataNamaLengkap();
        data.add(namaKaryawan);

        registrasiUser.getTxtFieldNamaKaryawan().sendKeys(data.get(1));
        extentTest.log(LogStatus.PASS, "TRUPA001 Input text field Nama Karyawan");
    }
    @And("TRUPA001 Input text field Email")
    public void trupa001_input_text_field_email(){
        email = dataGenerator.dataEmail();
        data.add(email);

        registrasiUser.getTxtFieldEmail().sendKeys(data.get(2));
        extentTest.log(LogStatus.PASS, "TRUPA001 Input text field Email");
    }
    @And("TRUPA001 Input text field Password")
    public void trupa001_input_text_field_password(){
        password = dataGenerator.dataPassword();
        data.add(password);

        registrasiUser.getTxtFieldPassword().sendKeys(data.get(3));
        extentTest.log(LogStatus.PASS, "TRUPA001 Input text field Password");
    }
    @And("TRUPA001 Input text field Divisi")
    public void trupa001_input_text_field_divisi(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, document.body.scrollHeight * 0.25);");

        registrasiUser.getTxtFieldDivisi().click();
        GlobalFunction.delay(1);

        registrasiUser.getTxtFieldDivisi().sendKeys(Keys.DOWN);
        registrasiUser.getTxtFieldDivisi().sendKeys(Keys.RETURN);
        extentTest.log(LogStatus.PASS, "TRUPA001 Input text field Divisi");
    }
    @And("TRUPA001 Input text field Unit")
    public void trupa001_input_text_field_unit(){
        registrasiUser.getTxtFieldUnit().click();
        registrasiUser.getTxtFieldUnit().sendKeys(Keys.DOWN);
        registrasiUser.getTxtFieldUnit().sendKeys(Keys.RETURN);
        extentTest.log(LogStatus.PASS, "TRUPA001 Input text field Unit");
    }
    @And("TRUPA001 Input text field Posisi Kerja")
    public void trupa001_input_text_field_posisi_kerja(){
        registrasiUser.getTxtFieldPosisiKerja().click();
        registrasiUser.getTxtFieldPosisiKerja().sendKeys(Keys.DOWN);
        registrasiUser.getTxtFieldPosisiKerja().sendKeys(Keys.RETURN);
        extentTest.log(LogStatus.PASS, "TRUPA001 Input text field Posisi Kerja");
    }
    @And("TRUPA001 Input text field Jabatan")
    public void trupa001_input_text_field_jabatan(){
        registrasiUser.getTxtFieldJabatan().click();
        registrasiUser.getTxtFieldJabatan().sendKeys(Keys.DOWN);
        registrasiUser.getTxtFieldJabatan().sendKeys(Keys.RETURN);
        extentTest.log(LogStatus.PASS, "TRUPA001 Input text field Jabatan");
    }
    @And ("TRUPA001 Input text field Atasan")
    public void trupa001_input_text_field_atasan(){
        registrasiUser.getTxtFieldAtasan().click();
        GlobalFunction.delay(2);
        registrasiUser.getTxtFieldAtasan().sendKeys(Keys.DOWN);
        registrasiUser.getTxtFieldAtasan().sendKeys(Keys.RETURN);
        extentTest.log(LogStatus.PASS, "TRUPA001 Input text field Atasan");
    }
    @And ("TRUPA001 Input text field Atasan V2")
    public void trupa001_input_text_field_atasan_v2(){
        registrasiUser.getTxtFieldAtasanV2().click();
        GlobalFunction.delay(2);

        registrasiUser.getTxtFieldAtasanV2().sendKeys(Keys.DOWN);
        registrasiUser.getTxtFieldAtasanV2().sendKeys(Keys.RETURN);
        extentTest.log(LogStatus.PASS, "TRUPA001 Input text field Atasan V2");
    }
    @And ("TRUPA001 Input text field Atasan V3")
    public void trupa001_input_text_field_atasan_v3(){
        registrasiUser.getTxtFieldAtasanV3().click();
        GlobalFunction.delay(2);

        registrasiUser.getTxtFieldAtasanV3().sendKeys(Keys.DOWN);
        registrasiUser.getTxtFieldAtasanV3().sendKeys(Keys.RETURN);
        extentTest.log(LogStatus.PASS, "TRUPA001 Input text field Atasan V3");
    }
    @And ("TRUPA001 input text field Tipe Kontrak")
    public void trupa001_input_text_field_tipe_kontrak(){
        registrasiUser.getTxtFieldTipeKontrak().click();
        while(true){
            registrasiUser.getTxtFieldTipeKontrak().sendKeys(Keys.DOWN);
            registrasiUser.getTxtFieldTipeKontrak().sendKeys(Keys.RETURN);

            int asci = 0;
            for (int i = 0; i < registrasiUser.getTxtFieldTipeKontrak().getAttribute("value").trim().length(); i++) {
                asci = asci + (int) registrasiUser.getTxtFieldTipeKontrak().getAttribute("value").trim().charAt(i);
            }
            if(asci == 326){
                //registrasiUser.getTxtFieldTipeKontrak().sendKeys(Keys.RETURN);
                extentTest.log(LogStatus.PASS, "TRUPA001 input text field Tipe Kontrak");
                break;
            }else{
                //System.out.println("ASCII : "+asci);
                //System.out.println("Kontrak : " + registrasiUser.getTxtFieldTipeKontrak().getAttribute("value"));
                registrasiUser.getTxtFieldTipeKontrak().sendKeys(Keys.DOWN);
            }
            GlobalFunction.delay(2);
        }
    }
    @And ("TRUPA001 Input text field Lokasi Kerja")
    public void trupa001_input_text_field_lokasi_kerja(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, document.body.scrollHeight * 0.25);");

        registrasiUser.getTxtFieldLokasiKerja().click();
        registrasiUser.getTxtFieldLokasiKerja().sendKeys(Keys.DOWN);
        registrasiUser.getTxtFieldLokasiKerja().sendKeys(Keys.RETURN);
        extentTest.log(LogStatus.PASS, "TRUPA001 Input text field Lokasi Kerja");
    }
    @And ("TRUPA001 Input text Field Tipe Shift")
    public void trupa001_input_text_field_tipe_shift(){
        registrasiUser.getTxtFieldShiftType().click();

        if(!registrasiUser.getTxtFieldShiftList().isEmpty()){
            WebElement cek = driver.findElement(By.className("MuiMenuItem-gutters"));
            cek.click();
        }
        extentTest.log(LogStatus.PASS, "TRUPA001 Input text Field Tipe Shift");
    }
    @And ("TRUPA001 Input text field Jadwal Kerja")
    public void trupa001_input_text_field_jadwal_kerja(){
        registrasiUser.getTxtFieldJadwalKerja().click();
        GlobalFunction.delay(2);

        registrasiUser.getTxtFieldJadwalKerja().sendKeys(Keys.DOWN);
        registrasiUser.getTxtFieldJadwalKerja().sendKeys(Keys.RETURN);
        extentTest.log(LogStatus.PASS, "TRUPA001 Input text field Jadwal Kerja");
    }
    @And ("TRUPA001 Input text field Selfie")
    public void trupa001_input_text_field_selfie(){
        registrasiUser.getTxtFieldRequiredSelfie().click();
        while (true){
           GlobalFunction.delay(1);
           if(!registrasiUser.getTxtFieldSelfieList().isEmpty()){
               registrasiUser.getTxtFieldSelfieList().get(0).click();
               extentTest.log(LogStatus.PASS, "TRUPA001 Input text field Selfie");
               break;
           }else{
               System.out.println("cek : " + registrasiUser.getTxtFieldSelfieList().size());
               extentTest.log(LogStatus.FAIL, "TRUPA001 Input text field Selfie");
               break;
           }
        }
    }
    @And ("TRUPA001 Input text field Jumlah Cuti")
    public void trupa001_input_text_field_jumlah_cuti(){
        registrasiUser.getTxtFieldJumlahCuti().clear(); //clear dulu

        registrasiUser.getTxtFieldJumlahCuti().sendKeys("12");
        extentTest.log(LogStatus.PASS, "TRUPA001 Input text field Jumlah Cuti");
    }
    @When("TRUPA001 Tekan tombol Submit")
    public void trupa001_tekan_tombol_submit(){
        registrasiUser.getButtonSumbit().click();
        extentTest.log(LogStatus.PASS, "TRUPA001 Tekan tombol Submit");
    }
    @Then("TRUPA001 Validasi notifikasi setelah tombol sumbit")
    public void trupa001_validasi_notifikasi_setelah_tombol_sumbit(){
        int varInt =0;
        while (true) {
            varInt = varInt+1;
            GlobalFunction.delay(1);
            registrasiUser.getComboNama().click();

            if(!registrasiUser.getSearchByNIK().isEmpty()){
                registrasiUser.getSearchByNIK().get(1).click();

                //registrasiUser.getTextFieldSearch().click();
                registrasiUser.getTextFieldSearch().sendKeys(data.get(0));
                registrasiUser.getButtonSearch().click();

                GlobalFunction.delay(2);
                //System.out.println("cek NIK : " + registrasiUser.getTabelNIK().trim());

                if(registrasiUser.getTabelNIK().trim().equals(data.get(0)) || registrasiUser.getTabelNama().equals(data.get(1))){
                    extentTest.log(LogStatus.PASS, "TRUPA001 Validasi notifikasi setelah tombol sumbit");
                    break;
                }
            }else if (varInt == 10){
                extentTest.log(LogStatus.FAIL, "TRUPA001 Validasi notifikasi setelah tombol sumbit");
                break;
            }
        }
    }
    @When("TRUPA001 Tekan Profile")
    public void trupa001_tekan_profile(){
        homePage.getLabelProfil().click();
        extentTest.log(LogStatus.PASS, "TRUPA001 Tekan Profile");
    }
    @When("TRUPA001 Tekan Tombol Logout")
    public void trupa001_tekan_tombol_logout(){
        homePage.getButtonLogout().click();
        extentTest.log(LogStatus.PASS, "TRUPA001 Tekan Tombol Logout");
    }
    @Then("TRUPA001 Validasi label halaman login")
    public void trupa001_validasi_label_halaman_login(){
        String textLabelLogin = (loginPage.getLabelLogin()==null)?"" : loginPage.getLabelLogin().getText();
        if(textLabelLogin.equals("")){
            isValid = false;
            extentTest.log(LogStatus.FAIL, "TRUPA001 Validasi label halaman login");
        }
        Assert.assertTrue(textLabelLogin.equals("Login"));
        extentTest.log(LogStatus.PASS, "TRUPA001 Validasi label halaman login");
    }

    //TRUPA002 User melakukan login setelah pendaftaran user oleh admin
    @When("TRUPA002 Membuka halaman login")
    public void trupa002_membuka_halaman_login(){
        this.driver.get(Constants.URL_LOGIN2); // url login untuk user

        extentTest.log(LogStatus.PASS, "TRUPA002 Membuka halaman login");
    }
    @And("TRUPA002 clear field email dan password")
    public void trupa002_clear_field_email_dan_password(){
        userLoginPage.getTxtEmail().clear();
        userLoginPage.getTxtPassword().clear();
        extentTest.log(LogStatus.PASS, "TRUPA002 clear field email dan password");
    }
    @And("TRUPA002 input text field email dan password yang valid")
    public void trupa002_input_text_field_email_dan_password_yang_valid(){
        userLoginPage.getTxtEmail().sendKeys(data.get(2));
        userLoginPage.getTxtPassword().sendKeys(data.get(3));
        extentTest.log(LogStatus.PASS, "TRUPA002 input text field email dan password yang valid");
    }
    @When("TRUPA002 Tekan tombol masuk")
    public void trupa002_tekan_tombol_masuk(){
        userLoginPage.getBtnMasuk().click();
        extentTest.log(LogStatus.PASS, "TRUPA002 Tekan tombol masuk");
    }
    @Then("TRUPA002 Validasi halaman home")
    public void trupa002_validasi_halaman_home(){
        if(userLoginPage.getDivValidasiHome().isDisplayed()){
            extentTest.log(LogStatus.PASS, "TRUPA002 Validasi halaman home");
        }else{
            extentTest.log(LogStatus.FAIL, "TRUPA002 Validasi halaman home");
        }
    }
    @When("TRUPA002 Tekan button stip")
    public void trupa002_tekan_button_stip(){
        userLoginPage.getBtnUtkLogout().click();
        extentTest.log(LogStatus.PASS, "TRUPA002 Tekan button stip");
    }
    @When("TRUPA002 tekan tombol Logout")
    public void trupa002_tekan_tombol_logout(){
        userLoginPage.getButtonLogout().click();
        extentTest.log(LogStatus.PASS, "TRUPA002 tekan tombol Logout");
    }
    @Then("TRUPA002 Validasi halaman login")
    public void trupa002_validasi_halaman_login(){
        if(userLoginPage.getDivValidasiLogin().isDisplayed()){
            extentTest.log(LogStatus.PASS, "TRUPA002 Validasi halaman login");
        }else {
            extentTest.log(LogStatus.FAIL, "TRUPA002 Validasi halaman login");
        }
    }

}
