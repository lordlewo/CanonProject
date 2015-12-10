CREATE TABLE `album_mappings` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `image_id` bigint NOT NULL,
  `album_id` bigint NOT NULL,
  PRIMARY KEY (`id`),
  FOREIGN KEY (image_id) REFERENCES image(id),
  FOREIGN KEY (album_id) REFERENCES album(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO album_mappings(image_id,album_id) VALUES(1,1);
INSERT INTO album_mappings(image_id,album_id) VALUES(2,1);
INSERT INTO album_mappings(image_id,album_id) VALUES(3,1);
INSERT INTO album_mappings(image_id,album_id) VALUES(4,1);
INSERT INTO album_mappings(image_id,album_id) VALUES(5,1);
INSERT INTO album_mappings(image_id,album_id) VALUES(6,1);
INSERT INTO album_mappings(image_id,album_id) VALUES(7,1);
INSERT INTO album_mappings(image_id,album_id) VALUES(8,1);
INSERT INTO album_mappings(image_id,album_id) VALUES(9,1);
INSERT INTO album_mappings(image_id,album_id) VALUES(10,1);
INSERT INTO album_mappings(image_id,album_id) VALUES(11,1);
INSERT INTO album_mappings(image_id,album_id) VALUES(12,1);
INSERT INTO album_mappings(image_id,album_id) VALUES(13,1);
INSERT INTO album_mappings(image_id,album_id) VALUES(14,1);
INSERT INTO album_mappings(image_id,album_id) VALUES(15,1);
INSERT INTO album_mappings(image_id,album_id) VALUES(16,1);
INSERT INTO album_mappings(image_id,album_id) VALUES(17,1);
INSERT INTO album_mappings(image_id,album_id) VALUES(18,1);
INSERT INTO album_mappings(image_id,album_id) VALUES(19,1);
INSERT INTO album_mappings(image_id,album_id) VALUES(20,1);
INSERT INTO album_mappings(image_id,album_id) VALUES(21,1);
INSERT INTO album_mappings(image_id,album_id) VALUES(22,1);
INSERT INTO album_mappings(image_id,album_id) VALUES(23,1);
INSERT INTO album_mappings(image_id,album_id) VALUES(24,1);
INSERT INTO album_mappings(image_id,album_id) VALUES(25,1);
INSERT INTO album_mappings(image_id,album_id) VALUES(26,1);
INSERT INTO album_mappings(image_id,album_id) VALUES(27,1);
INSERT INTO album_mappings(image_id,album_id) VALUES(28,1);
INSERT INTO album_mappings(image_id,album_id) VALUES(29,1);
INSERT INTO album_mappings(image_id,album_id) VALUES(30,1);
INSERT INTO album_mappings(image_id,album_id) VALUES(31,1);
INSERT INTO album_mappings(image_id,album_id) VALUES(32,1);

INSERT INTO album_mappings(image_id,album_id) VALUES(33,1);
INSERT INTO album_mappings(image_id,album_id) VALUES(34,1);
INSERT INTO album_mappings(image_id,album_id) VALUES(35,1);
INSERT INTO album_mappings(image_id,album_id) VALUES(36,1);
INSERT INTO album_mappings(image_id,album_id) VALUES(37,1);
INSERT INTO album_mappings(image_id,album_id) VALUES(38,1);
INSERT INTO album_mappings(image_id,album_id) VALUES(39,1);
INSERT INTO album_mappings(image_id,album_id) VALUES(40,1);