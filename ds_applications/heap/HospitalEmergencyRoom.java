import java.util.PriorityQueue;

//encapsulation used as here we are bundling data and methods together while restricting direct access to some details by HospitalEmergencyRoom class
class Patient {
  String name;
  int severity;

  public Patient(String name, int severity) {
    this.name = name;
    this.severity = severity;
  }
}

class HospitalEmergencyRoom {
  public static void main(String[] args) {
    PriorityQueue<Patient> pq = new PriorityQueue<>((p1, p2) -> p1.severity - p2.severity);

    pq.add(new Patient("alice", 5));// broken leg patient
    pq.add(new Patient("bob", 10));// mild fever
    pq.add(new Patient("charlie", 1));// heart attack
    pq.add(new Patient("levisss", 15));// eye checkup

    System.out.println("patients treated in order of severity :");
    while (!pq.isEmpty()) {
      Patient p = pq.poll();
      System.out.println("Treating :" + p.name + "(Severity:" + p.severity + ")");
    }
  }
}

// oops usage here:
// Abstraction :- in pq we are hiding internal details how its adding in heap as
// we are using it by java collection framework
//inheritance:priorityqueue from abstract queue
//polymorphism:instead of custom sorting in pq we used lambda function which overrides default sorting behaviour (p1, p2) -> p1.severity - p2.severity)