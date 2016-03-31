

ALTER TABLE `ast_DailyCaseTracker_T` ADD CONSTRAINT FOREIGN KEY (`forumId`) REFERENCES `ast_Forum_M`(`forumId`);



ALTER TABLE `ast_DailyCaseTracker_T` ADD CONSTRAINT FOREIGN KEY (`caseId`) REFERENCES `ast_CaseInformation_T`(`caseId`);



ALTER TABLE `ast_DailyCaseTracker_T` ADD CONSTRAINT FOREIGN KEY (`judgeRegId`) REFERENCES `ast_JudgeRegistration_T`(`judgeRegId`);

