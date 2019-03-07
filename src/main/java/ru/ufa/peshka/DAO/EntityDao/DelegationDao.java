package ru.ufa.peshka.DAO.EntityDao;

import ru.ufa.peshka.DAO.AbstractDao;
import ru.ufa.peshka.entity.Delegation;
import ru.ufa.peshka.entity.Participant;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

public class DelegationDao extends AbstractDao<Delegation> {

    public DelegationDao() {
        super.sqlInsert = "INSERT INTO delegation(id, name, place, first_name_cap, last_name_cap, patronymic_cap, phone_captain, sum_participant, arrive_date) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        super.sqlSelect = "SELECT * FROM delegation WHERE id = ?";
        super.sqlUpdate = "UPDATE delegation SET name = ?, place = ?, first_name_cap = ?, last_name_cap = ?, patronymic_cap = ?, phone_captain = ?, sum_participant = ?, arrive_date = ? WHERE id = ?";
        super.sqlDelete = "DELETE FROM delegation WHERE id = ?";
    }

    @Override
    public void mappingInsert(PreparedStatement preparedStatement, Delegation delegation) throws SQLException {
        preparedStatement.setString(1, delegation.getId().toString());
        preparedStatement.setString(2, delegation.getName());
        preparedStatement.setString(3, delegation.getPlace());
        preparedStatement.setString(4, delegation.getFirstName());
        preparedStatement.setString(5, delegation.getLastName());
        preparedStatement.setString(6, delegation.getPatronymic());
        preparedStatement.setString(7, delegation.getPhoneCaptain());
        preparedStatement.setInt(8, delegation.getSumParticipant());
        preparedStatement.setDate(9,delegation.getArriveDate() == null ? null : new java.sql.Date(delegation.getArriveDate().getTime()));
    }

    @Override
    public void mappingSelect(PreparedStatement preparedStatement, Delegation delegation, ResultSet resultSet, String id) throws SQLException {
        delegation.setId(UUID.fromString(resultSet.getString(id)));
        delegation.setName(resultSet.getString(2));
        delegation.setPlace(resultSet.getString(3));
        delegation.setFirstName(resultSet.getString(4));
        delegation.setLastName(resultSet.getString(5));
        delegation.setPatronymic(resultSet.getString(6));
        delegation.setPhoneCaptain(resultSet.getString(7));
        delegation.setSumParticipant(resultSet.getInt(8));
        delegation.setArriveDate(resultSet.getDate(9));
    }

    @Override
    public void mappingUpdate(PreparedStatement preparedStatement, Delegation delegation) throws SQLException {
        preparedStatement.setString(1, delegation.getName());
        preparedStatement.setString(2, delegation.getPlace());
        preparedStatement.setString(3, delegation.getFirstName());
        preparedStatement.setString(4, delegation.getLastName());
        preparedStatement.setString(5, delegation.getPatronymic());
        preparedStatement.setString(6, delegation.getPhoneCaptain());
        preparedStatement.setInt(7, delegation.getSumParticipant());
        preparedStatement.setDate(8,delegation.getArriveDate() == null ? null : new java.sql.Date(delegation.getArriveDate().getTime()));
        preparedStatement.setString(9, delegation.getId().toString());
    }

    @Override
    public void mappingDelete(PreparedStatement preparedStatement, Delegation delegation) throws SQLException {
        preparedStatement.setString(1,delegation.getId().toString());
    }

    /**
    @Override
    public Set<Delegation> getAll() throws SQLException {
        Set<Delegation> delegations = new HashSet<>();

        sql = "SELECT * FROM delegation";

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
                statement.close();
                resultSet.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return delegations;
    }
    */
}