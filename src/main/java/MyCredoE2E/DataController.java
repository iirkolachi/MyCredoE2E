package MyCredoE2E;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DataController {
    public static String query_getPersonId = """
            USE CredoBnk
            SELECT
            	*
            FROM dbo.TBL_Person (NOLOCK)
            WHERE PersonalN = '18425315444'
            """;

    public static String query_getToken = """
            EXEC CredoBnk.dbo.GetSystemAuthorizationToken
            """;

    public static String query_getCardName = """
            """;

    //take person id
    public int personId() throws SQLException {
    Connection databaseAccessSQL = DBAccessSQL.getConnection();
    ResultSet result = null;
    PreparedStatement preparedStatement = databaseAccessSQL.prepareStatement(query_getPersonId);
    int personId = 0;
    result = preparedStatement.executeQuery();
    while (result.next()) {
        personId = Integer.parseInt(result.getString("Id"));
    }
    return personId;
}
    //generate token
    public String accessToken() throws SQLException {
        Connection databaseAccessSQL = DBAccessSQL.getConnection();
        ResultSet result = null;
        PreparedStatement preparedStatement = databaseAccessSQL.prepareStatement(query_getToken);
        String accessToken = "";
        result = preparedStatement.executeQuery();
        while (result.next()) {
            accessToken = result.getString("Token");
        }
        return accessToken;

    }
}
