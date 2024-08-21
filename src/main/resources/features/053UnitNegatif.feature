#/*
#IntelliJ IDEA 2024.1.4 (Ultimate Edition)
#Build #IU-241.18034.62, built on June 21, 2024
#@Author ITS-NEW a.k.a. Herlina Kurnia Prasetiani
#Java Developer
#Created on 15/08/2024 11:06
#@Last Modified 15/08/2024 11:06
#Version 1.0
#*/

Feature: Unit Negatif
  Scenario: TUNNA003 Admin menambahkan unit baru tanpa mengisi field isian
  When TUNNA003 Tekan menu management
  When TUNNA003 Tekan menu Unit
  Then TUNNA003 Validasi halaman Unit
  When TUNNA003 Tekan tombol Tambahkan
  Then TUNNA003 Validasi modal Tambah Unit
  And TUNNA003 Clear semua inputan
  When TUNNA003 Tekan tombol tambah
  Then TUNNA003 Validasi notifikasi yang muncul setelah tombol tambah ditekan

    Scenario: TUNNA004 Admin menambahkan unit baru dengan panjang karakter lebih dari 500 pada field nama unit
    And TUNNA004 Input text field nama unit
    When TUNNA004 Tekan tombol tambah
    Then TUNNA004 Validasi notifikasi yang muncul setelah tombol tambah ditekan
    And TUNNA004 Input text search berdasarkan nama
    When TUNNA004 Tekan tombol search
    Then TUNNA004 Validasi tabel yang telah di search
    When TUNNA004 Tekan Profile
    When TUNNA004 Tekan Tombol Logout
    When TUNNA004 Validasi label halaman login