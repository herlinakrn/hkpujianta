Feature: Izin Off Negatif
  Scenario: TIZONU003 User melakukan izin off tanpa menginputkan isian
  When TIZONU003 Membuka Halaman Login
  And TIZONU003 Clear field input email dan password
  And TIZONU003 Masukan email dan password yang valid
  When TIZONU003 Tekan tombol Masuk
  Then TIZONU003 Validasi Halaman Home
  When TIZONU003 Tekan tombol Izin
  Then TIZONU003 Validasi Halaman Izin
  When TIZONU003 Tekan tombol Izin Off
  Then TIZONU003 Validasi setelah menekan tombol izin off
  When TIZONU003 Tekan tombol ajukan izin off
  Then TIZONU003 Validasi Form ajukan izin off
  When TIZONU003 Tekan tombol Ajukan
  Then TIZONU003 Validasi setelah menekan tombol Ajukan
  When TIZONU003 Tekan tombol kembali
  Then TIZONU003 Validasi halaman home setelah izin off
  When TIZONU003 Tekan button stip
  When TIZONU003 tekan tombol Logout
  Then TIZONU003 Validasi halaman login