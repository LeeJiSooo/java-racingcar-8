package racingcar.view;

import racingcar.domain.Car;

import java.util.ArrayList;
import java.util.List;

public class OutputView {
    public void printRoundResultHeader() {
        System.out.println("\n실행 결과");
    }

    // 한 라운드의 결과를 출력
    public void printRoundResult(List<Car> cars) {
        for (Car car : cars) {
            System.out.print(car.getName() + " : ");
            printPosition(car.getPosition());
            System.out.println();
        }
        System.out.println();
    }

    // '-' 문자를 그리는 메서드
    private void printPosition(int position) {
        for (int i = 0; i < position; i++) {
            System.out.print("-");
        }
    }

    // 최종 우승자 출력
    public void printWinners(List<Car> winners) {
        List<String> winnerNames = new ArrayList<>();
        for (Car winner : winners) {
            winnerNames.add(winner.getName());
        }

        // String.join을 사용하여 쉼표로 구분
        String winnersString = String.join(", ", winnerNames);
        System.out.println("최종 우승자 : " + winnersString);
    }

}
