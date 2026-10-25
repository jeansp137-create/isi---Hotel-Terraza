@echo off
chcp 65001 >nul
cd /d "%~dp0"

set "JAVA_HOME=C:\Program Files\Eclipse Adoptium\jdk-17.0.20.101-hotspot"
set "PATH=%JAVA_HOME%\bin;%PATH%"

if not exist bin\hotel\HotelApp.class (
    echo Primero debes compilar. Abre compilar.bat y luego este archivo.
    pause
    exit /b 1
)

echo Iniciando Hotel Luna...
echo.
echo Abre tu navegador en: http://localhost:8080
echo Para detener el servidor: Ctrl + C
echo.

java -cp bin hotel.HotelApp

pause
