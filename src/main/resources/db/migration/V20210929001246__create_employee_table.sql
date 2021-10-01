CREATE TABLE employee(
                         id INT AUTO_INCREMENT PRIMARY KEY,
                         name VARCHAR(255) NOT NULL,
                         age INT NOT NULL,
                         gender VARCHAR(10)
) engine=InnoDB DEFAULT CHARSET = utf8;

INSERT INTO employee (name,age,gender) VALUES ('小明',20,'男');
INSERT INTO employee (name,age,gender) VALUES ('小红',19,'女');
INSERT INTO employee (name,age,gender) VALUES ('小智',19,'男');
INSERT INTO employee (name,age,gender) VALUES ('小刚',19,'男');
INSERT INTO employee (name,age,gender) VALUES ('小夏',19,'女');
