import ru.ufa.peshka.DAO.EntityDao.FineTwainDao;
import ru.ufa.peshka.DAO.EntityDao.RaceTwainDao;
import ru.ufa.peshka.entity.FineTwain;
import ru.ufa.peshka.entity.RaceTwain;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.HashSet;
import java.util.Set;

public class Main {

    public static void main(String[] args) throws SQLException, ClassNotFoundException, ParseException {

        RaceTwain raceTwain = new RaceTwain();
        FineTwain fineTwain = new FineTwain();
        Set <RaceTwain> raceTwains = new HashSet<>();
        Set <FineTwain> fineTwains = new HashSet<>();

        RaceTwainDao raceTwainDao = new RaceTwainDao();
        FineTwainDao fineTwainDao = new FineTwainDao();

        fineTwainDao.getAll(fineTwains ,fineTwain);
        for (int i=0;i<fineTwains.size();i++){
            System.out.println(fineTwains.toArray()[i]);
        }

    }
}
