-- phpMyAdmin SQL Dump
-- version 5.0.4
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1:33065
-- Tiempo de generación: 10-07-2021 a las 00:26:55
-- Versión del servidor: 10.4.16-MariaDB
-- Versión de PHP: 7.4.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `juego`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `carril`
--

CREATE TABLE `carril` (
  `idcarril` int(11) NOT NULL,
  `nomcarril` varchar(45) NOT NULL,
  `distarecorrida` int(20) NOT NULL,
  `idpista` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `carro`
--

CREATE TABLE `carro` (
  `idcarro` int(11) NOT NULL,
  `nomcarro` varchar(45) NOT NULL,
  `numganador` int(11) NOT NULL,
  `idcarril` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `conductor`
--

CREATE TABLE `conductor` (
  `idconductor` int(11) NOT NULL,
  `nomconductor` varchar(45) NOT NULL,
  `numerocarro` int(11) NOT NULL,
  `numerocarril` int(11) NOT NULL,
  `avance` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `conductor`
--

INSERT INTO `conductor` (`idconductor`, `nomconductor`, `numerocarro`, `numerocarril`, `avance`) VALUES
(1, 'cesar', 12, 1, 2200),
(2, 'alberto', 23, 2, 2200),
(3, 'ceyni', 34, 3, 2100);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pista`
--

CREATE TABLE `pista` (
  `idpista` int(11) NOT NULL,
  `distancia` int(11) NOT NULL,
  `numerocarril` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `pista`
--

INSERT INTO `pista` (`idpista`, `distancia`, `numerocarril`) VALUES
(1, 2000, 3);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `podio`
--

CREATE TABLE `podio` (
  `idpodio` int(11) NOT NULL,
  `conductor` int(11) NOT NULL,
  `puesto` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `podio`
--

INSERT INTO `podio` (`idpodio`, `conductor`, `puesto`) VALUES
(1, 0, 1),
(2, 0, 2),
(3, 0, 3);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `carril`
--
ALTER TABLE `carril`
  ADD PRIMARY KEY (`idcarril`);

--
-- Indices de la tabla `carro`
--
ALTER TABLE `carro`
  ADD PRIMARY KEY (`idcarro`);

--
-- Indices de la tabla `conductor`
--
ALTER TABLE `conductor`
  ADD PRIMARY KEY (`idconductor`);

--
-- Indices de la tabla `pista`
--
ALTER TABLE `pista`
  ADD PRIMARY KEY (`idpista`);

--
-- Indices de la tabla `podio`
--
ALTER TABLE `podio`
  ADD PRIMARY KEY (`idpodio`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `carril`
--
ALTER TABLE `carril`
  MODIFY `idcarril` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de la tabla `carro`
--
ALTER TABLE `carro`
  MODIFY `idcarro` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de la tabla `conductor`
--
ALTER TABLE `conductor`
  MODIFY `idconductor` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de la tabla `pista`
--
ALTER TABLE `pista`
  MODIFY `idpista` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de la tabla `podio`
--
ALTER TABLE `podio`
  MODIFY `idpodio` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
