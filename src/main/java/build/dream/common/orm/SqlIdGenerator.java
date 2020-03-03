package build.dream.common.orm;

import build.dream.common.utils.ApplicationHandler;
import build.dream.common.utils.DatabaseUtils;
import org.apache.commons.lang3.Validate;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class SqlIdGenerator implements IdGenerator<Long> {
    private DataSource dataSource;

    public SqlIdGenerator() {
        this.dataSource = ApplicationHandler.getBean(DataSource.class);
    }

    @Override
    public Long nextId() {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = dataSource.getConnection();
            preparedStatement = connection.prepareStatement("SELECT RAND() * 10000;");
            resultSet = preparedStatement.executeQuery();
            Validate.isTrue(resultSet.next(), "生成ID失败！");
            return resultSet.getLong(0);
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            DatabaseUtils.closeResultSet(resultSet);
            DatabaseUtils.closeStatement(preparedStatement);
            DatabaseUtils.closeConnection(connection);
        }
    }

    @Override
    public List<Long> nextManyIds(int number) {
        List<Long> ids = new ArrayList<Long>(number);
        for (int index = 0; index < number; index++) {
            ids.add(nextId());
        }
        return ids;
    }
}
