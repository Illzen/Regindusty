DROP DATABASE IF EXISTS regindusty;

CREATE DATABASE regindusty;

USE regindusty;

DROP TABLE IF EXISTS regional_specialties;

DROP TABLE IF EXISTS specialty;

DROP TABLE IF EXISTS districts;

CREATE TABLE districts (
	adcode INT,
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
	FOREIGN KEY (adcode) REFERENCES districts (adcode),
	FOREIGN KEY (s_id) REFERENCES specialty (id),
	PRIMARY KEY(adcode, s_id)
)