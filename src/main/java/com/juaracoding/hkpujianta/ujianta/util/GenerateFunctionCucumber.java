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
                    "@And",
                    "@And",
                    "@When",
                    "@Then",
                    "@When",
                    "@When",
                    "@Then",
                    "@And",
                    "@When",
                    "@When",
                    "@When",
                    "@Then",
                    "@And",
                    "@When",
                    "@Then",
                    "@When",
                    "@When",
                    "@Then",

            };

            String [] strFunction = {
                    "TUMPA002 Membuka Halaman Login",
                    "TUMPA002 Clear field input email dan password",
                    "TUMPA002 Masukan email dan password yang valid",
                    "TUMPA002 Tekan tombol Masuk",
                    "TUMPA002 Validasi Halaman Home",
                    "TUMPA002 Tekan menu Management",
                    "TUMPA002 Tekan menu User Monitoring",
                    "TUMPA002 Validasi halaman User monitoring",
                    "TUMPA002 Input keyword pada text field search",
                    "TUMPA002 Tekan tombol search",
                    "TUMPA002 Tekan Tombol Titik tiga",
                    "TUMPA002 Tekan tombol edit",
                    "TUMPA002 Validasi Halaman edit user monitoring",
                    "TUMPA002 Ubah text field nama",
                    "TUMPA002 Tekan tombol ubah",
                    "TUMPA002 Validasi setelah menekan tombol ubah",
                    "TUMPA002 Tekan Profile",
                    "TUMPA002 Tekan Tombol Logout",
                    "TUMPA002 Validasi label halaman login",
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
