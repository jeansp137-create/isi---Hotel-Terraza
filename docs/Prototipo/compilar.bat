@echo off
chcp 65001 >nul
cd /d "%~dp0"

set "JAVA_HOME=C:\Program Files\Eclipse Adoptium\jdk-17.0.20.101-hotspot"
set "PATH=%JAVA_HOME%\bin;%PATH%"

echo Compilando Hotel Luna...
echo.

if not exist bin mkdir bin

javac -encoding UTF-8 -d bin src\hotel\*.java

if %errorlevel% neq 0 (
    echo.
    echo ERROR: No se pudo compilar.
    echo Revisa que el JDK este instalado en:
    echo %JAVA_HOME%
    pause
    exit /b 1
)

echo Compilacion lista.
echo Ahora abre ejecutar.bat para ver la pagina.
pause
