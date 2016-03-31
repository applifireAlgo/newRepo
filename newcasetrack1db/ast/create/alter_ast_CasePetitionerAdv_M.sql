

ALTER TABLE `ast_CasePetitionerAdv_M` ADD CONSTRAINT FOREIGN KEY (`advCatId`) REFERENCES `ast_CasePetitionerAdv_M`(`casePetAdvId`);



ALTER TABLE `ast_CasePetitionerAdv_M` ADD CONSTRAINT FOREIGN KEY (`casePetAdv`) REFERENCES `ast_SignUp_T`(`registrationId`);



ALTER TABLE `ast_CasePetitionerAdv_M` ADD CONSTRAINT FOREIGN KEY (`caseId`) REFERENCES `ast_CaseInformation_T`(`caseId`);

