

class CountFieldException extends Exception {
    public CountFieldException(String message) {
        super("Колличество полей  " + message + "!");
    }
}

class TypeDataExceptoin extends Exception {
    public TypeDataExceptoin(int index) {
        super("Поле [" + index + "] имеет не допустимый тип!");
    }
}

class FormatException extends Exception {
    public FormatException() {
        super("Не корректный ввод номера телефона");
    }
}

class EmptyStringException extends Exception {
    public EmptyStringException(String message) {
        super(message);
    }
}