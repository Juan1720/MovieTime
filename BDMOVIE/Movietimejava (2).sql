Create database MovieTime;
use MovieTime;

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

-- ------------------------------------------------------


create table if not exists `MovieTime`. `Distrito`(
`idDistrito` int not null auto_increment,
`distrito` varchar(30) not null,
	primary key(`idDistrito`)
);
Create table if not exists `MovieTime`.`Sala`(
`idSala` int not null auto_increment,
`sala` varchar(30) not null,
`capacidad` varchar(20)  not null,
	primary key(`idSala`)
);

Create table if not exists `Movietime`.`Precio`(
`idPrecio` int not null auto_increment,
`Precio` Decimal not null,
`DescripPrecio` varchar(30) not null,
	primary key(`idPrecio`)
);

Create table if not exists `MovieTime`.`Cartelera`(
`idCartelera` int not null auto_increment,
`titulo` varchar(50) not null,
`genero` varchar(20) not null,
`duracion`varchar(10) not null,
`director` varchar(40) not null,
`clasificacion` varchar(25) not null,
`imagen` varchar(65535) not null,
	primary key(`idcartelera`)
);

/*Create table if not exists `MovieTime`.`Horario`(
`idHorario` int not null auto_increment,
`fecha` date not null,
`hora` time not null,
	Primary key(`idHorario`)
);*/

Create table if not exists `MovieTime`.`Usuario`(
`idUsuario` int not null auto_increment,
`usuario` varchar (25) not null,
`tipRol` varchar(20) not null,
`contrasena` varchar(9) not null,
`nombres` varchar(30) not null,
`apellidos` varchar(50) not null,
`dni` varchar(8) not null,
`Direccion` varchar(50) not null,
`telefono` varchar(9) not null,
`correo` varchar(25) not null,
	primary key(`idUsuario`)
);

Create table if not exists `MovieTime`.`Cine`(
`idCine` int not null auto_increment,
`cine` varchar(50) not null,
`distrito` int not null,
`telefono` varchar(9) not null,
`direccion` varchar(60) not null,
`imagen` varchar(65535) not null,
`estado` bit not null,
	primary key(`idCine`),
Key `fk_cine_distrito` using hash (`distrito`),
constraint `fk_cine_distrito`
foreign key (`distrito`)
references `MovieTime`.`Distrito` (`idDistrito`)
on update cascade
);



Create table if not exists `MovieTime`.`Asientos`(
`idAsientos` int not null auto_increment,
`asiento` varchar(3) not null,
`sala` int not null,
`estado` bit not null,
	primary key(`idAsientos`),
Key `fk_asientos_sala` using hash (`sala`),
constraint `fk_asientos_sala`
foreign key (`sala`)
references `MovieTime`.`sala` (`idSala`)
on update cascade
);

Create table if not exists `Movietime`.`Funciones`(

`idFuncion` int not null auto_increment,
`cartelera` int not null,
`cine` int not null,
`sala` int not null,
`fecha` varchar(20) not null,
`hora` varchar(10) not null,
`tipFuncion` varchar(20) not null,
`estado` bit not null,
	primary key(`idFuncion`),
Key `fk_funciones_cartelera` using hash (`cartelera`),
Key `fk_funciones_cine` using hash (`cine`),
key `fk_funciones_sala` using hash (`sala`),
constraint `fk_funciones_cartelera`
	foreign key (`cartelera`)
    references `MovieTime`.`Cartelera` (`idCartelera`)
    on update cascade,
constraint `fk_funciones_cine`
	foreign key (`cine`)
	references `MovieTime`.`Cine`(`idCine`)
	on update cascade,
constraint `fk_funciones_sala` 
	foreign key(`sala`)
    references `MovieTime`.`Sala` (`idsala`)
    on update cascade
   /* constraint `fk_funciones_horario` 
	foreign key(`horario`)
    references `MovieTime`.`Horario` (`idHorario`)
    on update cascade*/
);

create table if not exists `MovieTime`.`VentaEntrada`(
`idEntrada` int not null auto_increment,
`usuario` int not null,
`Funciones` int not null,
`precio` int not null,
`cantEntradas` numeric not null,
`fecha` date not null,
`Asientos` varchar(4) not null,
`montoTotal` decimal not null,
	primary key(idEntrada),
Key `fk_ventaEntrada_usuario` using hash (`usuario`),
Key `fk_ventaEntrada_funcion` using hash(`Funciones`),
Key `fk_ventaEntrada_precio` using hash(`precio`),
constraint `fk_ventaEntrada_usuario`
	foreign key (`usuario`)
	references `MovieTime`.`Usuario` (`idUsuario`)
	on update cascade,
constraint `fk_ventaEntrada_Funciones`
	foreign key(`Funciones`)
    references `MovieTime`.`Funciones` (`idFuncion`)
    on update cascade,
constraint `fk_ventaEntrada_precio`
	foreign key(`precio`)
    references `MovieTime`.`Precio` (`idPrecio`)
    on update cascade

);







