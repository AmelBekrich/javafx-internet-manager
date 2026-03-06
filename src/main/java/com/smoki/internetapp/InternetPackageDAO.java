package com.smoki.internetapp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class InternetPackageDAO {
    public static void insert(InternetPackage p) {
        String sql = "INSERT INTO users(first_name, last_name, address, speed, bandwidth, contract_length) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection connection = DbConnection.connect();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, p.getFirstName());
            statement.setString(2, p.getLastName());
            statement.setString(3, p.getAddress());
            statement.setInt(4, p.getInternetSpeed());
            statement.setString(5, p.getBandwidth());
            statement.setInt(6, p.getContractLength());

            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static List<InternetPackage> getAll() {
        List<InternetPackage> internetPackageList = new ArrayList<>();
        String sql = "SELECT * FROM users";

        try (Connection connection = DbConnection.connect();
             PreparedStatement preparedStatement = connection.prepareStatement(sql);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                InternetPackage internetPackage = new InternetPackage(
                        resultSet.getInt("id"),
                        resultSet.getString("first_name"),
                        resultSet.getString("last_name"),
                        resultSet.getString("address"),
                        resultSet.getInt("speed"),
                        resultSet.getString("bandwidth"),
                        resultSet.getInt("contract_length")
                );
                internetPackageList.add(internetPackage);
            }
            return internetPackageList;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return internetPackageList;
    }

    public static void delete(int id) {
        String sql = "DELETE FROM users WHERE id=?";

        try (Connection connection = DbConnection.connect();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
