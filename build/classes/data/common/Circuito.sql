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



INSERT INTO `Users` ( `Email` , `Password` , `Name` , `BirthDay` , `InscriptionD` , `Rol` ) 
VALUES 
  ( 'i02dipea@uco.es', 'antonio', 'Antonio Diaz Perez', '2002-02-05 00:00:00', '2022-10-06 00:00:00' , 'Administrador' ),
  ( 'i02essej@uco.es', 'jesus', 'Jesus Escribano Serena', '2002-10-06 00:00:00', '2018-12-06 00:00:00', 'Administrador' ),
  ( 'f62trzaj@uco.es', 'juanjo', 'Juan Jose Trenado Zafra', '2002-10-06 00:00:00', '2018-12-06 00:00:00', 'Administrador' ),
  ( 'j.gonzalezru@gmail.com', 'jose', 'Jose González Ruíz', '2002-10-06 00:00:00', '2018-12-06 00:00:00', 'Cliente' ),
  ('purus.in.molestie@yahoo.org','QSQ78BKO2WZ','Driscoll Duran','1976-10-13 21:59:02','2023-01-31 07:43:17','Cliente'),
  ('scelerisque.neque@outlook.net','LHO98QWD8UK','Susan Buckner','2000-01-19 14:23:08','2023-11-06 16:39:48','Cliente'),
  ('donec.tempus.lorem@aol.com','CGC16CBY3WH','Caleb Wilkerson','2001-02-11 11:36:07','2023-07-06 21:04:21','Cliente'),
  ('cras@yahoo.edu','CVR69RNF8XM','Erich Klein','1978-08-26 04:55:34','2022-12-13 17:58:33','Cliente'),
  ('quis@yahoo.ca','LLK31NQF2EI','Brenda Sawyer','1976-05-28 15:58:43','2022-07-29 16:45:38','Cliente'),
  ('dolor.vitae@protonmail.org','KPP24BXX5EH','Myles Bolton','1995-08-04 01:45:15','2023-08-22 21:37:48','Cliente'),
  ('nunc.commodo@aol.org','GCU65OYH0KM','Olympia Barry','1985-11-26 12:30:05','2022-08-26 02:51:27','Cliente'),
  ('lectus@google.com','IWX87TOB2DO','Jarrod Roman','2000-11-30 19:03:41','2022-04-11 22:31:39','Cliente'),
  ('nulla.cras.eu@outlook.com','SBD39UEU3PX','Gavin Freeman','1992-02-25 12:22:33','2023-04-08 01:30:02','Cliente'),
  ('ipsum@yahoo.com','DIU59RCR5JM','Deanna Colon','2001-05-26 10:18:48','2023-11-01 21:13:09','Cliente'),
  ('sed.turpis@google.edu','PQC77OWF8PR','Carly Avery','1986-09-18 02:41:57','2022-04-03 20:57:48','Cliente'),
  ('ultricies@google.org','DTV61EWH5EB','Amery Medina','1972-01-21 06:56:18','2023-09-13 12:06:31','Cliente'),
  ('vivamus.molestie.dapibus@yahoo.org','SJJ70BIF5YY','Karly Wells','1971-02-24 06:31:35','2023-12-07 18:56:08','Cliente'),
  ('gravida.praesent@google.couk','TUI37YHH1ID','Anthony Rocha','1984-02-16 10:13:44','2021-12-19 13:09:43','Cliente'),
  ('augue.scelerisque@protonmail.edu','XHI78PVX4XC','Bree Grimes','1975-04-24 16:03:28','2023-08-12 13:58:03','Cliente'),
  ('mattis.cras@icloud.edu','ETJ41GFG5QY','Hayfa Mathews','1992-02-09 10:05:43','2022-12-12 16:18:57','Cliente'),
  ('mattis.integer@google.edu','OXY97JCV3BB','Maggie Brennan','1988-06-17 00:36:55','2022-10-30 23:18:30','Cliente'),
  ('ac.orci@hotmail.edu','VYF24UCW8MY','Noble Hoffman','1998-08-25 04:42:42','2023-03-16 23:16:08','Cliente'),
  ('tincidunt.nunc@google.couk','HPS41QXY7HL','Cally Eaton','2003-01-30 23:24:13','2022-11-01 12:18:15','Cliente'),
  ('amet.diam@protonmail.net','TAG66UTO5KR','Ira Watson','1989-06-20 12:55:29','2021-12-14 20:13:35','Cliente');
  


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
