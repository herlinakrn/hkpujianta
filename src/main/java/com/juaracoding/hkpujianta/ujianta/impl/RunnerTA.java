package com.juaracoding.hkpujianta.ujianta.impl;

/*
IntelliJ IDEA 2024.1.4 (Ultimate Edition)
Build #IU-241.18034.62, built on June 21, 2024
@Author ITS-NEW a.k.a. Herlina Kurnia Prasetiani
Java Developer
Created on 13/08/2024 09:35
@Last Modified 13/08/2024 09:35
Version 1.0
*/

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = {
                //----------FEATURE POSITIF----------
                "src/main/resources/features/001LoginPositifAdmin.feature",
                "src/main/resources/features/002RegistrasiUserPositif.feature",
                "src/main/resources/features/003UnitPositif.feature",
                "src/main/resources/features/004IzinTerlambatPositif.feature",
                "src/main/resources/features/005IzinOffPositif.feature",
                "src/main/resources/features/006UserMonitoringPositif.feature",

                //--------FEATURE NEGATIF-------------
                "src/main/resources/features/051LoginNegatifAdmin.feature",
                "src/main/resources/features/052RegistrasiUserNegatif.feature",
                "src/main/resources/features/053UnitNegatif.feature",
                "src/main/resources/features/054IzinTerlambatNegatif.feature",
                "src/main/resources/features/055IzinOffNegatif.feature",
        },
        glue = "com.juaracoding.hkpujianta.ujianta.impl",
        monochrome = true,
        plugin ={"pretty","html:ujian6-report/extentreport/ujianta.html",
                "json:ujianta-report/extentreport/ujianta.json",
                "junit:ujianta-report/extentreport/ujianta.xml"
        })

public class RunnerTA extends AbstractTestNGCucumberTests {}
