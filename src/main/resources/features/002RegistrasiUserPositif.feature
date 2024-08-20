Feature: Registrasi User Positif
  Scenario: TRUPA001 Admin melakukan registrasi user dengan isian valid
    When TRUPA001 Membuka halaman login
    And TRUPA001 clear field email dan password
    And TRUPA001 input text field email dan password yang valid
    And TRUPA001 Tekan tombol masuk
    Then TRUPA001 Validasi halaman home
    When TRUPA001 Tekan menu Management
    When TRUPA001 Tekan menu Pendaftaran User
    Then TRUPA001 Validasi halaman Pendaftaran User
    And TRUPA001 input text field Foto
    And TRUPA001 Input text field NIK
    And TRUPA001 Input text field Nama Karyawan
    And TRUPA001 Input text field Email
    And TRUPA001 Input text field Password
    And TRUPA001 Input text field Divisi
    And TRUPA001 Input text field Unit
    And TRUPA001 Input text field Posisi Kerja
    And TRUPA001 Input text field Jabatan
    And TRUPA001 Input text field Atasan
    And TRUPA001 Input text field Atasan V2
    And TRUPA001 Input text field Atasan V3
    And TRUPA001 input text field Tipe Kontrak
    And TRUPA001 Input text field Lokasi Kerja
    And TRUPA001 Input text Field Tipe Shift
    And TRUPA001 Input text field Jadwal Kerja
    And TRUPA001 Input text field Selfie
    And TRUPA001 Input text field Jumlah Cuti
    When TRUPA001 Tekan tombol Submit
    Then TRUPA001 Validasi notifikasi setelah tombol sumbit
    When TRUPA001 Tekan Profile
    When TRUPA001 Tekan Tombol Logout
    Then TRUPA001 Validasi label halaman login

    Scenario: TRUPA002 User melakukan login setelah pendaftaran user oleh admin
    When TRUPA002 Membuka halaman login
    And TRUPA002 clear field email dan password
    And TRUPA002 input text field email dan password yang valid
    When TRUPA002 Tekan tombol masuk
    Then TRUPA002 Validasi halaman home
    When TRUPA002 Tekan button stip
    When TRUPA002 tekan tombol Logout
    Then TRUPA002 Validasi halaman login