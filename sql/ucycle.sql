drop database ucycle;
create database if not exists ucycle;
use ucycle;


/*顧客情報入力（新規登録・customer_typeは１．月額会員２．一般会員３．SNS会員）(snsでログインした場合snsを入力してもらう)*/
create table if not exists customer(
customer_type int (1) not  null,
customer_id int(6) primary key auto_increment,
familyname varchar(20) not null,
givenname varchar(20) not null,
password varchar(8),
phone  varchar(12),
mailaddress varchar (40) unique,
postcode int (7),
address varchar(20),
housenumber varchar (50),
credit_name varchar (40),
credit_number  bigint(16),
expiredate int(6),
security_code int(4)
);


/*駐輪場情報*/
create table if not exists port(
port_id int(2) primary key auto_increment,
port_name varchar(20)unique not null,
port_address varchar(50) not null
);


/*自転車情報（statusの値で在庫の有無を確認  1,無2,有）*/
create table if not exists cycle(
cycle_id int(6) unique not null,
port_id int(2)  not null,
port_name varchar(20) not null,
due_date int(6),
status int(1),
foreign key(port_id) references port(port_id),
foreign key(port_name) references port(port_name)
);


/*利用履歴情報*/
create table if not exists reservation_info(
customer_id int(6) not null,
port_name varchar(20) not null,
cycle_id int(6) not null,
plan int(1) not null,
reservation_date varchar(10) ,
foreign key(customer_id) references customer(customer_id),
foreign key(port_name) references port(port_name),
foreign key(cycle_id) references cycle(cycle_id)
);


/*管理者情報*/
create table if not exists admin(
admin_id int(8) not null,
admin_password varchar(30) not null,
port_id int(2),
foreign key(port_id) references port(port_id)
);




/*月極顧客情報（実例）*/
insert into customer(customer_type,customer_id,familyname,givenname,password,phone,mailaddress,postcode,address,housenumber,credit_name,credit_number,expiredate,security_code
)values(
"1","1","三戸","康太郎","1111","0901234567","aaa@co.jp","4211212","静岡市葵区千代","2-2-2","mito","5555555555554444","160101","222"
);
insert into customer(customer_type,customer_id,familyname,givenname,password,phone,mailaddress,postcode,address,housenumber,credit_name,credit_number,expiredate,security_code
)values(
"2","2","名無しの","権兵衛","1111","0901234567","bbb@co.jp","4211212","静岡市葵区千代","2-2-3","nanasi","5105105105105100","160101","223"
);
insert into customer(customer_type,customer_id,familyname,givenname,password,phone,mailaddress,postcode,address,housenumber,credit_name,credit_number,expiredate,security_code
)values(
"3","3","山田","太郎","1111","0901234567","ccc@co.jp","4211212","静岡市葵区千代","2-2-2","yamada","4111111111111111","160101","222"
);
insert into customer(customer_type,customer_id,familyname,givenname,password,phone,mailaddress,postcode,address,housenumber,credit_name,credit_number,expiredate,security_code
)values(
"1","4","山田","次太郎","1111","0901234567","ddd@co.jp","4211212","静岡市葵区千代","2-2-2","yamada","4012888888881881","160101","222"
);
insert into customer(customer_type,customer_id,familyname,givenname,password,phone,mailaddress,postcode,address,housenumber,credit_name,credit_number,expiredate,security_code
)values(
"2","5","山田","三郎","1111","0901234567","eee@co.jp","4211212","静岡市葵区千代","2-2-2","yamada","3530111333300000","160101","222"
);
insert into customer(customer_type,customer_id,familyname,givenname,password,phone,mailaddress,postcode,address,housenumber,credit_name,credit_number,expiredate,security_code
)values(
"3","6","山田","四郎","1111","0901234567","fff@co.jp","4211212","静岡市葵区千代","2-2-2","yamada","3566002020360505","160101","222"
);
insert into customer(customer_type,customer_id,familyname,givenname,password,phone,mailaddress,postcode,address,housenumber,credit_name,credit_number,expiredate,security_code
)values(
"1","7","山田","五郎","1111","0901234567","ggg@co.jp","4211212","静岡市葵区千代","2-2-2","yamada","371449635398431","160101","2222"
);






/*駐輪場情報（実例）*/
insert into port(port_id,port_name,port_address
)values(
"1","有楽町駅前店","東京都千代田区丸の内3-6-11船ー店"
);
insert into port(port_id,port_name,port_address
)values(
"2","日本橋兜町店","東京都中央区日本橋兜町8-11"
);
insert into port(port_id,port_name,port_address
)values(
"3","田町センタービル店","東京都港区芝浦5-34-7田町センタービル"
);
insert into port(port_id,port_name,port_address
)values(
"4","西新宿1丁目店（本店）","東京都新宿区1-13-8朝日新宿ビル"
);
insert into port(port_id,port_name,port_address
)values(
"5","本郷三丁目店","東京都文京区本郷2-40-18"
);
insert into port(port_id,port_name,port_address
)values(
"6","御徒町南口店","東京都台東区上野5-20-6"
);
insert into port(port_id,port_name,port_address
)values(
"7","両国東口店","東京都墨田区両国3-26-5"
);
insert into port(port_id,port_name,port_address
)values(
"8","東陽町店","東京都江東区東陽4-5-18 メトロハイツ東陽"
);


