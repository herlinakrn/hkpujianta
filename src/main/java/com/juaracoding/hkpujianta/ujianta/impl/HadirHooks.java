package com.juaracoding.hkpujianta.ujianta.impl;

import com.juaracoding.hkpujianta.ujianta.connection.DriverSingleton;
import com.juaracoding.hkpujianta.ujianta.scenariomapping.HadirScenario;
import com.juaracoding.hkpujianta.ujianta.util.Constants;
import com.juaracoding.hkpujianta.ujianta.util.GlobalFunction;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import io.cucumber.java.*;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

/*
IntelliJ IDEA 2024.1.4 (Ultimate Edition)
Build #IU-241.18034.62, built on June 21, 2024
@Author ITS-NEW a.k.a. Herlina Kurnia Prasetiani
Java Developer
Created on 12/08/2024 17:52
@Last Modified 12/08/2024 17:52
Version 1.0
*/
public class HadirHooks {

    public static WebDriver driver;
    public static ExtentTest extentTest;
    public static ExtentReports reports = new ExtentReports(GlobalFunction.rootProject+"/"+
            GlobalFunction.extendReportName +"-main/extentreport/login.html");
    private static HadirScenario[] tests = HadirScenario.values();
    private static final int[] DATA_OUTLINE = {
            //LOGIN
            1, //TLPA001 - Login Dengan email Dan Password Yang Valid
            1, //TLNA002 - Login dengan menggunakan email dan password yang kosong
            1, //TLNA003 - Login dengan menggunakan email yang valid
            1, //TLNA004 - Login dengan menggunakan password yang valid
            1, //TLNA005 - Login dengan menggunakan email dan password yang tidak valid

            //REGISTRASI USER
            1, //TRUPA001 - Admin melakukan registrasi user dengan isian valid

            //MANAGENET UNIT
            1, //TUNNA003 Admin menambahkan unit baru tanpa mengisi field isian
            1, //TUNNA004 Admin menambahkan unit baru dengan panjang karakter lebih dari 500 pada field nama unit

            //IZIN TERLAMBAT
            1, //TIZPU001 User input Izin Terlambat dengan isian valid
            1, //TIZNU003 User mengajukan izin terlambat tanpa mengisi inputan

            //IZIN OFF
            1, //TIZOPU001 User mengajukan izin off dengan isian valid
            1, //TIZOPA002 Admin melakukan validasi pada menu laporan izin off
            1, //TIZONU003 User melakukan izin off tanpa menginputkan isian

            //USER MONITORING
            1, //TUMPA001 Admin melakukan pencarian data dengan keyword 'test'
            1, //TUMPA002 Admin melakukan edit pada nama user
    };

    private String testReport = "";

    @Before
    public void setUp() {
        DriverSingleton.getInstance(Constants.EDGE);
        driver = DriverSingleton.getDriver();
        testReport = tests[GlobalFunction.testCount].getTestName();
        extentTest = reports.startTest(testReport);
        if(GlobalFunction.countOutline==DATA_OUTLINE[GlobalFunction.testCount])
        {
            GlobalFunction.countOutline=0;
            GlobalFunction.testCount++;
        }
        GlobalFunction.countOutline++;
    }

    @AfterStep
    public void getResultStatus(Scenario scenario) throws IOException {
        if(scenario.isFailed()) {
            String screenshotPath = GlobalFunction.getScreenshot(driver, GlobalFunction.extendReportName
                    +scenario.getName().replace(" ", "_"));
            extentTest.log(LogStatus.FAIL, scenario.getName()+"\n"
                    +extentTest.addScreenCapture(screenshotPath));
        }
    }

    @After
    public void closeObject() {
        reports.endTest(extentTest);
        reports.flush();
    }

    @AfterAll
    public static void closeBrowser() {
        GlobalFunction.delay(Constants.TIMEOUT_DELAY, Constants.GLOB_PARAM_DELAY);
        DriverSingleton.closeObjectInstance();
    }

}
