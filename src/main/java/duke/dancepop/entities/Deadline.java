package duke.dancepop.entities;

import duke.dancepop.enums.TaskEnum;
import duke.dancepop.utils.DateTimeUtil;

import java.time.LocalDateTime;

public class Deadline extends Task {
    private LocalDateTime deadline;

    // TODO: Fix design for inheritance
    public Deadline(String description, LocalDateTime deadline) {
        super(description);
        this.deadline = deadline;
    }

    protected TaskEnum getType() {
        return TaskEnum.DEADLINE;
    }

    public LocalDateTime getDeadline() {
        return deadline;
    }

    public String toString() {
        return super.toString() + " (by: " + DateTimeUtil.toString(deadline) +")";
    }
}
