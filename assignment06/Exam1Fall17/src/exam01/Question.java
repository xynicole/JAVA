package exam01;

public class Question {
	private String question;
	public Question(String text) {
	question = text;
	}
	public void display() {
	System.out.println("Write your answer to the question below:");
	System.out.println(question);
	}
	}

