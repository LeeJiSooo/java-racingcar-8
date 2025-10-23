package racingcar.util;

public class Validator {
    private static final int MAX_NAME_LENGTH = 5;

    public static void validateCarNames(String[] carNames) {
        if (carNames.length == 0) {
            throw new IllegalArgumentException("자동차 이름이 입력되지 않았습니다.");
        }
        for (String name : carNames) {
            validateNameLength(name.trim()); // 공백 제거 후 검증
        }
    }

    private static void validateNameLength(String name) {
        if (name.isEmpty() || name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException("자동차 이름은 1자 이상 5자 이하만 가능합니다.");
        }
    }

    public static int validateTryCount(String tryCountStr) {
        try {
            int tryCount = Integer.parseInt(tryCountStr);
            if (tryCount <= 0) {
                throw new IllegalArgumentException("시도 횟수는 1 이상의 양수여야 합니다.");
            }
            return tryCount;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("시도 횟수는 숫자로만 입력해야 합니다.");
        }
    }
}
