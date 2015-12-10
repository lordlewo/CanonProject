CREATE TABLE `metadata` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `height` int,
  `width` int,
  `x_resolution` int,
  `y_resolution` int,
  `make` varchar(100),
  `model` varchar(100),
  `create_date` datetime,
  `flash` varchar(100),
  `orientation` varchar(100),
  `latitude` int,
  `longitude` int,
  `dominant_color` varchar(100),
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO metadata(height,width,x_resolution,y_resolution,make,model,create_date,flash,orientation,latitude,longitude,dominant_color) VALUES(123,123,12,12,'cucc1','cucc2',now(),'cucc3','cucc4',23,23,'color1');
INSERT INTO metadata(height,width,x_resolution,y_resolution,make,model,create_date,flash,orientation,latitude,longitude,dominant_color) VALUES(223,223,22,22,'cucc5','cucc6',now(),'cucc7','cucc8',34,34,'color2');
INSERT INTO metadata(height,width,x_resolution,y_resolution,make,model,create_date,flash,orientation,latitude,longitude,dominant_color) VALUES(323,323,32,32,'cucc9','cucc10',now(),'cucc11','cucc12',45,45,'color3');
INSERT INTO metadata(height,width,x_resolution,y_resolution,make,model,create_date,flash,orientation,latitude,longitude,dominant_color) VALUES(423,423,42,42,'cucc13','cucc14',now(),'cucc15','cucc16',56,56,'color4');
