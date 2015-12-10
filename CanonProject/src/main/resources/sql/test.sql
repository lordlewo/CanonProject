create table `test`(
	`id` int not null auto_increment,
    `name` varchar(30) not null,
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO test(name) VALUES('sample');
INSERT INTO test(name) VALUES('name');
INSERT INTO test(name) VALUES('test');
INSERT INTO test(name) VALUES('temp');
INSERT INTO test(name) VALUES('yolo');