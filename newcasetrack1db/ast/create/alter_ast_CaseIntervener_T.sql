

ALTER TABLE `ast_CaseIntervener_T` ADD CONSTRAINT FOREIGN KEY (`caseId`) REFERENCES `ast_CaseInformation_T`(`caseId`);

