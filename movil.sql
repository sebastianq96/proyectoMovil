-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 31-05-2019 a las 19:01:35
-- Versión del servidor: 10.1.40-MariaDB
-- Versión de PHP: 7.3.5

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `movil`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `curso`
--

CREATE TABLE `curso` (
  `id_curso` int(11) NOT NULL,
  `descripcion` text NOT NULL,
  `fechaFin` date NOT NULL,
  `fechaIni` date NOT NULL,
  `horario` text NOT NULL,
  `nombreCurso` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `curso`
--

INSERT INTO `curso` (`id_curso`, `descripcion`, `fechaFin`, `fechaIni`, `horario`, `nombreCurso`) VALUES
(1234, 'Creacion apps moviles', '2019-06-20', '2019-01-14', 'sabados de 2pm-5pm', 'Movil'),
(3214, 'Diseño Transmedia', '2019-06-30', '2019-01-28', 'Virtual', 'Diseño Transmedia');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `novedades`
--

CREATE TABLE `novedades` (
  `cambioSalon` text NOT NULL,
  `cancelacionClase` text NOT NULL,
  `id_novedades` int(11) NOT NULL,
  `recordatorio` text NOT NULL,
  `salidaCampo` tinyint(1) NOT NULL,
  `longitud` float NOT NULL,
  `lactitud` float NOT NULL,
  `id_curso` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `novedades`
--

INSERT INTO `novedades` (`cambioSalon`, `cancelacionClase`, `id_novedades`, `recordatorio`, `salidaCampo`, `longitud`, `lactitud`, `id_curso`) VALUES
('Hoy tendremos vídeo llamada con Hangout.', 'Hoy tendremos vídeo llamada con Hangout.', 8597, 'Hoy tendremos vídeo llamada con Hangout.', 1, 0, 0, 3214),
('Nos vemos en LCC', 'No se cancela la clase', 654321, 'Recuerden que la clase es a las 10am', 1, 3.35354, -76521400, NULL);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `rol`
--

CREATE TABLE `rol` (
  `id_rol` int(11) NOT NULL,
  `id_curso` int(11) NOT NULL,
  `nombre` text NOT NULL,
  `cedula` text NOT NULL,
  `programa` text NOT NULL,
  `rol` text NOT NULL,
  `usuario` text NOT NULL,
  `contrasena` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `rol`
--

INSERT INTO `rol` (`id_rol`, `id_curso`, `nombre`, `cedula`, `programa`, `rol`, `usuario`, `contrasena`) VALUES
(0, 1234, 'Administrador', '1144088229', 'IM', 'admin', 'admin', 'admin'),
(456, 1234, 'sebastian quintero', '1107103', 'IM', 'estudiante', 'sebastianq', '12345'),
(789, 1234, 'Diego Fernando', '789456', 'IM', 'profesor', 'diegof', '1234');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `curso`
--
ALTER TABLE `curso`
  ADD PRIMARY KEY (`id_curso`),
  ADD KEY `id_curso` (`id_curso`);

--
-- Indices de la tabla `novedades`
--
ALTER TABLE `novedades`
  ADD PRIMARY KEY (`id_novedades`),
  ADD KEY `id_curso` (`id_curso`);

--
-- Indices de la tabla `rol`
--
ALTER TABLE `rol`
  ADD PRIMARY KEY (`id_rol`),
  ADD KEY `id_curso` (`id_curso`);

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `novedades`
--
ALTER TABLE `novedades`
  ADD CONSTRAINT `novedades_ibfk_1` FOREIGN KEY (`id_curso`) REFERENCES `curso` (`id_curso`);

--
-- Filtros para la tabla `rol`
--
ALTER TABLE `rol`
  ADD CONSTRAINT `rol_ibfk_1` FOREIGN KEY (`id_curso`) REFERENCES `curso` (`id_curso`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
