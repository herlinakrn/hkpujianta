Feature: Izin Negatif
  Scenario:TIZNU003 User mengajukan izin terlambat tanpa mengisi inputan
  When TIZNU003 Membuka Halaman Login
  And TIZNU003 Clear field input email dan password
  And TIZNU003 Masukan email dan password yang valid
  When TIZNU003 Tekan tombol Masuk
  Then TIZNU003 Validasi Halaman Home
  When TIZNU003 Tekan tombol Izin
  Then TIZNU003 Validasi Halaman Izin
  When TIZNU003 Tekan tombol Ajukan Izin Terlambat
  When TIZNU003 Validasi form Ajukan Izin Terlambat
  When TIZNU003 Tekan tombol Ajukan
  When TIZNU003 Validasi notifikasi setelah tekan tombol Ajukan