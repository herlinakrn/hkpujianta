#/*
#IntelliJ IDEA 2024.1.4 (Ultimate Edition)
#Build #IU-241.18034.62, built on June 21, 2024
#@Author ITS-NEW a.k.a. Herlina Kurnia Prasetiani
#Java Developer
#Created on 12/08/2024 15:57
#@Last Modified 12/08/2024 15:57
#Version 1.0
#*/

  Feature: Login Positif
    Scenario Outline: TLPA001 Login dengan menggunakan email dan password yang valid
      When TLPA001 Membuka Halaman Login
      And TLPA001 Clear Field email dan password
      And TLPA001 Input textfield "<email>" email yang valid
      And TLPA001 Input textfield "<password>" password yang valid
      And TLPA001 Tekan tombol Masuk
      And TLPA001 Scroll ke akhir page
      Then TLPA001 Validasi halaman home
      When TLPA001 Tekan Profil
      When TLPA001 Tekan tombol Logout
      Then TLPA001 Validasi halaman login

      Examples:
      |email|password|
      |admin@hadir.com|admin@hadir|