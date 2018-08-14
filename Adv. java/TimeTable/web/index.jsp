<%-- 
    Document   : index
    Created on : 14 Aug, 2018, 11:53:58 AM
    Author     : studentadmin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Time Table</title>
    </head>
    <body>
        <center>
            <h1>Welcome!</h1>
            <fieldset style="width: 500px">
                <legend align="left">Set Time Table</legend>
                <form method="POST" action="">
                    <label for="TS">Select Time Slot: </label>
                    <select name="TS">
                        <option value="0"></option>
                    </select>
                    <br>
                    <br>
                    <label for="day">Select Day: </label>
                    <select name="day">
                        <option value="0"></option>
                    </select>
                    <br>
                    <br>
                    <label for="sub">Select Subject: </label>
                    <select name="sub">
                        <option value="0"></option>
                    </select>
                    <br>
                    <br>
                    <input type="submit" value="Submit">
                </form>
            </fieldset>
        </center>
    </body>
</html>
