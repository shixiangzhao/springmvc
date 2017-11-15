echo Auto build project at tomcat...
set CATALINA_HOME=D:\software\apache-tomcat-8.5.23
set PROJ_HOME=D:\Cienet\workspace\springmvc

if exist %CATALINA_HOME%\webapps\mvc121.war del %CATALINA_HOME%\webapps\mvc121.war /q
echo Copy WAR to webapps...
copy %PROJ_HOME%\target\mvc121.war %CATALINA_HOME%\webapps\mvc121.war

@echo off&set local enable delayed expansion...  
title Tomcat restart...
cd /D %CATALINA_HOME%\bin  
call %CATALINA_HOME%\bin\shutdown.bat  
ping -n 6 127.1 >nul  
wmic process where name="java.exe" get processid,commandline |findstr /i "tomcat" >#  
for /f "delims=*" %%i in (#) do (        
   set var=%%i  
   set var=!var:start= #!  
   for /f "tokens=3 delims=#" %%a in ("!var!") do (set tomcatpid=%%a)  
)  
del # >nul  
if defined tomcatpid taskkill /pid !tomcatpid!  
ping -n 3 127.1 >nul  
call %CATALINA_HOME%\bin\startup.bat  