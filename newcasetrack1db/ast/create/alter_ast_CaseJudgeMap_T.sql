

ALTER TABLE `ast_CaseJudgeMap_T` ADD CONSTRAINT FOREIGN KEY (`caseId`) REFERENCES `ast_CaseInformation_T`(`caseId`);



ALTER TABLE `ast_CaseJudgeMap_T` ADD CONSTRAINT FOREIGN KEY (`judgeId`) REFERENCES `ast_JudgeRegistration_T`(`judgeRegId`);

