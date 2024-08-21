Feature: Unit Positif
  Scenario: TUNPA001 Admin menambahkan unit baru dengan isian valid
  When TUNPA001 Tekan menu management
  When TUNPA001 Tekan menu Unit
  Then TUNPA001 Validasi halaman Unit
  When TUNPA001 Tekan tombol Tambahkan
  Then TUNPA001 Validasi modal Tambah Unit
  And TUNPA001 Clear semua inputan
  And TUNPA001 Input text field nama unit
  And TUNPA001 Input text field lokasi absen tetap
  And TUNPA001 input text field calender
  And TUNPA001 input text field aturan cuti
  When TUNPA001 tekan tombol Tambah
  Then TUNPA001 Validasi notifikasi yang muncul setelah tombol tambah ditekan
  And TUNPA001 Input text search berdasarkan nama
  When TUNPA001 Tekan tombol search
  Then TUNPA001 Validasi tabel yang telah di search
  When TUNPA001 Klik menu Management pilih User Monitoring
  Then TUNPA001 Validasi Form User Monitoring
  Then TUNPA001 Validasi dropdown Unit di User Monitoring

    Scenario: TUNPA002 Admin menambahkan unit baru dengan isian nama unit saja
    When TUNPA002 Tekan menu management
    When TUNPA002 Tekan menu Unit
    Then TUNPA002 Validasi halaman Unit
    When TUNPA002 Tekan tombol Tambahkan
    Then TUNPA002 Validasi modal Tambah Unit
    And TUNPA002 Clear semua inputan
    And TUNPA002 Input text field nama unit
    When TUNPA002 Tekan tombol tambah
    Then TUNPA002 Validasi notifikasi yang muncul setelah tombol tambah ditekan
    And TUNPA002 Input text search berdasarkan nama
    When TUNPA002 Tekan tombol search
    Then TUNPA002 Validasi tabel yang telah di search
    When TUNPA002 Tekan titik tiga untuk edit
    When TUNPA002 Pilih edit
    Then TUNPA002 Validasi Modal Edit Unit
    And TUNPA002 Edit bagian field nama unit
    When TUNPA002 Tekan tombol simpan
    Then TUNPA002 Validasi hasil edit nama Unit
    When TUNPA002 Tekan titik tiga untuk delete
    When TUNPA002 Tekan Tombol delete
    Then TUNPA002 Validasi data yang telah di delete
    When TUNPA002 Tekan Profile
    When TUNPA002 Tekan Tombol Logout
    Then TUNPA002 Validasi label halaman login