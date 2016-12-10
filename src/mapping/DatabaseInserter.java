package mapping;

import mapping.AbstractDatabaseHandler;
import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Gerry
 */
public class DatabaseInserter<T> extends AbstractDatabaseHandler<T> {

    public DatabaseInserter(Class<T> type,
            DatabaseConnecter databaseConnecter) {
            super(type, databaseConnecter);
    }

    @Override
    protected String createQuery() {

	StringBuilder sb = new StringBuilder();

        sb.append("INSERT INTO ");
	sb.append(type.getSimpleName());
	sb.append("(");
	sb.append(super.getColumns(false));
	sb.append(")");
	sb.append(" VALUES (");
	sb.append(super.getColumns(true));
	sb.append(")");

	return sb.toString();
    }

	/**
	 * Inserts a list of <T>s into the corresponding database-table
	 * 
	 * @param list
	 *            List of <T>s that should be inserted into the corresponding
	 *            database-table
	 * 
	 * @throws SQLException
	 * @throws SecurityException
	 * @throws IllegalArgumentException
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 * @throws IntrospectionException
	 * @throws InvocationTargetException
	 */
    //Inserta una lista de objetos al registro
    public void insertObjects(List<T> list) throws SQLException,
                 SecurityException, IllegalArgumentException,
                 InstantiationException, IllegalAccessException,
		 IntrospectionException, InvocationTargetException {

	Connection connection = null;
	PreparedStatement preparedStatement = null;

	try {
            connection = dbConnecter.createConnection();
            preparedStatement = connection.prepareStatement(query);

            for (T instance : list) {
		int i = 0;

		for (Field field : type.getDeclaredFields()) {
                    PropertyDescriptor propertyDescriptor = new PropertyDescriptor(
                                        field.getName(), type);

                    Method method = propertyDescriptor.getReadMethod();

                    Object value = method.invoke(instance);
                    preparedStatement.setObject(++i, value);
		}

		preparedStatement.addBatch();
            }
            preparedStatement.executeBatch();

	} finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) { /* ignored */}
            }
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException e) { /* ignored */}
            }
	}
    }
}
