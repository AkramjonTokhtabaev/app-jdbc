package repository;

import entity.Category;
import entity.Response;
import utils.DbConfig;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CategoryRepository {
    public static List<Category> getCategories() throws SQLException {
        Connection ulanish = DbConfig.ulanish();
        System.out.println(ulanish);

        Statement statement = null;

        statement = ulanish.createStatement();
        ResultSet resultSet = statement.executeQuery("select  * from category");

        List<Category> categoryList = new ArrayList<>();
        while (resultSet.next()) {

            Category category = new Category();
            // row bitta
//
//                System.out.println(resultSet.getInt(1));
//                System.out.println(resultSet.getString(2));
//                System.out.println(resultSet.getBoolean(3));
//                System.out.println("==================================");

            category.setId(resultSet.getInt(1));
            category.setName(resultSet.getString(2));
            category.setActive(resultSet.getBoolean(3));

            categoryList.add(category);
        }

        return categoryList;
    }

    public static boolean addCategory(int id, String name) throws SQLException {
        // oddiy parametrli queriylar uchun

        Connection connection = DbConfig.ulanish();
        PreparedStatement preparedStatement = connection.prepareStatement("insert into category " +
                "values(?, ?, ?)");

        preparedStatement.setInt(1, id);
        preparedStatement.setString(2, name);
        preparedStatement.setBoolean(3, true);

        return preparedStatement.execute();
    }

    public static Response callFunction(String name, String type, String n_name) throws SQLException {

        Response response = new Response();
        Connection connection = DbConfig.ulanish();
        CallableStatement callableStatement =
                connection.prepareCall("{call category_crud(?,?,?,?,?)}");
        callableStatement.setString(1,name);
        callableStatement.setString(2,type);
        callableStatement.setString(3,n_name);
        callableStatement.registerOutParameter(4,Types.BOOLEAN);
        callableStatement.registerOutParameter(5,Types.VARCHAR);

     callableStatement.execute();
            response.setSuccess(callableStatement.getBoolean(4));
            response.setMessage(callableStatement.getString(5));

        return response;

    }

    public static boolean addcurrency(int id,String name) throws SQLException {
        Connection connection = DbConfig.ulanish();
        PreparedStatement preparedStatement =
                connection.prepareStatement("insert into currency values(?,?,?)");
        preparedStatement.setInt(1, id);
        preparedStatement.setString(2, name);
        preparedStatement.setBoolean(3, true);
        boolean execute = preparedStatement.execute();
        return execute;
    }


    }

