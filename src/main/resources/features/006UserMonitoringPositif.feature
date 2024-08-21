Feature: User Monitoring Positif
  Scenario: TUMPA001 Admin melakukan pencarian data dengan keyword 'test'
  When TUMPA001 Membuka Halaman Login
  And TUMPA001 Clear field input email dan password
  And TUMPA001 Masukan email dan password yang valid
  When TUMPA001 Tekan tombol Masuk
  Then TUMPA001 Validasi Halaman Home
  When TUMPA001 Tekan menu Management
  When TUMPA001 Tekan menu User Monitoring
  Then TUMPA001 Validasi halaman User monitoring
  And TUMPA001 Input keyword pada text field search
  When TUMPA001 Tekan tombol search
  Then TUMPA001 Validasi setelah menekan tombol search
  When TUMPA001 Tekan Profile
  When TUMPA001 Tekan Tombol Logout
  Then TUMPA001 Validasi label halaman login

    Scenario: TUMPA002 Admin melakukan edit pada nama user
    When TUMPA002 Membuka Halaman Login
    And TUMPA002 Clear field input email dan password
    And TUMPA002 Masukan email dan password yang valid
    When TUMPA002 Tekan tombol Masuk
    Then TUMPA002 Validasi Halaman Home
    When TUMPA002 Tekan menu Management
    When TUMPA002 Tekan menu User Monitoring
    Then TUMPA002 Validasi halaman User monitoring
    And TUMPA002 Input keyword pada text field search
    When TUMPA002 Tekan tombol search
    When TUMPA002 Tekan Tombol Titik tiga
    When TUMPA002 Tekan tombol edit
    Then TUMPA002 Validasi Halaman edit user monitoring
    And TUMPA002 Ubah text field nama
    When TUMPA002 Tekan tombol ubah
    Then TUMPA002 Validasi setelah menekan tombol ubah
    When TUMPA002 Tekan Profile
    When TUMPA002 Tekan Tombol Logout
    Then TUMPA002 Validasi label halaman login