CREATE TABLE `juxtaposeUser` (
  `id` int(11) NOT NULL,
  `first_name` varchar(255) DEFAULT NULL,
  `last_name` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `phone` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ;

insert into juxtaposeUser values (1,"ankit", "jain",  "ankit@gmail.com", "3219786460");

select * from juxtaposeUser where juxtaposeUser.id=1;
