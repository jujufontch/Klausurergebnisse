 package com.octest.beans;

import java.sql.*;

import jakarta.servlet.http.HttpServletRequest;

public class sql {
	
	// Fügt die im HtmlForm eingegebene Daten ins Datenbank ein 
    public boolean insert(HttpServletRequest request){
		
		String sname= request.getParameter("sname");
		
		String mnumStr = request.getParameter("mnum");
		
		String noteStr = request.getParameter("note");
		
		boolean bool = false;
		
		
		 int mnum;
		    float note;
		    try {
		        mnum = Integer.parseInt(mnumStr);
		        note = Float.parseFloat(noteStr);
		   
		    
		    if(matrikelprüfer(mnum)) {
		    	bool = true;
		    }
		    else {
		
		Connection connect = connect();
		
		  PreparedStatement depositStatement = connect.prepareStatement(
                  "INSERT INTO " + "klausur" + " (StudentName,MatrikelNummer,Note) VALUES (?, ?, ?)"
          );
         
			depositStatement.setString(1, sname);
		
          depositStatement.setInt(2,mnum );
          
          depositStatement.setFloat(3,note );
          
          depositStatement.executeUpdate();
          
          bool =false;
          
		 }} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		    
	return bool;
	}
	
	
   // Erstellst die Verbindung mit dem Datenbank
	public  static Connection connect() {
		
	    String url ;
	    Connection connexion= null;
	    String password = "0000";
	    String user = "root" ;
	    
	    
	        try {
	        Class.forName("com.mysql.cj.jdbc.Driver");


	    } catch (ClassNotFoundException e) {

	        System.out.println("Error ");
	    }


	        try {

	        connexion = DriverManager.getConnection("jdbc:mysql://localhost:3305/S", "root", "0000");


	    }
	        catch(Exception e ){

	        System.out.println("Verbindung fehlgeschlagen");
	    }
	        
	        return connexion;
	}
    
	// Speichert das Ergebniss der eingegebenen SQLQuery 
	// in einer ResultSetvariable und gibt diese zurück am Ende der Methode
	public static ResultSet result () {
		
		ResultSet resultat = null;
		
		 try{

		       
	           Connection connexion = connect();
			 
		        Statement sentence = connexion.createStatement();

		        String satz = "SELECT * FROM klausur;";

		        sentence.execute(satz);
		         resultat = sentence.executeQuery(satz);}
	     
		    catch(Exception e){
		    	
		    	System.out.println("Error in the result");

		    }
		 
		 return resultat;
	}
    
	
	//Ermittelt für die als paramter übergebene SQLtabbelle die Anzahl ihrer Spalten  
	public static int getResultColumn(ResultSet r){
	    int columns = 0;
	try{
	      columns = r.getMetaData().getColumnCount();}

	catch(Exception e){
	    System.out.println("Error");
	     }

	return columns;}
    
	
	// Prüft ob die  in Htmlform eingegebene Matrikelnummer schon im Datenbank besetzt ist 
    public static boolean matrikelprüfer(int Mnummer) {
    	
    	 ResultSet rs = result();
         int spalte = getResultColumn(rs);
         int count = 0;

         try{

             while (rs.next()) {


                     if(rs.getInt(2) == Mnummer){

                         count+= 1;
                         break;
                     }




             }rs.close();
         }
         catch(Exception e){}


          if(count ==1){

             return true;
          }
          else {

              return false ;
          }}

	
    //Gib den Inhalt einer SQLtabelle zurück 
	 public static void Select(int spalte, ResultSet rs){
		 try {

	            for (int i = 1; i < spalte+1; i++) {

	                System.out.print(String.format("%-15s", rs.getMetaData().getColumnLabel(i)));}

	            System.out.println();
	            System.out.println("--------------------------------------------------------------");

	            while (rs.next()) {
	                for (int i = 1; i < spalte+1; i++) {

	                    System.out.print(String.format("%-15s", rs.getString(i)));}

	                System.out.println();

	            }


	            rs.close();


	        }
	        catch(Exception e){}



	    }
	}