/*自転車情報*/
insert into cycle(cycle_id,port_id,port_name,due_date,status
)values("1","1","有楽町駅前店","150608","1"
);
insert into cycle(cycle_id,port_id,port_name,due_date,status
)values("2","1","有楽町駅前店","150608","2"
);
insert into cycle(cycle_id,port_id,port_name,due_date,status
)values("3","2","日本橋兜町店","150623","1"
);
insert into cycle(cycle_id,port_id,port_name,due_date,status
)values("4","2","日本橋兜町店","150612","2"
);
insert into cycle(cycle_id,port_id,port_name,due_date,status
)values("5","3","田町センタービル店","150610","1"
);
insert into cycle(cycle_id,port_id,port_name,due_date,status
)values("6","3","田町センタービル店","150622","2"
);
insert into cycle(cycle_id,port_id,port_name,due_date,status
)values("7","4","西新宿1丁目店（本店）","150622","1"
);
insert into cycle(cycle_id,port_id,port_name,due_date,status
)values("8","4","西新宿1丁目店（本店）","150622","2"
);
insert into cycle(cycle_id,port_id,port_name,due_date,status
)values("9","5","本郷三丁目店","150622","1"
);
insert into cycle(cycle_id,port_id,port_name,due_date,status
)values("10","5","本郷三丁目店","150622","2"
);
insert into cycle(cycle_id,port_id,port_name,due_date,status
)values("11","6","御徒町南口店","150622","1"
);
insert into cycle(cycle_id,port_id,port_name,due_date,status
)values("12","6","御徒町南口店","150622","2"
);
insert into cycle(cycle_id,port_id,port_name,due_date,status
)values("13","7","両国東口店","150622","1"
);
insert into cycle(cycle_id,port_id,port_name,due_date,status
)values("14","7","両国東口店","150622","2"
);
insert into cycle(cycle_id,port_id,port_name,due_date,status
)values("15","8","東陽町店","150622","1"
);
insert into cycle(cycle_id,port_id,port_name,due_date,status
)values("16","8","東陽町店","150622","2"
);


/*利用履歴情報*/
insert into reservation_info(customer_id,port_name,cycle_id,plan,reservation_date
)values("2","有楽町駅前店","1","1","20150601"
);
/*利用履歴情報 @author Kaito*/
INSERT INTO reservation_info VALUES(2, '有楽町駅前店', 1, 2, '20150601');
INSERT INTO reservation_info VALUES(2, '日本橋兜町店', 1, 1, '20150601');
INSERT INTO reservation_info VALUES(1, '日本橋兜町店', 2, 2, '20150601');
INSERT INTO reservation_info VALUES(2, '田町センタービル店', 1, 1, '20150601');
INSERT INTO reservation_info VALUES(2, '田町センタービル店', 2, 2, '20150601');
INSERT INTO reservation_info VALUES(2, '西新宿1丁目店（本店）', 1, 1, '20150601');
INSERT INTO reservation_info VALUES(2, '西新宿1丁目店（本店）', 2, 2, '20150601');
INSERT INTO reservation_info VALUES(2, '本郷三丁目店', 1, 1, '20150601');
INSERT INTO reservation_info VALUES(2, '本郷三丁目店', 2, 2, '20150601');
INSERT INTO reservation_info VALUES(2, '御徒町南口店', 1, 1, '20150601');
INSERT INTO reservation_info VALUES(2, '御徒町南口店', 2, 1, '20150601');
INSERT INTO reservation_info VALUES(2, '両国東口店', 1, 1, '20150601');
INSERT INTO reservation_info VALUES(1, '両国東口店', 2, 2, '20150601');
INSERT INTO reservation_info VALUES(2, '東陽町店', 1, 1, '20150601');
INSERT INTO reservation_info VALUES(2, '東陽町店', 2, 2, '20150601');
/*/Kaito*/



/*管理者情報*/
insert into admin(admin_id,admin_password,port_id
)values("1072","kaito","1"
);
insert into admin(admin_id,admin_password,port_id
)values("2072","kaito","2"
);
insert into admin(admin_id,admin_password,port_id
)values("3072","kaito","3"
);
insert into admin(admin_id,admin_password,port_id
)values("4072","kaito","4"
);
insert into admin(admin_id,admin_password,port_id
)values("5072","kaito","5"
);
insert into admin(admin_id,admin_password,port_id
)values("6072","kaito","6"
);
insert into admin(admin_id,admin_password,port_id
)values("7072","kaito","7"
);
insert into admin(admin_id,admin_password,port_id
)values("8072","kaito","8"
);
