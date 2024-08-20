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
                    "@And",
                    "@When",
                    "@Then",
                    "@When",
                    "@Then",
                    "@When",
                    "@Then",
                    "@And",
                    "@And",
                    "@When",
                    "@Then",
                    "@When",
                    "@Then",
                    "@When",
                    "@When",
                    "@When",

            };

            String [] strFunction = {
                    "TIZOPU001 Membuka Halaman Login",
                    "TIZOPU001 Clear field input email dan password",
                    "TIZOPU001 Masukan email dan password yang valid",
                    "TIZOPU001 Tekan tombol Masuk",
                    "TIZOPU001 Validasi Halaman Home",
                    "TIZOPU001 Tekan tombol Izin",
                    "TIZOPU001 Validasi Halaman Izin",
                    "TIZOPU001 Tekan tombol Izin Off",
                    "TIZOPU001 Validasi setelah menekan tombol izin off",
                    "TIZOPU001 Tekan tombol ajukan izin off",
                    "TIZOPU001 Validasi Form ajukan izin off",
                    "TIZOPU001 Input tanggal izin off",
                    "TIZOPU001 input alasan izin off",
                    "TIZOPU001 Tekan tombol Ajukan",
                    "TIZOPU001 Validasi setelah menekan tombol Ajukan",
                    "TIZOPU001 Tekan tombol kembali",
                    "TIZOPU001 Validasi halaman home",
                    "TIZOPU001 Tekan button stip",
                    "TIZOPU001 tekan tombol Logout",
                    "TIZOPU001 Validasi halaman login",

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
