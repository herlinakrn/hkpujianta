package com.juaracoding.hkpujianta.ujianta.impl.admin;

import com.juaracoding.hkpujianta.ujianta.impl.HadirHooks;
import com.juaracoding.hkpujianta.ujianta.page.admin.HomePage;
import com.juaracoding.hkpujianta.ujianta.page.admin.LoginPage;
import com.juaracoding.hkpujianta.ujianta.page.admin.UnitPage;
import com.juaracoding.hkpujianta.ujianta.page.admin.UserMonitoring;
import com.juaracoding.hkpujianta.ujianta.util.Constants;
import com.juaracoding.hkpujianta.ujianta.util.GlobalFunction;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.*;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;

/*
IntelliJ IDEA 2024.1.4 (Ultimate Edition)
Build #IU-241.18034.62, built on June 21, 2024
@Author ITS-NEW a.k.a. Herlina Kurnia Prasetiani
Java Developer
Created on 15/08/2024 10:44
@Last Modified 15/08/2024 10:44
Version 1.0
*/
public class UnitPositif {
    public WebDriver driver;
    private static ExtentTest extentTest;
    private LoginPage loginPage;
    private HomePage homePage;
    private UnitPage unitPage;
    private UserMonitoring userMonitoring;
    private boolean isValid;
    private String namaUnit;
    private String namaUnit2;
    private String namaUnitEdit;

