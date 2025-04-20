package actions.utilities;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static actions.commons.DBConstants.*;


public class DBUtils {
    private static final Logger logger = LoggerFactory.getLogger(DBUtils.class); // Init Logger
    private Connection connection;

    public DBUtils(Connection connection) {
        this.connection = connection;
    }
    private boolean isConnectionValid() {
        try {
            return connection != null && !connection.isClosed();
        } catch (SQLException e) {
            logger.error("Error checking database connection status", e);
            return false; // Coi như không hợp lệ nếu có lỗi khi kiểm tra
        }
    }
    public boolean isEducationExist(String educationName) {
        // check Connection before using
        if (!isConnectionValid()) {
            logger.error("Database connection is not valid for checking existence of: {}", educationName);
            throw new IllegalStateException("Database connection is closed or invalid."); //phuong thuc goi vao luc doi tuong dang o trang thai khong hop le
        }
        //Using
        try (PreparedStatement stmt = connection.prepareStatement(SEARCH_BY_EDUCATION_NAME)){
             //create an object contains SQL query for executing SQL + dynamic variables
             //try-with-resources: auto close resources
            stmt.setString(1, educationName);
            try(ResultSet rs = stmt.executeQuery()) {//execute and return a rs contain/store result
                return rs.next();//move to next line in the results, if has --> return True, unless False
            }
        } catch (SQLException e){
            logger.error("Error checking if education exists: {}", educationName, e);
            throw new RuntimeException("Database error while checking education existence for: " + educationName, e);
        }
    }
    public int updateEducation(Object...params){
        // check Connection before using
        if (!isConnectionValid()) {
            logger.error("Database connection is not valid");
            throw new IllegalStateException("Database connection is closed or invalid.");
        }
        //Update
        try ( //try-with-resources: auto close resources
              PreparedStatement stmt = connection.prepareStatement(INSERT_EDUCATION);
              //ResultSet rs = stmt.executeQuery();
        ){
            //gan params to PreparedStatement
            for (int i=0; i<params.length; i++){
                stmt.setObject(i+1, params[i]);
            }
            int affectedRows = stmt.executeUpdate();
            return affectedRows;
        } catch (SQLException e){
            logger.error("Error checking", e);
            throw new RuntimeException("Database error while update education", e);
        }
    }
    public int deleteEducationByName(String name){
        // check Connection before using
        if (!isConnectionValid()) {
            logger.error("Database connection is not valid for checking existence of: {}", name);
            throw new IllegalStateException("Database connection is closed or invalid.");
        }
        //Delete
        try ( //try-with-resources: auto close resources
              PreparedStatement stmt = connection.prepareStatement(DELETE_BY_EDUCATION_NAME)
        ){
            stmt.setString(1, name); //gan xong roi execute
            int affectedRows = stmt.executeUpdate(); //INSERT, UPDATE, DELETE. --> executeUpdate()
            logger.info("Deleted {} education record(s) with name: {}", affectedRows, name);
            return affectedRows;
        } catch (SQLException e){
            logger.error("Error checking if education exists: {}", name, e);
            throw new RuntimeException("Database error while checking education existence for: " + name, e);
        }
    }
    public int countEducationByName(String educationName){
        // check Connection before using
        if (!isConnectionValid()) {
            logger.error("Database connection is not valid for checking existence of: {}", educationName);
            throw new IllegalStateException("Database connection is closed or invalid.");
        }
        //Using
        try ( //try-with-resources: auto close resources
              PreparedStatement stmt = connection.prepareStatement(COUNT_EDUCATION_BY_NAME);
        ){
            stmt.setString(1, educationName);
            try(ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    int count = rs.getInt(1); //// Lấy giá trị cột+dong đầu tiên (là COUNT(*))
                    logger.debug("Found {} record(s) for education '{}'", count, educationName);
                    return count;
                }
                return 0;
            }// resultSet will be auto closed here
        }catch (SQLException e){
            logger.error("Error counting education records for: {}", educationName, e);
            throw new RuntimeException("Database error while counting education records for: " + educationName, e);
        } // stmt will be auto closed here
    }
}
