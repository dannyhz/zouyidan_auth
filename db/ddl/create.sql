CREATE TABLE `b_loan_application` (
  `ID` bigint(12) NOT NULL AUTO_INCREMENT,
  `loan_application_id` bigint(12) DEFAULT NULL,
  `apply_person_id` bigint(12) DEFAULT NULL,
  `apply_status` varchar(64) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;