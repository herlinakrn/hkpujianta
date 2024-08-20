Feature: Izin Off Positif
  Scenario: TIZOPU001 User mengajukan izin off dengan isian valid
  When TIZOPU001 Membuka Halaman Login
  And TIZOPU001 Clear field input email dan password
  And TIZOPU001 Masukan email dan password yang valid
  When TIZOPU001 Tekan tombol Masuk
  And TIZOPU001 Validasi Halaman Home
  When TIZOPU001 Tekan tombol Izin
  Then TIZOPU001 Validasi Halaman Izin
  When TIZOPU001 Tekan tombol Izin Off
  Then TIZOPU001 Validasi setelah menekan tombol izin off
  When TIZOPU001 Tekan tombol ajukan izin off
  Then TIZOPU001 Validasi Form ajukan izin off
  And TIZOPU001 Input tanggal izin off
  And TIZOPU001 input alasan izin off
  When TIZOPU001 Tekan tombol Ajukan
  Then TIZOPU001 Validasi setelah menekan tombol Ajukan
  When TIZOPU001 Tekan tombol kembali
  Then TIZOPU001 Validasi halaman home setelah izin off
  When TIZOPU001 Tekan button stip
  When TIZOPU001 tekan tombol Logout
  When TIZOPU001 Validasi halaman login