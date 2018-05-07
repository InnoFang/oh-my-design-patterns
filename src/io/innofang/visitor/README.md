# Visitor（访问者）

访问者模式是行为型设计模式的一种。访问者模式结构看起来要比其他的设计模式的结构要
复杂一些，但其实如果能找到一个合理的例子来解释这种模式的话，其实是非常好理解的。

在讲解之前先申明访问者模式的结构和定义。

![](https://raw.githubusercontent.com/InnoFang/DesignPatterns/master/uml/visitor.png)

 + Visitor :  接口或抽象类，内部定义了对每一个元素（Element）访问的性为，它的参数就是可以访问的元素，它的方法个数理论上来讲与元素个数是一样的，因此，访问者模式要求元素的类族要稳定，如果要频繁的修改 Visitor 接口，那么说明不适合使用访问者模式
 + ConcreteVisitor : 具体的访问者，需要给出对每个元素类访问时所产生的具体行为
 + Element : 元素接口或抽象类，定义了一个接收访问者（accept）的方法，意指每个元素都要能被访问者访问
 + ElementA, ElementB : 具体元素类，其具体的实现，通常情况下是使用访问者提供的访问该元素类的方法
 + ObjectStructure : 对象结构，是一个抽象表述，内部管理了元素集合，并且可以迭代这些元素供访问者访问

# 访问者模式的简单实现

如果只是简单的看类图及其描述的话，多半是要晕的。但是设计模式的灵感很多时候都来自于生活，那么我们来结合实际情况来阐述一下这个访问者模式

公司在招聘的时候，会根据申请人的不同进行不同的考量，比如应届生会更重视学分绩点或者专业基础，社招人员会更重视项目经验与实践能力。而申请者申请工作的时候都要投递简历，面试的时候又会有诸如小组组长，技术总监，hr等几轮面试，而且考察的点都不一样

这其实是一个很好的访问者模式的模型，我们把申请者比作元素（Element），访问者就是面试官，我们作为申请者需要将自己的简历给面试官看，这就是元素（Element）给访问者（Visitor）提供的 accept 方法，面试管再查看建立时则是通过自身的 visit 方法进行筛选，那么现在将申请者的简历收集起来就相当于一个人才市场，也就是我们的对象结构（ObjectStructure），它在内部持有申请者的简历，那么每一个来访问的面试官都可以用自身的 visit 方法，按照自己的标准来对每一份建立进行不同的考量，期望筛选出符合标准的申请者。

那么我们就用代码来实现以下这个案例吧

首先，自然是定义一个面试申请者（Applicant）和面试官（Interviewer）的接口

> 申请者接口

```java
/**
 * 面试申请者接口，只有一个抽象方法用来接受面试官的考核
 */
public interface Applicant {
    void accept(Interviewer visitor);
}
```


> 面试官接口

```java
/**
 * 面试官接口，分对象考核学生和工程师
 */
public interface Interviewer {

    void visit(Student student);
    void visit(Engineer engineer);

}
```


接下来就可以定义学生和工程师实体了，对于学生而言会有 GPA 和专业（major），而工程师的话则是工作经验和项目数量

> 学生实体类

```java
/**
 * 申请者：学生，具有姓名，gpa，专业属性，并实现 accept 方法，用于接收面试官审核
 */
public class Student implements Applicant {

    private String name;
    private double gpa;
    private String major;

    public Student(String name, double gpa, String major) {
        this.name = name;
        this.gpa = gpa;
        this.major = major;
    }

    @Override
    public void accept(Interviewer visitor) {
        visitor.visit(this);
    }

    // getter and setter
}
```

> 工程师实体

```java

/**
 * 申请者：工程师，具有姓名，工作经验，项目数量，并实现 accept 方法，用于接收面试官审核
 */
public class Engineer implements Applicant {

    private String name;
    private int workExperience;
    private int projectNumber;

    public Engineer(String name, int workExperience, int projectNumber) {
        this.name = name;
        this.workExperience = workExperience;
        this.projectNumber = projectNumber;
    }

    @Override
    public void accept(Interviewer visitor) {
        visitor.visit(this);
    }

    // getter and setter
}
```

可以看到，accept 方法基本都是接收一个访问者然后调用它自身的 visit 方法，因为具体怎么“访问”是由访问者自身决定的

那么面试官我们也定义 Leader 和 HR 两种，他们在考核的时候也是要对学生和工程师进行不同的考量，比如对于 Leader 而言，考量学生时他想考察的是 GPA，而对工程师的话则是项目数量，对于 HR 而言，考察学生时考察的是专业，而工程师则是工作经验。当然这里只是举个例子。

> Leader

```java

/**
 * 对于 Leader 而言，考量学生时他想考察的是 GPA，而对工程师的话则是项目数量
 */
public class Leader implements Interviewer {
    @Override
    public void visit(Student student) {
        System.out.println("Student  " + student.getName() + "'s gpa is " + student.getGpa());
    }

    @Override
    public void visit(Engineer engineer) {
        System.out.println("Engineer  " + engineer.getName() + "'s number of projects is " + engineer.getProjectNumber());
    }
}

```

> HR

```java
/**
 * 对于 HR 而言，考察学生时考察的是专业，而工程师则是工作经验
 */
public class Hr implements Interviewer {
    @Override
    public void visit(Student student) {
        System.out.println("Student  " + student.getName() + "'s major is " + student.getMajor());
    }

    @Override
    public void visit(Engineer engineer) {
        System.out.println("Engineer  " + engineer.getName() + "'s work experience is " + engineer.getWorkExperience() + " year");
    }
}
```

那么申请者们如何更好的让面试管审核自己呢？现在最普遍的就是往人才市场投简历，那么我们就模拟一个人才市场，内部维护一个申请者的列表，并实现一个可以接收面试官查看的方法

```java

/**
 * 人才市场
 */
public class LaborMarket {

    List<Applicant> applicants = new ArrayList<>();

    {
        applicants.add(new Student("Wang",  3.2, "Computer Science"));
        applicants.add(new Student("Lee",  3.4, "Network Engineer"));
        applicants.add(new Student("Chan",  3.4, "Computer Science"));
        applicants.add(new Engineer("Bob",  4, 15));
        applicants.add(new Engineer("Tony",  3, 10));
        applicants.add(new Engineer("Jim",  6, 20));
    }


    public void showApplicants(Interviewer visitor) {
        for (Applicant applicant : applicants) {
            applicant.accept(visitor);
        }
    }
}
```
这里只是简单的模拟了一下，而接受面试官去审核各个面试者的方法实现则是遍历每个申请者，调用他们的 accept 方法，其实这就**相当于是让面试官去看自己的简历**

那么，接下来来测试一下

```java
LaborMarket laborMarket = new LaborMarket();
System.out.println("===== Round 1: Leader =====");
laborMarket.showApplicants(new Leader());

System.out.println("===== Round 2: HR =====");
laborMarket.showApplicants(new Hr());
```

运行，输出结果如下

```
===== Round 1: Leader =====
Student  Wang's gpa is 3.2
Student  Lee's gpa is 3.4
Student  Chan's gpa is 3.4
Engineer  Bob's number of projects is 15
Engineer  Tony's number of projects is 10
Engineer  Jim's number of projects is 20
===== Round 2: HR =====
Student  Wang's major is Computer Science
Student  Lee's major is Network Engineer
Student  Chan's major is Computer Science
Engineer  Bob's work experience is 4 year
Engineer  Tony's work experience is 3 year
Engineer  Jim's work experience is 6 year
```

其实逻辑并不复杂，而访问者模式也让我们能够将面试官分别考量不同的申请者的逻辑变得更加的清晰，可以看到我们并没有写一行 if 语句去判断申请者和面试官，这样做的好处就是这个功能能够更好的扩展和维护，结构更加清晰并且灵活性也很高

# 总结

正如我前面说的，访问者模式的有点很明显，但是我们仍然要考虑一个问题，如果我的功能真的很简单，或许真的就是一行 if 语句就能解决，那么这个模式还有使用的必要吗？
如果你有这样的疑问，那么我觉得就没有必要这样用，不要为了使用设计模式而使用设计模式，这样只会让简单的问题复杂化，只有当你真正需要它的时候，你才能体会到访问者模式的价值

那么，再次总结下访问者模式的优缺点

优点：

 + 符合单一职责原则，每个角色的职责能够明确的分开
 + 可扩展性强
 + 可维护
 + 更加灵活

缺点：

 + 有关具体元素时修改成本大
 + 对访问者显示了具体元素的细节，不符合迪米特原则
 + 为了能够做到访问者“区别对待”具体元素，没有依赖抽象类，而是使用了具体元素类，不符合依赖倒置原则

END
