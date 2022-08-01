create database opmsa;


  
  CREATE TABLE IF NOT EXISTS `opmsa`.`commentr` (
  `comment_id` INT NOT NULL AUTO_INCREMENT,
  `Date` VARCHAR(15) NOT NULL,
  `Comment_time` VARCHAR(16) NOT NULL,
  `Comment` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`comment_id`));
  
     
    CREATE TABLE IF NOT EXISTS `opmsa`.`admin_records` (
  `Adminid` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(30) NOT NULL,
  `address` VARCHAR(50) NOT NULL,
  PRIMARY KEY (`Adminid`));
  
      
    CREATE TABLE IF NOT EXISTS `opmsa`.`clients` (
  `client_id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(50) NOT NULL,
  `address` VARCHAR(50) NOT NULL,
  PRIMARY KEY (`client_id`));
  
      
    CREATE TABLE IF NOT EXISTS `opmsa`.`commentr` (
  `comment_id` INT NOT NULL AUTO_INCREMENT,
  `Date` VARCHAR(15) NOT NULL,
  `Comment_time` VARCHAR(16) NOT NULL,
  `Comment` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`comment_id`));
  
  
     
    CREATE TABLE IF NOT EXISTS `opmsa`.`propertyr` (
  `property_id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(50) NOT NULL,
  `address` VARCHAR(100) NOT NULL,
  PRIMARY KEY (`property_id`));
  
  
  
  
