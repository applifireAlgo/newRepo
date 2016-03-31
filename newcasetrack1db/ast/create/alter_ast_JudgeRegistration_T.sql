

ALTER TABLE `ast_JudgeRegistration_T` ADD CONSTRAINT FOREIGN KEY (`jContactId`) REFERENCES `ast_CoreContacts_T`(`contactId`);



ALTER TABLE `ast_JudgeRegistration_T` ADD CONSTRAINT FOREIGN KEY (`forumId`) REFERENCES `ast_Forum_M`(`forumId`);

