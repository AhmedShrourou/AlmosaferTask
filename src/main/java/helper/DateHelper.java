package helper;

import java.time.LocalDate;

public class DateHelper {

    public String getDateAfterDays(int days){

        LocalDate today = LocalDate.now();
        return today.plusDays((long) days).toString();
    }
}
