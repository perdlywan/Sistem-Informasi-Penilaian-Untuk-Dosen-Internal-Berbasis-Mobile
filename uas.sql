-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Sep 16, 2022 at 05:51 AM
-- Server version: 10.4.21-MariaDB
-- PHP Version: 8.0.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `uas`
--

-- --------------------------------------------------------

--
-- Table structure for table `admin`
--

CREATE TABLE `admin` (
  `id` int(11) NOT NULL,
  `nama` varchar(50) NOT NULL,
  `username` varchar(50) NOT NULL,
  `password` varchar(8) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `admin`
--

INSERT INTO `admin` (`id`, `nama`, `username`, `password`) VALUES
(1, 'admin 3', 'admin_kelompok3', '12345');

-- --------------------------------------------------------

--
-- Table structure for table `dosen`
--

CREATE TABLE `dosen` (
  `KodeDosen` char(3) NOT NULL,
  `Nidn` varchar(15) NOT NULL,
  `NamaDosen` varchar(35) NOT NULL,
  `TmptLahir` varchar(20) NOT NULL,
  `TglLahir` date NOT NULL,
  `Status` varchar(20) NOT NULL,
  `Alamat` varchar(20) NOT NULL,
  `Kelurahan` varchar(25) NOT NULL,
  `Kecamatan` varchar(25) NOT NULL,
  `Kota_Kab` varchar(25) NOT NULL,
  `Provinsi` varchar(25) NOT NULL,
  `KodePos` varchar(5) NOT NULL,
  `NoHp` varchar(13) NOT NULL,
  `Pendidikan` varchar(2) NOT NULL,
  `JabatanAkademik` varchar(15) NOT NULL,
  `Golongan` varchar(6) NOT NULL,
  `Prodi` varchar(30) NOT NULL,
  `BidangKeahlian` varchar(40) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `dosen`
--

INSERT INTO `dosen` (`KodeDosen`, `Nidn`, `NamaDosen`, `TmptLahir`, `TglLahir`, `Status`, `Alamat`, `Kelurahan`, `Kecamatan`, `Kota_Kab`, `Provinsi`, `KodePos`, `NoHp`, `Pendidikan`, `JabatanAkademik`, `Golongan`, `Prodi`, `BidangKeahlian`) VALUES
('D01', '213123123129831', 'Johan', 'Kijang', '2000-09-08', 'Menikah', 'Pasar Berdikari', 'Kijang Kota', 'Bintan Timut', 'Kabupaten Bintan', 'Kepri', '29151', '081398980909', 'S3', 'Guru Besar', 'IV D', 'Sistem Komputer', 'SPK');

-- --------------------------------------------------------

--
-- Table structure for table `mahasiswa`
--

CREATE TABLE `mahasiswa` (
  `nim` char(8) NOT NULL,
  `nama_mahasiswa` varchar(35) NOT NULL,
  `tempat_lahir` varchar(20) NOT NULL,
  `tanggal_lahir` date NOT NULL,
  `status` varchar(20) NOT NULL,
  `alamat` varchar(20) NOT NULL,
  `kecamatan` varchar(25) NOT NULL,
  `kota_kab` varchar(25) NOT NULL,
  `provinsi` varchar(25) NOT NULL,
  `kode_pos` varchar(5) NOT NULL,
  `no_hp` varchar(13) NOT NULL,
  `pendidikan_terakhir` varchar(7) NOT NULL,
  `prodi` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `mahasiswa`
--

INSERT INTO `mahasiswa` (`nim`, `nama_mahasiswa`, `tempat_lahir`, `tanggal_lahir`, `status`, `alamat`, `kecamatan`, `kota_kab`, `provinsi`, `kode_pos`, `no_hp`, `pendidikan_terakhir`, `prodi`) VALUES
('11115011', 'Muhammad Salman Aziz', 'Cilegon', '1998-08-09', 'Duda/Janda', 'Jalan Pemuda No.1,', 'Cilegon', 'Cilegon', 'Banten', '42411', '081290009898', 'SMK', 'Sistem Informasi'),
('11118050', 'Reza Khairunisa Anwar', 'Serang', '2000-10-05', 'Belum Menikah', 'Jalan Pemuda No.3', 'Serang', 'Serang', 'Banten', '42113', '089678787979', 'SMK', 'Sistem Informasi'),
('11118051', 'Uswatun Hasanah', 'Serang', '1999-09-11', 'Belum Menikah', 'Jalan Bangkit No.2', 'Serang', 'Serang', 'Banten', '42111', '0819912525', 'SMK', 'Sistem Komputer'),
('11118064', 'Perdly Setiawan', 'Tanjungpinang', '2000-11-07', 'Belum Menikah', 'Bumi Agung Permai 1', 'Serang', 'Serang', 'Banten', '42111', '081378717655', 'SMK', 'Sistem Informasi'),
('11118072', 'Ridho Pratama', 'Serang', '2000-11-11', 'Menikah', 'Jalan Soekarno No.1', 'Serang', 'Serang', 'Banten', '42111', '081123456789', 'SMA', 'Sistem Komputer'),
('11118076', 'Robi Prasetya Prematurroni', 'Pandegelang', '2000-02-01', 'Duda/Janda', 'Jalan Pompa Air No.5', 'Banjar', 'Serang', 'Banten', '42222', '081523232323', 'SMA', 'Teknik Informatika'),
('11118083', 'Suherli Sutansyach', 'Serang', '1999-02-02', 'Menikah', 'Kragilan 1', 'Tegal Maja', 'Serang', 'Banten', '42333', '081219911991', 'SMK', 'Sistem Informasi'),
('11118084', 'Syahrul Rizal', 'Serang', '1970-01-01', 'Duda/Janda', 'Jalan Tepi Kali No.5', 'Tegal Maja', 'Serang', 'Banten', '42151', '081345567879', 'SMA', 'Teknik Informatika'),
('11118089', 'Yanda Rikza Abi Pratama', 'Cilegon', '2012-12-12', 'Menikah', 'Jalan Bung Hatta No.', 'Serang', 'Serang', 'Banten', '42111', '0819925657', 'SMA', 'Sistem Informasi');

-- --------------------------------------------------------

--
-- Table structure for table `penilaian`
--

CREATE TABLE `penilaian` (
  `id` int(11) NOT NULL,
  `nama_dosen` varchar(255) NOT NULL,
  `pertanyaan1` varchar(255) NOT NULL,
  `pertanyaan2` varchar(255) NOT NULL,
  `pertanyaan3` varchar(255) NOT NULL,
  `pertanyaan4` varchar(255) NOT NULL,
  `pertanyaan5` varchar(255) NOT NULL,
  `pertanyaan6` varchar(255) NOT NULL,
  `pertanyaan7` varchar(255) NOT NULL,
  `pertanyaan8` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `penilaian`
--

INSERT INTO `penilaian` (`id`, `nama_dosen`, `pertanyaan1`, `pertanyaan2`, `pertanyaan3`, `pertanyaan4`, `pertanyaan5`, `pertanyaan6`, `pertanyaan7`, `pertanyaan8`) VALUES
(1, 'Zaenal Muttaqin, S.Kom., SE., MM (AUDIT SI)', 'SangatBaik', 'SangatBaik', 'SangatBaik', 'SangatBaik', 'SangatBaik', 'SangatBaik', 'SangatBaik', 'SangatBaik');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `admin`
--
ALTER TABLE `admin`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `dosen`
--
ALTER TABLE `dosen`
  ADD PRIMARY KEY (`KodeDosen`);

--
-- Indexes for table `mahasiswa`
--
ALTER TABLE `mahasiswa`
  ADD PRIMARY KEY (`nim`);

--
-- Indexes for table `penilaian`
--
ALTER TABLE `penilaian`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `admin`
--
ALTER TABLE `admin`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `penilaian`
--
ALTER TABLE `penilaian`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
