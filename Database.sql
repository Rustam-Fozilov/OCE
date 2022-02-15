CREATE DATABASE oce;
USE oce;


SELECT * FROM admins;
SELECT * FROM followers;
SELECT * FROM users;
SELECT * FROM courses;


CREATE TABLE users(
	UserId INT NOT NULL auto_increment,
    Ismi varchar(50),
    Familiyasi varchar(50),
    Telefon varchar(50),
    Email varchar(50),
    Parol varchar(50),
    Statusi varchar(50),
    primary key(user_id)
);


CREATE TABLE admins(
    AdminId INT NOT NULL AUTO_INCREMENT,
    Ismi VARCHAR(50),
    Familiyasi VARCHAR(50),
    Login VARCHAR(50),
    Parol VARCHAR(50),
    PRIMARY KEY (AdminId)
);


CREATE TABLE courses(
    CourseId INT NOT NULL AUTO_INCREMENT,
    Nomi VARCHAR(50),
    Narxi INT,
    Davomiyligi VARCHAR(50),
    Oqituvchi VARCHAR(50),
    PRIMARY KEY (CourseId)
);


CREATE TABLE followers(
    FollowersId INT NOT NULL AUTO_INCREMENT,
    user_id INT,
    kurs_id INT,
    tarif VARCHAR(50),
    PRIMARY KEY (FollowersId),
    FOREIGN KEY (user_id) REFERENCES users (UserId),
    FOREIGN KEY (kurs_id) REFERENCES courses (CourseId)
);


INSERT INTO users(Ismi, Familiyasi, Telefon, Email, Parol, Statusi)
VALUE
        ('Mirahmad', 'Qobulov', '+998996069834', 'mirahmadqobulov@gmail.com', 'Mirahmad22', 'Student'),
        ('Bilol', 'Yolchixojayev', '+998934454050', 'bilolyolchixojayev@gmail.com', 'Bilol21', 'Student'),
        ('Eldor', 'Sharipov', '+998991235476', 'eldorsharipov@gmail.com', 'Eldor21', 'Student'),
        ('Doniyor', 'Hayitov', '+998949884377', 'doniyorhayitov@gmail.com', 'Doniyor19', 'Student'),
        ('Nodir', 'Azimov', '+998998899060', 'nodirazimov@gmail.com', 'Nodir18', 'Student'),
        ('Qodir', 'Shokirov', '+998943343204', 'qodirshokirov@gmail.com', 'Qodir19', 'Student'),
        ('Abbos', 'Umarov', '+998991123498', 'abbosumarov@gmail.com', 'Abbos22', 'Student'),
        ('Sarvar', 'Anvarov', '+998934452131', 'sarvaranvarov@gmail.com', 'Sarvar20', 'Student'),
        ('Asqar', 'Tohirov', '+998930052002', 'asqartohirov@gmail.com', 'Asqar23', 'Student'),
        ('Dilshod', 'Toirov', '+998936602070', 'dilshodtoirov@gmail.com', 'Dilshod19', 'Student'),
        ('Aziza', 'Karimova', '+998947565634', 'azizakarimova@gmail.com', 'Aziza18', 'Student'),
        ('Gulnora', 'Sobitova', '+998940997788', 'gulnorasobitova@gmail.com', 'Gulnora24', 'Student'),
        ('Jamshid', 'Ilhomov', '+998997752165', 'jamshidilhomov@gmail.com', 'Jamshid20', 'Student'),
        ('Manzura', 'Jasurova', '+998939027489', 'manzurajasurova@gmail.com', 'Manzura17', 'Student'),
        ('Xurshid', 'Ergashev', '+998999028365', 'xurshidergashev@gmail.com', 'Xurshid26', 'Student'),
        ('Aziz', 'Isoqov', '+998953219073', 'azizisoqov@gmail.com', 'Aziz22', 'Student'),
        ('Mahmud', 'Valiyev', '+998939842037', 'mahmudvaliyev@gmail.com', 'Mahmud26', 'Student'),
        ('Ismoil', 'Akbarov', '+998977170287', 'ismoilakbarov@gmail.com', 'Ismoil04', 'Student');


INSERT INTO admins(Ismi, Familiyasi, login, parol)
VALUES ('Rustam', 'Fozilov', 'RustamAdmin', 'Rustam19'),
       ('Mohir', 'Mahmudov', 'MohirAdmin', 'Mohir19');


INSERT INTO courses (Nomi, Narxi, Davomiyligi, Oqituvchi)
VALUES ('Java dasturlash', 6000000, '12 oy', 'Jamshid Valiyev'),
       ('Python dasturlash', 6000000, '12 oy', 'Xurshid Vahobov'),
       ('Data science', 9500000, '24 oy', 'Ilhom Madaminov'),
       ('Machine Learning', 15000000, '12 oy', 'Tolib Murodov'),
       ('Kiberxavfsizlik', 7500000, '24 oy', 'Olim Qilichov'),
       ('Android dasturlash', 5000000, '9 oy', 'Said Ahmadov'),
       ('IOS dasturlash', 5000000, '8 oy', 'Bahodir Umarov'),
       ('Frontend dasturlash', 4800000, '6 oy', 'Ahror Qurbonov'),
       ('Flutter dasturlash', 4500000, '6 oy', 'Mahmud Sultonov'),
       ('Internet marketolog', 9200000, '24 oy', 'Nigora Rahimova'),
       ('Kopirayting', 600000, '2 oy', 'Mohira Komilova'),
       ('PR menejer', 5600000, '6 oy', 'Ziyodulla Gafurov'),
       ('Moushin dizayn', 8500000, '13 oy', 'Dilshod Damirhonov'),
       ('Fullstack dasturchi', 8300000, '12 oy', 'Farrux Diyorov'),
       ('Photoshop', 300000, '2 oy', 'Sherzod Omonov'),
       ('Matematik analiz', 3000000, '3 oy', 'Anvar Nazarov'),
       ('3D animator', 8700000, '12 oy', 'Temur Asadov'),
       ('Tarmoq adminstratori', 7000000, '15 oy', 'Mamur Hakimov'),
       ('C++ dasturlash', 5500000, '6 oy', 'Samandar Hamroyev'),
       ('Mobil dasturlash', 14000000, '24 oy', 'Obid Asrorov');
       
       
       
       