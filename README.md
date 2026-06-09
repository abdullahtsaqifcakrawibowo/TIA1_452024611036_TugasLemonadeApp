# Tugas Praktikum 3: Aplikasi Lemonade (Jetpack Compose)

Repositori ini berisi proyek Android **Aplikasi Lemonade** yang dikerjakan sebagai pemenuhan tugas praktik mandiri mata kuliah Pemrograman Perangkat Bergerak, berdasarkan modul Google Developer Codelab.

---

## 👤 Identitas Mahasiswa
* **Nama:** Abdullah Tsaqif Cakrawibowo
* **NIM:** 452024611036
* **Kelas:** TI 5 A1

---

## 🌟 Sorotan Fitur & Pemenuhan Rubrik (Skor Maksimal)

Aplikasi ini telah dirancang untuk memenuhi kriteria fungsionalitas dan arsitektur kode tingkat lanjut sesuai dengan rubrik tugas:

### 1. Fungsionalitas & Logika Transisi (State Machine)
* Aplikasi berjalan 100% lancar tanpa *crash* dan mampu melewati 4 siklus *state* secara berurutan dan akurat.
* **Logika Acak Terimplementasi Sempurna:** Pada State 2 (Memeras Lemon), aplikasi menggunakan fungsi `(2..4).random()` sebagai target perasan. Jumlah ketukan yang dibutuhkan untuk memeras lemon berubah-ubah secara dinamis setiap kali siklus diulang, tidak di-*hardcode*.

### 2. Antarmuka Pengguna (UI) & Aset Visual
* **Tata Letak Presisi:** Memanfaatkan komponen `Column` dengan parameter `horizontalAlignment = Alignment.CenterHorizontally` dan `verticalArrangement = Arrangement.Center`. Semua elemen (gambar, teks, *spacer*/padding) berada tepat di tengah layar dengan jarak proporsional.
* **Sinkronisasi Visual:** Teks panduan (`Text`) dan gambar (`Image`) berubah secara sinkron dan tepat sesuai *state* yang sedang aktif. 
* Memanfaatkan aset gambar resmi dari Google Codelab sesuai instruksi. Tombol dibuat dengan bentuk *RoundedCornerShape* agar estetis.

### 3. Arsitektur Kode Bersih (Clean Code & Resources)
* **Bebas Teks Hardcoded:** Seluruh teks antarmuka maupun *content description* pada aplikasi tidak ada yang ditulis langsung di dalam fungsi Composable. Semuanya direferensikan secara rapi melalui file `res/values/strings.xml` menggunakan `stringResource()`.
* Penamaan variabel bersifat deskriptif (contoh: `currentStep`, `squeezeCount`, `squeezeTarget`), sehingga alur logika sangat mudah dibaca.
* **State Hoisting:** Memisahkan penyimpanan data menggunakan `remember { mutableStateOf(...) }` agar UI bereaksi (*re-composition*) secara otomatis setiap ada perubahan kondisi.

### 4. Manajemen Versi (Git & GitHub)
* Penggunaan `Git` secara bertahap dengan pesan komit (*commit message*) yang jelas dan deskriptif.
* File `.gitignore` dikonfigurasi dengan benar (bawaan Android Studio diaktifkan) sehingga direktori *build* lokal (seperti folder `/build` atau `/.gradle`) tidak ikut terunggah, menjaga repositori tetap bersih dan siap di-*clone* atau *build* ulang oleh penguji.

---

## 🚀 Riwayat Pengerjaan (Commit History)
Proyek ini dibangun melalui beberapa tahap *commit*:
1. `feat: add assets and basic layout` - Menambahkan gambar, mengatur `strings.xml`, dan membangun fondasi tata letak UI.
2. `feat: implementasi lengkap aplikasi lemonade berbasis state` - Memasukkan logika utama *state*, fungsionalitas tombol, serta algoritma acak (2-4 ketukan) pada proses perasan lemon.

---
