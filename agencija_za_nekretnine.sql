-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Feb 02, 2024 at 11:51 PM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `agencija_za_nekretnine`
--

-- --------------------------------------------------------

--
-- Table structure for table `dodatno`
--

CREATE TABLE `dodatno` (
  `DodatnoID` int(11) NOT NULL,
  `Terasa` tinyint(1) DEFAULT NULL,
  `ParkingMesto` tinyint(1) DEFAULT NULL,
  `Klima` tinyint(1) DEFAULT NULL,
  `Grejanje` tinyint(1) DEFAULT NULL,
  `Kablovska` tinyint(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `dodatno`
--

INSERT INTO `dodatno` (`DodatnoID`, `Terasa`, `ParkingMesto`, `Klima`, `Grejanje`, `Kablovska`) VALUES
(1, 1, 1, 0, 1, 1),
(2, 0, 1, 1, 0, 0),
(3, 1, 0, 1, 1, 1),
(4, 1, 1, 1, 1, 1),
(5, 0, 0, 0, 0, 0),
(6, 1, 0, 1, 1, 0);

-- --------------------------------------------------------

--
-- Table structure for table `fotografija`
--

CREATE TABLE `fotografija` (
  `FotografijaID` int(11) NOT NULL,
  `NepokretnostID` int(11) DEFAULT NULL,
  `Prilozena` tinyint(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `fotografija`
--

INSERT INTO `fotografija` (`FotografijaID`, `NepokretnostID`, `Prilozena`) VALUES
(1, 1, 1),
(2, 2, 0),
(3, 3, 1),
(4, 4, 0),
(5, 5, 1);

-- --------------------------------------------------------

--
-- Table structure for table `klijent`
--

CREATE TABLE `klijent` (
  `KlijentID` int(11) NOT NULL,
  `Ime` varchar(50) DEFAULT NULL,
  `Adresa` varchar(100) DEFAULT NULL,
  `Telefon` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `klijent`
--

INSERT INTO `klijent` (`KlijentID`, `Ime`, `Adresa`, `Telefon`) VALUES
(1, 'Milan Janković', 'Dunavska 11', '011-555-8888'),
(2, 'Tamara Ristić', 'Trg Branka Radičevića 7', '021-444-3333'),
(3, 'Dusan Petrovic', 'Svetog Save 22', '031-111-2222'),
(4, 'Ana Simic', 'Kralja Petra Prvog 5', '018-999-7777'),
(5, 'Lazar Jovic', 'Jovana Cvijica 33', '024-666-5555'),
(6, 'dasd', 'alsd', '+381638744488');

-- --------------------------------------------------------

--
-- Table structure for table `korisnici`
--

CREATE TABLE `korisnici` (
  `KorisniciID` int(11) NOT NULL,
  `username` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `korisnici`
--

INSERT INTO `korisnici` (`KorisniciID`, `username`, `password`) VALUES
(9, 'asd', '12345'),
(10, 'dsad', 'asdasdad');

-- --------------------------------------------------------

--
-- Table structure for table `lokacija`
--

CREATE TABLE `lokacija` (
  `LokacijaID` int(11) NOT NULL,
  `Drzava` varchar(50) DEFAULT NULL,
  `Grad` varchar(50) DEFAULT NULL,
  `Ulica` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `lokacija`
--

INSERT INTO `lokacija` (`LokacijaID`, `Drzava`, `Grad`, `Ulica`) VALUES
(1, 'Srbija', 'Novi Sad', 'Jovana Cvijića 18'),
(2, 'Srbija', 'Beograd', 'Francuska 14'),
(3, 'Srbija', 'Niš', 'Svetosavska 25'),
(4, 'Srbija', 'Kragujevac', 'Kneza Mihaila 9'),
(5, 'Srbija', 'Leskovac', 'Bulevar Oslobodjenja 21');

-- --------------------------------------------------------

--
-- Table structure for table `nepokretnost`
--

CREATE TABLE `nepokretnost` (
  `NepokretnostID` int(11) NOT NULL,
  `LokacijaID` int(11) DEFAULT NULL,
  `TipObjekta` varchar(50) DEFAULT NULL,
  `Povrsina` float DEFAULT NULL,
  `Cena` decimal(15,2) DEFAULT NULL,
  `VlasnikID` int(11) DEFAULT NULL,
  `DodatnoID` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `nepokretnost`
--

INSERT INTO `nepokretnost` (`NepokretnostID`, `LokacijaID`, `TipObjekta`, `Povrsina`, `Cena`, `VlasnikID`, `DodatnoID`) VALUES
(1, 1, 'Stan', 110, 110000.00, 1, 1),
(2, 2, 'Kuca', 200, 300000.00, 2, 2),
(3, 3, 'Stan', 60, 90000.00, 3, 3),
(4, 4, 'Apartman', 45, 40000.00, 4, 4),
(5, 5, 'Vikendica', 120, 150000.00, 5, 5),
(6, 1, 'Kuca', 120, 180000.00, 1, 6);

-- --------------------------------------------------------

--
-- Stand-in structure for view `pogledvlasnicinekretnine`
-- (See below for the actual view)
--
CREATE TABLE `pogledvlasnicinekretnine` (
`VlasnikID` int(11)
,`Ime` varchar(255)
,`NepokretnostID` int(11)
,`TipObjekta` varchar(50)
);

-- --------------------------------------------------------

--
-- Table structure for table `pregled`
--

CREATE TABLE `pregled` (
  `PregledID` int(11) NOT NULL,
  `NepokretnostID` int(11) NOT NULL,
  `DatumPregleda` date NOT NULL,
  `VremePregleda` time NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `pregled`
--

INSERT INTO `pregled` (`PregledID`, `NepokretnostID`, `DatumPregleda`, `VremePregleda`) VALUES
(1, 2, '2024-12-12', '16:08:00');

-- --------------------------------------------------------

--
-- Table structure for table `ugovor`
--

CREATE TABLE `ugovor` (
  `UgovorID` int(11) NOT NULL,
  `RedniBroj` int(11) DEFAULT NULL,
  `DatumNastanka` date DEFAULT NULL,
  `DatumIsteka` date DEFAULT NULL,
  `VlasnikID` int(11) DEFAULT NULL,
  `KlijentID` int(11) DEFAULT NULL,
  `Iznos` decimal(15,2) DEFAULT NULL,
  `NaknadaAgenciji` decimal(15,2) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `ugovor`
--

INSERT INTO `ugovor` (`UgovorID`, `RedniBroj`, `DatumNastanka`, `DatumIsteka`, `VlasnikID`, `KlijentID`, `Iznos`, `NaknadaAgenciji`) VALUES
(1, 1, '2020-02-10', '2021-02-10', 1, 1, 110000.00, 9000.00),
(2, 2, '2024-01-20', '2025-01-20', 2, 2, 300000.00, 20000.00),
(3, 3, '2024-03-05', '2025-03-05', 3, 3, 90000.00, 12000.00),
(4, 4, '2024-01-15', '2025-01-15', 4, 4, 80000.00, 6000.00),
(5, 5, '2024-02-28', '2025-02-28', 5, 5, 150000.00, 12000.00);

-- --------------------------------------------------------

--
-- Table structure for table `vlasniknekretnine`
--

CREATE TABLE `vlasniknekretnine` (
  `VlasnikID` int(11) NOT NULL,
  `Ime` varchar(255) DEFAULT NULL,
  `Adresa` varchar(255) DEFAULT NULL,
  `Telefon` varchar(15) DEFAULT NULL,
  `Godine` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `vlasniknekretnine`
--

INSERT INTO `vlasniknekretnine` (`VlasnikID`, `Ime`, `Adresa`, `Telefon`, `Godine`) VALUES
(1, 'Marija Petrović', 'Nova Adresa 123', '011-123-4567', 23),
(2, 'Nikola Stojanović', 'Beogradska 28', '021-987-6543', 33),
(3, 'Jovana Jovanović', 'Kneza Miloša 7', '031-567-8901', 30),
(4, 'Aleksa Marković', 'Bulevar Nemanjica 78', '018-234-5679', 57),
(5, 'Teodora Simić', 'Cara Lazara 33', '024-876-5432', 43);

-- --------------------------------------------------------

--
-- Structure for view `pogledvlasnicinekretnine`
--
DROP TABLE IF EXISTS `pogledvlasnicinekretnine`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `pogledvlasnicinekretnine`  AS SELECT `v`.`VlasnikID` AS `VlasnikID`, `v`.`Ime` AS `Ime`, `n`.`NepokretnostID` AS `NepokretnostID`, `n`.`TipObjekta` AS `TipObjekta` FROM (`vlasniknekretnine` `v` left join `nepokretnost` `n` on(`v`.`VlasnikID` = `n`.`VlasnikID`)) ;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `dodatno`
--
ALTER TABLE `dodatno`
  ADD PRIMARY KEY (`DodatnoID`);

--
-- Indexes for table `fotografija`
--
ALTER TABLE `fotografija`
  ADD PRIMARY KEY (`FotografijaID`),
  ADD KEY `NepokretnostID` (`NepokretnostID`);

--
-- Indexes for table `klijent`
--
ALTER TABLE `klijent`
  ADD PRIMARY KEY (`KlijentID`);

--
-- Indexes for table `korisnici`
--
ALTER TABLE `korisnici`
  ADD PRIMARY KEY (`KorisniciID`);

--
-- Indexes for table `lokacija`
--
ALTER TABLE `lokacija`
  ADD PRIMARY KEY (`LokacijaID`);

--
-- Indexes for table `nepokretnost`
--
ALTER TABLE `nepokretnost`
  ADD PRIMARY KEY (`NepokretnostID`),
  ADD KEY `LokacijaID` (`LokacijaID`),
  ADD KEY `VlasnikID` (`VlasnikID`),
  ADD KEY `DodatnoID` (`DodatnoID`);

--
-- Indexes for table `pregled`
--
ALTER TABLE `pregled`
  ADD PRIMARY KEY (`PregledID`);

--
-- Indexes for table `ugovor`
--
ALTER TABLE `ugovor`
  ADD PRIMARY KEY (`UgovorID`),
  ADD KEY `VlasnikID` (`VlasnikID`),
  ADD KEY `KlijentID` (`KlijentID`);

--
-- Indexes for table `vlasniknekretnine`
--
ALTER TABLE `vlasniknekretnine`
  ADD PRIMARY KEY (`VlasnikID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `dodatno`
--
ALTER TABLE `dodatno`
  MODIFY `DodatnoID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `fotografija`
--
ALTER TABLE `fotografija`
  MODIFY `FotografijaID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `klijent`
--
ALTER TABLE `klijent`
  MODIFY `KlijentID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `korisnici`
--
ALTER TABLE `korisnici`
  MODIFY `KorisniciID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT for table `lokacija`
--
ALTER TABLE `lokacija`
  MODIFY `LokacijaID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `nepokretnost`
--
ALTER TABLE `nepokretnost`
  MODIFY `NepokretnostID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `pregled`
--
ALTER TABLE `pregled`
  MODIFY `PregledID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `ugovor`
--
ALTER TABLE `ugovor`
  MODIFY `UgovorID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `vlasniknekretnine`
--
ALTER TABLE `vlasniknekretnine`
  MODIFY `VlasnikID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `fotografija`
--
ALTER TABLE `fotografija`
  ADD CONSTRAINT `fotografija_ibfk_1` FOREIGN KEY (`NepokretnostID`) REFERENCES `nepokretnost` (`NepokretnostID`);

--
-- Constraints for table `nepokretnost`
--
ALTER TABLE `nepokretnost`
  ADD CONSTRAINT `nepokretnost_ibfk_1` FOREIGN KEY (`LokacijaID`) REFERENCES `lokacija` (`LokacijaID`),
  ADD CONSTRAINT `nepokretnost_ibfk_2` FOREIGN KEY (`VlasnikID`) REFERENCES `vlasniknekretnine` (`VlasnikID`),
  ADD CONSTRAINT `nepokretnost_ibfk_3` FOREIGN KEY (`DodatnoID`) REFERENCES `dodatno` (`DodatnoID`);

--
-- Constraints for table `ugovor`
--
ALTER TABLE `ugovor`
  ADD CONSTRAINT `ugovor_ibfk_1` FOREIGN KEY (`VlasnikID`) REFERENCES `vlasniknekretnine` (`VlasnikID`),
  ADD CONSTRAINT `ugovor_ibfk_2` FOREIGN KEY (`KlijentID`) REFERENCES `klijent` (`KlijentID`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
