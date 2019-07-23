package exam01;

public class QuestionTest {

		public static void main(String[] args) {
		Question q1 = new Question("What did you do on your last vacation?");
		Question q2 = new TweetQuestion("Which course are you enjoying most?");
		q1.display();
		System.out.println("-------------------");
		q2.display();
		}
}
