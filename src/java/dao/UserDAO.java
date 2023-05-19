package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import obj.User;
import utils.DBUtils;


public class UserDAO {

    private static final Logger LOGGER = Logger.getLogger(UserDAO.class.getName());

    private static final String GET_USER_QUERY = "SELECT * FROM [User] "
            + "WHERE userID = ? AND password = ? COLLATE Latin1_General_CS_AS";

    private static final String GET_USERS_QUERY = "SELECT * From [USER]";

    private static final String IS_USER_EXIST_QUERY = "SELECT * FROM [User] "
            + "WHERE userID = ? COLLATE Latin1_General_CS_AS";

    public static final User getUser(String userID, String password) {

        try (
                Connection connection = DBUtils.getConnection();
        ) {
            connection.setTransactionIsolation(Connection.TRANSACTION_READ_COMMITTED);

            try (
                    PreparedStatement statement = connection.prepareStatement(
                        GET_USER_QUERY,
                        ResultSet.TYPE_SCROLL_INSENSITIVE,
                        ResultSet.CONCUR_READ_ONLY);
            ) {
                statement.setString(1, userID);
                statement.setString(2, password);
                ResultSet result = statement.executeQuery();

                if (result.next() && !result.isLast()) {
                    throw new SQLException("Duplicate user");
                }

                return new User(result.getString("userID"),
                        result.getString("fullName"),
                        result.getString("roleID"),
                        result.getString("password")
                );
            } catch (Exception e) {
                LOGGER.log(Level.SEVERE, e.getMessage());
            }
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, e.getMessage());
        }

        return null;
    }

    public static final ArrayList<User> getUsers() {

        try (
                Connection connection = DBUtils.getConnection();
        ) {
            connection.setTransactionIsolation(Connection.TRANSACTION_READ_COMMITTED);

            try (
                    PreparedStatement statement = connection.prepareStatement(
                        GET_USERS_QUERY,
                        ResultSet.TYPE_SCROLL_INSENSITIVE,
                        ResultSet.CONCUR_READ_ONLY);
            ) {
                ResultSet result = statement.executeQuery();
                ArrayList<User> users = new ArrayList<>();

                while (result.next()) {
                    users.add(new User(
                            result.getString("userID"),
                            result.getString("fullName"),
                            result.getString("roleID"),
                            result.getString("password")
                    ));
                }

                return users;
            } catch (Exception e) {
                LOGGER.log(Level.SEVERE, e.getMessage());
            }
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, e.getMessage());
        }

        return null;
    }

    public static final boolean isUserExist(String userID) {

        try (
                Connection connection = DBUtils.getConnection();
        ) {
            connection.setTransactionIsolation(Connection.TRANSACTION_READ_COMMITTED);

            try (
                    PreparedStatement statement = connection.prepareStatement(
                            IS_USER_EXIST_QUERY,
                            ResultSet.TYPE_SCROLL_SENSITIVE,
                            ResultSet.CONCUR_READ_ONLY
                    );
            ) {
                statement.setString(1, userID);
                ResultSet result = statement.executeQuery();
                return result.next();
            } catch (Exception e) {
                LOGGER.log(Level.SEVERE, e.getMessage());
            }
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, e.getMessage());
        }

        return false;
    }
}
