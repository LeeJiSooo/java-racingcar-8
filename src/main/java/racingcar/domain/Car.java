package racingcar.domain;

public class Car {
    private final String name;
    private int position;

    public Car(String name) {
        // 이름은 Controller에서 검증 후 넘어온다고 가정
        this.name = name.trim(); // 혹시 모를 공백 제거
        this.position = 0;
    }
    public void move(int number) {
        if (number >= 4) {
            this.position++;
        }
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }
}
