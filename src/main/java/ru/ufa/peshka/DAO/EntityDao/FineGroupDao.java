package ru.ufa.peshka.DAO.EntityDao;

import org.apache.log4j.Logger;
import ru.ufa.peshka.DAO.AbstractDao;
import ru.ufa.peshka.entity.Enum.Cut;
import ru.ufa.peshka.entity.FineGroup;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Set;
import java.util.UUID;


public class FineGroupDao extends AbstractDao <FineGroup> {

    public FineGroupDao() {
        super.sqlInsert = "INSERT INTO fine_group(id, number_stage, fine, cut, id_race_group) VALUES (?, ?, ?, ?, ?)";
        super.sqlSelect = "SELECT * FROM fine_group WHERE id = ?";
        super.sqlUpdate = "UPDATE fine_group SET number_stage = ?, fine = ?, cut = ?, id_race_group = ? WHERE id = ?";
        super.sqlDelete = "DELETE FROM fine_group WHERE id = ?";
        super.sqlSelectAll = "SELECT * FROM fine_group";
    }

    private static Logger logger = Logger.getLogger(FineGroupDao.class.getName());

    //create
    @Override
    public void mappingInsert(PreparedStatement preparedStatement, FineGroup fineGroup) throws SQLException {
        preparedStatement.setString(1, fineGroup.getId().toString());
        if (fineGroup.getNumberStage() < 1) logger.debug("not NumberStage");
        else preparedStatement.setInt(2, fineGroup.getNumberStage());
        preparedStatement.setInt(3, fineGroup.getFine());
        preparedStatement.setString(4, fineGroup.getCut().toString());
        preparedStatement.setString(5, fineGroup.getRaceGroupId().toString());
    }

    //update
    @Override
    public void mappingUpdate(PreparedStatement preparedStatement, FineGroup fineGroup) throws SQLException {
        preparedStatement.setInt(1, fineGroup.getNumberStage());
        preparedStatement.setInt(2, fineGroup.getFine());
        preparedStatement.setString(3, fineGroup.getCut().toString());
        preparedStatement.setString(4, fineGroup.getRaceGroupId().toString());
        preparedStatement.setString(5, fineGroup.getId().toString());
    }

    //delete
    @Override
    public void mappingDelete(PreparedStatement preparedStatement, FineGroup fineGroup) throws SQLException {
        preparedStatement.setString(1, fineGroup.getId().toString());
    }

    //readByKey
    @Override
    public void mappingSelect(FineGroup fineGroup, ResultSet resultSet) throws SQLException {
        fineGroup.setId(UUID.fromString(resultSet.getString(1)));
        fineGroup.setNumberStage(resultSet.getInt(2));
        fineGroup.setFine(resultSet.getInt(3));
        fineGroup.setCut(Cut.valueOf(resultSet.getString(4)));
        fineGroup.setRaceGroupId(UUID.fromString(resultSet.getString(5)));
    }

    //readAll
    @Override
    public void mappingSelectAll(FineGroup fineGroup, Set<FineGroup> sets, ResultSet resultSet) throws SQLException {
        while (resultSet.next()){
            fineGroup = new FineGroup();
            mappingSelect(fineGroup,resultSet);
            sets.add(fineGroup);
        }
    }
}