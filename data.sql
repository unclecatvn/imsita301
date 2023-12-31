USE [ITA]
GO
/****** Object:  Table [dbo].[Class]    Script Date: 11/6/2023 8:12:37 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Class](
	[class_id] [nvarchar](50) NOT NULL,
	[semester_id] [nvarchar](50) NOT NULL,
	[start_date] [date] NOT NULL,
	[end_date] [date] NOT NULL,
	[class_name] [nvarchar](50) NOT NULL,
 CONSTRAINT [PK_Class] PRIMARY KEY CLUSTERED 
(
	[class_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Enroll]    Script Date: 11/6/2023 8:12:37 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Enroll](
	[enroll_id] [nvarchar](50) NOT NULL,
	[project_id] [nvarchar](50) NOT NULL,
	[user_id] [int] NOT NULL,
 CONSTRAINT [PK_Enroll] PRIMARY KEY CLUSTERED 
(
	[enroll_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Enroll Project]    Script Date: 11/6/2023 8:12:37 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Enroll Project](
	[enroll_id] [nvarchar](50) NOT NULL,
	[project_id] [nvarchar](50) NOT NULL
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Gitlab]    Script Date: 11/6/2023 8:12:37 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Gitlab](
	[gitlab_link] [nvarchar](150) NOT NULL,
	[project_id] [nvarchar](50) NOT NULL,
 CONSTRAINT [PK_Gitlab] PRIMARY KEY CLUSTERED 
(
	[gitlab_link] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Group]    Script Date: 11/6/2023 8:12:37 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Group](
	[group_id] [nvarchar](50) NOT NULL,
	[project_id] [nvarchar](50) NOT NULL,
	[member_id] [nvarchar](50) NOT NULL,
 CONSTRAINT [PK_Group] PRIMARY KEY CLUSTERED 
(
	[group_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Group member]    Script Date: 11/6/2023 8:12:37 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Group member](
	[Gmem_id] [nvarchar](50) NOT NULL,
	[group_id] [nvarchar](50) NOT NULL,
	[member_id] [nvarchar](50) NOT NULL,
 CONSTRAINT [PK_Group member] PRIMARY KEY CLUSTERED 
(
	[Gmem_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Issue]    Script Date: 11/6/2023 8:12:37 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Issue](
	[Issue_id] [nvarchar](50) NOT NULL,
	[milestone_id] [nvarchar](50) NOT NULL,
	[description] [nvarchar](50) NOT NULL,
	[issue_name] [nvarchar](50) NOT NULL,
 CONSTRAINT [PK_Issue] PRIMARY KEY CLUSTERED 
(
	[Issue_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Milestone]    Script Date: 11/6/2023 8:12:37 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Milestone](
	[milestone_id] [nvarchar](50) NOT NULL,
	[project_id] [nvarchar](50) NOT NULL,
	[start_date] [date] NOT NULL,
	[end_date] [date] NOT NULL,
	[requirement] [nvarchar](max) NOT NULL,
	[milestone_name] [nvarchar](50) NOT NULL,
	[Gmem_id] [nvarchar](50) NOT NULL,
 CONSTRAINT [PK_Milestone] PRIMARY KEY CLUSTERED 
(
	[milestone_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Project]    Script Date: 11/6/2023 8:12:37 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Project](
	[project_id] [nvarchar](50) NOT NULL,
	[sub_id] [nvarchar](50) NOT NULL,
	[description] [nvarchar](max) NOT NULL,
	[requirement] [nvarchar](max) NOT NULL,
	[gitlab_link] [nvarchar](150) NOT NULL,
 CONSTRAINT [PK_Project] PRIMARY KEY CLUSTERED 
(
	[project_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Role]    Script Date: 11/6/2023 8:12:37 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Role](
	[role_id] [int] NOT NULL,
	[role_name] [nchar](10) NOT NULL,
 CONSTRAINT [PK_Role] PRIMARY KEY CLUSTERED 
(
	[role_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Semester]    Script Date: 11/6/2023 8:12:37 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Semester](
	[semester_id] [nvarchar](50) NOT NULL,
	[semester_name] [nvarchar](50) NOT NULL,
	[description] [nvarchar](max) NOT NULL,
 CONSTRAINT [PK_Semester] PRIMARY KEY CLUSTERED 
(
	[semester_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Semester_class]    Script Date: 11/6/2023 8:12:37 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Semester_class](
	[semester_class_id] [nvarchar](50) NOT NULL,
	[semester_id] [nvarchar](50) NOT NULL,
	[class_id] [nvarchar](50) NOT NULL,
 CONSTRAINT [PK_Semester_class] PRIMARY KEY CLUSTERED 
(
	[semester_class_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Subject]    Script Date: 11/6/2023 8:12:37 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Subject](
	[sub_id] [nvarchar](50) NOT NULL,
	[sub_name] [nvarchar](50) NOT NULL,
	[description] [nvarchar](max) NOT NULL,
	[class_id] [nvarchar](50) NOT NULL,
 CONSTRAINT [PK_Subject] PRIMARY KEY CLUSTERED 
(
	[sub_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[system_setting]    Script Date: 11/6/2023 8:12:37 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[system_setting](
	[status] [bit] NOT NULL,
	[domain_emails] [nvarchar](50) NOT NULL
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[User]    Script Date: 11/6/2023 8:12:37 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[User](
	[user_id] [int] IDENTITY(1,1) NOT NULL,
	[full_name] [nchar](50) NOT NULL,
	[email] [nvarchar](50) NULL,
	[gender] [bit] NULL,
	[password] [nvarchar](50) NOT NULL,
	[phone] [int] NULL,
	[status] [bit] NOT NULL,
	[role_id] [int] NOT NULL,
	[roll_number] [nvarchar](50) NULL,
	[verification_key] [nvarchar](50) NULL,
 CONSTRAINT [PK_User] PRIMARY KEY CLUSTERED 
(
	[user_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
INSERT [dbo].[Role] ([role_id], [role_name]) VALUES (1, N'Admin     ')
GO
SET IDENTITY_INSERT [dbo].[User] ON 

INSERT [dbo].[User] ([user_id], [full_name], [email], [gender], [password], [phone], [status], [role_id], [roll_number], [verification_key]) VALUES (1, N'Hoai Nam                                          ', N'nguyenhoain123@gmail.com', 1, N'123', 0, 1, 1, N'HE160187', NULL)
INSERT [dbo].[User] ([user_id], [full_name], [email], [gender], [password], [phone], [status], [role_id], [roll_number], [verification_key]) VALUES (8, N'Nam Hoai                                          ', N'hoainam2002vn@gmail.com', 1, N'123', 0, 1, 1, N'Null', NULL)
SET IDENTITY_INSERT [dbo].[User] OFF
GO
ALTER TABLE [dbo].[Class]  WITH CHECK ADD  CONSTRAINT [FK_Class_Semester_class] FOREIGN KEY([semester_id])
REFERENCES [dbo].[Semester_class] ([semester_class_id])
GO
ALTER TABLE [dbo].[Class] CHECK CONSTRAINT [FK_Class_Semester_class]
GO
ALTER TABLE [dbo].[Enroll]  WITH CHECK ADD  CONSTRAINT [FK_Enroll_User] FOREIGN KEY([user_id])
REFERENCES [dbo].[User] ([user_id])
GO
ALTER TABLE [dbo].[Enroll] CHECK CONSTRAINT [FK_Enroll_User]
GO
ALTER TABLE [dbo].[Enroll Project]  WITH CHECK ADD  CONSTRAINT [FK_Enroll Project_Enroll] FOREIGN KEY([enroll_id])
REFERENCES [dbo].[Enroll] ([enroll_id])
GO
ALTER TABLE [dbo].[Enroll Project] CHECK CONSTRAINT [FK_Enroll Project_Enroll]
GO
ALTER TABLE [dbo].[Enroll Project]  WITH CHECK ADD  CONSTRAINT [FK_Enroll Project_Project] FOREIGN KEY([project_id])
REFERENCES [dbo].[Project] ([project_id])
GO
ALTER TABLE [dbo].[Enroll Project] CHECK CONSTRAINT [FK_Enroll Project_Project]
GO
ALTER TABLE [dbo].[Group]  WITH CHECK ADD  CONSTRAINT [FK_Group_Project] FOREIGN KEY([project_id])
REFERENCES [dbo].[Project] ([project_id])
GO
ALTER TABLE [dbo].[Group] CHECK CONSTRAINT [FK_Group_Project]
GO
ALTER TABLE [dbo].[Group member]  WITH CHECK ADD  CONSTRAINT [FK_Group member_Group] FOREIGN KEY([group_id])
REFERENCES [dbo].[Group] ([group_id])
GO
ALTER TABLE [dbo].[Group member] CHECK CONSTRAINT [FK_Group member_Group]
GO
ALTER TABLE [dbo].[Issue]  WITH CHECK ADD  CONSTRAINT [FK_Issue_Milestone] FOREIGN KEY([milestone_id])
REFERENCES [dbo].[Milestone] ([milestone_id])
GO
ALTER TABLE [dbo].[Issue] CHECK CONSTRAINT [FK_Issue_Milestone]
GO
ALTER TABLE [dbo].[Milestone]  WITH CHECK ADD  CONSTRAINT [FK_Milestone_Group member] FOREIGN KEY([Gmem_id])
REFERENCES [dbo].[Group member] ([Gmem_id])
GO
ALTER TABLE [dbo].[Milestone] CHECK CONSTRAINT [FK_Milestone_Group member]
GO
ALTER TABLE [dbo].[Project]  WITH CHECK ADD  CONSTRAINT [FK_Project_Gitlab] FOREIGN KEY([gitlab_link])
REFERENCES [dbo].[Gitlab] ([gitlab_link])
GO
ALTER TABLE [dbo].[Project] CHECK CONSTRAINT [FK_Project_Gitlab]
GO
ALTER TABLE [dbo].[Project]  WITH CHECK ADD  CONSTRAINT [FK_Project_Subject] FOREIGN KEY([sub_id])
REFERENCES [dbo].[Subject] ([sub_id])
GO
ALTER TABLE [dbo].[Project] CHECK CONSTRAINT [FK_Project_Subject]
GO
ALTER TABLE [dbo].[Semester_class]  WITH CHECK ADD  CONSTRAINT [FK_Semester_class_Semester] FOREIGN KEY([semester_class_id])
REFERENCES [dbo].[Semester] ([semester_id])
GO
ALTER TABLE [dbo].[Semester_class] CHECK CONSTRAINT [FK_Semester_class_Semester]
GO
ALTER TABLE [dbo].[Subject]  WITH CHECK ADD  CONSTRAINT [FK_Subject_Class] FOREIGN KEY([class_id])
REFERENCES [dbo].[Class] ([class_id])
GO
ALTER TABLE [dbo].[Subject] CHECK CONSTRAINT [FK_Subject_Class]
GO
ALTER TABLE [dbo].[User]  WITH CHECK ADD  CONSTRAINT [FK_User_Role] FOREIGN KEY([role_id])
REFERENCES [dbo].[Role] ([role_id])
GO
ALTER TABLE [dbo].[User] CHECK CONSTRAINT [FK_User_Role]
GO
