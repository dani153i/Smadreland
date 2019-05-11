package dk.smadreland.model;

import javax.persistence.*;

@Entity
@Table(name = "answer_custom")
public class CustomAnswer extends Answer {

    public CustomAnswer() {}
    public CustomAnswer(String content) {
        super(content);
    }
}
