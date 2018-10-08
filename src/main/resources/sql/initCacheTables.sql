CREATE TABLE IF NOT EXISTS `int_codes` (
  `bicCode` VARCHAR(9) NOT NULL,
  `intCode` DOUBLE     NOT NULL,
  PRIMARY KEY (`bicCode`),
  UNIQUE INDEX `int_codes_bikCode_uindex` (`bicCode`)
);

CREATE TABLE IF NOT EXISTS `credit_org_info` (
  `intCode` DOUBLE NOT NULL,
  `orgInfo` TEXT   NOT NULL,
  PRIMARY KEY (`intCode`),
  UNIQUE INDEX `credit_org_info_intCode_uindex` (`intCode`)
);