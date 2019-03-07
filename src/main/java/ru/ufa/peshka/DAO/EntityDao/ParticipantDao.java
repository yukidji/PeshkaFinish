package ru.ufa.peshka.DAO.EntityDao;

import ru.ufa.peshka.DAO.AbstractDao;
import ru.ufa.peshka.entity.Enum.Gender;
import ru.ufa.peshka.entity.Enum.Rank;
import ru.ufa.peshka.entity.Participant;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

public class ParticipantDao extends AbstractDao<Participant> {

    public ParticipantDao() {
        super.sqlInsert = "INSERT INTO participant (id, first_name, last_name, patronymic, age, gender, rank, id_delegation, id_race_group, id_race_twain, id_chip) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        super.sqlSelect = "SELECT * FROM participant WHERE id = ?";
        super.sqlUpdate = "UPDATE participant SET first_name = ?, last_name = ?, patronymic = ?, age = ?, gender = ?, rank = ?, id_delegation = ?, id_race_group = ?, id_race_twain = ?, id_chip = ? WHERE id = ?";
        super.sqlDelete = "DELETE FROM participant WHERE id = ?";
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
    }

    @Override
    public void mappingSelect(PreparedStatement preparedStatement, Participant participant, ResultSet resultSet, String id) throws SQLException {
        participant.setId(UUID.fromString(resultSet.getString(id)));
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
    public void mappingUpdate(PreparedStatement preparedStatement, Participant participant) throws SQLException {
        preparedStatement.setString(1, participant.getFirstName());
        preparedStatement.setString(2, participant.getLastName());
        preparedStatement.setString(3, participant.getPatronymic());
        preparedStatement.setInt(4, participant.getAge());
        preparedStatement.setString(5, participant.getGender().toString());
        preparedStatement.setString(6, participant.getRank().toString());
        preparedStatement.setString(7, participant.getDelegationId().toString());
        preparedStatement.setString(8, participant.getRaceGroupId().toString());
        preparedStatement.setString(9, participant.getRaceTwainId().toString());
        preparedStatement.setString(10, participant.getChipId().toString());
        preparedStatement.setString(11, participant.getChipId().toString());
    }

    @Override
    public void mappingDelete(PreparedStatement preparedStatement, Participant participant) throws SQLException {
        preparedStatement.setString(1,participant.getId().toString());
    }
}
