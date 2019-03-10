package ru.ufa.peshka.DAO.EntityDao;

import org.apache.commons.lang.ObjectUtils;
import ru.ufa.peshka.DAO.AbstractDao;
import ru.ufa.peshka.entity.Enum.Gender;
import ru.ufa.peshka.entity.Enum.Rank;
import ru.ufa.peshka.entity.Participant;

import java.lang.reflect.Type;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Set;
import java.util.UUID;

public class ParticipantDao extends AbstractDao<Participant> {

    public ParticipantDao() {
        super.sqlInsert = "INSERT INTO participant (id, first_name, last_name, patronymic, age, " +
                "gender, rank_p, id_delegation, id_race_group, id_race_twain, id_chip) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        super.sqlSelect = "SELECT * FROM participant WHERE id = ?";
        super.sqlUpdate = "UPDATE participant SET first_name = ?, last_name = ?, patronymic = ?, age = ?, gender = ?, rank_p = ?, id_delegation = ?, id_race_group = ?, id_race_twain = ?, id_chip = ? WHERE id = ?";
        super.sqlDelete = "DELETE FROM participant WHERE id = ?";
        super.sqlSelectAll = "SELECT * FROM participant";
    }

    //create
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
            if (participant.getRaceGroupId() != null)
            preparedStatement.setString(9, participant.getRaceGroupId().toString());
            else  preparedStatement.setNull(9, Types.VARCHAR);
            if (participant.getRaceTwainId() != null)
            preparedStatement.setString(10, participant.getRaceTwainId().toString());
            else preparedStatement.setNull(10, Types.VARCHAR);;
            if (participant.getChipId() != null)
            preparedStatement.setString(11, participant.getChipId().toString());
            else  preparedStatement.setNull(11, Types.VARCHAR);
    }

    //update
    @Override
    public void mappingUpdate(PreparedStatement preparedStatement, Participant participant) throws SQLException {
        preparedStatement.setString(1, participant.getFirstName());
        preparedStatement.setString(2, participant.getLastName());
        preparedStatement.setString(3, participant.getPatronymic());
        preparedStatement.setInt(4, participant.getAge());
        preparedStatement.setString(5, participant.getGender().toString());
        preparedStatement.setString(6, participant.getRank().toString());
        preparedStatement.setString(7, participant.getDelegationId().toString());
        if (participant.getRaceGroupId() != null)
            preparedStatement.setString(8, participant.getRaceGroupId().toString());
        else  preparedStatement.setNull(8, Types.VARCHAR);
        if (participant.getRaceTwainId() != null)
            preparedStatement.setString(9, participant.getRaceTwainId().toString());
        else preparedStatement.setNull(9, Types.VARCHAR);;
        if (participant.getChipId() != null)
            preparedStatement.setString(10, participant.getChipId().toString());
        else  preparedStatement.setNull(10, Types.VARCHAR);
        preparedStatement.setString(11, participant.getId().toString());
    }

    //delete
    @Override
    public void mappingDelete(PreparedStatement preparedStatement, Participant participant) throws SQLException {
        preparedStatement.setString(1,participant.getId().toString());
    }

    //readByKey
    @Override
    public void mappingSelect(Participant participant, ResultSet resultSet) throws SQLException {
        participant.setId(UUID.fromString(resultSet.getString(1)));
        participant.setFirstName(resultSet.getString(2));
        participant.setLastName(resultSet.getString(3));
        participant.setPatronymic(resultSet.getString(4));
        participant.setAge(resultSet.getInt(5));
        participant.setGender(Gender.valueOf(resultSet.getString(6)));
        participant.setRank(Rank.valueOf(resultSet.getString(7)));
        participant.setDelegationId(UUID.fromString(resultSet.getString(8)));
        if(resultSet.getString(9) == null) participant.setRaceGroupId(null);
        else participant.setRaceGroupId(UUID.fromString(resultSet.getString(9)));
        if(resultSet.getString(10) == null) participant.setRaceTwainId(null);
        else participant.setRaceTwainId(UUID.fromString(resultSet.getString(10)));
        if(resultSet.getString(11) == null) participant.setChipId(null);
        else participant.setChipId(UUID.fromString(resultSet.getString(11)));
    }

    //getAll
    @Override
    public void mappingSelectAll(Participant participant, Set<Participant> sets, ResultSet resultSet) throws SQLException {
        while (resultSet.next()){
            participant = new Participant();
            mappingSelect(participant, resultSet);
            sets.add(participant);
        }
    }
}
