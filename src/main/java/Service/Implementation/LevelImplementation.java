package Service.Implementation;

import Connection.Implementation.SessionUtil;
import Models.LevelEntity;
import Service.Interfaces.LevelsOperation;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class LevelImplementation implements LevelsOperation {

    @Override
    public List<LevelEntity> getListOfAllLevels() {
        try (Session session = SessionUtil.getSession()) {
            String hql = "FROM LevelEntity AS L";
            org.hibernate.query.Query<LevelEntity> query = session.createQuery(hql, LevelEntity.class);
            return query.getResultList();
        }
    }

    @Override
    public LevelEntity getFirstFreeLevel() {
        LevelsOperation levelsOperation = new LevelImplementation();
        List<LevelEntity> listOfALlLevelEntity = levelsOperation.getListOfAllLevels();
        int numberOfLevel = listOfALlLevelEntity.size() + 1;
        for (int i = 0; i < listOfALlLevelEntity.size(); i++) {
            if (listOfALlLevelEntity.get(i).isStatus()) {
                numberOfLevel = i;
                break;
            }
        }
        if (numberOfLevel > listOfALlLevelEntity.size()) {
            System.out.println("There is not free level!");

        }
        return listOfALlLevelEntity.get(numberOfLevel);
    }

    @Override
    public void changeStatusOfLevel(LevelEntity levelEntity) {
        try (Session session = SessionUtil.getSession()) {
            Transaction transaction = session.beginTransaction();
            if (levelEntity.isStatus()) {
                levelEntity.setStatus(false);
            }
            if (!levelEntity.isStatus()) {
                levelEntity.setStatus(true);
            }
            session.save(levelEntity);
            transaction.commit();
        }
    }
}
