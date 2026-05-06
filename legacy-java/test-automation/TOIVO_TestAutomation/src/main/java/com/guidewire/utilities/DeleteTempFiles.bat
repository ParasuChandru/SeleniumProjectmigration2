REM  This batch file is scheduled on a daily basis in this server to clean up some of the temp files like chrome_BITS_*, edge_BITS_* and scoped_dir*

for /d %%i in (c:\"Program Files"\scoped_dir* 
c:\"Program Files"\edge_BITS_*
c:\"Program Files"\chrome_BITS_*) do @rmdir "%%i" /s /q