package pl.danielstrielnikow.domain.api;

import pl.danielstrielnikow.category.Category;
import pl.danielstrielnikow.category.CategoryDao;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class CategoryService {
    private CategoryDao categoryDao = new CategoryDao();

    public List<CategoryName> findAllCategoryNames() {
        return categoryDao.findAll()
                .stream()
                .map(CategoryNameMapper::map)
                .collect(Collectors.toList());
    }

    private static class CategoryNameMapper {
        static CategoryName map(Category c) {
            return new CategoryName(
                    c.getId(),
                    c.getName()
            );
        }
    }

    public Optional<CategoryFullInfo> findById(int categoryId) {
        return categoryDao.findById(categoryId)
                .map(CategoryFullInfoMapper::map);
    }
    private static class CategoryFullInfoMapper {
        static CategoryFullInfo map(Category c) {
            return new CategoryFullInfo(
                    c.getId(),
                    c.getName(),
                    c.getDescription()
            );
        }
    }
}
