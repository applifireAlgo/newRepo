

ALTER TABLE `ast_ProfileLitSubCategory_M` ADD CONSTRAINT FOREIGN KEY (`regId`) REFERENCES `ast_SignUp_T`(`registrationId`);



ALTER TABLE `ast_ProfileLitSubCategory_M` ADD CONSTRAINT FOREIGN KEY (`litSubCatId`) REFERENCES `ast_LitigationSubCategory_M`(`litSubCategoryId`);



ALTER TABLE `ast_ProfileLitSubCategory_M` ADD CONSTRAINT FOREIGN KEY (`litCatId`) REFERENCES `ast_LitigationCategory_M`(`litigationCatId`);

