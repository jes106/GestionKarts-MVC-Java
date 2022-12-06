DROP TABLE IF EXISTS `Reservations` ;
DROP TABLE IF EXISTS `Bono` ;
DROP TABLE IF EXISTS `Karts` ;
DROP TABLE IF EXISTS `Tracks` ;
DROP TABLE IF EXISTS `Users`;


CREATE TABLE `Users` (
    `Email` VARCHAR( 32 ) NOT NULL ,
    `Password` VARCHAR(32) NOT NULL,
    `Name` VARCHAR( 64 ) NOT NULL ,
    `BirthDay` DATETIME NOT NULL ,
    `InscriptionD` DATETIME NOT NULL ,
    `Rol` ENUM('Administrador', 'Cliente') NOT NULL ,
    PRIMARY KEY ( `Email` )
) TYPE = InnoDB ;

CREATE TABLE `Tracks`(
    `Name` VARCHAR( 32 ) NOT NULL,
    `State` BOOL NOT NULL ,
    `Difficulty` ENUM('infantil', 'familiar', 'adultos') NOT NULL ,
    `MaxKarts` INT( 3 ) NOT NULL,
    PRIMARY KEY ( `Name` )
) TYPE = InnoDB ;

CREATE TABLE `Bono` (
    `IdNumber` INT( 4 ) NOT NULL ,
    `SessionNumber` BOOL NOT NULL ,
    `DateCreated` DATETIME NOT NULL,
    `Type` ENUM('infantil', 'familiar', 'adultos') NOT NULL ,
    `Email` VARCHAR(32) NOT NULL ,
    PRIMARY KEY ( `IdNumber` ) ,
    FOREIGN KEY ( `Email` ) REFERENCES `Users` ( `Email` )
) TYPE = InnoDB ;

CREATE TABLE `Reservations` (
    `Id` INT( 3 ) NOT NULL,
    `Email` VARCHAR( 32 ) NOT NULL ,
    `Date` DATETIME NOT NULL ,
    `Lenght` INT( 3 ) NOT NULL ,
    `Price` FLOAT NOT NULL ,
    `Discount` FLOAT NOT NULL ,
    `Track` VARCHAR( 32 ) NOT NULL ,
    `Type` ENUM('infantil', 'familiar', 'adultos') NOT NULL ,
    `ChildremNumber` INT NULL ,
    `AdultsNumber` INT NULL ,
    `IdBono` INT NULL,
    PRIMARY KEY ( `Id` ) ,
    FOREIGN KEY ( `Email` ) REFERENCES `Users` ( `Email` ) ,
    FOREIGN KEY ( `Track` ) REFERENCES `Tracks` ( `Name` ) ,
    FOREIGN KEY ( `IdBono` ) REFERENCES `Bono` ( `IdNumber` )
) TYPE = InnoDB ;

CREATE TABLE `Karts` (
    `Id` INT( 3 ) NOT NULL ,
    `Child` BOOL NOT NULL ,
    `State` ENUM( 'Reservado', 'Disponible', 'Mantenimiento' ) NOT NULL ,
    `TrackName` VARCHAR( 32 ) NULL,
    PRIMARY KEY ( `Id` ) ,
    FOREIGN KEY ( `TrackName` ) REFERENCES `Tracks` ( `Name` )
) TYPE = InnoDB ;



INSERT INTO `Users` ( `Email` , `Password` , `Name` , `BirthDay` , `InscriptionD` , `Rol` ) VALUES ( 'i02dipea@uco.es', 'antonio', 'Antonio Diaz Perez', '2002-02-05 00:00:00', '2022-10-06 00:00:00' , 'Administrador' );
INSERT INTO `Users` ( `Email` , `Password` , `Name` , `BirthDay` , `InscriptionD` , `Rol` ) VALUES ( 'i02essej@uco.es', 'jesus', 'Jesus Escribano Serena', '2002-10-06 00:00:00', '2018-12-06 00:00:00', 'Administrador' );
INSERT INTO `Users` ( `Email` , `Password` , `Name` , `BirthDay` , `InscriptionD` , `Rol` ) VALUES ( 'f62trzaj@uco.es', 'juanjo', 'Juan Jose Trenado Zafra', '2002-10-06 00:00:00', '2018-12-06 00:00:00', 'Administrador' );
INSERT INTO `Users` ( `Email` , `Password` , `Name` , `BirthDay` , `InscriptionD` , `Rol` ) VALUES ( 'j.gonzalezru@gmail.com', 'jose', 'Jose González Ruíz', '2002-10-06 00:00:00', '2018-12-06 00:00:00', 'Cliente' );

INSERT INTO `Tracks` ( `Name` , `State` , `Difficulty` , `MaxKarts` ) VALUES ( 'Tokio', '1', 'infantil', '2' );
INSERT INTO `Tracks` ( `Name` , `State` , `Difficulty` , `MaxKarts` ) VALUES ( 'Brazil', '1', 'adultos', '4' );
INSERT INTO `Tracks` ( `Name` , `State` , `Difficulty` , `MaxKarts` ) VALUES ( 'Lisboa', '1', 'familiar', '5' );
INSERT INTO `Tracks` ( `Name` , `State` , `Difficulty` , `MaxKarts` ) VALUES ( 'Katar', '0', 'familiar', '6' );

INSERT INTO `Karts` ( `Id` , `Child` , `State` , `TrackName` ) VALUES ( '0', 'false', 'Mantenimiento', 'Brazil' );
INSERT INTO `Karts` ( `Id` , `Child` , `State` , `TrackName` ) VALUES ( '1', 'true', 'Disponible', 'Tokio' );
INSERT INTO `Karts` ( `Id` , `Child` , `State` , `TrackName` ) VALUES ( '2', 'true', 'Mantenimiento', 'Brazil' );
INSERT INTO `Karts` ( `Id` , `Child` , `State` , `TrackName` ) VALUES ( '3', 'false', 'Reservado', 'Lisboa' );
INSERT INTO `Karts` ( `Id` , `Child` , `State` , `TrackName` ) VALUES ( '4', 'true', 'Disponible', 'Lisboa' );
INSERT INTO `Karts` ( `Id` , `Child` , `State` , `TrackName` ) VALUES ( '5', 'true', 'Disponible', 'Tokio' );
INSERT INTO `Karts` ( `Id` , `Child` , `State` , `TrackName` ) VALUES ( '6', 'false', 'Disponible', 'Lisboa' );
INSERT INTO `Karts` ( `Id` , `Child` , `State` , `TrackName` ) VALUES ( '7', 'false', 'Disponible', 'Brazil' );
INSERT INTO `Karts` ( `Id` , `Child` , `State` , `TrackName` ) VALUES ( '8', 'true', 'Disponible', 'Brazil' );
INSERT INTO `Karts` ( `Id` , `Child` , `State` , `TrackName` ) VALUES ( '9', 'false', 'Reservado', 'Lisboa' );
INSERT INTO `Karts` ( `Id` , `Child` , `State` , `TrackName` ) VALUES ( '10', 'false', 'Disponible', 'Lisboa' );
