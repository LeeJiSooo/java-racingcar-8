package racingcar.controller;

import racingcar.domain.Car;
import racingcar.domain.RacingGame;
import racingcar.util.Validator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class GameController {
    private final InputView inputView;
    private final OutputView outputView;
    public GameController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();

    }
    public void run() {
        // 1. 입력 받기 및 객체 생성
        RacingGame game = setupGame();
        int tryCount = getTryCount();

        // 2. 게임 실행
        playGame(game, tryCount);

        // 3. 결과 발표
        showResult(game);

    }

    // 1-1. 자동차 이름 입력 받고 RacingGame 객체 생성
    private RacingGame setupGame() {
        String carNamesInput = inputView.readCarNames();
        String[] carNames = carNamesInput.split(",");

        Validator.validateCarNames(carNames); // 검증

        List<Car> cars = createCars(carNames);
        return new RacingGame(cars);
    }

    // 1-2. 시도 횟수 입력 받기
    private int getTryCount() {
        String tryCountInput = inputView.readTryCount();
        return Validator.validateTryCount(tryCountInput); // 검증
    }

    // 1-3. Car 객체 리스트 생성
    private List<Car> createCars(String[] carNames) {
        List<Car> cars = new ArrayList<>();
        for (String name : carNames) {
            cars.add(new Car(name.trim())); // 공백 제거 후 생성
        }
        return cars;
    }

    // 2. 게임 실행
    private void playGame(RacingGame game, int tryCount) {
        outputView.printRoundResultHeader();
        for (int i = 0; i < tryCount; i++) {
            game.playRound();
            outputView.printRoundResult(game.getCars());
        }
    }

    // 3. 최종 결과 발표
    private void showResult(RacingGame game) {
        List<Car> winners = game.getWinners();
        outputView.printWinners(winners);
    }


}
