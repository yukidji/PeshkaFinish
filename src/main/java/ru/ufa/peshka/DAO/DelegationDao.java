package ru.ufa.peshka.DAO;

import ru.ufa.peshka.entity.Delegation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.util.HashSet;
import java.util.Set;

public class DelegationDao implements GenericDao<Delegation>{
private Connection connection;

    public DelegationDao (Connection connection){
        this.connection = connection;
    }

    //create создание новой записи в БД
    @Override
    public void create(Delegation delegation) throws SQLException, ParseException {
        String sql = "INSERT INTO delegation(id, name, place, first_name_cap, last_name_cap, patronymic_cap, phone_captain, sum_participant, arrive_date) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try{
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, delegation.getId().toString());
            preparedStatement.setString(2, delegation.getName());
            preparedStatement.setString(3, delegation.getPlace());
            preparedStatement.setString(4, delegation.getFirstName());
            preparedStatement.setString(5, delegation.getLastName());
            preparedStatement.setString(6, delegation.getPatronymic());
            preparedStatement.setString(7, delegation.getPhoneCaptain());
            preparedStatement.setInt(8, delegation.getSumParticipant());
            preparedStatement.setDate(9,delegation.getArriveDate() == null ? null : new java.sql.Date(delegation.getArriveDate().getTime()));
            preparedStatement.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //read переделать. Пока не знаю как
    @Override
    public Delegation readById(String id) throws SQLException{
        Delegation delegation = new Delegation();

        String sql = "SELECT * FROM delegation WHERE id = ?;";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            //delegation.setId(id); //???
            delegation.setName(resultSet.getString("name"));
            delegation.setPlace(resultSet.getString("place"));
            delegation.setFirstName(resultSet.getString("first_name_cap"));
            delegation.setLastName(resultSet.getString("last_name_cap"));
            delegation.setPatronymic(resultSet.getString("patronymic"));
            delegation.setPhoneCaptain(resultSet.getString("phone_captain"));
            delegation.setSumParticipant(resultSet.getInt("sum_participant"));
            delegation.setArriveDate(resultSet.getDate("arrive_date"));
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return delegation;
    }

    @Override
    public void update(Delegation delegation) throws SQLException {

        String sql = "UPDATE delegation SET name = ?, place = ?, first_name_cap = ?, last_name_cap = ?, patronymic_cap = ?, phone_captain = ?, sum_participant = ?, arrive_date = ? WHERE id = ?";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, delegation.getName());
            preparedStatement.setString(2, delegation.getPlace());
            preparedStatement.setString(3, delegation.getFirstName());
            preparedStatement.setString(4, delegation.getLastName());
            preparedStatement.setString(5, delegation.getPatronymic());
            preparedStatement.setString(6, delegation.getPhoneCaptain());
            preparedStatement.setInt(7, delegation.getSumParticipant());
            preparedStatement.setDate(8,delegation.getArriveDate() == null ? null : new java.sql.Date(delegation.getArriveDate().getTime()));
            preparedStatement.setString(9, delegation.getId().toString());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Delegation delegation) throws SQLException {

        String sql = "DELETE FROM delegation WHERE id = ?";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,delegation.getId().toString());
            preparedStatement.executeUpdate();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public Set<Delegation> getAll() throws SQLException {
        Set<Delegation> delegations = new HashSet<>();

        String sql = "SELECT * FROM delegation";

        try{
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()){
                Delegation delegation = new Delegation();
                //delegation.setId();
                delegation.setName(resultSet.getString(2));
                delegation.setPlace(resultSet.getString(3));
                delegation.setFirstName(resultSet.getString(4));
                delegation.setLastName(resultSet.getString(5));
                delegation.setPatronymic(resultSet.getString(6));
                delegation.setPhoneCaptain(resultSet.getString(7));
                delegation.setSumParticipant(resultSet.getInt(8));
                delegation.setArriveDate(resultSet.getDate(9));
                delegations.add(delegation);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return delegations;
    }
}