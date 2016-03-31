

ALTER TABLE `ast_CaseRespondent_T` ADD CONSTRAINT FOREIGN KEY (`caseId`) REFERENCES `ast_CaseInformation_T`(`caseId`);

