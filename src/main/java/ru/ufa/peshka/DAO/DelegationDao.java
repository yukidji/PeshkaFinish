package ru.ufa.peshka.DAO;

import ru.ufa.peshka.entity.Delegation;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;

public class DelegationDao implements DelegationDaoInterface{
private Connection connection;

public DelegationDao (Connection connection){
    this.connection = connection;
}

    //create создание новой записи в БД
    @Override
    public Delegation create() throws SQLException, ParseException {
        PreparedStatement preparedStatement = null;
        Delegation delegation = new Delegation();

        String sql = "INSERT INTO delegation(id, name, place, first_name_cap, last_name_cap, patronymic_cap, phone_captain, sum_participant, arrive_date) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try{
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, delegation.getId().toString());
            preparedStatement.setString(2, delegation.getName());
            preparedStatement.setString(3, delegation.getPlace());
            preparedStatement.setString(4, delegation.getFirstName());
            preparedStatement.setString(5, delegation.getLastName());
            preparedStatement.setString(6, delegation.getPatronymic());
            preparedStatement.setString(7, delegation.getPhoneCaptain());
            preparedStatement.setInt(8, delegation.getSumParticipant());
            if(delegation.getArriveDate() == null){
                preparedStatement.setDate(9,null);
            } else {
                preparedStatement.setDate(9, new java.sql.Date(delegation.getArriveDate().getTime()));
            }
            preparedStatement.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (preparedStatement != null){
                preparedStatement.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
        return null;
    }

    //read переделать. Пока не знаю как
    @Override
    public Delegation readById(UUID id) throws SQLException{
        PreparedStatement preparedStatement = null;
        Delegation delegation = new Delegation();

        String idString = id.toString();
        String sql = "SELECT * FROM delegation WHERE id = ?;";

        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, idString);

        ResultSet resultSet = preparedStatement.executeQuery();
        resultSet.next();

        delegation.setId(id);
        delegation.setName(resultSet.getString("name"));
        delegation.setPlace(resultSet.getString("place"));
        delegation.setFirstName(resultSet.getString("first_name_cap"));
        delegation.setLastName(resultSet.getString("last_name_cap"));
        delegation.setPatronymic(resultSet.getString("patronymic"));
        delegation.setPhoneCaptain(resultSet.getString("phone_captain"));
        delegation.setSumParticipant(resultSet.getInt("sum_participant"));
        delegation.setArriveDate(resultSet.getDate("arrive_date"));

        return delegation;
    }

    @Override
    public void update(Delegation delegation) {

    }

    @Override
    public void delete(Delegation delegation) {

    }

    @Override
    public List<Delegation> getAll() throws SQLException {
        List<Delegation> delegations = new ArrayList<>();
        Statement statement = null;
        ResultSet resultSet = null;
        Delegation delegation = new Delegation();

        String sql = "SELECT * FROM delegation";

        try{
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);

            while (resultSet.next()){
                //delegation.setId(); //не знаю как состыковать string и UUID (id d БД хранится как строка)
                delegation.setName(resultSet.getString(2));
                delegation.setPlace(resultSet.getString(3));
                delegation.setFirstName(resultSet.getString(4));
                delegation.setLastName(resultSet.getString(5));
                delegation.setPatronymic(resultSet.getString(6));
                delegation.setPhoneCaptain(resultSet.getString(7));
                delegation.setSumParticipant(resultSet.getInt(8));
                //delegation.getArriveDate(new java.util.Date(resultSet.getDate(9).getTime()));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (statement != null){
                statement.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
        return delegations;
    }
}
