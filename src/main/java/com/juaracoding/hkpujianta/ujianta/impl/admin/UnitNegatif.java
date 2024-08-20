package com.juaracoding.hkpujianta.ujianta.impl.admin;

import com.juaracoding.hkpujianta.ujianta.impl.HadirHooks;
import com.juaracoding.hkpujianta.ujianta.page.admin.HomePage;
import com.juaracoding.hkpujianta.ujianta.page.admin.LoginPage;
import com.juaracoding.hkpujianta.ujianta.page.admin.UnitPage;
import com.juaracoding.hkpujianta.ujianta.util.Constants;
import com.juaracoding.hkpujianta.ujianta.util.GlobalFunction;
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
Created on 15/08/2024 11:06
@Last Modified 15/08/2024 11:06
Version 1.0
*/
public class UnitNegatif {
    public WebDriver driver;
    private static ExtentTest extentTest;
    private LoginPage loginPage;
    private HomePage homePage;
    private UnitPage unitPage;
    private boolean isValid;
    private String namaUnitLongChar;

    public UnitNegatif(){
        isValid = true;
        this.driver = HadirHooks.driver;
        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);
        unitPage = new UnitPage(driver);
        extentTest = HadirHooks.extentTest;
    }

    @BeforeTest
    public void initials(){
        isValid = true;
    }

    //TUNNA003 Admin menambahkan unit baru tanpa mengisi field isian
    @When("TUNNA003 Tekan menu management")
    public void tunna003_tekan_menu_management(){
        this.driver.get(Constants.URL_LOGIN); // url

        //login
        loginPage.getTxtFieldEmail().sendKeys("admin@hadir.com");
        loginPage.getTxtFieldPassword().sendKeys("admin@hadir");
        loginPage.getButtonMasuk().click();

        //validasi home
        String textValidasi = (homePage.getValidasiLabelValidasi()==null)?"" : homePage.getValidasiLabelValidasi().getText();
        String textValidasi2 = (homePage.getLabelAplikasiHadir()==null)?"" : homePage.getLabelAplikasiHadir().getText();

        if(textValidasi.equals("") && textValidasi2.equals("")){
            isValid = false;
        }
        Assert.assertTrue(textValidasi.equals("Validator 1") && textValidasi2.equals("© 2022 Aplikasi Hadir"));

        //klik management
        unitPage.getVarManagement().click();
        extentTest.log(LogStatus.PASS, "TUNNA003 Tekan menu management");
    }
    @When("TUNNA003 Tekan menu Unit")
    public void tunna003_tekan_menu_unit(){
        unitPage.getVarUnit().click();
        extentTest.log(LogStatus.PASS, "TUNNA003 Tekan menu Unit");
    }
    @Then("TUNNA003 Validasi halaman Unit")
    public void tunna003_validasi_halaman_unit(){
        String txtValidasi1 = (unitPage.getValidasiUnit()==null?"":unitPage.getValidasiUnit().getText());
        String txtValidasi2 = (unitPage.getValidasiLokasiAbsen()==null?"":unitPage.getValidasiLokasiAbsen().getText());

        if(txtValidasi1.equals("") && txtValidasi2.equals("")){
            isValid = false;
            extentTest.log(LogStatus.FAIL, "TUNNA003 Validasi halaman Unit");
        }
        Assert.assertTrue(txtValidasi1.equals("Unit") && txtValidasi2.equals("LOKASI ABSEN TETAP"));
        extentTest.log(LogStatus.PASS, "TUNNA003 Validasi halaman Unit");
    }
    @When("TUNNA003 Tekan tombol Tambahkan")
    public void tunna003_tekan_tombol_tambahkan(){
        unitPage.getButtonTambahkan().click();
        extentTest.log(LogStatus.PASS, "TUNNA003 Tekan tombol Tambahkan");
    }
    @Then("TUNNA003 Validasi modal Tambah Unit")
    public void tunna003_validasi_modal_tambah_unit(){
        String txtValidasiModal = (unitPage.getValidasiModalTambahUnit()==null)?"":unitPage.getValidasiModalTambahUnit().getText();
        if(txtValidasiModal.equals("")){
            isValid = false;
            extentTest.log(LogStatus.FAIL, "TUNNA003 Validasi modal Tambah Unit");
        }
        Assert.assertTrue(txtValidasiModal.equals("Tambah Unit"));
        extentTest.log(LogStatus.PASS, "TUNNA003 Validasi modal Tambah Unit");
    }
    @And("TUNNA003 Clear semua inputan")
    public void tunna003_clear_semua_inputan(){
        unitPage.getTxtFieldNamaUnit().clear();
        //unitPage.getTxtFieldLocationType().clear();
        //unitPage.getTxtFieldKalender().clear();
        //unitPage.getTxtFieldAturanUnit().clear();
        extentTest.log(LogStatus.PASS, "TUNNA003 Clear semua inputan");
    }
    @When("TUNNA003 Tekan tombol tambah")
    public void tunna003_tekan_tombol_tambah(){
        unitPage.getButtonModalTambah().click();
        extentTest.log(LogStatus.PASS, "TUNNA003 Tekan tombol tambah");
    }
    @Then("TUNNA003 Validasi notifikasi yang muncul setelah tombol tambah ditekan")
    public void tunna003_validasi_notifikasi_yang_muncul_setelah_tombol_tambah_ditekan(){
        String txtValidasi = (unitPage.getVarError()==null)?"":unitPage.getVarError().getText();
        if(txtValidasi.equals("")){
            isValid = false;
            extentTest.log(LogStatus.FAIL, "TUNNA003 Validasi notifikasi yang muncul setelah tombol tambah ditekan");
        }
        Assert.assertTrue(txtValidasi.equals("Nama unit tidak boleh kosong!."));
        extentTest.log(LogStatus.PASS, "TUNNA003 Validasi notifikasi yang muncul setelah tombol tambah ditekan");
    }

    //TUNNA004 Admin menambahkan unit baru dengan panjang karakter lebih dari 500 pada field nama unit
    @And ("TUNNA004 Input text field nama unit")
    public void tunna004_input_text_field_nama_unit(){
        unitPage.getTxtFieldNamaUnit().clear();

        namaUnitLongChar = "Lorem Ipsum is simply dummy text of the printing and typesetting industry. " +
                "Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, " +
                "when an unknown printer took a galley of type and scrambled it to make a type specimen book. " +
                "It has survived not only five centuries, but also the leap into electronic typesetting, " +
                "remaining essentially unchanged. It was popularised in the 1960s with the release of " +
                "Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing " +
                "software like Aldus PageMaker including versions of Lorem Ipsum.";

        unitPage.getTxtFieldNamaUnit().sendKeys(namaUnitLongChar);

        extentTest.log(LogStatus.PASS, "TUNNA004 Input text field nama unit");
    }
    @When("TUNNA004 Tekan tombol tambah")
    public void tunna004_tekan_tombol_tambah(){
        unitPage.getButtonModalTambah().click();
        extentTest.log(LogStatus.PASS, "TUNNA004 Tekan tombol tambah");
    }
    @Then("TUNNA004 Validasi notifikasi yang muncul setelah tombol tambah ditekan")
    public void tunna004_validasi_notifikasi_yang_muncul_setelah_tombol_tambah_ditekan(){
        String txtValidasi = (unitPage.getVarNotififasiBerhasil()==null)?"":unitPage.getVarNotififasiBerhasil().getText();
        if(txtValidasi.equals("")){
            isValid = false;
            extentTest.log(LogStatus.FAIL, "TUNNA004 Validasi notifikasi yang muncul setelah tombol tambah ditekan");
        }
        Assert.assertTrue(txtValidasi.equals("Berhasil Menambahkan Unit"));
        extentTest.log(LogStatus.PASS, "TUNNA004 Validasi notifikasi yang muncul setelah tombol tambah ditekan");
    }
    @And ("TUNNA004 Input text search berdasarkan nama")
    public void tunna004_input_text_search_berdasarkan_nama(){
        unitPage.getTxtSearchField().clear(); // clear dulu
        //System.out.println("cek : " + namaUnitLongChar);
        unitPage.getTxtSearchField().sendKeys("Lorem");
        extentTest.log(LogStatus.PASS, "TUNNA004 Input text search berdasarkan nama");
    }
    @When("TUNNA004 Tekan tombol search")
    public void tunna004_tekan_tombol_search(){
        unitPage.getButtonSearch().click();
        extentTest.log(LogStatus.PASS, "TUNNA004 Tekan tombol search");
    }
    @Then("TUNNA004 Validasi tabel yang telah di search")
    public void tunna004_validasi_tabel_yang_telah_di_search(){
        int varInt = 0;
        while(true){
            varInt = varInt+1;
            GlobalFunction.delay(1);
            if(!unitPage.getTabelUnit().trim().equals(namaUnitLongChar)){
                extentTest.log(LogStatus.FAIL, "TUNNA004 Validasi tabel yang telah di search");
                break;
            } else if (varInt ==10) {
                extentTest.log(LogStatus.PASS, "TUNNA004 Validasi tabel yang telah di search");
                break;
            }
        }
    }
}
