DROP TABLE IF EXISTS `ast_CaseRespondent_T`;

CREATE TABLE `ast_CaseRespondent_T` ( `caseRespId` VARCHAR(256) NOT NULL, `caseId` VARCHAR(256) NOT NULL, `respondentName` VARCHAR(256) NOT NULL, `startDate` DATETIME NULL DEFAULT NULL, `endDate` DATETIME NOT NULL, `createdBy` VARCHAR(64) NULL DEFAULT '-1', `createdDate` DATETIME NULL DEFAULT '1900-01-01', `updatedBy` VARCHAR(64) NULL DEFAULT '-1', `updatedDate` DATETIME NULL DEFAULT '1900-01-01', `versionId` INT(11) NULL DEFAULT '-1', `activeStatus` INT(1) NULL DEFAULT '1', `txnAccessCode` INT(11) NULL DEFAULT NULL, PRIMARY KEY (`caseRespId`));

