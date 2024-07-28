package application;

import db.DB;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Program {
    public static void main(String[] args) {

        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;
        try {
            conn = DB.getConnection();

            st = conn.createStatement(); // instanciar obj do tipo Statement

            rs = st.executeQuery("select * from department");// entrar com uma string -> comando sql

            while (rs.next()) {
                System.out.println(rs.getInt("Id") + " " + rs.getString("Name"));

            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            DB.closeResultSet(rs); DB.closeStatement(st); DB.closeConnection();
        }

    }
}
