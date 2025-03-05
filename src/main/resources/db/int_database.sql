create database market_place;
use market_place;
create table market(
                       MaMatBang VARCHAR(10) PRIMARY KEY,
                       TenMatBang VARCHAR(50),
                       DiaChi VARCHAR(255),
                       DienTich INT,
                       LoaiMatBang VARCHAR(50),
                       GiaThue INT,
                       NgayBatDauChoThue DATE


);
INSERT INTO market (MaMatBang, TenMatBang, DiaChi, DienTich, LoaiMatBang, GiaThue, NgayBatDauChoThue)
VALUES
    ('MB001', 'Văn phòng 1', '123 Đường ABC, Đà Nẵng', 80, 'Văn phòng', 2500000, '2023-10-01'),
    ('MB002', 'Cửa hàng A', '456 Đường XYZ, Đà Nẵng', 100, 'Cửa hàng', 4000000, '2023-10-15'),
    ('MB003', 'Nhà ở 1', '789 Đường DEF, Đà Nẵng', 120, 'Nhà ở', 5500000, '2023-01-20'),
    ('MB004', 'Văn phòng 2', '101 Đường GHI, Đà Nẵng', 60, 'Văn phòng', 2200000, '2023-05-11'),
    ('MB005', 'Cửa hàng B', '202 Đường KLM, Đà Nẵng', 90, 'Cửa hàng', 3800000, '2023-11-10');

select * from market

