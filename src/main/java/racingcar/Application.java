package racingcar;

import racingcar.controller.GameController;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        try {
            GameController gameController = new GameController();
            gameController.run();
        } catch (IllegalArgumentException e) {
            System.out.println("에러메시지" + e.getMessage());
        }
    }
}
