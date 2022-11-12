package pro.sky.java.course2.examineservice.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import pro.sky.java.course2.examineservice.domain.Question;
import pro.sky.java.course2.examineservice.exception.InvalidAmountOfQuestionsException;

import java.util.Collection;
import java.util.Set;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class ExaminerServiceImplTest {

    private static final Question FIRST_QUESTION = new Question("Question1", "Answer1");
    private static final Question SECOND_QUESTION = new Question("Question2", "Answer2");
    private static final Question THIRD_QUESTION = new Question("Question3", "Answer3");
    private static final int WRONG_AMOUNT_1 = -1;
    private static final int WRONG_AMOUNT_2 = 10;
    private static final int CORRECT_AMOUNT = 2;

    @Mock
    private QuestionService questionServiceMock;

    @InjectMocks
    private ExaminerServiceImpl examinerService;

    @Test
    void getQuestions() {
        Mockito.when(questionServiceMock.getAll()).thenReturn(Set.of(FIRST_QUESTION, SECOND_QUESTION, THIRD_QUESTION));
        Mockito.when(questionServiceMock.getRandomQuestion()).thenReturn(FIRST_QUESTION, FIRST_QUESTION, SECOND_QUESTION, THIRD_QUESTION);

        Collection<Question> expected = Set.of(FIRST_QUESTION, SECOND_QUESTION);
        assertThat(examinerService.getQuestions(CORRECT_AMOUNT)).isEqualTo(expected);
    }

    @Test
    void shouldReturnInvalidAmountOfQuestionsException() {
        Mockito.when(questionServiceMock.getAll()).thenReturn(Set.of(FIRST_QUESTION, SECOND_QUESTION, THIRD_QUESTION));

        assertThrows(InvalidAmountOfQuestionsException.class, () -> examinerService.getQuestions(WRONG_AMOUNT_1));
        assertThrows(InvalidAmountOfQuestionsException.class, () -> examinerService.getQuestions(WRONG_AMOUNT_2));
    }
}