# languagelib
Android 切换语言 

android Studio添加依赖

To get a Git project into your build:

Step 1. Add the JitPack repository to your build file
gradle
Add it in your root build.gradle at the end of repositories:

	allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
Step 2. Add the dependency

	dependencies {
	        implementation 'com.github.LittleWriteRabit:languagelib:v1.0.0'
	}
  
maven
Step 1. Add the JitPack repository to your build file

maven

	<repositories>
		<repository>
		    <id>jitpack.io</id>
		    <url>https://jitpack.io</url>
		</repository>
	</repositories>
  
Step 2. Add the dependency

	<dependency>
	    <groupId>com.github.LittleWriteRabit</groupId>
	    <artifactId>languagelib</artifactId>
	    <version>v1.0.0</version>
	</dependency>
