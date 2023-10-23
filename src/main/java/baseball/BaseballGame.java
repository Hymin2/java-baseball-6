package baseball;

import java.util.List;

public class BaseballGame {
    private static final BaseballReferee baseballReferee = new BaseballReferee();
    private static final InputReader inputReader = new InputReader();
    private static final NumberGenerator numberGenerator = new NumberGenerator();
    private static final OutputWriter outputWriter = new OutputWriter();

    public static void gameStart() {
        outputWriter.printGameStartMessage();

        while (true) {
            List<Integer> goal = numberGenerator.generateNumber();

            while (true) {
                outputWriter.printInputMessage();
                List<Integer> userInput = inputReader.readUserGameInput();

                int[] result = baseballReferee.scoreInput(goal, userInput);
                outputWriter.printResultOfInput(result[0], result[1]);

                if (isThreeStrike(result[1])) {
                    break;
                }
            }
            outputWriter.printGameFinishMessage();

            if (!isRestart(inputReader.readUserGameFinishInput())) {
                break;
            }
        }

    }

    private static boolean isThreeStrike(int strike) {
        return strike == 3;
    }

    private static boolean isRestart(int restart) {
        return restart == 1;
    }
}
