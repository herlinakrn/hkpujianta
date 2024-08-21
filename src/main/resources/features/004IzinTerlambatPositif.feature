Feature: Izin Terlambat Positif
  Scenario: TIZPU001 User input Izin Terlambat dengan isian valid
  When TIZPU001 Membuka Halaman Login
  And TIZPU001 Clear field input email dan password
  And TIZPU001 Masukan email dan password yang valid
  When TIZPU001 Tekan tombol Masuk
  Then TIZPU001 Validasi Halaman Home
  When TIZPU001 Tekan tombol Izin
  Then TIZPU001 Validasi Halaman Izin
  When TIZPU001 Tekan tombol Ajukan Izin Terlambat
  Then TIZPU001 Validasi form Ajukan Izin Terlambat
  And TIZPU001 Clear field form Ajukan Izin Terlambat
  And TIZPU001 Input field Tanggal
  And TIZPU001 Input field Jam
  And TIZPU001 Input field Keterangan
  When TIZPU001 Tekan tombol Ajukan
  Then TIZPU001 Validasi setelah melakukan input
  When TIZPU001 Tekan tombol kembali
  Then TIZPU001 Validasi halaman home setelah izin
  When TIZPU001 Tekan button stip
  When TIZPU001 tekan tombol Logout
  Then TIZPU001 Validasi halaman login