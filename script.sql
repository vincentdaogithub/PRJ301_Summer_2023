USE master
GO

IF EXISTS (SELECT * FROM sys.databases WHERE name = 'Application')
    DROP DATABASE Application;
GO

CREATE DATABASE Application
GO

USE Application
GO

CREATE TABLE [User] (
    userID NVARCHAR(6),
    fullName NVARCHAR(100),
    roleID NVARCHAR(2),
    password NVARCHAR(100)
);
GO

ALTER TABLE [User]
ADD CONSTRAINT CHK_UserID
CHECK (userID LIKE 'AD[0-9][0-9][0-9][0-9]'
    OR userID LIKE 'US[0-9][0-9][0-9][0-9]'
);
GO

INSERT INTO [User]
VALUES
    ('AD0000', 'admin', 'AD', 'admin'),
    ('US0000', 'user', 'US', '12345');
GO
