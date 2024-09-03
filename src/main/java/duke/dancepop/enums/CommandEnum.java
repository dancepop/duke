package duke.dancepop.enums;

public enum CommandEnum {
  EVENT("event"),
  TODO("todo"),
  DEADLINE("deadline");

  private final String value;

  CommandEnum(String value) {
    this.value = value;
  }

  public String getValue() {
    return value;
  }
}
