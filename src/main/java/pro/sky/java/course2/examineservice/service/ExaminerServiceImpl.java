package pro.sky.java.course2.examineservice.service;

import org.springframework.stereotype.Service;
import pro.sky.java.course2.examineservice.model.Question;
import pro.sky.java.course2.examineservice.exception.InvalidAmountOfQuestionsException;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Service
public class ExaminerServiceImpl implements ExaminerService {

    private final QuestionService questionService;

    public ExaminerServiceImpl(QuestionService questionService) {
        this.questionService = questionService;
    }

    @Override
    public Collection<Question> getQuestions(int amount) {

        if (amount < 0 || amount > questionService.getAll().size()) {
            throw new InvalidAmountOfQuestionsException();
        }

        Set<Question> questionSet = new HashSet<>();

        while (questionSet.size() < amount) {
            questionSet.add(questionService.getRandomQuestion());
        }

        return questionSet;
    }
}
