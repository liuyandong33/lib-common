package build.dream.common.orm;

import build.dream.common.utils.ApplicationHandler;
import build.dream.common.utils.DatabaseUtils;
import build.dream.common.utils.ValidateUtils;

import javax.sql.DataSource;
import java.math.BigInteger;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class SqlIdGenerator implements IdGenerator<BigInteger> {
    private DataSource dataSource;

    public SqlIdGenerator() {
        this.dataSource = ApplicationHandler.getBean(DataSource.class);
    }

    @Override
    public BigInteger nextId() {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = dataSource.getConnection();
            preparedStatement = connection.prepareStatement("SELECT RAND() * 10000;");
            resultSet = preparedStatement.executeQuery();
            ValidateUtils.isTrue(resultSet.next(), "生成ID失败！");
            return BigInteger.valueOf(resultSet.getLong(0));
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            DatabaseUtils.closeConnection(connection);
        }
    }

    @Override
    public List<BigInteger> nextManyIds(int number) {
        List<BigInteger> ids = new ArrayList<BigInteger>(number);
        for (int index = 0; index < number; index++) {
            ids.add(nextId());
        }
        return ids;
    }
}
