package Action.FifthTask;

import javax.swing.*;
import java.util.*;
import java.util.stream.Collectors;

public class StreamMethods {
    JTextArea outputTextArea;

    public double averageValue(List<Integer> numbers) {
        return numbers.stream()
                .mapToDouble(Integer::doubleValue)
                .average()
                .orElse(0.0);
    }
    public List<String> upperCaseAndPrefix(List<String> strings) {
        return strings.stream()
                .map(s -> "_new_" + s.toUpperCase())
                .collect(Collectors.toList());
    }
    public List<Integer> listSquares(List<Integer> numbers) {
        return numbers.stream()
                .filter(num -> Collections.frequency(numbers, num) == 1)
                .map(num -> num * num)
                .collect(Collectors.toList());
    }
    public List<String> sortAlphabetically(List<String> strings, char newChar) {
        return strings.stream()
                .filter(s -> s.startsWith(String.valueOf(newChar)))
                .sorted()
                .collect(Collectors.toList());
    }
    public <T> T lastElem(Collection<T> collection) {
        return collection.stream()
                .reduce((first, second) -> second)
                .orElseThrow(NoSuchElementException::new);
    }
    public int sumEvenNumbers(int[] numbers) {
        return Arrays.stream(numbers)
                .filter(num -> num % 2 == 0)
                .sum();
    }
    public Map<Character, String> conversionMap(List<String> strings) {
        return strings.stream()
                .collect(Collectors.toMap(
                        s -> s.charAt(0),
                        s -> s.substring(1),
                        (existing, replacement) -> existing + ", " + replacement
                ));
    }
    public void start() {

        List<Integer> numbers = Arrays.asList(1, 6, 3, 8, 4);
        this.outputTextArea.append("среднее значение списка целых чисел:" + averageValue(numbers) + "\n");

        List<String> strings = Arrays.asList("task", "user", "item");
        this.outputTextArea.append("строки в верхнем регистре с префиксом «_new_»: " + upperCaseAndPrefix(strings) + "\n");

        List<Integer> numbers2 = Arrays.asList(12, 5, 43, 3, 4, 4, 6);
        this.outputTextArea.append("список квадратов всех встречающихся только один раз элементов списка: " + listSquares(numbers2) + "\n");

        List<String> strings2 = Arrays.asList("field", "12", "passed", "array", "double", "adobe");
        this.outputTextArea.append("строки, начинающиеся с заданной буквы, отсортированные по алфавиту: " + sortAlphabetically(strings2, 'a') + "\n");

        List<String> strings3 = Arrays.asList("name", "lastname", "country");;
        try {
            this.outputTextArea.append("последний элемент : " + lastElem(strings3) + "\n");
        } catch (NoSuchElementException e) {
            this.outputTextArea.append(" колекция пуста\n");
        }

        int[] numbers3 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        this.outputTextArea.append("сумму чётных чисел: " + sumEvenNumbers(numbers3) + "\n");

        List<String> stringsToMap = Arrays.asList("1Lev", "2Sup", "3&&&&");
        this.outputTextArea.append("Map, где первый символ – ключ, оставшиеся – значение;: " + conversionMap(stringsToMap) + "\n");
    }

    public void setOutputTextArea(JTextArea outputTextArea){
        this.outputTextArea = outputTextArea;
    }
}
