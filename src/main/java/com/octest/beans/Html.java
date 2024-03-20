package com.octest.beans;

import java.sql.ResultSet;
import java.sql.SQLException;



public class Html {
	
	// Ruft den Inhalt einer SQLTabelle , fügt diese zu einem Htmltable 
    public String generateTable(ResultSet rs) throws SQLException {
        StringBuilder htmlTable = new StringBuilder("<table>");
        
        sql m = new sql();

        try {
            // Generate table headers
            htmlTable.append("<tr>");
            
            int columnCount = m.getResultColumn(rs);
            for (int i = 1; i <= columnCount; i++) {
                htmlTable.append("<th>").append(rs.getMetaData().getColumnLabel(i)).append("</th>");
            }
            htmlTable.append("</tr>");

            // Generate table rows
            while (rs.next()) {
                htmlTable.append("<tr>");
                for (int i = 1; i <= columnCount; i++) {
                    htmlTable.append("<td>").append(rs.getString(i)).append("</td>");
                }
                htmlTable.append("</tr>");
            }

            htmlTable.append("</table>");
        } catch (SQLException e) {
            // Log or handle the exception appropriately
            throw e;
        } finally {
            if (rs != null) {
                rs.close();
            }
        }

        return htmlTable.toString();
    }

}