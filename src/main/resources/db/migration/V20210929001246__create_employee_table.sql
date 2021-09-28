CREATE TABLE employee(
                         id INT PRIMARY KEY,
                         name VARCHAR(255) NOT NULL,
                         age INT NOT NULL,
                         gender VARCHAR(10)
) engine=InnoDB DEFAULT CHARSET = utf8;

INSERT INTO employee (id,name,age,gender) VALUES ( 0, '小明',20,'男');
INSERT INTO employee (id,name,age,gender) VALUES ( 1, '小红',19,'女');
INSERT INTO employee (id,name,age,gender) VALUES ( 2, '小智',19,'男');
INSERT INTO employee (id,name,age,gender) VALUES ( 3, '小刚',19,'男');
INSERT INTO employee (id,name,age,gender) VALUES ( 4, '小夏',19,'女');
