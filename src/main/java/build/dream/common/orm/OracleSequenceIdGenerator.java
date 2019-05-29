package build.dream.common.orm;

import build.dream.common.utils.ApplicationHandler;
import build.dream.common.utils.DatabaseUtils;
import org.apache.commons.lang3.Validate;

import javax.sql.DataSource;
import java.math.BigInteger;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class OracleSequenceIdGenerator implements IdGenerator<BigInteger> {
    private DataSource dataSource;

    public OracleSequenceIdGenerator() {
        this.dataSource = ApplicationHandler.getBean(DataSource.class);
    }

    @Override
    public BigInteger nextId() {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = dataSource.getConnection();
            preparedStatement = connection.prepareStatement("SELECT id_sequence.nextval FROM DUAL;");
            resultSet = preparedStatement.executeQuery();
            Validate.isTrue(resultSet.next(), "生成ID失败！");
            return BigInteger.valueOf(resultSet.getLong(1));
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            DatabaseUtils.closeResultSet(resultSet);
            DatabaseUtils.closeStatement(preparedStatement);
            DatabaseUtils.closeConnection(connection);
        }
    }

    @Override
    public List<BigInteger> nextManyIds(int number) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = dataSource.getConnection();
            preparedStatement = connection.prepareStatement("SELECT id_sequence.nextval FROM (SELECT ROWNUM FROM DUAL CONNECT BY ROWNUM <= ?);");
            preparedStatement.setInt(1, number);
            resultSet = preparedStatement.executeQuery();

            List<BigInteger> ids = new ArrayList<BigInteger>(number);
            while (resultSet.next()) {
                ids.add(BigInteger.valueOf(resultSet.getLong(1)));
            }
            return ids;
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            DatabaseUtils.closeResultSet(resultSet);
            DatabaseUtils.closeStatement(preparedStatement);
            DatabaseUtils.closeConnection(connection);
        }
    }
}
