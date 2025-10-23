package racingcar.controller;

import racingcar.view.InputView;

public class GameController {
    private final InputView inputView;
    public GameController() {
        this.inputView = new InputView();
    }
    public void run() {
        String carNamesInput = inputView.readCarNames();
        String tryCountInput = inputView.readTryCount();

        System.out.println("입력된 이름: " + carNamesInput);
        System.out.println("입력된 횟수: " + tryCountInput);
    }
}
