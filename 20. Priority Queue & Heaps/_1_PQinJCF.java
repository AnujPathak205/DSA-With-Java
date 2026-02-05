import java.util.PriorityQueue;

class Student implements Comparable<Student>{
    String name;
    int rank;

    public Student(String name, int rank) {
        this.name = name;
        this.rank = rank;
    }

    @Override
    public int compareTo(Student s2) {
        return Integer.compare(this.rank, s2.rank);
    }
}

class Player{
    String name;
    int rank;

    public Player(String name, int rank) {
        this.name = name;
        this.rank = rank;
    }
}

public class _1_PQinJCF {
    public static void main(String[] args) {
        // PriorityQueue<Integer> pq = new PriorityQueue<>((o1,o2)-> o2-o1);
        // pq.add(2);
        // pq.add(6);
        // pq.add(4);
        // pq.add(1);
        // pq.add(3);
        // pq.add(1);

        // System.out.println(pq);
        // System.out.println(pq.remove());
        // System.out.println(pq.remove());
        // System.out.println(pq.remove());
        // System.out.println(pq.remove());

        PriorityQueue<Student> pq = new PriorityQueue<>();
        pq.add(new Student("Anuj", 5));
        pq.add(new Student("Amit", 2));
        pq.add(new Student("Aman", 3));
        pq.add(new Student("Abhishek", 1));
        pq.add(new Student("Ankit", 4));

        while(!pq.isEmpty()){
            System.out.println(pq.peek().name+" -> "+pq.remove().rank);
        }

        System.out.println("-------------------------------");

        PriorityQueue<Player> pq2 = new PriorityQueue<>((p1,p2) -> p1.rank - p2.rank);
        pq2.add(new Player("Abhi", 3));
        pq2.add(new Player("Anuj", 1));
        pq2.add(new Player("Amit", 2));

        while(!pq2.isEmpty()){
            System.out.println(pq2.peek().name+" -> "+pq2.remove().rank);
        }


    }
}
