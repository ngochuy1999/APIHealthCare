USE [HealthCare]
GO
/****** Object:  Table [dbo].[Account]    Script Date: 11/27/2021 12:44:03 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Account](
	[accountId] [int] IDENTITY(1,1) NOT NULL,
	[email] [nvarchar](200) NOT NULL,
	[password] [nvarchar](50) NOT NULL,
	[roleId] [int] NOT NULL,
	[phone] [nvarchar](20) NOT NULL,
	[dateCreate] [date] NOT NULL,
	[username] [nvarchar](50) NOT NULL,
	[avatar] [nvarchar](max) NULL,
	[cover] [nvarchar](max) NULL,
	[isAccuracy] [int] NOT NULL,
	[active] [int] NULL,
 CONSTRAINT [PK_Account_1] PRIMARY KEY CLUSTERED 
(
	[accountId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
/****** Object:  Table [dbo].[ConsultingRoom]    Script Date: 11/27/2021 12:44:03 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ConsultingRoom](
	[clicnicId] [int] NOT NULL,
	[clicnicName] [nvarchar](50) NOT NULL,
	[note] [nchar](10) NOT NULL,
	[active] [int] NULL,
 CONSTRAINT [PK_Clinic] PRIMARY KEY CLUSTERED 
(
	[clicnicId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Doctor]    Script Date: 11/27/2021 12:44:03 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Doctor](
	[doctorId] [int] NOT NULL,
	[firstName] [nvarchar](50) NOT NULL,
	[lastName] [nvarchar](50) NOT NULL,
	[address] [nvarchar](200) NOT NULL,
	[specialityId] [int] NOT NULL,
	[consultingRoomId] [int] NOT NULL,
	[isWorking] [int] NOT NULL,
	[birthday] [date] NOT NULL,
	[dateBegin] [date] NOT NULL,
	[dateEnd] [date] NULL,
	[active] [int] NULL,
	[yearExperience] [nvarchar](50) NOT NULL,
	[timeAdvise] [int] NOT NULL,
	[description] [nvarchar](max) NOT NULL,
 CONSTRAINT [PK_Doctor] PRIMARY KEY CLUSTERED 
(
	[doctorId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
/****** Object:  Table [dbo].[FavoriteDoctor]    Script Date: 11/27/2021 12:44:03 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[FavoriteDoctor](
	[PID] [int] NOT NULL,
	[doctorId] [int] NOT NULL,
 CONSTRAINT [PK_Like] PRIMARY KEY CLUSTERED 
(
	[PID] ASC,
	[doctorId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[HospitalData]    Script Date: 11/27/2021 12:44:03 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[HospitalData](
	[id] [int] NOT NULL,
	[profit] [float] NOT NULL,
 CONSTRAINT [PK_HospitalData] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[HospitalInfo]    Script Date: 11/27/2021 12:44:03 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[HospitalInfo](
	[id] [int] NOT NULL,
	[name] [nvarchar](50) NOT NULL,
	[address] [nvarchar](50) NOT NULL,
	[addressDetail] [nvarchar](50) NULL,
	[phoneNumber] [nvarchar](50) NOT NULL,
	[description] [nvarchar](50) NOT NULL,
	[versionApp] [nvarchar](10) NULL,
 CONSTRAINT [PK_HospitalInfo] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[MedicalBill]    Script Date: 11/27/2021 12:44:03 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[MedicalBill](
	[billId] [int] IDENTITY(1,1) NOT NULL,
	[waitingTime] [time](7) NULL,
	[date] [datetime] NOT NULL,
	[examinationFee] [float] NOT NULL,
	[PID] [int] NOT NULL,
	[objectId] [int] NOT NULL,
	[doctorId] [int] NOT NULL,
	[statusId] [int] NOT NULL,
 CONSTRAINT [PK_MedicalBill] PRIMARY KEY CLUSTERED 
(
	[billId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[MedicalBillStatus]    Script Date: 11/27/2021 12:44:03 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[MedicalBillStatus](
	[statusId] [int] NOT NULL,
	[statusName] [nvarchar](50) NOT NULL,
	[description] [nvarchar](100) NOT NULL,
 CONSTRAINT [PK_MedicalBillStatus] PRIMARY KEY CLUSTERED 
(
	[statusId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[MedicalObject]    Script Date: 11/27/2021 12:44:03 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[MedicalObject](
	[id] [int] NOT NULL,
	[name] [nvarchar](50) NOT NULL,
	[description] [nvarchar](50) NOT NULL,
	[active] [int] NOT NULL,
 CONSTRAINT [PK_MedicalObject] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[MedicalRecord]    Script Date: 11/27/2021 12:44:03 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[MedicalRecord](
	[recordId] [int] IDENTITY(1,1) NOT NULL,
	[billId] [int] NULL,
	[diagnostic] [nvarchar](50) NOT NULL,
	[drugAllergy] [nvarchar](50) NOT NULL,
	[active] [int] NULL,
 CONSTRAINT [PK_Patient] PRIMARY KEY CLUSTERED 
(
	[recordId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[NotificationDetail]    Script Date: 11/27/2021 12:44:03 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[NotificationDetail](
	[idNoti] [int] NOT NULL,
	[IdAccount] [int] NOT NULL,
 CONSTRAINT [PK_NotificationDetail] PRIMARY KEY CLUSTERED 
(
	[idNoti] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Notifiication]    Script Date: 11/27/2021 12:44:03 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Notifiication](
	[idNoti] [int] NOT NULL,
	[contentNoti] [nvarchar](1000) NOT NULL,
	[dateNoti] [datetime] NOT NULL,
	[isAdmin] [int] NOT NULL,
 CONSTRAINT [PK_Notifiication] PRIMARY KEY CLUSTERED 
(
	[idNoti] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Patient]    Script Date: 11/27/2021 12:44:03 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Patient](
	[PID] [int] NOT NULL,
	[identityCard] [nvarchar](20) NULL,
	[name] [nvarchar](100) NOT NULL,
	[gender] [int] NULL,
	[birthday] [date] NULL,
	[address] [nvarchar](200) NULL,
	[active] [int] NULL,
 CONSTRAINT [PK_Patient_1] PRIMARY KEY CLUSTERED 
(
	[PID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Prescription]    Script Date: 11/27/2021 12:44:03 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Prescription](
	[prescriptionId] [int] NOT NULL,
	[medicineName] [nvarchar](50) NOT NULL,
	[quantity] [int] NOT NULL,
	[dosage] [nvarchar](100) NOT NULL,
	[active] [int] NOT NULL,
 CONSTRAINT [PK_PrescriptionDetail] PRIMARY KEY CLUSTERED 
(
	[prescriptionId] ASC,
	[medicineName] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[QRCode]    Script Date: 11/27/2021 12:44:03 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[QRCode](
	[id] [int] NOT NULL,
	[imageUrl] [nvarchar](200) NOT NULL,
	[doctorId] [int] NOT NULL,
	[active] [int] NULL,
 CONSTRAINT [PK_QRCode] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Question]    Script Date: 11/27/2021 12:44:03 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Question](
	[questionId] [int] NOT NULL,
	[accountID] [int] NOT NULL,
	[question] [nvarchar](1000) NOT NULL,
	[dateComment] [date] NOT NULL,
	[dateEdit] [date] NULL,
	[parentQuestionID] [int] NULL,
	[doctorId] [int] NOT NULL,
 CONSTRAINT [PK_Question] PRIMARY KEY CLUSTERED 
(
	[questionId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Rating]    Script Date: 11/27/2021 12:44:03 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Rating](
	[ratingId] [int] NOT NULL,
	[billId] [int] NOT NULL,
	[doctorId] [int] NOT NULL,
	[accountId] [int] NOT NULL,
	[rating] [int] NOT NULL,
	[comment] [nvarchar](1000) NOT NULL,
	[dateRating] [datetime] NOT NULL,
	[dateEdit] [datetime] NULL,
	[parentId] [int] NULL,
 CONSTRAINT [PK_Rating] PRIMARY KEY CLUSTERED 
(
	[ratingId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Role]    Script Date: 11/27/2021 12:44:03 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Role](
	[roleId] [int] NOT NULL,
	[roleName] [nvarchar](50) NOT NULL,
	[description] [nvarchar](200) NOT NULL,
	[active] [int] NULL,
 CONSTRAINT [PK_Role] PRIMARY KEY CLUSTERED 
(
	[roleId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Speciality]    Script Date: 11/27/2021 12:44:03 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Speciality](
	[specialityId] [int] NOT NULL,
	[name] [nvarchar](100) NOT NULL,
	[description] [nvarchar](200) NOT NULL,
	[imageUrl] [nvarchar](200) NULL,
	[active] [int] NULL,
 CONSTRAINT [PK_Department] PRIMARY KEY CLUSTERED 
(
	[specialityId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Subclinical]    Script Date: 11/27/2021 12:44:03 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Subclinical](
	[subclinicalId] [int] NOT NULL,
	[testName] [nvarchar](50) NOT NULL,
	[price] [float] NOT NULL,
	[active] [int] NULL,
	[specialityId] [int] NOT NULL,
 CONSTRAINT [PK_Paraclinical] PRIMARY KEY CLUSTERED 
(
	[subclinicalId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[TestForm]    Script Date: 11/27/2021 12:44:03 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[TestForm](
	[testFormId] [int] IDENTITY(1,1) NOT NULL,
	[isPay] [int] NOT NULL,
	[billId] [int] NOT NULL,
	[diagnostic] [nvarchar](100) NOT NULL,
	[active] [int] NULL,
 CONSTRAINT [PK_TestForm] PRIMARY KEY CLUSTERED 
(
	[testFormId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[TestFormDetail]    Script Date: 11/27/2021 12:44:03 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[TestFormDetail](
	[testFormId] [int] NOT NULL,
	[subclinicalId] [int] NOT NULL,
	[assignTime] [date] NOT NULL,
	[note] [nvarchar](50) NULL,
 CONSTRAINT [PK_TestFormDetail] PRIMARY KEY CLUSTERED 
(
	[testFormId] ASC,
	[subclinicalId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[TestResult]    Script Date: 11/27/2021 12:44:03 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[TestResult](
	[resultId] [int] NOT NULL,
	[imageUrl] [nvarchar](200) NOT NULL,
	[fileUrl] [nvarchar](50) NOT NULL,
	[doctorId] [int] NOT NULL,
	[date] [nvarchar](50) NOT NULL,
	[conclude] [nvarchar](50) NOT NULL,
	[testFormId] [int] NULL,
	[active] [int] NULL,
 CONSTRAINT [PK_TestResult] PRIMARY KEY CLUSTERED 
(
	[resultId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[TreatmentRegimen]    Script Date: 11/27/2021 12:44:03 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[TreatmentRegimen](
	[treatmentId] [int] NOT NULL,
	[dateBegin] [date] NULL,
	[dateEnd] [date] NULL,
	[needs] [nvarchar](100) NOT NULL,
	[prohibited] [nvarchar](100) NOT NULL,
	[reExaminationDate] [date] NOT NULL,
	[active] [int] NULL,
 CONSTRAINT [PK_TreatmentRegimen] PRIMARY KEY CLUSTERED 
(
	[treatmentId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET IDENTITY_INSERT [dbo].[Account] ON 

INSERT [dbo].[Account] ([accountId], [email], [password], [roleId], [phone], [dateCreate], [username], [avatar], [cover], [isAccuracy], [active]) VALUES (1, N'ngochuy199x@gmail.com', N'123456', 1, N'096664466', CAST(N'2021-01-01' AS Date), N'admin', NULL, NULL, 1, 1)
INSERT [dbo].[Account] ([accountId], [email], [password], [roleId], [phone], [dateCreate], [username], [avatar], [cover], [isAccuracy], [active]) VALUES (2, N'huy@gmail.com', N'admin', 2, N'096664466', CAST(N'2021-01-01' AS Date), N'admin', NULL, NULL, 1, 1)
INSERT [dbo].[Account] ([accountId], [email], [password], [roleId], [phone], [dateCreate], [username], [avatar], [cover], [isAccuracy], [active]) VALUES (3, N'ngochuy199newx@gmail.com', N'1123', 3, N'096664466', CAST(N'2021-01-01' AS Date), N'ngọc huy', NULL, NULL, 1, 1)
INSERT [dbo].[Account] ([accountId], [email], [password], [roleId], [phone], [dateCreate], [username], [avatar], [cover], [isAccuracy], [active]) VALUES (4, N'ngochuy2201@gmail.com', N'123456', 3, N'096664466', CAST(N'2021-01-01' AS Date), N'lê ngọc huy', NULL, NULL, 1, 1)
INSERT [dbo].[Account] ([accountId], [email], [password], [roleId], [phone], [dateCreate], [username], [avatar], [cover], [isAccuracy], [active]) VALUES (5, N'ngochuy1@gmail.com', N'123456', 3, N'096664466', CAST(N'2021-01-01' AS Date), N'ngọc huy', NULL, NULL, 0, 1)
INSERT [dbo].[Account] ([accountId], [email], [password], [roleId], [phone], [dateCreate], [username], [avatar], [cover], [isAccuracy], [active]) VALUES (6, N'ngochuy@gmail.com', N'123456', 3, N'096664466', CAST(N'2021-01-01' AS Date), N'ngọc huy', NULL, NULL, 0, 1)
INSERT [dbo].[Account] ([accountId], [email], [password], [roleId], [phone], [dateCreate], [username], [avatar], [cover], [isAccuracy], [active]) VALUES (7, N'cr7@gmail.com', N'12345678', 3, N'096664466', CAST(N'2021-01-01' AS Date), N'ronaldo', NULL, NULL, 1, 1)
INSERT [dbo].[Account] ([accountId], [email], [password], [roleId], [phone], [dateCreate], [username], [avatar], [cover], [isAccuracy], [active]) VALUES (8, N'ngoc@gmail.com', N'123', 3, N'096664466', CAST(N'2021-01-01' AS Date), N'ngọc huy', NULL, NULL, 1, 1)
INSERT [dbo].[Account] ([accountId], [email], [password], [roleId], [phone], [dateCreate], [username], [avatar], [cover], [isAccuracy], [active]) VALUES (9, N'hh@gmail.com', N'123', 2, N'096664466', CAST(N'2021-01-01' AS Date), N'huy', NULL, NULL, 1, 1)
INSERT [dbo].[Account] ([accountId], [email], [password], [roleId], [phone], [dateCreate], [username], [avatar], [cover], [isAccuracy], [active]) VALUES (1009, N'nn@gmail.com', N'123456', 3, N'096664466', CAST(N'2021-01-01' AS Date), N'lê ngọc huy', NULL, NULL, 1, 1)
INSERT [dbo].[Account] ([accountId], [email], [password], [roleId], [phone], [dateCreate], [username], [avatar], [cover], [isAccuracy], [active]) VALUES (1012, N'aa@gmail.com', N'1234', 3, N'096664466', CAST(N'2021-01-01' AS Date), N'ngoc huy', NULL, NULL, 1, 1)
INSERT [dbo].[Account] ([accountId], [email], [password], [roleId], [phone], [dateCreate], [username], [avatar], [cover], [isAccuracy], [active]) VALUES (1013, N'ngochuy111@gmail.com', N'Huy123456', 3, N'098886553', CAST(N'2021-11-10' AS Date), N'huy99', NULL, NULL, 1, 1)
INSERT [dbo].[Account] ([accountId], [email], [password], [roleId], [phone], [dateCreate], [username], [avatar], [cover], [isAccuracy], [active]) VALUES (1014, N'ngochuy888@gmail.com', N'1234Huy123', 3, N'09688865559', CAST(N'2021-11-10' AS Date), N'huy007', NULL, NULL, 1, 1)
INSERT [dbo].[Account] ([accountId], [email], [password], [roleId], [phone], [dateCreate], [username], [avatar], [cover], [isAccuracy], [active]) VALUES (1015, N'huuss@gmail.com', N'Kk22334455', 3, N'0909889668', CAST(N'2021-11-10' AS Date), N'hdbdbd', NULL, NULL, 1, 1)
INSERT [dbo].[Account] ([accountId], [email], [password], [roleId], [phone], [dateCreate], [username], [avatar], [cover], [isAccuracy], [active]) VALUES (1016, N'hhg@gmail.com', N'123456Huy', 3, N'09888655228', CAST(N'2021-11-10' AS Date), N'huydll', NULL, NULL, 1, 1)
INSERT [dbo].[Account] ([accountId], [email], [password], [roleId], [phone], [dateCreate], [username], [avatar], [cover], [isAccuracy], [active]) VALUES (2013, N'ng@gmail.com', N'Huy12345678', 3, N'0996885364', CAST(N'2021-11-17' AS Date), N'09484859239', NULL, NULL, 1, 1)
INSERT [dbo].[Account] ([accountId], [email], [password], [roleId], [phone], [dateCreate], [username], [avatar], [cover], [isAccuracy], [active]) VALUES (2014, N'fbfb@gmail.com', N'123Huy456', 3, N'0986865528', CAST(N'2021-11-17' AS Date), N'huyabc', NULL, NULL, 1, 1)
INSERT [dbo].[Account] ([accountId], [email], [password], [roleId], [phone], [dateCreate], [username], [avatar], [cover], [isAccuracy], [active]) VALUES (2018, N'nghuy@gmail.com', N'123456', 2, N'0966885364', CAST(N'2021-11-24' AS Date), N'huy11', NULL, NULL, 1, 1)
SET IDENTITY_INSERT [dbo].[Account] OFF
INSERT [dbo].[ConsultingRoom] ([clicnicId], [clicnicName], [note], [active]) VALUES (1, N'1', N'1         ', 1)
INSERT [dbo].[Doctor] ([doctorId], [firstName], [lastName], [address], [specialityId], [consultingRoomId], [isWorking], [birthday], [dateBegin], [dateEnd], [active], [yearExperience], [timeAdvise], [description]) VALUES (2, N'Thạc sĩ – Bác sĩ HỒ NGUYỄN TIẾN', N'a', N'97 Nguyễn Thị Minh Khai, P. Bến Thành, Quận 1, TP. HCM', 1, 1, 1, CAST(N'1999-02-02' AS Date), CAST(N'2022-01-01' AS Date), CAST(N'2022-01-01' AS Date), 1, N'5 năm', 30, N'
<h2><strong>BẰNG CẤP CHUYÊN MÔN:</strong></h2>
<ul>
<li>Thạc sĩ Sản – Phụ khoa, Đại học Y Dược Huế</li>
<li>Bác sĩ chuyên khoa I Sản – Phụ khoa, Đại học Y Dược Huế</li>
<li>Bác sĩ Đa khoa tổng quát, Đại học Y Dược Huế</li>
<li>Bằng Chẩn đoán hình ảnh về Sản – Phụ khoa và Nội soi buồng tử cung, Đại học Pa-ri XI, Pháp</li>
<li>Chứng chỉ khóa huấn luyện phẫu thuật điều trị són tiểu khi gắng sức và sa sinh dục, Đại học Würzburg, Đức và Bệnh viện Trung Ương Huế</li>
<li>Chứng nhận tham dự khóa huấn luyện các kỹ thuật xâm lấn chẩn đoán trước sinh (sinh thiết gai nhau, nội soi thai) của ISOUG-OR tại bệnh viên KK Singapore</li>
</ul>
<h2><strong>KINH NGHIỆM Y KHOA:</strong></h2>
<ul>
<li>2010 – nay: Cố vấn Cấp cao Sản – Phụ khoa, Bệnh viện Quốc tế Hạnh Phúc</li>
<li>2008 – 2010: Bác sỹ Sản – Phụ khoa, Bệnh viện Trung Ương Huế</li>
<li>2007 – 2008: Bác sỹ nội trú chuyên Sản – Phụ khoa (FFI), Bệnh viện Antoine Beclere, Pa-ri, Pháp</li>
<li>2003 – 2006: Bác sỹ nội trú chuyên Sản – Phụ khoa, Bệnh viện Trung Ương Huế và Bệnh viện Y Dược Huế</li>
</ul>')
INSERT [dbo].[Doctor] ([doctorId], [firstName], [lastName], [address], [specialityId], [consultingRoomId], [isWorking], [birthday], [dateBegin], [dateEnd], [active], [yearExperience], [timeAdvise], [description]) VALUES (3, N'Bác sĩ NGUYỄN NGỌC MAI HUY', N'a', N'97 Nguyễn Thị Minh Khai, P. Bến Thành, Quận 1, TP. HCM', 1, 1, 1, CAST(N'1999-02-02' AS Date), CAST(N'2020-01-01' AS Date), CAST(N'2020-01-01' AS Date), 1, N'3 năm', 35, N'<h2><strong>BẰNG CẤP CHUYÊN MÔN:</strong></h2>
<ul>
<li>Bác sĩ chuyên Khoa I chuyên ngành Nội – Nội Tiết, Đại học Y Dược Tp.HCM</li>
<li>Bác sĩ Đa khoa, Đại học Y Dược Tp.HCM</li>
</ul>
<h2><strong>KINH NGHIỆM Y KHOA:</strong></h2>
<ul>
<li>2017 – nay: Phó trưởng khoa Cấp cứu và Phòng khám 24Hr, Bệnh viện Quốc tế Hạnh Phúc</li>
<li>2015 – 2017: Bác sĩ điều trị khoa Cấp cứu – Nội tiết Bệnh viện Đa khoa Ái Nghĩa, phòng khám Sài Gòn – Bà Rịa</li>
<li>2006 – 2012: Bác sĩ điều tri khoa Cấp cứu – Nội tổng quát, Bệnh viện Đa khoa khu vực Củ Chi, Tp.HCM</li>')
INSERT [dbo].[Doctor] ([doctorId], [firstName], [lastName], [address], [specialityId], [consultingRoomId], [isWorking], [birthday], [dateBegin], [dateEnd], [active], [yearExperience], [timeAdvise], [description]) VALUES (2018, N'Thạc sĩ – Bác sĩ HỒ NGUYỄN TIẾN', N'a', N'97 Nguyễn Thị Minh Khai, P. Bến Thành, Quận 1, TP. HCM', 1, 1, 1, CAST(N'1999-01-22' AS Date), CAST(N'2021-11-24' AS Date), NULL, 1, N'5 năm', 30, N'lol dung du')
INSERT [dbo].[FavoriteDoctor] ([PID], [doctorId]) VALUES (7, 2)
SET IDENTITY_INSERT [dbo].[MedicalBill] ON 

INSERT [dbo].[MedicalBill] ([billId], [waitingTime], [date], [examinationFee], [PID], [objectId], [doctorId], [statusId]) VALUES (1, CAST(N'00:00:00' AS Time), CAST(N'2021-11-16 07:00:00.000' AS DateTime), 18000, 7, 1, 2, 1)
INSERT [dbo].[MedicalBill] ([billId], [waitingTime], [date], [examinationFee], [PID], [objectId], [doctorId], [statusId]) VALUES (2, CAST(N'00:00:00' AS Time), CAST(N'1900-01-01 14:00:06.673' AS DateTime), 18000, 3, 1, 2, 1)
INSERT [dbo].[MedicalBill] ([billId], [waitingTime], [date], [examinationFee], [PID], [objectId], [doctorId], [statusId]) VALUES (8, NULL, CAST(N'1900-01-01 08:00:06.677' AS DateTime), 20000, 7, 1, 2, 1)
INSERT [dbo].[MedicalBill] ([billId], [waitingTime], [date], [examinationFee], [PID], [objectId], [doctorId], [statusId]) VALUES (9, NULL, CAST(N'1900-01-01 00:00:06.680' AS DateTime), 20000, 7, 1, 2, 1)
INSERT [dbo].[MedicalBill] ([billId], [waitingTime], [date], [examinationFee], [PID], [objectId], [doctorId], [statusId]) VALUES (10, NULL, CAST(N'1900-01-01 00:00:06.683' AS DateTime), 20000, 7, 1, 2, 1)
INSERT [dbo].[MedicalBill] ([billId], [waitingTime], [date], [examinationFee], [PID], [objectId], [doctorId], [statusId]) VALUES (11, NULL, CAST(N'1900-01-01 00:00:06.687' AS DateTime), 20000, 7, 1, 2, 1)
INSERT [dbo].[MedicalBill] ([billId], [waitingTime], [date], [examinationFee], [PID], [objectId], [doctorId], [statusId]) VALUES (12, NULL, CAST(N'1900-01-01 00:00:06.690' AS DateTime), 20000, 7, 1, 2, 1)
INSERT [dbo].[MedicalBill] ([billId], [waitingTime], [date], [examinationFee], [PID], [objectId], [doctorId], [statusId]) VALUES (13, NULL, CAST(N'1900-01-01 00:00:06.693' AS DateTime), 20000, 7, 1, 2, 1)
INSERT [dbo].[MedicalBill] ([billId], [waitingTime], [date], [examinationFee], [PID], [objectId], [doctorId], [statusId]) VALUES (14, NULL, CAST(N'1900-01-01 00:00:06.697' AS DateTime), 20000, 7, 1, 2, 1)
INSERT [dbo].[MedicalBill] ([billId], [waitingTime], [date], [examinationFee], [PID], [objectId], [doctorId], [statusId]) VALUES (15, NULL, CAST(N'1900-01-01 00:00:06.700' AS DateTime), 20000, 7, 1, 2, 1)
INSERT [dbo].[MedicalBill] ([billId], [waitingTime], [date], [examinationFee], [PID], [objectId], [doctorId], [statusId]) VALUES (16, NULL, CAST(N'1900-01-01 00:00:06.703' AS DateTime), 20000, 7, 1, 2, 1)
INSERT [dbo].[MedicalBill] ([billId], [waitingTime], [date], [examinationFee], [PID], [objectId], [doctorId], [statusId]) VALUES (17, NULL, CAST(N'1900-01-01 00:00:06.707' AS DateTime), 20000, 7, 1, 2, 1)
INSERT [dbo].[MedicalBill] ([billId], [waitingTime], [date], [examinationFee], [PID], [objectId], [doctorId], [statusId]) VALUES (18, NULL, CAST(N'1900-01-01 00:00:06.710' AS DateTime), 20000, 7, 1, 2, 1)
INSERT [dbo].[MedicalBill] ([billId], [waitingTime], [date], [examinationFee], [PID], [objectId], [doctorId], [statusId]) VALUES (19, NULL, CAST(N'1900-01-01 00:00:06.713' AS DateTime), 20000, 7, 1, 2, 1)
INSERT [dbo].[MedicalBill] ([billId], [waitingTime], [date], [examinationFee], [PID], [objectId], [doctorId], [statusId]) VALUES (20, NULL, CAST(N'1900-01-01 00:00:06.717' AS DateTime), 20000, 7, 1, 2, 4)
INSERT [dbo].[MedicalBill] ([billId], [waitingTime], [date], [examinationFee], [PID], [objectId], [doctorId], [statusId]) VALUES (21, NULL, CAST(N'1900-01-01 00:00:06.720' AS DateTime), 20000, 7, 1, 2, 3)
INSERT [dbo].[MedicalBill] ([billId], [waitingTime], [date], [examinationFee], [PID], [objectId], [doctorId], [statusId]) VALUES (22, NULL, CAST(N'1900-01-01 00:00:06.723' AS DateTime), 20000, 7, 1, 2, 2)
INSERT [dbo].[MedicalBill] ([billId], [waitingTime], [date], [examinationFee], [PID], [objectId], [doctorId], [statusId]) VALUES (23, NULL, CAST(N'1900-01-01 00:00:06.727' AS DateTime), 20000, 7, 1, 2, 1)
INSERT [dbo].[MedicalBill] ([billId], [waitingTime], [date], [examinationFee], [PID], [objectId], [doctorId], [statusId]) VALUES (24, NULL, CAST(N'1900-01-01 00:00:06.730' AS DateTime), 20000, 7, 1, 2, 1)
INSERT [dbo].[MedicalBill] ([billId], [waitingTime], [date], [examinationFee], [PID], [objectId], [doctorId], [statusId]) VALUES (25, NULL, CAST(N'1900-01-01 00:00:06.733' AS DateTime), 20000, 7, 1, 2, 1)
INSERT [dbo].[MedicalBill] ([billId], [waitingTime], [date], [examinationFee], [PID], [objectId], [doctorId], [statusId]) VALUES (26, NULL, CAST(N'1900-01-01 00:00:06.737' AS DateTime), 20000, 7, 1, 2, 1)
INSERT [dbo].[MedicalBill] ([billId], [waitingTime], [date], [examinationFee], [PID], [objectId], [doctorId], [statusId]) VALUES (27, NULL, CAST(N'1900-01-01 00:00:06.740' AS DateTime), 20000, 7, 1, 2, 1)
INSERT [dbo].[MedicalBill] ([billId], [waitingTime], [date], [examinationFee], [PID], [objectId], [doctorId], [statusId]) VALUES (28, NULL, CAST(N'1900-01-01 00:00:06.743' AS DateTime), 20000, 7, 1, 2, 1)
INSERT [dbo].[MedicalBill] ([billId], [waitingTime], [date], [examinationFee], [PID], [objectId], [doctorId], [statusId]) VALUES (29, NULL, CAST(N'1900-01-01 00:00:06.747' AS DateTime), 20000, 7, 1, 2, 1)
INSERT [dbo].[MedicalBill] ([billId], [waitingTime], [date], [examinationFee], [PID], [objectId], [doctorId], [statusId]) VALUES (30, NULL, CAST(N'1900-01-01 00:00:06.750' AS DateTime), 20000, 7, 1, 2, 1)
INSERT [dbo].[MedicalBill] ([billId], [waitingTime], [date], [examinationFee], [PID], [objectId], [doctorId], [statusId]) VALUES (65, NULL, CAST(N'2021-11-18 11:43:45.030' AS DateTime), 20000, 2013, 1, 2, 1)
INSERT [dbo].[MedicalBill] ([billId], [waitingTime], [date], [examinationFee], [PID], [objectId], [doctorId], [statusId]) VALUES (66, NULL, CAST(N'2021-11-18 23:40:37.727' AS DateTime), 20000, 2014, 1, 2, 1)
INSERT [dbo].[MedicalBill] ([billId], [waitingTime], [date], [examinationFee], [PID], [objectId], [doctorId], [statusId]) VALUES (67, NULL, CAST(N'2021-11-18 23:40:38.920' AS DateTime), 20000, 2014, 1, 2, 1)
SET IDENTITY_INSERT [dbo].[MedicalBill] OFF
INSERT [dbo].[MedicalBillStatus] ([statusId], [statusName], [description]) VALUES (1, N'chờ khám', N'ok')
INSERT [dbo].[MedicalBillStatus] ([statusId], [statusName], [description]) VALUES (2, N'đang khám', N'ok')
INSERT [dbo].[MedicalBillStatus] ([statusId], [statusName], [description]) VALUES (3, N'đã khám xong', N'ok')
INSERT [dbo].[MedicalBillStatus] ([statusId], [statusName], [description]) VALUES (4, N'cancel', N'ok')
INSERT [dbo].[MedicalObject] ([id], [name], [description], [active]) VALUES (1, N'BHYT', N'bảo hiểm y tế', 1)
SET IDENTITY_INSERT [dbo].[MedicalRecord] ON 

INSERT [dbo].[MedicalRecord] ([recordId], [billId], [diagnostic], [drugAllergy], [active]) VALUES (1, 30, N'đau đầu ', N'nnn', 1)
SET IDENTITY_INSERT [dbo].[MedicalRecord] OFF
INSERT [dbo].[Patient] ([PID], [identityCard], [name], [gender], [birthday], [address], [active]) VALUES (2, NULL, N'ngọc huy', NULL, NULL, NULL, NULL)
INSERT [dbo].[Patient] ([PID], [identityCard], [name], [gender], [birthday], [address], [active]) VALUES (3, NULL, N'ngọc huy', NULL, NULL, NULL, NULL)
INSERT [dbo].[Patient] ([PID], [identityCard], [name], [gender], [birthday], [address], [active]) VALUES (4, NULL, N'Lê Ngọc Huy', NULL, NULL, NULL, NULL)
INSERT [dbo].[Patient] ([PID], [identityCard], [name], [gender], [birthday], [address], [active]) VALUES (5, NULL, N'ngọc huy', NULL, NULL, NULL, NULL)
INSERT [dbo].[Patient] ([PID], [identityCard], [name], [gender], [birthday], [address], [active]) VALUES (6, NULL, N'ngọc huy', NULL, NULL, NULL, NULL)
INSERT [dbo].[Patient] ([PID], [identityCard], [name], [gender], [birthday], [address], [active]) VALUES (7, NULL, N'Lê Ngọc Huy', NULL, NULL, NULL, NULL)
INSERT [dbo].[Patient] ([PID], [identityCard], [name], [gender], [birthday], [address], [active]) VALUES (8, NULL, N'ngọc huy lê', NULL, NULL, NULL, NULL)
INSERT [dbo].[Patient] ([PID], [identityCard], [name], [gender], [birthday], [address], [active]) VALUES (1009, NULL, N'lê ngọc huy', NULL, NULL, NULL, NULL)
INSERT [dbo].[Patient] ([PID], [identityCard], [name], [gender], [birthday], [address], [active]) VALUES (1012, NULL, N'ngoc huy', NULL, NULL, NULL, NULL)
INSERT [dbo].[Patient] ([PID], [identityCard], [name], [gender], [birthday], [address], [active]) VALUES (1013, NULL, N'Lê Ngọc Huy', NULL, NULL, NULL, NULL)
INSERT [dbo].[Patient] ([PID], [identityCard], [name], [gender], [birthday], [address], [active]) VALUES (1014, NULL, N'Lê Ngọc Huy', NULL, NULL, NULL, NULL)
INSERT [dbo].[Patient] ([PID], [identityCard], [name], [gender], [birthday], [address], [active]) VALUES (1015, NULL, N'NGOC HUY', NULL, NULL, NULL, NULL)
INSERT [dbo].[Patient] ([PID], [identityCard], [name], [gender], [birthday], [address], [active]) VALUES (2013, NULL, N'Ngochuy', NULL, NULL, NULL, NULL)
INSERT [dbo].[Patient] ([PID], [identityCard], [name], [gender], [birthday], [address], [active]) VALUES (2014, N'08589632561', N'Lê Ngọc Huy', 1, CAST(N'1999-01-22' AS Date), N'QB', 1)
INSERT [dbo].[Role] ([roleId], [roleName], [description], [active]) VALUES (1, N'admin', N'admin', 1)
INSERT [dbo].[Role] ([roleId], [roleName], [description], [active]) VALUES (2, N'doctor', N'doctor', 1)
INSERT [dbo].[Role] ([roleId], [roleName], [description], [active]) VALUES (3, N'patient', N'patient', 1)
INSERT [dbo].[Speciality] ([specialityId], [name], [description], [imageUrl], [active]) VALUES (1, N'khoa mắt', N'1', N'https://cdn-icons.flaticon.com/png/128/2775/premium/2775228.png?token=exp=1636562193~hmac=e9ce546a044b5e1dc4c05aa5051c8d86', 1)
INSERT [dbo].[Speciality] ([specialityId], [name], [description], [imageUrl], [active]) VALUES (2, N'khoa tai mũi ', N'2', N'https://cdn-icons.flaticon.com/png/128/2775/premium/2775227.png?token=exp=1636562193~hmac=8fe5a1b6ba2994318e6a70769fbb3e1e', 2)
INSERT [dbo].[Speciality] ([specialityId], [name], [description], [imageUrl], [active]) VALUES (3, N'khoa tim mạch', N'4', N'https://cdn-icons.flaticon.com/png/128/2775/premium/2775221.png?token=exp=1636562193~hmac=b36b6e132e411f93338409e25c395947', 4)
INSERT [dbo].[Speciality] ([specialityId], [name], [description], [imageUrl], [active]) VALUES (4, N'nha khoa', N'6', N'https://cdn-icons.flaticon.com/png/512/2775/premium/2775257.png?token=exp=1636562193~hmac=a46c777cf1dd17f6f52a1c8c15e1aa0c', 6)
INSERT [dbo].[Speciality] ([specialityId], [name], [description], [imageUrl], [active]) VALUES (5, N'khoa thần kinh', N'1', N'https://cdn-icons-png.flaticon.com/512/2491/2491314.png', NULL)
INSERT [dbo].[Speciality] ([specialityId], [name], [description], [imageUrl], [active]) VALUES (6, N'da liễu', N'1', N'https://cdn-icons.flaticon.com/png/512/2775/premium/2775223.png?token=exp=1636565211~hmac=ed2510deacbee13b54b98a1e99e1697e', NULL)
INSERT [dbo].[Speciality] ([specialityId], [name], [description], [imageUrl], [active]) VALUES (7, N'xương khớp', N'1', N'https://cdn-icons.flaticon.com/png/512/2775/premium/2775212.png?token=exp=1636565211~hmac=e8747c3d593c5f20f7caea6811d16d7b', NULL)
INSERT [dbo].[Speciality] ([specialityId], [name], [description], [imageUrl], [active]) VALUES (8, N'khoa hô hấp', N'1', N'https://cdn-icons.flaticon.com/png/512/2775/premium/2775239.png?token=exp=1636565452~hmac=4f40c5e5176f50062114075aabcebb82', NULL)
INSERT [dbo].[Speciality] ([specialityId], [name], [description], [imageUrl], [active]) VALUES (9, N'aaa', N'a', N'a', 1)
ALTER TABLE [dbo].[Question] ADD  CONSTRAINT [DF_Question_dateComment]  DEFAULT (getdate()) FOR [dateComment]
GO
ALTER TABLE [dbo].[Rating] ADD  CONSTRAINT [DF_Rating_dateRating_1]  DEFAULT (getdate()) FOR [dateRating]
GO
ALTER TABLE [dbo].[Account]  WITH CHECK ADD  CONSTRAINT [FK_Account_Role] FOREIGN KEY([roleId])
REFERENCES [dbo].[Role] ([roleId])
GO
ALTER TABLE [dbo].[Account] CHECK CONSTRAINT [FK_Account_Role]
GO
ALTER TABLE [dbo].[Doctor]  WITH CHECK ADD  CONSTRAINT [FK_Doctor_Account] FOREIGN KEY([doctorId])
REFERENCES [dbo].[Account] ([accountId])
GO
ALTER TABLE [dbo].[Doctor] CHECK CONSTRAINT [FK_Doctor_Account]
GO
ALTER TABLE [dbo].[Doctor]  WITH CHECK ADD  CONSTRAINT [FK_Doctor_ConsultingRoom] FOREIGN KEY([consultingRoomId])
REFERENCES [dbo].[ConsultingRoom] ([clicnicId])
GO
ALTER TABLE [dbo].[Doctor] CHECK CONSTRAINT [FK_Doctor_ConsultingRoom]
GO
ALTER TABLE [dbo].[Doctor]  WITH CHECK ADD  CONSTRAINT [FK_Doctor_Speciality] FOREIGN KEY([specialityId])
REFERENCES [dbo].[Speciality] ([specialityId])
GO
ALTER TABLE [dbo].[Doctor] CHECK CONSTRAINT [FK_Doctor_Speciality]
GO
ALTER TABLE [dbo].[FavoriteDoctor]  WITH CHECK ADD  CONSTRAINT [FK_FavoriteDoctor_Patient] FOREIGN KEY([PID])
REFERENCES [dbo].[Patient] ([PID])
GO
ALTER TABLE [dbo].[FavoriteDoctor] CHECK CONSTRAINT [FK_FavoriteDoctor_Patient]
GO
ALTER TABLE [dbo].[FavoriteDoctor]  WITH CHECK ADD  CONSTRAINT [FK_Like_Doctor] FOREIGN KEY([doctorId])
REFERENCES [dbo].[Doctor] ([doctorId])
GO
ALTER TABLE [dbo].[FavoriteDoctor] CHECK CONSTRAINT [FK_Like_Doctor]
GO
ALTER TABLE [dbo].[MedicalBill]  WITH CHECK ADD  CONSTRAINT [FK_MedicalBill_Doctor] FOREIGN KEY([doctorId])
REFERENCES [dbo].[Doctor] ([doctorId])
GO
ALTER TABLE [dbo].[MedicalBill] CHECK CONSTRAINT [FK_MedicalBill_Doctor]
GO
ALTER TABLE [dbo].[MedicalBill]  WITH CHECK ADD  CONSTRAINT [FK_MedicalBill_MedicalBillStatus] FOREIGN KEY([statusId])
REFERENCES [dbo].[MedicalBillStatus] ([statusId])
GO
ALTER TABLE [dbo].[MedicalBill] CHECK CONSTRAINT [FK_MedicalBill_MedicalBillStatus]
GO
ALTER TABLE [dbo].[MedicalBill]  WITH CHECK ADD  CONSTRAINT [FK_MedicalBill_MedicalObject] FOREIGN KEY([objectId])
REFERENCES [dbo].[MedicalObject] ([id])
GO
ALTER TABLE [dbo].[MedicalBill] CHECK CONSTRAINT [FK_MedicalBill_MedicalObject]
GO
ALTER TABLE [dbo].[MedicalBill]  WITH CHECK ADD  CONSTRAINT [FK_MedicalBill_Patient] FOREIGN KEY([PID])
REFERENCES [dbo].[Patient] ([PID])
GO
ALTER TABLE [dbo].[MedicalBill] CHECK CONSTRAINT [FK_MedicalBill_Patient]
GO
ALTER TABLE [dbo].[MedicalRecord]  WITH CHECK ADD  CONSTRAINT [FK_MedicalRecord_MedicalBill] FOREIGN KEY([billId])
REFERENCES [dbo].[MedicalBill] ([billId])
GO
ALTER TABLE [dbo].[MedicalRecord] CHECK CONSTRAINT [FK_MedicalRecord_MedicalBill]
GO
ALTER TABLE [dbo].[Patient]  WITH CHECK ADD  CONSTRAINT [FK_Patient_Account] FOREIGN KEY([PID])
REFERENCES [dbo].[Account] ([accountId])
GO
ALTER TABLE [dbo].[Patient] CHECK CONSTRAINT [FK_Patient_Account]
GO
ALTER TABLE [dbo].[Prescription]  WITH CHECK ADD  CONSTRAINT [FK_PrescriptionDetail_TreatmentRegimen] FOREIGN KEY([prescriptionId])
REFERENCES [dbo].[TreatmentRegimen] ([treatmentId])
GO
ALTER TABLE [dbo].[Prescription] CHECK CONSTRAINT [FK_PrescriptionDetail_TreatmentRegimen]
GO
ALTER TABLE [dbo].[QRCode]  WITH CHECK ADD  CONSTRAINT [FK_QRCode_Doctor] FOREIGN KEY([doctorId])
REFERENCES [dbo].[Doctor] ([doctorId])
GO
ALTER TABLE [dbo].[QRCode] CHECK CONSTRAINT [FK_QRCode_Doctor]
GO
ALTER TABLE [dbo].[Subclinical]  WITH CHECK ADD  CONSTRAINT [FK_Subclinical_Speciality] FOREIGN KEY([specialityId])
REFERENCES [dbo].[Speciality] ([specialityId])
GO
ALTER TABLE [dbo].[Subclinical] CHECK CONSTRAINT [FK_Subclinical_Speciality]
GO
ALTER TABLE [dbo].[TestForm]  WITH CHECK ADD  CONSTRAINT [FK_TestForm_MedicalBill] FOREIGN KEY([billId])
REFERENCES [dbo].[MedicalBill] ([billId])
GO
ALTER TABLE [dbo].[TestForm] CHECK CONSTRAINT [FK_TestForm_MedicalBill]
GO
ALTER TABLE [dbo].[TestFormDetail]  WITH CHECK ADD  CONSTRAINT [FK_TestFormDetail_Paraclinical] FOREIGN KEY([subclinicalId])
REFERENCES [dbo].[Subclinical] ([subclinicalId])
GO
ALTER TABLE [dbo].[TestFormDetail] CHECK CONSTRAINT [FK_TestFormDetail_Paraclinical]
GO
ALTER TABLE [dbo].[TestFormDetail]  WITH CHECK ADD  CONSTRAINT [FK_TestFormDetail_TestForm] FOREIGN KEY([testFormId])
REFERENCES [dbo].[TestForm] ([testFormId])
GO
ALTER TABLE [dbo].[TestFormDetail] CHECK CONSTRAINT [FK_TestFormDetail_TestForm]
GO
ALTER TABLE [dbo].[TestResult]  WITH CHECK ADD  CONSTRAINT [FK_TestResult_Doctor] FOREIGN KEY([doctorId])
REFERENCES [dbo].[Doctor] ([doctorId])
GO
ALTER TABLE [dbo].[TestResult] CHECK CONSTRAINT [FK_TestResult_Doctor]
GO
ALTER TABLE [dbo].[TestResult]  WITH CHECK ADD  CONSTRAINT [FK_TestResult_TestForm] FOREIGN KEY([testFormId])
REFERENCES [dbo].[TestForm] ([testFormId])
GO
ALTER TABLE [dbo].[TestResult] CHECK CONSTRAINT [FK_TestResult_TestForm]
GO
ALTER TABLE [dbo].[TreatmentRegimen]  WITH CHECK ADD  CONSTRAINT [FK_TreatmentRegimen_MedicalRecord] FOREIGN KEY([treatmentId])
REFERENCES [dbo].[MedicalRecord] ([recordId])
GO
ALTER TABLE [dbo].[TreatmentRegimen] CHECK CONSTRAINT [FK_TreatmentRegimen_MedicalRecord]
GO
