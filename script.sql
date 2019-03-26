CREATE DATABASE horse_racing;
USE horse_racing;
CREATE TABLE Users(
    Login VARCHAR(30) NOT NULL PRIMARY KEY,
    Password VARCHAR(30) NOT NULL,
    Name VARCHAR(30) NOT NULL,
    Balance DOUBLE,
    RegistrationDate DATE NOT NULL,
    Access ENUM("ADMIN" , "BOOKMAKER" , "USER") NOT NULL
    );
CREATE TABLE Horses(
	HorseID INT UNSIGNED NOT NULL PRIMARY KEY,
    Name VARCHAR(30) NOT NULL,
    Breed ENUM("ARABIAN" , "AKHAL_TEKE" , "SIGLAVI" , "HADBAN")
	);
CREATE TABLE Riders(
	RiderID INT UNSIGNED NOT NULL PRIMARY KEY,
    Name VARCHAR(30) NOT NULL,
    HorseID INT UNSIGNED NOT NULL
	);
CREATE TABLE Ivents(
	IventID INT UNSIGNED NOT NULL PRIMARY KEY,
    Name VARCHAR(30) NOT NULL,
    Date DATE NOT NULL,
    Time TIME NOT NULL,
	Rider1ID INT UNSIGNED NOT NULL,
    Rider2ID INT UNSIGNED NOT NULL,
    Rider3ID INT UNSIGNED NOT NULL,
    Rider4ID INT UNSIGNED NOT NULL,
    Rider1_Place1_Coefficient DOUBLE,
    Rider1_Place2_Coefficient DOUBLE,
    Rider1_Place3_Coefficient DOUBLE,
    Rider1_Place4_Coefficient DOUBLE,
    Rider2_Place1_Coefficient DOUBLE,
    Rider2_Place2_Coefficient DOUBLE,
    Rider2_Place3_Coefficient DOUBLE,
    Rider2_Place4_Coefficient DOUBLE,
    Rider3_Place1_Coefficient DOUBLE,
    Rider3_Place2_Coefficient DOUBLE,
    Rider3_Place3_Coefficient DOUBLE,
    Rider3_Place4_Coefficient DOUBLE,
    Rider4_Place1_Coefficient DOUBLE,
    Rider4_Place2_Coefficient DOUBLE,
    Rider4_Place3_Coefficient DOUBLE,
    Rider4_Place4_Coefficient DOUBLE,
    Rider1Position ENUM("1" , "2" , "3" , "4"),
    Rider2Position ENUM("1" , "2" , "3" , "4"),
    Rider3Position ENUM("1" , "2" , "3" , "4"),
    Rider4Position ENUM("1" , "2" , "3" , "4")
	);
CREATE TABLE Bets(
	BetID INT UNSIGNED NOT NULL PRIMARY KEY,
    UserLogin VARCHAR(30) NOT NULL,
    Coefficient DOUBLE NOT NULL,
    Money DOUBLE NOT NULL,
    Date DATE NOT NULL,
    Time TIME NOT NULL,
    BetType ENUM("FIRST_RIDER_1_PLACE" , "FIRST_RIDER_2_PLACE" , "FIRST_RIDER_3_PLACE" , "FIRST_RIDER_4_PLACE" ,
    "SECOND_RIDER_1_PLACE" , "SECOND_RIDER_2_PLACE" , "SECOND_RIDER_3_PLACE" , "SECOND_RIDER_4_PLACE" ,
    "THIRD_RIDER_1_PLACE" , "THIRD_RIDER_2_PLACE" , "THIRD_RIDER_3_PLACE" , "THIRD_RIDER_4_PLACE" ,
    "FOURTH_RIDER_1_PLACE" , "FOURTH_RIDER_2_PLACE" , "FOURTH_RIDER_3_PLACE" , "FOURTH_RIDER_4_PLACE"),
    BetStatus ENUM("WIN" , "LOSS" , "NOTPLAYED"),
    IventID INT UNSIGNED NOT NULL
    );

INSERT INTO Users(Login , Password , Name , Balance , RegistrationDate , Access) VALUES("admin", "bce7fc7bf5208d4" , "Sasha" , 999999 , "1970-01-01" , "ADMIN");
INSERT INTO Users(Login , Password , Name , Balance , RegistrationDate , Access) VALUES("bookmaker" , "d4d8f47dfc1435" , "Sasha" , 10 , "1970-01-01" , "BOOKMAKER");
INSERT INTO Users(Login , Password , Name , Balance , RegistrationDate , Access) VALUES("user" , "735d32715fcad394" , "Sasha" , "10" , "1970-01-01" , "USER");

