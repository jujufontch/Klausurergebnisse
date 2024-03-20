<%@ page pageEncoding="UTF-8" %>   
<!DOCTYPE html>
<html>
<style>
table, th, td {
  border:1px solid black;
}
</style>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1>Vorläufige Ergebnisse der Klausur Logik SOSe 2024 </h1>

<ul>

<li> Sie können in die untenliegenden  Felder die Informationen zu  Studenten eingeben </li>

<li> Diese werden sobald sie auf den Button submit drücken , zum Datenbank hinzugefügt </li></ul>

  <p>
  <form method="post" action="bonjour">
            <label for="sname">StudentName : </label>
            <input type="text" name="sname" id="sname" />
            
            <label for="mnum">MatrikelNummer : </label>            
            <input type="text" name="mnum" id="mnum" />
                       
            <label for="note">Note : </label>
            <input type="text" name="note" id="note" />
            
            <input type="submit" />
        </form> </p>
  



</body>
</html>