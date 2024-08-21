package com.juaracoding.hkpujianta.ujianta.util;

/*
IntelliJ IDEA 2024.1.4 (Ultimate Edition)
Build #IU-241.18034.62, built on June 21, 2024
@Author ITS-NEW a.k.a. Herlina Kurnia Prasetiani
Java Developer
Created on 09/08/2024 23:54
@Last Modified 09/08/2024 23:54
Version 1.0
*/
public class GenerateFunctionCucumber {
    public static void main(String[] args) {
            generateFunc();
    }

        public static void  generateFunc(){
            String [] strPrefix = {
                    "@When",
                    "@Then",
                    "@When",
                    "@When",
                    "@Then",

            };

            String [] strFunction = {
                    "TIZNU003 Tekan tombol kembali",
                    "TIZNU003 Validasi halaman home",
                    "TIZNU003 Tekan button stip",
                    "TIZNU003 tekan tombol Logout",
                    "TIZNU003 Validasi halaman login",
            };

            for (int i = 0; i < strFunction.length; i++) {
                String strFunctionz = strFunction[i].trim();
                System.out.println(strPrefix[i]+"(\""+strFunctionz+"\")");
                System.out.println("public void "+strFunctionz.replace(" ","_").toLowerCase()+"(){\n");
                System.out.println("extentTest.log(LogStatus.PASS, \""+strFunctionz+"\");");
                System.out.println("}");
            }
        }

    }
