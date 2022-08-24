import OOP.Computer;
import OOP.Laptop;
import OOP.SportsCar;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.time.*;

public class hello_world {

    public static void main(String[] args) {
        addToTime("second", 67);

        LocalDate now = LocalDate.now();
        System.out.println(now);
        System.out.println(now.getYear());
        System.out.println(now.getDayOfYear());

        LocalDate someBirthday = LocalDate.of(2021, Month.DECEMBER, 12);
        System.out.println(someBirthday);

        getNumberOfDays(someBirthday);

        LocalDateTime localDateTimeNow = LocalDateTime.now();
        System.out.println(localDateTimeNow);

        Instant instant = Instant.ofEpochMilli(4);
        LocalDateTime localDateTime = LocalDateTime.ofInstant(instant, ZoneId.of("CET"));
        System.out.println(localDateTime);

        System.out.println(Duration.ofHours(2).toMinutes());
        System.out.println(Period.between(LocalDate.now(), LocalDate.now().plusDays(30)).getMonths());

        LocalDate localDateForm = LocalDate.now();
//        String formattedLocalDate = localDateForm.format(DateTimeFormatter.ISO_WEEK_DATE);
        String formattedLocalDate = localDateForm.format(DateTimeFormatter.ofPattern("dd:MM:YY"));
        System.out.println(formattedLocalDate);

        int[] numbers = {67, 34, 65, 5, 4, 234, 43};

        bubbleSort(numbers);
        bubbleSortHighestToLowest(numbers);

//        insertionSort(numbers);
//        selectionSort(numbers);

        mergeSort(numbers, 0, numbers.length - 1);
        System.out.println(Arrays.toString(numbers));

        SportsCar sportsCar = new SportsCar();
        sportsCar.drive();

        Computer computer = new Computer("demo","1200", "120");
        Computer computer2 = new Computer("text","1600", "130");

        computer.configure();
        computer2.configure();

        Laptop laptop = new Laptop("core", "500", "200", 64);
        laptop.configure();
    }
    public static void getNumberOfDays(LocalDate localInputDate){

        localInputDate.isAfter(LocalDate.now());
        if(localInputDate.isAfter(LocalDate.now())) {
            System.out.println("This is " + Period.between(LocalDate.now(), localInputDate).getDays() + " away in the future");
        } else {
            System.out.println("This is " + Period.between(LocalDate.now(), localInputDate).getDays() + " in the past");
        }

    }

    public static void addToTime(String name, int num) {
        LocalTime localTime = LocalTime.now();

        switch (name) {
            case "hour":
                localTime = localTime.plusHours(num);
                break;
            case "minute":
                localTime = localTime.plusMinutes(num);
                break;
            case "second":
                localTime = localTime.plusSeconds(num);
                break;
            case "millisecond":
                localTime = localTime.plusNanos(num);
                break;
        }

        System.out.println(localTime);
    }

    static void bubbleSort(int[] nums){
        for(int i = 0; i < nums.length; i++){
            for(int j = 0; j < nums.length - 1; j++){
                if(nums[j] > nums[j + 1]){
                    int temp = nums[j];

                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                }
            }
        }

        System.out.println(Arrays.toString(nums));
    }

    static void bubbleSortHighestToLowest(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length - 1; j++) {
                if (nums[j] < nums[j + 1]) {
                    int temp = nums[j];

                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(nums));
    }

    static void insertionSort(int[] nums){
        for(int i = 1; i < nums.length; i++){
            int valueToSort = nums[i];
            int j;

            for(j = i; j > 0 && nums[j - 1] > valueToSort; j--){
                nums[j] = nums[j - 1];
            }

            nums[j] = valueToSort;
        }

        System.out.println(Arrays.toString(nums));
    }

    static void selectionSort(int[] nums){
        for(int i = 0; i < nums.length - 1; i++){
            int index = i;

            for(int j = i +1; j < nums.length; j++){
                if(nums[j] < nums[index]){
                    index = j;
                }
            }

            int smallerNumber = nums[index];
            nums[index] = nums[i];
            nums[i] = smallerNumber;
        }

        System.out.println(Arrays.toString(nums));
    }

    static  void mergeSort(int[] nums, int start, int end){
        int mid = (start + end) / 2;

        if(start < end) {
            mergeSort(nums, start, mid);
            mergeSort(nums, mid + 1, end);

            merge(start, mid, end, nums);
        }
    }

    private static void merge(int start, int mid, int end, int[] nums){
        int[] tempArray = new int[nums.length];
        int tempArrayIndex = start;

        int startIndex = start;
        int midIndex = mid + 1;

        while(startIndex <= mid && midIndex <= end){
            if (nums[startIndex] < nums[midIndex]) {
                tempArray[tempArrayIndex++] = nums[startIndex++];
            }else{
                tempArray[tempArrayIndex++] = nums[midIndex++];
            }
        }

        while(startIndex <= mid){
            tempArray[tempArrayIndex++] = nums[startIndex++];
        }

        while(midIndex <= end){
            tempArray[tempArrayIndex++] = nums[startIndex++];
        }

        if(end + 1 - start >= 0) {
            System.arraycopy(tempArray, start, nums, start, end + 1 - start);
        }
    }


}












