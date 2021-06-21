import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PersonMapper {
    private final Connection connection;

    public PersonMapper(Connection connection) {
        this.connection = connection;
    }

    public Person findById(int idPerson) throws SQLException{
        PreparedStatement statement = connection.prepareStatement(
                "SELECT IDPERSON, FIRSTNAME, LASTNAME FROM USERS WHERE IDPERSON = ?");
        statement.setInt(1, idPerson);
        try(ResultSet resultSet = statement.executeQuery()){
            while (resultSet.next()){
                Person person = new Person();
                person.setIdPerson(resultSet.getInt(1));
                person.setFirstName(resultSet.getString(2));
                person.setLastName(resultSet.getString(3));
                return person;
            }
        }
        throw new SQLException();
    }

    public void insert(Person person) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(
                "INSERT INTO USERS (IDPERSON, FIRSTNAME, LASTNAME) VALUES (?, ?, ?)");
        statement.setInt(1, person.getIdPerson());
        statement.setString(2, person.getFirstName());
        statement.setString(3, person.getLastName());
        statement.execute();
    }

    public void update(Person person) throws SQLException{
        PreparedStatement statement = connection.prepareStatement(
                "UPDATE USERS SET FIRSTNAME = ? WHERE IDPERSON = ?");
        statement.setString(1,person.getFirstName());
        statement.setInt(2,person.getIdPerson());
    }

    public void delete(Person person) throws SQLException{
        PreparedStatement statement = connection.prepareStatement(
                "DELETE FROM USERS WHERE LASTNAME = ?");
        statement.setString(1, person.getLastName());
    }

}
