package ru.ufa.peshka.DAO.EntityDao;

import ru.ufa.peshka.DAO.AbstractDao;
import ru.ufa.peshka.entity.Stage;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

public class StageDao extends AbstractDao<Stage> {

    public String pole = "id";

    public StageDao(){
        super.sqlInsert = "INSERT INTO stage (id, idDistance, number, name, controlTimeMan, controlTimeWomen, length, angle, depth, longLogs, railAngle, supportHeight) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        super.sqlSelect = "SELECT * FROM stage WHERE id = ?";
        super.sqlUpdate = "UPDATE stage SET idDistance = ?, number= ?, name = ?, controlTimeMan = ?, controlTimeWoman = ?, length=?, angle = ?, depth =?, longLogs=?, railAngle=?, supportHeight = ? WHERE id = ?";
        super.sqlDelete = "DELETE FROM stage WHERE id = ?";
        super.sqlSelectAll = "SELECT * FROM stage";
    }

    public String setSqlDelete(String sql, String pole){
        this.sqlDelete = sql;
        return this.pole = pole;
    }

    public String setSqlSelect(String sql, String pole){
        this.sqlSelect = sql;
        return this.pole = pole;
    }

    //create
    @Override
    public void mappingInsert(PreparedStatement preparedStatement, Stage stage) throws SQLException {
        preparedStatement.setString(1, stage.getId().toString());
        preparedStatement.setString(2, stage.getIdDistance().toString());
        preparedStatement.setInt(3, stage.getNumber());
        preparedStatement.setString(4, stage.getName());
        preparedStatement.setString(5, stage.getControlTimeMan());
        preparedStatement.setString(6, stage.getControlTimeWoman());
        preparedStatement.setString(7, stage.getLength());
        preparedStatement.setString(8, stage.getAngle());
        preparedStatement.setString(9, stage.getDepth());
        preparedStatement.setString(10, stage.getLongLogs());
        preparedStatement.setString(11, stage.getRailAngle());
        preparedStatement.setString(12, stage.getSupportHeight());
    }

    //update
    @Override
    public void mappingUpdate(PreparedStatement preparedStatement, Stage stage) throws SQLException {
        preparedStatement.setString(12, stage.getId().toString());
        preparedStatement.setString(1,stage.getIdDistance().toString());
        preparedStatement.setInt(2, stage.getNumber());
        preparedStatement.setString(3, stage.getName());
        preparedStatement.setString(4, stage.getControlTimeMan());
        preparedStatement.setString(5, stage.getControlTimeWoman());
        preparedStatement.setString(6, stage.getLength());
        preparedStatement.setString(7, stage.getAngle());
        preparedStatement.setString(8, stage.getDepth());
        preparedStatement.setString(9, stage.getLongLogs());
        preparedStatement.setString(10, stage.getRailAngle());
        preparedStatement.setString(11, stage.getSupportHeight());
    }

    //delete
    @Override
    public void mappingDelete(PreparedStatement preparedStatement, Stage stage) throws SQLException {
        if (pole.equals("id")) preparedStatement.setString(1, stage.getId().toString());
        else if (pole.equals("idDistance")) preparedStatement.setString(1, stage.getIdDistance().toString());;
    }

    //readByKey
    @Override
    public void mappingSelect(Stage stage, ResultSet resultSet) throws SQLException {
        stage.setId(UUID.fromString(resultSet.getString(1)));
        stage.setIdDistance(UUID.fromString(resultSet.getString(2)));
        stage.setNumber(resultSet.getInt(3));
        stage.setName(resultSet.getString(4));
        stage.setControlTimeMan(resultSet.getString(5));
        stage.setControlTimeWoman(resultSet.getString(6));
        stage.setLength(resultSet.getString(7));
        stage.setAngle(resultSet.getString(8));
        stage.setDepth(resultSet.getString(9));
        stage.setLongLogs(resultSet.getString(10));
        stage.setRailAngle(resultSet.getString(11));
        stage.setSupportHeight(resultSet.getString(12));
    }

    //getAll
    @Override
    public void mappingSelectAll(Stage stage, List<Stage> list, ResultSet resultSet) throws SQLException {
        while (resultSet.next()){
            stage = new Stage();
            mappingSelect(stage, resultSet);
            list.add(stage);
        }
    }
}
