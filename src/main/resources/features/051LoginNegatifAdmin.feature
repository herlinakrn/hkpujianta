#/*
#IntelliJ IDEA 2024.1.4 (Ultimate Edition)
#Build #IU-241.18034.62, built on June 21, 2024
#@Author ITS-NEW a.k.a. Herlina Kurnia Prasetiani
#Java Developer
#Created on 12/08/2024 15:57
#@Last Modified 12/08/2024 15:57
#Version 1.0
#*/

  Feature: Login Negatif
    Scenario: TLNA002 Login dengan menggunakan email dan password yang kosong
      When TLNA002 Clear field email dan password
      And TLNA002 Input text field email empty string
      And TLNA002 Input text field password empty string
      And TLNA002 Tekan tombol Masuk
      Then TLNA002 Validasi notifikasi yang muncul saat tombol masuk ditekan

      Scenario: TLNA003 Login dengan menggunakan email yang valid
        When TLNA003 Clear field email dan password
        And TLNA003 Input text field email yang valid
        And TLNA003 Input text field password yang tidak valid
        And TLNA003 Tekan tombol Masuk
        Then TLNA003 Validasi notifikasi yang muncul saat tombol masuk ditekan

        Scenario: TLNA004 Login dengan menggunakan password yang valid
          When TLNA004 Clear field email dan password
          And TLNA004 Input text field email yang tidak valid
          And TLNA004 Input text field password yang valid
          And TLNA004 Tekan tombol Masuk
          Then TLNA004 Validasi notifikasi yang muncul saat tombol masuk ditekan

          Scenario: TLNA005 Login dengan menggunakan email dan password yang tidak valid
            When TLNA005 Clear field email dan password
            And TLNA005 input text field email yang tidak valid
            And TLNA005 input text field password yang tidak valid
            And TLNA005 Tekan tombol Masuk
            Then TLNA005 Validasi notifikasi yang muncul saat tombol masuk ditekan