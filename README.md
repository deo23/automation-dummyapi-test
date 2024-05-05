# automation-dummyapi-test

## Overview Project
Dummy API yang layanan API siap pakai yang diisi dengan data palsu. Ini berfungsi sebagai area uji coba untuk bermain-main dengan pengguna nyata dan mengirimkan data. Terdapat lebih dari 100 pengguna palsu, 800+ posting dan gambar, serta lebih dari 1.000 komentar. Terdapat dua jenis antarmuka API yang tersedia: endpoint REST data API dan GraphQL API.

## Library yang dibutuhkan untuk Build (Build With)
Proyek ini menggunakan Maven sebagai manajer proyek dan tidak memerlukan pustaka eksternal.

## Prerequisites
Pastikan Anda telah menginstal JDK dan Maven di sistem Anda.

## Installation
1. Clone repositori ke mesin lokal Anda.
2. Buka proyek di IDE Java pilihan Anda.
3. Bangun proyek untuk mengompilasi kode.

## File Configuration
Tidak ada konfigurasi file khusus yang diperlukan.

## Project Structure

```
automation-dummyapi-test
├─ .vscode/
│  └─ settings.json
├─ pom.xml
├─ README.md
├─ src/
│  ├─ main/
│  │  ├─ java/
│  │  │  └─ com/
│  │  │     └─ dummyapi/
│  │  └─ resources/
│  └─ test/
│     └─ java/
│        ├─ CreateUserDataTest.java
│        ├─ UpdateUserDataTest.java
│        ├─ UserDeleteApiTest.java
│        └─ UserGetApiTest.java
└─ target/
   ├─ classes/
   │  └─ com/
   │     └─ dummyapi/
   ├─ generated-sources/
   │  └─ annotations/
   ├─ generated-test-sources/
   │  └─ test-annotations/
   ├─ maven-status/
   │  └─ maven-compiler-plugin/
   │     └─ testCompile/
   │        └─ default-testCompile/
   │           ├─ createdFiles.lst
   │           └─ inputFiles.lst
   ├─ surefire-reports/
   │  ├─ 2024-05-05T11-51-04_575-jvmRun1.dump
   │  ├─ 2024-05-05T11-58-20_851-jvmRun1.dump
   │  ├─ TEST-UpdateUserDataTest.xml
   │  ├─ TEST-UserDeleteApiTest.xml
   │  ├─ TEST-UserGetApiTest.xml
   │  ├─ UpdateUserDataTest.txt
   │  ├─ UserDeleteApiTest.txt
   │  └─ UserGetApiTest.txt
   └─ test-classes/
      ├─ CreateUserDataTest.class
      ├─ UpdateUserDataTest$UserDataUtil.class
      ├─ UpdateUserDataTest.class
      ├─ UserDeleteApiTest.class
      └─ UserGetApiTest.class
```

- `pom.xml`: File konfigurasi Maven yang mengatur dependensi, plugin, dan konfigurasi proyek lainnya.
- `src/`: Direktori utama yang berisi kode sumber proyek.
  - `main/`: Direktori untuk kode sumber utama proyek.
    - `java/`: Direktori untuk kode sumber Java.
      - `com/`: Direktori root untuk struktur paket.
        - `dummyapi/`: Paket yang berisi kode sumber proyek.
    - `resources/`: Direktori untuk sumber daya proyek, seperti file konfigurasi.
  - `test/`: Direktori untuk unit test.
    - `java/`: Direktori untuk kode sumber unit test Java.
      - File-file unit test, seperti `CreateUserDataTest.java`, `UpdateUserDataTest.java`, `UserDeleteApiTest.java`, dan `UserGetApiTest.java`.

- `target/`: Direktori yang berisi hasil dari proses pembangunan proyek.
  - `classes/`: Direktori yang berisi file kelas hasil kompilasi.
    - `com/`: Direktori yang berisi struktur paket kelas.
      - `dummyapi/`: Direktori yang berisi kelas-kelas dari paket `dummyapi`.
  - `generated-sources/`: Direktori yang berisi sumber daya yang dihasilkan secara otomatis oleh proses kompilasi atau pembangunan.
  - `generated-test-sources/`: Direktori yang berisi sumber daya yang dihasilkan secara otomatis untuk pengujian.
  - `maven-status/`: Direktori yang berisi status proyek dari plugin Maven.
  - `surefire-reports/`: Direktori yang berisi laporan hasil pengujian dari Surefire plugin.
  - `test-classes/`: Direktori yang berisi file kelas unit test hasil kompilasi.

## How To Run Execution Testing
1. Buka proyek di IDE Anda.
2. Jalankan unit test yang terletak di direktori `test/`.
3. Unit test akan menjalankan berbagai skenario untuk memvalidasi fungsionalitas API.

## Software Under Test
Perangkat lunak yang diuji adalah API Dummy yang menyediakan data palsu untuk digunakan dalam pengujian dan pengembangan.

## Test Case
Test case mencakup skenario berikut:
- Pembuatan data pengguna baru.
- Pembaruan data pengguna.
- Penghapusan pengguna.
- Pengambilan data pengguna.

## Author
- Dafa Nurul Fauziansyah
- Fariz Rahman Maulana
- Muhammad Deo Audha Rizki.

## Reference
Tidak ada referensi eksternal khusus yang digunakan dalam proyek ini.
