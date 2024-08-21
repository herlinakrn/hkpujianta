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

    Scenario: TIZOPA002 Admin melakukan validasi pada menu laporan izin off
    When TIZOPA002 Membuka Halaman Login
    And TIZOPA002 Clear field input email dan password
    And TIZOPA002 Masukan email dan password yang valid
    When TIZOPA002 Tekan tombol Masuk
    Then TIZOPA002 Validasi Halaman Home
    When TIZOPA002 Tekan menu laporan
    When TIZOPA002 Pilih menu Izin Off
    Then TIZOPA002 Validasi menu izin Off
    And TIZOPA002 Input text search berdasarkan nama
    When TIZOPA002 Tekan tombol search
    And TIZOPA002 Validasi tabel yang telah di search
    When TIZOPA002 Tekan Profile
    When TIZOPA002 Tekan Tombol Logout
    Then TIZOPA002 Validasi label halaman login