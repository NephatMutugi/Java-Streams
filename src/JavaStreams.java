import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * @ Author NMuchiri
 **/
public class JavaStreams {
    // In this class, we'll learn more about functional programming and JAVA 8 Streams

    public static void main(String[] args) {

        List<Person> people = getPeople();

        // Iterative approach
        // returns all females
        iterativeApproach(people);

        System.out.println("\n\n");
        // declarative/ streams approach
        // returns all males
        declarativeApproach(people);
    }


    private static List<Person> getPeople(){
        return
                List.of(
                        new Person("James Bond", 23, Gender.MALE),
                        new Person("Caterina Rostov", 34, Gender.FEMALE),
                        new Person("Hellen Jepkosgei", 22, Gender.FEMALE),
                        new Person("Ross White", 24, Gender.MALE),
                        new Person("Vladmir Smith", 24, Gender.MALE),
                        new Person("Jane Doe", 23, Gender.FEMALE)

                );
    }
    private static void iterativeApproach(List<Person> people){
        // Iterating using the old imperative approach
        List<Person> females = new ArrayList<>();

        for (Person person : people){
            if (person.getGender().equals(Gender.FEMALE)){
                females.add(person);
            }
        }

        females.forEach(System.out::println);
    }

    private static void declarativeApproach(List<Person> people){

        // Filter
        List<Person> males = people.stream()
                .filter(person -> person.getGender().equals(Gender.MALE)).toList();

        // Sort
        List<Person> orderedList = people.stream().sorted(Comparator.comparing(Person::getAge)).toList();
        orderedList.forEach(System.out::println);


        //males.forEach(System.out::println);
    }
}
