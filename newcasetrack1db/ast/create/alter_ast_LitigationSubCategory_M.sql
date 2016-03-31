

ALTER TABLE `ast_LitigationSubCategory_M` ADD CONSTRAINT FOREIGN KEY (`litigationCategoryId`) REFERENCES `ast_LitigationCategory_M`(`litigationCatId`);

