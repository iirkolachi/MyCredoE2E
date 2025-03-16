package MyCredoE2E;

import MyCredoE2E.Elements.ProductPageElements;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DataController {
    public static String query_getPersonalN = """
            USE IBankUsermanagement
            SELECT
            	P.PersonalNumber
            FROM auth.Persons P
            INNER JOIN auth.UserLogins U
            ON P.Id = U.PersonId
            WHERE U.Login = 'iilo2020'
            """;

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
            EXEC CredoBnk.card.spcardlist @personid = ?
            """;

    //get personal number
//    public int personalN() throws SQLException {
//        Connection databaseAccessSQL = DBAccessSQL.getConnection244();
//        System.out.println(databaseAccessSQL.getSchema());
//        ResultSet result = null;
//        PreparedStatement preparedStatement = databaseAccessSQL.prepareStatement(query_getPersonalN);
//        int personalN = 0;
//        result = preparedStatement.executeQuery();
//        while (result.next()) {
//            personalN = Integer.parseInt(result.getString("PersonalNumber"));
//        }
//        return personalN;
//    }

    //get person id
    public int personId() throws SQLException {
    Connection databaseAccessSQL = DBAccessSQL.getConnection247();
    ResultSet result = null;
    //int personalN = personalN();
    PreparedStatement preparedStatement = databaseAccessSQL.prepareStatement(query_getPersonId);
    //preparedStatement.setInt(1, personalN);
    int personId = 0;
    result = preparedStatement.executeQuery();
    while (result.next()) {
        personId = Integer.parseInt(result.getString("Id"));
    }
    return personId;
}
    //generate token
    public String accessToken() throws SQLException {
        Connection databaseAccessSQL = DBAccessSQL.getConnection247();
        ResultSet result = null;
        PreparedStatement preparedStatement = databaseAccessSQL.prepareStatement(query_getToken);
        String accessToken = "";
        result = preparedStatement.executeQuery();
        while (result.next()) {
            accessToken = result.getString("Token");
        }
        return accessToken;

    }

    //get card name
    public String cardName() throws SQLException {
        ProductPageElements productPageElements = new ProductPageElements();
        Connection databaseAccessSQL = DBAccessSQL.getConnection247();
        ResultSet result = null;
        int personId = personId();
        PreparedStatement preparedStatement = databaseAccessSQL.prepareStatement(query_getCardName);
        preparedStatement.setInt(1, personId);
        String cardName = "";
        result = preparedStatement.executeQuery();
        while (result.next()) {
           String accountNumber = result.getString("AccountNumber");
            if (accountNumber.equals(productPageElements.accNumber.getText())) {
                cardName = result.getString("CardNickName");
            }
        }
        return cardName;
    }
}
