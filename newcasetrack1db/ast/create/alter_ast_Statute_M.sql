

ALTER TABLE `ast_Statute_M` ADD CONSTRAINT FOREIGN KEY (`litCategoryId`) REFERENCES `ast_LitigationCategory_M`(`litigationCatId`);

