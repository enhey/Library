USE [master]
GO
/****** Object:  Database [library]    Script Date: 12/31/2018 21:21:20 ******/
CREATE DATABASE [library] ON  PRIMARY 
( NAME = N'library', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL10_50.SQLEXPRESS\MSSQL\DATA\library.mdf' , SIZE = 3072KB , MAXSIZE = UNLIMITED, FILEGROWTH = 1024KB )
 LOG ON 
( NAME = N'library_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL10_50.SQLEXPRESS\MSSQL\DATA\library_log.ldf' , SIZE = 1024KB , MAXSIZE = 2048GB , FILEGROWTH = 10%)
GO
ALTER DATABASE [library] SET COMPATIBILITY_LEVEL = 100
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [library].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [library] SET ANSI_NULL_DEFAULT OFF
GO
ALTER DATABASE [library] SET ANSI_NULLS OFF
GO
ALTER DATABASE [library] SET ANSI_PADDING OFF
GO
ALTER DATABASE [library] SET ANSI_WARNINGS OFF
GO
ALTER DATABASE [library] SET ARITHABORT OFF
GO
ALTER DATABASE [library] SET AUTO_CLOSE OFF
GO
ALTER DATABASE [library] SET AUTO_CREATE_STATISTICS ON
GO
ALTER DATABASE [library] SET AUTO_SHRINK OFF
GO
ALTER DATABASE [library] SET AUTO_UPDATE_STATISTICS ON
GO
ALTER DATABASE [library] SET CURSOR_CLOSE_ON_COMMIT OFF
GO
ALTER DATABASE [library] SET CURSOR_DEFAULT  GLOBAL
GO
ALTER DATABASE [library] SET CONCAT_NULL_YIELDS_NULL OFF
GO
ALTER DATABASE [library] SET NUMERIC_ROUNDABORT OFF
GO
ALTER DATABASE [library] SET QUOTED_IDENTIFIER OFF
GO
ALTER DATABASE [library] SET RECURSIVE_TRIGGERS OFF
GO
ALTER DATABASE [library] SET  DISABLE_BROKER
GO
ALTER DATABASE [library] SET AUTO_UPDATE_STATISTICS_ASYNC OFF
GO
ALTER DATABASE [library] SET DATE_CORRELATION_OPTIMIZATION OFF
GO
ALTER DATABASE [library] SET TRUSTWORTHY OFF
GO
ALTER DATABASE [library] SET ALLOW_SNAPSHOT_ISOLATION OFF
GO
ALTER DATABASE [library] SET PARAMETERIZATION SIMPLE
GO
ALTER DATABASE [library] SET READ_COMMITTED_SNAPSHOT OFF
GO
ALTER DATABASE [library] SET HONOR_BROKER_PRIORITY OFF
GO
ALTER DATABASE [library] SET  READ_WRITE
GO
ALTER DATABASE [library] SET RECOVERY SIMPLE
GO
ALTER DATABASE [library] SET  MULTI_USER
GO
ALTER DATABASE [library] SET PAGE_VERIFY CHECKSUM
GO
ALTER DATABASE [library] SET DB_CHAINING OFF
GO
USE [library]
GO
/****** Object:  User [library]    Script Date: 12/31/2018 21:21:20 ******/
CREATE USER [library] FOR LOGIN [library] WITH DEFAULT_SCHEMA=[dbo]
GO
/****** Object:  Table [dbo].[reader]    Script Date: 12/31/2018 21:21:20 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[reader](
	[reader_id] [nvarchar](10) NOT NULL,
	[reader_password] [nvarchar](16) NULL,
PRIMARY KEY CLUSTERED 
(
	[reader_id] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[borrow]    Script Date: 12/31/2018 21:21:20 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[borrow](
	[id] [nvarchar](10) NULL,
	[borrowUp] [int] NULL,
	[borrowAlready] [int] NULL,
	[ticket] [float] NULL
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[book]    Script Date: 12/31/2018 21:21:20 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[book](
	[id] [nvarchar](10) NOT NULL,
	[name] [nvarchar](30) NULL,
	[author] [nvarchar](30) NULL,
	[brand] [nvarchar](10) NULL,
	[press] [nvarchar](30) NULL,
	[outtime] [date] NULL,
	[price] [numeric](6, 2) NULL,
	[local] [nvarchar](30) NULL,
	[freuency] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[work_detail]    Script Date: 12/31/2018 21:21:20 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[work_detail](
	[work_id] [nvarchar](10) NOT NULL,
	[name] [nvarchar](8) NULL,
	[sex] [nvarchar](8) NULL,
	[dept] [nvarchar](30) NULL,
PRIMARY KEY CLUSTERED 
(
	[work_id] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[work]    Script Date: 12/31/2018 21:21:20 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[work](
	[work_id] [nvarchar](10) NOT NULL,
	[work_password] [nvarchar](16) NULL,
PRIMARY KEY CLUSTERED 
(
	[work_id] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[reader_detail]    Script Date: 12/31/2018 21:21:20 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[reader_detail](
	[read_id] [nvarchar](10) NOT NULL,
	[name] [nvarchar](8) NULL,
	[sex] [nvarchar](8) NULL,
	[sclass] [nvarchar](30) NULL,
	[type] [nvarchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[read_id] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Check [C1]    Script Date: 12/31/2018 21:21:20 ******/
ALTER TABLE [dbo].[borrow]  WITH CHECK ADD  CONSTRAINT [C1] CHECK  (([borrowUp]>=[borrowAlready]))
GO
ALTER TABLE [dbo].[borrow] CHECK CONSTRAINT [C1]
GO
