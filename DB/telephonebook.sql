-- phpMyAdmin SQL Dump
-- version 4.0.4
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Nov 28, 2013 at 06:54 PM
-- Server version: 5.5.32
-- PHP Version: 5.4.16

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `telephonebook`
--
CREATE DATABASE IF NOT EXISTS `telephonebook` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `telephonebook`;

-- --------------------------------------------------------

--
-- Table structure for table `mobilephone`
--

CREATE TABLE IF NOT EXISTS `mobilephone` (
  `firstname` text NOT NULL,
  `lastname` text,
  `mobilephone` char(10) NOT NULL,
  `id` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=12 ;

--
-- Dumping data for table `mobilephone`
--

INSERT INTO `mobilephone` (`firstname`, `lastname`, `mobilephone`, `id`) VALUES
('Sdffh', 'Assdsd', '1234567890', 8),
('Pavl', 'Facksk', '091233333', 9),
('asdsdds', 'yttrt', '12222222', 10),
('Dmitriy', 'Kozlovskiy', '1928378123', 11);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
