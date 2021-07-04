USE [assignment_nashtech]
GO
INSERT [dbo].[tblDepartment] ([depID], [depName], [depAddress]) VALUES (1, N'Phòng k? toán', N'HCM')
INSERT [dbo].[tblDepartment] ([depID], [depName], [depAddress]) VALUES (2, N'Phòng nhân s?', N'HCM')
GO
INSERT [dbo].[tblEmployee] ([empID], [empName], [empAddress], [empSalary], [empSex], [empBirthdate], [depID]) VALUES (N'af6d2a48-1bfe-4270-ad85-50e1025c9247', N'Ph?m Vi?t H', N'5 C? Chi', CAST(20000 AS Decimal(18, 0)), N'F', CAST(N'1989-09-19T00:00:00.000' AS DateTime), 2)
INSERT [dbo].[tblEmployee] ([empID], [empName], [empAddress], [empSalary], [empSex], [empBirthdate], [depID]) VALUES (N'2d897637-df7c-45bb-949e-59d0ec190f07', N'Nguy?n Van A', N'4 Bình Duong', CAST(150000 AS Decimal(18, 0)), N'M', CAST(N'1999-09-19T00:00:00.000' AS DateTime), 1)
GO
