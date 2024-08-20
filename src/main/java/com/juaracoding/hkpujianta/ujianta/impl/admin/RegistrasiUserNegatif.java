package com.juaracoding.hkpujianta.ujianta.impl.admin;

import com.juaracoding.hkpujianta.ujianta.impl.HadirHooks;
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
import org.openqa.selenium.*;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;

import java.util.ArrayList;
import java.util.List;

/*
IntelliJ IDEA 2024.1.4 (Ultimate Edition)
Build #IU-241.18034.62, built on June 21, 2024
@Author ITS-NEW a.k.a. Herlina Kurnia Prasetiani
Java Developer
Created on 17/08/2024 02:23
@Last Modified 17/08/2024 02:23
Version 1.0
*/
public class RegistrasiUserNegatif {
    public WebDriver driver;
    private static ExtentTest extentTest;
    private LoginPage loginPage;
    private HomePage homePage;
    private RegistrasiUser registrasiUser;
    private boolean isValid;
    private String namaKaryawan;
    private String NIK;
    private String email;
    private String password;
    private DataGenerator dataGenerator;
    private static List<String> data = new ArrayList<>();

    public RegistrasiUserNegatif(){
        isValid = true;
        this.driver = HadirHooks.driver;
        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);
        registrasiUser = new RegistrasiUser(driver);
        extentTest = HadirHooks.extentTest;
        dataGenerator = new DataGenerator();
    }
    @BeforeTest
    public void initials(){
        isValid = true;
    }

    @When("TRUNA003 Membuka halaman login")
    public void truna003_membuka_halaman_login(){
        this.driver.get(Constants.URL_LOGIN);//buka url admin

        extentTest.log(LogStatus.PASS, "TRUNA003 Membuka halaman login");
    }
    @And("TRUNA003 clear field email dan password")
    public void truna003_clear_field_email_dan_password(){
        loginPage.getTxtFieldEmail().clear();
        loginPage.getTxtFieldPassword().clear();
        extentTest.log(LogStatus.PASS, "TRUNA003 clear field email dan password");
    }
    @And("TRUNA003 input text field email dan password yang valid")
    public void truna003_input_text_field_email_dan_password_yang_valid(){
        loginPage.getTxtFieldEmail().sendKeys("admin@hadir.com");
        loginPage.getTxtFieldPassword().sendKeys("admin@hadir");
        extentTest.log(LogStatus.PASS, "TRUNA003 input text field email dan password yang valid");
    }
    @And("TRUNA003 Tekan tombol masuk")
    public void truna003_tekan_tombol_masuk(){
        loginPage.getButtonMasuk().click();
        extentTest.log(LogStatus.PASS, "TRUNA003 Tekan tombol masuk");
    }
    @Then("TRUNA003 Validasi halaman home")
    public void truna003_validasi_halaman_home(){
        String textValidasi = (homePage.getValidasiLabelValidasi()==null)?"" : homePage.getValidasiLabelValidasi().getText();
        String textValidasi2 = (homePage.getLabelAplikasiHadir()==null)?"" : homePage.getLabelAplikasiHadir().getText();

        if(textValidasi.equals("") && textValidasi2.equals("")){
            isValid = false;
        }
        Assert.assertTrue(textValidasi.equals("Validator 1") && textValidasi2.equals("© 2022 Aplikasi Hadir"));
        extentTest.log(LogStatus.PASS, "TRUNA003 Validasi halaman home");
    }
    @When("TRUNA003 Tekan menu Management")
    public void truna003_tekan_menu_management(){
        registrasiUser.getVarManagement().click();
        extentTest.log(LogStatus.PASS, "TRUNA003 Tekan menu Management");
    }
    @When("TRUNA003 Tekan menu Pendaftaran User")
    public void truna003_tekan_menu_pendaftaran_user(){
        registrasiUser.getVarPendaftaranUser().click();
        extentTest.log(LogStatus.PASS, "TRUNA003 Tekan menu Pendaftaran User");
    }
    @Then("TRUNA003 Validasi halaman Pendaftaran User")
    public void truna003_validasi_halaman_pendaftaran_user(){
        String txtValidasi = (registrasiUser.getLabelValidasiRegisterUser()==null)?"" : registrasiUser.getLabelValidasiRegisterUser().getText();
        String txtValidasi2 = (registrasiUser.getLabelValidasiAccountInformation()==null)?"" : registrasiUser.getLabelValidasiAccountInformation().getText();
        if(txtValidasi.equals("") && txtValidasi2.equals("")){
            isValid = false;
        }

        Assert.assertTrue(txtValidasi.equals("Registrasi User") && txtValidasi2.equals("Account Information"));
        extentTest.log(LogStatus.PASS, "TRUNA003 Validasi halaman Pendaftaran User");
    }
    @And("TRUNA003 input text field Foto")
    public void truna003_input_text_field_foto(){
        WebElement inputFile = driver.findElement(By.name("logo"));
        inputFile.sendKeys(GlobalFunction.getFilePathInResources("\\data\\negatif\\file-php-tersembunyi.jpg"));
        extentTest.log(LogStatus.PASS, "TRUNA003 input text field Foto");
    }
    @And("TRUNA003 Input text field NIK")
    public void truna003_input_text_field_nik(){
        NIK = dataGenerator.noKtp();
        data.add(NIK);

        registrasiUser.getTxtFieldNIK().sendKeys(data.get(0));
        extentTest.log(LogStatus.PASS, "TRUNA003 Input text field NIK");
    }
    @And("TRUNA003 Input text field Nama Karyawan")
    public void truna003_input_text_field_nama_karyawan(){
        namaKaryawan = dataGenerator.dataNamaLengkap();
        data.add(namaKaryawan);

        registrasiUser.getTxtFieldNamaKaryawan().sendKeys(data.get(1));
        extentTest.log(LogStatus.PASS, "TRUNA003 Input text field Nama Karyawan");
    }
    @And("TRUNA003 Input text field Email")
    public void truna003_input_text_field_email(){
        email = dataGenerator.dataEmail();
        data.add(email);

        registrasiUser.getTxtFieldEmail().sendKeys(data.get(2));
        extentTest.log(LogStatus.PASS, "TRUNA003 Input text field Email");
    }
    @And("TRUNA003 Input text field Password")
    public void truna003_input_text_field_password(){
        password = dataGenerator.dataPassword();
        data.add(password);

        registrasiUser.getTxtFieldPassword().sendKeys(data.get(3));
        extentTest.log(LogStatus.PASS, "TRUNA003 Input text field Password");
    }
    @And("TRUNA003 Input text field Divisi")
    public void truna003_input_text_field_divisi(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, document.body.scrollHeight * 0.25);");

        registrasiUser.getTxtFieldDivisi().click();
        GlobalFunction.delay(1);

        registrasiUser.getTxtFieldDivisi().sendKeys(Keys.DOWN);
        registrasiUser.getTxtFieldDivisi().sendKeys(Keys.RETURN);
        extentTest.log(LogStatus.PASS, "TRUNA003 Input text field Divisi");
    }
    @And("TRUNA003 Input text field Unit")
    public void truna003_input_text_field_unit(){
        registrasiUser.getTxtFieldUnit().click();
        registrasiUser.getTxtFieldUnit().sendKeys(Keys.DOWN);
        registrasiUser.getTxtFieldUnit().sendKeys(Keys.RETURN);
        extentTest.log(LogStatus.PASS, "TRUNA003 Input text field Unit");
    }
    @And("TRUNA003 Input text field Posisi Kerja")
    public void truna003_input_text_field_posisi_kerja(){
        registrasiUser.getTxtFieldPosisiKerja().click();
        registrasiUser.getTxtFieldPosisiKerja().sendKeys(Keys.DOWN);
        registrasiUser.getTxtFieldPosisiKerja().sendKeys(Keys.RETURN);
        extentTest.log(LogStatus.PASS, "TRUNA003 Input text field Posisi Kerja");
    }
    @And("TRUNA003 Input text field Jabatan")
    public void truna003_input_text_field_jabatan(){
        registrasiUser.getTxtFieldJabatan().click();
        registrasiUser.getTxtFieldJabatan().sendKeys(Keys.DOWN);
        registrasiUser.getTxtFieldJabatan().sendKeys(Keys.RETURN);
        extentTest.log(LogStatus.PASS, "TRUNA003 Input text field Jabatan");
    }
    @And("TRUNA003 input text field Tipe Kontrak")
    public void truna003_input_text_field_tipe_kontrak(){
        registrasiUser.getTxtFieldTipeKontrak().click();
        while(true) {
            registrasiUser.getTxtFieldTipeKontrak().sendKeys(Keys.DOWN);
            registrasiUser.getTxtFieldTipeKontrak().sendKeys(Keys.RETURN);

            int asci = 0;
            for (int i = 0; i < registrasiUser.getTxtFieldTipeKontrak().getAttribute("value").trim().length(); i++) {
                asci = asci + (int) registrasiUser.getTxtFieldTipeKontrak().getAttribute("value").trim().charAt(i);
            }
            if (asci == 326) {
                extentTest.log(LogStatus.PASS, "TRUNA003 input text field Tipe Kontrak");

                break;
            } else {
                registrasiUser.getTxtFieldTipeKontrak().sendKeys(Keys.DOWN);
            }
            GlobalFunction.delay(2);
        }
    }
    @And ("TRUNA003 Input text field Lokasi Kerja")
    public void truna003_input_text_field_lokasi_kerja(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, document.body.scrollHeight * 0.25);");

        registrasiUser.getTxtFieldLokasiKerja().click();
        registrasiUser.getTxtFieldLokasiKerja().sendKeys(Keys.DOWN);
        registrasiUser.getTxtFieldLokasiKerja().sendKeys(Keys.RETURN);
        extentTest.log(LogStatus.PASS, "TRUNA003 Input text field Lokasi Kerja");
    }
    @And("TRUNA003 Input text Field Tipe Shift")
    public void truna003_input_text_field_tipe_shift(){
        registrasiUser.getTxtFieldShiftType().click();

        if(!registrasiUser.getTxtFieldShiftList().isEmpty()){
            WebElement cek = driver.findElement(By.className("MuiMenuItem-gutters"));
            cek.click();
        }
        extentTest.log(LogStatus.PASS, "TRUNA003 Input text Field Tipe Shift");
    }
    @And("TRUNA003 Input text field Jadwal Kerja")
    public void truna003_input_text_field_jadwal_kerja(){
        registrasiUser.getTxtFieldJadwalKerja().click();
        GlobalFunction.delay(2);

        registrasiUser.getTxtFieldJadwalKerja().sendKeys(Keys.DOWN);
        registrasiUser.getTxtFieldJadwalKerja().sendKeys(Keys.RETURN);
        extentTest.log(LogStatus.PASS, "TRUNA003 Input text field Jadwal Kerja");
    }
    @And("TRUNA003 Input text field Selfie")
    public void truna003_input_text_field_selfie(){
        registrasiUser.getTxtFieldRequiredSelfie().click();
        while (true) {
            GlobalFunction.delay(1);
            if (!registrasiUser.getTxtFieldSelfieList().isEmpty()) {
                registrasiUser.getTxtFieldSelfieList().get(0).click();
                extentTest.log(LogStatus.PASS, "TRUNA003 Input text field Selfie");
                //extentTest.log(LogStatus.PASS, "TRUPA001 Input text field Selfie");
                break;
            } else {
                System.out.println("cek : " + registrasiUser.getTxtFieldSelfieList().size());
                extentTest.log(LogStatus.FAIL, "TRUNA003 Input text field Selfie");
                //extentTest.log(LogStatus.FAIL, "TRUPA001 Input text field Selfie");
                break;
            }
        }
    }
    @When("TRUNA003 Tekan tombol Submit")
    public void truna003_tekan_tombol_submit(){
        registrasiUser.getButtonSumbit().click();
        extentTest.log(LogStatus.PASS, "TRUNA003 Tekan tombol Submit");
    }
    @Then("TRUNA003 Validasi notifikasi setelah tombol sumbit")
    public void truna003_validasi_notifikasi_setelah_tombol_sumbit(){
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
                    extentTest.log(LogStatus.PASS, "TRUNA003 Validasi notifikasi setelah tombol sumbit");
                    //extentTest.log(LogStatus.PASS, "TRUPA001 Validasi notifikasi setelah tombol sumbit");
                    break;
                }
            }else if (varInt == 10){
                extentTest.log(LogStatus.FAIL, "TRUNA003 Validasi notifikasi setelah tombol sumbit");
                //extentTest.log(LogStatus.FAIL, "TRUPA001 Validasi notifikasi setelah tombol sumbit");
                break;
            }
        }
    }
    @When("TRUNA003 Tekan Profile")
    public void truna003_tekan_profile(){
        homePage.getLabelProfil().click();
        extentTest.log(LogStatus.PASS, "TRUNA003 Tekan Profile");
    }
    @When("TRUNA003 Tekan Tombol Logout")
    public void truna003_tekan_tombol_logout(){
        homePage.getButtonLogout().click();
        extentTest.log(LogStatus.PASS, "TRUNA003 Tekan Tombol Logout");
    }
    @Then("TRUNA003 Validasi label halaman login")
    public void truna003_validasi_label_halaman_login(){
        String textLabelLogin = (loginPage.getLabelLogin()==null)?"" : loginPage.getLabelLogin().getText();
        if(textLabelLogin.equals("")){
            isValid = false;
            extentTest.log(LogStatus.FAIL, "TRUPA001 Validasi label halaman login");
        }
        Assert.assertTrue(textLabelLogin.equals("Login"));
        extentTest.log(LogStatus.PASS, "TRUNA003 Validasi label halaman login");
    }

}
