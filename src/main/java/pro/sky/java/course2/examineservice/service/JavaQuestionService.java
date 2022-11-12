package pro.sky.java.course2.examineservice.service;

import org.springframework.stereotype.Service;
import pro.sky.java.course2.examineservice.domain.Question;
import pro.sky.java.course2.examineservice.exception.QuestionAlreadyInTheListException;
import pro.sky.java.course2.examineservice.exception.QuestionNotFoundException;

import java.util.*;

@Service
public class JavaQuestionService implements QuestionService {

    private Set<Question> questions = new HashSet<>();

    @Override
    public Question add(String question, String answer) {
        Question q = new Question(question, answer);
        if (questions.add(q)) {
            return q;
        } else {
            throw new QuestionAlreadyInTheListException();
        }
    }

    @Override
    public Question add(Question question) {
        if (questions.add(question)) {
            return question;
        } else {
            throw new QuestionAlreadyInTheListException();
        }
    }

    @Override
    public Question remove(Question question) {
        if (questions.remove(question)) {
            return question;
        } else {
            throw new QuestionNotFoundException();
        }
    }

    @Override
    public Collection<Question> getAll() {
        return Collections.unmodifiableSet(questions);
    }

    @Override
    public Question getRandomQuestion() {

        Random rand = new Random();
        int i = rand.nextInt(0, questions.size());
        return (Question) questions.toArray()[i];
    }
}
