CREATE TABLE districts { adcode INT,
name VARCHAR(20),
PRIMARY KEY(adcode) };

CREATE TABLE specialty { id INT,
name VARCHAR(20),
PRIMARY KEY(id) };

CREATE TABLE regional_specialties { adcode INT,
s_id INT,
FOREIGN KEY (adcode) REFERENCES districts (adcode),
FOREIGN KEY (s_id) REFERENCES specialty (id),
PRIMARY KEY(d_id, s_id) }