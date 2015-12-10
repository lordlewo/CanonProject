CREATE TABLE `image` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  `home_direcory` varchar(200) NOT NULL,
  `mime_id` bigint NOT NULL,
  `metadata_id` bigint,
  PRIMARY KEY (`id`),
  FOREIGN KEY (mime_id) REFERENCES mime(id),
  FOREIGN KEY (metadata_id) REFERENCES metadata(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO image(name,home_direcory,mime_id,metadata_id) VALUES('6829321-master-chief-wallpaper','D:\\canon\\images\\',1,1);
INSERT INTO image(name,home_direcory,mime_id,metadata_id) VALUES('6954617-camera-canon-tower-bridge-london-england-photo','D:\\canon\\images\\',1,2);
INSERT INTO image(name,home_direcory,mime_id,metadata_id) VALUES('6953263-island-sunset-pictures','D:\\canon\\images\\',1,3);
INSERT INTO image(name,home_direcory,mime_id,metadata_id) VALUES('6956607-canon-eos-30d-hi-tech-autumn-nature-dry-leaves-photo','D:\\canon\\images\\',1,4);
INSERT INTO image(name,home_direcory,mime_id,metadata_id) VALUES('6959235-mood-girl-camera-canon','D:\\canon\\images\\',1,1);
INSERT INTO image(name,home_direcory,mime_id,metadata_id) VALUES('6967977-canon-camera-photo','D:\\canon\\images\\',1,2);
INSERT INTO image(name,home_direcory,mime_id,metadata_id) VALUES('6993383-old-piano-music-photo','D:\\canon\\images\\',1,3);
INSERT INTO image(name,home_direcory,mime_id,metadata_id) VALUES('6971290-lady-musgrave-island-australia','D:\\canon\\images\\',1,4);
INSERT INTO image(name,home_direcory,mime_id,metadata_id) VALUES('7003450-nikon-camera-photo','D:\\canon\\images\\',1,1);
INSERT INTO image(name,home_direcory,mime_id,metadata_id) VALUES('7004090-canon-lens-camera-hi-tech','D:\\canon\\images\\',1,2);
INSERT INTO image(name,home_direcory,mime_id,metadata_id) VALUES('7008123-brunette-girl-canon-camera','D:\\canon\\images\\',1,3);
INSERT INTO image(name,home_direcory,mime_id,metadata_id) VALUES('7013654-skyrim-artwork','D:\\canon\\images\\',1,4);
INSERT INTO image(name,home_direcory,mime_id,metadata_id) VALUES('7018521-cartoon-kitty','D:\\canon\\images\\',1,1);
INSERT INTO image(name,home_direcory,mime_id,metadata_id) VALUES('7022757-eurofighter-cockpit','D:\\canon\\images\\',1,2);
INSERT INTO image(name,home_direcory,mime_id,metadata_id) VALUES('7023132-universe-carina-nebula','D:\\canon\\images\\',1,3);
INSERT INTO image(name,home_direcory,mime_id,metadata_id) VALUES('7026102-vinyl-records-music','D:\\canon\\images\\',1,4);
INSERT INTO image(name,home_direcory,mime_id,metadata_id) VALUES('7027430-music-records','D:\\canon\\images\\',1,1);
INSERT INTO image(name,home_direcory,mime_id,metadata_id) VALUES('7027595-elder-scrolls-viking','D:\\canon\\images\\',1,2);
INSERT INTO image(name,home_direcory,mime_id,metadata_id) VALUES('7032671-solar-eclipse','D:\\canon\\images\\',1,3);
INSERT INTO image(name,home_direcory,mime_id,metadata_id) VALUES('7035276-field-grass-flowers-lavender','D:\\canon\\images\\',1,4);
INSERT INTO image(name,home_direcory,mime_id,metadata_id) VALUES('7035454-space-shuttle-discovery','D:\\canon\\images\\',1,1);
INSERT INTO image(name,home_direcory,mime_id,metadata_id) VALUES('7036117-server-ethernet-cables','D:\\canon\\images\\',1,2);
INSERT INTO image(name,home_direcory,mime_id,metadata_id) VALUES('7037247-field-poppies-nature','D:\\canon\\images\\',1,3);
INSERT INTO image(name,home_direcory,mime_id,metadata_id) VALUES('7037840-tulips-leaves','D:\\canon\\images\\',1,4);
INSERT INTO image(name,home_direcory,mime_id,metadata_id) VALUES('7038748-gears-of-war-judgment-2013','D:\\canon\\images\\',1,1);
INSERT INTO image(name,home_direcory,mime_id,metadata_id) VALUES('7038848-asian-oriental-lanterns-paper-lights-holiday-photo','D:\\canon\\images\\',1,2);
INSERT INTO image(name,home_direcory,mime_id,metadata_id) VALUES('7039328-brooklyn-bridge-manhattan','D:\\canon\\images\\',1,3);
INSERT INTO image(name,home_direcory,mime_id,metadata_id) VALUES('7039959-girl-poppy-flower','D:\\canon\\images\\',1,4);
INSERT INTO image(name,home_direcory,mime_id,metadata_id) VALUES('7040615-foggy-landscape','D:\\canon\\images\\',1,1);
INSERT INTO image(name,home_direcory,mime_id,metadata_id) VALUES('7040925-lower-manhattan-new-york','D:\\canon\\images\\',1,2);
INSERT INTO image(name,home_direcory,mime_id,metadata_id) VALUES('7041044-thick-wood','D:\\canon\\images\\',1,3);
INSERT INTO image(name,home_direcory,mime_id,metadata_id) VALUES('skyrim','D:\\canon\\images\\',1,4);

INSERT INTO image(name,home_direcory,mime_id,metadata_id) VALUES('door','D:\\canon\\images\\',1,4);
INSERT INTO image(name,home_direcory,mime_id,metadata_id) VALUES('fuji','D:\\canon\\images\\',1,4);
INSERT INTO image(name,home_direcory,mime_id,metadata_id) VALUES('htc','D:\\canon\\images\\',1,3);
INSERT INTO image(name,home_direcory,mime_id,metadata_id) VALUES('iphone','D:\\canon\\images\\',1,3);
INSERT INTO image(name,home_direcory,mime_id,metadata_id) VALUES('nikon','D:\\canon\\images\\',1,2);
INSERT INTO image(name,home_direcory,mime_id,metadata_id) VALUES('panasonic','D:\\canon\\images\\',1,2);
INSERT INTO image(name,home_direcory,mime_id,metadata_id) VALUES('plaza','D:\\canon\\images\\',1,1);
INSERT INTO image(name,home_direcory,mime_id,metadata_id) VALUES('sidney','D:\\canon\\images\\',1,1);
