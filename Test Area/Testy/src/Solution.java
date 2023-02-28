
// you can also use imports, for example:
// import java.util.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Solution {

    private static final String DEPARTMENT = "Consumer Lending";

    public static void main(String[] args) {
        List<Applicant> applicants = Arrays.asList(generateApplicants());
        List<Employee> employees = new ArrayList<>();


        // 1 for loop
        // hatdog.forEach((wew) -> System.out.println(wew));        

        Stream<Applicant> hatdog = Arrays.stream(generateApplicants());
        hatdog.forEach(applicant -> {
            if(applicant.getSkill().contains("Java")) {
                Employee prospect = new Employee(applicant.getName(), DEPARTMENT, applicant.getSkill(), applicant.getSalary());
                if(!employees.contains(prospect)) {
                    employees.add(prospect);
                }
            }
        });

        // for(Applicant applicant:applicants) {
        //     if(applicant.getSkill().contains("Java")) {
        //         Employee prospect = new Employee(applicant.getName(), DEPARTMENT, applicant.getSkill(), applicant.getSalary());
        //         if(!employees.contains(prospect)) {
        //             employees.add(prospect);
        //         }
        //     }
        // }

        for (int x=0; x<employees.size(); x++){
            System.out.println(employees.get(x).getName());
            System.out.println(employees.get(x).getDepartment());
            System.out.println(employees.get(x).getSalary());
            System.out.println(employees.get(x).getSkill());
        }

        // 2 rework loop above
    }

    private static Applicant[] generateApplicants() {
        return new Applicant[]{new Applicant("Ben", "Java", 60000f),
                new Applicant("Jarrell",  "Golang", 55000f),
                new Applicant("Jam",  "Java,Golang", 70000f),
                new Applicant("Daryl",  "PHP", 65000f),
                new Applicant("Kate",  "Java,Golang", 80000f),
                new Applicant("Kate",  "Java,Python", 80000f),
                new Applicant("John",  "Python", 55000f)};
    }

    static class Employee {
        private String name;
        private String department;
        private String skill;
        private float salary;

        public Employee(String name, String department, String skill, float salary) {
            this.name = name;
            this.department = department;
            this.skill = skill;
            this.salary = salary;
        }

        public String getName() {
            return name;
        }
        
        public void setName(String name) {
            this.name = name;
        }

        public String getDepartment() {
            return department;
        }

        public void setDepartment(String department) {
            this.department = department;
        }

        public String getSkill() {
            return skill;
        }

        public void setSkill(String skill) {
            this.skill = skill;
        }

        public float getSalary() {
            return salary;
        }

        public void setSalary(float salary) {
            this.salary = salary;
        }
    }

    static class Applicant {
        private String name;
        private String skill;
        private float salary;

        public Applicant(String name,String skill, float salary) {
            this.name = name;
            this.skill = skill;
            this.salary = salary;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getSkill() {
            return skill;
        }

        public void setSkill(String skill) {
            this.skill = skill;
        }

        public float getSalary() {
            return salary;
        }

        public void setSalary(float salary) {
            this.salary = salary;
        }
    }
}