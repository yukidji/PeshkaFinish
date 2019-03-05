package ru.ufa.peshka.DAO;

import ru.ufa.peshka.entity.Delegation;
import ru.ufa.peshka.entity.FineGroup;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.Set;

public class FineGroupDao implements GenericDao<FineGroup> {
    private Connection connection;
    static String sql;

    @Override
    public void create(FineGroup fineGroup) throws SQLException, ParseException {
        sql = "INSERT INTO fine_group(id, number_stage, fine, cut, id_race_group) VALUES (?, ?, ?, ?, ?)";

        try{
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, fineGroup.getId().toString());
            preparedStatement.setInt(2, fineGroup.getNumberStage());
            preparedStatement.setInt(3, fineGroup.getFine());
            preparedStatement.setString(4, Boolean.toString(fineGroup.getCut()));
            preparedStatement.setString(5, fineGroup.getRaceGroupId().toString());
            preparedStatement.execute();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public FineGroup readById(String id) throws SQLException {
        FineGroup fineGroup = new FineGroup();

        sql = "SELECT * FROM delegation WHERE id = ?;";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            //delegation.setId(id); //???
            fineGroup.setNumberStage(resultSet.getInt(2));
            fineGroup.setFine(resultSet.getInt(3));
            fineGroup.setCut(Boolean.parseBoolean(resultSet.getString(4)));
            //fineGroup.setRaceGroupId(resultSet.getString(5));
            preparedStatement.close();
            resultSet.close();
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return fineGroup;
    }

    @Override
    public void update(FineGroup object) throws SQLException {

    }

    @Override
    public void delete(FineGroup object) throws SQLException {

    }

    @Override
    public Set<FineGroup> getAll() throws SQLException {
        return null;
    }
}
