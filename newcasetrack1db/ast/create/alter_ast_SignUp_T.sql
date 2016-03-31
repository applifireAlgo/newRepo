

ALTER TABLE `ast_SignUp_T` ADD CONSTRAINT FOREIGN KEY (`contactId`) REFERENCES `ast_CoreContacts_T`(`contactId`);



ALTER TABLE `ast_SignUp_T` ADD CONSTRAINT FOREIGN KEY (`userTypeId`) REFERENCES `ast_UserType_M`(`userTypeId`);

