

ALTER TABLE `ast_CaseRespondentAdv_T` ADD CONSTRAINT FOREIGN KEY (`advCatId`) REFERENCES `ast_AdvocateCategory_M`(`advCatId`);



ALTER TABLE `ast_CaseRespondentAdv_T` ADD CONSTRAINT FOREIGN KEY (`advocateId`) REFERENCES `ast_SignUp_T`(`registrationId`);



ALTER TABLE `ast_CaseRespondentAdv_T` ADD CONSTRAINT FOREIGN KEY (`caseId`) REFERENCES `ast_CaseInformation_T`(`caseId`);

