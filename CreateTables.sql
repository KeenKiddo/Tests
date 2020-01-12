CREATE TABLE `movies` (
  `id` int(11) NOT NULL,
  `title` varchar(255) DEFAULT NULL,
  `year` varchar(4) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `ratings` (
  `id` int(11) NOT NULL,
  `position` int(11) DEFAULT NULL,
  `date` date DEFAULT NULL,
  `votes` varchar(20) DEFAULT NULL,
  `movieid` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_movieid` (`movieid`),
  CONSTRAINT `fk_movieid` FOREIGN KEY (`movieid`) REFERENCES `movies` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

