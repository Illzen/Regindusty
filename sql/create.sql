USE regindusty;

ALTER TABLE regional_specialties DROP CONSTRAINT rs_adcode;
ALTER TABLE regional_specialties DROP CONSTRAINT rs_specialty;
DROP TABLE IF EXISTS regional_specialties;

DROP TABLE IF EXISTS specialty;

DROP TABLE IF EXISTS districts;

DROP DATABASE IF EXISTS regindusty;

CREATE DATABASE regindusty;
USE regindusty

CREATE TABLE districts (
	adcode INT AUTO_INCREMENT,
	name VARCHAR(20),
	PRIMARY KEY(adcode)
);

CREATE TABLE specialty (
	id INT,
	name VARCHAR(20),
	description TEXT,
	PRIMARY KEY(id)
);

CREATE TABLE regional_specialties (
	adcode INT,
	s_id INT,
	CONSTRAINT rs_adcode FOREIGN KEY (adcode) REFERENCES districts (adcode) ON UPDATE CASCADE,
	CONSTRAINT rs_specialty FOREIGN KEY (s_id) REFERENCES specialty (id) ON UPDATE CASCADE,
	PRIMARY KEY(adcode, s_id)
)