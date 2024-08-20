Feature: Registrasi User Negatif
  Scenario: TRUNA003 Admin melakukan registrasi dengan foto profil format .jpg namun didalamnya script php
  When TRUNA003 Membuka halaman login
  And TRUNA003 clear field email dan password
  And TRUNA003 input text field email dan password yang valid
  And TRUNA003 Tekan tombol masuk
  Then TRUNA003 Validasi halaman home
  When TRUNA003 Tekan menu Management
  When TRUNA003 Tekan menu Pendaftaran User
  Then TRUNA003 Validasi halaman Pendaftaran User
  And TRUNA003 input text field Foto
  And TRUNA003 Input text field NIK
  And TRUNA003 Input text field Nama Karyawan
  And TRUNA003 Input text field Email
  And TRUNA003 Input text field Password
  And TRUNA003 Input text field Divisi
  And TRUNA003 Input text field Unit
  And TRUNA003 Input text field Posisi Kerja
  And TRUNA003 Input text field Jabatan
  And TRUNA003 input text field Tipe Kontrak
    And TRUNA003 Input text field Lokasi Kerja
  And TRUNA003 Input text Field Tipe Shift
  And TRUNA003 Input text field Jadwal Kerja
  And TRUNA003 Input text field Selfie
  When TRUNA003 Tekan tombol Submit
  Then TRUNA003 Validasi notifikasi setelah tombol sumbit
  When TRUNA003 Tekan Profile
  When TRUNA003 Tekan Tombol Logout
  Then TRUNA003 Validasi label halaman login





















