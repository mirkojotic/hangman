class Main {

    public static void main(String[] args) {
        System.out.println("Starting...");

        boolean playing = true;
        int score = 0;

        Word word = new Word();
        while(playing == true) {
            Game game = new Game(word.get().toLowerCase());
            game.run();
            if(game.userGuessed()) {
                score++;
            } else {
                score--;
            }
            System.out.println("Round over! Your score is: " + score);
        }
    }
}