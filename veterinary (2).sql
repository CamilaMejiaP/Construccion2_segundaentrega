-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 23-02-2024 a las 04:59:39
-- Versión del servidor: 8.0.33
-- Versión de PHP: 8.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";

/*DROP database veterinary;*/

--
-- Base de datos: `veterinary`
--
CREATE DATABASE veterinary;
use veterinary;
-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `role`
--

CREATE TABLE `role` (
  `id` int NOT NULL AUTO_INCREMENT PRIMARY KEY,
  `name` varchar(50) NOT NULL
);
-- --------------------------------------------------------

CREATE TABLE `session`(
`id` int NOT NULL AUTO_INCREMENT PRIMARY KEY,
`role_id` int NOT NULL,
`username` varchar(55) NOT NULL,

CONSTRAINT `fk_role_id` FOREIGN KEY (`role_id`) REFERENCES `role`(`id`)
);

-- ---------------------------------------------------------------------

--
-- Estructura de tabla para la tabla `person`
--

CREATE TABLE `person` (
  `id` bigint NOT NULL PRIMARY KEY,
  `age` int NOT NULL,
  `name` varchar(50) NOT NULL,
  `role_id` int NOT NULL,
  `username` varchar(55) NOT NULL,
  `password` varchar(55) NOT NULL,
  
  CONSTRAINT `fk_role_id_person` FOREIGN KEY (`role_id`) REFERENCES `role`(`id`)
) ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pet`
--

CREATE TABLE `pet` (
  `id` int NOT NULL AUTO_INCREMENT PRIMARY KEY,
  `name` varchar(250) NOT NULL,
  `owner_id` bigint NOT NULL,
  `age` int NOT NULL,
  `species` varchar(250) NOT NULL,
  `breed` varchar(250) NOT NULL,
  `caracteristics` varchar(250) NOT NULL,
  `weight` bigint NOT NULL,
  
  CONSTRAINT `fk_owner_id` FOREIGN KEY (`owner_id`) REFERENCES `person`(`id`)
) ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `order`
--

CREATE TABLE `order` (
  `id` int NOT NULL AUTO_INCREMENT PRIMARY KEY,
  `pet_id` int NOT NULL,
  `owner_id` bigint NOT NULL,
  `veterinarian_id` bigint NOT NULL,
  `medicine` text NOT NULL,
  `date` date NOT NULL,
  `is_canceled`BOOLEAN NOT NULL,
  
  CONSTRAINT `fk_pet_id` FOREIGN KEY (`pet_id`) REFERENCES `pet`(`id`),
  CONSTRAINT `fk_owner_id_order` FOREIGN KEY (`owner_id`) REFERENCES `person`(`id`),
  CONSTRAINT `fk_veterinarian_id` FOREIGN KEY (`veterinarian_id`) REFERENCES `person`(`id`)
);
-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `history`
--

CREATE TABLE `clinichistory` (
  `id` int NOT NULL AUTO_INCREMENT PRIMARY KEY,
  `date` date NOT NULL,
  `veterinarianId` bigint NOT NULL,
  `reason` varchar(250) NOT NULL,
  `symptoms` text NOT NULL,
  `diagnostic` text NOT NULL,
  `procedure_pet` text NOT NULL,
  `medicine` text NOT NULL,
  `dosis` varchar(250) NOT NULL,
  `order_id` int,
  `vaccination_history` text NOT NULL,
  `detail` text NOT NULL,
  `anulation` BOOLEAN NOT NULL,
  
  CONSTRAINT `fk_veterinarianId` FOREIGN KEY (`veterinarianId`) REFERENCES `person`(`id`)
) ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `bill`
--

CREATE TABLE `bill` (
  `id` int NOT NULL AUTO_INCREMENT PRIMARY KEY,
  `pet_id` int NOT NULL,
  `owner_id` bigint NOT NULL,
  `order_id` int NOT NULL,
  `product_name` varchar(250) NOT NULL,
  `value` bigint NOT NULL,
  `amount` int NOT NULL,
  `date` date NOT NULL,
  
  CONSTRAINT `fk_pet_id_bill` FOREIGN KEY (`pet_id`) REFERENCES `pet`(`id`),
  CONSTRAINT `fk_owner_id_bill` FOREIGN KEY (`owner_id`) REFERENCES `person`(`id`),
  CONSTRAINT `fk_order_id_bill` FOREIGN KEY (`order_id`) REFERENCES `order`(`id`)
) ;
-- --------------------------------------------------------




INSERT INTO `role` (`name`) VALUES ("Administrador");
INSERT INTO `role` (`name`) VALUES ("Vendedor");
INSERT INTO `role` (`name`) VALUES ("Veterinario");
INSERT INTO `person` (`id`,`age`,`name`,`role_id`,`username`,`password`) VALUES ("001","20","admin","1","admin","123");
  
select * FROM `session`;
select * FROM `person`;
select * from `role`;


