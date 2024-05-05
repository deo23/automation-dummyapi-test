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
