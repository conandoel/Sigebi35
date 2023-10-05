-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 05-10-2023 a las 03:43:14
-- Versión del servidor: 10.4.28-MariaDB
-- Versión de PHP: 8.0.28

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `biblioteca`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ejemplar`
--

CREATE TABLE `ejemplar` (
  `idEjemplar` int(13) NOT NULL,
  `isbn` varchar(22) NOT NULL,
  `estado` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `ejemplar`
--

INSERT INTO `ejemplar` (`idEjemplar`, `isbn`, `estado`) VALUES
(1, '978-950-071-822-6', 'En Reparación'),
(2, '978-950-075-575-7', 'Prestado'),
(3, '978-987-242-561-6', 'Disponible'),
(4, '978-987-48326-9-6', 'Prestado'),
(5, '978-987-550-550-6', 'Disponible'),
(6, '978-987-580-609-2', 'En Reparación'),
(7, '978-987-617-012-3', 'En Reparación'),
(8, '978-987-662-064-2', 'Prestado'),
(9, '978-987-688-451-8', 'Disponible'),
(10, '978-987-705-395-2', 'Prestado'),
(11, '978-987-767-388-3', 'Disponible'),
(12, '978-987-767-395-1', 'Disponible'),
(13, '978-987-8481-65-4', 'Disponible'),
(14, 'PRE-ISBN-00000001', 'En Reparación'),
(15, '978-950-071-822-6', 'Disponible'),
(16, '978-950-075-575-7', 'Disponible'),
(17, '978-950-075-576-4', 'Prestado'),
(18, '978-987-242-561-6', 'En Reparación'),
(19, '978-987-48326-9-6', 'Prestado'),
(20, '978-987-550-550-6', 'Disponible'),
(21, '978-987-617-012-3', 'Disponible'),
(22, '978-987-662-064-2', 'Disponible'),
(23, '978-987-688-451-8', 'Disponible'),
(24, '978-987-705-395-2', 'Prestado'),
(25, '978-987-767-388-3', 'Disponible'),
(26, '978-987-767-395-1', 'Disponible'),
(27, '978-987-8481-65-4', 'Disponible'),
(28, 'PRE-ISBN-00000001', 'En Reparación'),
(29, '978-950-071-822-6', 'Disponible'),
(30, '978-950-075-576-4', 'Disponible'),
(31, '978-987-242-561-6', 'Prestado'),
(32, '978-987-48326-9-6', 'Prestado'),
(33, '978-987-617-012-3', 'Disponible'),
(34, '978-987-688-451-8', 'Prestado'),
(35, '978-987-767-395-1', 'Prestado'),
(36, '978-987-8481-65-4', 'En Reparación'),
(37, 'PRE-ISBN-00000001', 'Disponible'),
(38, '978-987-48326-9-6', 'Disponible'),
(39, '978-987-617-012-3', 'Disponible'),
(40, 'PRE-ISBN-00000001', 'Prestado'),
(41, '978-987-48326-9-6', 'Disponible'),
(42, '978-987-617-012-3', 'Prestado'),
(43, '978-987-617-012-3', 'Prestado');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `lector`
--

CREATE TABLE `lector` (
  `idSocio` int(8) NOT NULL,
  `apellido` varchar(100) NOT NULL,
  `nombre` varchar(100) NOT NULL,
  `domicilio` varchar(100) NOT NULL,
  `mail` varchar(100) NOT NULL,
  `fechaDeAlta` date NOT NULL,
  `fechaDeBaja` date DEFAULT NULL,
  `estado` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `lector`
--

INSERT INTO `lector` (`idSocio`, `apellido`, `nombre`, `domicilio`, `mail`, `fechaDeAlta`, `fechaDeBaja`, `estado`) VALUES
(5556, 'Di Monte', 'Iván Sergio', 'Rawson 693', 'ivansdmonte@hotmail.com', '1984-01-12', NULL, 1),
(5557, 'Manrique', 'Luis Emilio', 'Larrea 3552', 'luigui@gmail.com', '1980-05-15', NULL, 1),
(5558, 'Torres', 'Nelson Tobías', 'Av. Falcón 1220 bis', 'nelsoncrack@gmail.com', '1994-12-01', '2009-02-27', 0),
(5559, 'Ojeda', 'Silvia', 'Bv. Reconquista 770, 1º Piso, Dpto. \"C\"', 'siviaojeda@hotmail.com', '1997-02-18', NULL, 1),
(5560, 'Ramirez', 'Augusto', 'Lima 55, 5º Piso, Dpto. \"2\"', 'yiyaya@gmail.com', '2001-06-07', '2022-10-09', 0),
(5561, 'Caccia', 'Damián', 'Thompson 852', 'damicacci@gmail.com', '2005-09-21', NULL, 1),
(5562, 'Zanabria', 'Eugenia', 'Felipe Moré 2477', 'eugizanabria96@gmail.com', '1978-11-30', NULL, 1),
(5563, 'Baletto', 'Lorena', 'Balcarce 6510', 'loreloi@hotmail.com', '1996-08-19', NULL, 1),
(5564, 'Edison', 'Lara', 'Estebanez 112', 'parssin@gmail.com', '1989-03-04', '2020-10-08', 0),
(5565, 'Peuchele', 'Rubén', 'Mitre 3008', 'rubencito@hotmail.com', '1992-04-24', NULL, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `libro`
--

CREATE TABLE `libro` (
  `isbn` varchar(22) NOT NULL,
  `titulo` varchar(100) NOT NULL,
  `autor` varchar(100) NOT NULL,
  `anio` year(4) NOT NULL,
  `genero` varchar(100) NOT NULL,
  `editorial` varchar(100) NOT NULL,
  `estado` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `libro`
--

INSERT INTO `libro` (`isbn`, `titulo`, `autor`, `anio`, `genero`, `editorial`, `estado`) VALUES
('978-950-071-822-6', 'La Muerte y Otras Sorpresas', 'Benedetti, Mario', '2000', 'Narrativa Breve', 'Sudamericana', 1),
('978-950-075-575-7', 'Ficciones', 'Borges, Jorge Luis', '2016', 'Narrativa Breve', 'Sudamericana', 1),
('978-950-075-576-4', 'El Aleph', 'Borges, Jorge Luis', '2011', 'Narrativa Breve', 'Sudamericana', 1),
('978-987-242-561-6', 'El Príncipe', 'Maquiavelo, Nicolás', '2008', 'Política', 'BEEME', 1),
('978-987-48326-9-6', 'El Principito', 'Saint-Exupery, Antoine de', '2022', 'Infantil', 'Libertador', 1),
('978-987-550-550-6', 'El Libro de Monelle', 'SchWob, Marcel', '1968', 'Narrativa Breve', 'Ramón Sopena', 1),
('978-987-580-609-2', 'El Libro del Fantasma', 'Dolina, Alejandro', '2013', 'Narrativa Breve', 'Terramar', 1),
('978-987-617-012-3', 'Alicia en el País de las Maravillas', 'Carroll, Lewis', '2016', 'Infantil', 'Terramar', 1),
('978-987-662-064-2', 'La Vuelta al Mundo en Ochenta Días', 'Verne, Julio', '2016', 'Aventura', 'Centro Editor de Cultura', 1),
('978-987-688-451-8', 'El Principito', 'Saint-Exupery, Antoine de', '2021', 'Infantil', 'UniRío Editora', 1),
('978-987-705-395-2', 'El Principito', 'Saint-Exupery, Antoine de', '2015', 'Infantil', 'El Gato de Hojalata', 1),
('978-987-767-388-3', 'Cazador de nubes', 'Vedia, Fernando de', '2023', 'Infantil', 'Planeta Lector', 1),
('978-987-767-395-1', 'El Principito', 'Saint-Exupery, Antoine de', '2023', 'Infantil', 'Planeta Lector', 1),
('978-987-8481-65-4', 'El Principito ha regresado', 'Núñez, Ramón Avelino', '2022', 'Infantil', 'Editorial D', 1),
('PRE-ISBN-00000001', 'Fausto', 'Goethe, Wolfgang', '1968', 'Tragedia', 'Ramón Sopena', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `prestamo`
--

CREATE TABLE `prestamo` (
  `idPrestamo` int(11) NOT NULL,
  `fechaInicio` date NOT NULL,
  `fechaFin` date NOT NULL,
  `idEjemplar` int(11) NOT NULL,
  `idSocio` int(11) NOT NULL,
  `estado` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `prestamo`
--

INSERT INTO `prestamo` (`idPrestamo`, `fechaInicio`, `fechaFin`, `idEjemplar`, `idSocio`, `estado`) VALUES
(1, '2023-09-28', '2023-10-05', 2, 5556, 1),
(2, '2023-09-29', '2023-10-06', 4, 5559, 1),
(3, '2023-09-29', '2023-10-06', 43, 5559, 1),
(4, '2023-09-30', '2023-09-07', 40, 5557, 1),
(5, '2023-10-02', '2023-10-09', 31, 5562, 1),
(6, '2023-10-02', '2023-10-09', 8, 5562, 1),
(7, '2023-10-02', '2023-10-09', 24, 5563, 1),
(8, '2023-10-03', '2023-10-10', 34, 5561, 1),
(9, '2023-10-03', '2023-10-10', 17, 5556, 1),
(10, '2023-10-03', '2023-10-10', 42, 5563, 1),
(11, '2023-10-03', '2023-10-10', 10, 5557, 1),
(12, '2023-10-04', '2023-10-11', 35, 5561, 1),
(13, '2023-10-04', '2023-10-11', 32, 5565, 1),
(14, '2023-10-04', '2023-10-11', 19, 5565, 1);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `ejemplar`
--
ALTER TABLE `ejemplar`
  ADD PRIMARY KEY (`idEjemplar`),
  ADD KEY `isbn` (`isbn`);

--
-- Indices de la tabla `lector`
--
ALTER TABLE `lector`
  ADD PRIMARY KEY (`idSocio`);

--
-- Indices de la tabla `libro`
--
ALTER TABLE `libro`
  ADD PRIMARY KEY (`isbn`);

--
-- Indices de la tabla `prestamo`
--
ALTER TABLE `prestamo`
  ADD PRIMARY KEY (`idPrestamo`),
  ADD KEY `ejemplar` (`idEjemplar`),
  ADD KEY `idSocio` (`idSocio`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `ejemplar`
--
ALTER TABLE `ejemplar`
  MODIFY `idEjemplar` int(13) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=44;

--
-- AUTO_INCREMENT de la tabla `lector`
--
ALTER TABLE `lector`
  MODIFY `idSocio` int(8) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5566;

--
-- AUTO_INCREMENT de la tabla `prestamo`
--
ALTER TABLE `prestamo`
  MODIFY `idPrestamo` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `ejemplar`
--
ALTER TABLE `ejemplar`
  ADD CONSTRAINT `ejemplar_ibfk_1` FOREIGN KEY (`isbn`) REFERENCES `libro` (`isbn`);

--
-- Filtros para la tabla `prestamo`
--
ALTER TABLE `prestamo`
  ADD CONSTRAINT `prestamo_ibfk_1` FOREIGN KEY (`idEjemplar`) REFERENCES `ejemplar` (`idEjemplar`),
  ADD CONSTRAINT `prestamo_ibfk_2` FOREIGN KEY (`idSocio`) REFERENCES `lector` (`idSocio`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
