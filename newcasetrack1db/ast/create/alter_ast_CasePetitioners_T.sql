

ALTER TABLE `ast_CasePetitioners_T` ADD CONSTRAINT FOREIGN KEY (`caseId`) REFERENCES `ast_CaseInformation_T`(`caseId`);

