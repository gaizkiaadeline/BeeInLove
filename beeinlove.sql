-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Waktu pembuatan: 23 Jan 2023 pada 16.36
-- Versi server: 10.4.24-MariaDB
-- Versi PHP: 8.1.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `beeinlove`
--

-- --------------------------------------------------------

--
-- Struktur dari tabel `msfemaleuser`
--

CREATE TABLE `msfemaleuser` (
  `UserName` varchar(200) NOT NULL,
  `UserAge` int(11) DEFAULT NULL,
  `UserJob` varchar(200) NOT NULL,
  `UserHobby` varchar(200) NOT NULL,
  `UserMusicGenre` varchar(200) NOT NULL,
  `UserMajor` varchar(200) NOT NULL,
  `UserCampus` varchar(200) NOT NULL,
  `UserIntGend` varchar(200) NOT NULL,
  `UserIntAge` int(11) NOT NULL,
  `UserIntOcc` varchar(200) NOT NULL,
  `UserIntHobby` varchar(200) NOT NULL,
  `UserIntMusic` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `msfemaleuser`
--

INSERT INTO `msfemaleuser` (`UserName`, `UserAge`, `UserJob`, `UserHobby`, `UserMusicGenre`, `UserMajor`, `UserCampus`, `UserIntGend`, `UserIntAge`, `UserIntOcc`, `UserIntHobby`, `UserIntMusic`) VALUES
('Acel', 20, 'Singer', 'SInging', 'RnB', 'CS', 'BINUS', 'M', 22, 'Programmer', 'Singing', 'RnB'),
('Adeline', 20, 'Programmer', 'Singing', 'RnB', 'CS', 'BINUS', 'M', 21, 'Programmer', 'Singing', 'RnB'),
('Cathy', 22, 'Model', 'Singing', 'Classic', 'English Literature', 'UI', 'M', 22, 'Programmer', 'Reading', 'Jazz'),
('Jane', 20, 'Model', 'Singing', 'Rock', 'Premed', 'Harvard', 'M', 23, 'Programmer', 'Singing', 'Jazz'),
('Kimmy', 20, 'Singer', 'Reading', 'RnB', 'Premed', 'Yale', 'M', 23, 'Singer', 'Reading', 'Jazz'),
('Lien', 20, 'Singer', 'Singing', 'Jazz', 'CS', 'BINUS', 'M', 22, 'Actor', 'Singing', 'Jazz'),
('Lily', 20, 'Singer', 'Singing', 'Pop', 'Management', 'BINUS', 'M', 20, 'Programmer', 'Playing games', 'Jazz'),
('Olive', 20, 'Singer', 'Singing', 'RnB', 'CS', 'BINUS', 'M', 21, 'Programmer', 'Playing games', 'RnB');

-- --------------------------------------------------------

--
-- Struktur dari tabel `msmaleuser`
--

CREATE TABLE `msmaleuser` (
  `UserName` varchar(200) NOT NULL,
  `UserAge` int(11) DEFAULT NULL,
  `UserJob` varchar(200) NOT NULL,
  `UserHobby` varchar(200) NOT NULL,
  `UserMusicGenre` varchar(200) NOT NULL,
  `UserMajor` varchar(200) NOT NULL,
  `UserCampus` varchar(200) NOT NULL,
  `UserIntGend` varchar(200) NOT NULL,
  `UserIntAge` int(11) NOT NULL,
  `UserIntOcc` varchar(200) NOT NULL,
  `UserIntHobby` varchar(200) NOT NULL,
  `UserIntMusic` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `msmaleuser`
--

INSERT INTO `msmaleuser` (`UserName`, `UserAge`, `UserJob`, `UserHobby`, `UserMusicGenre`, `UserMajor`, `UserCampus`, `UserIntGend`, `UserIntAge`, `UserIntOcc`, `UserIntHobby`, `UserIntMusic`) VALUES
('Darren', 24, 'Soccer Player', 'Reading', 'Jazz', 'CS', 'Oxford', 'F', 21, 'Model', 'Singing', 'RnB'),
('Hans', 20, 'Student', 'Watching', 'Pop', 'CS', 'BINUS', 'F', 20, 'Singer', 'SInging', 'Jazz'),
('Hendrik', 23, 'Actor', 'Singing', 'Jazz', 'CS', 'BINUS', 'F', 20, 'Singer', 'Singing', 'Jazz'),
('John', 22, 'Programmer', 'Coding', 'Rock', 'CS', 'BINUS', 'F', 20, 'Singer', 'Singing', 'Jazz'),
('Kay', 22, 'Data Analyst', 'Playing games', 'Jazz', 'CS', 'BINUS', 'F', 20, 'Singer', 'Singing', 'RnB'),
('Leo', 22, 'Programmer', 'Singing', 'Jazz', 'Cyber', 'BINUS', 'F', 20, 'Singer', 'Singing', 'Jazz'),
('Lion', 22, 'Actor', 'Singing', 'Jazz', 'CS', 'BINUS', 'F', 20, 'Singer', 'Singing', 'Jazz'),
('Luthfi', 20, 'Programmer', 'Playing games', 'Jazz', 'CS', 'BINUS', 'F', 20, 'SInger', 'Singing', 'Pop'),
('Niall', 24, 'Singer', 'Reading', 'Jazz', 'CS', 'MIT', 'F', 22, 'Singer', 'RnB', 'Jazz'),
('Olly', 22, 'Actor', 'Reading', 'Jazz', 'CS', 'BINUS', 'F', 20, 'Singer', 'Singing', 'Jazz'),
('Reyn', 21, 'Programmer', 'Singing', 'RnB', 'Cyber', 'BINUS', 'F', 20, 'Programmer', 'Singing', 'RnB');

-- --------------------------------------------------------

--
-- Struktur dari tabel `msuser`
--

CREATE TABLE `msuser` (
  `UserName` varchar(200) NOT NULL,
  `UserAge` int(11) DEFAULT NULL,
  `UserJob` varchar(200) NOT NULL,
  `UserHobby` varchar(200) NOT NULL,
  `UserMusicGenre` varchar(200) NOT NULL,
  `UserMajor` varchar(200) NOT NULL,
  `UserCampus` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `msuser`
--

INSERT INTO `msuser` (`UserName`, `UserAge`, `UserJob`, `UserHobby`, `UserMusicGenre`, `UserMajor`, `UserCampus`) VALUES
('Acel', 20, 'Singer', 'SInging', 'RnB', 'CS', 'BINUS'),
('Adeline', 20, 'Programmer', 'Singing', 'RnB', 'CS', 'BINUS'),
('Cathy', 22, 'Model', 'Singing', 'Classic', 'English Literature', 'UI'),
('Darren', 24, 'Soccer Player', 'Reading', 'Jazz', 'CS', 'Oxford'),
('Ella', 21, 'Model', 'Reading', 'Rock', 'Accounting', 'Yale'),
('Hans', 20, 'Student', 'Watching', 'Pop', 'CS', 'BINUS'),
('Hendrik', 23, 'Actor', 'Singing', 'Jazz', 'CS', 'BINUS'),
('Jane', 20, 'Model', 'Singing', 'Rock', 'Premed', 'Harvard'),
('John', 22, 'Programmer', 'Coding', 'Rock', 'CS', 'BINUS'),
('Kay', 22, 'Data Analyst', 'Playing games', 'Jazz', 'CS', 'BINUS'),
('Kimmy', 20, 'Singer', 'Reading', 'RnB', 'Premed', 'Yale'),
('Leo', 22, 'Programmer', 'Singing', 'Jazz', 'Cyber', 'BINUS'),
('Lily', 20, 'Singer', 'Singing', 'Pop', 'Management', 'BINUS'),
('Luthfi', 20, 'Programmer', 'Playing games', 'Jazz', 'CS', 'BINUS'),
('Niall', 24, 'Singer', 'Reading', 'Jazz', 'CS', 'MIT'),
('Olive', 20, 'Singer', 'Singing', 'RnB', 'CS', 'BINUS'),
('Olly', 22, 'Actor', 'Reading', 'Jazz', 'CS', 'BINUS'),
('Reyn', 21, 'Programmer', 'Singing', 'RnB', 'Cyber', 'BINUS');

--
-- Indexes for dumped tables
--

--
-- Indeks untuk tabel `msfemaleuser`
--
ALTER TABLE `msfemaleuser`
  ADD PRIMARY KEY (`UserName`);

--
-- Indeks untuk tabel `msmaleuser`
--
ALTER TABLE `msmaleuser`
  ADD PRIMARY KEY (`UserName`);

--
-- Indeks untuk tabel `msuser`
--
ALTER TABLE `msuser`
  ADD PRIMARY KEY (`UserName`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
