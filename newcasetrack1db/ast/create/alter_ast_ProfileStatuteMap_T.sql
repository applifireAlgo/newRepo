

ALTER TABLE `ast_ProfileStatuteMap_T` ADD CONSTRAINT FOREIGN KEY (`statuteId`) REFERENCES `ast_Statute_M`(`statuteId`);



ALTER TABLE `ast_ProfileStatuteMap_T` ADD CONSTRAINT FOREIGN KEY (`regId`) REFERENCES `ast_SignUp_T`(`registrationId`);



ALTER TABLE `ast_ProfileStatuteMap_T` ADD CONSTRAINT FOREIGN KEY (`litCatId`) REFERENCES `ast_LitigationCategory_M`(`litigationCatId`);

