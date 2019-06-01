-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jun 01, 2019 at 08:36 AM
-- Server version: 10.1.35-MariaDB
-- PHP Version: 7.2.9

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `sellnbuy`
--

-- --------------------------------------------------------

--
-- Table structure for table `details`
--

CREATE TABLE `details` (
  `id` int(10) NOT NULL,
  `name` varchar(20) NOT NULL,
  `address` varchar(30) NOT NULL,
  `tel` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `details`
--

INSERT INTO `details` (`id`, `name`, `address`, `tel`) VALUES
(100, 'eddii', 'newyork', 424345),
(101, 'kamalhasan', 'newyork', 677),
(103, 'hasan', 'newyork', 677),
(105, 'kamal', 'newyork', 42434905);

-- --------------------------------------------------------

--
-- Table structure for table `item`
--

CREATE TABLE `item` (
  `id` int(11) NOT NULL,
  `name` varchar(500) NOT NULL,
  `description` varchar(500) NOT NULL,
  `price` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `item`
--

INSERT INTO `item` (`id`, `name`, `description`, `price`) VALUES
(1, 's10 Plus', 'Samsung S10 Plus', 120000),
(2, 'J7 Proooooooooooo', 'Samsung J7 Pro', 40000),
(3, 'Note 9', 'Samsung Note 9', 140000),
(4, 's8', 'Samsung S8', 90000);

-- --------------------------------------------------------

--
-- Table structure for table `payment`
--

CREATE TABLE `payment` (
  `id` int(11) DEFAULT NULL,
  `name` varchar(50) DEFAULT NULL,
  `country` varchar(15) DEFAULT NULL,
  `contactNo` varchar(10) DEFAULT NULL,
  `date` varchar(10) DEFAULT NULL,
  `creditCardType` varchar(20) DEFAULT NULL,
  `creditCardNo` int(11) DEFAULT NULL,
  `securityCode` varchar(5) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `payment`
--

INSERT INTO `payment` (`id`, `name`, `country`, `contactNo`, `date`, `creditCardType`, `creditCardNo`, `securityCode`) VALUES
(1, 'Ruwan', 'Sri Lanka', '0771822104', '2019.05.21', 'Visa Card', 5575, '6789'),
(2, 'Anjana', 'Italy', '0779485645', '2019.05.17', 'Visa Card', 2344, '3452'),
(3, 'Sasi', 'Greece', '0771276990', '2019.05.27', 'Master Card', 1124, '5577'),
(4, 'Shehani', 'Sri Lanka', '0719549812', '2019.04.12', 'Visa Card', 5566, '8888'),
(5, 'Suaj', 'Sri Lanka', '0719549812', '2019.04.12', 'Visa Card', 5566, '8888');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `item`
--
ALTER TABLE `item`
  ADD PRIMARY KEY (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
