
import java.util.LinkedList;
import java.util.Queue;
import java.util.HashMap;
import java.util.Map;

public class ClinicQueue {

    private static Queue<Patient> waitingQueue = new LinkedList<>();
    private static Map<String, Patient> allPatients = new HashMap<>();
    
public static int getRegisteredCount() {
    return allPatients.size();
}

public static int getWaitingCount() {
    return waitingQueue.size();
}
public static boolean registerPatient(Patient patient) {

        if (allPatients.containsKey(patient.getId())) {
            return false;
        }

        allPatients.put(patient.getId(), patient);
        waitingQueue.add(patient);

        return true;
    }

public static Patient callNextPatient() {
        return waitingQueue.poll();
    }

public static Queue<Patient> getWaitingPatients() {
        return new LinkedList<>(waitingQueue);
    }

public static Patient searchPatient(String id) {
        return allPatients.get(id);
    }
}

