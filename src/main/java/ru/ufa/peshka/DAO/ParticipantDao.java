package ru.ufa.peshka.DAO;

import ru.ufa.peshka.entity.Enum.Gender;
import ru.ufa.peshka.entity.Enum.Rank;
import ru.ufa.peshka.entity.Participant;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

public class ParticipantDao extends AbstractDao<Participant> {

    String sqlInsert = "INSERT INTO participant (id, first_name, last_name, patronymic, age, gender, rank, id_delegation, id_race_group, id_race_twain, id_chip) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
    String sqlSelect = "SELECT * FROM participant WHERE id = ?";
    String sqlUpdate = "UPDATE participant SET first_name = ?, last_name = ?, patronymic = ?, age = ?, gender = ?, rank = ?, id_delegation = ?, id_race_group = ?, id_race_twain = ?, id_chip = ? WHERE id = ?";
    String sqlDelete = "DELETE FROM participant WHERE id = ?";

    public ParticipantDao(Connection connection) {
        super(connection);
    }

    @Override
    public String getSQL(String param) {
        if (param.equals("INSERT")) return sqlInsert;
        if (param.equals("SELECT")) return sqlSelect;
        if (param.equals("UPDATE")) return sqlUpdate;
        if (param.equals("DELETE")) return sqlDelete;
        else {
            return null;
        }
    }

    @Override
    public void mappingInsert(PreparedStatement preparedStatement, Participant participant) throws SQLException {
            preparedStatement.setString(1, participant.getId().toString());
            preparedStatement.setString(2, participant.getFirstName());
            preparedStatement.setString(3, participant.getLastName());
            preparedStatement.setString(4, participant.getPatronymic());
            preparedStatement.setInt(5, participant.getAge());
            preparedStatement.setString(6, participant.getGender().toString());
            preparedStatement.setString(7, participant.getRank().toString());
            preparedStatement.setString(8, participant.getDelegationId().toString());
            preparedStatement.setString(9, participant.getRaceGroupId().toString());
            preparedStatement.setString(10, participant.getRaceTwainId().toString());
            preparedStatement.setString(11, participant.getChipId().toString());
            preparedStatement.execute();
    }

    @Override
    public void mappingSelect(PreparedStatement preparedStatement, Participant participant, ResultSet resultSet) throws SQLException {
        //participant.setId(UUID.fromString(resultSet.getString(id)));
        participant.setFirstName(resultSet.getString(2));
        participant.setLastName(resultSet.getString(3));
        participant.setPatronymic(resultSet.getString(4));
        participant.setAge(resultSet.getInt(5));
        participant.setGender(Gender.valueOf(resultSet.getString(6)));
        participant.setRank(Rank.valueOf(resultSet.getString(7)));
        participant.setDelegationId(UUID.fromString(resultSet.getString(8)));
        participant.setRaceGroupId(UUID.fromString(resultSet.getString(9)));
        participant.setRaceTwainId(UUID.fromString(resultSet.getString(10)));
        participant.setChipId(UUID.fromString(resultSet.getString(11)));
    }

    @Override
    public Participant mappingUpdate(PreparedStatement preparedStatement, Participant participant) {
        return null;
    }

    @Override
    public Participant mappingDelete(PreparedStatement preparedStatement, Participant participant) {
        return null;
    }
}
