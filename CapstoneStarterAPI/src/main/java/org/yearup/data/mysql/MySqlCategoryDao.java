package org.yearup.data.mysql;

import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;
import org.yearup.data.CategoryDao;
import org.yearup.models.Category;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Component
public class MySqlCategoryDao extends MySqlDaoBase implements CategoryDao {
    public MySqlCategoryDao(DataSource dataSource) {
        super(dataSource);
    }

    @Override
    public List<Category> getAllCategories() {
        List<Category> categories = new ArrayList<>();
        String query = "SELECT * FROM Categories";
        try(Connection connection = getConnection()) {
            try(PreparedStatement statement = connection.prepareStatement(query)) {
                ResultSet results = statement.executeQuery();

                while (results.next()) {
                    Category category = mapRow(results);
                    categories.add(category);
                }
            }
        } catch (SQLException e) {

        }
        return categories;
    }

    @Override
    public Category getById(int categoryId) {
        String query = "SELECT * " +
                "FROM Categories " +
                "WHERE Category_Id = ?";
        try(Connection connection = getConnection()) {
            try(PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setInt(1, categoryId);
                ResultSet results = statement.executeQuery();

                while (results.next()) {
                    return mapRow(results);
                }
            }
        } catch (SQLException e) {

        }
        return null;
    }

    @Override
    public Category create(Category category) {
        String query = "INSERT INTO categories (category_id, name, description) VALUES (?, ?, ?);";
        try(Connection connection = getConnection()) {
            try(PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setInt(1, category.getCategoryId());
                statement.setString(2, category.getName());
                statement.setString(3, category.getName());

                ResultSet results = statement.executeQuery();

                while (results.next()) {
                    return mapRow(results);
                }
            }
        } catch (SQLException e) {

        }
        return null;
    }

    @Override
    public void update(int categoryId, Category category) {
        // update category
    }

    @Override
    public void delete(int categoryId)
    {
        // delete category
    }

    private Category mapRow(ResultSet row) throws SQLException
    {
        int categoryId = row.getInt("category_id");
        String name = row.getString("name");
        String description = row.getString("description");

        Category category = new Category()
        {{
            setCategoryId(categoryId);
            setName(name);
            setDescription(description);
        }};

        return category;
    }

}
