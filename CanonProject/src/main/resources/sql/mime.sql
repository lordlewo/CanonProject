CREATE TABLE `mime` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `name` varchar(100) ,
  `mime_type` varchar(100) NOT NULL,
  `suffix` varchar(10) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO mime(name,mime_type,suffix) VALUES('JPEG (Joint Photographic Experts Group)','image/jpeg','.jpg');
INSERT INTO mime(name,mime_type,suffix) VALUES('PNG (Portable Network Graphics)','image/png','.png');