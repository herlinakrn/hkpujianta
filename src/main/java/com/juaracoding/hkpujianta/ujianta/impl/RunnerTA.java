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
                //POSITIF
                "src/main/resources/features/001LoginPositifAdmin.feature",

                //NEGATIF
                "src/main/resources/features/051LoginNegatifAdmin.feature",
                //"src/main/resources/features/003Step1Soal11.feature",
        },
        glue = "com.juaracoding.hkpujianta.ujianta.impl",
        monochrome = true,
        plugin ={"pretty","html:ujian6-report/extentreport/ujianta.html",
                "json:ujianta-report/extentreport/ujianta.json",
                "junit:ujianta-report/extentreport/ujianta.xml"
        })

public class RunnerTA extends AbstractTestNGCucumberTests {}
