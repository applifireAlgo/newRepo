

ALTER TABLE `ast_CaseInformation_T` ADD CONSTRAINT FOREIGN KEY (`forumId`) REFERENCES `ast_Forum_M`(`forumId`);



ALTER TABLE `ast_CaseInformation_T` ADD CONSTRAINT FOREIGN KEY (`caseStatusId`) REFERENCES `ast_CaseStatus_M`(`caseStatusId`);



ALTER TABLE `ast_CaseInformation_T` ADD CONSTRAINT FOREIGN KEY (`caseTypeId`) REFERENCES `ast_CaseType_M`(`caseTypeId`);

