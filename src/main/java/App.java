import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class App {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/datamapper","root","root");
        PersonMapper personMapper = new PersonMapper(connection);

        Person personA = new Person(1,"Petr", "Ivanov");
        Person personB = new Person(2,"Egor","Sidorov");
        Person personC = new Person(3,"Timur","Maratov");

        //Inserting new persons into DB
        try{
            personMapper.insert(personA);
            personMapper.insert(personB);
            personMapper.insert(personC);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        //Finding a person from DB
        try{
            int idPersonFound = 2;
            Person personFound = personMapper.findById(idPersonFound);
            System.out.println("Person with id " + idPersonFound + " is: " + personFound.getFirstName() + " " + personFound.getLastName());
        } catch (SQLException e) {
            e.printStackTrace();
        }

        //Getting all persons from DB into Identity Map
        try{
            Map <Integer, Person> personMap = new HashMap<>();
            for(int i=1;i<=3;i++){
                Person person = personMapper.findById(i);
                personMap.put(person.getIdPerson(),person);
            }
            System.out.println("stop");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        //Deleting a person from DB
        try{
            personMapper.delete(personC);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        connection.close();
    }
}
