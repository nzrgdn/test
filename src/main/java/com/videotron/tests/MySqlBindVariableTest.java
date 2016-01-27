package com.videotron.tests;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

@Component
public class MySqlBindVariableTest {

    enum LogType { INFO, WARNING, DEBUG, TRACE, FATAL };

    //    @Autowired
    private static Logger logger = LogManager.getLogger(MySqlBindVariableTest.class.getName());

    public static void main(String[] args) {
        new MySqlBindVariableTest().run();
    }
    private void run() {
        Connection conn = null;
        PreparedStatement prepStmt = null, stmt = null;
        ResultSet rs = null;
        try {
            Class.forName("net.sf.log4jdbc.sql.jdbcapi.DriverSpy").newInstance();
            String connectionUrl = "jdbc:log4jdbc:oracle:thin:@//saorat3:1521/LOUISEBT";
            String connectionUser = "redevance_batch";
            String connectionPassword = "batchtest";
            conn = DriverManager.getConnection(connectionUrl, connectionUser, connectionPassword);
            String sqlStmt = "SELECT no_cli, cd_post FROM id_client where no_cli=?";
            prepStmt = conn.prepareStatement(sqlStmt);
            prepStmt.setString(1, "10000003");
            rs = prepStmt.executeQuery();
            while (rs.next()) {
                String id = rs.getString("no_cli");
                String cdpost = rs.getString("cd_post");
                System.out.println("ID: " + id + ", cd post: " + cdpost);
            }
            sqlStmt = "update fct_semaphore set statut = ?";
            stmt = conn.prepareStatement(sqlStmt);
            stmt.setString(1, "tadam");
            int retour = stmt.executeUpdate();
            logger.info("info ;)");
            logger.warn("warn ;)");
            logger.debug("debug ;)");
            logger.error("error ;)");
            logger.fatal("fatal ;)");
            String message = this.toString(LogType.INFO, "message1", "message2", "message3");
            logger.info(message);

            if (retour > 0) {
                logger.trace("done ;)");
                //                System.out.println("done :)");
            }
            else {
                logger.trace("not done :(");
                //                System.out.println("not done :(");
            }

        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            try {
                if (rs != null) {
                    rs.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                if (prepStmt != null) {
                    prepStmt.close();
                }
                if (stmt != null) {
                    stmt.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    private String toString(LogType logType, String...messages) {
        List<String> arr = Arrays.asList(messages);
        short index = 0;
        for (String str: arr) {
            arr.set(index, index > 0 ? "-SUITE : " + str : str);
            index++;
        }
        return StringUtils.join(arr, "\n");
    }
}