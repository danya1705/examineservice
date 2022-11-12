package pro.sky.java.course2.examineservice.service;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pro.sky.java.course2.examineservice.model.Question;
import pro.sky.java.course2.examineservice.exception.QuestionAlreadyInTheListException;
import pro.sky.java.course2.examineservice.exception.QuestionNotFoundException;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class JavaQuestionServiceTest {

    private static final Question FIRST_QUESTION = new Question("Question1", "Answer1");
    private static final Question SECOND_QUESTION = new Question("Question2", "Answer2");
    private static final Question THIRD_QUESTION = new Question("Question3", "Answer3");

    JavaQuestionService javaQuestionService = new JavaQuestionService();

    @BeforeEach
    void createQuestionList() {
        javaQuestionService.add(FIRST_QUESTION);
    }

    @AfterEach
    void clearQuestionList() {
        while (javaQuestionService.getAll().size() > 0) {
            javaQuestionService.remove(javaQuestionService.getRandomQuestion());
        }
    }

    @Test
    void addPositiveTest() {
        javaQuestionService.add(SECOND_QUESTION.getQuestion(),SECOND_QUESTION.getAnswer());
        javaQuestionService.add(THIRD_QUESTION);
        Set<Question> expected = new HashSet<>(Set.of(FIRST_QUESTION,SECOND_QUESTION,THIRD_QUESTION));
        assertThat(javaQuestionService.getAll()).isEqualTo(expected);
    }

    @Test
    void shouldReturnQuestionAlreadyInTheListExceptionWhenTryToAdd() {
        assertThrows(QuestionAlreadyInTheListException.class, () -> javaQuestionService.add(FIRST_QUESTION.getQuestion(),FIRST_QUESTION.getAnswer()));
        assertThrows(QuestionAlreadyInTheListException.class, () -> javaQuestionService.add(FIRST_QUESTION));
    }

    @Test
    void removePositiveTest() {
        javaQuestionService.remove(FIRST_QUESTION);
        assertThat(javaQuestionService.getAll()).doesNotContain(FIRST_QUESTION);
    }

    @Test
    void shouldReturnQuestionNotFoundExceptionWhenTryToRemove() {
        assertThrows(QuestionNotFoundException.class, () -> javaQuestionService.remove(SECOND_QUESTION));
    }

    @Test
    void getAllPositiveTest() {
        Set<Question> expected = new HashSet<>(Set.of(FIRST_QUESTION));
        assertThat(javaQuestionService.getAll()).isEqualTo(expected);
    }

    @Test
    void getRandomQuestionPositiveTest() {
        assertThat(javaQuestionService.getRandomQuestion()).isIn(javaQuestionService.getAll());
    }
}