INSERT INTO Horses(HorseID , Name , Breed) VALUES(122, "Jasmin" , "ARABIAN");
INSERT INTO Horses(HorseID , Name , Breed) VALUES(346, "Remi" , "SIGLAVI");
INSERT INTO Horses(HorseID , Name , Breed) VALUES(722, "Treysi" , "HADBAN");
INSERT INTO Horses(HorseID , Name , Breed) VALUES(75, "Hora" , "AKHAL_TEKE");
INSERT INTO Horses(HorseID , Name , Breed) VALUES(6, "Lokhard" , "SIGLAVI");
INSERT INTO Horses(HorseID , Name , Breed) VALUES(165, "Laguna" , "HADBAN");
INSERT INTO Horses(HorseID , Name , Breed) VALUES(10, "Rassel" , "ARABIAN");
INSERT INTO Horses(HorseID , Name , Breed) VALUES(879, "Karas" , "AKHAL_TEKE");
INSERT INTO Horses(HorseID , Name , Breed) VALUES(7, "Napoleon" , "ARABIAN");
INSERT INTO Horses(HorseID , Name , Breed) VALUES(13, "Rudy" , "ARABIAN");

INSERT INTO Riders(RiderID , Name , HorseID) VALUES(76 , "Alexander" , 122);
INSERT INTO Riders(RiderID , Name , HorseID) VALUES(45 , "Gregor" , 346);
INSERT INTO Riders(RiderID , Name , HorseID) VALUES(657 , "Conor" , 722);
INSERT INTO Riders(RiderID , Name , HorseID) VALUES(454 , "Elizabhet" , 75);
INSERT INTO Riders(RiderID , Name , HorseID) VALUES(23 , "Ron" , 13);
INSERT INTO Riders(RiderID , Name , HorseID) VALUES(345 , "Jackson" , 6);
INSERT INTO Riders(RiderID , Name , HorseID) VALUES(78 , "Walker" , 165);
INSERT INTO Riders(RiderID , Name , HorseID) VALUES(768 , "James" , 10);
INSERT INTO Riders(RiderID , Name , HorseID) VALUES(936 , "Morris" , 879);
INSERT INTO Riders(RiderID , Name , HorseID) VALUES(3 , "Brock" , 7);

INSERT INTO Ivents(IventID , Name , Date , Time , Rider1ID , Rider2ID , Rider3ID , Rider4ID , Rider1_Place1_Coefficient ,
    Rider1_Place2_Coefficient , Rider1_Place3_Coefficient , Rider1_Place4_Coefficient , Rider2_Place1_Coefficient , Rider2_Place2_Coefficient ,
	Rider2_Place3_Coefficient , Rider2_Place4_Coefficient , Rider3_Place1_Coefficient , Rider3_Place2_Coefficient , Rider3_Place3_Coefficient ,
	Rider3_Place4_Coefficient , Rider4_Place1_Coefficient , Rider4_Place2_Coefficient , Rider4_Place3_Coefficient , Rider4_Place4_Coefficient)
    VALUES(345 , "Football" , "2019-02-8" , "14:20:33" , 76 , 45 , 657 , 454 , 1.2 , 1.4 , 1.3 , 1.9 , 4.3 , 1.2 , 7.6 , 1.2 , 1.2 , 1.4 , 1.3 , 1.9 , 4.3 , 1.2 , 7.6 , 1.2 );

INSERT INTO Ivents(IventID , Name , Date , Time , Rider1ID , Rider2ID , Rider3ID , Rider4ID , Rider1_Place1_Coefficient ,
    Rider1_Place2_Coefficient , Rider1_Place3_Coefficient , Rider1_Place4_Coefficient , Rider2_Place1_Coefficient , Rider2_Place2_Coefficient ,
	Rider2_Place3_Coefficient , Rider2_Place4_Coefficient , Rider3_Place1_Coefficient , Rider3_Place2_Coefficient , Rider3_Place3_Coefficient ,
	Rider3_Place4_Coefficient , Rider4_Place1_Coefficient , Rider4_Place2_Coefficient , Rider4_Place3_Coefficient , Rider4_Place4_Coefficient)
    VALUES(12 , "Hockey" , "2019-03-24" , "14:19:49" , 3 , 936 , 345 , 23 , 1.2 , 1.4 , 1.3 , 1.9 , 4.3 , 1.2 , 7.6 , 1.2 , 1.2 , 1.4 , 1.3 , 1.9 , 4.3 , 1.2 , 7.6 , 1.2 );