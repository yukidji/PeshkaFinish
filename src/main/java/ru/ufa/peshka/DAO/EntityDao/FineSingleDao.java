package ru.ufa.peshka.DAO.EntityDao;

import org.apache.log4j.Logger;
import ru.ufa.peshka.DAO.AbstractDao;
import ru.ufa.peshka.entity.Enum.Cut;
import ru.ufa.peshka.entity.FineSingle;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Set;
import java.util.UUID;

public class FineSingleDao extends AbstractDao<FineSingle> {
    public FineSingleDao() {
        super.sqlInsert = "INSERT INTO fine_single(id, number_stage, fine, cut, id_race_single) VALUES (?, ?, ?, ?, ?)";
        super.sqlSelect = "SELECT * FROM fine_single WHERE id = ?";
        super.sqlUpdate = "UPDATE fine_single SET number_stage = ?, fine = ?, cut = ?, id_race_single = ? WHERE id = ?";
        super.sqlDelete = "DELETE FROM fine_single WHERE id = ?";
        super.sqlSelectAll = "SELECT * FROM fine_single";
    }

    private static Logger logger = Logger.getLogger(FineSingleDao.class.getName());

    //FineSingleDao, FineGroupDao, FineTwainDao код повотряется...
    //create
    @Override
    public void mappingInsert(PreparedStatement preparedStatement, FineSingle fineSingle) throws SQLException {
        preparedStatement.setString(1, fineSingle.getId().toString());
        if (fineSingle.getNumberStage() < 1) logger.debug("not NumberStage");
        else preparedStatement.setInt(2, fineSingle.getNumberStage());
        preparedStatement.setInt(3, fineSingle.getFine());
        preparedStatement.setString(4, fineSingle.getCut().toString());
        preparedStatement.setString(5, fineSingle.getRaceSingleId().toString());
    }

    //update
    @Override
    public void mappingUpdate(PreparedStatement preparedStatement, FineSingle fineSingle) throws SQLException {
        preparedStatement.setInt(1, fineSingle.getNumberStage());
        preparedStatement.setInt(2, fineSingle.getFine());
        preparedStatement.setString(3, fineSingle.getCut().toString());
        preparedStatement.setString(4, fineSingle.getRaceSingleId().toString());
        preparedStatement.setString(5, fineSingle.getId().toString());
    }

    //delete
    @Override
    public void mappingDelete(PreparedStatement preparedStatement, FineSingle fineSingle) throws SQLException {
        preparedStatement.setString(1, fineSingle.getId().toString());
    }

    //readByKey
    @Override
    public void mappingSelect(FineSingle fineSingle, ResultSet resultSet) throws SQLException {
        fineSingle.setId(UUID.fromString(resultSet.getString(1)));
        fineSingle.setNumberStage(resultSet.getInt(2));
        fineSingle.setFine(resultSet.getInt(3));
        fineSingle.setCut(Cut.valueOf(resultSet.getString(4)));
        fineSingle.setRaceSingleId(UUID.fromString(resultSet.getString(5)));
    }

    //readAll
    @Override
    public void mappingSelectAll(FineSingle fineSingle, List<FineSingle> list, ResultSet resultSet) throws SQLException {
        while (resultSet.next()){
            fineSingle = new FineSingle();
            mappingSelect(fineSingle, resultSet);
            list.add(fineSingle);
        }
    }
}
