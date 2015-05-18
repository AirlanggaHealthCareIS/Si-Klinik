-- phpMyAdmin SQL Dump
-- version 3.2.4
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: May 18, 2015 at 09:53 
-- Server version: 5.1.41
-- PHP Version: 5.3.1

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `cis`
--

-- --------------------------------------------------------

--
-- Table structure for table `beli`
--

CREATE TABLE IF NOT EXISTS `beli` (
  `ID_BELI` char(6) NOT NULL,
  `ID_SUPPLIER` char(6) NOT NULL,
  `TANGGAL_BELI` date DEFAULT NULL,
  `SUB_TOTAL` int(11) DEFAULT NULL,
  `PPN_BELI` decimal(10,0) DEFAULT NULL,
  `TOTAL_BELI` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID_BELI`),
  KEY `FK_DARI1` (`ID_SUPPLIER`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `beli`
--


-- --------------------------------------------------------

--
-- Table structure for table `detail_assessment_rekammedik`
--

CREATE TABLE IF NOT EXISTS `detail_assessment_rekammedik` (
  `ID_Assessment` int(11) NOT NULL AUTO_INCREMENT,
  `ID_REKAM_MEDIS` char(30) NOT NULL,
  `PPL` text NOT NULL,
  `Assessment` text NOT NULL,
  `DX` text NOT NULL,
  `TX` text NOT NULL,
  `MX` text NOT NULL,
  `EX` text NOT NULL,
  PRIMARY KEY (`ID_Assessment`),
  KEY `ID_Assessment` (`ID_Assessment`),
  KEY `ID_REKAM_MEDIS` (`ID_REKAM_MEDIS`),
  KEY `ID_REKAM_MEDIS_2` (`ID_REKAM_MEDIS`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=13 ;

--
-- Dumping data for table `detail_assessment_rekammedik`
--

INSERT INTO `detail_assessment_rekammedik` (`ID_Assessment`, `ID_REKAM_MEDIS`, `PPL`, `Assessment`, `DX`, `TX`, `MX`, `EX`) VALUES
(1, '1-1', 'Hipertensi', 'Hipertensi', '-', '-', '-', '-'),
(2, '5-1', '1', 'ABSES ABDOMEN', '1', '1', 'mx1', 'ex1'),
(3, '5-1', ';ppl1;ppl2', 'ABSES', ';dx3;dx4', ';tx3;tx4', ';mx1;mx2', ';ex1;ex2'),
(4, '2-1', '34', 'AMENORE', 'minum obat', 'tidak merokok', 'selalu olahraga', 'check up rutin'),
(5, '2-1', 'ppl1', 'ABSES KEPALA & LEHER', 'dx1', 'tx1', 'mx1', 'ex1'),
(6, '5-3', 'A~B', 'ABSES ABDOMEN', 'C~D', 'E~F', 'G~H', 'I~J'),
(7, '5-4', 'ppl1~ppl2', 'ABSES ABDOMEN', 'dx1~dx2', 'tx1~tx2~tx3', 'mx1~mx2~mx3', 'ex1~ex2~ex3'),
(8, '1-4', 'ppl1~ppl2', 'ABRUPSIO PLASENTA', 'dx1~dx2', 'tx1~tx2', 'mx1~mx2', 'ex1~ex2'),
(9, '5-5', 'ppl1', 'ABRUPSIO PLASENTA', 'dx1', 'tx1', 'mx1', 'ex1'),
(10, '2-3', '1', 'ABSES KEPALA & LEHER', '2', '3', '5', '4'),
(11, '2-4', '1', 'ABRUPSIO PLASENTA', '2', '3', '4', '5'),
(12, '1-5', '2', 'ABSES', '3', '4', '5', '6~null');

-- --------------------------------------------------------

--
-- Table structure for table `detail_beli`
--

CREATE TABLE IF NOT EXISTS `detail_beli` (
  `ID_DETAIL_BELI` char(250) NOT NULL,
  `ID_OBAT` char(6) NOT NULL,
  `ID_BELI` char(6) NOT NULL,
  `QTY_DETAIL_BELI` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID_DETAIL_BELI`),
  KEY `FK_BERISI5` (`ID_OBAT`),
  KEY `FK_TERDIRI6` (`ID_BELI`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `detail_beli`
--


-- --------------------------------------------------------

--
-- Table structure for table `detail_resep_obat`
--

CREATE TABLE IF NOT EXISTS `detail_resep_obat` (
  `ID_DETAIL_RESEP` int(11) NOT NULL AUTO_INCREMENT,
  `ID_REKAM_MEDIS` char(6) NOT NULL,
  `ID_OBAT` char(6) NOT NULL,
  `QTY_DETAIL_RESEP` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID_DETAIL_RESEP`),
  KEY `FK_BERISI1` (`ID_REKAM_MEDIS`),
  KEY `FK_BERISI2` (`ID_OBAT`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=2 ;

--
-- Dumping data for table `detail_resep_obat`
--

INSERT INTO `detail_resep_obat` (`ID_DETAIL_RESEP`, `ID_REKAM_MEDIS`, `ID_OBAT`, `QTY_DETAIL_RESEP`) VALUES
(1, '1-1', 'O1', 10);

-- --------------------------------------------------------

--
-- Table structure for table `detail_transaksi_obat`
--

CREATE TABLE IF NOT EXISTS `detail_transaksi_obat` (
  `ID_DETAIL_TRANSAKSI_OBAT` int(11) NOT NULL AUTO_INCREMENT,
  `ID_TRANSAKSI_OBAT` varchar(6) NOT NULL,
  `ID_OBAT` char(6) NOT NULL,
  `QTY_DETAIL_TRANSAKSI` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID_DETAIL_TRANSAKSI_OBAT`),
  KEY `FK_BERISI3` (`ID_OBAT`),
  KEY `FK_BERISI4` (`ID_TRANSAKSI_OBAT`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=5 ;

--
-- Dumping data for table `detail_transaksi_obat`
--

INSERT INTO `detail_transaksi_obat` (`ID_DETAIL_TRANSAKSI_OBAT`, `ID_TRANSAKSI_OBAT`, `ID_OBAT`, `QTY_DETAIL_TRANSAKSI`) VALUES
(1, '3', 'O1', 10),
(2, '4', 'O1', 10),
(3, '5', 'O1', 10),
(4, '6', 'O1', 10);

-- --------------------------------------------------------

--
-- Table structure for table `dokter`
--

CREATE TABLE IF NOT EXISTS `dokter` (
  `ID_DOKTER` char(6) NOT NULL,
  `ID_POLI` varchar(6) NOT NULL,
  `NAMA_DOKTER` varchar(20) DEFAULT NULL,
  `ALAMAT_DOKTER` varchar(50) DEFAULT NULL,
  `TGL_LAHIR_DOKTER` date DEFAULT NULL,
  `TELEPON_DOKTER` varchar(16) DEFAULT NULL,
  `JENIS_KELAMIN_DOKTER` varchar(1) DEFAULT NULL,
  `AGAMA_DOKTER` varchar(10) DEFAULT NULL,
  `PASSWORD_DOKTER` varchar(10) DEFAULT NULL,
  `NO_IJIN` varchar(16) DEFAULT NULL,
  `TARIF_DOKTER` int(11) DEFAULT NULL,
  `GAJI_POKOK_DOKTER` int(11) NOT NULL,
  PRIMARY KEY (`ID_DOKTER`),
  KEY `FK_DIISI1` (`ID_POLI`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `dokter`
--

INSERT INTO `dokter` (`ID_DOKTER`, `ID_POLI`, `NAMA_DOKTER`, `ALAMAT_DOKTER`, `TGL_LAHIR_DOKTER`, `TELEPON_DOKTER`, `JENIS_KELAMIN_DOKTER`, `AGAMA_DOKTER`, `PASSWORD_DOKTER`, `NO_IJIN`, `TARIF_DOKTER`, `GAJI_POKOK_DOKTER`) VALUES
('DOK001', 'pol001', 'DR. RETNO WISASTI, S', 'JL. WR. SUPRATMAN 59 SURABAYA TIMUR/GUBENG', '1975-03-18', '0315674360', 'P', 'ISLAM', 'dok001retn', 'd20030001rs', 50000, 1000000),
('DOK002', 'pol001', 'DR. FADJAR ARIBOWO', 'JL. KAPAS KRAMPUNG NO. 148 SURABAYA TIMUR', '1969-08-10', '0315033748', 'L', 'ISLAM', 'dok002fadj', 'd20010002fa', 50000, 1000000),
('DOK003', 'pol001', 'DRG. DYAH AYU R. W.', 'JL. TIDAR NO. 94 SURABAYA UTARA', '1972-05-25', '0315451530', 'P', 'ISLAM', 'dok003dyah', 'd20050003darw', 50000, 1000000),
('DOK004', 'pol002', 'DRG. BACHTIAR EFFEND', 'JL. TIDAR NO. 81 SURABAYA UTARA', '1965-10-17', '0315468955', 'L', 'KRISTEN', 'dok004bach', 'd19990004be', 50000, 1000000),
('DOK005', 'pol002', 'DR. NUGROHO TJANDRA ', 'JL. KAPUAS NO. 54 SURABAYA PUSAT', '1965-03-01', '0315686907', 'L', 'KRISTEN', 'dok005nugr', 'd20000005ntw', 50000, 25000000),
('DOK006', 'pol002', 'DR. I NYOMAN ADNYANA', 'JL. RAYA DHARMAHUSADA INDAH BLOK A NO.26 SURABAYA ', '1962-02-21', '03170679810', 'L', 'HINDU', 'dok006nyom', 'd20000006ina', 65000, 1000000),
('DOK007', 'pol003', 'DR. BUDIARTO, SP. PK', 'JL. JEMURSARI NO. 4 SURABAYA SELATAN', '1966-03-23', '0318418414', 'L', 'ISLAM', 'dok007budi', 'd20020007b', 65000, 10000000),
('DOK008', 'pol003', 'DR. MARIANA HAROEN, ', 'JL. KEDUNGSARI NO. 121 SURABAYA UTARA', '1970-09-07', '0315341027', 'P', 'KRISTEN', 'dok008mari', 'd20010008mh', 65000, 400000),
('DOK009', 'pol004', 'DR. RAHARDJO ARIYO M', 'JL. TEGALSARI NO. 7 SURABAYA UTARA', '1976-07-13', '0315344239', 'L', 'ISLAM', 'dok009raha', 'd20040009ram', 30000, 30000000),
('DOK010', 'pol004', 'DR. HERI KABULLAH, S', 'JL. TANJUNG PERAK TIMUR NO. 160 SURABAYA UTARA', '1967-05-14', '0313522429', 'L', 'ISLAM', 'dok010heri', 'd20030010hk', 50000, 20000000);

-- --------------------------------------------------------

--
-- Table structure for table `jadwal`
--

CREATE TABLE IF NOT EXISTS `jadwal` (
  `ID_JADWAL` char(6) NOT NULL,
  `ID_DOKTER` char(6) NOT NULL,
  `HARI` varchar(10) DEFAULT NULL,
  `JAM` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`ID_JADWAL`),
  KEY `FK_MEMILIH2` (`ID_DOKTER`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `jadwal`
--


-- --------------------------------------------------------

--
-- Table structure for table `kadaluarsa_obat`
--

CREATE TABLE IF NOT EXISTS `kadaluarsa_obat` (
  `ID_KADALUARSA_OBAT` char(6) NOT NULL,
  `ID_OBAT` char(6) NOT NULL,
  `TANGGAL_KADALUARSA_OBAT` date DEFAULT NULL,
  PRIMARY KEY (`ID_KADALUARSA_OBAT`),
  KEY `FK_MEMILIKI2` (`ID_OBAT`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `kadaluarsa_obat`
--


-- --------------------------------------------------------

--
-- Table structure for table `kepuasan_pelanggan`
--

CREATE TABLE IF NOT EXISTS `kepuasan_pelanggan` (
  `id` int(11) NOT NULL,
  `waktu` datetime NOT NULL,
  `id_aktor` varchar(10) NOT NULL,
  `satisfied` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `kepuasan_pelanggan`
--


-- --------------------------------------------------------

--
-- Table structure for table `obat`
--

CREATE TABLE IF NOT EXISTS `obat` (
  `ID_OBAT` char(6) NOT NULL,
  `NAMA_OBAT` varchar(20) DEFAULT NULL,
  `DOSIS` decimal(10,0) DEFAULT NULL,
  `KETERANGAN_OBAT` text,
  `STOK_OBAT` int(11) DEFAULT NULL,
  `STOK_KRITIS` int(11) NOT NULL,
  `PABRIK_OBAT` varchar(20) DEFAULT NULL,
  `JENIS_OBAT` varchar(20) DEFAULT NULL,
  `KEMASAN` varchar(25) NOT NULL,
  `HARGA_OBAT` int(11) NOT NULL,
  PRIMARY KEY (`ID_OBAT`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `obat`
--

INSERT INTO `obat` (`ID_OBAT`, `NAMA_OBAT`, `DOSIS`, `KETERANGAN_OBAT`, `STOK_OBAT`, `STOK_KRITIS`, `PABRIK_OBAT`, `JENIS_OBAT`, `KEMASAN`, `HARGA_OBAT`) VALUES
('O1', 'IBUPROFEN', '200', NULL, 10, 5, 'PT COMBIPHAR', 'TABLET', 'BOTOL', 17000),
('O10', 'alif', '12', 'asadad', 2, 0, 'sdsd', 'sdsd', 'adasa', 12144),
('O11', 'BEDAK SALISIL', '2', NULL, 10, 5, 'PT HENSON FARMA', 'SERBUK', 'BEDAK', 17000),
('O2', 'IBUPROFEN', '400', NULL, 10, 5, 'PT COMBIPHAR', 'TABLET', 'BOTOL', 20000),
('O3', 'PARASETAMOL', '500', NULL, 10, 5, 'PT KIMIA FARMA', 'TABLET', 'KOTAK', 11000),
('O4', 'PARASETAMOL', '120', NULL, 10, 5, 'PT KIMIA FARMA', 'SIRUP', 'BOTOL', 18000),
('O5', 'AMOXCILIN', '500', NULL, 15, 5, 'PT SANBE FARMA', 'TABLET', 'KOTAK', 13000),
('O6', 'AMOXCILIN', '125', NULL, 10, 5, 'PT SANBE FARMA', 'SIRUP', 'BOTOL', 15000),
('O7', 'BETAMETASON', '10', NULL, 10, 5, 'PT PHAROS', 'KRIM', 'SALEP', 11000),
('O8', 'SERUM ANTITETANUS', '200', NULL, 10, 5, 'PT PHAROS', 'CAIR', 'BOTOL', 22000),
('O9', 'PROPANOLOL', '10', NULL, 10, 5, 'PT HENSON FARMA', 'TABLET', 'KOTAK', 13000);

-- --------------------------------------------------------

--
-- Table structure for table `pasien`
--

CREATE TABLE IF NOT EXISTS `pasien` (
  `ID_PASIEN` int(11) NOT NULL AUTO_INCREMENT,
  `NAMA_PASIEN` varchar(20) DEFAULT NULL,
  `ALAMAT` varchar(50) DEFAULT NULL,
  `JENIS_KELAMIN` char(1) DEFAULT NULL,
  `TGL_LAHIR` date DEFAULT NULL,
  `NO_TELEPON` varchar(16) DEFAULT NULL,
  `UMUR` char(3) DEFAULT NULL,
  `AGAMA` varchar(10) DEFAULT NULL,
  `PEKERJAAN` varchar(30) DEFAULT NULL,
  `TEMPAT_LAHIR` varchar(10) DEFAULT NULL,
  `NO_BPJS_PASIEN` varchar(16) DEFAULT NULL,
  `GOL_DARAH` varchar(2) DEFAULT NULL,
  `Suku Bangsa` varchar(20) NOT NULL,
  `Status Pernikahan` varchar(1) NOT NULL,
  PRIMARY KEY (`ID_PASIEN`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=6 ;

--
-- Dumping data for table `pasien`
--

INSERT INTO `pasien` (`ID_PASIEN`, `NAMA_PASIEN`, `ALAMAT`, `JENIS_KELAMIN`, `TGL_LAHIR`, `NO_TELEPON`, `UMUR`, `AGAMA`, `PEKERJAAN`, `TEMPAT_LAHIR`, `NO_BPJS_PASIEN`, `GOL_DARAH`, `Suku Bangsa`, `Status Pernikahan`) VALUES
(1, 'ADI PURTANTO', 'KETINTANG NO.11 SURABAYA', 'L', '1994-05-13', '08574565321', '21', 'ISLAM', 'MAHASISWA', 'JAKARTA', NULL, 'O', 'Jawa', '0'),
(2, 'SAIDI', 'GUNUNG SARI INDAH NO. 28, SURABAYA', 'L', '1992-08-23', '08992123412', '23', 'HINDU', 'PNS', 'JAKARTA', NULL, 'AB', 'Jawa', '1'),
(3, 'AYUNDA', 'RUNGKUT ASRI INDAH NO.22, SURABAYA', 'P', '1996-01-12', '0312114214', '19', 'ISLAM', 'MAHASISWA', 'SURABAYA', NULL, 'B', 'Batak', '0'),
(4, 'ASTUTI', 'MULYOSARI TIMUR NO.21, SURABAYA', 'P', '1889-03-22', '0899453463', '26', 'KRISTEN', 'WIRASWASTA', 'SEMARANG', NULL, 'AB', 'Batak', '1'),
(5, 'DEWI', 'ASEM ROWO NO.12, SURABAYA', 'L', '1982-02-02', '085742122341', '33', 'ISLAM', 'IBU RUMAH TANGGA', 'SURABAYA', NULL, 'AB', 'Jawa', '1');

-- --------------------------------------------------------

--
-- Table structure for table `pendaftaran`
--

CREATE TABLE IF NOT EXISTS `pendaftaran` (
  `ID_PENDAFTARAN` int(11) NOT NULL AUTO_INCREMENT,
  `ID_PETUGAS` char(6) NOT NULL,
  `ID_DOKTER` char(6) NOT NULL,
  `ID_PASIEN` int(11) NOT NULL,
  `ID_POLI` varchar(6) NOT NULL,
  `TGL_PERIKSA` date DEFAULT NULL,
  `KELUHAN` text,
  `NO_ANTRIAN` int(11) NOT NULL,
  PRIMARY KEY (`ID_PENDAFTARAN`),
  KEY `FK_DIPILIH1` (`ID_DOKTER`),
  KEY `FK_MELAKUKAN1` (`ID_PASIEN`),
  KEY `FK_MEMILIH1` (`ID_POLI`),
  KEY `FK_MENGURUS1` (`ID_PETUGAS`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=5 ;

--
-- Dumping data for table `pendaftaran`
--

INSERT INTO `pendaftaran` (`ID_PENDAFTARAN`, `ID_PETUGAS`, `ID_DOKTER`, `ID_PASIEN`, `ID_POLI`, `TGL_PERIKSA`, `KELUHAN`, `NO_ANTRIAN`) VALUES
(1, 'PET005', 'DOK001', 1, 'pol001', '2015-05-11', 'pusing', 1),
(2, 'PET003', 'DOK006', 2, 'pol003', '2015-05-11', '-', 2),
(3, 'PET002', 'DOK003', 5, 'pol002', '2015-05-18', '-', 3),
(4, 'PET002', 'DOK006', 5, 'pol003', '2015-05-18', NULL, 1);

-- --------------------------------------------------------

--
-- Table structure for table `penerimaan`
--

CREATE TABLE IF NOT EXISTS `penerimaan` (
  `ID_Transaksi` varchar(10) NOT NULL,
  `Tanggal` date NOT NULL,
  `Jumlah` int(11) NOT NULL,
  `Saldo` int(11) NOT NULL,
  `Flag` int(11) NOT NULL,
  PRIMARY KEY (`ID_Transaksi`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `penerimaan`
--

INSERT INTO `penerimaan` (`ID_Transaksi`, `Tanggal`, `Jumlah`, `Saldo`, `Flag`) VALUES
('O-1', '2015-04-01', 150000, 2554000, 3),
('O-2', '2015-04-06', 46000, 2600000, 4),
('PE-1', '2015-03-24', 100000, 2504000, 1);

-- --------------------------------------------------------

--
-- Table structure for table `pengeluaran`
--

CREATE TABLE IF NOT EXISTS `pengeluaran` (
  `ID_Transaksi` varchar(10) NOT NULL,
  `Tanggal` date NOT NULL,
  `Jumlah` int(11) NOT NULL,
  `Saldo` int(11) NOT NULL,
  `Flag` int(11) NOT NULL,
  PRIMARY KEY (`ID_Transaksi`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `pengeluaran`
--

INSERT INTO `pengeluaran` (`ID_Transaksi`, `Tanggal`, `Jumlah`, `Saldo`, `Flag`) VALUES
('B-1', '2015-03-25', 100000, 2404000, 2),
('B-2', '2015-04-11', 200000, 2400000, 5);

-- --------------------------------------------------------

--
-- Table structure for table `penggajian`
--

CREATE TABLE IF NOT EXISTS `penggajian` (
  `id_gaji` varchar(6) NOT NULL,
  `id_pegawai` varchar(6) NOT NULL,
  `tanggal_gaji` date NOT NULL,
  PRIMARY KEY (`id_gaji`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `penggajian`
--

INSERT INTO `penggajian` (`id_gaji`, `id_pegawai`, `tanggal_gaji`) VALUES
('G001', 'DOK001', '2015-04-01'),
('G002', 'DOK002', '2015-04-06'),
('G003', 'PET007', '2015-04-06'),
('G004', 'DOK003', '2015-04-06'),
('G005', 'DOK004', '2015-04-08'),
('G006', 'PET001', '2015-04-08'),
('G007', 'PET002', '2015-04-09'),
('G008', 'PET003', '2015-04-09'),
('G009', 'PET004', '2015-04-13'),
('G010', 'PET005', '2015-04-14'),
('G011', 'PET006', '2015-04-16'),
('G012', 'PET008', '2015-04-06'),
('G013', 'DOK005', '2015-04-14'),
('G014', 'DOK006', '2015-04-22'),
('G015', 'DOK007', '2015-04-09'),
('G016', 'DOK008', '2015-04-14');

-- --------------------------------------------------------

--
-- Table structure for table `penyakit`
--

CREATE TABLE IF NOT EXISTS `penyakit` (
  `ID_PENYAKIT` char(6) NOT NULL,
  `NAMA_PENYAKIT` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`ID_PENYAKIT`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `penyakit`
--

INSERT INTO `penyakit` (`ID_PENYAKIT`, `NAMA_PENYAKIT`) VALUES
('P-1', 'Ablasio Retina'),
('P-10', 'Abses Peritonsiler'),
('P-11', 'Abses Retrofaringeal'),
('P-12', 'Abses Tangan'),
('P-13', 'Adenokarsinoma Pankr'),
('P-14', 'Adenosine Stress Tes'),
('P-15', 'Akalasia'),
('P-16', 'Akromegali'),
('P-17', 'Akrosianosis'),
('P-18', 'Aktinomikosis'),
('P-19', 'Albinisme'),
('P-2', 'Abrupsio Plasenta'),
('P-20', 'AlkalosisMetabolik'),
('P-21', 'Alkalosis Respirator'),
('P-22', 'Alzheimer'),
('P-23', 'Ambliopia Toksika'),
('P-24', 'Amblyopia'),
('P-25', 'Amebiasis'),
('P-26', 'Amenore'),
('P-27', 'Amiloidosis'),
('P-28', 'Amnesia Disosiatif'),
('P-29', 'Amyotrophic Latera Sclerosis'),
('P-3', 'Abses'),
('P-30', 'Anafilaksis'),
('P-31', 'Anemia'),
('P-32', 'Aneurisma'),
('P-4', 'Abses Abdomen'),
('P-5', 'Abses Anorektal'),
('P-6', 'Abses Kepala & Leher'),
('P-7', 'Abses Otak'),
('P-8', 'Abses Otot'),
('P-9', 'Abses Periapikal');

-- --------------------------------------------------------

--
-- Table structure for table `petugas`
--

CREATE TABLE IF NOT EXISTS `petugas` (
  `ID_PETUGAS` char(6) NOT NULL,
  `NAMA_PETUGAS` varchar(20) DEFAULT NULL,
  `JABATAN_PETUGAS` varchar(10) DEFAULT NULL,
  `ALAMAT_PETUGAS` varchar(50) DEFAULT NULL,
  `TELEPON_PETUGAS` varchar(16) DEFAULT NULL,
  `TGL_LAHIR_PETUGAS` date DEFAULT NULL,
  `JENIS_KELAMIN_PETUGAS` varchar(2) DEFAULT NULL,
  `AGAMA_PETUGAS` varchar(10) CHARACTER SET utf8 DEFAULT NULL,
  `GAJI_POKOK_PETUGAS` int(11) NOT NULL,
  `PASSWORD_PETUGAS` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`ID_PETUGAS`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `petugas`
--

INSERT INTO `petugas` (`ID_PETUGAS`, `NAMA_PETUGAS`, `JABATAN_PETUGAS`, `ALAMAT_PETUGAS`, `TELEPON_PETUGAS`, `TGL_LAHIR_PETUGAS`, `JENIS_KELAMIN_PETUGAS`, `AGAMA_PETUGAS`, `GAJI_POKOK_PETUGAS`, `PASSWORD_PETUGAS`) VALUES
('PET001', 'JESSICA', 'KASIR', 'JL. KAYON NO. 3 SURABAYA TIMUR', '081330734979', '1993-02-10', 'P', 'KRISTEN', 2000000, 'PET001JESS'),
('PET002', 'ALIF', 'KASIR', 'JL. GUBENG POJOK NO. 21 SURABAYA TIMUR', '0315310069', '1991-11-03', 'L', 'ISLAM', 2000000, 'PET002ALIF'),
('PET003', 'YULIASTI', 'APOTEKER', 'JL. KAYON NO. 3 SURABAYA ', '0315345426', '1992-08-11', 'P', 'KRISTEN', 2500000, 'PET003YULI'),
('PET004', 'MELLA', 'APOTEKER', 'JL. KARAH INDAH H – 18 SURABAYA BARAT', '0318299815', '1990-08-12', 'P', 'ISLAM', 2500000, 'PET004MELL'),
('PET005', 'INDYKA', 'APOTEKER', 'JL. KAPAS KRAMPUNG NO. 123 SURABAYA TIMUR', '0313719012', '1991-05-07', 'L', 'ISLAM', 2500000, 'PET005INDY'),
('PET006', 'MERRY', 'PERAWAT', 'JL. RAYA TENGGILIS C NO. 10 SURABAYA SELATAN', '0318411821', '1990-07-15', 'P', 'ISLAM', 3000000, 'PET006MERR'),
('PET007', 'TRIYAH', 'PERAWAT', 'JL. NGAGEL JAYA NO. 81 SURABAYA SELATAN', '0315054096', '1991-04-07', 'P', 'ISLAM', 3000000, 'PET007TRIY'),
('PET008', 'MELINDA', 'PERAWAT', 'JALAN MULYOREJO TENGAH NO 30 SURABAYA', '0313425128', '1989-11-14', 'P', 'ISLAM', 3000000, 'PET008MELI');

-- --------------------------------------------------------

--
-- Table structure for table `poliklinik`
--

CREATE TABLE IF NOT EXISTS `poliklinik` (
  `ID_POLI` varchar(6) NOT NULL,
  `NAMA_POLI` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`ID_POLI`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `poliklinik`
--

INSERT INTO `poliklinik` (`ID_POLI`, `NAMA_POLI`) VALUES
('pol001', 'Poli Umum'),
('pol002', 'Poli KIA'),
('pol003', 'Poli Gigi'),
('pol004', 'Poli Mata');

-- --------------------------------------------------------

--
-- Table structure for table `presensi`
--

CREATE TABLE IF NOT EXISTS `presensi` (
  `TANGGAL_MASUK` date NOT NULL,
  `ID` varchar(7) NOT NULL,
  `JAM_MASUK` varchar(8) NOT NULL,
  `JAM_KELUAR` varchar(8) NOT NULL,
  PRIMARY KEY (`TANGGAL_MASUK`,`ID`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `presensi`
--


-- --------------------------------------------------------

--
-- Table structure for table `rekam_medis`
--

CREATE TABLE IF NOT EXISTS `rekam_medis` (
  `ID_REKAM_MEDIS` char(30) NOT NULL,
  `ID_DOKTER` char(6) NOT NULL,
  `ID_PASIEN` int(11) NOT NULL,
  `TGL_REKAM_MEDIS` date DEFAULT NULL,
  `ALERGI_OBAT` text,
  `RIWAYAT_SEKARANG` text NOT NULL,
  `RIWAYAT_DAHULU` text NOT NULL,
  `RIWAYAT_KELUARGA` text NOT NULL,
  `KETERANGAN_PEKERJAAN` text NOT NULL,
  `KEBIASAAN` text NOT NULL,
  `KEADAAN_UMUM` text NOT NULL,
  `GCS` int(11) NOT NULL,
  `KESADARAN` varchar(50) NOT NULL,
  `TENSI` varchar(7) NOT NULL,
  `NADI` int(11) NOT NULL,
  `RR` int(11) NOT NULL,
  `TEMPERATURE` int(11) NOT NULL,
  `PEMERIKSAAN_LAIN` text NOT NULL,
  `TPL` text NOT NULL,
  `RUJUKAN_DOKTER` text,
  `FLAG` int(11) NOT NULL,
  PRIMARY KEY (`ID_REKAM_MEDIS`),
  KEY `FK_DITULIS1` (`ID_DOKTER`),
  KEY `FK_MEMILIKI1` (`ID_PASIEN`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `rekam_medis`
--

INSERT INTO `rekam_medis` (`ID_REKAM_MEDIS`, `ID_DOKTER`, `ID_PASIEN`, `TGL_REKAM_MEDIS`, `ALERGI_OBAT`, `RIWAYAT_SEKARANG`, `RIWAYAT_DAHULU`, `RIWAYAT_KELUARGA`, `KETERANGAN_PEKERJAAN`, `KEBIASAAN`, `KEADAAN_UMUM`, `GCS`, `KESADARAN`, `TENSI`, `NADI`, `RR`, `TEMPERATURE`, `PEMERIKSAAN_LAIN`, `TPL`, `RUJUKAN_DOKTER`, `FLAG`) VALUES
('1-1', 'DOK009', 1, '2015-04-15', '-', 'hipertensi', '-', 'hipertensi', 'supir truk 12 jam menyetir non stop', 'merokok 10 batang/hari', 'pucat', 100, 'normal', '170/110', 80, 100, 37, '-', 'Hipertensi', '-', 1),
('1-2', 'DOK001', 1, '2015-04-19', '-', 'a', '-\nRiwayat pemeriksaan tanggal 2015-04-15 pasien didiagnosa: Hipertensi', 'hipertensi', 'supir truk 12 jam menyetir non stop', 'merokok 10 batang/hari', 'b', 10, 'c', '100/110', 100, 80, 34, '-', 'a', NULL, 2),
('1-3', 'DOK001', 1, '2015-04-26', '-', 'penderita mengeluhkan sakit perut yang berulang-ulang ketika bangun tidur', '-\nRiwayat pemeriksaan tanggal 2015-04-15 pasien didiagnosa: Hipertensi\nRiwayat pemeriksaan tanggal 2015-04-19 pasien didiagnosa: ', 'hipertensi', 'sering begadang larut malam', '-', 'normal', 1, 'normal', '10/10', 10, 1, 4, '-', 'hepatits C', NULL, 3),
('1-4', 'DOK001', 1, '2015-05-11', '-', '-', '-\nRiwayat pemeriksaan tanggal 2015-04-15 pasien didiagnosa: Hipertensi\nRiwayat pemeriksaan tanggal 2015-04-19 pasien didiagnosa: \nRiwayat pemeriksaan tanggal 2015-04-26 pasien didiagnosa: ', 'hipertensi', 'sering begadang larut malam', '-', 'normal', 90, 'normal', '100', 80, 100, 34, '-', 'tpl1~tpl2', NULL, 4),
('1-5', 'DOK001', 1, '2015-05-11', '-', '-', '-\nRiwayat pemeriksaan tanggal 2015-04-15 pasien didiagnosa: Hipertensi\nRiwayat pemeriksaan tanggal 2015-04-19 pasien didiagnosa: \nRiwayat pemeriksaan tanggal 2015-04-26 pasien didiagnosa: \nRiwayat pemeriksaan tanggal 2015-05-11 pasien didiagnosa: ABRUPSIO PLASENTA', 'hipertensi', 'sering begadang larut malam', '-', '-', 0, '-', '0', 0, 0, 0, '-', '1', NULL, 5),
('2-1', 'DOK001', 2, '2015-04-26', '-', 'faringitis', '-', '-', '-', '-', 'normal', 0, '-', '-', 0, 0, 0, '-', 'a;b;c', NULL, 1),
('2-2', 'DOK001', 2, '2015-04-26', '- tidak ada', 'masih batuk dengan rasa sakit di dada dan perut', '- \nRiwayat pemeriksaan tanggal 2015-04-26 pasien didiagnosa: mengalami batuk TBC', '- tidak ada', '- menjadi sekretaris	', '-merokok', 'sehat', 23, 'tampak sehat', '70', 160, 234, 37, '	-	', '1;2', NULL, 2),
('2-3', 'DOK001', 2, '2015-05-11', '- tidak ada', '-	', '- \nRiwayat pemeriksaan tanggal 2015-04-26 pasien didiagnosa: mengalami batuk TBC\nRiwayat pemeriksaan tanggal 2015-04-26 pasien didiagnosa: ', '- tidak ada', '- menjadi sekretaris	', '-merokok', '-', 100, '-', '-', 90, 90, 78, '-', '1', NULL, 3),
('2-4', 'DOK001', 2, '2015-05-11', '- tidak ada', '-', '- \nRiwayat pemeriksaan tanggal 2015-04-26 pasien didiagnosa: mengalami batuk TBC\nRiwayat pemeriksaan tanggal 2015-04-26 pasien didiagnosa: \nRiwayat pemeriksaan tanggal 2015-05-11 pasien didiagnosa: ABSES KEPALA & LEHER', '- tidak ada', '- menjadi sekretaris	', '-merokok', 'norrm', 0, '0', '0', 0, 0, 0, '0', '-', NULL, 4),
('5-1', 'DOK001', 5, '2015-04-26', '-', 'pusing', 'migrain', '-', '-	-', '-', 'normal', 0, 'normal', '100/110', 80, 90, 35, '-', 'a;b;;d;e', NULL, 1),
('5-2', 'DOK001', 5, '2015-04-26', '-', '-', 'migrain\nRiwayat pemeriksaan tanggal 2015-04-26 pasien didiagnosa: ', '-', '-	-', '-', 'normal', 10, 'normal', '100/110', 80, 10, 37, '-', '1', NULL, 2),
('5-3', 'DOK001', 5, '2015-05-11', '-', '-	', 'migrain\nRiwayat pemeriksaan tanggal 2015-04-26 pasien didiagnosa: \nRiwayat pemeriksaan tanggal 2015-04-26 pasien didiagnosa: ', '-', '-	-', '-', 'NORMAL', 90, 'NORMAL', '100', 90, 90, 37, '-', 'A~B', NULL, 3),
('5-4', 'DOK001', 5, '2015-05-11', '-', '-', 'migrain\nRiwayat pemeriksaan tanggal 2015-04-26 pasien didiagnosa: \nRiwayat pemeriksaan tanggal 2015-04-26 pasien didiagnosa: \nRiwayat pemeriksaan tanggal 2015-05-11 pasien didiagnosa: ABSES ABDOMEN', '-', '-	-', '-', 'normal', 90, 'normal', '100', 90, 80, 37, '-', 'tpl1', NULL, 4),
('5-5', 'DOK001', 5, '2015-05-11', '-', '-', 'migrain\nRiwayat pemeriksaan tanggal 2015-04-26 pasien didiagnosa: \nRiwayat pemeriksaan tanggal 2015-04-26 pasien didiagnosa: \nRiwayat pemeriksaan tanggal 2015-05-11 pasien didiagnosa: ABSES ABDOMEN\nRiwayat pemeriksaan tanggal 2015-05-11 pasien didiagnosa: ABSES ABDOMEN', '-', '-	-', '-', '-', 90, '-', '-', 90, 90, 34, '-', 'tpl1', NULL, 5),
('5-6', 'DOK001', 5, '2015-05-18', '-', 'ddqd', 'migrain\nRiwayat pemeriksaan tanggal 2015-04-26 pasien didiagnosa: \nRiwayat pemeriksaan tanggal 2015-04-26 pasien didiagnosa: \nRiwayat pemeriksaan tanggal 2015-05-11 pasien didiagnosa: ABSES ABDOMEN\nRiwayat pemeriksaan tanggal 2015-05-11 pasien didiagnosa: ABSES ABDOMEN\nRiwayat pemeriksaan tanggal 2015-05-11 pasien didiagnosa: ABRUPSIO PLASENTA', '-', '-	-', '-', 'x', 1, 'a', 'sd', 3, 2, 13, '	sdsf', 'sdf', NULL, 6);

-- --------------------------------------------------------

--
-- Table structure for table `supplier`
--

CREATE TABLE IF NOT EXISTS `supplier` (
  `ID_SUPPLIER` char(6) NOT NULL,
  `NAMA_SUPPLIER` varchar(30) DEFAULT NULL,
  `ALAMAT_SUPPLIER` varchar(50) DEFAULT NULL,
  `KOTA_SUPPLIER` varchar(20) DEFAULT NULL,
  `TELEPON_SUPPLIER` varchar(16) DEFAULT NULL,
  `NPWP_SUPPLIER` varchar(20) DEFAULT NULL,
  `JENIS_PAJAK_SUPPLIER` varchar(20) DEFAULT NULL,
  `KODE_PAJAK_SUPPLIER` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`ID_SUPPLIER`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `supplier`
--

INSERT INTO `supplier` (`ID_SUPPLIER`, `NAMA_SUPPLIER`, `ALAMAT_SUPPLIER`, `KOTA_SUPPLIER`, `TELEPON_SUPPLIER`, `NPWP_SUPPLIER`, `JENIS_PAJAK_SUPPLIER`, `KODE_PAJAK_SUPPLIER`) VALUES
('SUP001', 'PT HOLI PHARMACEUTICAL INDUSTR', 'JL . LEUWI GAJAH NO. 100 CIMINDI ', 'CIMAHI', '0318969078', '34.129.035.1-601.000', 'PPH PASAL 22 FARMASI', 'PAJAKFAR2'),
('SUP002', 'PT KIMIA FARMA', 'JL . CICENDO NO. 43 ', 'BANDUNG', '0226789012', '07.007.007.7-777.000', 'PPH PASAL 22 FARMASI', 'PAJAKFAR2'),
('SUP003', 'PT COMPHIPAR', 'JL . RAYA SIMPANG 383 PADALARANG', 'BANDUNG', '0223756112', '07.015.027.7-170.000', 'PPH PASAL 22 FARMASI', 'PAJAKFAR2'),
('SUP004', 'PT SANBE FARMA', 'L . INDUSTRI  I NO. 9 , DESA UTAMA, LEUWI GAJAH, C', 'CIMAHI', '0225722132', '34.127.041.1-602.000', 'PPH PASAL 22 FARMASI', 'PAJAKFAR2'),
('SUP005', 'PT GRACIA PHARMINDO', 'KAWASAN INDUSTRI DWI PAPURI  BLOK M­30 JL . RAYA R', 'BANDUNG', '0223755216', '07.105.222.7-255.000', 'PPH PASAL 22 FARMASI', 'PAJAKFAR2'),
('SUP006', 'PT SANDOZ INDONESIA', 'JL . RAYA CARINGIN 363 PADALARANG', 'BANDUNG', '02237676521', '07.046.007.7-007.000', 'PPH PASAL 22 FARMASI', 'PAJAKFAR2'),
('SUP007', 'PT KASA HUSADA', 'JALAN KALI MAS BARAT NO. 17 – 19', 'SURABAYA', '0313566721', '12.130.010.3-127.000', 'PPH PASAL 15 FARMASI', 'PAJAKFAR3'),
('SUP008', 'PT HENSON FARMA', 'JL . KARANGPILANG BARAT NO. 200', 'SURABAYA', '03133547721', '12.050.010.3-130.000', 'PPH PASAL 15 FARMASI', 'PAJAKFAR3'),
('SUP009', 'PT DURAFARMA JAYA', 'JL . RUNGKUT INDUSTRI  VIII/22­24 ', 'SURABAYA', '0318439617', '12.034.006.3-157.000', 'PPH PASAL 15 FARMASI', 'PAJAKFAR3'),
('SUP010', 'PT SURYA DERMATO MEDICA', 'JL . RUNGKUT INDUSTRI  III/31', 'SURABAYA', '0318493209', '12.035.005.3-008.000', 'PPH PASAL 15 FARMASI', 'PAJAKFAR3'),
('SUP011', 'PT OTSUKA INDONESIA', 'JL . SUMBER WARAS NO. 25 LAWANG', 'MALANG', '0341426244', '21.006.129.5-002.000', 'PPH PASAL 22 FARMASI', 'PAJAKFAm2'),
('SUP012', 'PT WIRO SATIVA FARMINDO', 'JL . RAYA TAMAN KM 20, TANJUNGSARI  TAMAN', 'SIDOARJO', '0317881440', '22.012.129.7-110.000', 'PPH PASAL 15 FARMASI', 'PAJAKFAR3'),
('SUP013', 'PT BINTANG TOEDJOE', 'JL . RAWA SUMUR BARAT II / K­9 KAWASAN INDUSTRI  P', 'JAKARTA TIMUR', '0214605533', '01.120.007.01-003.00', 'PPH PASAL 23/26 FARM', 'PAJAKFAR1'),
('SUP014', 'PT DANKOS FARMA', 'JL . RAWA GATEL  BLOK III S / 37­38 KAWASAN INDUST', 'JAKARTA TIMUR', '0214600158', '01.130.007.01-005.00', 'PPH PASAL 23/26 FARM', 'PAJAKFAR1'),
('SUP015', 'PT MERCK INDONESIA', 'JL . TB SIMATUPANG NO. 8 PASAR REBO', 'JAKARTA', '0218400081', '01.140.007.01-007.00', 'PPH PASAL 23/26 FARM', 'PAJAKFAR1'),
('SUP016', 'PT PHAROS INDONESIA', 'JL . LIMO 40 PERMATA HIJAU, SENAYAN', 'JAKARTA', '0217200981', '01.123.007.01-013.00', 'PPH PASAL 23/26 FARM', 'PAJAKFAR1'),
('SUP017', 'PT INTERNASIONAL CHEMICAL', 'JL . MOGOT KM 11 RT 06/03  CENGKARENG', 'JAKARTA BARAT', '0216252752', '01.170.007.01-077.00', 'PPH PASAL 23/26 FARM', 'PAJAKFAR1');

-- --------------------------------------------------------

--
-- Table structure for table `tindakan_dokter`
--

CREATE TABLE IF NOT EXISTS `tindakan_dokter` (
  `ID_TINDAKAN_DOKTER` char(6) NOT NULL,
  `TINDAKAN_DOKTER` text,
  `BIAYA_TINDAKAN_DOKTER` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID_TINDAKAN_DOKTER`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tindakan_dokter`
--

INSERT INTO `tindakan_dokter` (`ID_TINDAKAN_DOKTER`, `TINDAKAN_DOKTER`, `BIAYA_TINDAKAN_DOKTER`) VALUES
('TD001', 'INFUS - PASANG', 40000),
('TD002', 'INFUS - LEPAS', 15000),
('TD003', 'INFUS - GANTI CAIRAN INFUS (SPOELING INFUS)', 25000),
('TD004', 'SUNTIK KB', 40000),
('TD005', 'SUNTIK UMUM', 40000),
('TD006', 'RAWAT LUKA - BAKAR (BESAR)', 60000),
('TD007', 'RAWAT LUKA - BAKAR (KECIL)', 40000),
('TD008', 'SIRCUMSISI (LASER / BIASA) - REPAIR KHITAN', 480000),
('TD009', 'CABUT GIGI', 50000),
('TD010', 'TAMBAL GIGI', 50000),
('TD011', 'MEMBERSIHKAN KARANG GIGI', 70000),
('TD012', 'BLEACHING (PEMUTIHAN GIGI)', 1500000),
('TD013', 'PASANG KAWAT (BEHEL GIGI)', 2500000),
('TD014', 'LEPAS BRECKET PER RAHANG', 70000),
('TD015', 'TINDAKAN THT - SPOELING', 50000),
('TD016', 'IMUNISASI', 40000),
('TD017', 'IMUNISASI HEPATITIS', 70000),
('TD018', 'JAHIT LUKA (HECTING)', 50000),
('TD019', 'BUKA JAHITAN', 30000),
('TD020', 'MEDICAL CHECK UP', 150000),
('TD021', 'CEK TENSI', 10000);

-- --------------------------------------------------------

--
-- Table structure for table `tindakan_periksa`
--

CREATE TABLE IF NOT EXISTS `tindakan_periksa` (
  `ID_TINDAKAN_PERIKSA` int(11) NOT NULL,
  `ID_REKAM_MEDIS` char(6) NOT NULL,
  `ID_TINDAKAN_DOKTER` char(6) DEFAULT NULL,
  `ID_TRANSAKSI_PERIKSA` int(11) NOT NULL,
  PRIMARY KEY (`ID_TINDAKAN_PERIKSA`),
  KEY `FK_MENDAPATKAN2` (`ID_TINDAKAN_DOKTER`),
  KEY `FK_TERDIRI3` (`ID_REKAM_MEDIS`),
  KEY `FK_TERDIRI4` (`ID_TRANSAKSI_PERIKSA`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tindakan_periksa`
--


-- --------------------------------------------------------

--
-- Table structure for table `transaksi_obat`
--

CREATE TABLE IF NOT EXISTS `transaksi_obat` (
  `ID_TRANSAKSI_OBAT` int(11) NOT NULL AUTO_INCREMENT,
  `TANGGAL_JUAL` date DEFAULT NULL,
  `SUBTOTAL_TRANSAKSI_OBAT` int(11) DEFAULT NULL,
  `PPN_TRANSAKSI_OBAT` decimal(10,0) DEFAULT NULL,
  `TOTAL_TRANSAKSI_OBAT` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID_TRANSAKSI_OBAT`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=8 ;

--
-- Dumping data for table `transaksi_obat`
--

INSERT INTO `transaksi_obat` (`ID_TRANSAKSI_OBAT`, `TANGGAL_JUAL`, `SUBTOTAL_TRANSAKSI_OBAT`, `PPN_TRANSAKSI_OBAT`, `TOTAL_TRANSAKSI_OBAT`) VALUES
(1, '2015-04-12', 10000, '1000', 11000),
(2, '2015-04-26', 50000, '5000', 55000),
(3, '2015-04-26', 50000, '5000', 55000),
(4, '2015-04-26', 50000, '5000', 55000),
(5, '2015-04-26', 50000, '5000', 55000),
(6, '2015-04-26', 50000, '5000', 55000),
(7, '2015-04-26', 0, '0', 0);

-- --------------------------------------------------------

--
-- Table structure for table `transaksi_periksa`
--

CREATE TABLE IF NOT EXISTS `transaksi_periksa` (
  `ID_TRANSAKSI_PERIKSA` int(11) NOT NULL AUTO_INCREMENT,
  `ID_DOKTER` char(6) NOT NULL,
  `ID_PASIEN` int(11) NOT NULL,
  `SUBTOTAL_TRANSAKSI_PERIKSA` int(11) DEFAULT NULL,
  `PPN_TRANSAKSI_PERIKSA` decimal(10,0) DEFAULT NULL,
  `TOTAL_TRANSAKSI_PERIKSA` int(11) DEFAULT NULL,
  `KLAIM_BPJS` varchar(7) DEFAULT NULL,
  `NO_KARTU_TRANSAKSI` varchar(18) DEFAULT NULL,
  `TANGGAL_TRANSAKSI_PERIKSA` date DEFAULT NULL,
  PRIMARY KEY (`ID_TRANSAKSI_PERIKSA`),
  KEY `FK_DIISI2` (`ID_DOKTER`),
  KEY `FK_MENDAPTKAN1` (`ID_PASIEN`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=7 ;

--
-- Dumping data for table `transaksi_periksa`
--

INSERT INTO `transaksi_periksa` (`ID_TRANSAKSI_PERIKSA`, `ID_DOKTER`, `ID_PASIEN`, `SUBTOTAL_TRANSAKSI_PERIKSA`, `PPN_TRANSAKSI_PERIKSA`, `TOTAL_TRANSAKSI_PERIKSA`, `KLAIM_BPJS`, `NO_KARTU_TRANSAKSI`, `TANGGAL_TRANSAKSI_PERIKSA`) VALUES
(1, 'DOK002', 0, 100000, '10000', 110000, '0', NULL, '2015-04-10'),
(2, 'DOK001', 1, 5380000, '538000', 5918000, NULL, NULL, '2015-05-11'),
(3, 'DOK001', 5, 5380000, '538000', 5918000, NULL, NULL, '2015-05-11'),
(4, 'DOK001', 2, 5380000, '538000', 5918000, NULL, NULL, '2015-05-11'),
(5, 'DOK001', 2, 5380000, '538000', 5918000, NULL, NULL, '2015-05-11'),
(6, 'DOK001', 1, 5380000, '538000', 5918000, NULL, NULL, '2015-05-11');

--
-- Constraints for dumped tables
--

--
-- Constraints for table `beli`
--
ALTER TABLE `beli`
  ADD CONSTRAINT `FK_DARI1` FOREIGN KEY (`ID_SUPPLIER`) REFERENCES `supplier` (`ID_SUPPLIER`);

--
-- Constraints for table `detail_assessment_rekammedik`
--
ALTER TABLE `detail_assessment_rekammedik`
  ADD CONSTRAINT `detail_assessment_rekammedik_ibfk_1` FOREIGN KEY (`ID_REKAM_MEDIS`) REFERENCES `rekam_medis` (`ID_REKAM_MEDIS`);

--
-- Constraints for table `detail_beli`
--
ALTER TABLE `detail_beli`
  ADD CONSTRAINT `FK_BERISI5` FOREIGN KEY (`ID_OBAT`) REFERENCES `obat` (`ID_OBAT`),
  ADD CONSTRAINT `FK_TERDIRI6` FOREIGN KEY (`ID_BELI`) REFERENCES `beli` (`ID_BELI`);

--
-- Constraints for table `detail_resep_obat`
--
ALTER TABLE `detail_resep_obat`
  ADD CONSTRAINT `detail_resep_obat_ibfk_1` FOREIGN KEY (`ID_REKAM_MEDIS`) REFERENCES `rekam_medis` (`ID_REKAM_MEDIS`),
  ADD CONSTRAINT `detail_resep_obat_ibfk_2` FOREIGN KEY (`ID_OBAT`) REFERENCES `obat` (`ID_OBAT`);

--
-- Constraints for table `detail_transaksi_obat`
--
ALTER TABLE `detail_transaksi_obat`
  ADD CONSTRAINT `detail_transaksi_obat_ibfk_1` FOREIGN KEY (`ID_OBAT`) REFERENCES `obat` (`ID_OBAT`);

--
-- Constraints for table `dokter`
--
ALTER TABLE `dokter`
  ADD CONSTRAINT `FK_DIISI1` FOREIGN KEY (`ID_POLI`) REFERENCES `poliklinik` (`ID_POLI`);

--
-- Constraints for table `jadwal`
--
ALTER TABLE `jadwal`
  ADD CONSTRAINT `FK_MEMILIH2` FOREIGN KEY (`ID_DOKTER`) REFERENCES `dokter` (`ID_DOKTER`);

--
-- Constraints for table `kadaluarsa_obat`
--
ALTER TABLE `kadaluarsa_obat`
  ADD CONSTRAINT `FK_MEMILIKI2` FOREIGN KEY (`ID_OBAT`) REFERENCES `obat` (`ID_OBAT`);

--
-- Constraints for table `pendaftaran`
--
ALTER TABLE `pendaftaran`
  ADD CONSTRAINT `FK_DIPILIH1` FOREIGN KEY (`ID_DOKTER`) REFERENCES `dokter` (`ID_DOKTER`),
  ADD CONSTRAINT `FK_MEMILIH1` FOREIGN KEY (`ID_POLI`) REFERENCES `poliklinik` (`ID_POLI`),
  ADD CONSTRAINT `pendaftaran_ibfk_1` FOREIGN KEY (`ID_PASIEN`) REFERENCES `pasien` (`ID_PASIEN`);

--
-- Constraints for table `rekam_medis`
--
ALTER TABLE `rekam_medis`
  ADD CONSTRAINT `FK_DITULIS1` FOREIGN KEY (`ID_DOKTER`) REFERENCES `dokter` (`ID_DOKTER`),
  ADD CONSTRAINT `rekam_medis_ibfk_1` FOREIGN KEY (`ID_PASIEN`) REFERENCES `pasien` (`ID_PASIEN`);

--
-- Constraints for table `tindakan_periksa`
--
ALTER TABLE `tindakan_periksa`
  ADD CONSTRAINT `FK_MENDAPATKAN2` FOREIGN KEY (`ID_TINDAKAN_DOKTER`) REFERENCES `tindakan_dokter` (`ID_TINDAKAN_DOKTER`),
  ADD CONSTRAINT `tindakan_periksa_ibfk_1` FOREIGN KEY (`ID_TRANSAKSI_PERIKSA`) REFERENCES `transaksi_periksa` (`ID_TRANSAKSI_PERIKSA`),
  ADD CONSTRAINT `tindakan_periksa_ibfk_2` FOREIGN KEY (`ID_REKAM_MEDIS`) REFERENCES `rekam_medis` (`ID_REKAM_MEDIS`);

--
-- Constraints for table `transaksi_periksa`
--
ALTER TABLE `transaksi_periksa`
  ADD CONSTRAINT `FK_DIISI2` FOREIGN KEY (`ID_DOKTER`) REFERENCES `dokter` (`ID_DOKTER`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
