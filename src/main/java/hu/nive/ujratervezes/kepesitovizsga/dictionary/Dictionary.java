package hu.nive.ujratervezes.kepesitovizsga.dictionary;

import org.mariadb.jdbc.MariaDbDataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Dictionary {

    private MariaDbDataSource dataSource;

    public Dictionary(MariaDbDataSource dataSource) {
        this.dataSource = dataSource;
    }

    public String getEnglishWord(String hungarianWord) {
        try (Connection conn = dataSource.getConnection();
             PreparedStatement stmt = conn.prepareStatement("select angol from words where magyar = ?;")) {
            stmt.setString(1, hungarianWord);

            return getWord(stmt);

        } catch (SQLException sqle) {
            throw new IllegalStateException("Can not get word from database.", sqle);
        }
    }

    public String getHungarianWord(String englishWord) {
        try (Connection conn = dataSource.getConnection();
             PreparedStatement stmt = conn.prepareStatement("select magyar from words where angol = ?;")) {
            stmt.setString(1, englishWord);

            return getWord(stmt);

        } catch (SQLException sqle) {
            throw new IllegalStateException("Can not get word from database.", sqle);
        }
    }

    private String getWord(PreparedStatement stmt) throws SQLException {
        try (ResultSet rs = stmt.executeQuery()) {
            if (rs.next()) {
                return rs.getString(1);
            }
        }
        throw new IllegalArgumentException("No such word in dictionary.");
    }
}
