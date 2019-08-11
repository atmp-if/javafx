-- phpMyAdmin SQL Dump
-- version 4.6.5.2
-- https://www.phpmyadmin.net/
--
-- Хост: 127.0.0.1:3306
-- Час створення: Жов 30 2018 р., 23:57
-- Версія сервера: 5.5.53
-- Версія PHP: 5.5.38

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- База даних: `dblib`
--

-- --------------------------------------------------------

--
-- Структура таблиці `books`
--

CREATE TABLE `books` (
  `id` int(11) NOT NULL,
  `title` varchar(25) NOT NULL,
  `autor` varchar(25) NOT NULL,
  `year` int(11) NOT NULL,
  `about` varchar(500) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Дамп даних таблиці `books`
--

INSERT INTO `books` (`id`, `title`, `autor`, `year`, `about`) VALUES
(9, 'Інформатика', 'Завадський', 2015, 'Поглиблене'),
(10, 'Пітер Пен', 'Дж.Баррі', 2012, 'Найулюбленіша книжка мільйонів дітей по всьому світу! Книга запрошує малих і великих читачів у дивовижну подорож до острова \nНебувандії — країни вічного дитинства.'),
(11, 'А що як?...', 'Ренделл Манро', 2018, 'А що, як усі люди на Землі одночасно посвітять на Місяць лазерними указками? \nА що, як комусь удасться осушити всі океани?'),
(12, 'Дикий робот', 'Пітер Браун', 2018, 'Що буде, коли помістити робота в дику природу? \nНа перший погляд, такий задум не може закінчитися нічим цікавим'),
(13, '20000 льє під водою', 'Жуль Верн', 2013, 'Жуль Верн — видатний французький письменник, \nкласик науково-фантастичної та пригодницької літератури.');

--
-- Індекси збережених таблиць
--

--
-- Індекси таблиці `books`
--
ALTER TABLE `books`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT для збережених таблиць
--

--
-- AUTO_INCREMENT для таблиці `books`
--
ALTER TABLE `books`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
