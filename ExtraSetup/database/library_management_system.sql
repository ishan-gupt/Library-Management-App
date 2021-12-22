-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Dec 30, 2020 at 01:00 PM
-- Server version: 10.4.14-MariaDB
-- PHP Version: 7.2.33

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `library_management_system`
--

-- --------------------------------------------------------

--
-- Table structure for table `admin`
--

CREATE TABLE `admin` (
  `a_id` int(5) NOT NULL,
  `a_email` varchar(35) NOT NULL,
  `pass` varchar(35) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `admin`
--

INSERT INTO `admin` (`a_id`, `a_email`, `pass`) VALUES
(1, 'parthpatel@gmail.com', '1234567890'),
(2, 'admin@gmail.com', 'pass');

-- --------------------------------------------------------

--
-- Table structure for table `books`
--

CREATE TABLE `books` (
  `b_id` int(5) NOT NULL,
  `b_name` varchar(55) NOT NULL,
  `b_code` int(10) NOT NULL,
  `b_author` varchar(55) NOT NULL,
  `b_sem` int(10) NOT NULL,
  `b_dept` varchar(55) NOT NULL,
  `b_price` int(55) NOT NULL,
  `b_count` int(40) NOT NULL,
  `b_img` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `books`
--

INSERT INTO `books` (`b_id`, `b_name`, `b_code`, `b_author`, `b_sem`, `b_dept`, `b_price`, `b_count`, `b_img`) VALUES
(8, 'Android', 9, 'MH. sir', 8, 'Computer', 100, 3, 'android.jpg'),
(13, 'SQL', 45, 'PHG.sir', 5, 'Computer', 56, 4, 'sql.jpg'),
(14, 'Data Structure', 35, 'LL.sir', 6, 'Computer', 400, 4, 'DS.jpg');

-- --------------------------------------------------------

--
-- Table structure for table `catagery`
--

CREATE TABLE `catagery` (
  `c_id` int(5) NOT NULL,
  `department` varchar(55) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `catagery`
--

INSERT INTO `catagery` (`c_id`, `department`) VALUES
(1, 'Computer'),
(2, 'Mech'),
(3, 'Civil'),
(4, 'Automobile');

-- --------------------------------------------------------

--
-- Table structure for table `collegenews`
--

CREATE TABLE `collegenews` (
  `n_id` int(5) NOT NULL,
  `date` date NOT NULL,
  `newsheading` varchar(55) NOT NULL,
  `newsimg` varchar(10) NOT NULL,
  `newsdescription` varchar(55) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `contact`
--

CREATE TABLE `contact` (
  `con_id` int(5) NOT NULL,
  `con_name` varchar(55) NOT NULL,
  `con_email` varchar(55) NOT NULL,
  `con_phone` bigint(10) NOT NULL,
  `con_sub` varchar(254) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `contact`
--

INSERT INTO `contact` (`con_id`, `con_name`, `con_email`, `con_phone`, `con_sub`) VALUES
(2, 'student', 'p@gmail.com', 1234567890, ' subject'),
(4, 'Sam', 'sam@gmail.com', 4344558792, ' Subject'),
(5, 'student', 'p@gmail.com', 1234567890, ' sdfghjjsdc '),
(7, 'KKJLN', 'sam@gmail.com', 1234567890, 'asdfvb '),
(8, 'KKJLN', 'sam@gmail.com', 1234567890, 'asdfvb ');

-- --------------------------------------------------------

--
-- Table structure for table `event`
--

CREATE TABLE `event` (
  `eventname` varchar(10) NOT NULL,
  `eventdate` date NOT NULL,
  `collegename` varchar(55) NOT NULL,
  `eventdescription` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `facultydata`
--

CREATE TABLE `facultydata` (
  `email` varchar(55) NOT NULL,
  `name` varchar(55) NOT NULL,
  `surname` varchar(55) NOT NULL,
  `mobile` bigint(10) NOT NULL,
  `sem` int(45) NOT NULL,
  `password` varchar(55) NOT NULL,
  `dept` varchar(55) NOT NULL,
  `book_code1` bigint(5) NOT NULL,
  `book_code2` bigint(55) NOT NULL,
  `book_issue1` date NOT NULL,
  `book_submit1` date NOT NULL,
  `book_issue2` date NOT NULL,
  `book_submit2` date NOT NULL,
  `book1_fine` int(10) NOT NULL,
  `book2_fine` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `facultydata`
--

INSERT INTO `facultydata` (`email`, `name`, `surname`, `mobile`, `sem`, `password`, `dept`, `book_code1`, `book_code2`, `book_issue1`, `book_submit1`, `book_issue2`, `book_submit2`, `book1_fine`, `book2_fine`) VALUES
('s@gmail.com', 'q', 'w', 2345678, 1, 'd', 'd', 40, 40, '2020-03-23', '2020-03-24', '2020-03-23', '2020-03-24', 50, 50);

-- --------------------------------------------------------

--
-- Table structure for table `news`
--

CREATE TABLE `news` (
  `n_id` int(5) NOT NULL,
  `img` varchar(55) NOT NULL,
  `title` varchar(55) NOT NULL,
  `description` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `news`
--

INSERT INTO `news` (`n_id`, `img`, `title`, `description`) VALUES
(8, 'img/werfg.png', 'Using MySQL and PHP with Maps', 'This Admin page'),
(12, 'img/a.png', 'exam', 'Exam form of final year students are available \r\nat online student corner. Please check the status. '),
(13, 'img/a.png', 'exam', 'Exam form of final year students are available \r\nat online student corner. Please check the status. ');

-- --------------------------------------------------------

--
-- Table structure for table `notifiy`
--

CREATE TABLE `notifiy` (
  `n_id` int(5) NOT NULL,
  `enroll` int(55) NOT NULL,
  `note1` varchar(55) NOT NULL,
  `note2` int(55) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `studentdata`
--

CREATE TABLE `studentdata` (
  `enroll` bigint(16) NOT NULL,
  `name` varchar(55) NOT NULL,
  `surname` varchar(55) NOT NULL,
  `mobile` bigint(10) NOT NULL,
  `password` varchar(55) NOT NULL,
  `sem` int(10) NOT NULL,
  `dept` varchar(55) NOT NULL,
  `book_code1` bigint(55) NOT NULL,
  `book_code2` bigint(55) NOT NULL,
  `book_issue1` date NOT NULL,
  `book_submit1` date NOT NULL,
  `book_issue2` date NOT NULL,
  `book_submit2` date NOT NULL,
  `book2_fine` int(55) NOT NULL,
  `book1_fine` int(55) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `studentdata`
--

INSERT INTO `studentdata` (`enroll`, `name`, `surname`, `mobile`, `password`, `sem`, `dept`, `book_code1`, `book_code2`, `book_issue1`, `book_submit1`, `book_issue2`, `book_submit2`, `book2_fine`, `book1_fine`) VALUES
(160200107075, 'parth', 'patel', 7698546063, 'qwerty', 8, 'Computer', 0, 0, '0000-00-00', '0000-00-00', '0000-00-00', '0000-00-00', 0, 0),
(160200107078, 'Rajesh ', 'pawar', 9834854581, '1234567890', 8, 'Computer', 9, 0, '2020-06-19', '2020-06-20', '0000-00-00', '0000-00-00', 0, 0);

-- --------------------------------------------------------

--
-- Table structure for table `subcategory`
--

CREATE TABLE `subcategory` (
  `sc_id` int(5) NOT NULL,
  `sc_name` varchar(55) NOT NULL,
  `c_id` int(5) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `subcategory`
--

INSERT INTO `subcategory` (`sc_id`, `sc_name`, `c_id`) VALUES
(1, 'Parth', 1),
(2, 'rajesh', 1),
(9, 'akki', 4),
(10, 'pratik', 3),
(12, 'Kevin', 3);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `admin`
--
ALTER TABLE `admin`
  ADD PRIMARY KEY (`a_id`);

--
-- Indexes for table `books`
--
ALTER TABLE `books`
  ADD PRIMARY KEY (`b_id`);

--
-- Indexes for table `catagery`
--
ALTER TABLE `catagery`
  ADD PRIMARY KEY (`c_id`);

--
-- Indexes for table `collegenews`
--
ALTER TABLE `collegenews`
  ADD PRIMARY KEY (`n_id`);

--
-- Indexes for table `contact`
--
ALTER TABLE `contact`
  ADD PRIMARY KEY (`con_id`);

--
-- Indexes for table `event`
--
ALTER TABLE `event`
  ADD PRIMARY KEY (`eventname`);

--
-- Indexes for table `facultydata`
--
ALTER TABLE `facultydata`
  ADD PRIMARY KEY (`email`);

--
-- Indexes for table `news`
--
ALTER TABLE `news`
  ADD PRIMARY KEY (`n_id`);

--
-- Indexes for table `notifiy`
--
ALTER TABLE `notifiy`
  ADD PRIMARY KEY (`n_id`);

--
-- Indexes for table `studentdata`
--
ALTER TABLE `studentdata`
  ADD PRIMARY KEY (`enroll`);

--
-- Indexes for table `subcategory`
--
ALTER TABLE `subcategory`
  ADD PRIMARY KEY (`sc_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `admin`
--
ALTER TABLE `admin`
  MODIFY `a_id` int(5) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `books`
--
ALTER TABLE `books`
  MODIFY `b_id` int(5) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;

--
-- AUTO_INCREMENT for table `catagery`
--
ALTER TABLE `catagery`
  MODIFY `c_id` int(5) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT for table `collegenews`
--
ALTER TABLE `collegenews`
  MODIFY `n_id` int(5) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `contact`
--
ALTER TABLE `contact`
  MODIFY `con_id` int(5) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT for table `news`
--
ALTER TABLE `news`
  MODIFY `n_id` int(5) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;

--
-- AUTO_INCREMENT for table `notifiy`
--
ALTER TABLE `notifiy`
  MODIFY `n_id` int(5) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `subcategory`
--
ALTER TABLE `subcategory`
  MODIFY `sc_id` int(5) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
