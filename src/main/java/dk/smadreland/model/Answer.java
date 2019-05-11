package dk.smadreland.model;

import javax.persistence.*;

@Entity
@Table(name = "question")
public class Answer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String content;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "question_id")
    private Question question;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "next_question_id")
    private Question nextQuestion;

    public Answer() {}
    public Answer(String content) {
        this.content = content;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getContent() { return content; }
    public void setContent(String content) { this.content = content; }

    public Question getQuestion() { return question; }
    public void setQuestion(Question question) { this.question = question; }

    public Question getNextQuestion() { return nextQuestion; }
    public void setNextQuestion(Question nextQuestion) { this.nextQuestion = nextQuestion; }


    @Override
    public String toString() {
        return "Answer{" +
                "id=" + id +
                ", content='" + content + '\'' +
                '}';
    }
}
