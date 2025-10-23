package racingcar.controller;

import racingcar.util.Validator;
import racingcar.view.InputView;

public class GameController {
    private final InputView inputView;
    public GameController() {
        this.inputView = new InputView();
    }
    public void run() {
        // 1. 입력 받기
        String carNamesInput = inputView.readCarNames();
        String tryCountInput = inputView.readTryCount();

        // 2. 검증하기
        String[] carNames = carNamesInput.split(",");
        Validator.validateCarNames(carNames);

        int tryCount = Validator.validateTryCount(tryCountInput);

    }
}