    public UnitPositif(){
        isValid = true;
        this.driver = HadirHooks.driver;
        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);
        unitPage = new UnitPage(driver);
        userMonitoring = new UserMonitoring(driver);
        extentTest = HadirHooks.extentTest;
    }

    @BeforeTest
    public void initials(){
        isValid = true;
    }

    @When("TUNPA001 Tekan menu management")
    public void tunpa001_tekan_menu_management(){

        this.driver.get(Constants.URL_LOGIN); // url

        //login
        loginPage.getTxtFieldEmail().sendKeys("admin@hadir.com");
        loginPage.getTxtFieldPassword().sendKeys("admin@hadir");
        loginPage.getButtonMasuk().click();

        //validasi home
        String textValidasi = (homePage.getValidasiLabelValidasi()==null)?"" : homePage.getValidasiLabelValidasi().getText();
        String textValidasi2 = (homePage.getLabelAplikasiHadir()==null)?"" : homePage.getLabelAplikasiHadir().getText();

        if(textValidasi.equals("") && textValidasi2.equals("")){
            //isValid = false;
            extentTest.log(LogStatus.FAIL, "TUNPA001 Tekan menu management");
        }
        Assert.assertTrue(textValidasi.equals("Validator 1") && textValidasi2.equals("© 2022 Aplikasi Hadir"));

        //klik management
        unitPage.getVarManagement().click();

        extentTest.log(LogStatus.PASS, "TUNPA001 Tekan menu management");
    }
    @When("TUNPA001 Tekan menu Unit")
    public void tunpa001_tekan_menu_unit(){
        unitPage.getVarUnit().click();
        extentTest.log(LogStatus.PASS, "TUNPA001 Tekan menu Unit");
    }
    @Then("TUNPA001 Validasi halaman Unit")
    public void tunpa001_validasi_halaman_unit(){
        String txtValidasi1 = (unitPage.getValidasiUnit()==null?"":unitPage.getValidasiUnit().getText());
        String txtValidasi2 = (unitPage.getValidasiLokasiAbsen()==null?"":unitPage.getValidasiLokasiAbsen().getText());

        if(txtValidasi1.equals("") && txtValidasi2.equals("")){
            isValid = false;
            extentTest.log(LogStatus.FAIL, "TUNNA003 Validasi halaman Unit");
        }
        Assert.assertTrue(txtValidasi1.equals("Unit") && txtValidasi2.equals("LOKASI ABSEN TETAP"));
        extentTest.log(LogStatus.PASS, "TUNPA001 Validasi halaman Unit");
    }
    @When("TUNPA001 Tekan tombol Tambahkan")
    public void tunpa001_tekan_tombol_tambahkan(){
        unitPage.getButtonTambahkan().click();
        extentTest.log(LogStatus.PASS, "TUNPA001 Tekan tombol Tambahkan");
    }
    @Then("TUNPA001 Validasi modal Tambah Unit")
    public void tunpa001_validasi_modal_tambah_unit(){
        String txtValidasiModal = (unitPage.getValidasiModalTambahUnit()==null)?"":unitPage.getValidasiModalTambahUnit().getText();
        if(txtValidasiModal.equals("")){
            isValid = false;
            extentTest.log(LogStatus.FAIL, "TUNNA003 Validasi modal Tambah Unit");
        }
        Assert.assertTrue(txtValidasiModal.equals("Tambah Unit"));
        extentTest.log(LogStatus.PASS, "TUNPA001 Validasi modal Tambah Unit");
    }
    @And("TUNPA001 Clear semua inputan")
    public void tunpa001_clear_semua_inputan(){
        unitPage.getTxtFieldNamaUnit().clear();
        extentTest.log(LogStatus.PASS, "TUNPA001 Clear semua inputan");
    }
    @And("TUNPA001 Input text field nama unit")
    public void tunpa001_input_text_field_nama_unit(){
        namaUnit = "Z Coba Unit";
        unitPage.getTxtFieldNamaUnit().sendKeys(namaUnit);
        extentTest.log(LogStatus.PASS, "TUNPA001 Input text field nama unit");
    }
    @And("TUNPA001 Input text field lokasi absen tetap")
    public void tunpa001_input_text_field_lokasi_absen_tetap(){
        GlobalFunction.delay(3);
        //unitPage.getTxtFieldLocationType().click();
        //GlobalFunction.delay(3);
        WebElement cek = driver.findElement(By.id("locationType"));
        cek.click();
        extentTest.log(LogStatus.PASS, "TUNPA001 Input text field lokasi absen tetap");
    }
    @And("TUNPA001 input text field calender")
    public void tunpa001_input_text_field_calender(){
        unitPage.getTxtFieldKalender().click();
        GlobalFunction.delay(1);

        unitPage.getTxtFieldKalender().sendKeys(Keys.DOWN);
        unitPage.getTxtFieldKalender().sendKeys(Keys.RETURN);
        extentTest.log(LogStatus.PASS, "TUNPA001 Input text field calender");
    }
    @And("TUNPA001 input text field aturan cuti")
    public void tunpa001_input_text_field_aturan_cuti(){
        unitPage.getTxtFieldAturanUnit().click();
        unitPage.getTxtFieldAturanUnit().sendKeys(Keys.DOWN);
        unitPage.getTxtFieldAturanUnit().sendKeys(Keys.RETURN);
        extentTest.log(LogStatus.PASS, "TUNPA001 input text field aturan cuti");
    }
    @When("TUNPA001 tekan tombol Tambah")
    public void tunpa001_tekan_tombol_tambah(){
        unitPage.getButtonModalTambah().click();
        extentTest.log(LogStatus.PASS, "TUNPA001 tekan tombol Tambah");
    }
    @Then("TUNPA001 Validasi notifikasi yang muncul setelah tombol tambah ditekan")
    public void tunpa001_validasi_notifikasi_yang_muncul_setelah_tombol_tambah_ditekan(){
        if(unitPage.getVarNotififasiBerhasil().getText().equals("Berhasil Menambahkan Unit")){
            extentTest.log(LogStatus.PASS, "TUNPA001 Validasi notifikasi yang muncul setelah tombol tambah ditekan");
        }else {
            extentTest.log(LogStatus.FAIL, "TUNPA001 Validasi notifikasi yang muncul setelah tombol tambah ditekan");
        }
    }
    @And("TUNPA001 Input text search berdasarkan nama")
    public void tunpa001_input_text_search_berdasarkan_nama(){
        unitPage.getTxtSearchField().clear();
        unitPage.getTxtSearchField().click();
        unitPage.getTxtSearchField().sendKeys(namaUnit);
        extentTest.log(LogStatus.PASS, "TUNPA001 Input text search berdasarkan nama");
    }
    @When("TUNPA001 Tekan tombol search")
    public void tunpa001_tekan_tombol_search(){
        unitPage.getButtonSearch().click();
        extentTest.log(LogStatus.PASS, "TUNPA001 Tekan tombol search");
    }
    @Then("TUNPA001 Validasi tabel yang telah di search")
    public void tunpa001_validasi_tabel_yang_telah_di_search(){

        int varInt = 0;
        while(true){
            varInt = varInt+1;
            GlobalFunction.delay(1);
            //System.out.println("cek nama unit : " + unitPage.getTabelUnit().trim());
            if(unitPage.getTabelUnit().trim().equals(namaUnit)){
                extentTest.log(LogStatus.PASS, "TUNPA001 Validasi tabel yang telah di search");
                break;
            } else if (varInt ==10) {
                extentTest.log(LogStatus.FAIL, "TUNPA001 Validasi tabel yang telah di search");
                break;
            }
        }
    }
    @When("TUNPA001 Klik menu Management pilih User Monitoring")
    public void tunpa001_klik_menu_management_pilih_user_monitoring(){
        //userMonitoring.getVarManagement().click();

        //scroll sidebar
        WebElement sidebar = driver.findElement(By.xpath("//div[@class='sidebar MuiBox-root css-ftf74w']"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollTop = arguments[0].scrollHeight;", sidebar);

        userMonitoring.getVarUserMonitoring().click();
        userMonitoring.getBtnTambahkan().click();
        extentTest.log(LogStatus.PASS, "TUNPA001 Klik menu Management pilih User Monitoring");
    }
    @Then("TUNPA001 Validasi Form User Monitoring")
    public void tunpa001_validasi_form_user_monitoring(){
        String txtValidasiModal = (userMonitoring.getVarAddUserMonitoring()==null)?"":userMonitoring.getVarAddUserMonitoring().getText();
        if(txtValidasiModal.equals("")){
            isValid = false;
            extentTest.log(LogStatus.FAIL, "TUNPA001 Validasi Form User Monitoring");
        }
        Assert.assertTrue(txtValidasiModal.equals("Add User Monitoring"));
        extentTest.log(LogStatus.PASS, "TUNPA001 Validasi Form User Monitoring");
    }
    @Then("TUNPA001 Validasi dropdown Unit di User Monitoring")
    public void tunpa001_validasi_dropdown_unit_di_user_monitoring(){
        userMonitoring.getTxtFieldUnit().click();
        userMonitoring.getTxtFieldUnit().sendKeys(Keys.DOWN);
        userMonitoring.getTxtFieldUnit().sendKeys(namaUnit);
        userMonitoring.getTxtFieldUnit().sendKeys(Keys.RETURN);

        GlobalFunction.delay(2);

        if(userMonitoring.getTxtFieldUnit().isDisplayed()){
            extentTest.log(LogStatus.PASS, "TUNPA001 Validasi dropdown Unit di User Monitoring");
        }else{
            extentTest.log(LogStatus.FAIL, "TUNPA001 Validasi dropdown Unit di User Monitoring");
        }
    }

    //TUNPA002 Admin menambahkan unit baru dengan isian nama unit saja
    @When("TUNPA002 Tekan menu management")
    public void tunpa002_tekan_menu_management(){
        //unitPage.getVarManagement().click();
        extentTest.log(LogStatus.PASS, "TUNPA002 Tekan menu management");
    }
    @When("TUNPA002 Tekan menu Unit")
    public void tunpa002_tekan_menu_unit(){
        unitPage.getVarUnit().click();
        extentTest.log(LogStatus.PASS, "TUNPA002 Tekan menu Unit");
    }
    @Then("TUNPA002 Validasi halaman Unit")
    public void tunpa002_validasi_halaman_unit(){
        String txtValidasi1 = (unitPage.getValidasiUnit()==null?"":unitPage.getValidasiUnit().getText());
        String txtValidasi2 = (unitPage.getValidasiLokasiAbsen()==null?"":unitPage.getValidasiLokasiAbsen().getText());

        if(txtValidasi1.equals("") && txtValidasi2.equals("")){
            isValid = false;
            extentTest.log(LogStatus.FAIL, "TUNPA002 Validasi halaman Unit");
           // extentTest.log(LogStatus.FAIL, "TUNNA003 Validasi halaman Unit");
        }
        Assert.assertTrue(txtValidasi1.equals("Unit") && txtValidasi2.equals("LOKASI ABSEN TETAP"));
        extentTest.log(LogStatus.PASS, "TUNPA002 Validasi halaman Unit");
    }
    @When("TUNPA002 Tekan tombol Tambahkan")
    public void tunpa002_tekan_tombol_tambahkan(){
        unitPage.getButtonTambahkan().click();
        extentTest.log(LogStatus.PASS, "TUNPA002 Tekan tombol Tambahkan");
    }
    @Then("TUNPA002 Validasi modal Tambah Unit")
    public void tunpa002_validasi_modal_tambah_unit(){
        String txtValidasiModal = (unitPage.getValidasiModalTambahUnit()==null)?"":unitPage.getValidasiModalTambahUnit().getText();
        if(txtValidasiModal.equals("")){
            isValid = false;
            extentTest.log(LogStatus.FAIL, "TUNNA003 Validasi modal Tambah Unit");
        }
        Assert.assertTrue(txtValidasiModal.equals("Tambah Unit"));
        //extentTest.log(LogStatus.PASS, "TUNPA001 Validasi modal Tambah Unit");
        extentTest.log(LogStatus.PASS, "TUNPA002 Validasi modal Tambah Unit");
    }
    @And("TUNPA002 Clear semua inputan")
    public void tunpa002_clear_semua_inputan(){
        unitPage.getTxtFieldNamaUnit().clear();
        extentTest.log(LogStatus.PASS, "TUNPA002 Clear semua inputan");
    }
    @And("TUNPA002 Input text field nama unit")
    public void tunpa002_input_text_field_nama_unit(){
        namaUnit2 = "Ini Coba Unit";
        unitPage.getTxtFieldNamaUnit().sendKeys(namaUnit2);
        extentTest.log(LogStatus.PASS, "TUNPA002 Input text field nama unit");
    }
    @When("TUNPA002 Tekan tombol tambah")
    public void tunpa002_tekan_tombol_tambah(){
        unitPage.getButtonModalTambah().click();
        extentTest.log(LogStatus.PASS, "TUNPA002 Tekan tombol tambah");
    }
    @Then("TUNPA002 Validasi notifikasi yang muncul setelah tombol tambah ditekan")
    public void tunpa002_validasi_notifikasi_yang_muncul_setelah_tombol_tambah_ditekan(){
        if(unitPage.getVarNotififasiBerhasil().getText().equals("Berhasil Menambahkan Unit")){
            extentTest.log(LogStatus.PASS, "TUNPA002 Validasi notifikasi yang muncul setelah tombol tambah ditekan");
        }else {
            extentTest.log(LogStatus.FAIL, "TUNPA002 Validasi notifikasi yang muncul setelah tombol tambah ditekan");
        }
    }
    @And("TUNPA002 Input text search berdasarkan nama")
    public void tunpa002_input_text_search_berdasarkan_nama(){
        unitPage.getTxtSearchField().clear();
        unitPage.getTxtSearchField().click();
        unitPage.getTxtSearchField().sendKeys(namaUnit2);
        extentTest.log(LogStatus.PASS, "TUNPA002 Input text search berdasarkan nama");
    }
    @When("TUNPA002 Tekan tombol search")
    public void tunpa002_tekan_tombol_search(){
        unitPage.getButtonSearch().click();
        extentTest.log(LogStatus.PASS, "TUNPA002 Tekan tombol search");
    }
    @Then("TUNPA002 Validasi tabel yang telah di search")
    public void tunpa002_validasi_tabel_yang_telah_di_search(){
        int varInt = 0;
        while(true){
            varInt = varInt+1;
            GlobalFunction.delay(1);
            if(unitPage.getTabelUnit().trim().equals(namaUnit2)){
                extentTest.log(LogStatus.PASS, "TUNPA002 Validasi tabel yang telah di search");
                break;
            } else if (varInt ==10) {
                extentTest.log(LogStatus.FAIL, "TUNPA002 Validasi tabel yang telah di search");
                break;
            }
        }
    }
    @When("TUNPA002 Tekan titik tiga untuk edit")
    public void tunpa002_tekan_titik_tiga_untuk_edit(){
        unitPage.getBtnTitikTiga().click();
        extentTest.log(LogStatus.PASS, "TUNPA002 Tekan titik tiga untuk edit");
    }
    @When("TUNPA002 Pilih edit")
    public void tunpa002_pilih_edit(){
        unitPage.getBtnEdit().click();
        extentTest.log(LogStatus.PASS, "TUNPA002 Pilih edit");
    }
    @Then("TUNPA002 Validasi Modal Edit Unit")
    public void tunpa002_validasi_modal_edit_unit(){
        String txtValidasiModal = (unitPage.getFormModalEdit()==null)?"":unitPage.getFormModalEdit().getText();
        if(txtValidasiModal.equals("")){
            isValid = false;
            extentTest.log(LogStatus.FAIL, "TUNPA002 Validasi Modal Edit Unit");
        }
        Assert.assertTrue(txtValidasiModal.equals("Edit Unit"));
        extentTest.log(LogStatus.PASS, "TUNPA002 Validasi Modal Edit Unit");
    }
    @And("TUNPA002 Edit bagian field nama unit")
    public void tunpa002_edit_bagian_field_nama_unit(){
        namaUnitEdit = "Edit Unit by H";
        GlobalFunction.delay(1);

        unitPage.getTxtFieldNamaUnit().clear();
        unitPage.getTxtFieldNamaUnit().sendKeys(namaUnitEdit);

        extentTest.log(LogStatus.PASS, "TUNPA002 Edit bagian field nama unit");
    }
    @When("TUNPA002 Tekan tombol simpan")
    public void tunpa002_tekan_tombol_simpan(){
        unitPage.getBtnSimpanEdit().click();
        extentTest.log(LogStatus.PASS, "TUNPA002 Tekan tombol simpan");
    }
    @Then("TUNPA002 Validasi hasil edit nama Unit")
    public void tunpa002_validasi_hasil_edit_nama_unit(){
        GlobalFunction.delay(1);
        unitPage.getTxtSearchField().clear();
        unitPage.getTxtSearchField().click();
        unitPage.getTxtSearchField().sendKeys(namaUnitEdit);
        unitPage.getButtonSearch().click();

        WebElement tabel = driver.findElement(By.xpath("/html/body/div[1]/div/div/div/div[1]/div/div/div/div[2]/div/table/tbody"));
        WebElement nama = tabel.findElement(By.tagName("h6"));

        if(nama.getText().equals(namaUnitEdit)){
            extentTest.log(LogStatus.PASS, "TUNPA002 Validasi hasil edit nama Unit");
        }else{
            extentTest.log(LogStatus.FAIL, "TUNPA002 Validasi hasil edit nama Unit");
        }
    }
    @When("TUNPA002 Tekan titik tiga untuk delete")
    public void tunpa002_tekan_titik_tiga_untuk_delete(){
        unitPage.getBtnTitikTiga().click();
        extentTest.log(LogStatus.PASS, "TUNPA002 Tekan titik tiga untuk delete");
    }
    @When("TUNPA002 Tekan Tombol delete")
    public void tunpa002_tekan_tombol_delete(){
        GlobalFunction.delay(3);
        unitPage.getBtnDelete().click();
        GlobalFunction.delay(1);
        unitPage.getBtnYa().click();
        extentTest.log(LogStatus.PASS, "TUNPA002 Tekan Tombol delete");
    }
    @Then("TUNPA002 Validasi data yang telah di delete")
    public void tunpa002_validasi_data_yang_telah_di_delete(){
        GlobalFunction.delay(1);
        unitPage.getTxtSearchField().clear();
        //unitPage.getTxtSearchField().click();
        unitPage.getTxtSearchField().sendKeys("coba");
        unitPage.getButtonSearch().click();

        WebElement tabel = driver.findElement(By.xpath("/html/body/div[1]/div/div/div/div[1]/div/div/div/div[2]/div/table/tbody"));
        WebElement nama = tabel.findElement(By.tagName("h6"));

        if(nama.getText().equals(namaUnitEdit)){
            extentTest.log(LogStatus.FAIL, "TUNPA002 Validasi data yang telah di delete");
        }else{
            extentTest.log(LogStatus.PASS, "TUNPA002 Validasi data yang telah di delete");
        }
    }
    @When("TUNPA002 Tekan Profile")
    public void tunpa002_tekan_profile(){
        homePage.getLabelProfil().click();
        extentTest.log(LogStatus.PASS, "TUNPA002 Tekan Profile");
    }
    @When("TUNPA002 Tekan Tombol Logout")
    public void tunpa002_tekan_tombol_logout(){
        homePage.getButtonLogout().click();
        extentTest.log(LogStatus.PASS, "TUNPA002 Tekan Tombol Logout");
    }
    @Then("TUNPA002 Validasi label halaman login")
    public void tunpa002_validasi_label_halaman_login(){
        if(loginPage.getLabelLogin().getText().equals("")){
            extentTest.log(LogStatus.FAIL, "TUNPA002 Validasi label halaman login");
        }else {
            extentTest.log(LogStatus.PASS, "TUNPA002 Validasi label halaman login");
        }
    }

}
