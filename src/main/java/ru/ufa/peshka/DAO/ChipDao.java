package ru.ufa.peshka.DAO;

import ru.ufa.peshka.entity.Chip;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.util.HashSet;
import java.util.Set;

public class ChipDao implements GenericDao <Chip> {
private Connection connection;
static String sql;

    @Override
    public void create(Chip chip) throws SQLException, ParseException {
        sql = "INSERT INTO chip(id, status) VALUES (?, ?)";

        try{
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, chip.getId().toString());
            preparedStatement.setString(2,  Boolean.toString(chip.getStatus()));
            preparedStatement.execute();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Chip readById(String id) throws SQLException {
        Chip chip= new Chip();

        sql = "SELECT * FROM chip WHERE id = ?;";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            //chip.setId(id); //???
            chip.setStatus(Boolean.parseBoolean(resultSet.getString("status")));
            preparedStatement.close();
            resultSet.close();
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return chip;
    }

    @Override
    public void update(Chip chip) throws SQLException {
        sql = "UPDATE chip SET status= ? WHERE id = ?";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, Boolean.toString(chip.getStatus()));
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Chip chip) throws SQLException {
        sql = "DELETE FROM chip WHERE id = ?";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,chip.getId().toString());
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public Set<Chip> getAll() throws SQLException {
        Set<Chip> chips = new HashSet<>();

        sql = "SELECT * FROM chip";

        try{
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()){
                Chip chip = new Chip();
                //delegation.setId();
                chip.setStatus(Boolean.parseBoolean(resultSet.getString(2)));
                chips.add(chip);
                statement.close();
                resultSet.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return chips;
    }
}
