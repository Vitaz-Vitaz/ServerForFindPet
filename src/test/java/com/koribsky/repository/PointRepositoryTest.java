package com.koribsky.repository;

import com.koribsky.domain.NewPoint;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Класс PointDaoJPA")
@DataJpaTest
public class PointRepositoryTest {
    private String f = "jbi";

    @Autowired
     private NewPointRepository pointRepository;

    @PersistenceContext
    private EntityManager entityManager;

    @DisplayName("должен добавлять точку")
    @Test
    void shouldInsertPoint() {

        NewPoint expectedPoint = NewPoint.builder()
                .id(5)
                .description("kitik")
                .photo(f)
                .x(2)
                .y(2)
                .build();

        pointRepository.save(expectedPoint);
        NewPoint actualPoint = pointRepository.getById(5);

        assertThat(actualPoint).isEqualTo(expectedPoint);
    }


    @DisplayName("должен обновлять автора")
    @Test
    void shouldUpdateAuthor() {
        NewPoint expectedPoint = NewPoint.builder()
                .id(6)
                .description("kitik")
                .photo(f)
                .x(2)
                .y(2)
                .build();

        pointRepository.save(expectedPoint);
        NewPoint actualPoint = pointRepository.getById(6);

        assertThat(actualPoint).isEqualTo(expectedPoint);
    }
    @DisplayName("должен возвращать всех авторов")
    @Test
    void shouldGetAllAuthors() {

        NewPoint p1 = NewPoint.builder()
                .id(7)
                .description("kitik")
                .photo(f)
                .x(2)
                .y(2)
                .build();
        NewPoint p2 = NewPoint.builder()
                .id(8)
                .description("kitik")
                .photo(f)
                .x(2)
                .y(2)
                .build();

        assertThat(pointRepository.findAll().size()).isEqualTo(4);
//        assertThat(pointRepository.findAll())
//                .containsExactlyInAnyOrder(p1, p2);
    }
    @DisplayName("должен возвращать автора по id")
    @Test
    void shouldGetAuthorById() {

        NewPoint p1 = NewPoint.builder()
                .id(1)
                .description("kitik")
                .photo(f)
                .x(2)
                .y(2)
                .build();

        NewPoint actualPoint = pointRepository.getById(1);

        assertThat(actualPoint).isEqualTo(p1);
    }

    @DisplayName("должен возвращать автора по имени")
    @Test
    void shouldGetAuthorByName() {

        NewPoint p1 = NewPoint.builder()
                .id(10)
                .description("kitik")
                .photo(f)
                .x(25666)
                .y(2)
                .build();

        NewPoint actualPoint = pointRepository.findByX(25666);

        assertThat(actualPoint).isEqualTo(p1);
    }

    @DisplayName("должен удалять автора по id")
    @Test
    void shouldDeleteAuthorById() {

        int sizeBefore = pointRepository.findAll().size();

        pointRepository.deleteById(3);
        entityManager.flush();

        int sizeAfter =pointRepository.findAll().size();
        assertThat(sizeBefore - sizeAfter).isEqualTo(1);
    }



}
