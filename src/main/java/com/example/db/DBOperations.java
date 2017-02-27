package com.example.db;


import java.sql.*;

public class DBOperations {


    public int getLastKey() throws Exception {

        final Connection connection = Database.getConnection();
        final Statement statement = connection.createStatement();
        final ResultSet resultSet = statement.executeQuery("SELECT MAX(id) FROM shortner");

        while (resultSet.next()) {
            return resultSet.getInt(1);
        }

        connection.close();
        return 0;
    }

    public boolean isUrlPresent(String url) throws Exception {
        final Connection connection = Database.getConnection();
        final Statement statement = connection.createStatement();
        final ResultSet resultSet = statement.executeQuery("SELECT COUNT(*) FROM shortner WHERE url = '" +  url + "'");

        while (resultSet.next()) {
            return resultSet.getInt(1) == 1;
        }

        connection.close();

        return false;
    }


    public String getShortUrl(String url) throws Exception {
        final Connection connection = Database.getConnection();
        final Statement statement = connection.createStatement();
        final ResultSet resultSet = statement.executeQuery("SELECT shorturl FROM shortner WHERE url = '" +  url + "'");

        String shortUrl = null;

        if (resultSet.next()) {
            shortUrl = resultSet.getString(1);
        }
        return shortUrl;
    }


    public String getUrl(String shortURL) throws Exception {
        final Connection connection = Database.getConnection();
        final Statement statement = connection.createStatement();
        final ResultSet resultSet = statement.executeQuery("SELECT url FROM shortner WHERE shorturl = '" +  shortURL + "'");

        String shortUrl = null;

        if (resultSet.next()) {
            shortUrl = resultSet.getString(1);
        }
        return shortUrl;
    }

    public static void main(String[] args) throws Exception {

        final Connection connection = Database.getConnection();
        final Statement statement = connection.createStatement();
        String url = "http://foo.com";
        String shortUrl = "kjhkfd ";
        System.out.println(url + "::" + shortUrl);
        String query = "INSERT INTO shortner(url, shorturl) VALUES(?, ?)";

        // create the mysql insert preparedstatement
        PreparedStatement preparedStmt = connection.prepareStatement(query);

        preparedStmt.setString(1, url);
        preparedStmt.setString(2, shortUrl);

        preparedStmt.execute();

        connection.close();
    }

    public void saveUrl(String url, String shortUrl) throws Exception {
        final Connection connection = Database.getConnection();
        final Statement statement = connection.createStatement();

        System.out.println(url + "::" + shortUrl);
        String query = "INSERT INTO shortner(url, shorturl) VALUES(?, ?)";

        // create the mysql insert preparedstatement
        PreparedStatement preparedStmt = connection.prepareStatement(query);

        preparedStmt.setString(1, url);
        preparedStmt.setString(2, shortUrl);

        preparedStmt.execute();

        connection.close();
    }
}
