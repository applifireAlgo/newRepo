

ALTER TABLE `ast_CaseType_M` ADD CONSTRAINT FOREIGN KEY (`forumId`) REFERENCES `ast_Forum_M`(`forumId`);



ALTER TABLE `ast_CaseType_M` ADD CONSTRAINT FOREIGN KEY (`litCatId`) REFERENCES `ast_LitigationCategory_M`(`litigationCatId`);

