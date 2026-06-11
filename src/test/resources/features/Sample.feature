Feature: Sample feature — hapus atau rename sesuai kebutuhan

  # Scenario biasa
  Scenario: Contoh login berhasil
    Given  saya membuka halaman "https://www.example.com"
    And saya login sebagai role "standard"
    Then URL saat ini mengandung "dashboard"

  # Scenario Outline — untuk banyak data sekaligus
  Scenario Outline: Contoh validasi error login
    Given saya membuka halaman "https://www.example.com"
    And saya login dengan "<username>" dan "<password>"
    Then saya melihat pesan error "<pesanError>"

    Examples:
      | username         | password  | pesanError                  |
      | user_salah       | pass123   | Username tidak ditemukan    |
      | user@example.com |           | Password tidak boleh kosong |
