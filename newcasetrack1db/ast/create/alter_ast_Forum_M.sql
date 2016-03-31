

ALTER TABLE `ast_Forum_M` ADD CONSTRAINT FOREIGN KEY (`litCategoryId`) REFERENCES `ast_LitigationCategory_M`(`litigationCatId`);

