package com.juaracoding.hkpujianta.ujianta.scenariomapping;

public enum HadirScenario {
    //LOGIN
    T1("TLPA001 Login dengan menggunakan email dan password yang valid"),
    T2("TLNA002 Login dengan menggunakan email dan password yang kosong"),
    T3("TLNA003 Login dengan menggunakan email yang valid"),
    T4("TLNA004 Login dengan menggunakan password yang valid"),
    T5("TLNA005 Login dengan menggunakan email dan password yang tidak valid"),

    //REGISTRASI USER
    T6("TRUPA001 Admin melakukan registrasi user dengan isian valid"),

    //MANAGEMANT UNIT
    T7("TUNNA003 Admin menambahkan unit baru tanpa mengisi field isian"),
    T8("TUNNA004 Admin menambahkan unit baru dengan panjang karakter lebih dari 500 pada field nama unit"),

    //IZIN
    T9("TIZPU001 User input Izin Terlambat dengan isian valid"),
    T10("TIZNU003 User mengajukan izin terlambat tanpa mengisi inputan")
    ;

    private String testName;

    private HadirScenario(String value){
        testName = value;
    }

    public String getTestName(){
        return testName;
    }
}