CREATE TABLE IF NOT EXISTS `opmsa`.`admin_commr` (
  `comment_id` INT NOT NULL AUTO_INCREMENT,
  `admin_id` INT NOT NULL,
  `Comment_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `Comment` VARCHAR(300) NOT NULL,
  PRIMARY KEY (`comment_id`),
  INDEX `admin_id` (`admin_id` ASC) VISIBLE,
  CONSTRAINT `admin_commr_ibfk_1`
    FOREIGN KEY (`comment_id`)
    REFERENCES `opmsa`.`commentr` (`comment_id`),
  CONSTRAINT `admin_commr_ibfk_2`
    FOREIGN KEY (`admin_id`)
    REFERENCES `opmsa`.`admin_records` (`Adminid`));

CREATE TABLE IF NOT EXISTS `opmsa`.`admin_contactr` (
  `Adminidc` INT NOT NULL AUTO_INCREMENT,
  `contact` BIGINT NOT NULL,
  PRIMARY KEY (`contact`),
  INDEX `Adminidc` (`Adminidc` ASC) VISIBLE,
  CONSTRAINT `admin_contactr_ibfk_1`
    FOREIGN KEY (`Adminidc`)
    REFERENCES `opmsa`.`admin_records` (`Adminid`));
    
    CREATE TABLE IF NOT EXISTS `opmsa`.`admin_propr` (
  `property_id` INT NOT NULL AUTO_INCREMENT,
  `admin_id` INT NOT NULL,
  `name` VARCHAR(100) NOT NULL,
  `address` VARCHAR(200) NOT NULL,
  `Discription` VARCHAR(300) NOT NULL,
  `price` INT NOT NULL,
  `property_type` VARCHAR(50) NOT NULL,
  `property_status` VARCHAR(100) NOT NULL,
  PRIMARY KEY (`property_id`, `admin_id`),
  INDEX `admin_id` (`admin_id` ASC) VISIBLE,
  CONSTRAINT `admin_propr_ibfk_1`
    FOREIGN KEY (`admin_id`)
    REFERENCES `opmsa`.`admin_records` (`Adminid`));
 
  


  CREATE TABLE IF NOT EXISTS `opmsa`.`admin_records1` (
  `Adminid` INT NOT NULL,
  `username` VARCHAR(30) NOT NULL,
  PRIMARY KEY (`Adminid`),
  CONSTRAINT `admin_records1_ibfk_1`
    FOREIGN KEY (`Adminid`)
    REFERENCES `opmsa`.`admin_records` (`Adminid`));
    
    
    CREATE TABLE IF NOT EXISTS `opmsa`.`admin_records2` (
  `Adminid` INT NOT NULL,
  `password` VARCHAR(30) NOT NULL,
  PRIMARY KEY (`Adminid`),
  CONSTRAINT `admin_records2_ibfk_1`
    FOREIGN KEY (`Adminid`)
    REFERENCES `opmsa`.`admin_records` (`Adminid`));
    
    
    
   CREATE TABLE IF NOT EXISTS `opmsa`.`client_contactr` (
  `Client_id` INT NOT NULL,
  `contact` BIGINT NOT NULL,
  PRIMARY KEY (`contact`),
  INDEX `Client_id` (`Client_id` ASC) VISIBLE,
  CONSTRAINT `client_contactr_ibfk_1`
    FOREIGN KEY (`Client_id`)
    REFERENCES `opmsa`.`clients` (`client_id`));
    

  
  CREATE TABLE IF NOT EXISTS `opmsa`.`clients1` (
  `client_id` INT NOT NULL AUTO_INCREMENT,
  `email` VARCHAR(30) NOT NULL,
  PRIMARY KEY (`client_id`),
  UNIQUE INDEX `email_UNIQUE` (`email` ASC) VISIBLE,
  CONSTRAINT `clients1_ibfk_1`
    FOREIGN KEY (`client_id`)
    REFERENCES `opmsa`.`clients` (`client_id`));
    
    
    CREATE TABLE IF NOT EXISTS `opmsa`.`clients2` (
  `client_id` INT NOT NULL AUTO_INCREMENT,
  `username` VARCHAR(30) NOT NULL,
  PRIMARY KEY (`client_id`),
  CONSTRAINT `clients2_ibfk_1`
    FOREIGN KEY (`client_id`)
    REFERENCES `opmsa`.`clients` (`client_id`));
    
    
    
    
  CREATE TABLE IF NOT EXISTS `opmsa`.`clients3` (
  `client_id` INT NOT NULL AUTO_INCREMENT,
  `password` VARCHAR(30) NOT NULL,
  `client_type` VARCHAR(10) NOT NULL,
  PRIMARY KEY (`client_id`),
  CONSTRAINT `clients3_ibfk_1`
    FOREIGN KEY (`client_id`)
    REFERENCES `opmsa`.`clients` (`client_id`));
    

  
  
  CREATE TABLE IF NOT EXISTS `opmsa`.`pay_clientr` (
  `payment_id` INT NOT NULL AUTO_INCREMENT,
  `client_id` INT NOT NULL,
  `account_no` BIGINT NOT NULL,
  `date` DATE NOT NULL,
  `amount` INT NOT NULL,
  PRIMARY KEY (`payment_id`),
  INDEX `client_id` (`client_id` ASC) VISIBLE,
  CONSTRAINT `pay_clientr_ibfk_1`
    FOREIGN KEY (`client_id`)
    REFERENCES `opmsa`.`clients` (`client_id`));
    
    
    
    CREATE TABLE IF NOT EXISTS `opmsa`.`pay_clientr1` (
  `payment_id` INT NOT NULL,
  `transaction_no` VARCHAR(150) NOT NULL,
  PRIMARY KEY (`transaction_no`),
  INDEX `payment_id` (`payment_id` ASC) VISIBLE,
  CONSTRAINT `pay_clientr1_ibfk_1`
    FOREIGN KEY (`payment_id`)
    REFERENCES `opmsa`.`pay_clientr` (`payment_id`));
    
    
    
    CREATE TABLE IF NOT EXISTS `opmsa`.`prop_clientr` (
  `property_id` INT NOT NULL,
  `client_id` INT NOT NULL,
  `description` VARCHAR(300) NOT NULL,
  `price` INT NOT NULL,
  `property_type` VARCHAR(50) NOT NULL,
  `property_status` VARCHAR(100) NOT NULL,
  PRIMARY KEY (`property_id`),
  INDEX `client_id` (`client_id` ASC) VISIBLE,
  CONSTRAINT `prop_clientr_ibfk_1`
    FOREIGN KEY (`client_id`)
    REFERENCES `opmsa`.`clients` (`client_id`),
  CONSTRAINT `prop_clientr_ibfk_2`
    FOREIGN KEY (`property_id`)
    REFERENCES `opmsa`.`propertyr` (`property_id`));
    
    
    
    CREATE TABLE IF NOT EXISTS `opmsa`.`prop_clientr1` (
  `property_id` INT NOT NULL,
  `name` VARCHAR(100) NOT NULL,
  `address` VARCHAR(200) NOT NULL,
  PRIMARY KEY (`name`, `address`),
  INDEX `property_id` (`property_id` ASC) VISIBLE,
  CONSTRAINT `prop_clientr1_ibfk_1`
    FOREIGN KEY (`property_id`)
    REFERENCES `opmsa`.`propertyr` (`property_id`));
    
    
    CREATE TABLE IF NOT EXISTS `opmsa`.`prop_commr` (
  `property_id` INT NOT NULL,
  `comment_id` INT NOT NULL,
  PRIMARY KEY (`comment_id`),
  INDEX `property_id` (`property_id` ASC) VISIBLE,
  CONSTRAINT `prop_commr_ibfk_1`
    FOREIGN KEY (`comment_id`)
    REFERENCES `opmsa`.`commentr` (`comment_id`),
  CONSTRAINT `prop_commr_ibfk_2`
    FOREIGN KEY (`property_id`)
    REFERENCES `opmsa`.`propertyr` (`property_id`));
    
    
 
  
  CREATE TABLE IF NOT EXISTS `opmsa`.`propertyr1` (
  `property_id` INT NOT NULL,
  `description` VARCHAR(300) NOT NULL,
  `price` INT NOT NULL,
  `property_type` VARCHAR(50) NOT NULL,
  `property_status` VARCHAR(100) NOT NULL,
  PRIMARY KEY (`property_id`),
  CONSTRAINT `propertyr1_ibfk_1`
    FOREIGN KEY (`property_id`)
    REFERENCES `opmsa`.`propertyr` (`property_id`));