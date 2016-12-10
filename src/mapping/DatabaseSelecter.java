package mapping;


import mapping.AbstractDatabaseHandler;
import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Gerry
 */
public class DatabaseSelecter<T> extends AbstractDatabaseHandler<T> {
    
    public DatabaseSelecter( Class<T> type, 
            DatabaseConnecter dbConnecter ){
        super( type , dbConnecter );
    }
    
    @Override
    protected String createQuery() {

        StringBuilder sb = new StringBuilder();

	sb.append("SELECT ");
	sb.append(super.getColumns(false));
	sb.append(" FROM ");

		
	sb.append(type.getSimpleName());

	return sb.toString();
    }
    
    public List<T> selectObjects() throws SQLException,
            SecurityException, IllegalArgumentException,
            InstantiationException, IllegalAccessException,
            IntrospectionException, InvocationTargetException {

	Connection connection = null;
	Statement statement = null;
	ResultSet resultSet = null;

	try {
            connection = dbConnecter.createConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(query);

            return createObjects(resultSet);

	} finally {
            //DatabaseResourceCloser.close(resultSet, statement, connection);
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) { /* ignored */}
            }
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) { /* ignored */}
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) { /* ignored */}
            }
	}
    }
    
    private List<T> createObjects(ResultSet resultSet)
            throws SecurityException, IllegalArgumentException,
            SQLException, InstantiationException,
            IllegalAccessException, IntrospectionException,
            InvocationTargetException {

	List<T> list = new ArrayList<T>();

	while (resultSet.next()) {

            T instance = type.newInstance();

            for (Field field : type.getDeclaredFields()) {

		/* We assume the table-column-names exactly match the variable-names of T */
		Object value = resultSet.getObject(field.getName());

		PropertyDescriptor propertyDescriptor = new PropertyDescriptor(
                    field.getName(), type);

		Method method = propertyDescriptor.getWriteMethod();

		method.invoke(instance, value);
            }

            list.add(instance);
	}
        
	return list;
    }
}
