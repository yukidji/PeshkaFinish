import ru.ufa.peshka.DAO.EntityDao.ChipDao;
import ru.ufa.peshka.entity.Chip;
import ru.ufa.peshka.entity.Enum.StatusChip;

import java.sql.*;
import java.text.ParseException;
import java.util.UUID;

public class Main {

    public static void main (String[] args) throws SQLException, ClassNotFoundException, ParseException {
        ChipDao chipDao = new ChipDao();
        Chip chip;
        //chip = new Chip();
        //chip.getId();
        //chip.setStatus(StatusChip.FREE);
        chip = chipDao.readById(new Chip(),"cd966bde-8789-442a-85ce-da7c5ffb645c");
        System.out.println(chip.toString());
    }
}
