CREATE DATABASE car;

USE car;
CREATE TABLE user(
    userID INT PRIMARY KEY AUTO_INCREMENT,
    fullName VARCHAR(255) NOT NULL,
    idCard VARCHAR(20) UNIQUE NOT NULL,
    email VARCHAR(255) UNIQUE NOT NULL,
    phone VARCHAR(20) NOT NULL,
    address VARCHAR(500),
    birthDate DATE,
    username VARCHAR(50) UNIQUE NOT NULL,
    password VARCHAR(50) NOT NULL,
    role VARCHAR(50) NOT NULL
);

CREATE TABLE Car (
    ID INT PRIMARY KEY AUTO_INCREMENT,
    licensePlate VARCHAR(20) UNIQUE NOT NULL,
    name VARCHAR(255) NOT NULL,
    model VARCHAR(100),
    brand VARCHAR(100),
    year INT CHECK (year >= 1900),
    description VARCHAR(500),
    status VARCHAR(50),
    dayRate FLOAT CHECK (dayRate >= 0),
    ownerType VARCHAR(20)
  
);
INSERT INTO Car (licensePlate, name, model, brand, year, description, status, dayRate, ownerType)
VALUES 
('30A-12345', 'Toyota Vios', 'G 1.5 AT', 'Toyota', 2019, 'Sedan tiết kiệm nhiên liệu, nội thất rộng', 'available', 500000, 'company'),
('51F-67890', 'Hyundai Accent', '1.4 AT', 'Hyundai', 2020, 'Xe chạy gia đình, sạch sẽ, máy êm', 'rented', 450000, 'user'),
('29C-45678', 'Ford Ranger', 'Wildtrak 2.0', 'Ford', 2021, 'Xe bán tải, mạnh mẽ, gầm cao', 'maintenance', 800000, 'company'),
('43A-11223', 'Kia Morning', '1.25 MT', 'Kia', 2018, 'Xe nhỏ, phù hợp chạy nội thành', 'available', 350000, 'user'),
('60A-99881', 'Mazda 3', 'Deluxe 1.5 AT', 'Mazda', 2021, 'Sedan hạng C, cảm giác lái tốt', 'available', 600000, 'company'),
('36B-23782', 'VinFast Lux A2.0', 'Plus', 'VinFast', 2020, 'Xe Việt, kiểu dáng sang trọng', 'rented', 700000, 'user'),
('29B-76854', 'Honda City', 'RS 1.5 CVT', 'Honda', 2022, 'Xe mới, tiết kiệm xăng, công nghệ hiện đại', 'available', 550000, 'company'),
('20A-11222', 'Mitsubishi Xpander', 'AT Premium', 'Mitsubishi', 2019, 'MPV 7 chỗ, phù hợp gia đình', 'rented', 650000, 'user'),
('72C-45677', 'Suzuki XL7', 'GLX 1.5 AT', 'Suzuki', 2021, 'Gầm cao, máy bền, nội thất rộng', 'available', 620000, 'company'),
('18A-66789', 'Toyota Fortuner', '2.4 G MT', 'Toyota', 2020, 'SUV 7 chỗ, chạy đường dài cực tốt', 'maintenance', 900000, 'company');

