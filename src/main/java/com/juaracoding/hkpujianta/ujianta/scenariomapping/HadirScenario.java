package com.juaracoding.hkpujianta.ujianta.scenariomapping;

public enum HadirScenario {
    //-----LOGIN POSITIF ADMIN-------
    T1("TLPA001 Login dengan menggunakan email dan password yang valid"),

    //------REGISTRASI USER POSITIF--------
    T2("TRUPA001 Admin melakukan registrasi user dengan isian valid"),
    T3("TRUPA002 User melakukan login setelah pendaftaran user oleh admin"),

    //------MANAGEMANT UNIT POSITIF-------
    T4("TUNPA001 Admin menambahkan unit baru dengan isian valid"),
    T5("TUNPA002 Admin menambahkan unit baru dengan isian nama unit saja"),

    //------IZIN TERLAMBAT POSITIF--------
    T6("TIZPU001 User input Izin Terlambat dengan isian valid"),

    //------IZIN OFF POSITIF------------
    T7("TIZOPU001 User mengajukan izin off dengan isian valid"),
    T8("TIZOPA002 Admin melakukan validasi pada menu laporan izin off"),

    //------USER MONITORING POSITIF-----------
    T9("TUMPA001 Admin melakukan pencarian data dengan keyword 'test'"),
    T10("TUMPA002 Admin melakukan edit pada nama user"),

    //------LOGIN ADMIN NEGATIF----------------
    T11("TLNA002 Login dengan menggunakan email dan password yang kosong"),
    T12("TLNA003 Login dengan menggunakan email yang valid"),
    T13("TLNA004 Login dengan menggunakan password yang valid"),
    T14("TLNA005 Login dengan menggunakan email dan password yang tidak valid"),

    //-------REGISTRASI USER NEGATIF-----------
    T15("TRUNA003 Admin melakukan registrasi dengan foto profil format .jpg namun didalamnya script php"),

    //--------UNIT NEGATIF----------------
    T16("TUNNA003 Admin menambahkan unit baru tanpa mengisi field isian"),
    T17("TUNNA004 Admin menambahkan unit baru dengan panjang karakter lebih dari 500 pada field nama unit"),

    //--------IZIN TERLAMBAT NEGATIF---------------
    T18("TIZNU003 User mengajukan izin terlambat tanpa mengisi inputan"),

    //--------IZIN OFF NEGATIF---------------
    T19("TIZONU003 User melakukan izin off tanpa menginputkan isian")
    ;

    private String testName;

    private HadirScenario(String value){
        testName = value;
    }

    public String getTestName(){
        return testName;
    }
}
