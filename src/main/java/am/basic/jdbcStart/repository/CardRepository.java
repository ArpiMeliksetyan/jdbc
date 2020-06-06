package am.basic.jdbcStart.repository;

import am.basic.jdbcStart.model.Card;
import am.basic.jdbcStart.model.Student;
import am.basic.jdbcStart.model.User;
import am.basic.jdbcStart.util.DataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CardRepository {
    private DataSource dataSource;

    public CardRepository(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public void update(Card card) throws SQLException {
        Connection connection = dataSource.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("UPDATE  card  SET name= ?, surname=?, cvv=? where id=?");
        preparedStatement.setString(1, card.getName());
        preparedStatement.setString(2, card.getSurname());
        preparedStatement.setInt(3, card.getCvv());


        int result = preparedStatement.executeUpdate();
        System.out.println("result = " + result);
    }

    public Card getById(int id) throws SQLException {
        Card card = null;

        Connection connection = dataSource.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("Select * from user where id =?");
        preparedStatement.setInt(1, id);

        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            card = fromResulSet(resultSet);
        }
        resultSet.close();
        preparedStatement.close();
        return card;
    }

    private Card fromResulSet(ResultSet resultSet) throws SQLException {

        Card card = new Card();
        card.setId(resultSet.getInt("id"));
        card.setName(resultSet.getString("name"));
        card.setSurname(resultSet.getString("surname"));
        card.setCvv(resultSet.getInt("cvv"));


        return card;
    }

    public void add(Card card) throws SQLException {
        Connection connection = dataSource.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("INSERT into card VALUES (0,?,?,?)");
        preparedStatement.setString(1, card.getName());
        preparedStatement.setString(2, card.getSurname());
        preparedStatement.setInt(3, card.getCvv());


        int result = preparedStatement.executeUpdate();
        System.out.println(result);
    }

    public void delete(int id) throws SQLException {

        Card card = null;
        Connection connection = dataSource.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("DELETE from card where id =?");
        preparedStatement.setInt(1, id);
        preparedStatement.execute();
        preparedStatement.close();
    }

    public List<Card> getAll() throws SQLException {

        List<Card> cardList = new ArrayList<>();
        Connection connection = dataSource.getConnection();
        ResultSet resultSet = connection.createStatement().executeQuery("Select*from card ");


        while (resultSet.next()) {
            Card card = fromResulSet(resultSet);
            cardList.add(card);

        }
        resultSet.close();
        return cardList;

    }

    public List<Card> FindByNameAndSurname(String name, String surname) throws SQLException {
        List<Card> cardList1 = new ArrayList<>();
        Connection connection = dataSource.getConnection();
        PreparedStatement preparedStatement =
                connection.prepareStatement("SELECT*from card where name LIKE (Concat('%',?,'%'))and surname LIKE  (Concat('%',?,'%'))");
        preparedStatement.setString(1, name);
        preparedStatement.setString(2, surname);
        ResultSet resultSet = preparedStatement.executeQuery();


        while (resultSet.next()) {
            Card card = fromResulSet(resultSet);
            cardList1.add(card);

        }
        resultSet.close();
        preparedStatement.close();
        return cardList1;
    }
}
