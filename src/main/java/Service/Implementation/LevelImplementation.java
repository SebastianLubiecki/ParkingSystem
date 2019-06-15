package Service.Implementation;

import Connection.Implementation.SessionUtil;
import Models.Level;
import Service.Interfaces.LevelsOperation;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class LevelImplementation implements LevelsOperation {

    @Override
    public List<Level> getListOfAllLevels() {
        try (Session session = SessionUtil.getSession()) {
            String hql = "FROM Level AS L";
            org.hibernate.query.Query<Level> query = session.createQuery(hql, Level.class);
            return query.getResultList();
        }
    }

    @Override
    public Level getFirstFreeLevel() {
        LevelsOperation levelsOperation = new LevelImplementation();
        List<Level> listOfALlLevel = levelsOperation.getListOfAllLevels();
        int numberOfLevel = listOfALlLevel.size() + 1;
        for (int i = 0; i < listOfALlLevel.size(); i++) {
            if (listOfALlLevel.get(i).isStatus()) {
                numberOfLevel = i;
                break;
            }
        }
        if (numberOfLevel > listOfALlLevel.size()) {
            System.out.println("There is not free level!");

        }
        return listOfALlLevel.get(numberOfLevel);
    }

    @Override
    public void changeStatusOfLevel(Level level) {
        try (Session session = SessionUtil.getSession()) {
            Transaction transaction = session.beginTransaction();


            if (level.isStatus()) {
                level.setStatus(false);
            }
            if (!level.isStatus()) {
                level.setStatus(true);
            }
            session.save(level);
            transaction.commit();
        }
    }
}
