import lombok.Data;
import lombok.ToString;

public enum DangerLevel {
    LOW(30){
        @Override
        public String toString() {
            return "LOW + : " + LOW.dangerNum;
        }
    },
    MEDIUM(55) {
        @Override
        public String toString() {
            return "MEDIUM + : " + MEDIUM.dangerNum;
        }
    },
    HIGH(80){
        @Override
        public String toString() {
            return "HIGH + : " + HIGH.dangerNum;
        }
    };

    private final int dangerNum;

    DangerLevel(int dangerNum) {
        this.dangerNum = dangerNum;
    }



}
