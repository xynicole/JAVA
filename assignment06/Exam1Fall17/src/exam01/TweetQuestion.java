package exam01;

class TweetQuestion extends Question
{
    public TweetQuestion(String text){
        super(text);
    }

    @Override
    public void display(){
        System.out.println("You must limit your answer to 140 characters.");
        super.display();
    }
}
