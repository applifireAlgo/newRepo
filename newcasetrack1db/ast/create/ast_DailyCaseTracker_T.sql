DROP TABLE IF EXISTS `ast_DailyCaseTracker_T`;

CREATE TABLE `ast_DailyCaseTracker_T` ( `caseTrackId` VARCHAR(256) NOT NULL, `caseItemNo` INT(10) NOT NULL, `caseId` VARCHAR(256) NOT NULL, `caseDate` DATETIME NOT NULL, `judgeRegId` VARCHAR(256) NOT NULL, `courtNo` VARCHAR(256) NOT NULL, `forumId` VARCHAR(256) NOT NULL, `createdBy` VARCHAR(64) NULL DEFAULT '-1', `createdDate` DATETIME NULL DEFAULT '1900-01-01', `updatedBy` VARCHAR(64) NULL DEFAULT '-1', `updatedDate` DATETIME NULL DEFAULT '1900-01-01', `versionId` INT(11) NULL DEFAULT '-1', `activeStatus` INT(1) NULL DEFAULT '1', `txnAccessCode` INT(11) NULL DEFAULT NULL, PRIMARY KEY (`caseTrackId`));

