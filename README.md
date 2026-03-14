# Tugas 3 - Pengembangan Aplikasi Mobile
## Aplikasi My Profile
- **Nama:** Nabila Ramadhani Mujahidin
- **NIM:** 123140062
- **Kelas:** Pengembangan Aplikasi Mobile RB

## Tampilan Aplikasi (Screenshot)
<img width="446" height="986" alt="image" src="https://github.com/user-attachments/assets/6a348102-21aa-4ab0-9a4f-eca08ab41e6e" />

## Fitur Aplikasi

Aplikasi menampilkan informasi profil pengguna dengan komponen UI modern dari Compose Multiplatform, meliputi:

* Foto profil berbentuk circular dengan border kustom (warna pink)
* Nama, Pekerjaan (Role), dan Status koneksi
* Tombol interaktif "Open Bio / Close Bio" yang menampilkan/menyembunyikan deskripsi secara mulus menggunakan animasi
* Tombol "Message" bergaya outlined
* Informasi detail pengguna (dibungkus dalam Card):
  * Email
  * Instagram
  * Education (Pendidikan)

## Komponen UI yang Digunakan

Aplikasi ini menggunakan beberapa komponen utama dari Compose Material 3:

* Scaffold & TopAppBar (Kerangka dasar dan header atas)
* Column, Row, Box (Untuk layouting)
* Card (Sebagai wadah informasi dengan efek elevasi/bayangan)
* Text (Untuk tipografi)
* Button & OutlinedButton (Tombol aksi)
* Image & Icon (Menampilkan foto profil dan ikon material)
* Divider & Spacer (Untuk garis pemisah dan jarak antar elemen)
* AnimatedVisibility (Untuk animasi transisi memunculkan/menyembunyikan Bio)

## Reusable Composable Functions

Project ini menggunakan beberapa Composable Function yang reusable (dapat digunakan kembali), yaitu:

* `ProfileScreen()`
  Menjadi kerangka utama atau screen pembungkus halaman profil.

* `ProfileHeader()`
  Menampilkan bagian atas profil yang berisi foto profil, nama, role, dan status singkat.

* `InfoRowItem()`
  Menampilkan setiap baris item informasi (seperti Email, Instagram, Education) yang menerima parameter berupa ikon, label, dan nilainya.

---

# Tugas 4 - Pengembangan Aplikasi Mobile
## Pembaruan: Arsitektur MVVM & Fitur Interaktif Tambahan

Pada Tugas 4, aplikasi dikembangkan lebih lanjut dengan memisahkan logika bisnis dari tampilan UI menggunakan arsitektur **MVVM (Model-View-ViewModel)** dan penambahan fitur dinamis yang lebih interaktif.

## Fitur Baru Aplikasi

* **Pengelolaan State dengan MVVM:** Data profil tidak lagi di-hardcode di UI, melainkan disimpan dalam Data Class (`ProfileUiState`) dan dikelola secara reaktif oleh `ProfileViewModel`.
* **Fitur Edit Profil:** Pengguna dapat menekan tombol "Edit Profile" untuk memunculkan form pengisian nama dan bio. Perubahan teks akan langsung tersimpan secara *real-time* menggunakan prinsip *State Hoisting*.
* **Dark Mode & Light Mode (Tema Gelap/Terang):** Terdapat sebuah *Switch* (ikon 🌙/☀️) di TopAppBar. Ketika ditekan, tema aplikasi beserta warnanya akan berubah dari terang ke gelap (dan sebaliknya) dengan animasi transisi warna latar yang halus.

## Komponen & Teknologi Baru yang Digunakan

* **ViewModel & StateFlow:** Menggunakan `ViewModel` dari *Lifecycle* dan `StateFlow` (`MutableStateFlow`, `asStateFlow`, `.update`) dari *Kotlin Coroutines* untuk manajemen data reaktif.
* **Switch:** Komponen Compose untuk tombol *toggle* pada fitur Dark Mode.
* **OutlinedTextField:** Komponen form input teks untuk mengetik/mengubah nama dan bio.
* **animateColorAsState:** Komponen animasi yang digunakan untuk membuat perubahan warna background transisi terang-ke-gelap menjadi lebih *smooth* (menggunakan durasi *tween 500ms*).
* **MaterialTheme (Color Schemes):** Pengaturan palet warna kustom untuk mode terang (`LightColorScheme`) dan mode gelap (`DarkColorScheme`).

## Reusable Composable Functions (Tambahan)

Aplikasi kini sepenuhnya menerapkan **State Hoisting** (menarik *state* ke atas) sehingga seluruh fungsi UI menjadi *Stateless*. Terdapat penambahan fungsi reusable baru:

* **`StatelessEditField()`**
  Merupakan form input teks (`OutlinedTextField`) yang dapat digunakan kembali. Menerima parameter berupa `label`, nilai teks saat ini (`value`), dan aksi pembaruan saat teks diketik (`onValueChange`). Fungsi ini digunakan untuk input Nama dan Bio secara efisien.