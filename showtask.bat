call runcrud.bat
if "%ERRORLEVEL%" == "0" goto runbrowser
echo.
echo Error runing runcrud.bat
goto fail

:runbrowser
echo.
start chrome http://localhost:8080/crud/v1/task/getTasks
if %ERRORLEVEL% =="0' goto end
echo.
echo start www fail
goto fail

:fail
echo.
echo There were errors

:end
echo.
echo Work is finished.