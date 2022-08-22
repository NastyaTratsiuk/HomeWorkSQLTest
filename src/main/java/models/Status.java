package models;

public enum Status {

    PASSED (1),
    FAILED (2),
    SKIPPED (3);

    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    Status(int id) {
        this.id = id;
    }
}
